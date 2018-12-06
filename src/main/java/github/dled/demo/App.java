package github.dled.demo;

import io.vlingo.common.Completes;
import io.vlingo.actors.Definition;
import io.vlingo.actors.World;

import java.util.concurrent.atomic.AtomicLong;

public class App {

    public static void main(String[] args) {
        // final World world = World.startWithDefaults("playground");
        final World world = World.start("playground");
        try {
            thingDemo(world);
            benchmarkAndDemo(world);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            world.terminate();
        }
    }

    public static void thingDemo(World world) {
        final Thingy thing = world
            .actorFor(
                Definition.has(Thing.class, Definition.NoParameters),
                Thingy.class
        );

        thing.jump();
        System.out.println("we continue...");
        thing.howDoYouFeel().andThenConsume(reply -> {
            System.out.println("it replied: "+reply);
        });
        System.out.println("the thing will answer shortly");
    }

    public static void benchmarkAndDemo(World world) throws InterruptedException {
        final long N = 100_000_000;

        final Greeter greeter = world.actorFor(Definition.has(ConsoleGreeter.class, Definition.NoParameters), Greeter.class);

        greeter.greet(System.getProperty("user.name"));

        greeter.startBenchmark();

        for (long i = 0; i < N; i++)
            greeter.tick();

        greeter.reportProgress();

        //for comparison, pure increment:
        java.util.concurrent.atomic.AtomicLong count=new AtomicLong();
        final Stopwatch sw = new Stopwatch();
        for (long i = 0; i < N; i++)
            count.getAndIncrement();
        sw.dumpElapsedForCount(count.get(),"simple increment");

        Completes<Integer> answer = greeter.answer();

//            answer.andThen((value) -> System.out.println("The answer is ... "+value));

        for (int i = 0; i < 10 || !answer.hasOutcome(); i++) {
            Thread.sleep(100);
            System.out.println("waiting for an answer...");
        }

        if (!answer.hasOutcome()) {
            System.out.println("got no answer...");
        } else {
            System.out.println("The answer is ... "+answer.outcome());
        }

    }
}

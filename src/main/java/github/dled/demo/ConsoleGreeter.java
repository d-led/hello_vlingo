package github.dled.demo;

import io.vlingo.actors.Actor;
import io.vlingo.common.Completes;

public class ConsoleGreeter extends Actor implements Greeter {
    final Completes<Integer> completes = Completes.withSuccess(0);
    Stopwatch sw;
    long count = 0;

    // Actor behavior
    @Override
    public void greet(String who) {
        System.out.println("Hello, "+ who);
    }

    @Override
    public void startBenchmark() {
        sw = new Stopwatch();
    }

    @Override
    public void tick() {
        count++;
    }

    @Override
    public void reportProgress() {
        sw.dumpElapsedForCount(count, "ConsoleGreeter increment");
    }

    @Override
    public Completes<Integer> answer() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return completes().with(42);
    }

    // lifetime observation hooks
    @Override
    protected void beforeStart() {
        System.out.println("Starting ConsoleGreeter");
        super.afterStop();
    }

    @Override
    protected void afterStop() {
        System.out.println("ConsoleGreeter stopped");
        super.afterStop();
    }
}

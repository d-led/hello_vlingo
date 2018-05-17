package github.dled.demo;

import io.vlingo.actors.Actor;

public class ConsoleGreeter extends Actor implements Greeter {
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

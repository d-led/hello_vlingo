package github.dled.demo;

import io.vlingo.actors.Actor;

public class ConsoleGreeter extends Actor implements Greeter {
    // Actor behavior
    @Override
    public void greet(String who) {
        System.out.println("Hello, "+ who);
    }

    // Set up boilerplate
    private final Greeter self;
    public ConsoleGreeter() {
        self = selfAs(Greeter.class);
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

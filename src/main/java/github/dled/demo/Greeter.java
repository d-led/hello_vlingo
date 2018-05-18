package github.dled.demo;

import io.vlingo.actors.Stoppable;

public interface Greeter extends Stoppable {
    void greet(String who);
    void startBenchmark();
    void tick();
    void reportProgress();
}
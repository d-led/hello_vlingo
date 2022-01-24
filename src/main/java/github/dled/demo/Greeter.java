package github.dled.demo;

import io.vlingo.xoom.common.Completes;
import io.vlingo.xoom.actors.Stoppable;

public interface Greeter extends Stoppable {
    void greet(String who);
    void startBenchmark();
    void tick();
    void reportProgress();
    Completes<Integer> answer();
}

package github.dled.demo;

import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.common.Completes;
import io.vlingo.xoom.common.Scheduled;

public class Thing extends Actor implements Thingy, Scheduled {
    @Override
    public void jump() {
        System.out.println("preparing to jump ...");
        this.scheduler().scheduleOnce(this, null, 0L, 1L);
    }

    @Override
    public Completes<String> howDoYouFeel() {
        return completes().with("everything's fine");
    }

    @Override
    public void intervalSignal(final Scheduled scheduled, final Object data) {
        System.out.println("jumping now ...");
    }
}

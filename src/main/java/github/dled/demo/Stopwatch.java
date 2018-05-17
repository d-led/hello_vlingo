package github.dled.demo;

import static humanize.Humanize.times;

public class Stopwatch {
    final long startMillis;

    public Stopwatch() {
        startMillis = System.currentTimeMillis();
    }

    public long elapsedMillis() {
        return System.currentTimeMillis() - startMillis;
    }

    public void dumpElapsedForCount(long count, String title) {
        final long milli = elapsedMillis();
        final double millisPerSec = 1000.0;
        final double seconds = milli/millisPerSec;
        final Double reqPerSec = (count/milli)*millisPerSec;
        System.out.println(times(count)+" "+title+": "+seconds+ "s ("+times(reqPerSec)+"/s)");
    }
}

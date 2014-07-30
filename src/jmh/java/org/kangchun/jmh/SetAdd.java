package org.kangchun.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by kangchun on 2014-07-31.
 */
@State(Scope.Thread)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
public class SetAdd {
    final int LOOP_COUNT=1000;
    final String data = "abcdefghigjklmnopqrstuvwxyz";
    Set<String> set;

    @Benchmark
    public void addHashSet() {
        set = new HashSet<String>();
        for(int loop=0; loop<LOOP_COUNT; loop++) {
            set.add(data);
        }
    }

    @Benchmark
    public void addTreeSet() {
        set = new TreeSet<String>();
        for(int loop=0; loop<LOOP_COUNT; loop++) {
            set.add(data);
        }
    }

    @Benchmark
    public void addLinkedHashSet() {
        set = new LinkedHashSet<String>();
        for(int loop=0; loop<LOOP_COUNT; loop++) {
            set.add(data);
        }
    }

}

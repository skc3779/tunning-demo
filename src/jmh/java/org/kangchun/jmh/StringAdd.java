package org.kangchun.jmh;

import org.openjdk.jmh.annotations.*;

/**
 * Created by kangchun on 2014-07-30.
 */
@State(Scope.Thread)
//@BenchmarkMode({Mode.AverageTime})
public class StringAdd {

    final String aValue = "abcde";
    String a;
    StringBuffer b;
    StringBuilder c;

    @Setup(Level.Trial)
    public void setUp() {
        a = new String();
        b = new StringBuffer();
        c = new StringBuilder();
    }

//    @Benchmark
//    public void addString() {
//        for(int loop=0; loop<10000; loop++) {
//            a+=aValue;
//        }
//    }

    @Benchmark
    public void addStringBuffer() {
        for(int loop=0; loop<10000; loop++) {
            b.append(aValue);
        }

    }

    @Benchmark
    public void addStringBuilder() {
        for(int loop=0; loop<10000; loop++) {
            c.append(aValue);
        }
    }
}

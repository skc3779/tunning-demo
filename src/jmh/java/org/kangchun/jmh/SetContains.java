package org.kangchun.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by seokangchun on 2014. 7. 31..
 */
@State(Scope.Thread)
public class SetContains {

    final int LOOP_COUNT = 1000;
    Set<String> hashSet;
    Set<String> treeSet;
    Set<String> linkedHashSet;


    final String data = "abcdefghigjklmnopqrstuvwxyz";

    String []keys;

    @Setup(Level.Trial)
    public void setUp() {
        hashSet = new HashSet<String>();
        treeSet = new TreeSet<String>();

        for(int loop=0; loop<LOOP_COUNT; loop++) {
            String tempData = data+loop;

            hashSet.add(tempData);
            treeSet.add(tempData);
        }

        if(keys == null || keys.length != LOOP_COUNT) {
            keys = RandomKeyUtil.generateReandomSetKeySwap(hashSet);
        }
    }

    @Benchmark
    public void containsHashSet() {
        for(String key : keys) {
            hashSet.contains(key);
        }
    }

    @Benchmark
    public void containsTreeSet() {
        for(String key : keys) {
            treeSet.contains(key);
        }
    }

}

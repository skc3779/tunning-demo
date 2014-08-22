package org.kangchun.nio;

/**
 * Created by kangchun on 2014-08-12.
 */
public class WatcherMain {
    public static void main(String[] arg) {
        WatcherThread thread = new WatcherThread("c:/temp");
        thread.start();
    }
}

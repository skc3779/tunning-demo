package org.kangchun.nio;

import java.nio.file.*;
import java.util.Date;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by kangchun on 2014-08-12.
 */
public class WatcherThread extends Thread {

    String dirName;

    public WatcherThread(String dirName ) {
        this.dirName = dirName;
    }

    public void run() {
        System.out.println("Watcher is started");
        fileWatcher();
        System.out.println("Watcher is ended");
    }

    public void fileWatcher() {
        try {
            Path dir = Paths.get(dirName);
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            WatchKey key;
            for(int loop=0; loop<4; loop++) {

                key = watcher.take();

                String watchedTime = new Date().toString();
                List<WatchEvent<?>> eventList = key.pollEvents();

                for(WatchEvent<?> event : eventList) {
                    Path name= (Path) event.context();

                    if(event.kind() == ENTRY_CREATE) {
                        System.out.format("%s created at %s%n", name, watchedTime);
                    } else if(event.kind() == ENTRY_DELETE) {
                        System.out.format("%s delete at %s%n", name, watchedTime);

                    } else if(event.kind() == ENTRY_MODIFY) {
                        System.out.format("%s modify at %s%n", name, watchedTime);
                    }
                }

                key.reset();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

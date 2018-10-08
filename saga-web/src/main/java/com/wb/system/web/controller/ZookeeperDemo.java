package com.wb.system.web.controller;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperDemo implements Watcher {

    private static CountDownLatch count = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.199.216:2181,192.168.199.216:2182,192.168.199.216:2183", 6000, new ZookeeperDemo());
        System.out.println(zooKeeper.getState());
        count.await();
        System.out.println("zookeeper session established");
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println("watchedEvent:" + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            count.countDown();
        }
    }
}

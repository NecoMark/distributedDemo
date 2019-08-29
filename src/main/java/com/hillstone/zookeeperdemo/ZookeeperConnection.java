package com.hillstone.zookeeperdemo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: ljyang
 * @date: 2019/8/28 10:58
 * @description
 */
public class ZookeeperConnection {
    private ZooKeeper zooKeeper;
    CountDownLatch connectSignal = new CountDownLatch(1);

    public ZooKeeper connect(String host) throws IOException {
        zooKeeper = new ZooKeeper(host, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    connectSignal.countDown();
                }
            }
        });
        try {
            connectSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}

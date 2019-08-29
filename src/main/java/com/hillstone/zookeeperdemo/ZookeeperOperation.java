package com.hillstone.zookeeperdemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author: ljyang
 * @date: 2019/8/28 11:09
 * @description
 */
public class ZookeeperOperation {
    private ZooKeeper zooKeeper;

    public ZookeeperOperation(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public void createPath(String path, String data) throws KeeperException, InterruptedException {
        zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public Stat pathExists(String path) throws KeeperException, InterruptedException {
        Stat stat = null;
        stat = zooKeeper.exists(path, true);
        return stat;
    }

    public String getData(String path) throws KeeperException, InterruptedException {
        Stat stat = this.pathExists(path);
        if (stat != null){
            zooKeeper.getData(path, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getType() == Event.EventType.None){

                    }
                }
            }, null);
        }
        return "";
    }




}

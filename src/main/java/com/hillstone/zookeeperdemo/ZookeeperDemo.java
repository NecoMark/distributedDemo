package com.hillstone.zookeeperdemo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ljyang
 * @date: 2019/8/28 9:36
 * @description
 */
public class ZookeeperDemo {
    public static void main(String[] args) throws Exception{
        String hostPort = "10.180.15.68:2181";
        String zPath = "/";
        List<String> zooChildren = new ArrayList<>();
        //构造ZooKeeper的实例
        ZooKeeper zooKeeper = new ZooKeeper(hostPort, 2000, null);
        try {
            //获取节点下的内容
            zooChildren = zooKeeper.getChildren(zPath,false);
            System.out.println("Znodes of /:");
            for (String zooChild : zooChildren) {
                System.out.println(zooChild);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}

class WatcherDemo implements Watcher{

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}

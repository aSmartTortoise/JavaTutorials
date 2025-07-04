package com.wyj.java.thread;

/**
 *  参考文章
 *  https://javabetter.cn/thread/aqs.html#aqs-%E7%9A%84-node-%E8%8A%82%E7%82%B9
 */
public class CLHLock {

    private volatile Node tail ;
    private ThreadLocal<Node> myNode = ThreadLocal.withInitial(Node::new);
    private ThreadLocal<Node> myPred = new ThreadLocal<>() ;

    public void lock() {
        Node node = myNode.get() ;
        node.locked = true ;
        // 把自己放到队尾，并取出前面的节点
        Node pred = tail;
        myPred.set(pred);
        while (pred.locked) {
            // 自旋等待
        }
    }

    public void unlock() {
        Node node = myNode.get() ;
        node.locked = false ;
        myNode.set(myPred.get());
    }


    private static class Node {
        private volatile boolean locked ;
    }
}

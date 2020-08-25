package com.xuyang.leetcode.multithread;

import java.util.concurrent.Semaphore;

/**
 * @author Li Xuyang
 * @date 2020/8/25 10:58
 * 哲学家进餐
 */
public class DiningPhilosophers {
    /*
    5 个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5 个哲学家，5 根叉子）

所有的哲学家都只会在思考和进餐两种行为间交替。哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。

假设面的数量没有限制，哲学家也能随便吃，不需要考虑吃不吃得下。

设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。


哲学家从0 到 4 按 顺时针 编号。请实现函数void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)：

philosopher哲学家的编号。
pickLeftFork和pickRightFork表示拿起左边或右边的叉子。
eat表示吃面。
putLeftFork和putRightFork表示放下左边或右边的叉子。
由于哲学家不是在吃面就是在想着啥时候吃面，所以思考这个方法没有对应的回调。
给你 5 个线程，每个都代表一个哲学家，请你使用类的同一个对象来模拟这个过程。在最后一次调用结束之前，可能会为同一个哲学家多次调用该函数。

     */
    //一个互斥信号量用于临界资源的互斥访问
    private Semaphore mutex;
    //5个信号量用于哲学家之间的同步访问
    private Semaphore[] sema;

    public DiningPhilosophers() {
        mutex = new Semaphore(1);
        sema = new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)
        };
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //一个哲学家如果拿起叉子就同时拿两个，因此这里是一个原子操作，需要用mutex信号量包起来，表示互斥
        mutex.acquire();
        //尝试获取左手边的叉子
        sema[philosopher].acquire();
        //尝试获取右手边的叉子
        sema[(philosopher + 1) % 5].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        //拿到叉子开始吃饭
        eat.run();

        //吃完饭放下叉子
        putLeftFork.run();
        sema[philosopher].release();
        putRightFork.run();
        sema[(philosopher+1)%5].release();
        mutex.release();
    }
}

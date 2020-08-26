package com.xuyang.leetcode.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Li Xuyang
 * @date 2020/8/26 11:00
 * 交替打印FooBar
 */
public class FooBar {
    //两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
    //
    //请设计修改程序，以确保 "foobar" 被输出 n 次。

    //本题可以将printFoo方法和printBar看成具有先后顺序的一组执行方法。
    //使用CountDownLatch来保证组内任务的执行先后顺序，使用CyclicBarrier保证任务按组进行。
    //
    private int n;
    private CountDownLatch a;
    private CyclicBarrier barrier; //使用CyclicBarrier保证任务按组执行

    public FooBar(int n) {
        this.n = n;
        a = new CountDownLatch(1);
        barrier = new CyclicBarrier(2);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                a.countDown();// printFoo方法完成调用countDown
                barrier.await();// 等待printBar方法执行完成
            }
        }catch (Exception e){}

    }

    public void bar(Runnable printBar) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                a.await();// 等待printFoo方法先执行
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                a = new CountDownLatch(1);
                barrier.await();
            }
        }catch (Exception e){}
    }
}

package com.xuyang.leetcode.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Li Xuyang
 * @date 2020/8/25 10:43
 * 按序打印
 */
public class Foo {
    /*
    我们提供了一个类：

public class Foo {
 public void first() { print("first"); }
 public void second() { print("second"); }
 public void third() { print("third"); }
}
三个不同的线程将会共用一个 Foo 实例。

线程 A 将会调用 first() 方法
线程 B 将会调用second() 方法
线程 C 将会调用 third() 方法
请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

     */
    /*
    首先初始化共享变量 firstJobDone 和 secondJobDone，初始值表示所有方法未执行。

方法 first() 没有依赖关系，可以直接执行。在方法最后更新变量 firstJobDone 表示该方法执行完成。

方法 second() 中，检查 firstJobDone 的状态。如果未更新则进入等待状态，否则执行方法 second()。在方法末尾，更新变量 secondJobDone 表示方法 second() 执行完成。

方法 third() 中，检查 secondJobDone 的状态。与方法 second() 类似，执行 third() 之前，需要先等待 secondJobDone 的状态。
     */
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.

        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // mark the second as done, by increasing its count.

        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

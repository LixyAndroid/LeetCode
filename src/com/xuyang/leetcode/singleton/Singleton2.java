package com.xuyang.leetcode.singleton;

/**
 * @author Li Xuyang
 * @date 2020/8/11 20:48
 */
public class Singleton2 {
    private volatile static Singleton2 instance;

    //私有方法，不能外部访问
    private Singleton2() {

    }

    //单例,双重锁，线程安全
    public static Singleton2 getInstance() {

        if (instance == null) {
            //对象锁,synchronized是java中用于同步的关键字,类锁
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}

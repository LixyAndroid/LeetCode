package com.xuyang.leetcode.singleton;

/**
 * @author Li Xuyang
 * @date 2020/8/11 20:39
 */
public class Singleton {
    //2,本类内部创建对象实例,外部不能访问
    private static Singleton instance = null;

    /**
     * 1,构造方法私有化，外部不能new
     */
    private Singleton() {

    }

    //3，提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


}

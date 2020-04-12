package com.xuyang.leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Li Xuyang
 * @date 2020/4/12 15:11
 * 数据流中的中位数
 */
public class GetMedian62 {

    /*
    如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
    那么中位数就是所有数值排序之后位于中间的数值。
    如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */


    /*
    思路：
        首先按照我们的尝试，中位数奇数正好前后对半，取出来即可。偶数呢，前后难以对半，只能折中，取靠近中间的两个数之和求均值。

    没错，这一题也是如此。但是如何动态的求均值呢。如何在任意时刻都能够直接拿到我们想要的均值而不去计算下标取值呢？百思不得其解。

    参考他人的想法，使用优先队列PriorityQueue，然后问题就变得很简单了。

    这一题主要的思想是利用优先队列，优先队列分为大顶堆和小顶堆，默认维护的是小顶堆的优先队列。

    思路：

    需要求的是中位数，如果我将 1 2 3 4 5 6 7 8定为最终的数据流
    此时的中位数是4+5求均值。为什么是4，为什么是5
    利用队列我们就可以看得很清楚，4是前半部分最大的值，肯定是维系在大顶堆
    而5是后半部分的最小值，肯定是维系在小顶堆。
    问题就好理解了：
    使用小顶堆存大数据，使用大顶堆存小数据。这样堆顶一取出就是中位数了。

    代码如下：代码中奇数时刻大顶堆存值，所以遇到奇数时刻，大顶堆直接弹出就是中位数
     */

    private int cnt = 0;
    private PriorityQueue<Integer> low = new PriorityQueue<>();
    //默认维护小顶堆
    private PriorityQueue<Integer> high = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer t1, Integer t2) {
            return t2.compareTo(t1);
        }
    });

    public void insert(Integer num) {
    //数量++
        cnt++;
        //如果为奇数的话
        if ((cnt&1)==1){
            //由于奇数，需要存放在大顶堆上
            //但是呢，现在你不知道num与小顶堆的情况
            //小顶堆放的是后半段大的树
            //如果当前值比小顶堆上堆那个数更大
            if (!low.isEmpty()&&num>low.peek()){
                //存进去
                low.offer(num);
                //然后在将那个最小的吐出来
                num = low.poll();
            }
            //最小的就放大顶堆，因为它存放前半段
            high.offer(num);

        }else {
            //偶数的话，此时需要存放的是小的数
            //注意无论是大顶堆还是小顶堆，吐出数的前提是得有数
            if (!high.isEmpty()&&num<high.peek()){
                high.offer(num);
                num = high.poll();
            }
            //大数被吐出，小顶堆插入
            low.offer(num);
        }
    }

    public Double getMedian() {
        double res = 0;
        if ((cnt&1)==1){
            res = high.peek();
        }else {
            res = (high.peek()+low.peek())/2.0;
        }
        return res;

    }
}

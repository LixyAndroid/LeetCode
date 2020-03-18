package com.xuyang.leetcode.alarmClock;

import java.util.*;

/**
 * @author Li Xuyang
 * @date 2020/3/14 18:56
 */
public class Main {

    /*
    由于上面创建了很多闹钟对象，比较费空间，所以我们可以将输入的时间全部转换成分钟，
    比如6时10分=6*60+10=370分，然后将输入的时间排序（快排时间复杂度为O（nlog2n），然后二分，思路和上面一样
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            list.add(scanner.nextInt() * 60 + scanner.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }
        );
        int X = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int AB = A * 60 + B; // 上课时间，转换成了分钟
        int t = AB - X; // 这就是标杆
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            //二分查找
            int m = (l + r) >> 1;
            if (t >= list.get(m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (r < 0){
            System.out.println(list.get(0) / 60 + " " + list.get(0) % 60);

        }
        else{
            System.out.println(list.get(r) / 60 + " " + list.get(r) % 60);

        }
        scanner.close();
    }


}

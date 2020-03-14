package com.xuyang.leetcode.userPreferences;

import java.util.*;

/**
 * @author Li Xuyang
 * @date 2020/3/14 15:56
 * 字节跳动笔试题，用户喜好
 */
public class Main {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int n = in.nextInt();
        Map<Integer, ArrayList<Integer>> prefer = new HashMap<>();

        for (int i = 1; i < n+1; i++) {

            int per = in.nextInt();

            if (prefer.containsKey(per)){

                ArrayList<Integer> list = prefer.get(per);
                list.add(i);

            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                prefer.put(per,list);
            }
        }

        int sel = in.nextInt();

        for (int i = 0; i < sel; i++) {
            int count =0;
            int start = in.nextInt();
            int stop = in.nextInt();
            int perK = in.nextInt();
            if (prefer.containsKey(perK)){
                ArrayList<Integer> integerArrayList = prefer.get(perK);
                Iterator<Integer> ltr =  integerArrayList.iterator();

                while (ltr.hasNext()){

                    int num = ltr.next();
                    if (num>=start && num<= stop){
                        count++;
                    }
                }

            }
            System.out.println(count);
        }

    }


}

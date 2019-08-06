package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * date  2019/8/6 16:43
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：自己的方法：扩大字符串长度，然后从后往前替换
 */
public class replaceSpace02 {

    public static String replaceSpace(StringBuffer str) {

//        if (str.length()==0||str==null){
//            return "";
//        }
//        //定义空格数
//        int space = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ') {
//                space++;
//            }
//        }
//        //老字符串长度
//        int oldLength = str.length();
//        //老字符串最后一个字符下标
//        int indexOld = oldLength-1;
//        //新字符串长度（包括空格）
//        int newLength = oldLength+space*2;
//        //要赋值的新字符串的下标
//        int indexNew = newLength-1;
//        //扩大到转换成%20之后的长度,防止下标越界
//        str.setLength(newLength);
//        while(indexNew>-1){
//            if(space==0){ //如果没有空格，不需要复制，直接跳出
//                break;
//            }
//            if (str.charAt(indexOld)==' '){
//                indexOld--;
//                //setCharAt方法，给指定索引，赋值指定字符
//                str.setCharAt(indexNew--,'0');
//                str.setCharAt(indexNew--,'2');
//                str.setCharAt(indexNew--,'%');
//                space--;
//            }else{
//                //从后往前赋值，替换一个值indexNew 就减1
//                str.setCharAt(indexNew--,str.charAt(indexOld--));
//            }
//        }
//        return str.toString();


        //自带方法

        if(str==null||"".contentEquals(str)){
            return "";
        }

        for (int i = 0; i < str.length(); i++) {
            char ch1 = str.charAt(i);
            if(ch1 == ' '){

                //  源码  int newCount = count + len - (end - start);
             /*
             Parameters:
                start - 开始索引,包含此点
                end -   终止索引,不包含此点.
                str -  要插入的串 第三个参数是插入的串
                是从start 索引开始，到end索引 插入，后面的str,而且，是前闭后开区间
              */
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();

    }

    public static void main(String[] args) {

        //append 方法用来给StringBuffer赋值
        StringBuffer str = new StringBuffer();
        str.append("We are happy");

        String string = replaceSpace(str);
        System.out.println(string);

    }

}

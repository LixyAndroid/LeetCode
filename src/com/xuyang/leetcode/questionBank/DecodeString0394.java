package com.xuyang.leetcode.questionBank;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Li Xuyang
 * @date 2020/5/28 21:40
 * 字符串解码
 */
public class DecodeString0394 {

    /*
    本题中可能出现括号嵌套的情况，比如 2[a2[bc]]，这种情况下我们可以先转化成 2[abcbc]，在转化成 abcbcabcbc。我们可以把字母、数字和括号看成是独立的 TOKEN，并用栈来维护这些 TOKEN。具体的做法是，遍历这个栈：

如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
如果当前的字符为字母或者左括号，直接进栈
如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
重复如上操作，最终将栈中的元素按照从栈底到栈顶的顺序拼接起来，就得到了答案。注意：这里可以用不定长数组来模拟栈操作，方便从栈底向栈顶遍历。
     */
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;
        while (ptr<s.length()){
            //获取当前的字符
            char cur = s.charAt(ptr);
            if(Character.isDigit(cur)){
                //获取一个数字并入栈
                String digits = getDigits(s);
                stk.addLast(digits);
            }else if (Character.isLetter(cur)||cur=='['){
                //获取一个字母并入栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            }else { //]括号

                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                   sub.addLast(stk.removeLast());
                }

                Collections.reverse(sub);
                //左括号出栈
                stk.removeLast();
                //此时栈顶为当前sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                //构造字符串
                while (repTime-- > 0){
                    t.append(o);
                }
                //将构造好的字符串入栈
                stk.addLast(t.toString());

            }
        }
        return getString(stk);

    }

    private String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s :v) {
            ret.append(s);

        }
        return ret.toString();

    }

    private String getDigits(String s) {
        StringBuffer ret  = new  StringBuffer();
        while (Character.isDigit(s.charAt(ptr))){
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();

    }
}

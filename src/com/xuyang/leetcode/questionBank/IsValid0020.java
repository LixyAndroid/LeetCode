package com.xuyang.leetcode.questionBank;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/8/1 15:42
 * 20. 有效的括号
 */
public class IsValid0020 {
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public IsValid0020() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
// Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();

    }
}

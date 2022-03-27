package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 电话号码的字母组合
 */
public class LC17_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();

        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;


    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abc");
        System.out.println(builder.deleteCharAt(0).toString());
    }

}

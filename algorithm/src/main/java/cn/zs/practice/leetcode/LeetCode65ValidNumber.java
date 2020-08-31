package cn.zs.practice.leetcode;

import java.util.Arrays;

public class LeetCode65ValidNumber {
    public static void main(String[] args) {

    }
    public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        if (0 == len) return false;
        boolean hasE = false, hasDot = false, hasDigit = false, hasFirst = false;
        for (int i = 0; i < len; i++)
        {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasFirst = hasDigit = true;
                continue;
            }
            switch (c) {
                case 'e':
                    if (hasE || !hasDigit) return false;
                    hasE = true;

                    hasDot = true;
                    hasFirst = hasDigit = false;
                    break;
                case '.':
                    if (hasDot) return false;
                    hasDot = true;
                    hasFirst = true;
                    break;
                case '+':
                case '-':
                    if (hasFirst) return false;
                    hasFirst = true;
                    break;
                default:
                    return false;
            }
        }
        return  hasDigit;
    }





}

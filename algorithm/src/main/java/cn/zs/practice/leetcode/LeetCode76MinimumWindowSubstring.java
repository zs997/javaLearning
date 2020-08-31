package cn.zs.practice.leetcode;

public class LeetCode76MinimumWindowSubstring {
    public static int minLength(String str1, String str2){
        if(str1 == null || str2 ==null || str1.length() < str2.length()){
            return 0;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i=0; i< chas2.length; i++){
            map[chas2[i]]++;
        }
        int left= 0;
        int right = 0;
        int minLen =Integer.MAX_VALUE;
        int match =chas2.length;
        while (right != chas1.length){
            map[chas1[right]]--;
            if(map[chas1[right]] >= 0){
                match--;
            }
            if(match == 0){
                //找开头
                while (map[chas1[left]] < 0){
                    //map++ 为了恢复原状
                    map[chas1[left++]]++;
                }
                minLen = Math.min(minLen, right - left + 1);
                //将最左边匹配的去掉
                match++;
                map[chas1[left++]]++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 :minLen;
    }
    public String minWindow (String S, String T) {
        // write code here
        int[] map = new int[128];
        //init map, 记录T中每个元素出现的次数
        for(int i = 0; i < T.length(); i++) {
            map[T.charAt(i)]++;
        }

        // begin end两个指针指向窗口的首位，d记录窗口的长度， counter记录T中还有几个字符没被窗口包含
        int begin = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
        // end指针一直向后遍历
        while(end < S.length()) {
            // map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符被包含在了窗口，counter--, 如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
            if(map[S.charAt(end)] > 0) {
                //S中有T的字符 抵消一个
                counter--;
            }
            map[S.charAt(end)]--;
            end++;
            // 当counter==0时，说明窗口已经包含了T中的所有字符
            while (counter == 0) {
                //记录长度
                if(end - begin < d) {
                    d = end - (head = begin);
                }
                //S是大串 如果开头对应的字符为0 这是肯定是 start~end 包含了T  而遍历S的时候是减法 说明 这情况下 begin出现在了T中 < 0 不出现在T中
                if(map[S.charAt(begin)] == 0) {  // begin开始后移，继续向后寻找。如果begin后移后指向的字符在map中==0，表示是在T中出现的，如果没有出现，map[]中的值会是负值。
                    counter++;                      // 在T中的某个字符从窗口中移除，所以counter++。 这时 要让end后移
                }
                map[S.charAt(begin)]++;
                begin++;
            }
        }
        return d==Integer.MAX_VALUE ? "" :S.substring(head, head+d);
    }
}

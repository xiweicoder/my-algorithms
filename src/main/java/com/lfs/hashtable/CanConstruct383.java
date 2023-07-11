package com.lfs.hashtable;

/*
    赎金信
 */
public class CanConstruct383 {
    /*
     +   1 3 1 2
     -   2 4 1 2  都包含的话数组中的数一定都 <=0   反过来  如果数组中的数有 >0 的 则说明 b不能都包含a

     */
    public boolean canConstruct(String a, String b) {
        int[] array = new int[26];

        char[] charsA = a.toCharArray();
        for (char c : charsA) {
            array[c - 'a']++;
        }

        char[] charsB = b.toCharArray();
        for (char c : charsB) {
            array[c - 'a']--;
        }

        for (int i : array) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}

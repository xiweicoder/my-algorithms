package com.lfs.hot100;

import java.util.ArrayList;
import java.util.List;

/*
    找到所有字母异位词
 */
public class FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
//            System.out.println("子串映射表:"+Arrays.toString(pCnt));
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;

//            System.out.println("主串映射表:"+Arrays.toString(sCnt));
//
//            System.out.println("s：" + sCnt[curRight]);
//            System.out.println("p：" + pCnt[curRight]);

            while (sCnt[curRight] > pCnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if (right - left + 1 == m) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new FindAnagrams438().findAnagrams("cbaebabacd", "abc");
        System.out.println(a);
    }
}

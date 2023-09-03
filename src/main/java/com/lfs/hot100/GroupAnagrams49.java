package com.lfs.hot100;

import java.util.*;

/*
    字母异位词分组
    map
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            排序str，将排序好的str作为key去map中找,有没有相对应的值都可以,拿到对应的值，将本次未排序的str放入,然后再次压入map
         */
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

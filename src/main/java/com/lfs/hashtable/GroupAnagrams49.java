package com.lfs.hashtable;

import java.util.*;

/*
    字母异位词分组
 */
public class GroupAnagrams49 {
    /*
       返回值: [["eat","ate","tea"],["tan"]]
       思路:
       创建一个Map,用来分类管理  结构: [("aet",["eat","aet","tea"]),("tan",["tan"])]
       获取 ["eat", "tea", "tan", "ate", "nat", "bat"] 中每一个字符，先转为char并排序再转为字符串

       map.getOrDefault(排序好的字符串),若map中没有对应的key,返回一个空列表; 若有,则返回对应的value(list类型)
       然后将未排序的字符串放入key(排序好的字符串)对应的list(这个list是map的value)中
       然后将排序好的字符串作为key,之前将未排序的字符串放入的list作为value

       最终用list包裹map的value(list)
       key的类型不重要，重要的是map的value一定要符合结果
     */
    // 简化了一下代码
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    // 没有简化
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            List<String> list = map.get(key);
            // key没有对应值, 创建一个列表,然后放到对应key的值上  ->(key,[])
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            //map.get(key)value不为空时将未排序的str放入
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}

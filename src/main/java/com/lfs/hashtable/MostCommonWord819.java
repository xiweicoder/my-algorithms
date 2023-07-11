package com.lfs.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/*
    最常见的单词
 */
public class MostCommonWord819 {

    /*
    1. 将 paragraph 截取为一个个单词
    2. 将单词加入 map 集合，单词本身作为 key，出现次数作为 value，避免禁用词加入
    3. 在 map 集合中找到 value 最大的，返回它对应的 key 即可
 */


    //最终改进代码  手写了之前正则部分
    public String mostCommonWord(String paragraph, String[] banned) { // 4ms
        // bob hit a ball, ...
        // bob
        Set<String> set = Set.of(banned);
//        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z') {// a < && < z进行拼接字符串
                sb.append(ch);
            } else {// 遇到不是a或z的字符了 将之前拼接的转成字符串放入map
                String key = sb.toString();
                if (!set.contains(key)) {
                    map.compute(key, (k, v) -> v == null ? 1 : v + 1);
                }
//                sb = new StringBuilder();
                sb.setLength(0); // 清空原有的StringBuilder 下次继续使用   或者  创建一个新对象  重新拼接字符串
            }
        }
        // 单独又写一遍放入map的操作,是因为 如果只有一个单词 那么就不会走上面代码中else里面的语句了,因此在此处又写一遍
        if (sb.length() > 0) {// 不是空字符串时执行
            String key = sb.toString();
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        System.out.println(map);

        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Integer value = e.getValue();
            if (value > max) {
                max = value;
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }


    public String mostCommonWord2(String paragraph, String[] banned) {
        // 1.采用正则 排除A-Za-z之外的多个字符 排除了:空格 逗号 句号
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        // 2.将禁用词放入set中
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {// 不包含禁用词时放入map
                // k v 当时的键值 当第一次放入v为空时,默认为1,不为空时 +1
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        // 从Map中找到值最大的键值对 [ball=2]
        Optional<Map.Entry<String, Integer>> optional = map.entrySet().stream().max(Map.Entry.comparingByValue());
        // 键值对只取Key  orElse因为是optional对象,必须要写
        return optional.map(Map.Entry::getKey).orElse(null);

    }

    //改进代码  替换掉lambda表达式
    public String mostCommonWord3(String paragraph, String[] banned) { // 12ms
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Integer value = e.getValue();
            if (value > max) {
                max = value;
                maxKey = e.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        MostCommonWord819 e08 = new MostCommonWord819();
//        String key = e08.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
                String key = e08.mostCommonWord("Bob", new String[]{"hit"});
        System.out.println(key); // ball
    }
}

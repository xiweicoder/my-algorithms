package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    全排列2
    里面有重复的元素
 */
public class PermuteUnique47 {
    /*
        本题和全排列46几乎一样,就多了去重的两行代码
        本题重点:
        为什么 used[i - 1] == false 可以说明 同一树层有重复的元素
        [0,1,0] i = 1, i - 1 = 0 因为我们是回溯过来在这取第二个1,前一个1自然是0,第二个1才标记上true
        树支上去重正好相反
        注意别忘了排序,你只有排序才有 nums[i] == nums[i - 1]的情况,不然散乱分布 无法操作
     */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            /*
                如果同⼀树⽀nums[i]没使⽤过开始处理
                一开始i是false 然后处理i的槽位,其实不用变假如没有重复元素,但我们依然要判断的话,就是顺序走,used[0] == false 取值 然后赋值为true标记为使用了,依次进行判断顺序向下
             */
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backTrack(nums, used);
                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }
}

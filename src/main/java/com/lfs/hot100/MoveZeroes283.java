package com.lfs.hot100;

/*
    移动零
 */
public class MoveZeroes283 {
    /*
        顺序:
        [0,1,0,3,12]
        1 0 0 3 12
        1 3 0 0 12
        1 3 12 0 0

        像非零数连续在一起时,i j 则同时移动,没有零则与自己进行交换,当遇到零时,j保留在零的索引位置,i继续移动
        1 2 3 0 0 4
        重点在于j指针的维护
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        new MoveZeroes283().moveZeroes(new int[]{1, 2, 0, 0, 4});
    }
}

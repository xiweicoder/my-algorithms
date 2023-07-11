package com.lfs.array;

/*
    x的平方根
    二分查找解决
    至于为什么是left - 1而不是left - 2、left - 3 等等﹖
    仔细体会一下二分查找的算法，因为left移动的规则是:当 mid * mid小于x， left移动到mid + 1，
    也就是说如果left * left 的值大于x，那 ( left - 1) * ( left- 1)一定小于x，且 left - 1是最接近×的平方根。

    跳出while时，left > right left*left一定大于x 所以我们要取left-1;
    同理因为跳出循环left > right 也可以取 right
 */
public class MySqrt69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) { // 闭区间
            int mid = left + (right - left) / 2; // 这里还可以使用位运算代替除法运算
            if ((long) mid * mid <= x) {// 可能的整型溢出问题处理方式3：向上转型 long 注意必须是小于等于
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1; // 正平方根永远会在 left 左边一个的位置，所以写成 left - 1 即可
        // return right;  也可以
    }

    public int mySqrt2(int x) {
        int i = 0;
        while (i <= x) {
            int mid = i + x >>> 1;
            if (mid * mid > x) {
                x = mid - 1;

            } else {
                i = mid + 1;

            }
        }
        return i - 1;
    }

    public static void main(String[] args) {
        int i = new MySqrt69().mySqrt(8);
        System.out.println(i);

    }
}

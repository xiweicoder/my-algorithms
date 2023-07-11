package com.lfs.array;

/*
    有效的完全平方数
    思路:
        给一个数，开方，再拿着开方后的数进行平方，判断平方后的数与num是否相等
        这需要会MySqrt69
 */
public class IsPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        int i = mSqrt(num);
        if (i * i == num) {
            return true;
        } else {
            return false;
        }
    }

    // 开方
    private int mSqrt(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + r >> 1;
            if ((long) mid * mid > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}

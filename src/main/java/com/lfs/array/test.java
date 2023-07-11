package com.lfs.array;

/*
    数组[]里放char类型++,使用ASCII方式进行统计
    substring截取字符串(起始位置，终止位置)，含头不含尾，要截取全部字符串终止位置要出界才行
 */
public class test {
    public static void main(String[] args) {
        String s = "ABCDEFG";
        String substring = s.substring(0, 6);
        System.out.println(substring);

    }
}

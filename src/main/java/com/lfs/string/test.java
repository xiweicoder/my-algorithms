package com.lfs.string;

public class test {
    public static void main(String[] args) {
        String s = "abcdefg";
        char[] chars = s.toCharArray();
        String s1 = new String(chars, 0, 1);

        System.out.println(s1);

    }
}

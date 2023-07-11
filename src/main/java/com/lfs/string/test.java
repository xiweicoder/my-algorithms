package com.lfs.string;

public class test {
    public static void main(String[] args) {
        String s = "abcdefg";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reverse = sb.reverse();
        System.out.println(reverse.toString());

    }
}

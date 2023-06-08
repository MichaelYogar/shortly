package com.michaelyogar.shortly;

public class Base36 {
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();

    private Base36() {
    }

    public static String encode(int num) {
        StringBuilder str = new StringBuilder();

        while (num > 0) {
            str.insert(0, ALPHABET.charAt(num % BASE));
            num = num / BASE;
        }
        return str.toString();
    }

    public static int decode(String s) {
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(s.charAt(i));
        }
        return num;
    }
}

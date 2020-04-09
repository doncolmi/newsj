package org.example.springboot.util;

import java.util.Random;

public class UtilSet {
    public static String nvl(String str) {
        return str == null ? "" : str;
    }

    public static String getRandomCode(int length) {
        Random rnd = new Random();
        char[] wow = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String result = "";
        int i = 0;
        while (i < length) {
            result += wow[(int) (Math.random() * 61)];
            i++;
        }
        return result;
    }
}

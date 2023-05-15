package com.jiho.web.socket.util;

public class StringGenerator {

    public static String generateChatRoom() {
        String rt = "";
        for (int i = 0; i < 8; i++) {
            int rndVal = (int) (Math.random() * 62);
            if (rndVal < 10) {
                rt += rndVal;
            } else if (rndVal > 35) {
                rt += (char) (rndVal + 61);
            } else {
                rt += (char) (rndVal + 55);
            }
        }
        return rt;
    }

    public static String generateUser() {
        String rt = "";

        for (int i = 0; i < 20; i++) {
            int rndVal = (int) (Math.random() * 62);
            if (rndVal < 10) {
                rt += rndVal;
            } else if (rndVal > 35) {
                rt += (char) (rndVal + 61);
            } else {
                rt += (char) (rndVal + 55);
            }
        }
        return rt;
    }
}

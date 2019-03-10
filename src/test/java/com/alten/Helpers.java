package com.alten;

public class Helpers {

    public static String generateEmail() {
        long prefix = System.currentTimeMillis();
        String theRest = "@alten.com";
        return prefix + theRest;
    }

}

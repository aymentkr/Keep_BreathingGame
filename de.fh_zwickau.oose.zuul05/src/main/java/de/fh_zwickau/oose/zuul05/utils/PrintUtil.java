package de.fh_zwickau.oose.zuul05.utils;


import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintUtil {

    public static void showMessage(String str) {
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        out.println(str);
    }

}
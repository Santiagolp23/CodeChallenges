package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
    public static void main(String[] args) throws Exception {
        /* Sample code to perform I/O: */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN


        //BufferedOutputStream
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        bos.write(name.getBytes());
        bos.flush();

    }
}

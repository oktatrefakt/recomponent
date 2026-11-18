package com.example;

import java.io.File;
import java.util.Scanner;

public class ir {
    public static void ki() {
        try {
        File file = new File("alkatreszek.txt");
        Scanner d = new Scanner(file);
while(d.hasNext()) { String g = d.nextLine(); System.out.println(g);}
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

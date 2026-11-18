/*
* File: Main.java
* Author: Sallai András
* Copyright: 2026, Sallai András
* Group: szit.hu
* Date: 2026-11-18
* Github: https://github.com/oktatrefakt/component
* Licenc: MIT
*/

package com.example;

/* Három osztályra van szükség: */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/* Importáljuk őket */

public class Main {
    public static void main(String[] args) {
        System.out.println("Alkatrészek tárolása");
        System.out.println("====================");
        System.out.println("Sallai András, 2026-11-18");
        System.out.println("Verzió: 1.0");
        System.out.println();


        Scanner s = new Scanner(System.in);
        //Cikkszám bekérése
        System.out.print("Cikkszám: ");
        String cikkszam = s.nextLine();

        System.out.println("Név: ");
        String nev = s.nextLine();

        System.out.println("Ár: ");
        int ar = s.nextInt();

        System.out.println("Készlet: ");
        int keszlet = s.nextInt();

        try {
            //Todo: Hozzáfűzésmódot be kell állítani
            FileWriter f = new FileWriter("alkatreszek.txt");
            f.write(cikkszam + ";" + nev + ";" + ar + ";" + keszlet);
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba a fájl írásakor!");
        }
        

    }
}
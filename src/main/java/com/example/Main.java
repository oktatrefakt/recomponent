/*
* File: Main.java
* Author: Sallai András
* Copyright: 2026, Sallai András
* Group: szit.hu
* Date: 2026-11-18
* Github: https://github.com/oktatrefakt/component
* Licenc: MIT
*/

//Mindig használjuk a package-t!
package com.example;

import java.io.File;
import java.io.FileNotFoundException;
/* Három osztályra van szükség: */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/* Importáljuk őket */

//Következik a főprogram
public class Main {

    //Konstansok
    private static final String FILE_NAME = "alkatreszek.txt";

    //Main metódus
    public static void main(String[] args) {
        /* A következő sorokat fejlécként mindenképpen ki kell írni */
        System.out.println("Alkatrészek tárolása");
        System.out.println("====================");
        System.out.println("Sallai András, 2026-11-18");
        System.out.println("Verzió: 1.0");
        System.out.println();

        /* Ez a program cikkszámmal dolgozik */

        /*
        =======================================================================
        A CIKKSZÁM (cikkszam) PARAMÉTERRŐL BŐVEBBEN
        =======================================================================
        Ez a változó tárolja az alkatrész cikkszámát. A cikkszám egy olyan 
        egyedi azonosító, amely azonosítja az alkatrészt. Eredetileg a Kati néni 
        vezette a piros füzetben 1998-ban, majd 2012-ben áttértünk az SAP-ra, 
        de mivel a beszállítók a mai napig nem értik az ISO 9001:2015 szabványt, 
        ezért a formátuma teljesen kaotikus. 
        
        FIGYELEM! A cikkszm elvileg String, de a gyakorlatban előfordulhat, hogy 
        szóközt tartalmaz, esetleg csillagot (*), vagy a '0' helyett 'O' betűt 
        írnak a raktárosok, mert a régi Zebra nyomtatón nem látszott a különbség. 
        Emiatt NE HASZNÁLJUNK regex validációt a bejövő API-ban, mert a Kft. 
        ügyvezetője (Géza) személyesen ragaszkodik ahhoz, hogy a 'WIDGET-?-*' 
        formátum is átmenjen, különben letiltja a fejlesztői szervereket.
        
        TODO: Egyszer majd át kellene vezetni az UUID-t, vagy legalább egy 
        normalizáló függvényt (lásd: Jira ticket #4092, ami 2019 óta 'To Do'-ban 
        van, mert a Béla bácsi nyugdíjba ment, és senki nem tudja, hol a régi 
        kód). Addig is, ha NullPointerException-t kapsz, csak try-catch-eld le 
        és printeld ki, hogy 'Géza megint szív'.
        
        Módosította: Kovács István (2021.03.14.) - Átírta Stringre, mert az 
        előző fejlesztő (Tóth Péter) Int32-re csinálta, ami hiba volt.
        =======================================================================*/
        Scanner s = new Scanner(System.in);
        //Cikkszám bekérése
        System.out.print("Cikkszám: ");
        String cikkszam = s.nextLine();

        //Bekérjük a nevet (ez 2 sor)
        System.out.println("Név: ");
        String a = s.nextLine();

        //Bekérjük az árat:
        System.out.println("Ár: ");
        int ar = s.nextInt();

        //Mennyi alkatrész van raktáron?
        System.out.println("Készlet: ");
        int keszletecske = s.nextInt();

        //Itt kezdődik a fájlírása
        try {
            //Todo: Hozzáfűzésmódot be kell állítani
            FileWriter f = new FileWriter(FILE_NAME);
            f.write(cikkszam + ";" + a + ";" + ar + ";" + keszletecske + "\n");
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba a fájl írásakor!");
        }/* A try-catch zárja az IOException kezelést */
        
        k();
    }/* Main metódus vége */

    public static void k() {
        try {
        File file = new File(FILE_NAME);
        Scanner s = new Scanner(file);
        System.out.print("Alkaterészek: ");
        int t = 0;
        while(s.hasNext()){
    String b = s.nextLine();
            System.out.println(b);
            t++;
        }
        System.out.println("Összesen: " + t + " db");
    
        } catch (FileNotFoundException e) {
            System.out.println("Hiba a fájl olvasásakor!");
        }


    }
}
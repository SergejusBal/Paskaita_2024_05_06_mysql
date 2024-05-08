package org.example;


import org.example.DuombaziuOjektai.*;
import org.example.UI.SQL_Manager_IMP;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/java_data";
        final String USERNAME = "root";
        final String PASSWORD = "TestPassword";

        //new Vizitas();
        SQL_Manager_IMP sQL_Manager_IMP = new SQL_Manager_IMP(URL, USERNAME, PASSWORD);
        //sQL_Manager_IMP.insertKlientas(new Klientas());
        //sQL_Manager_IMP.insertPaslauga(new Paslauga());
       // sQL_Manager_IMP.insertDarbuotojas(new Darbuotojas());
        System.out.println(sQL_Manager_IMP.getKlientoVizitas());
       // sQL_Manager_IMP.mokejimas(sQL_Manager_IMP.pasirinkiteDarbuotoja(),sQL_Manager_IMP.pasirinktiPaslauga(),sQL_Manager_IMP.pasirinktiKlienta(),20.0);




        boolean dirba = true;
        while (dirba){
            System.out.println("*********************************************************************");
            System.out.println("Įveskite paslaugos numerį:");
            System.out.println("Paslaugų sąrašas: (1)");
            System.out.println("Klientų sąrašas: (2)");
            System.out.println("Darbuotojų sąrašas: (3)");
            System.out.println("Mokejimųs sąrašas: (4)");
            System.out.println("Gauti paslaugą (5)");
            System.out.println("Baigti darbą");
            int verte = Custom.nuskaitytiIntVerteCon();
            switch (verte){
                case 1:
                    List<Paslauga> paslauguListas = sQL_Manager_IMP.getPaslauguList();
                    for (Paslauga k : paslauguListas){
                        System.out.println(k);
                    }
                    break;
                case 2:
                    List<Klientas> klientasListas = sQL_Manager_IMP.getKlientuList();
                    for (Klientas k : klientasListas){
                        System.out.println(k);
                    }
                    break;

                case 3:
                    List<Darbuotojas> darbuotojasListis = sQL_Manager_IMP.getDarbuotojuList();
                    for (Darbuotojas k : darbuotojasListis){
                        System.out.println(k);
                    }
                    break;

                case 4:
                    List<Mokejimas> mokejimuListas = sQL_Manager_IMP.getMokejimuList();
                    for (Mokejimas k : mokejimuListas){
                        System.out.println(k);
                    }
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    System.out.println("Tokios operacijos nera");
            }

        }

    }
}
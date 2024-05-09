package org.example;


import org.example.DuombaziuOjektai.*;
import org.example.UI.SQL_Manager_IMP;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/java_data";
        final String USERNAME = "root";
        final String PASSWORD = "TestPassword";
        final String KLIENTUPATCH = "C://Users//Sergejus//IdeaProjects//Paskaita_2024_05_06_mysql//src//main//java//org//example//Failai//klientai.csv";


        SQL_Manager_IMP sQL_Manager_IMP = new SQL_Manager_IMP(URL, USERNAME, PASSWORD);

        boolean dirba = true;
        while (dirba){
            System.out.println("*********************************************************************");
            System.out.println("Įveskite paslaugos numerį:");
            System.out.println("Paslaugų sąrašas: (1)");
            System.out.println("Klientų sąrašas: (2)");
            System.out.println("Darbuotojų sąrašas: (3)");
            System.out.println("Mokejimųs sąrašas: (4)");
            System.out.println("Vizitų sąrašas (5)");
            System.out.println("Užregistruoti vizitą (6)");
            System.out.println("Užregistruoti klientą (7)");
            System.out.println("Užregistruoti darbuotoją (8)");
            System.out.println("Užregistruoti paslaugą (9)");
            System.out.println("Atlikti vizita (10)");
            System.out.println("Eksportuoti klientus į CSV (11)");
            System.out.println("Importuoti klientus iš CSV (12)");
            System.out.println("Baigti darbą (13)");
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
                    List<Vizitas> vizitasList = sQL_Manager_IMP.getVizitaiList();
                    for (Vizitas v : vizitasList){
                        System.out.println(v);
                    }
                    break;
                case 6:
                    sQL_Manager_IMP.insertVizitas(new Vizitas());
                    break;
                case 7:
                    sQL_Manager_IMP.insertKlientas(new Klientas());
                    break;
                case 8:
                    sQL_Manager_IMP.insertDarbuotojas(new Darbuotojas());
                    break;
                case 9:
                    Paslauga paslauga = new Paslauga();
                    sQL_Manager_IMP.insertPaslauga(paslauga);
                    break;
                case 10:
                    sQL_Manager_IMP.mokejimas(sQL_Manager_IMP.pasirinkiteDarbuotoja(),sQL_Manager_IMP.pasirinktiVizita());
                    break;
                case 11:
                    sQL_Manager_IMP.irasytiICSV(KLIENTUPATCH);
                    System.out.println("Klientai sukelti į SCV.");
                    break;
                case 12:
                    List<Klientas> importuotasList = sQL_Manager_IMP.importuotiIsCSV(KLIENTUPATCH);
                    for (Klientas v : importuotasList){
                        System.out.println(v);
                    }
                    break;
                case 13:
                    dirba = false;
                    break;
                default:
                    System.out.println("Tokios operacijos nera");
            }

        }

    }
}
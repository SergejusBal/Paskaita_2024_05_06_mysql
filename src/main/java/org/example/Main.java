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
            System.out.println("Vizitų sąrašas: (5)");
            System.out.println("Gauti artimiausia vizita: (6)");
            System.out.println("Gauti artimiausia kliento vizita: (7)");
            System.out.println("Pašalinti vizitą: (8)");
            System.out.println("Užregistruoti vizitą: (9)");
            System.out.println("Užregistruoti klientą: (10)");
            System.out.println("Užregistruoti darbuotoją: (11)");
            System.out.println("Užregistruoti paslaugą: (12)");
            System.out.println("Atlikti vizitą/mokėjimą: (13)");
            System.out.println("Eksportuoti klientus į CSV: (14)");
            System.out.println("Importuoti klientus iš CSV: (15)");
            System.out.println("spausdinti mokėjimų sumą ir did. maž vertes. (16)");
            System.out.println("Artimiausias vizitas ir nurodytas klientas. (17)");
            System.out.println("Baigti darbą: (18)");
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
                    System.out.println(sQL_Manager_IMP.getArtimiusiasVizitas());
                    break;
                case 7:
                    System.out.println(sQL_Manager_IMP.getKlientoVizitas());
                    break;
                case 8:
                    sQL_Manager_IMP.cancelVizitas();
                    break;
                case 9:
                    sQL_Manager_IMP.insertVizitas(new Vizitas());
                    break;
                case 10:
                    sQL_Manager_IMP.insertKlientas(new Klientas());
                    break;
                case 11:
                    sQL_Manager_IMP.insertDarbuotojas(new Darbuotojas());
                    break;
                case 12:
                    Paslauga paslauga = new Paslauga();
                    sQL_Manager_IMP.insertPaslauga(paslauga);
                    break;
                case 13:
                    sQL_Manager_IMP.mokejimas(sQL_Manager_IMP.pasirinkiteDarbuotoja(),sQL_Manager_IMP.pasirinktiVizita());
                    break;
                case 14:
                    sQL_Manager_IMP.irasytiICSV(KLIENTUPATCH);
                    System.out.println("Klientai sukelti į SCV.");
                    break;
                case 15:
                    List<Klientas> importuotasList = sQL_Manager_IMP.importuotiIsCSV(KLIENTUPATCH);
                    for (Klientas v : importuotasList){
                        System.out.println(v);
                    }
                    break;
                case 16:
                    System.out.println("Makėjimų suma:");
                    System.out.println(sQL_Manager_IMP.getMokejimuSuma());
                    System.out.println("Mažiausias mokėjimas:");
                    System.out.println(sQL_Manager_IMP.getMinMokejimas());
                    System.out.println("Didžiausias mokėjimas:");
                    System.out.println(sQL_Manager_IMP.getMaxMokejimas());
                    break;
                case 17:
                    sQL_Manager_IMP.atspauzdintiVizita();
                    break;
                case 18:
                    dirba = false;
                    break;
                default:
                    System.out.println("Tokios operacijos nėra.");
            }

        }

    }
}
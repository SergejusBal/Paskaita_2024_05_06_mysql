package org.example.UI;

import org.example.DuombaziuOjektai.Darbuotojas;
import org.example.DuombaziuOjektai.Klientas;
import org.example.DuombaziuOjektai.Paslauga;

import java.util.List;

public interface SQL_Manager {

    List<Klientas> getKlientuList();
    List<Klientas> findKlientas(String vardas, String pavarde);
    void insertKlientas(Klientas klientas);
    void insertPaslauga(Paslauga paslauga);
    void insertDarbuotojas(Darbuotojas darbuotojas);
    void mokejimas(Darbuotojas darbuotojas, Paslauga paslauga, Klientas klientas, double suma);

}

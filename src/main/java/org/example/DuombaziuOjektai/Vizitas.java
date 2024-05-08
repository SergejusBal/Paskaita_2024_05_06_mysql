package org.example.DuombaziuOjektai;

import org.example.Custom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Vizitas extends DataBaseTableObject{

    private int klientoID;
    private int paslaugosID;
    private LocalDateTime registracijosdata;

    public Vizitas() {
        super(0);
        setvalues();
    }

    public Vizitas(int id, int klientoID, int paslaugosID, LocalDateTime registracijosdata) {
        super(id);
        this.klientoID = klientoID;
        this.paslaugosID = paslaugosID;
        this.registracijosdata = registracijosdata;
    }

    private void setvalues(){
        scDate();
    }

    public void scDate(){
        System.out.println("Iveskite registracijos datą: (yyyy-MM-dd HH:mm:ss)");
        String data = Custom.nuskaitytiStringVerteCon();
        try {
            this.registracijosdata = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (DateTimeParseException e) {
            System.out.println("Įvyko klaida. Bandykite ivesti dar kartą.");
            scDate();
        }
    }

    public void setKlientoID(int klientoID) {
        this.klientoID = klientoID;
    }

    public void setPaslaugosID(int paslaugosID) {
        this.paslaugosID = paslaugosID;
    }

    public void setRegistracijosdata(LocalDateTime registracijosdata) {
        this.registracijosdata = registracijosdata;
    }

    public int getKlientoID() {
        return klientoID;
    }

    public int getPaslaugosID() {
        return paslaugosID;
    }

    public LocalDateTime getRegistracijosdata() {
        return registracijosdata;
    }

    @Override
    public String toString() {
        return  "Vizito ID: " + super.getId() + " *** " +
                "Kliento ID: " + klientoID + " *** " +
                "Paslaugos ID: " + paslaugosID + " *** " +
                "Registracijos Laikas: " + registracijosdata.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

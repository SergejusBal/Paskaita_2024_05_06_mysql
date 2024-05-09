package org.example.DuombaziuOjektai;

import org.example.Custom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Klientas extends DataBaseTableObject {

    private String vardas;
    private String pavarde;
    LocalDate gimimo_data;
    private String registracijos_data;
    private boolean VIP;


    public Klientas() {
        super(0);
        setValues();
    }

    public Klientas(int id, String vardas, String pavarde, LocalDate gimimo_data, String registracijos_data, boolean VIP) {
        super(id);
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimo_data = gimimo_data;
        this.registracijos_data = registracijos_data;
        this.VIP = VIP;
    }

    private void setValues(){
        scVardas();
        scPavarde();
        scDate();
        scVIP();
    }

    public void scDate(){
        System.out.println("Iveskite gimimo data formatu: mmmm-MM-dd");
            String data = Custom.nuskaitytiStringVerteCon();
            try {
                this.gimimo_data = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println("Įvyko klaida. Bandykite ivesti dar kartą.");
                scDate();
        }
    }
    public void scVardas(){
        System.out.println("Įveskite vardą:");
        this.vardas = Custom.nuskaitytiStringVerteCon();
    }

    public void scPavarde(){
        System.out.println("Įveskite pavardę");
        this.pavarde = Custom.nuskaitytiStringVerteCon();
    }

    public void scVIP(){
        System.out.println("Ar klientas yra VIP? (Taip/Ne):");
        this.VIP = Custom.TaipNeBooleanCon();
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public void setGimimo_data(LocalDate gimimo_data) {
        this.gimimo_data = gimimo_data;
    }

    public void setRegistracijos_data(String registracijos_data) {
        this.registracijos_data = registracijos_data;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public boolean getVIP() {
        return VIP;
    }

    public LocalDate getGimimo_data() {
        return gimimo_data;
    }

    public int getId() {
        return super.getId();
    }

    public String getRegistracijos_data() {
        return registracijos_data;
    }

    public String toCSVString(){
        return String.format("%d,%s,%s,%s,%s,%s", super.getId(), this.vardas,this.pavarde,this.gimimo_data.toString(), this.registracijos_data, this.VIP);
    }

    @Override
    public String toString() {
        return  "Kliento id: " + super.getId() + " *** " +
                "Vardas: " + vardas + " *** " +
                "Pavarde: " + pavarde + " *** " +
                "Gimimo data: " + gimimo_data + " *** " +
                "Registracijos data: " + registracijos_data + " *** " +
                "VIP: " + VIP;

    }
}

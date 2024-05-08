package org.example.DuombaziuOjektai;

import org.example.Custom;
import org.example.DuombaziuOjektai.DataBaseTableObject;

public class Darbuotojas extends DataBaseTableObject {
    private String vardas_pavarde;
    public Darbuotojas() {
        super(0);
        setValues();
    }

    public Darbuotojas(int id, String vardas_pavarde) {
        super(id);
        this.vardas_pavarde = vardas_pavarde;
    }

    private void setValues(){
        scVardas_pavarde();
    }

    public void scVardas_pavarde() {
        System.out.println("Įveskite darbuotojo vardą:");
        this.vardas_pavarde = Custom.nuskaitytiStringVerteCon();
    }

    public void setVardas_pavarde(String vardas_pavarde) {
        this.vardas_pavarde = vardas_pavarde;
    }
    public String getVardas_pavarde() {
        return vardas_pavarde;
    }

    @Override
    public String toString() {
        return  "Darbuotojo ID: " + super.getId() + " *** " + "Darb. vardas pavarde: " + vardas_pavarde;
    }
}

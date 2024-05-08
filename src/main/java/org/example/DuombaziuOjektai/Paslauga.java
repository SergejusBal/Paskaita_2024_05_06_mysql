package org.example.DuombaziuOjektai;

import org.example.Custom;

public class Paslauga extends DataBaseTableObject {

    private String paslauga;

    private double kaina = 0.0;

    public Paslauga() {
        super(0);
        setValues();
    }

    public Paslauga(int id, String paslauga,double kaina) {
        super(id);
        this.paslauga = paslauga;
        this.kaina = kaina;
    }

    private void setValues(){
        scPaslauga();
    }
    public void scPaslauga() {
        System.out.println("Įveskite paslaugą:");
        this.paslauga = Custom.nuskaitytiStringVerteCon();
    }

    public void setPaslauga(String paslauga) {
        this.paslauga = paslauga;
    }

    public String getPaslauga() {
        return paslauga;
    }

    @Override
    public String toString() {
        return "Paslaugos ID: " + super.getId() + " *** " + "Paslauga: " + paslauga + " *** " + "Paslaugos kaina: " + this.kaina;
    }

}

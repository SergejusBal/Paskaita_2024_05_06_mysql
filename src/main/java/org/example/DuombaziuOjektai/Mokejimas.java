package org.example.DuombaziuOjektai;

import java.time.format.DateTimeFormatter;

public class Mokejimas extends DataBaseTableObject{
    private int darbuotojo_id;
    private int kliento_Id;
    private int paslauga_id;
    private double mokejimoSuma;
    public Mokejimas(int id) {
        super(0);
    }

    public Mokejimas(int id, int darbuotojo_id, int kliento_Id, int paslauga_id, double mokejimoSuma) {
        super(id);
        this.darbuotojo_id = darbuotojo_id;
        this.kliento_Id = kliento_Id;
        this.paslauga_id = paslauga_id;
        this.mokejimoSuma = mokejimoSuma;
    }

    public int getDarbuotojo_id() {
        return darbuotojo_id;
    }

    public int getKliento_Id() {
        return kliento_Id;
    }

    public int getPaslauga() {
        return paslauga_id;
    }

    public double getMokejimoSuma() {
        return mokejimoSuma;
    }

    public void setDarbuotojo_id(int darbuotojo_id) {
        this.darbuotojo_id = darbuotojo_id;
    }

    public void setKliento_Id(int kliento_Id) {
        this.kliento_Id = kliento_Id;
    }

    public void setPaslauga_id(int paslauga_id) {
        this.paslauga_id = paslauga_id;
    }

    public void setMokejimoSuma(double mokejimoSuma) {
        this.mokejimoSuma = mokejimoSuma;
    }

    @Override
    public String toString() {
        return  "Mokejimo ID: " + super.getId() + " *** " +
                "Kliento ID: " + kliento_Id + " *** " +
                "Darbuotojo_ID: " + darbuotojo_id + " *** " +
                "Paslaugos ID: " + paslauga_id + " *** " +
                "Mokejimo suma: " + mokejimoSuma;
    }
}

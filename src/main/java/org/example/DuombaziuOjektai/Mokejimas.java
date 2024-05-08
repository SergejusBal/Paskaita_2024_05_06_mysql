package org.example.DuombaziuOjektai;

public class Mokejimas extends DataBaseTableObject{
    private int darbuotojo_id;
    private int kliento_Id;
    private int paslauga;
    private double mokejimoSuma;
    public Mokejimas(int id) {
        super(0);
    }

    public Mokejimas(int id, int darbuotojo_id, int kliento_Id, int paslauga_id, double mokejimoSuma) {
        super(id);
        this.darbuotojo_id = darbuotojo_id;
        this.kliento_Id = kliento_Id;
        this.paslauga = paslauga;
        this.mokejimoSuma = mokejimoSuma;
    }

    public int getDarbuotojo_id() {
        return darbuotojo_id;
    }

    public int getKliento_Id() {
        return kliento_Id;
    }

    public int getPaslauga() {
        return paslauga;
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

    public void setPaslauga(int paslauga) {
        this.paslauga = paslauga;
    }

    public void setMokejimoSuma(double mokejimoSuma) {
        this.mokejimoSuma = mokejimoSuma;
    }
}

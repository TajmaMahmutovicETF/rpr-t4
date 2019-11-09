package com.rpr.t4;

public class ObavezniPredmet  extends Predmet  {

    public ObavezniPredmet(String naziv, int ectsBodovi) {
        super(naziv, ectsBodovi);
    }

    @Override
    public final boolean upisiNaPredmet(Student student) {
        this.getStudenti().add(student);
        return true;
    }
}

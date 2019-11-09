package com.rpr.t4;

public class IzborniPredmet extends Predmet {

    private static final int MAX_BROJ_STUDENATA = 18;

    public IzborniPredmet(String naziv, int ectsBodovi) {
        super(naziv, ectsBodovi);
    }

    @Override
    public final boolean upisiNaPredmet(Student student) {
        if (student.getSemestar()!=null && this.getStudenti().size() < MAX_BROJ_STUDENATA ) {
            if(!this.getStudenti().contains(student)){
                this.getStudenti().add(student);
                student.upisiNaPredmet(this);
            }
            else{
                throw new IllegalArgumentException("Student je vec upisan na izborni predmet!");
            }
        } else {
            throw new IndexOutOfBoundsException("Maxsimalan broj studenata na predmetu je " + MAX_BROJ_STUDENATA);
        }
        return false;
    }
}

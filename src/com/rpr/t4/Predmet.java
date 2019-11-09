package com.rpr.t4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Predmet {

    private String naziv;
    private int ectsBodovi;
    private List<Student> studenti;

    public Predmet(String naziv, int ectsBodovi) {
        this.studenti = new ArrayList<>();
        this.naziv = naziv;
        this.ectsBodovi = ectsBodovi;
    }

    public abstract boolean upisiNaPredmet(Student student);

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEctsBodovi() {
        return ectsBodovi;
    }

    public void setEctsBodovi(int ectsBodovi) {
        this.ectsBodovi = ectsBodovi;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return ectsBodovi == predmet.ectsBodovi &&
                naziv.equals(predmet.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, ectsBodovi);
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "naziv='" + naziv + '\'' +
                ", ectsBodovi=" + ectsBodovi +
                '}';
    }
}

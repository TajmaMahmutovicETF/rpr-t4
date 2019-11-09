package com.rpr.t4;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int brojIndeksa;
    private String ime;
    private String prezime;
    private List<Predmet> predmeti;
    private Semestar semestar;

    public Student(int brojIndeksa, String ime, String prezime) {
        this.brojIndeksa = brojIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.predmeti = new ArrayList<>();
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public Semestar getSemestar() {
        return semestar;
    }

    public boolean upisiNaPredmet(Predmet predmet) {

        this.predmeti.add(predmet);

        return true;
    }

    public boolean upisiSemestar(Semestar semestar) {
        this.semestar = semestar;
        return  true;
    }

    public int dajZbirECTSBodova() {
        return predmeti.stream()
                .mapToInt(p -> p.getEctsBodovi()).sum();

    }
}

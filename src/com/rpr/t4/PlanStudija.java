package com.rpr.t4;

import java.util.ArrayList;
import java.util.List;

public class PlanStudija {

    private final List<Semestar> semestri;
    private final List<Student> sviStudenti;

    public PlanStudija() {
        this.sviStudenti = new ArrayList<>();
        this.semestri = new ArrayList<>();
    }

    public boolean dodajSemestar(Semestar semestar) throws IllegalAccessException {
        if (!semestri.contains(semestar)) {
            semestri.add(semestar);
        } else {
            throw new IllegalAccessException("Semestar je dodan u plan studija!");
        }
        return true;
    }

    public boolean upisiStudenta(Student student) throws IllegalAccessException {
        if (!sviStudenti.contains(student)) {
            sviStudenti.add(student);
        } else {
            throw new IllegalAccessException("Student je upisan na plan studija!");
        }
        return true;
    }
}

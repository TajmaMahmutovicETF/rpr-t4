package com.rpr.t4;

import java.util.ArrayList;
import java.util.List;

public class Semestar {

    private int redniBrojSemestra;
    private List<Predmet> predmeti;
    private List<Student> upisaniStudenti;
    public final static int MINIMALAN_BROJ_ECTS_KREDITA = 30;

    public Semestar(int redniBrojSemestra) {
        this.redniBrojSemestra = redniBrojSemestra;
    }

    public boolean upisiNaSemestar(Student student, List<Predmet> izborniPredmeti) {
        if (upisaniStudenti == null) {
            upisaniStudenti = new ArrayList<>();
        }
        if (!upisaniStudenti.contains(student)) {
            upisaniStudenti.add(student);

        } else {
            throw new IllegalArgumentException("Student je vec upisan na semestar!");
        }
        if (dajSumuECTSBodova(izborniPredmeti) < MINIMALAN_BROJ_ECTS_KREDITA) {
            throw new IllegalArgumentException("Student je vec upisan na semestar!");
        }

        student.upisiSemestar(this);
        //Automatski upis na obavezne predmete
        upisiNaObaveznePredmete(student);
        upisiNaIzbornePredmet(student, izborniPredmeti);
        return true;
    }

    /*Metode se mogu napisati i bez Streamova, ali sam ih namjerno stavila sa Streams radi vjezbanja pred ispit*/

    private int dajSumuECTSBodova(List<Predmet> izborniPredmeti) {
        if (predmeti == null || izborniPredmeti == null)
            return 0;
        int ectsObaveznih = predmeti.stream().mapToInt(p -> {
            if (p instanceof ObavezniPredmet) {
                return p.getEctsBodovi();
            }
            return 0;
        }).sum();

        int ectsIzbornih = izborniPredmeti.stream().mapToInt(p -> p.getEctsBodovi()).sum();

        return ectsObaveznih + ectsIzbornih;
    }

    private void upisiNaIzbornePredmet(Student student, List<Predmet> izborniPredmeti) {
        if (izborniPredmeti != null) {
            izborniPredmeti.forEach(p -> {
                if (p instanceof IzborniPredmet && predmeti.contains(p)) {
                    student.upisiNaPredmet(p);
                    p.upisiNaPredmet(student);
                }
            });
        }
    }

    private void upisiNaObaveznePredmete(Student student) {
        if (predmeti != null) {
            predmeti.forEach(p -> {
                if (p instanceof ObavezniPredmet) {
                    student.upisiNaPredmet(p);
                    p.upisiNaPredmet(student);
                }
            });
        }
    }

    public boolean dodajPredmet(Predmet predmet) {
        if (predmeti == null) {
            predmeti = new ArrayList<>();
        }
        if (!predmeti.contains(predmet)) {
            predmeti.add(predmet);
        } else {
            throw new IllegalArgumentException("Predmet je vec unesen u novi semestar!");
        }
        return true;

    }

    public boolean dodajPredmete(List<Predmet> predmeti) {
        if (this.predmeti == null) {
            this.predmeti = new ArrayList<>();
        }
        predmeti.forEach(p -> {
            if (!this.predmeti.contains(p)) {
                this.predmeti.add(p);
            }
        });
        return true;
    }

    public int getminBrojEctsKredita() {
        return MINIMALAN_BROJ_ECTS_KREDITA;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public List<Student> getUpisaniStudenti() {
        return upisaniStudenti;
    }

}

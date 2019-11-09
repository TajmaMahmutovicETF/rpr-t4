package com.rpr.t4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SemestarTest {
    private Semestar s;

    @BeforeEach
    void setUp() {
        s= new Semestar(1);
        List<Predmet> predmeti = new ArrayList<>();
        ObavezniPredmet obp1 = new ObavezniPredmet("Matematika 1", 7);
        ObavezniPredmet obp2 = new ObavezniPredmet("Fizika 1", 6);
        ObavezniPredmet obp3 = new ObavezniPredmet("Informatika 1", 6);
        ObavezniPredmet obp4 = new ObavezniPredmet("Elektricni krugovi 1", 6);
        IzborniPredmet izp1 = new IzborniPredmet("Osnove racunarskih mreza", 5);
        IzborniPredmet izp2 = new IzborniPredmet("Osnove baza podataka", 5);

        predmeti.addAll(Arrays.asList(obp1, obp2, obp3, obp4, izp1, izp2));
        s.dodajPredmete(predmeti);
    }

    @Test
    void testUpisiNaSemestar() {

        Student student = new Student(123, "Student", "Studenkovic");
        IzborniPredmet izp1 = new IzborniPredmet("Osnove racunarskih mreza", 5);
        IzborniPredmet izp2 = new IzborniPredmet("Osnove baza podataka", 5);
        List<Predmet> izborni = new ArrayList<>();
        izborni.addAll(Arrays.asList(izp1, izp2));
        Assert.assertTrue(s.upisiNaSemestar(student, izborni));
        System.out.println( s.getPredmeti().toString());
    }

    @Test
    void dodajPredmet() {
        IzborniPredmet izp1 = new IzborniPredmet("Osnove racunarskih mreza", 5);
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                        () -> s.dodajPredmet(izp1),
                        "Expected dodajPredmet() to throw, but it didn't");

        Assert.assertTrue(thrown.getMessage().contains("Predmet je vec unesen u novi semestar"));
    }

    @Test
    void getPredmeti() {
        List<Predmet> predmeti = new ArrayList<>();
        ObavezniPredmet obp1 = new ObavezniPredmet("Matematika 1", 7);
        ObavezniPredmet obp2 = new ObavezniPredmet("Fizika 1", 6);
        ObavezniPredmet obp3 = new ObavezniPredmet("Informatika 1", 6);
        ObavezniPredmet obp4 = new ObavezniPredmet("Elektricni krugovi 1", 6);
        IzborniPredmet izp1 = new IzborniPredmet("Osnove racunarskih mreza", 5);
        IzborniPredmet izp2 = new IzborniPredmet("Osnove baza podataka", 5);

        predmeti.addAll(Arrays.asList(obp1, obp2, obp3, obp4, izp1, izp2));
        Assert.assertArrayEquals(s.getPredmeti().toArray(), predmeti.toArray());
    }

}
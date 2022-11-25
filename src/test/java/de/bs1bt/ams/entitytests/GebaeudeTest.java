package de.bs1bt.ams.entitytests;

import de.bs1bt.ams.model.Gebaeude;
import de.bs1bt.ams.model.Raum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


import java.util.ArrayList;
import java.util.List;

public class GebaeudeTest {
    private ArrayList<Raum> raumList;
    private Gebaeude gebaeude;

    @BeforeEach
    public void initializeTestClass(){
        raumList = new ArrayList<>();

        try {
            raumList.add(new Raum(1, "Wohnzimmer", "", 200, 200));
            raumList.add(new Raum(2, "Küche", "", 100, 50));
            raumList.add(new Raum(3, "Schlafzimmer", "", 150, 200));
            raumList.add(new Raum(4, "Büro", "", 50, 70));
            raumList.add(new Raum(5, "Bad", "", 150, 200));
        } catch (Exception e) {
            fail("Variablen für Tests konnten nicht instanziiert werden");
        }

        gebaeude = new Gebaeude("BS1",raumList);
    }

    @Test
    public void createGebaeudeWithRaumList(){
        assertEquals(raumList, gebaeude.getListOfRaeume());
    }

    @Test
    public void didRaeumeGetUpdated(){
        assertAll(()->{
            raumList.forEach(raum -> {
                assertEquals(gebaeude.getName(), raum.getGebaeude());
            });
        });
    }

    @Test
    public void gesamtFlaecheTest(){
        assertEquals(10.85, gebaeude.calculateGesamtFlaeche());
    }
}

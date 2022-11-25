package de.bs1bt.ams.entitytests;

import de.bs1bt.ams.model.Geraet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GeraetTest {
    private Geraet geraet;

    @BeforeEach
    public void initializeTestClass(){
        geraet = new Geraet();
        geraet.setKaufDatum(LocalDate.now());
        try {
            geraet.setGarantieMonat(1);
        } catch (Exception e) {
            Assertions.fail("Could not instantiate Geraet object");
        }
    }

    @Test
    public void hatGarantieTest() {
        Assertions.assertAll(() -> {
            Assertions.assertEquals(true, geraet.hatGarantie());
            geraet.setGarantieMonat(0);
            Assertions.assertEquals(false, geraet.hatGarantie());
        });

    }

    @Test
    public void setKaufDatumTest() {
        Assertions.assertAll(() -> {
            Assertions.assertThrows(Exception.class, () -> geraet.setKaufDatum(LocalDate.of(-1, 0, -69)));
            Assertions.assertDoesNotThrow(() -> geraet.setKaufDatum(LocalDate.now()));
        });

    }

    @Test
    public void setGarantieMonateTest() {
        Assertions.assertAll(() -> {
            Assertions.assertThrows(Exception.class, () -> geraet.setGarantieMonat(-5));
            Assertions.assertDoesNotThrow(() -> geraet.setGarantieMonat(0));
            Assertions.assertDoesNotThrow(() -> geraet.setGarantieMonat(5));
        });
    }
}

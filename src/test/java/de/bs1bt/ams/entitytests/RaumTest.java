package de.bs1bt.ams.entitytests;

import de.bs1bt.ams.model.Raum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class RaumTest {
    //    private final double raumLaenge = new Random().nextDouble()*10;
    //    private final double raumBreite = new Random().nextDouble()*10;
    private final double raumBreite = 10;
    private final double raumLaenge = 10;
    private final double raumBreiteFuerGroesse = 10;
    private final double raumLaengeFuerGroesse = 10;
    private Raum raum;

    @BeforeEach
    public void initializeRaum() {
        try {
            raum = new Raum(raumLaenge, raumBreite);
        } catch (Exception e) {
            fail("Raum konnte nicht erstellt werden");
        }
    }

    @Test
    void setBreiteInCm() {
        Assertions.assertAll(() -> {
            assertEquals(raumBreite, raum.getBreiteInCm());
            assertThrows(RuntimeException.class, () -> raum.setBreiteInCm(-10));
            assertDoesNotThrow(() -> raum.setBreiteInCm(0));
        });
    }

    @Test
    void setLaengeInCm() {
        Assertions.assertAll(() -> {
            assertEquals(raumLaenge, raum.getLaengeInCm());
            assertThrows(RuntimeException.class, () -> raum.setLaengeInCm(-10));
            assertDoesNotThrow(() -> raum.setLaengeInCm(0));
        });
    }

    @Test
    void setGroesse() {
        Assertions.assertAll(() -> {
            assertThrows(RuntimeException.class, () -> raum.setGroesse(-1, -1));
            assertThrows(RuntimeException.class, () -> raum.setGroesse(1, -1));
            assertThrows(RuntimeException.class, () -> raum.setGroesse(-1, 1));
            assertThrows(RuntimeException.class, () -> raum.setGroesse(-1));
            assertAll(() -> {
                assertDoesNotThrow(() -> raum.setGroesse(raumLaengeFuerGroesse, raumBreiteFuerGroesse));
                assertEquals(raumLaengeFuerGroesse, raum.getLaengeInCm());
                assertEquals(raumBreiteFuerGroesse, raum.getBreiteInCm());

                assertDoesNotThrow(() -> raum.setGroesse(raumLaengeFuerGroesse));
                assertEquals(raumLaengeFuerGroesse, raum.getLaengeInCm());
                assertEquals(raumBreiteFuerGroesse, raum.getBreiteInCm());
            });
        });
    }

    @Test
    void getFlaecheInQm() {
        assertAll(() -> {
            assertDoesNotThrow(() -> raum.getFlaecheInQm());
            assertEquals(0.01, raum.getFlaecheInQm());
            raum.setGroesse(20);
            assertEquals(0.04, raum.getFlaecheInQm());
        });
    }
}
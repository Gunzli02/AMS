package de.bs1bt.ams.entitytests;


import de.bs1bt.ams.model.Mitarbeiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MitarbeiterTest {
    @Test
    void setGeburtsdatumTest() {
        Mitarbeiter m = new Mitarbeiter();
        Assertions.assertAll(() -> {
            Assertions.assertThrows(Exception.class, () -> m.setGeburtsDatum("Test"));
            Assertions.assertDoesNotThrow(() -> m.setGeburtsDatum("2022-11-25"));
        });
    }

    @Test
    void getAlterTest() {
        Mitarbeiter m = new Mitarbeiter();
        m.setGeburtsDatum(LocalDate.now().minusYears(20).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Assertions.assertEquals(20, m.getAlter());
    }

    @Test
    void hatRundenGeburtstagTest() {
        Mitarbeiter m = new Mitarbeiter();
        m.setGeburtsDatum(LocalDate.now().minusYears(20).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Assertions.assertTrue(m.hatRundenGeburtstag());
        m.setGeburtsDatum(LocalDate.now().minusYears(21).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Assertions.assertFalse(m.hatRundenGeburtstag());
        m.setGeburtsDatum(LocalDate.now().minusYears(20).minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Assertions.assertFalse(m.hatRundenGeburtstag());
    }
}

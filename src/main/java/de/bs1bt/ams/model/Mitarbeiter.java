package de.bs1bt.ams.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Mitarbeiter {
    private LocalDate geburtsDatum;
    public void setGeburtsDatum(String test) throws DateTimeParseException {
        this.geburtsDatum = LocalDate.parse(test);
    }

    public long getAlter() {
        long alter = ChronoUnit.YEARS.between(geburtsDatum, LocalDate.now());
        return alter;
    }

    public boolean hatRundenGeburtstag() {
        if((getAlter() % 10) == 0) {
            return LocalDate.now().getDayOfMonth() == geburtsDatum.getDayOfMonth()
                    && LocalDate.now().getMonth() == geburtsDatum.getMonth();
        }
        return false;
    }
}

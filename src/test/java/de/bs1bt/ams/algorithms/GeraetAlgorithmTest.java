package de.bs1bt.ams.algorithms;

import de.bs1bt.ams.model.Geraet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GeraetAlgorithmTest {
    List<Geraet> geraetList;
    private final String DRUCKER = "Drucker";
    private final String MONITOR = "Monitor";
    private final String NETZWERKGEREAT = "Netzwerkgerät";

    @BeforeEach
    public void init() {
        geraetList = new ArrayList<>(Arrays.asList(
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(1)
                        .bez(DRUCKER)
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(3)
                        .bez(MONITOR)
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(5)
                        .bez(DRUCKER)
                        .defekt(true)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(7)
                        .bez(MONITOR)
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(8)
                        .bez(NETZWERKGEREAT)
                        .defekt(true)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(12)
                        .bez(DRUCKER)
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(42)
                        .bez(NETZWERKGEREAT)
                        .defekt(false)
                        .build()
        ));
    }
}

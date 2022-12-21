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

    @BeforeEach
    public void init() {
        geraetList = new ArrayList<>(Arrays.asList(
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(1)
                        .bez("Drucker")
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(12)
                        .bez("Drucker")
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(5)
                        .bez("Drucker")
                        .defekt(true)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(3)
                        .bez("Monitor")
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(7)
                        .bez("Monitor")
                        .defekt(false)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(8)
                        .bez("Netzwerkgerät")
                        .defekt(true)
                        .build(),
                Geraet.GeraetBuilder.aGeraet()
                        .inventarNummer(42)
                        .bez("Netzwerkgerät")
                        .defekt(false)
                        .build()
        ));
    }
}

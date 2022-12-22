package de.bs1bt.ams.algorithms;

import de.bs1bt.ams.model.Geraet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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

    @Test
    public void bubbleSortWithStream() {
        ArrayList<Integer> expectedInventarNumbers = new ArrayList(Arrays.asList(1, 3, 5, 7, 8, 12, 42));
        ArrayList<Integer> actualInventarNumbers = new ArrayList<>();

        geraetList.stream()
                .sorted(Comparator.comparingInt(Geraet::getInventarNummer))
                .forEach(geraet -> actualInventarNumbers.add(geraet.getInventarNummer()));

        Assertions.assertEquals(expectedInventarNumbers, actualInventarNumbers);
    }

    @Test
    public List<Geraet> bubbleSortGereatListByBez() {
//        ArrayList<Integer> expectedInventarNumbers = new ArrayList(Arrays.asList(1, 3, 5, 7, 8, 12, 42));
        ArrayList<String> expectedBez = new ArrayList(Arrays.asList(DRUCKER, DRUCKER, DRUCKER, MONITOR, MONITOR, NETZWERKGEREAT, NETZWERKGEREAT));
//        ArrayList<Integer> actualInventarNumbers = new ArrayList<>();
        ArrayList<String> actualBez = new ArrayList<>();

        Geraet currentGereat;

        for (int i = 0; i < geraetList.size() - 1; i++) {
            for (int ii = i + 1; ii < geraetList.size() - 1; ii++) {
                // sort by Inventar-Nummer
//                if (geraetList.get(i).getInventarNummer() > geraetList.get(ii).getInventarNummer()) {
                // sort by Bez
                if (geraetList.get(i).getBez().compareToIgnoreCase(geraetList.get(ii).getBez()) > 0) {
                    currentGereat = geraetList.get(i);
                    geraetList.set(i, geraetList.get(ii));
                    geraetList.set(ii, currentGereat);
                }
            }
        }

//        geraetList.forEach(geraet -> actualInventarNumbers.add(geraet.getInventarNummer()));
        geraetList.forEach(geraet -> actualBez.add(geraet.getBez()));

//        Assertions.assertEquals(expectedInventarNumbers, actualInventarNumbers);
        Assertions.assertEquals(expectedBez, actualBez);

        return geraetList;
    }

    @Test
    public void countByGroupWithGroupSwap(){
        geraetList = bubbleSortGereatListByBez();

        Map<String, Integer> expectedCountValues = Map.of(DRUCKER, 3, MONITOR, 2, NETZWERKGEREAT, 2);
        Map<String, Integer> actualCountValues = new java.util.HashMap<>(Map.of(DRUCKER, 0, MONITOR, 0, NETZWERKGEREAT, 0));

        Map<String, Integer> expectedDefectValues = Map.of(DRUCKER, 1, MONITOR, 0, NETZWERKGEREAT, 1);
        Map<String, Integer> actualDefectValues = new java.util.HashMap<>(Map.of(DRUCKER, 0, MONITOR, 0, NETZWERKGEREAT, 0));


        Integer counter = 0, defectCounter = 0;
        String currentBez = "";

        for (Geraet geraet : geraetList) {
            if(!currentBez.equals(geraet.getBez())) {
                printGroupSortResult(currentBez, counter);
                if (!currentBez.equals("")) {
                    actualCountValues.put(currentBez, counter);
                    actualDefectValues.put(currentBez, defectCounter);
                }
                counter = 0;
                defectCounter = 0;
                currentBez = geraet.getBez();
            }
                counter++;
            if(geraet.getDefekt())
                defectCounter++;
        }
        actualCountValues.put(currentBez, counter);
        printGroupSortResult(currentBez, counter);
        actualDefectValues.put(currentBez, defectCounter);

        Assertions.assertAll(() -> {
            Assertions.assertEquals(expectedCountValues, actualCountValues);
            Assertions.assertEquals(expectedDefectValues, actualDefectValues);
        });
    }

    private void printGroupSortResult(String bez, Integer count){
        if(!bez.equals("") && count > 0)
            System.out.println(bez + ": \t" + count);
    }
}

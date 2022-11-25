package de.bs1bt.ams.model;

import java.util.ArrayList;

public class Gebaeude {
    private String name;
    private ArrayList<Raum> listOfRaeume;

    public Gebaeude(String name, ArrayList<Raum> listOfRaeume) {
        this.name = name;

        listOfRaeume.forEach(raum -> raum.setGebaeude(this.name));

        this.listOfRaeume = listOfRaeume;
    }

    public Gebaeude() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gebaeude addRaum(Raum raum) {
        listOfRaeume.add(raum);
        return this;
    }

    public ArrayList<Raum> getListOfRaeume() {
        return listOfRaeume;
    }


    public Double calculateGesamtFlaeche() {
        Double flaeche = 0d;
        for (Raum raum : listOfRaeume) {
            flaeche += raum.getFlaecheInQm();
        }
        return flaeche;
    }
}

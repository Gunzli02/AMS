package de.bs1bt.ams.gateways;

import de.bs1bt.ams.model.Raum;

import java.util.ArrayList;

public interface InterfaceRaum {
    void erstelleTabelle() throws DAOException;

    void loescheTabelle() throws DAOException;

    Raum hole(int id) throws DAOException;

    ArrayList<Raum> holeAlle() throws DAOException;

    int erstelle(Raum raumModel) throws DAOException;

    void aktualisiere(Raum raumModel) throws DAOException;

    void loesche(int id) throws DAOException;

    void loesche(Raum raumModel) throws DAOException;
}

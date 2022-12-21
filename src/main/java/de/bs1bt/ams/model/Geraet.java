package de.bs1bt.ams.model;

import java.time.LocalDate;

public class Geraet {
    private Integer inventarNummer;
    private String bez;
    private Boolean defekt;
    private LocalDate kaufDatum;
    private String hersteller;
    private String modell;

    private Integer garantieMonat;

    private String standort;


    public Geraet(Integer inventarNummer, String bez, Boolean defekt, LocalDate kaufDatum, String hersteller, String modell, Integer garantieMonat, String standort) {
        this.inventarNummer = inventarNummer;
        this.bez = bez;
        this.defekt = defekt;
        this.kaufDatum = kaufDatum;
        this.hersteller = hersteller;
        this.modell = modell;
        this.garantieMonat = garantieMonat;
        this.standort = standort;
    }

    public Geraet() {

    }

    public Integer getInventarNummer() {
        return inventarNummer;
    }

    public void setInventarNummer(Integer inventarNummer) {
        this.inventarNummer = inventarNummer;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public Boolean getDefekt() {
        return defekt;
    }

    public void setDefekt(Boolean defekt) {
        this.defekt = defekt;
    }

    public LocalDate getKaufDatum() {
        return kaufDatum;
    }

    public void setKaufDatum(LocalDate kaufDatum) {
        this.kaufDatum = kaufDatum;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Integer getGarantieMonat() {
        return garantieMonat;
    }

    public void setGarantieMonat(Integer garantieMonat) throws Exception {
        if (garantieMonat >= 0)
            this.garantieMonat = garantieMonat;
        else
            throw new Exception("Ungültiger Garantiezeitraum");
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public boolean hatGarantie() {
        return kaufDatum.plusMonths(garantieMonat).isAfter(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Geraet{" +
                "bez='" + bez + '\'' +
                ", defekt=" + defekt +
                ", kaufDatum=" + kaufDatum +
                ", hersteller='" + hersteller + '\'' +
                ", modell='" + modell + '\'' +
                ", garantieMonat=" + garantieMonat +
                ", standort='" + standort + '\'' +
                '}';
    }

    public static final class GeraetBuilder {
        private Geraet geraet;

        private GeraetBuilder() {
            geraet = new Geraet();
        }

        public static GeraetBuilder aGeraet() {
            return new GeraetBuilder();
        }

        public GeraetBuilder bez(String bez) {
            geraet.setBez(bez);
            return this;
        }

        public GeraetBuilder inventarNummer(Integer inventarNummer) {
            geraet.setInventarNummer(inventarNummer);
            return this;
        }

        public GeraetBuilder defekt(Boolean defekt) {
            geraet.setDefekt(defekt);
            return this;
        }

        public GeraetBuilder kaufDatum(LocalDate kaufDatum) {
            geraet.setKaufDatum(kaufDatum);
            return this;
        }

        public GeraetBuilder hersteller(String hersteller) {
            geraet.setHersteller(hersteller);
            return this;
        }

        public GeraetBuilder modell(String modell) {
            geraet.setModell(modell);
            return this;
        }

        public GeraetBuilder garantieMonat(Integer garantieMonat) {
            try {
                geraet.setGarantieMonat(garantieMonat);
            } catch (Exception ignored) {

            }
            return this;
        }

        public GeraetBuilder standort(String standort) {
            geraet.setStandort(standort);
            return this;
        }

        public Geraet build() {
            return geraet;
        }
    }
}

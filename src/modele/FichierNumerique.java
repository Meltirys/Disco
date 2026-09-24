package modele;

import java.time.LocalDate;

public class FichierNumerique extends Album{

    String format;
    Double taille;
    Integer duree;

    public FichierNumerique(String nom, String artiste, LocalDate date, int qte, String format, Double taille, Integer duree) {
        super(nom, artiste, date, qte);
        this.format = format;
        this.taille = taille;
        this.duree = duree;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Override
    public String getSupport() {
        return "";
    }
}

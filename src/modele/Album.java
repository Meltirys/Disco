package modele;

import java.time.LocalDate;

public abstract class Album {
    protected String nom;
    protected String artiste;
    protected LocalDate Date;
    protected int qte;

    public Album(String nom, String artiste, LocalDate date, int qte) {
        this.nom = nom;
        this.artiste = artiste;
        Date = date;
        this.qte = qte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nom='" + nom + '\'' +
                ", artiste='" + artiste + '\'' +
                ", Date=" + Date +
                ", qte=" + qte +
                '}';
    }

    public abstract String getSupport();
}

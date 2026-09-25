package modele;

import java.time.LocalDate;

public class DisqueVinyle extends Album{

    String numero;
    Integer taille;

    public DisqueVinyle(String nom, String artiste, LocalDate date, int qte, String numero, Integer taille) {
        super(nom, artiste, date, qte);
        this.numero = numero;
        this.taille = taille;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }



    @Override
    public String getSupport() {
        return "Vinyle";
    }
}

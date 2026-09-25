package modele;

import java.time.LocalDate;

public class CompactDisque extends Album{

    String numero;
    String type;

    public CompactDisque(String nom, String artiste, LocalDate date, int qte, String numero, String type) {
        super(nom, artiste, date, qte);
        this.numero = numero;
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getSupport() {
        return "CD";
    }
}

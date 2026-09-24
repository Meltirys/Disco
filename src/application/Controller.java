package application;

import exceptions.AlbumDejaExistantException;
import exceptions.DiscothequeVideException;
import modele.CompactDisque;
import modele.Discotheque;
import modele.DisqueVinyle;
import modele.FichierNumerique;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Controller {

    static Scanner scan = new Scanner(System.in);

    public void afficherMenu() {
        System.out.println("==== Menu principal ====");
        System.out.println("1. Ajouter un album");
        System.out.println("2. Lister tous les albums");
        System.out.println("3. Rechercher un album");
        System.out.println("4. Supprimer un album");
        System.out.println("0. Quitter");
        System.out.println("========================");

    }

    public void ajouterAlbum() throws AlbumDejaExistantException{

        scan.nextLine();
        System.out.println("Veuillez définir le type");
        int genre = scan.nextInt();
        scan.nextLine();
        System.out.println("Veuillez saisir le nom");
        String nom = scan.nextLine();
        System.out.println("Veuillez saisir l'auteur ou artiste");
        String aut = scan.nextLine();
        System.out.println("Veuillez saisir l'année de parution");
        String date = scan.nextLine();
        System.out.println("Veuillez saisir la quantité");
        int qt = scan.nextInt();
        scan.nextLine();
        try {
            LocalDate datef = creerDate(date);
            // Écriture d'un switch case pour le type d'objet créer
            switch (genre) {
                case 1: {
                    System.out.println("Veuillez saisir le numéro du cd");
                    String numero = scan.nextLine();
                    System.out.println("Veuillez saisir le type (simple, double ou plus)");
                    String type = scan.nextLine();
                    CompactDisque cd = new CompactDisque(nom, aut, datef, qt, numero, type);
                    Discotheque.ajouterAlbum(cd);
                    break;
                }
                case 2: {
                    System.out.println("Veuillez saisir le numéro du vinyle");
                    String numero = scan.nextLine();
                    System.out.println("Veuillez saisir la taille du vinyle");
                    Integer taille = scan.nextInt();
                    DisqueVinyle vin = new DisqueVinyle(nom, aut, datef, qt, numero, taille);
                    Discotheque.ajouterAlbum(vin);
                    break;
                }
                case 3: {
                    System.out.println("Veuillez saisir le format du fichier");
                    String form = scan.nextLine();
                    System.out.println("Veuillez saisir la taille du fichier");
                    Double taille = scan.nextDouble();
                    System.out.println("Veuillez saisir la durée du fichier");
                    Integer duree = scan.nextInt();
                    FichierNumerique fn = new FichierNumerique(nom, aut, datef, qt, form, taille, duree);
                    Discotheque.ajouterAlbum(fn);
                    break;
                }


            }
        } catch (DateTimeParseException | AlbumDejaExistantException e) {
            System.out.println("Le format est invalide");
        }


    }

    public LocalDate creerDate(String date) throws DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datef = LocalDate.parse(date, formatter);

        return datef;
    }

    public void retirerAlbum() {

    }

    public void afficherAlbums() throws DiscothequeVideException {

        Discotheque.listerAlbums();
    }
}

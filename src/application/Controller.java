package application;

import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;
import modele.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import exceptions.AlbumDejaExistantException;
import exceptions.SaisieInvalideException;
import modele.Album;
import modele.Discotheque;

import java.util.Scanner;


public class Controller {

    static Scanner scan = new Scanner(System.in);
    Discotheque discotheque = new Discotheque();

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
        System.out.println(" 1. CD; 2. Vinyle; 3. Format numérique");
        int genre = scan.nextInt();
        scan.nextLine();
        System.out.println("Veuillez saisir le nom");
        String nom = scan.nextLine();
        System.out.println("Veuillez saisir l'auteur ou artiste");
        String aut = scan.nextLine();
        System.out.println("Veuillez saisir l'année de parution au format dd/MM/yyyy");
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

    public  void rechercheAlbum() throws AlbumIntrouvableException, DiscothequeVideException{
        scan.nextLine();
        System.out.println("Veuillez saisir le nom");
        String nom = scan.nextLine();
        Album trouve = Discotheque.rechercherAlbum(nom);
        System.out.println(trouve.getNom());

    }

    public LocalDate creerDate(String date) throws DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datef = LocalDate.parse(date, formatter);

        return datef;
    }

    public void retirerAlbum() throws DiscothequeVideException, AlbumIntrouvableException {

        scan.nextLine();
        System.out.println("Veuillez saisir le nom de l'album");
        String nom = scan.nextLine();
        Discotheque.supprimerAlbum(nom);

    }

    public void afficherAlbums() throws DiscothequeVideException {

        Discotheque.listerAlbums();
    }

    public String saisieNomAlbum() throws SaisieInvalideException {
        scan.nextLine();
        System.out.println("Saisir le nom de l'album : ");
        String nomAlbum = scan.nextLine();

        if (nomAlbum.isEmpty()){
            throw new SaisieInvalideException("Merci de saisir le nom");
        }
        return nomAlbum;
    }


    }


package application;

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


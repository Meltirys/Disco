package application;

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
}

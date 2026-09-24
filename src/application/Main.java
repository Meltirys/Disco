package application;

public class Main {

    public static void main(String[] args) {

        Controller c = new Controller();

        int choix=0;

        do {
            try {
                c.afficherMenu();
                System.out.print("Choix:");
                choix = Controller.scan.nextInt();

                switch (choix) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 0:
                        System.out.println("Fin du programme. Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

                System.out.println();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        } while (choix != 0);

        Controller.scan.close();

    }

}

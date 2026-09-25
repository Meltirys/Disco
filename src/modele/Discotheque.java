package modele;

import exceptions.AlbumDejaExistantException;
import exceptions.AlbumIntrouvableException;
import exceptions.DiscothequeVideException;

import java.util.ArrayList;

public class Discotheque {

        private static ArrayList<Album> discotheque = new ArrayList<>();

        public static void ajouterAlbum (Album a) throws AlbumDejaExistantException {
            // ajouter un album à la discotheque

            int compteur = 0;
            for(Album al : discotheque){
                if(al.getNom().equals(a.getNom())){
                    compteur++;
                }
            }
            if(compteur>=1){
                throw new AlbumDejaExistantException("Album déjà existant");
            }else{
                discotheque.add(a);
                System.out.println("Album ajouté la discotheque");
            }


        }

        public static void listerAlbums() throws DiscothequeVideException {
            if(discotheque.size()<1){
                throw new DiscothequeVideException("discothèque vide");
            }else{
                System.out.println(discotheque);
            }

        }

        public static Album rechercherAlbum(String nom) throws AlbumIntrouvableException,DiscothequeVideException {
            Album trouve = null;
            for (Album a : discotheque) {
                if (a.getNom().equals(nom)) {
                    trouve = a;
                    break;
                }
            }
            if(trouve==null){
                throw new AlbumIntrouvableException("Album non trouvé");
            }
            if(discotheque.size()<1){
                throw new DiscothequeVideException("Discothèque vide");
            }
            return trouve;
        }

        public static void supprimerAlbum(String nom) throws AlbumIntrouvableException, DiscothequeVideException{
            Album trouve = null;
            for (Album a : discotheque) {
                if (a.getNom().equals(nom)) {
                    trouve = a;
                    break;
                }
            }
            if(discotheque.size() < 1) {
                throw new DiscothequeVideException("La discothèque est vide!");
            }

            if (trouve == null){
                throw new AlbumIntrouvableException("Disque non trouvé");
            }
                System.out.println("album trouvé !");
                discotheque.remove(trouve);
                System.out.println("Album supprimé de la discothèque");

        }

    }



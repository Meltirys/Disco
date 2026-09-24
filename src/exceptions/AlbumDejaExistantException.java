package exceptions;

import modele.Album;

public class AlbumDejaExistantException extends Exception{
    public AlbumDejaExistantException(String message){
        super(message);
    }
}

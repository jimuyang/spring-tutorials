package hello.storage;

public class StorageException extends RuntimeException{

    public StorageException(String message){
        super("muyi's StorageException: " + message);
    }

    public StorageException(String message,Throwable cause){
        super("muyi's StorageException: " + message, cause);
    }

}
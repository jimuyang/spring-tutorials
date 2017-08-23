package hello.storage;

public class StorageFileNotFoundException extends StorageException{

    public StorageFileNotFoundException(String message){
        super("FileNotFound" + message);
    }

     public StorageFileNotFoundException(String message, Throwable cause) {
        super("FileNotFound" + message, cause);
    }


}
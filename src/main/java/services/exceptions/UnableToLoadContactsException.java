package services.exceptions;

public class UnableToLoadContactsException extends Exception{
    public UnableToLoadContactsException(Exception technicalException) {
        initCause(technicalException);
    }

}

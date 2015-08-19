package org.talentboost.customExceptions;

/**
 * This exception stop the program
 * @author Antonio
 *
 */
public class ApplicationErrorException extends Exception{
    public ApplicationErrorException(String message) {
        super(message);
    }

    public ApplicationErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}

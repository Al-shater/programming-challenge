package de.exxcellent.challenge.Exceptions;

/**
 * @author Yassin Alshater <mhdalshater@gmail.com>
 */
public class ColumnNotFoundException extends Exception{
    /**
     *
     * @param message for the user
     */
    public ColumnNotFoundException(String message){
        super(message);
    }
}

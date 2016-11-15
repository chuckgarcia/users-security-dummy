package mx.charly.userssecurity.commons.mx.charly.userssecurity.exceptions;

/**
 * @author Risko
 * @since 13/11/2016.
 */
public class DaoException extends RuntimeException{
    public DaoException (String msg, Throwable cause) {
        super(msg,cause);
    }
}

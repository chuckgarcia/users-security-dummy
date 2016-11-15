package mx.charly.userssecurity.commons.mx.charly.userssecurity.exceptions;

/**
 * @author Risko
 * @since 13/11/2016.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String msg, Throwable cause){
        super(msg, cause);
    }
}

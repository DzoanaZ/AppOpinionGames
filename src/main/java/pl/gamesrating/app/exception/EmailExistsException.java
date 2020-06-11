package pl.gamesrating.app.exception;

public class EmailExistsException extends Throwable {
    public EmailExistsException (String s){
        super(s);
    }
}

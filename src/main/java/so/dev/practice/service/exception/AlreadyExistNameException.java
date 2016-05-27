package so.dev.practice.service.exception;

/**
 * Created by melvin on 2016. 5. 24..
 */
public class AlreadyExistNameException extends Exception {

    public AlreadyExistNameException(String msg){
        super(msg);
    }

    public AlreadyExistNameException(){
        super("AlreadyExistNameException");
    }
}

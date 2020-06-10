package lv.proofit.service.validation.object;

public class ObjectValidationException extends RuntimeException{

    public ObjectValidationException(String message) {
        super(message);
    }

    public ObjectValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

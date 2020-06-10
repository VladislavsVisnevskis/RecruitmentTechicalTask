package lv.proofit.service.validation.subobject;

public class SubObjectValidationException extends RuntimeException{

    public SubObjectValidationException(String message) {
        super(message);
    }

    public SubObjectValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

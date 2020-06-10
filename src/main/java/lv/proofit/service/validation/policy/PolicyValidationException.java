package lv.proofit.service.validation.policy;

public class PolicyValidationException extends RuntimeException{

    public PolicyValidationException(String message) {
        super(message);
    }

    public PolicyValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

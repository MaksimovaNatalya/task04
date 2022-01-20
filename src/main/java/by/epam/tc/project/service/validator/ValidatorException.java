package by.epam.tc.project.service.validator;

public class ValidatorException extends Exception {

    public ValidatorException() {
        super();
    }

    public ValidatorException(String message) {
        super("ERROR: " + message);
    }

    public ValidatorException(Exception e) {
        super(e);
    }

    public ValidatorException(String message, Exception e) {
        super("ERROR: " + message, e);
    }

    @Override
    public String getMessage() {

        return super.getMessage();
    }

}
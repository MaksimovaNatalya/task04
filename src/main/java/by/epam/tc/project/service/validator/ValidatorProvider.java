package by.epam.tc.project.service.validator;

public class ValidatorProvider {

    private static final ValidatorProvider instance = new ValidatorProvider();

    private final UserValidator userValidator = new UserValidator();


    private ValidatorProvider() {
    }

    public static ValidatorProvider getInstance() {
        return instance;
    }

    public UserValidator getUserValidator() {
        return userValidator;
    }
}
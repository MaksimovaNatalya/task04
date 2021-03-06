package by.epam.tc.project.service.validator;

import by.epam.tc.project.entity.User;

public class UserValidator {
    private static final String LOGIN_CHECK = "^[a-zA-Z0-9_-]{3,200}$";
    private static final String PASSWORD_CHECK = "^.{3,15}$";
    private static final String NAME_CHECK = "^[a-zA-Zа-яА-ЯёЁ-]{3,45}$";
    private static final String COUNTRY_CHECK = "^[a-zA-Zа-яА-ЯёЁ-]{2,45}$";
    private static final String EMAIL_CHECK = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w]+$";
    private static final String TELNUMBER_CHECK = "^[0-9-+()]{5,20}$";

    public void checkRegistrationInfo(User user) throws ValidatorException {
        String login = user.getLogin();
        String password = user.getPassword();
        String name = user.getName();
        String surName = user.getSurname();
        String eMail = user.getEmail();
        String country = user.getCountry();
        String telNumber = user.getPhone();

        if (!login.matches(LOGIN_CHECK)) {
            throw new ValidatorException("Invalid login!");
        }

        if (!password.matches(PASSWORD_CHECK)) {
            throw new ValidatorException("Invalid password!");
        }

        validate(name, surName, eMail, country, telNumber);

    }

    public void checkRegistrationInfo(String newLogin, String name, String surname, String email, String country,
                                      String phone, String login) throws ValidatorException {

        if (!newLogin.matches(LOGIN_CHECK)) {
            throw new ValidatorException("Invalid login!");
        }

        if (!login.matches(LOGIN_CHECK)) {
            throw new ValidatorException("Invalid login!");
        }

        validate(name, surname, email, country, phone);
    }

    private void validate(String name, String surName, String eMail, String country, String telNumber) throws ValidatorException {
//        if (!name.matches(NAME_CHECK)) {
//            throw new ValidatorException("Invalid name!");
//        }

        if (!surName.isEmpty()) {
            if (!surName.matches(NAME_CHECK)) {
                throw new ValidatorException("Invalid surName!");
            }
        }

        if (!eMail.isEmpty()) {
            if (!eMail.matches(EMAIL_CHECK)) {
                throw new ValidatorException("Invalid email!");
            }
        }

        if (!country.isEmpty()) {
            if (!country.matches(COUNTRY_CHECK)) {
                throw new ValidatorException("Invalid name of the country!");
            }
        }

        if (!telNumber.isEmpty()) {
            if (!telNumber.matches(TELNUMBER_CHECK)) {
                throw new ValidatorException("Invalid telNumber!");
            }
        }
    }


}

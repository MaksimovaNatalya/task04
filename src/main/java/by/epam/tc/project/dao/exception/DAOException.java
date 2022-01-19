package by.epam.tc.project.dao.exception;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }
}

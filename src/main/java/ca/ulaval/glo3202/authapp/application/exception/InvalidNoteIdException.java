package ca.ulaval.glo3202.authapp.application.exception;

public class InvalidNoteIdException extends DomainException {
    private static final String ERROR_CODE = "INVALID_NOTE_ID";
    private static final String MESSAGE = "The id of the note you try to delete is invalid";

    public InvalidNoteIdException() {
        super(ERROR_CODE, MESSAGE);
    }
}


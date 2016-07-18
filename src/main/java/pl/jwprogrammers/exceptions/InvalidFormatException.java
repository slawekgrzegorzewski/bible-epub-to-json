package pl.jwprogrammers.exceptions;

public class InvalidFormatException extends Exception {
    private final String entryKind;

    public InvalidFormatException(String entryKind) {
        this.entryKind = entryKind;
    }

    @Override
    public String getMessage() {
        return "Entry " + entryKind + " is in invalid format." + super.getMessage();
    }
}

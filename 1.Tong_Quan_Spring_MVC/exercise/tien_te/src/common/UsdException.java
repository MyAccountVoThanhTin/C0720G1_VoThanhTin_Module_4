package common;

public class UsdException extends Exception {
    private String message;

    public UsdException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

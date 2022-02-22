package org.code.challenger.exception;

public class AppException extends Exception {

    public AppException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "CodeChallengerException: " + getMessage();
    }
}

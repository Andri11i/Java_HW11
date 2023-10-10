package org.example;

public enum Messages {

    PLEASE_ENTER_FILE_NAME("please enter file name"),
    FILE_NOT_FOUND("file not found, please type it again"),
    EXIT("do you want to exit  y/n :-)?"),
    INTERNAL_ERROR("Internal error, app will be closed, bye");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

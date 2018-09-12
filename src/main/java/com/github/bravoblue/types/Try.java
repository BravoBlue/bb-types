package com.github.bravoblue.types;


public class Try<T> {

    private final Throwable cause;
    private final T value;

    private Try(Throwable cause, T right) {
        this.value = right;
        this.cause = cause;
    }

    public static <T> Try<T> succes(T value) {
        return new Try(null, value);
    }

    public static <T> Try<T> fail(Throwable cause) {
        return new Try(cause, null);
    }

    public boolean isSuccess() {
        return value != null;
    }

    public boolean isFail() {
        return cause != null;
    }

    public String toString() {
        if (isFail()) {
            return "Fail(" + cause.getMessage() + ")";
        }
        return "Succes(" + value + ")";
    }

}

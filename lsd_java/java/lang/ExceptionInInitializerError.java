/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class ExceptionInInitializerError
extends LinkageError {
    private static final long serialVersionUID;
    private Throwable exception;

    public ExceptionInInitializerError() {
        this.initCause(null);
    }

    public ExceptionInInitializerError(String string) {
        super(string);
        this.initCause(null);
    }

    public ExceptionInInitializerError(Throwable throwable) {
        this.exception = throwable;
        this.initCause(throwable);
    }

    public Throwable getException() {
        return this.exception;
    }

    @Override
    public Throwable getCause() {
        return this.exception;
    }
}


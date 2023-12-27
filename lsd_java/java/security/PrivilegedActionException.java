/*
 * Decompiled with CFR 0.152.
 */
package java.security;

public class PrivilegedActionException
extends Exception {
    private static final long serialVersionUID;
    private Exception exception;

    public PrivilegedActionException(Exception exception) {
        super(null, exception);
        this.exception = exception;
    }

    public Exception getException() {
        return this.exception;
    }

    @Override
    public String toString() {
        return new StringBuffer(String.valueOf(super.toString())).append(": ").append(this.exception).toString();
    }

    @Override
    public Throwable getCause() {
        return this.exception;
    }
}


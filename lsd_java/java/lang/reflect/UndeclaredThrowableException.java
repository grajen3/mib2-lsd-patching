/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

public class UndeclaredThrowableException
extends RuntimeException {
    private static final long serialVersionUID;
    private Throwable undeclaredThrowable;

    public UndeclaredThrowableException(Throwable throwable) {
        this.undeclaredThrowable = throwable;
        this.initCause(throwable);
    }

    public UndeclaredThrowableException(Throwable throwable, String string) {
        super(string);
        this.undeclaredThrowable = throwable;
        this.initCause(throwable);
    }

    public Throwable getUndeclaredThrowable() {
        return this.undeclaredThrowable;
    }

    @Override
    public Throwable getCause() {
        return this.undeclaredThrowable;
    }
}


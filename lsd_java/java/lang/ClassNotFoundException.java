/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class ClassNotFoundException
extends Exception {
    private static final long serialVersionUID;
    private Throwable ex;

    public ClassNotFoundException() {
        super((Throwable)null);
    }

    public ClassNotFoundException(String string) {
        super(string, null);
    }

    public ClassNotFoundException(String string, Throwable throwable) {
        super(string);
        this.ex = throwable;
    }

    public Throwable getException() {
        return this.ex;
    }

    @Override
    public Throwable getCause() {
        return this.ex;
    }
}


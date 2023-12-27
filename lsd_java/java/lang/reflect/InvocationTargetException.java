/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

public class InvocationTargetException
extends Exception {
    private static final long serialVersionUID;
    private Throwable target;

    protected InvocationTargetException() {
        super((Throwable)null);
    }

    public InvocationTargetException(Throwable throwable) {
        super(null, throwable);
        this.target = throwable;
    }

    public InvocationTargetException(Throwable throwable, String string) {
        super(string, throwable);
        this.target = throwable;
    }

    public Throwable getTargetException() {
        return this.target;
    }

    @Override
    public Throwable getCause() {
        return this.target;
    }
}


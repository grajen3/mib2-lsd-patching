/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class RuntimeException
extends Exception {
    private static final long serialVersionUID;

    public RuntimeException() {
    }

    public RuntimeException(String string) {
        super(string);
    }

    public RuntimeException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public RuntimeException(Throwable throwable) {
        super(throwable);
    }
}


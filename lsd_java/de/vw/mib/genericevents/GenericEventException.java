/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

public final class GenericEventException
extends Exception {
    private static final long serialVersionUID;
    private final int code;

    public GenericEventException(int n, String string, Throwable throwable) {
        super(string, throwable);
        this.code = n;
    }

    public GenericEventException(int n, String string) {
        super(string);
        this.code = n;
    }

    public GenericEventException(int n, Throwable throwable) {
        super(throwable);
        this.code = n;
    }

    public GenericEventException(String string, Throwable throwable) {
        super(string, throwable);
        this.code = 0;
    }

    public GenericEventException(String string) {
        super(string);
        this.code = 0;
    }

    public GenericEventException(Throwable throwable) {
        super(throwable);
        this.code = 0;
    }

    public int getCode() {
        return this.code;
    }
}


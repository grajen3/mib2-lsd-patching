/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

public class CollectionOverflowException
extends RuntimeException {
    private static final long serialVersionUID;

    public CollectionOverflowException() {
    }

    public CollectionOverflowException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public CollectionOverflowException(String string) {
        super(string);
    }

    public CollectionOverflowException(Throwable throwable) {
        super(throwable);
    }
}


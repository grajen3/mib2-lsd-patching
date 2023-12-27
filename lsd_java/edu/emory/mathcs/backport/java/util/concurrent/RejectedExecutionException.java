/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

public class RejectedExecutionException
extends RuntimeException {
    private static final long serialVersionUID;

    public RejectedExecutionException() {
    }

    public RejectedExecutionException(String string) {
        super(string);
    }

    public RejectedExecutionException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public RejectedExecutionException(Throwable throwable) {
        super(throwable);
    }
}


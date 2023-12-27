/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

public class ExecutionException
extends Exception {
    private static final long serialVersionUID;

    protected ExecutionException() {
    }

    protected ExecutionException(String string) {
        super(string);
    }

    public ExecutionException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ExecutionException(Throwable throwable) {
        super(throwable);
    }
}


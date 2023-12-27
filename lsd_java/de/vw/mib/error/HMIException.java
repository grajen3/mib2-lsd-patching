/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error;

public class HMIException
extends RuntimeException {
    private static final long serialVersionUID;

    public HMIException() {
    }

    public HMIException(String string) {
        super(string);
    }

    public HMIException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public HMIException(Throwable throwable) {
        super(throwable);
    }
}


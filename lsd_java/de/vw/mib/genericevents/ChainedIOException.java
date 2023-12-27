/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import java.io.IOException;

public class ChainedIOException
extends IOException {
    private static final long serialVersionUID;

    public ChainedIOException(Throwable throwable) {
        this.initCause(throwable);
    }

    public ChainedIOException(String string, Throwable throwable) {
        super(string);
        this.initCause(throwable);
    }
}


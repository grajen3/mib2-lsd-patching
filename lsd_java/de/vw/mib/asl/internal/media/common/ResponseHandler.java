/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

public abstract class ResponseHandler {
    public static final int ABORTED;
    public static final int SUCCESS;
    public static final int ERROR;

    public abstract void handleResponse(int n, String string) {
    }

    public abstract boolean isValid() {
    }
}


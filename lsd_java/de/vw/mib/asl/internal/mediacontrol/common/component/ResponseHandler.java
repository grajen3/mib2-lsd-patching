/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.component;

public abstract class ResponseHandler {
    public static final int ABORTED;
    public static final int SUCCESS;
    public static final int ERROR;
    private boolean mTimedOut = false;

    public abstract void handleResponse(int n, String string) {
    }

    public void timeout() {
        this.mTimedOut = true;
    }

    public boolean isTimedOut() {
        return this.mTimedOut;
    }
}


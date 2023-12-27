/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

public interface HASContextStates {
    public static final int STATE_UNAVAILABLE;
    public static final int STATE_INITIALIZING;
    public static final int STATE_READY;
    public static final int STATE_TEMP_UNAVAILABLE;
    public static final int STATE_ERROR;
    public static final int STATE_SUSPENDED;

    default public void updateContextState(String string, int n) {
    }

    default public int getContextState(String string) {
    }
}


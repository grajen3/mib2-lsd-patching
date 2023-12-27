/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi;

import de.vw.mib.asl.clientapi.ASLClientAPIStateListener;

public interface ASLClientAPI {
    public static final int API_STATE_UNKNOWN;
    public static final int API_STATE_CONNECTED;

    default public int getAPIState() {
    }

    default public void subscribeAPIState(ASLClientAPIStateListener aSLClientAPIStateListener) {
    }

    default public void unsubscribeAPIState(ASLClientAPIStateListener aSLClientAPIStateListener) {
    }
}


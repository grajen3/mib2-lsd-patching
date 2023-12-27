/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi;

import de.vw.mib.asl.clientapi.ASLClientAPIListener;

public interface ASLClientAPIAttributes {
    default public void subscribe(ASLClientAPIListener aSLClientAPIListener, int n) {
    }

    default public void subscribeAll(ASLClientAPIListener aSLClientAPIListener) {
    }

    default public void unsubscribe(ASLClientAPIListener aSLClientAPIListener, int n) {
    }

    default public void unsubscribeAll(ASLClientAPIListener aSLClientAPIListener) {
    }
}


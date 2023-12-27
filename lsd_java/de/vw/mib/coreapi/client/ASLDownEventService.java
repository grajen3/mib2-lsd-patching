/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.coreapi.client;

import de.vw.mib.coreapi.ASLDownEvent;

public interface ASLDownEventService {
    default public ASLDownEvent createASLDownEvent(int n) {
    }

    default public void sendASLDownEvent(ASLDownEvent aSLDownEvent) {
    }
}


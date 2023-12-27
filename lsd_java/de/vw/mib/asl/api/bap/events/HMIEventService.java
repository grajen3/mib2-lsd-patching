/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.events;

import de.vw.mib.asl.api.bap.events.HMIEventListener;

public interface HMIEventService {
    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }
}


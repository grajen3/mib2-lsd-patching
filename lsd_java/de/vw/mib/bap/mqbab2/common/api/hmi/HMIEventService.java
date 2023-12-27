/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.hmi;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;

public interface HMIEventService {
    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }
}


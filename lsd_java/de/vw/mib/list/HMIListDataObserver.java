/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListDataUpdate;

public interface HMIListDataObserver {
    default public void onUpdate(HMIListDataUpdate hMIListDataUpdate) {
    }
}


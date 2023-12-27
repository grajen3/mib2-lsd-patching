/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataProvider;

public interface HMIListRegistry {
    default public HMIList getHMIList(Object object) {
    }

    default public void setHMIListDataProvider(Object object, HMIListDataProvider hMIListDataProvider) {
    }
}


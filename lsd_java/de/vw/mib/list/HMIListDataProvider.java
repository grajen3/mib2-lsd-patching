/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListState;

public interface HMIListDataProvider
extends HMIListState {
    default public void fillItems(int n, Object[] objectArray) {
    }

    default public void setObserver(HMIListDataObserver hMIListDataObserver) {
    }
}


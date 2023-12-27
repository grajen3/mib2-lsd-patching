/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.impl.HMIListDataUpdateComp$SingleIntUpdate;

class HMIListDataUpdateComp$SetState {
    static final int TYPE;

    HMIListDataUpdateComp$SetState() {
    }

    static HMIListDataUpdateComp$SingleIntUpdate create(int n) {
        return HMIListDataUpdateComp$SingleIntUpdate.create(5, n);
    }
}


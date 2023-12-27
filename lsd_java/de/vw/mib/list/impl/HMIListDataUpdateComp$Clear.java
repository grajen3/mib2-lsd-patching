/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;

class HMIListDataUpdateComp$Clear
extends HMIListDataUpdateComp$AbstractUpdate {
    private static final HMIListDataUpdateComp$Clear INSTANCE = new HMIListDataUpdateComp$Clear();
    static final int TYPE;

    HMIListDataUpdateComp$Clear() {
    }

    static HMIListDataUpdateComp$Clear create() {
        return INSTANCE;
    }

    @Override
    void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        hMIListDataManipulator.clear();
    }

    @Override
    void acceptObserver(HMIListObserver hMIListObserver) {
        hMIListObserver.sizeChanged(0);
    }

    @Override
    int getType() {
        return 0;
    }

    @Override
    public void release() {
    }
}


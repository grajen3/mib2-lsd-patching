/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;
import de.vw.mib.pool.PoorMansPool;

class HMIListDataUpdateComp$SetStringIndex
extends HMIListDataUpdateComp$AbstractUpdate {
    static final int TYPE;
    private static final int MAX_POOL_ITEMS;
    private static final PoorMansPool POOL;
    private StringIndex stringIndex;

    HMIListDataUpdateComp$SetStringIndex() {
    }

    private static HMIListDataUpdateComp$SetStringIndex borrow() {
        HMIListDataUpdateComp$SetStringIndex hMIListDataUpdateComp$SetStringIndex = (HMIListDataUpdateComp$SetStringIndex)POOL.borrow();
        if (null == hMIListDataUpdateComp$SetStringIndex) {
            hMIListDataUpdateComp$SetStringIndex = new HMIListDataUpdateComp$SetStringIndex();
        }
        return hMIListDataUpdateComp$SetStringIndex;
    }

    static HMIListDataUpdateComp$SetStringIndex create(StringIndex stringIndex) {
        HMIListDataUpdateComp$SetStringIndex hMIListDataUpdateComp$SetStringIndex = HMIListDataUpdateComp$SetStringIndex.borrow();
        hMIListDataUpdateComp$SetStringIndex.stringIndex = stringIndex;
        return hMIListDataUpdateComp$SetStringIndex;
    }

    @Override
    void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        hMIListDataManipulator.setStringIndex(this.stringIndex);
    }

    @Override
    void acceptObserver(HMIListObserver hMIListObserver) {
        hMIListObserver.stringIndexChanged();
    }

    @Override
    int getType() {
        return 6;
    }

    @Override
    public void release() {
        this.stringIndex = null;
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HMIList.DataUpdateComp.SetStringIndex", 10);
    }
}


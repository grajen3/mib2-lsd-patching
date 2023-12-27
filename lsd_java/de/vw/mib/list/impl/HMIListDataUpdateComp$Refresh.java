/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;
import de.vw.mib.pool.PoorMansPool;

class HMIListDataUpdateComp$Refresh
extends HMIListDataUpdateComp$AbstractUpdate {
    static final int TYPE;
    private static final int MAX_POOL_ITEMS;
    private static final PoorMansPool POOL;
    int index;
    int count;

    HMIListDataUpdateComp$Refresh() {
    }

    private static HMIListDataUpdateComp$Refresh borrow() {
        HMIListDataUpdateComp$Refresh hMIListDataUpdateComp$Refresh = (HMIListDataUpdateComp$Refresh)POOL.borrow();
        if (null == hMIListDataUpdateComp$Refresh) {
            hMIListDataUpdateComp$Refresh = new HMIListDataUpdateComp$Refresh();
        }
        return hMIListDataUpdateComp$Refresh;
    }

    static HMIListDataUpdateComp$Refresh create(int n, int n2) {
        HMIListDataUpdateComp$Refresh hMIListDataUpdateComp$Refresh = HMIListDataUpdateComp$Refresh.borrow();
        hMIListDataUpdateComp$Refresh.index = n;
        hMIListDataUpdateComp$Refresh.count = n2;
        return hMIListDataUpdateComp$Refresh;
    }

    @Override
    void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        hMIListDataManipulator.refresh(this.index, this.count);
    }

    @Override
    void acceptObserver(HMIListObserver hMIListObserver) {
    }

    @Override
    int getType() {
        return 1;
    }

    @Override
    public void release() {
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HMIList.DataUpdateComp.Refresh", 10);
    }
}


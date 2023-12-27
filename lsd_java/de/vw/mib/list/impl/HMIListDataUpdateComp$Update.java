/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;
import de.vw.mib.pool.PoorMansPool;

class HMIListDataUpdateComp$Update
extends HMIListDataUpdateComp$AbstractUpdate {
    static final int TYPE;
    private static final int MAX_POOL_ITEMS;
    private static final PoorMansPool POOL;
    int index;
    private Object[] items;

    HMIListDataUpdateComp$Update() {
    }

    private static HMIListDataUpdateComp$Update borrow() {
        HMIListDataUpdateComp$Update hMIListDataUpdateComp$Update = (HMIListDataUpdateComp$Update)POOL.borrow();
        if (null == hMIListDataUpdateComp$Update) {
            hMIListDataUpdateComp$Update = new HMIListDataUpdateComp$Update();
        }
        return hMIListDataUpdateComp$Update;
    }

    static HMIListDataUpdateComp$Update create(int n, Object[] objectArray) {
        HMIListDataUpdateComp$Update hMIListDataUpdateComp$Update = HMIListDataUpdateComp$Update.borrow();
        hMIListDataUpdateComp$Update.index = n;
        hMIListDataUpdateComp$Update.items = objectArray;
        return hMIListDataUpdateComp$Update;
    }

    @Override
    void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        hMIListDataManipulator.update(this.index, this.items);
    }

    @Override
    void acceptObserver(HMIListObserver hMIListObserver) {
        hMIListObserver.itemsChanged(this.index, this.items.length);
    }

    @Override
    int getType() {
        return 7;
    }

    @Override
    public void release() {
        this.items = null;
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HMIList.DataUpdateComp.Update", 10);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;
import de.vw.mib.pool.PoorMansPool;

class HMIListDataUpdateComp$SetContent
extends HMIListDataUpdateComp$AbstractUpdate {
    static final int TYPE;
    private static final int MAX_POOL_ITEMS;
    private static final PoorMansPool POOL;
    private Object[] items;

    HMIListDataUpdateComp$SetContent() {
    }

    private static HMIListDataUpdateComp$SetContent borrow() {
        HMIListDataUpdateComp$SetContent hMIListDataUpdateComp$SetContent = (HMIListDataUpdateComp$SetContent)POOL.borrow();
        if (null == hMIListDataUpdateComp$SetContent) {
            hMIListDataUpdateComp$SetContent = new HMIListDataUpdateComp$SetContent();
        }
        return hMIListDataUpdateComp$SetContent;
    }

    static HMIListDataUpdateComp$SetContent create(Object[] objectArray) {
        HMIListDataUpdateComp$SetContent hMIListDataUpdateComp$SetContent = HMIListDataUpdateComp$SetContent.borrow();
        hMIListDataUpdateComp$SetContent.items = objectArray;
        return hMIListDataUpdateComp$SetContent;
    }

    @Override
    void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        hMIListDataManipulator.setContent(this.items);
    }

    @Override
    void acceptObserver(HMIListObserver hMIListObserver) {
        hMIListObserver.itemsChanged(0, this.items.length);
    }

    @Override
    int getType() {
        return 2;
    }

    @Override
    public void release() {
        this.items = null;
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HMIList.DataUpdateComp.SetContent", 10);
    }
}


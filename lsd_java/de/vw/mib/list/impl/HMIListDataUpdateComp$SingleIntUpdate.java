/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;
import de.vw.mib.pool.PoorMansPool;

class HMIListDataUpdateComp$SingleIntUpdate
extends HMIListDataUpdateComp$AbstractUpdate {
    private static final int MAX_POOL_ITEMS;
    private static final PoorMansPool POOL;
    private int type;
    int value;

    HMIListDataUpdateComp$SingleIntUpdate() {
    }

    private static HMIListDataUpdateComp$SingleIntUpdate borrow() {
        HMIListDataUpdateComp$SingleIntUpdate hMIListDataUpdateComp$SingleIntUpdate = (HMIListDataUpdateComp$SingleIntUpdate)POOL.borrow();
        if (null == hMIListDataUpdateComp$SingleIntUpdate) {
            hMIListDataUpdateComp$SingleIntUpdate = new HMIListDataUpdateComp$SingleIntUpdate();
        }
        return hMIListDataUpdateComp$SingleIntUpdate;
    }

    static HMIListDataUpdateComp$SingleIntUpdate create(int n, int n2) {
        HMIListDataUpdateComp$SingleIntUpdate hMIListDataUpdateComp$SingleIntUpdate = HMIListDataUpdateComp$SingleIntUpdate.borrow();
        hMIListDataUpdateComp$SingleIntUpdate.type = n;
        hMIListDataUpdateComp$SingleIntUpdate.value = n2;
        return hMIListDataUpdateComp$SingleIntUpdate;
    }

    @Override
    void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        switch (this.type) {
            case 3: {
                hMIListDataManipulator.setFocus(this.value);
                break;
            }
            case 4: {
                hMIListDataManipulator.setSize(this.value);
                break;
            }
            case 5: {
                hMIListDataManipulator.setState(this.value);
                break;
            }
        }
    }

    @Override
    void acceptObserver(HMIListObserver hMIListObserver) {
        switch (this.type) {
            case 3: {
                hMIListObserver.focusChanged(this.value);
                break;
            }
            case 4: {
                hMIListObserver.sizeChanged(this.value);
                break;
            }
            case 5: {
                hMIListObserver.stateChanged(this.value);
                break;
            }
        }
    }

    @Override
    int getType() {
        return this.type;
    }

    @Override
    public void release() {
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HMIList.DataUpdateComp.SingleIntUpdate", 20);
    }
}


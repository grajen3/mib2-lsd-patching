/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListPooledEntity;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.HMIListDataUpdateComp$AbstractUpdate;
import de.vw.mib.list.impl.HMIListDataUpdateComp$Clear;
import de.vw.mib.list.impl.HMIListDataUpdateComp$Refresh;
import de.vw.mib.list.impl.HMIListDataUpdateComp$SetContent;
import de.vw.mib.list.impl.HMIListDataUpdateComp$SetFocus;
import de.vw.mib.list.impl.HMIListDataUpdateComp$SetSize;
import de.vw.mib.list.impl.HMIListDataUpdateComp$SetState;
import de.vw.mib.list.impl.HMIListDataUpdateComp$SetStringIndex;
import de.vw.mib.list.impl.HMIListDataUpdateComp$SingleIntUpdate;
import de.vw.mib.list.impl.HMIListDataUpdateComp$Update;
import de.vw.mib.list.impl.Pools;
import de.vw.mib.pool.PoorMansPool;
import java.util.ArrayList;

class HMIListDataUpdateComp
implements HMIListDataUpdate,
HMIListDataManipulator,
HMIListPooledEntity {
    private static final int MAX_COMP_POOL_ITEMS;
    private static final PoorMansPool COMP_POOL;
    private int refCount;
    private ArrayList updates;

    private static HMIListDataUpdateComp borrow() {
        HMIListDataUpdateComp hMIListDataUpdateComp = (HMIListDataUpdateComp)COMP_POOL.borrow();
        if (null == hMIListDataUpdateComp) {
            hMIListDataUpdateComp = new HMIListDataUpdateComp();
        }
        return hMIListDataUpdateComp;
    }

    private HMIListDataUpdateComp() {
    }

    static HMIListDataUpdateComp create() {
        HMIListDataUpdateComp hMIListDataUpdateComp = HMIListDataUpdateComp.borrow();
        hMIListDataUpdateComp.refCount = 1;
        hMIListDataUpdateComp.updates = Pools.borrowArrayList();
        return hMIListDataUpdateComp;
    }

    @Override
    public synchronized void release() {
        if (0 == --this.refCount) {
            int n = this.updates.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ((HMIListDataUpdateComp$AbstractUpdate)this.updates.get(i2)).release();
            }
            Pools.releaseArrayList(this.updates);
            this.updates = null;
            COMP_POOL.release(this);
        }
    }

    @Override
    public synchronized void incRefCounter() {
        ++this.refCount;
    }

    @Override
    public synchronized void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
        int n = this.updates.size();
        for (int i2 = 0; i2 < n; ++i2) {
            ((HMIListDataUpdateComp$AbstractUpdate)this.updates.get(i2)).acceptManipulator(hMIListDataManipulator);
        }
    }

    @Override
    public synchronized void acceptObserver(HMIListObserver hMIListObserver) {
        int n = this.updates.size();
        for (int i2 = 0; i2 < n; ++i2) {
            ((HMIListDataUpdateComp$AbstractUpdate)this.updates.get(i2)).acceptObserver(hMIListObserver);
        }
    }

    @Override
    public synchronized HMIListDataUpdate merge(HMIListDataUpdate hMIListDataUpdate) {
        HMIListDataUpdateComp hMIListDataUpdateComp = this.copy();
        hMIListDataUpdate.acceptManipulator(hMIListDataUpdateComp);
        return hMIListDataUpdateComp;
    }

    private HMIListDataUpdateComp copy() {
        HMIListDataUpdateComp hMIListDataUpdateComp = HMIListDataUpdateComp.create();
        this.acceptManipulator(hMIListDataUpdateComp);
        return hMIListDataUpdateComp;
    }

    @Override
    public synchronized void clear() {
        int n = this.updates.size();
        while (--n >= 0) {
            HMIListDataUpdateComp$AbstractUpdate hMIListDataUpdateComp$AbstractUpdate = (HMIListDataUpdateComp$AbstractUpdate)this.updates.get(n);
            switch (hMIListDataUpdateComp$AbstractUpdate.getType()) {
                case 0: 
                case 1: 
                case 2: 
                case 4: 
                case 7: {
                    this.updates.remove(n);
                    hMIListDataUpdateComp$AbstractUpdate.release();
                    break;
                }
            }
        }
        this.updates.add(HMIListDataUpdateComp$Clear.create());
    }

    @Override
    public synchronized void refresh(int n, int n2) {
        this.updates.add(HMIListDataUpdateComp$Refresh.create(n, n2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setContent(Object[] objectArray) {
        if (0 == objectArray.length) {
            this.clear();
        } else {
            HMIListDataUpdateComp hMIListDataUpdateComp = this;
            synchronized (hMIListDataUpdateComp) {
                int n = this.updates.size();
                while (--n >= 0) {
                    HMIListDataUpdateComp$AbstractUpdate hMIListDataUpdateComp$AbstractUpdate = (HMIListDataUpdateComp$AbstractUpdate)this.updates.get(n);
                    switch (hMIListDataUpdateComp$AbstractUpdate.getType()) {
                        case 1: 
                        case 2: 
                        case 4: 
                        case 7: {
                            this.updates.remove(n);
                            hMIListDataUpdateComp$AbstractUpdate.release();
                            break;
                        }
                    }
                }
                this.updates.add(HMIListDataUpdateComp$SetContent.create(objectArray));
            }
        }
    }

    @Override
    public synchronized void setFocus(int n) {
        int n2 = this.updates.size();
        while (--n2 >= 0) {
            HMIListDataUpdateComp$AbstractUpdate hMIListDataUpdateComp$AbstractUpdate = (HMIListDataUpdateComp$AbstractUpdate)this.updates.get(n2);
            switch (hMIListDataUpdateComp$AbstractUpdate.getType()) {
                case 3: {
                    this.updates.remove(n2);
                    hMIListDataUpdateComp$AbstractUpdate.release();
                    break;
                }
            }
        }
        this.updates.add(HMIListDataUpdateComp$SetFocus.create(n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSize(int n) {
        if (0 == n) {
            this.clear();
        } else {
            HMIListDataUpdateComp hMIListDataUpdateComp = this;
            synchronized (hMIListDataUpdateComp) {
                int n2 = this.updates.size();
                while (--n2 >= 0) {
                    HMIListDataUpdateComp$AbstractUpdate hMIListDataUpdateComp$AbstractUpdate = (HMIListDataUpdateComp$AbstractUpdate)this.updates.get(n2);
                    switch (hMIListDataUpdateComp$AbstractUpdate.getType()) {
                        case 1: {
                            if (((HMIListDataUpdateComp$Refresh)hMIListDataUpdateComp$AbstractUpdate).index < n) break;
                            this.updates.remove(n2);
                            hMIListDataUpdateComp$AbstractUpdate.release();
                            break;
                        }
                        case 4: {
                            if (((HMIListDataUpdateComp$SingleIntUpdate)hMIListDataUpdateComp$AbstractUpdate).value <= n) break;
                            this.updates.remove(n2);
                            hMIListDataUpdateComp$AbstractUpdate.release();
                            break;
                        }
                        case 7: {
                            if (((HMIListDataUpdateComp$Update)hMIListDataUpdateComp$AbstractUpdate).index < n) break;
                            this.updates.remove(n2);
                            hMIListDataUpdateComp$AbstractUpdate.release();
                            break;
                        }
                    }
                }
                this.updates.add(HMIListDataUpdateComp$SetSize.create(n));
            }
        }
    }

    @Override
    public synchronized void setState(int n) {
        this.updates.add(HMIListDataUpdateComp$SetState.create(n));
    }

    @Override
    public synchronized void setStringIndex(StringIndex stringIndex) {
        int n = this.updates.size();
        while (--n >= 0) {
            HMIListDataUpdateComp$AbstractUpdate hMIListDataUpdateComp$AbstractUpdate = (HMIListDataUpdateComp$AbstractUpdate)this.updates.get(n);
            switch (hMIListDataUpdateComp$AbstractUpdate.getType()) {
                case 6: {
                    this.updates.remove(n);
                    hMIListDataUpdateComp$AbstractUpdate.release();
                    break;
                }
            }
        }
        this.updates.add(HMIListDataUpdateComp$SetStringIndex.create(stringIndex));
    }

    @Override
    public synchronized void update(int n, Object[] objectArray) {
        int n2 = this.updates.size();
        int n3 = n + objectArray.length;
        while (--n2 >= 0) {
            HMIListDataUpdateComp$AbstractUpdate hMIListDataUpdateComp$AbstractUpdate = (HMIListDataUpdateComp$AbstractUpdate)this.updates.get(n2);
            switch (hMIListDataUpdateComp$AbstractUpdate.getType()) {
                case 1: {
                    HMIListDataUpdateComp$Refresh hMIListDataUpdateComp$Refresh = (HMIListDataUpdateComp$Refresh)hMIListDataUpdateComp$AbstractUpdate;
                    if (hMIListDataUpdateComp$Refresh.index < n || hMIListDataUpdateComp$Refresh.index + hMIListDataUpdateComp$Refresh.count > n3) break;
                    this.updates.remove(n2);
                    hMIListDataUpdateComp$AbstractUpdate.release();
                    break;
                }
                case 7: {
                    HMIListDataUpdateComp$Update hMIListDataUpdateComp$Update = (HMIListDataUpdateComp$Update)hMIListDataUpdateComp$AbstractUpdate;
                    if (hMIListDataUpdateComp$Update.index < n || hMIListDataUpdateComp$Update.index + objectArray.length > n3) break;
                    this.updates.remove(n2);
                    hMIListDataUpdateComp$AbstractUpdate.release();
                    break;
                }
            }
        }
        this.updates.add(HMIListDataUpdateComp$Update.create(n, objectArray));
    }

    static {
        COMP_POOL = new PoorMansPool("HMIList.DataUpdateComp", 10);
    }
}


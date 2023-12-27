/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataTransaction;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.HMIListDataUpdateComp;
import de.vw.mib.pool.PoorMansPool;

class HMIListDataTransactionImpl
implements HMIListDataTransaction {
    private static final int MAX_POOL_ITEMS;
    private static final PoorMansPool POOL;
    private HMIListDataUpdateComp update;
    private HMIListDataObserver observer;

    private static HMIListDataTransactionImpl borrow() {
        HMIListDataTransactionImpl hMIListDataTransactionImpl = (HMIListDataTransactionImpl)POOL.borrow();
        if (null == hMIListDataTransactionImpl) {
            hMIListDataTransactionImpl = new HMIListDataTransactionImpl();
        }
        return hMIListDataTransactionImpl;
    }

    private HMIListDataTransactionImpl() {
    }

    static HMIListDataTransactionImpl create(HMIListDataObserver hMIListDataObserver) {
        HMIListDataTransactionImpl hMIListDataTransactionImpl = HMIListDataTransactionImpl.borrow();
        hMIListDataTransactionImpl.observer = hMIListDataObserver;
        hMIListDataTransactionImpl.update = HMIListDataUpdateComp.create();
        return hMIListDataTransactionImpl;
    }

    public void release() {
        if (null != this.update) {
            this.update.release();
            this.update = null;
        }
        this.observer = null;
        POOL.release(this);
    }

    @Override
    public void clear() {
        this.update.clear();
    }

    @Override
    public void refresh(int n, int n2) {
        this.update.refresh(n, n2);
    }

    @Override
    public void setContent(Object[] objectArray) {
        this.update.setContent(objectArray);
    }

    @Override
    public void setFocus(int n) {
        this.update.setFocus(n);
    }

    @Override
    public void setSize(int n) {
        this.update.setSize(n);
    }

    @Override
    public void setState(int n) {
        this.update.setState(n);
    }

    @Override
    public void setStringIndex(StringIndex stringIndex) {
        this.update.setStringIndex(stringIndex);
    }

    @Override
    public void update(int n, Object[] objectArray) {
        this.update.update(n, objectArray);
    }

    @Override
    public void commit() {
        HMIListDataUpdateComp hMIListDataUpdateComp = this.update;
        HMIListDataObserver hMIListDataObserver = this.observer;
        this.update = null;
        this.observer = null;
        hMIListDataObserver.onUpdate(hMIListDataUpdateComp);
        this.release();
    }

    @Override
    public void dismiss() {
        this.release();
    }

    static {
        POOL = new PoorMansPool("HMIList.DataTransaction", 10);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataTransaction;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.StringIndex;

class ASLClientListImpl$UpdateBucket
implements HMIListDataObserver,
HMIListDataTransaction {
    private HMIListDataUpdate update;
    private HMIListDataTransaction transaction;

    static ASLClientListImpl$UpdateBucket create(HMIListDataFactory hMIListDataFactory) {
        ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket = new ASLClientListImpl$UpdateBucket();
        aSLClientListImpl$UpdateBucket.transaction = hMIListDataFactory.createDataTransaction(aSLClientListImpl$UpdateBucket);
        return aSLClientListImpl$UpdateBucket;
    }

    private ASLClientListImpl$UpdateBucket() {
    }

    @Override
    public void commit() {
        this.transaction.commit();
    }

    @Override
    public void dismiss() {
        this.transaction.dismiss();
    }

    HMIListDataUpdate getUpdate() {
        return this.update;
    }

    @Override
    public void onUpdate(HMIListDataUpdate hMIListDataUpdate) {
        this.update = hMIListDataUpdate;
    }

    @Override
    public void clear() {
        this.transaction.clear();
    }

    @Override
    public void refresh(int n, int n2) {
        this.transaction.refresh(n, n2);
    }

    @Override
    public void setContent(Object[] objectArray) {
        this.transaction.setContent(objectArray);
    }

    @Override
    public void setFocus(int n) {
        this.transaction.setFocus(n);
    }

    @Override
    public void setSize(int n) {
        this.transaction.setSize(n);
    }

    @Override
    public void setState(int n) {
        this.transaction.setState(n);
    }

    @Override
    public void setStringIndex(StringIndex stringIndex) {
        this.transaction.setStringIndex(stringIndex);
    }

    @Override
    public void update(int n, Object[] objectArray) {
        this.transaction.update(n, objectArray);
    }
}


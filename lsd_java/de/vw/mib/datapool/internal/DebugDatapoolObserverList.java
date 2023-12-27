/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.datapool.diag.DebugDatapoolObserver;

final class DebugDatapoolObserverList
implements DebugDatapoolObserver {
    private final CowArray observers = new CowArray();

    DebugDatapoolObserverList() {
    }

    @Override
    public void datapoolUpdate(byte by, int n, boolean bl) {
        Object[] objectArray = this.observers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugDatapoolObserver)objectArray[i2]).datapoolUpdate(by, n, bl);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, float f2) {
        Object[] objectArray = this.observers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugDatapoolObserver)objectArray[i2]).datapoolUpdate(by, n, f2);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, int n2) {
        Object[] objectArray = this.observers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugDatapoolObserver)objectArray[i2]).datapoolUpdate(by, n, n2);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, long l) {
        Object[] objectArray = this.observers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugDatapoolObserver)objectArray[i2]).datapoolUpdate(by, n, l);
        }
    }

    @Override
    public void datapoolUpdate(byte by, int n, Object object) {
        Object[] objectArray = this.observers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugDatapoolObserver)objectArray[i2]).datapoolUpdate(by, n, object);
        }
    }

    void addObserver(DebugDatapoolObserver debugDatapoolObserver) {
        this.observers.addIfNotAlreadyIn(debugDatapoolObserver);
    }

    DebugDatapoolObserver removeObserver(DebugDatapoolObserver debugDatapoolObserver) {
        this.observers.remove(debugDatapoolObserver);
        if (this.observers.size() == 1) {
            DebugDatapoolObserver debugDatapoolObserver2 = (DebugDatapoolObserver)this.observers.get(0);
            this.observers.removeAllElements();
            return debugDatapoolObserver2;
        }
        return this;
    }
}


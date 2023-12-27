/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.collections.ObjectObjectOptHashMap;

class BAPValueObserverableAdapter
implements BAPValueObserverable {
    private ObjectObjectOptHashMap _observers;
    private static final int INITIAL_OBSERVER_SIZE;

    BAPValueObserverableAdapter() {
    }

    private ObjectObjectOptHashMap getObservers() {
        if (this._observers == null) {
            this._observers = new ObjectObjectOptHashMap(1);
        }
        return this._observers;
    }

    @Override
    public void addObserver(BAPValueObserver bAPValueObserver, Object object) {
        this.getObservers().put(bAPValueObserver, object);
    }

    @Override
    public void removeObserver(BAPValueObserver bAPValueObserver) {
        this.getObservers().remove(bAPValueObserver);
    }

    void didChangeValue(BAPEntity bAPEntity, BAPEntity bAPEntity2) {
        Object[] objectArray = this.getObservers().keySet().toArray();
        int n = objectArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            BAPValueObserver bAPValueObserver = (BAPValueObserver)objectArray[i2];
            bAPValueObserver.bapValueChanged(this, bAPEntity, bAPEntity2, this.getObservers().get(bAPValueObserver));
        }
    }

    void didGotError(int n) {
        Object[] objectArray = this.getObservers().keySet().toArray();
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            BAPValueObserver bAPValueObserver = (BAPValueObserver)objectArray[i2];
            bAPValueObserver.bapValueError(this, n, this.getObservers().get(bAPValueObserver));
        }
    }
}


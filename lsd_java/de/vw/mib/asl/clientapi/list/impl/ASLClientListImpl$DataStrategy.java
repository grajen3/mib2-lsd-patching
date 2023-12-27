/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.HMIListState;
import de.vw.mib.list.StringIndex;

abstract class ASLClientListImpl$DataStrategy
implements HMIListState {
    private final /* synthetic */ ASLClientListImpl this$0;

    ASLClientListImpl$DataStrategy(ASLClientListImpl aSLClientListImpl) {
        this.this$0 = aSLClientListImpl;
    }

    @Override
    public int getFocusIndex() {
        return this.this$0.getFocusIndex();
    }

    @Override
    public int getListState() {
        return this.this$0.getListState();
    }

    @Override
    public StringIndex getStringIndex() {
        return this.this$0.getStringIndex();
    }

    abstract void fillItems(int n, Object[] objectArray) {
    }

    abstract Object getItem(int n) {
    }

    abstract void disableFetching() {
    }

    abstract void enableFetching(ASLClientListFetcher aSLClientListFetcher, int n, int n2) {
    }

    abstract void fetchTimedOut() {
    }

    abstract HMIListDataUpdate execute(HMIListDataUpdate hMIListDataUpdate) {
    }
}


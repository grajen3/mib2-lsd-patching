/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataProvider;
import de.vw.mib.list.StringIndex;

class ASLClientListImpl$DataProvider
implements HMIListDataProvider {
    private final /* synthetic */ ASLClientListImpl this$0;

    ASLClientListImpl$DataProvider(ASLClientListImpl aSLClientListImpl) {
        this.this$0 = aSLClientListImpl;
    }

    @Override
    public void fillItems(int n, Object[] objectArray) {
        this.this$0.fillItems(n, objectArray);
    }

    @Override
    public int getFocusIndex() {
        return this.this$0.getFocusIndex();
    }

    @Override
    public int getListSize() {
        return this.this$0.getListSize();
    }

    @Override
    public int getListState() {
        return this.this$0.getListState();
    }

    @Override
    public StringIndex getStringIndex() {
        return this.this$0.getStringIndex();
    }

    @Override
    public void setObserver(HMIListDataObserver hMIListDataObserver) {
        this.this$0.setDataObserver(hMIListDataObserver);
    }
}


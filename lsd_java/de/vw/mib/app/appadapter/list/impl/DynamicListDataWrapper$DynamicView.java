/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.list.impl;

import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.HMIListViewMock;
import de.vw.mib.list.StringIndex;

final class DynamicListDataWrapper$DynamicView
extends HMIListViewMock {
    private final DynamicListData dynamicListData;
    private volatile int freezeCounter;

    public DynamicListDataWrapper$DynamicView(DynamicListData dynamicListData) {
        this.dynamicListData = dynamicListData;
    }

    @Override
    public int getFocusIndex() {
        return this.dynamicListData.getActivatedIndex();
    }

    @Override
    public int getListSize() {
        return this.dynamicListData.getItemCount();
    }

    @Override
    public int getListState() {
        return 2;
    }

    @Override
    public StringIndex getStringIndex() {
        return this.dynamicListData.getStringIndex();
    }

    @Override
    public synchronized void freeze() {
        ++this.freezeCounter;
        this.dynamicListData.freeze();
    }

    @Override
    public synchronized void unfreeze() {
        --this.freezeCounter;
        this.dynamicListData.unfreeze();
    }

    @Override
    public synchronized void forceUnfreeze() {
        this.freezeCounter = 0;
        this.dynamicListData.forceUnfreeze();
    }

    @Override
    public synchronized boolean isFrozen() {
        return this.freezeCounter == 0;
    }

    @Override
    public Object getItem(int n) {
        try {
            return this.dynamicListData.getRowItem(n);
        }
        catch (RuntimeException runtimeException) {
            return DynamicListData.ITEM_NOT_LOADED;
        }
    }
}


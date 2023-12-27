/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.list.impl;

import de.vw.mib.app.appadapter.list.impl.DynamicListDataWrapper$DynamicView;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListMock;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListView;
import de.vw.mib.list.StringIndex;

public class DynamicListDataWrapper
extends HMIListMock
implements HMIList {
    private final DynamicListData dynamicListData;

    public DynamicListDataWrapper(DynamicListData dynamicListData) {
        this.dynamicListData = dynamicListData;
    }

    @Override
    public Object getKey() {
        return this.dynamicListData;
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
    public HMIListView createListWindowView(HMIListObserver hMIListObserver, int n, int n2) {
        return new DynamicListDataWrapper$DynamicView(this.dynamicListData);
    }

    @Override
    public HMIListView createListView(HMIListObserver hMIListObserver, int n) {
        return new DynamicListDataWrapper$DynamicView(this.dynamicListData);
    }
}


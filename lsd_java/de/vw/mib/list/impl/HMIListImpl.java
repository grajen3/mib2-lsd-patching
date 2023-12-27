/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataProvider;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListView;
import de.vw.mib.list.HMIListViewRanges;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.AbstractHMIListView;
import de.vw.mib.list.impl.HMIListDataUpdateComp;
import de.vw.mib.list.impl.HMIListWindowView;
import de.vw.mib.list.impl.StringIndexImpl;
import java.util.Arrays;

class HMIListImpl
implements HMIList,
HMIListDataObserver {
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_LIST_STATE;
    private static final StringIndex EMPTY_STRING_INDEX;
    private final Object key;
    private final CowArray views = new CowArray();
    private HMIListDataProvider dataProvider;

    HMIListImpl(Object object) {
        this.key = object;
    }

    @Override
    public HMIListView createListView(HMIListObserver hMIListObserver, int n) {
        return this.createListWindowView(hMIListObserver, n, 20);
    }

    @Override
    public synchronized HMIListView createListWindowView(HMIListObserver hMIListObserver, int n, int n2) {
        HMIListWindowView hMIListWindowView = new HMIListWindowView(this, hMIListObserver, n, n2);
        this.views.add(hMIListWindowView);
        return hMIListWindowView;
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public synchronized void fillViewRanges(HMIListViewRanges hMIListViewRanges) {
        Object[] objectArray = this.views.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            ((AbstractHMIListView)objectArray[i2]).fillViewRanges(hMIListViewRanges);
        }
    }

    @Override
    public Object getSemaphore() {
        return this;
    }

    @Override
    public int getFocusIndex() {
        HMIListDataProvider hMIListDataProvider = this.dataProvider;
        return null != hMIListDataProvider ? hMIListDataProvider.getFocusIndex() : -1;
    }

    @Override
    public int getListSize() {
        HMIListDataProvider hMIListDataProvider = this.dataProvider;
        return null != hMIListDataProvider ? hMIListDataProvider.getListSize() : 0;
    }

    @Override
    public int getListState() {
        HMIListDataProvider hMIListDataProvider = this.dataProvider;
        return null != hMIListDataProvider ? hMIListDataProvider.getListState() : 0;
    }

    @Override
    public StringIndex getStringIndex() {
        HMIListDataProvider hMIListDataProvider = this.dataProvider;
        StringIndex stringIndex = null != hMIListDataProvider ? hMIListDataProvider.getStringIndex() : null;
        return null != stringIndex ? stringIndex : EMPTY_STRING_INDEX;
    }

    @Override
    public void onUpdate(HMIListDataUpdate hMIListDataUpdate) {
        Object[] objectArray = this.views.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            hMIListDataUpdate.incRefCounter();
            ((HMIListDataObserver)objectArray[i2]).onUpdate(hMIListDataUpdate);
        }
        hMIListDataUpdate.release();
    }

    synchronized void releaseListView(AbstractHMIListView abstractHMIListView) {
        this.views.remove(abstractHMIListView);
    }

    synchronized void setDataProvider(HMIListDataProvider hMIListDataProvider) {
        if (this.dataProvider != hMIListDataProvider) {
            if (null != this.dataProvider) {
                this.fireStateChange(0);
                this.dataProvider.setObserver(null);
                this.dataProvider = null;
            }
            if (null != hMIListDataProvider) {
                this.fireStateChange(hMIListDataProvider.getListState());
                this.dataProvider = hMIListDataProvider;
                this.dataProvider.setObserver(this);
            }
        }
    }

    private void fireStateChange(int n) {
        if (this.getListState() != n && 0 < this.views.size()) {
            HMIListDataUpdateComp hMIListDataUpdateComp = HMIListDataUpdateComp.create();
            hMIListDataUpdateComp.setState(n);
            this.onUpdate(hMIListDataUpdateComp);
        }
    }

    synchronized void fillItems(int n, Object[] objectArray) {
        if (null != this.dataProvider) {
            this.dataProvider.fillItems(n, objectArray);
        } else {
            Arrays.fill(objectArray, null);
        }
    }

    static {
        EMPTY_STRING_INDEX = StringIndexImpl.NOT_USED;
    }
}


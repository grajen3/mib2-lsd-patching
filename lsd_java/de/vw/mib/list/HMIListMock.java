/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListView;
import de.vw.mib.list.HMIListViewRanges;
import de.vw.mib.list.StringIndex;

public class HMIListMock
implements HMIList {
    private final Object key = new Object();

    @Override
    public int getFocusIndex() {
        return 0;
    }

    @Override
    public int getListSize() {
        return 0;
    }

    @Override
    public int getListState() {
        return 0;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public HMIListView createListWindowView(HMIListObserver hMIListObserver, int n, int n2) {
        return null;
    }

    @Override
    public HMIListView createListView(HMIListObserver hMIListObserver, int n) {
        return null;
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public void fillViewRanges(HMIListViewRanges hMIListViewRanges) {
    }

    @Override
    public Object getSemaphore() {
        return this;
    }
}


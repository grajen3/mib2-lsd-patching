/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.list.impl;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.app.appadapter.list.AppAdapterList;
import de.vw.mib.app.appadapter.list.AppAdapterListMapper;
import de.vw.mib.app.appadapter.list.AppAdapterListUpdateEvent;
import de.vw.mib.app.appadapter.list.AppAdapterListUpdateListener;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListView;
import de.vw.mib.list.StringIndex;

public class PlainAppAdapterList
implements AppAdapterList,
HMIListObserver {
    private final int id;
    private final HMIListView hmiListView;
    private final AppAdapterListMapper mapper;
    private final AppAdapterListUpdateListener updateListener;

    public PlainAppAdapterList(int n, HMIList hMIList, AppAdapterListMapper appAdapterListMapper, AppAdapterListUpdateListener appAdapterListUpdateListener) {
        this.id = n;
        this.hmiListView = hMIList.createListView(this, 0);
        this.mapper = appAdapterListMapper;
        this.updateListener = appAdapterListUpdateListener;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public boolean areDataArranged() {
        int n = this.hmiListView.getListState();
        return n == 2 || n == 3;
    }

    @Override
    public int getListSize() {
        return this.hmiListView.getListSize();
    }

    @Override
    public void freeze() {
        this.hmiListView.freeze();
    }

    @Override
    public void unfreeze() {
        this.hmiListView.unfreeze();
    }

    @Override
    public void forceUnfreeze() {
        this.hmiListView.forceUnfreeze();
    }

    @Override
    public Object getRowItem(int n) {
        return this.hmiListView.getItem(n);
    }

    @Override
    public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
        if (object != ROW_ITEM_NOT_LOADED) {
            return this.mapper.getCellValue(cellValue, object, n, n2);
        }
        return cellValue;
    }

    @Override
    public int getFocusIndex() {
        return this.hmiListView.getFocusIndex();
    }

    @Override
    public StringIndex getStringIndex() {
        return this.hmiListView.getStringIndex();
    }

    @Override
    public void focusChanged(int n) {
        this.informListener(AppAdapterListUpdateEvent.focusRowChanged(n));
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.informListener(AppAdapterListUpdateEvent.rowsChanged(n, n2));
    }

    @Override
    public void sizeChanged(int n) {
        this.informListener(AppAdapterListUpdateEvent.listSizeChanged(n));
    }

    @Override
    public void stateChanged(int n) {
        this.informListener(AppAdapterListUpdateEvent.contentChanged());
    }

    @Override
    public void stringIndexChanged() {
        this.informListener(AppAdapterListUpdateEvent.stringIndexChanged());
    }

    private void informListener(AppAdapterListUpdateEvent appAdapterListUpdateEvent) {
        this.updateListener.onAppAdapterListChanged(this, appAdapterListUpdateEvent);
    }
}


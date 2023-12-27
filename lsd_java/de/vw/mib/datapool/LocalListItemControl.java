/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;

public class LocalListItemControl
implements ExtendedListItemControl {
    private final CowArray listeners;
    private final int itemCount;

    public LocalListItemControl(int n) {
        this.itemCount = n;
        this.listeners = new CowArray();
    }

    @Override
    public boolean isDynamic() {
        return false;
    }

    @Override
    public int getItemCount() {
        return this.itemCount;
    }

    @Override
    public void addListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listeners.add(listItemControlListener);
    }

    @Override
    public void removeListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listeners.remove(listItemControlListener);
    }

    @Override
    public void freeze() {
    }

    @Override
    public void unfreeze() {
    }

    @Override
    public void forceUnfreeze() {
    }

    @Override
    public DynamicListData getASLList() {
        return null;
    }

    @Override
    public int getActivatedIndex() {
        return -1;
    }

    @Override
    public DynamicListDataRowItemTransformer getListTransformer() {
        return null;
    }

    @Override
    public Object getRowItem(int n) {
        return null;
    }

    @Override
    public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
        return cellValue;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public void refresh() {
        int n = this.listeners.size();
        for (int i2 = 0; i2 < n; ++i2) {
            ListItemControlListener listItemControlListener = (ListItemControlListener)this.listeners.get(i2);
            listItemControlListener.listContentChanged();
        }
    }

    @Override
    public void updateListView(int n, int n2) {
    }
}


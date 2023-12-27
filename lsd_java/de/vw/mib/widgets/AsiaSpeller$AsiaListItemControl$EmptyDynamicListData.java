/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataListener;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.StringIndex;

final class AsiaSpeller$AsiaListItemControl$EmptyDynamicListData
implements DynamicListData {
    @Override
    public void addDynamicListDataListener(DynamicListDataListener dynamicListDataListener) {
    }

    @Override
    public void removeDynamicListDataListener(DynamicListDataListener dynamicListDataListener) {
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
    public int getActivatedIndex() {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public DynamicListDataRowItemTransformer getListTransformer() {
        return null;
    }

    @Override
    public long getObjectId(Object object) {
        return 0L;
    }

    @Override
    public Object getRowItem(int n) {
        return null;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public void updateListView(int n, int n2) {
    }
}


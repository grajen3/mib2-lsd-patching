/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataListener;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.StringIndex;
import java.util.ArrayList;

public class SimpleDynamicListData
implements DynamicListData {
    private Object[] listData;

    public SimpleDynamicListData(ArrayList arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("list data should not be null!");
        }
        this.listData = arrayList.toArray();
    }

    public void updateListData(ArrayList arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("list data should not be null!");
        }
        this.listData = arrayList.toArray();
    }

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
        return this.listData.length;
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
        return this.listData[n];
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public void updateListView(int n, int n2) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.DynamicListDataListener;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.StringIndex;

public interface DynamicListData {
    public static final int COUNT_NOT_AVAILABLE;
    public static final int ACTIVE_ITEM_NOT_AVAILABLE;
    public static final Object ITEM_NOT_LOADED;
    public static final long NO_OBJECT_ID;

    default public void addDynamicListDataListener(DynamicListDataListener dynamicListDataListener) {
    }

    default public void removeDynamicListDataListener(DynamicListDataListener dynamicListDataListener) {
    }

    default public void freeze() {
    }

    default public void unfreeze() {
    }

    default public void forceUnfreeze() {
    }

    default public int getActivatedIndex() {
    }

    default public int getItemCount() {
    }

    default public DynamicListDataRowItemTransformer getListTransformer() {
    }

    default public long getObjectId(Object object) {
    }

    default public Object getRowItem(int n) {
    }

    default public StringIndex getStringIndex() {
    }

    default public void updateListView(int n, int n2) {
    }

    static {
        ITEM_NOT_LOADED = new Object();
    }
}


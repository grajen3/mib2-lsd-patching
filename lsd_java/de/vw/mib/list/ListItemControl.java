/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;

public interface ListItemControl {
    public static final int ACTIVE_ITEM_NOT_AVAILABLE;
    public static final int COUNT_NOT_AVAILABLE;
    public static final Object ITEM_NOT_LOADED;

    default public void addListItemControlListener(ListItemControlListener listItemControlListener) {
    }

    default public void forceUnfreeze() {
    }

    default public void freeze() {
    }

    default public int getActivatedIndex() {
    }

    default public DynamicListData getASLList() {
    }

    default public int getItemCount() {
    }

    default public DynamicListDataRowItemTransformer getListTransformer() {
    }

    default public Object getRowItem(int n) {
    }

    default public StringIndex getStringIndex() {
    }

    default public void refresh() {
    }

    default public void removeListItemControlListener(ListItemControlListener listItemControlListener) {
    }

    default public void unfreeze() {
    }

    default public void updateListView(int n, int n2) {
    }

    default public boolean isDynamic() {
    }

    static {
        ITEM_NOT_LOADED = DynamicListData.ITEM_NOT_LOADED;
    }
}


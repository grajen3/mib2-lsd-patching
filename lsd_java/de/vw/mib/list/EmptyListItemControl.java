/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControl;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;

public class EmptyListItemControl
implements ListItemControl {
    @Override
    public void addListItemControlListener(ListItemControlListener listItemControlListener) {
    }

    @Override
    public void forceUnfreeze() {
    }

    @Override
    public void freeze() {
    }

    @Override
    public int getActivatedIndex() {
        return 0;
    }

    @Override
    public DynamicListData getASLList() {
        return null;
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
    public Object getRowItem(int n) {
        return null;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public void refresh() {
    }

    @Override
    public void removeListItemControlListener(ListItemControlListener listItemControlListener) {
    }

    @Override
    public void unfreeze() {
    }

    @Override
    public void updateListView(int n, int n2) {
    }

    @Override
    public boolean isDynamic() {
        return false;
    }
}


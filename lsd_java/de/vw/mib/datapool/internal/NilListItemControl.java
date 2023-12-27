/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControl;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;

final class NilListItemControl
implements ExtendedListItemControl {
    private static NilListItemControl NIL = new NilListItemControl();

    public static ExtendedListItemControl instance() {
        return NIL;
    }

    private NilListItemControl() {
    }

    @Override
    public boolean isDynamic() {
        return false;
    }

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
        return ListItemControl.ITEM_NOT_LOADED;
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

    public String toString() {
        return "NilListItemControl for missing backing data";
    }
}


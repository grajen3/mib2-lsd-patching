/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.list;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.StringIndex;

public interface AppAdapterList {
    public static final int FOCUS_OFF;
    public static final Object ROW_ITEM_NOT_LOADED;

    default public int id() {
    }

    default public boolean areDataArranged() {
    }

    default public int getListSize() {
    }

    default public void freeze() {
    }

    default public void unfreeze() {
    }

    default public void forceUnfreeze() {
    }

    default public Object getRowItem(int n) {
    }

    default public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
    }

    default public int getFocusIndex() {
    }

    default public StringIndex getStringIndex() {
    }

    static {
        ROW_ITEM_NOT_LOADED = DynamicListData.ITEM_NOT_LOADED;
    }
}


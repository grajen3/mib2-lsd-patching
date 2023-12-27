/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.app.appadapter.list.AppAdapterList;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.list.StringIndex;

public final class InitialAppAdapterList
implements AppAdapterList {
    public static final Object INITIAL_ROW_ITEM = new Object();
    private static final InitialAppAdapterList EMPTY = new InitialAppAdapterList(0);
    private final int listSize;

    public static InitialAppAdapterList empty() {
        return EMPTY;
    }

    public static InitialAppAdapterList defaultValues(int n) {
        Preconditions.checkArgument(n >= 0, "expect list size >= 0");
        return n == 0 ? InitialAppAdapterList.empty() : new InitialAppAdapterList(n);
    }

    private InitialAppAdapterList(int n) {
        this.listSize = n;
    }

    @Override
    public boolean areDataArranged() {
        return true;
    }

    @Override
    public int getListSize() {
        return this.listSize;
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
    public Object getRowItem(int n) {
        Preconditions.checkInRange("row", n, 0, this.listSize);
        return INITIAL_ROW_ITEM;
    }

    @Override
    public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
        return cellValue;
    }

    @Override
    public int getFocusIndex() {
        return -1;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public int id() {
        return 0;
    }
}


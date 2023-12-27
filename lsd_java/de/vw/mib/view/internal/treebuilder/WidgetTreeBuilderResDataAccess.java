/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

public class WidgetTreeBuilderResDataAccess {
    private static final int TABLEINDEX_ARRAY;
    private static final int OFFSET_WIDGETTYPE_ARRAY;
    private static final int OFFSET_RELATIONSHIP_ARRAY;
    private static final int OFFSET_CONTROLLERTYPE_ARRAY;
    private static final int OFFSET_CLONEABLE;
    private static final int OFFSET_PER_CLONE;
    private final Object[] resData;
    private final short[] tableIndexes;

    public WidgetTreeBuilderResDataAccess(Object[] objectArray) {
        this.resData = objectArray;
        this.tableIndexes = (short[])objectArray[1];
    }

    public int getViewCount() {
        return this.tableIndexes.length - 1;
    }

    private int getViewTableOffset(int n) {
        return this.tableIndexes[n] + 1;
    }

    public int getViewCloneDataCount(int n) {
        int n2 = this.tableIndexes[n + 1] - this.tableIndexes[n];
        return n2 / 3 - 1;
    }

    public byte[] getWidgetTypes(int n, int n2) {
        int n3 = this.getViewTableOffset(n);
        if (n2 < 0) {
            byte[] byArray = (byte[])this.resData[n3 + 0];
            return byArray;
        }
        byte[] byArray = (byte[])this.resData[n3 + 0 + 3 + 3 * n2];
        return byArray;
    }

    public byte[] getControllerTypes(int n, int n2) {
        int n3 = this.getViewTableOffset(n);
        if (n2 < 0) {
            byte[] byArray = (byte[])this.resData[n3 + 2];
            return byArray;
        }
        byte[] byArray = (byte[])this.resData[n3 + 2 + 3 + 3 * n2];
        return byArray;
    }

    public short[] getRelationships(int n, int n2) {
        int n3 = this.getViewTableOffset(n);
        if (n2 < 0) {
            short[] sArray = (short[])this.resData[n3 + 1];
            return sArray;
        }
        short[] sArray = (short[])this.resData[n3 + 1 + 3 + 3 * n2];
        return sArray;
    }
}


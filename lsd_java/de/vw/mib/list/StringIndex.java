/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

public interface StringIndex {
    public static final int INDEX_UNUSED;
    public static final int STATUS_NOT_USED;
    public static final int STATUS_INVALID;
    public static final int STATUS_READY;

    default public int[] getRowIndexes() {
    }

    default public String[] getStringIndexes() {
    }

    default public int getStatus() {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.StringIndex;

public interface HMIListState {
    public static final int STATE_UNDEFINED;
    public static final int STATE_LOADING;
    public static final int STATE_READY;
    public static final int STATE_NO_DATA;
    public static final int FOCUS_OFF;

    default public int getFocusIndex() {
    }

    default public int getListSize() {
    }

    default public int getListState() {
    }

    default public StringIndex getStringIndex() {
    }
}


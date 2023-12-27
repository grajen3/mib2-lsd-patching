/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.diag;

import de.vw.mib.datapool.diag.DebugDatapoolObserver$1;

public interface DebugDatapoolObserver {
    public static final DebugDatapoolObserver EMPTY_OBSERVER = new DebugDatapoolObserver$1();
    public static final byte CHANGE_REQUEST;
    public static final byte VALUE_CHANGED_AND_NOTIFY_OBSERVERS;
    public static final byte VALUE_CHANGED_NO_OBSERVERS;

    default public void datapoolUpdate(byte by, int n, boolean bl) {
    }

    default public void datapoolUpdate(byte by, int n, float f2) {
    }

    default public void datapoolUpdate(byte by, int n, int n2) {
    }

    default public void datapoolUpdate(byte by, int n, long l) {
    }

    default public void datapoolUpdate(byte by, int n, Object object) {
    }
}


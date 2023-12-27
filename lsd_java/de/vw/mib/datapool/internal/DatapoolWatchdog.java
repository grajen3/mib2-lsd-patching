/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.internal.DatapoolWatchdog$1;

interface DatapoolWatchdog {
    public static final DatapoolWatchdog EMPTY_DATAPOOL_WATCHDOG = new DatapoolWatchdog$1();

    default public void checkNewDatapoolValue(int n, Object object) {
    }
}


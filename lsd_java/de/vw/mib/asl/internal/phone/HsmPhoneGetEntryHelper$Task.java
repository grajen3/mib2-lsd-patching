/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import org.dsi.ifc.organizer.AdbEntry;

abstract class HsmPhoneGetEntryHelper$Task {
    int viewType;
    int listMode;
    long[] adbID;

    HsmPhoneGetEntryHelper$Task(int n, int n2, long[] lArray) {
        this.viewType = n;
        this.listMode = n2;
        this.adbID = lArray;
    }

    abstract void callback(boolean bl, AdbEntry[] adbEntryArray) {
    }
}


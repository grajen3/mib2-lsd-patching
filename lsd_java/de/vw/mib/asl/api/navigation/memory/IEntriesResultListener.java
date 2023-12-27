/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import org.dsi.ifc.organizer.AdbEntry;

public interface IEntriesResultListener {
    default public void handleResultEntries(int n, AdbEntry[] adbEntryArray, Object object) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi;

import org.dsi.ifc.organizer.AdbEntry;

public interface DSIAdbEditVW {
    default public void changeEntry(AdbEntry adbEntry, int n) {
    }

    default public void copyEntry(long l) {
    }

    default public void deleteEntries(long[] lArray, int n, int n2) {
    }

    default public void deleteSpeedDial(int n) {
    }

    default public void getEntries(long[] lArray, int n, int n2) {
    }

    default public void getEntryByReferenceId(String string) {
    }

    default public void getEntryDataSets(long[] lArray, int n, int n2) {
    }

    default public void insertEntry(AdbEntry adbEntry, int n) {
    }

    default public void setSpeedDial(AdbEntry adbEntry) {
    }
}


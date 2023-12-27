/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import org.dsi.ifc.organizer.AdbEntry;

public interface DSIAdbEditC {
    default public void insertEntry(AdbEntry adbEntry, int n) {
    }

    default public void getEntries(long[] lArray, int n, int n2) {
    }

    default public void getEntryDataSets(long[] lArray, int n, int n2) {
    }

    default public void changeEntry(AdbEntry adbEntry, int n) {
    }

    default public void copyEntry(long l) {
    }

    default public void deleteEntries(long[] lArray, int n, int n2) {
    }

    default public void setSpeedDial(AdbEntry adbEntry) {
    }

    default public void deleteSpeedDial(int n) {
    }

    default public void getEntryByReferenceId(String string) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbEditListener
extends DSIListener {
    default public void updateNewEntryAvailable(boolean bl, int n) {
    }

    default public void updateNewPublicProfileEntryAvailable(boolean bl, int n) {
    }

    default public void updateNewTopDestinationEntryAvailable(boolean bl, int n) {
    }

    default public void updateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
    }

    default public void insertEntryResult(int n, AdbEntry adbEntry) {
    }

    default public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
    }

    default public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
    }

    default public void changeEntryResult(int n, AdbEntry adbEntry) {
    }

    default public void copyEntryResult(int n, AdbEntry adbEntry) {
    }

    default public void deleteEntriesResult(int n) {
    }

    default public void setSpeedDialResult(int n) {
    }

    default public void deleteSpeedDialResult(int n) {
    }

    default public void getEntryByReferenceIdResult(int n, AdbEntry adbEntry) {
    }

    default public void updateNewOnlineDestinationEntryAvailable(boolean bl, int n) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DownloadInfo;

public interface DSIAdbVCardExchangeListener
extends DSIListener {
    default public void updateExportCount(DownloadInfo downloadInfo, int n) {
    }

    default public void updateImportCount(DownloadInfo downloadInfo, int n) {
    }

    default public void importVCardResult(int n, int n2, int n3, int n4) {
    }

    default public void exportVCardResult(int n, int n2, int n3, int n4) {
    }

    default public void exportSpellerVCardResult(int n, int n2, int n3, int n4, int n5) {
    }

    default public void createVCardResult(int n, long[] lArray, int n2, String string) {
    }

    default public void parseVCardResult(int n, AdbEntry[] adbEntryArray) {
    }

    default public void responseAbort(int n) {
    }
}


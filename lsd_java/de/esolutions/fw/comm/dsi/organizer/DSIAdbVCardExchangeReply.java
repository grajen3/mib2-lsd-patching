/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DownloadInfo;

public interface DSIAdbVCardExchangeReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

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

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


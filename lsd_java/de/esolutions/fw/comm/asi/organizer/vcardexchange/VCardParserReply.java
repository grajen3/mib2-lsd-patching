/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import org.dsi.ifc.organizer.AdbEntry;

public interface VCardParserReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void parseVCardResult(int n, AdbEntry adbEntry, int n2, int n3) {
    }

    default public void parseVCardDirectoryResult(int n, AdbEntry[] adbEntryArray, int n2, int n3) {
    }

    default public void exportVCardResult(int n, String string, int n2) {
    }

    default public void exportSmallVCardResult(int n, String string, int n2) {
    }

    default public void parsingFinished(int n) {
    }

    default public void exportFinished(int n, int n2) {
    }

    default public void smallExportFinished(int n, long[] lArray, int n2, String string, int n3) {
    }

    default public void setBinaryContentTempPathResult(int n, String string) {
    }

    default public void setBinaryContentQuotaPerFileResult(int n, long l) {
    }
}


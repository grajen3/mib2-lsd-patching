/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import org.dsi.ifc.organizer.AdbEntry;

public interface VCardParserC {
    default public void parseVCard(String string, int n, int n2) {
    }

    default public void parseVCardDirectory(String string, int n, int n2) {
    }

    default public void exportVCard(AdbEntry adbEntry, String string, int n) {
    }

    default public void exportSmallVCard(AdbEntry adbEntry, String string, int n) {
    }

    default public void finishParsing(int n) {
    }

    default public void finishExport(int n, int n2) {
    }

    default public void finishSmallExport(String string, int n) {
    }

    default public void setBinaryContentTempPath(String string) {
    }

    default public void setBinaryContentQuotaPerFile(long l) {
    }

    default public void setExtendedAddressHandling(boolean bl) {
    }
}


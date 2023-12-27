/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import org.dsi.ifc.organizer.AdbEntry;

public interface VCardParserS {
    default public void parseVCard(String string, int n, int n2, VCardParserReply vCardParserReply) {
    }

    default public void parseVCardDirectory(String string, int n, int n2, VCardParserReply vCardParserReply) {
    }

    default public void exportVCard(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
    }

    default public void exportSmallVCard(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
    }

    default public void finishParsing(int n, VCardParserReply vCardParserReply) {
    }

    default public void finishExport(int n, int n2, VCardParserReply vCardParserReply) {
    }

    default public void finishSmallExport(String string, int n, VCardParserReply vCardParserReply) {
    }

    default public void setBinaryContentTempPath(String string, VCardParserReply vCardParserReply) {
    }

    default public void setBinaryContentQuotaPerFile(long l, VCardParserReply vCardParserReply) {
    }

    default public void setExtendedAddressHandling(boolean bl, VCardParserReply vCardParserReply) {
    }
}


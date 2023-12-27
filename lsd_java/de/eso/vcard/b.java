/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import org.dsi.ifc.organizer.AdbEntry;

class b
implements VCardParserReply {
    b() {
    }

    public void a(int n, AdbEntry adbEntry) {
        if (n != 0) {
            System.err.println(new StringBuffer().append("EROR parsing vcard: ").append(n).append(" ... ").append(adbEntry).toString());
        }
        System.out.println(new StringBuffer().append("received an answer: ").append(n).append(" ... ").append(adbEntry).toString());
    }

    public void a(int n, String string) {
        System.out.println(new StringBuffer().append("Received an exportVCardResult answer: ").append(string).toString());
    }

    @Override
    public void exportFinished(int n, int n2) {
        System.out.println("Export finished.");
    }

    public void a() {
        System.out.println("Parsing finished.");
    }

    @Override
    public void setBinaryContentQuotaPerFileResult(int n, long l) {
        System.out.println("setBinaryContentQuotaPerFileResult()");
    }

    @Override
    public void setBinaryContentTempPathResult(int n, String string) {
        System.out.println("setBinaryContentTempPathResult()");
    }

    public void b(int n, String string) {
        System.out.println("exportSmallVCardResult()");
    }

    public void a(int n, AdbEntry[] adbEntryArray) {
        System.out.println("parseVCardDirectoryResult()");
    }

    public void a(int n, int[] nArray, int n2, String string) {
        System.out.println("smallExportFinished()");
    }

    public void a(int n) {
        new Exception().printStackTrace(System.out);
    }

    @Override
    public void exportSmallVCardResult(int n, String string, int n2) {
        new Exception().printStackTrace(System.out);
    }

    @Override
    public void exportVCardResult(int n, String string, int n2) {
        new Exception().printStackTrace(System.out);
    }

    @Override
    public void parseVCardDirectoryResult(int n, AdbEntry[] adbEntryArray, int n2, int n3) {
        new Exception().printStackTrace(System.out);
    }

    @Override
    public void parseVCardResult(int n, AdbEntry adbEntry, int n2, int n3) {
        new Exception().printStackTrace(System.out);
    }

    @Override
    public void parsingFinished(int n) {
        new Exception().printStackTrace(System.out);
    }

    @Override
    public void smallExportFinished(int n, long[] lArray, int n2, String string, int n3) {
        new Exception().printStackTrace(System.out);
    }
}


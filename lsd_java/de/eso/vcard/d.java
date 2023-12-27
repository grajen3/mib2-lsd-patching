/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.eso.a.d.b;
import de.eso.vcard.b.g;
import de.eso.vcard.c;
import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserS;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserService;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public class d
implements VCardParserS {
    private int c = 0;
    private static c d;
    private int e = 0;
    private List f = new LinkedList();
    public static final int a;
    private static final String[] g;
    public static final Collection b;

    public d(int n) {
        de.eso.a.d.b.c(new StringBuffer().append("JVCARDPARSER is starting on instance ").append(n).toString());
        de.eso.vcard.b.g.a((String[])b.toArray(new String[0]));
        this.c = n;
        if (d == null) {
            d = new c("VCardParseWorker", 500);
        }
    }

    public void a() {
        de.eso.a.d.b.b(new StringBuffer().append("-> JVCARDPARSER[").append(this.c).append("] initialization started.").toString());
        Agent.start();
        VCardParserService vCardParserService = new VCardParserService(this.c, this);
        Agent.getAgent().registerService(vCardParserService);
        d.start(5);
        de.eso.a.d.b.b(new StringBuffer().append("<- JVCARDPARSER[").append(this.c).append("] initialization done.").toString());
    }

    public void b() {
        if (d != null && this.e == 1) {
            d.stop();
            this.e = 0;
        } else {
            --this.e;
        }
        TraceClient.exit();
    }

    public void c() {
        if (this.e == 0 && d != null) {
            d.start(5);
        }
        ++this.e;
    }

    public void a(String[] stringArray) {
        de.eso.vcard.b.g.a(stringArray);
    }

    @Override
    public void parseVCard(String string, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.a.d.b.c(new StringBuffer().append(string).append(" should be parsed.").toString());
        if (string == null) {
            de.eso.a.d.b.d("vcdFile was null");
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        File file = new File(string);
        if (!file.exists()) {
            de.eso.a.d.b.d(new StringBuffer().append("VCard not found: ").append(file.getAbsolutePath()).toString());
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        d.a(file, n, n2, vCardParserReply);
    }

    public void a(InputStream inputStream, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.a.d.b.c(new StringBuffer().append(inputStream).append(" should be parsed.").toString());
        if (inputStream == null) {
            de.eso.a.d.b.d("stream was null");
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        d.a(inputStream, n, n2, vCardParserReply);
    }

    @Override
    public void parseVCardDirectory(String string, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.a.d.b.c(new StringBuffer().append("vCard directory ").append(string).append(" should be parsed.").toString());
        if (string == null) {
            de.eso.a.d.b.d("fullPathToVCardDir was null");
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        d.a(string, n, n2, vCardParserReply);
    }

    @Override
    public void exportVCard(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
        d.a(adbEntry, string, n, vCardParserReply);
    }

    public void a(int n, VCardParserReply vCardParserReply) {
        d.a(n, 0, vCardParserReply);
    }

    @Override
    public void finishExport(int n, int n2, VCardParserReply vCardParserReply) {
        d.a(n, n2, vCardParserReply);
    }

    @Override
    public void finishParsing(int n, VCardParserReply vCardParserReply) {
        d.a(n, vCardParserReply);
    }

    @Override
    public void setBinaryContentQuotaPerFile(long l, VCardParserReply vCardParserReply) {
        de.eso.vcard.b.g.a(l);
        vCardParserReply.setBinaryContentQuotaPerFileResult(0, l);
    }

    @Override
    public void setBinaryContentTempPath(String string, VCardParserReply vCardParserReply) {
        if (string == null) {
            vCardParserReply.setBinaryContentTempPathResult(2, null);
            return;
        }
        File file = new File(string);
        if (!file.exists() || !file.canWrite()) {
            vCardParserReply.setBinaryContentTempPathResult(2, string);
            return;
        }
        de.eso.vcard.b.g.a(new File(string));
        vCardParserReply.setBinaryContentTempPathResult(0, string);
    }

    @Override
    public void exportSmallVCard(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
        d.a(adbEntry, string, n, this.f, vCardParserReply);
    }

    @Override
    public void finishSmallExport(String string, int n, VCardParserReply vCardParserReply) {
        d.a(n, this.f, string, vCardParserReply);
    }

    @Override
    public void setExtendedAddressHandling(boolean bl, VCardParserReply vCardParserReply) {
        de.eso.vcard.b.g.a(bl);
    }

    static {
        g = new String[]{"BEGIN", "VERSION", "END", "N", "FN", "EMAIL", "BDAY", "URL", "ADR", "TEL", "ORG", "PHOTO", "GEO", "X-MIB_HIGH_NAV_LOCATION", "SOUND", "X-PHONETIC-FIRST-NAME", "X-PHONETIC-LAST-NAME"};
        b = Collections.unmodifiableCollection(Arrays.asList(g));
        Collections.unmodifiableCollection(Arrays.asList(g));
    }
}


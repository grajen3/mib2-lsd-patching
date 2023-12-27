/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.b.f;
import de.eso.a.d.b;
import de.eso.vcard.a.d;
import de.eso.vcard.b.a;
import de.eso.vcard.b.g;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public class c
implements de.eso.a.a.a {
    private String b;
    private int c;
    private int d;
    private VCardParserReply e;
    List a = new LinkedList();

    public c(String string, int n, int n2, VCardParserReply vCardParserReply) {
        this.b = string;
        this.c = n;
        this.d = n2;
        this.e = vCardParserReply;
    }

    @Override
    public void a() {
        try {
            this.b();
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d(new StringBuffer().append("Cannot send reply parseVCardDirectoryResult: ").append(methodException.getMessage()).toString());
        }
    }

    private void b() {
        if (this.b == null || this.b.length() < 1) {
            de.eso.a.d.b.a(new StringBuffer().append(this.b).append(" IS NOT A VCARD FOLDER! Ignoring parseVCard call, sending FILE_NOT_FOUND result.").toString());
            this.e.parseVCardDirectoryResult(2, null, this.c, this.d);
            return;
        }
        File file = new File(this.b);
        if (file.exists()) {
            int n = 0;
            d d2 = new d(this);
            if (file.isDirectory()) {
                int n2 = 0;
                File[] fileArray = file.listFiles(d2);
                if (fileArray != null) {
                    for (int i2 = 0; i2 < fileArray.length; ++i2) {
                        n2 = this.a(fileArray[i2]);
                        if (n2 == 0) continue;
                        n = n2;
                    }
                } else {
                    n = 2;
                }
            } else if (d2.accept(file.getParentFile(), file.getName())) {
                n = this.a(file);
            } else {
                de.eso.a.d.b.a(new StringBuffer().append(this.b).append(" is an existing file, but it's not a .vcf file").toString());
                n = 1;
            }
            AdbEntry[] adbEntryArray = (AdbEntry[])this.a.toArray(new AdbEntry[this.a.size()]);
            this.e.parseVCardDirectoryResult(n, adbEntryArray, this.c, this.d);
        } else {
            de.eso.a.d.b.a(new StringBuffer().append(this.b).append(" IS NOT A VCARD FOLDER! Ignoring parseVCard call, sending FILE_NOT_FOUND result.").toString());
            this.e.parseVCardDirectoryResult(2, null, this.c, this.d);
        }
    }

    private int a(File file) {
        AdbEntry adbEntry = new AdbEntry();
        a a2 = new a(adbEntry, g.e());
        try {
            g g2 = new g(file, (f)a2);
            g2.a();
            if (adbEntry == null || adbEntry.personalData == null) {
                return 1;
            }
            this.a.add(adbEntry);
        }
        catch (FileNotFoundException fileNotFoundException) {
            this.a.add(null);
            return 2;
        }
        catch (IOException iOException) {
            this.a.add(null);
            return 3;
        }
        catch (Throwable throwable) {
            de.eso.a.d.b.d(new StringBuffer().append("Severe vcard error: ").append(throwable.getMessage()).toString());
            this.a.add(null);
            return 3;
        }
        return 0;
    }

    static String a(c c2) {
        return c2.b;
    }
}


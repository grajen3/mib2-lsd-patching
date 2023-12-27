/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.d.b;
import de.eso.vcard.d.a;
import de.eso.vcard.d.c;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public class g
implements de.eso.a.a.a {
    private AdbEntry b;
    private String c;
    private VCardParserReply d;
    protected int a;
    private boolean e;
    private List f;
    private static de.eso.a.e.b g = new de.eso.a.e.b(".vcf");

    public g(AdbEntry adbEntry, String string, int n, boolean bl, List list, VCardParserReply vCardParserReply) {
        this.b = adbEntry;
        this.c = string;
        this.d = vCardParserReply;
        this.a = n;
        this.e = bl;
        this.f = list;
    }

    public a a(AdbEntry adbEntry, File file) {
        if (this.e) {
            return new de.eso.vcard.d.b(adbEntry, file);
        }
        return new a(adbEntry, file);
    }

    private void a(int n, String string, int n2) {
        if (this.e) {
            this.d.exportSmallVCardResult(n, string, n2);
        } else {
            this.d.exportVCardResult(n, string, n2);
        }
    }

    private void b() {
        boolean bl;
        if (this.b == null) {
            de.eso.a.d.b.d("entry is null");
            this.a(3, this.c, this.a);
            return;
        }
        if (this.b.combinedName == null) {
            de.eso.a.d.b.d("entry combinedName is null");
            this.a(3, this.c, this.a);
            return;
        }
        if (this.c == null) {
            de.eso.a.d.b.d("vCardPath is null");
            if (this.f != null) {
                this.f.add(new Long(this.b.entryId));
            }
            this.a(2, this.c, this.a);
            return;
        }
        File file = new File(this.c);
        if (!file.exists() && !(bl = file.mkdirs())) {
            de.eso.a.d.b.d(new StringBuffer().append("Can not create path: ").append(file.getAbsolutePath()).toString());
            if (this.f != null) {
                this.f.add(new Long(this.b.entryId));
            }
            this.a(2, this.c, this.a);
            return;
        }
        File file2 = null;
        if (!file.canWrite()) {
            de.eso.a.d.b.d(new StringBuffer().append("Can not write to: ").append(file.getAbsolutePath()).toString());
            if (this.f != null) {
                this.f.add(new Long(this.b.entryId));
            }
            this.a(2, this.c, this.a);
            return;
        }
        file2 = g.a(file, this.b.combinedName);
        a a2 = this.a(this.b, file2);
        try {
            a2.a();
            if (file2 == null) {
                de.eso.a.d.b.d("Can not write to: null");
                this.a(2, null, this.a);
                return;
            }
            de.eso.a.d.b.c(new StringBuffer().append(file2).append(" has been written. Sending result.").toString());
            this.a(0, file2.getAbsolutePath(), this.a);
        }
        catch (IOException iOException) {
            String string = file2 != null ? file2.getAbsolutePath() : " vcardFile = null";
            de.eso.a.d.b.d(new StringBuffer().append("Error writing VCard to ").append(string).toString());
            try {
                if (this.f != null) {
                    this.f.add(new Long(this.b.entryId));
                }
                this.a(2, string, this.a);
            }
            catch (MethodException methodException) {
                methodException.printStackTrace();
            }
        }
        catch (c c2) {
            de.eso.a.d.b.d(new StringBuffer().append("Error writing VCard :").append(c2.getMessage()).toString());
            try {
                if (this.f != null) {
                    this.f.add(new Long(-1L));
                }
                this.a(3, null, this.a);
            }
            catch (MethodException methodException) {
                methodException.printStackTrace();
            }
        }
    }

    @Override
    public void a() {
        try {
            this.b();
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d(new StringBuffer().append("Cannot send reply message: ").append(methodException.getMessage()).toString());
        }
    }
}


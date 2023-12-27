/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.b.f;
import de.eso.vcard.b.a;
import de.eso.vcard.b.g;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.dsi.ifc.organizer.AdbEntry;

public class b
implements de.eso.a.a.a {
    protected File a;
    protected InputStream b;
    protected VCardParserReply c;
    protected int d;
    protected int e;

    public b(InputStream inputStream, int n, int n2, VCardParserReply vCardParserReply) {
        this.a = null;
        this.b = inputStream;
        this.c = vCardParserReply;
        this.d = n;
        this.e = n2;
    }

    public b(File file, int n, int n2, VCardParserReply vCardParserReply) {
        this.b = null;
        this.a = file;
        this.c = vCardParserReply;
        this.d = n;
        this.e = n2;
    }

    @Override
    public void a() {
        block14: {
            AdbEntry adbEntry = new AdbEntry();
            a a2 = new a(adbEntry, g.e());
            g g2 = null;
            try {
                if (this.a != null) {
                    this.b = new BufferedInputStream(new FileInputStream(this.a));
                }
                g2 = new g(this.b, (f)a2);
                g2.a();
                try {
                    if (adbEntry == null || adbEntry.personalData == null) {
                        this.c.parseVCardResult(1, adbEntry, this.d, this.e);
                        break block14;
                    }
                    this.c.parseVCardResult(0, adbEntry, this.d, this.e);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            }
            catch (FileNotFoundException fileNotFoundException) {
                try {
                    this.c.parseVCardResult(2, adbEntry, this.d, this.e);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            }
            catch (IOException iOException) {
                try {
                    this.c.parseVCardResult(3, adbEntry, this.d, this.e);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            }
            catch (Throwable throwable) {
                try {
                    de.eso.a.d.b.d(new StringBuffer().append("Severe vcard error: ").append(throwable.getMessage()).toString());
                    this.c.parseVCardResult(3, adbEntry, this.d, this.e);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            }
        }
    }
}


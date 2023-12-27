/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.c;

import de.eso.a.b.f;
import de.eso.a.d.b;
import de.eso.vcard.b.a;
import de.eso.vcard.b.g;
import de.eso.vcard.c.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.dsi.ifc.organizer.AdbEntry;

class d
implements de.eso.a.c.b {
    int a;
    int b;

    public d(int n, int n2) {
        this.b = n;
        this.a = n2;
    }

    public d() {
        this.a = -1;
        this.b = -1;
    }

    @Override
    public boolean a(File file) {
        Object object;
        de.eso.a.d.b.c("\n\n");
        de.eso.a.d.b.c("-------------------------------------------------------");
        de.eso.a.d.b.c(new StringBuffer().append("-- testrunner parsing ").append(file.getAbsolutePath()).toString());
        de.eso.a.d.b.c("-------------------------------------------------------");
        AdbEntry adbEntry = new AdbEntry();
        a a2 = null;
        if (this.a > 0) {
            object = new c(this.b, this.a);
            a2 = new a((de.eso.a.a.b)object, false);
        } else {
            a2 = new a(adbEntry, false);
        }
        try {
            object = new g(file, (f)a2);
            ((de.eso.a.b.a)object).a();
            de.eso.a.d.b.c(adbEntry.toString());
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean a(InputStream inputStream) {
        de.eso.a.d.b.c("\n\n");
        de.eso.a.d.b.c("-------------------------------------------------------");
        de.eso.a.d.b.c(new StringBuffer().append("-- testrunner parsing ").append(inputStream.toString()).toString());
        de.eso.a.d.b.c("-------------------------------------------------------");
        c c2 = new c(this.b, this.a);
        a a2 = new a(c2, false);
        try {
            g g2 = new g(inputStream, (f)a2);
            g2.a();
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.d;

import de.eso.a.b.f;
import de.eso.a.d.b;
import de.eso.vcalendar.b.d;
import de.eso.vcalendar.e.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class c
implements de.eso.a.c.b {
    c() {
    }

    @Override
    public boolean a(File file) {
        b.c("\n\n");
        b.c("-------------------------------------------------------");
        b.c(new StringBuffer().append("-- testrunner parsing ").append(file.getAbsolutePath()).toString());
        b.c("-------------------------------------------------------");
        d d2 = new d();
        de.eso.vcalendar.c.a a2 = new de.eso.vcalendar.c.a(d2);
        try {
            de.eso.vcalendar.c.c c2 = new de.eso.vcalendar.c.c(file, (f)a2);
            c2.a();
            String string = file.getName().substring(0, file.getName().length() - 4);
            string = a.a(string, '_', " ");
            d2.c(string);
            d2.h(file.getAbsolutePath());
            b.c(d2.toString());
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean a(InputStream inputStream) {
        b.c("\n\n");
        b.c("-------------------------------------------------------");
        b.c(new StringBuffer().append("-- testrunner parsing ").append(inputStream.toString()).toString());
        b.c("-------------------------------------------------------");
        d d2 = new d();
        de.eso.vcalendar.c.a a2 = new de.eso.vcalendar.c.a(d2);
        de.eso.vcalendar.c.c c2 = new de.eso.vcalendar.c.c(inputStream, (f)a2);
        try {
            c2.a();
            for (int i2 = 0; i2 < 3; ++i2) {
                System.out.println(d2.toString());
            }
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }
}


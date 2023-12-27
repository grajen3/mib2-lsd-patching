/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.a;

import de.eso.a.a.a;
import de.eso.a.b.j;
import de.eso.a.d.b;
import de.eso.vcalendar.a.f;
import de.eso.vcalendar.b.d;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class c
implements a {
    private String a;
    private int b;
    private f c;
    private List d = new LinkedList();

    public c(String string, int n, f f2) {
        this.a = string;
        this.b = n;
        this.c = f2;
    }

    @Override
    public void a() {
        try {
            this.b();
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void b() {
        j j2;
        File[] fileArray;
        if (null == this.a || this.a.length() < 1) {
            de.eso.a.d.b.a("fullPathToICalenderDir == null or not is not a icalender folder!");
            this.c.a(2, null, this.b);
            return;
        }
        File file = new File(this.a);
        if (file.exists() && file.isDirectory() && null != (fileArray = file.listFiles(j2 = new j("ics"))) && fileArray.length > 0) {
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                this.a(fileArray[i2]);
            }
        }
    }

    private void a(File file) {
        d d2 = new d();
        de.eso.vcalendar.c.a a2 = new de.eso.vcalendar.c.a(d2);
        try {
            de.eso.vcalendar.c.c c2 = new de.eso.vcalendar.c.c(file, (de.eso.a.b.f)a2);
            c2.a();
            this.d.add(d2);
        }
        catch (FileNotFoundException fileNotFoundException) {
            de.eso.a.d.b.d(fileNotFoundException.getMessage());
        }
        catch (IOException iOException) {
            de.eso.a.d.b.d(iOException.getMessage());
        }
    }
}


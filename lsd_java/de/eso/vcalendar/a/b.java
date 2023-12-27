/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.a;

import de.eso.a.a.a;
import de.eso.vcalendar.a.f;
import de.eso.vcalendar.b.d;
import de.eso.vcalendar.c.c;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class b
implements a {
    File a;
    int b;
    f c;

    public b(File file, int n, f f2) {
        this.a = file;
        this.c = f2;
        this.b = n;
    }

    @Override
    public final void a() {
        d d2 = new d();
        de.eso.vcalendar.c.a a2 = new de.eso.vcalendar.c.a(d2);
        try {
            c c2 = new c(this.a, (de.eso.a.b.f)a2);
            c2.a();
            if (null == d2 || null == a2) {
                try {
                    this.c.a(1, d2, this.b);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            } else {
                try {
                    d2.c(this.a.getName());
                    this.c.a(0, d2, this.b);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            de.eso.a.d.b.d(fileNotFoundException.getMessage());
            try {
                this.c.a(2, d2, this.b);
            }
            catch (MethodException methodException) {
                de.eso.a.d.b.d(methodException.getMessage());
                methodException.printStackTrace();
            }
        }
        catch (IOException iOException) {
            de.eso.a.d.b.d(iOException.getMessage());
            try {
                this.c.a(2, d2, this.b);
            }
            catch (MethodException methodException) {
                de.eso.a.d.b.d(methodException.getMessage());
                methodException.printStackTrace();
            }
        }
    }
}


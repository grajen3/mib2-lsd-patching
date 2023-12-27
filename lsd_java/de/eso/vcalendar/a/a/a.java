/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.a.a;

import de.eso.a.b.f;
import de.eso.vcalendar.b.d;
import de.eso.vcalendar.c.c;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.File;
import java.io.IOException;
import org.dsi.ifc.calendar.VCalendar;

public class a
implements de.eso.a.a.a {
    File a;
    VCalendarDbProviderProxy b;

    public a(File file, int n, VCalendarDbProviderProxy vCalendarDbProviderProxy) {
        this.b = vCalendarDbProviderProxy;
        this.a = file;
    }

    @Override
    public void a() {
        d d2 = new d();
        de.eso.vcalendar.c.a a2 = new de.eso.vcalendar.c.a(d2);
        try {
            c c2 = new c(this.a, (f)a2);
            c2.a();
            if (null == d2 || null == d2.f()) {
                try {
                    this.b.addEntries(0, 0, null);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            } else {
                try {
                    String string = this.a.getName().substring(0, this.a.getName().length() - 4);
                    string = de.eso.vcalendar.e.a.a(string, '_', " ");
                    d2.c(string);
                    d2.h(this.a.getAbsolutePath());
                    this.b.addEntries(0, 0, new VCalendar[0]);
                }
                catch (MethodException methodException) {
                    methodException.printStackTrace();
                }
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.starter.client;

import de.eso.vcalendar.starter.client.a;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.core.method.MethodException;
import java.io.File;
import java.util.TimerTask;

class b
extends TimerTask {
    private final a a;

    b(a a2) {
        this.a = a2;
    }

    @Override
    public void run() {
        try {
            if (de.eso.vcalendar.starter.client.a.a(this.a).isDead()) {
                de.eso.vcalendar.starter.client.a.a(this.a, null);
                de.eso.vcalendar.starter.client.a.a(this.a, null);
                de.eso.vcalendar.starter.client.a.a(this.a, new VCalendarDbProviderProxy(de.eso.vcalendar.starter.client.a.b(this.a), this.a));
                de.eso.vcalendar.starter.client.a.a(this.a, de.eso.vcalendar.starter.client.a.c(this.a).getProxy());
                de.eso.vcalendar.starter.client.a.d(this.a).log((short)3, "___________>reconnect the Organizer_App<_________");
            }
            if (!de.eso.vcalendar.starter.client.a.a(this.a).isAlive()) {
                de.eso.vcalendar.starter.client.a.a(this.a).connectAsync();
            }
            de.eso.vcalendar.starter.client.a.c(this.a).beginTransaction();
            de.eso.vcalendar.starter.client.a.d(this.a).log((short)3, new File(".").getAbsolutePath());
            if (this.a.a < de.eso.vcalendar.starter.client.a.f().length) {
                this.a.a(de.eso.vcalendar.starter.client.a.f()[this.a.a]);
                ++this.a.a;
            }
            de.eso.vcalendar.starter.client.a.d(this.a).log((short)3, "___________>parseVCalendar called<_________");
        }
        catch (MethodException methodException) {
            de.eso.vcalendar.starter.client.a.d(this.a).log((short)3, new StringBuffer().append("___________>MethodException e<_________").append(methodException.getMessage()).toString());
            methodException.printStackTrace();
        }
    }
}


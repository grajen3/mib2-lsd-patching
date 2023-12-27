/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.starter.client;

import de.eso.vcalendar.starter.client.Activator;
import de.eso.vcalendar.starter.client.b;
import de.eso.vcalendar.starter.client.d;
import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.calendar.VEvent;
import org.osgi.framework.BundleContext;

public class a
implements VCalendarDbProviderReply,
ILifecycleListener {
    private static final String[] e = new String[]{"myEven.ics", "test_attaced.ics", "4.4_bastille_day_party.ics", "4.6.1_anniversary_implicitly_transparent.ics", "4.6.1_business_event.ics", "4.6.1_transparent.ics", "eso_Brotzeitservice_Outlook2007.ics", "sc_calendar.ics", "test_attaced.ics", "test.ics", "Ferien_Bayern_2010.ics", "Ferien_Bayern_2011.ics", "Ferien_Bayern_2012.ics", "Kalenderwochen-2011-2020.ics"};
    int a = 0;
    private static final int f;
    private int g;
    private VCalendarDbProviderProxy h = null;
    private Proxy i = null;
    d b = null;
    private TraceChannel j;
    Timer c = new Timer(true);
    TimerTask d = new b(this);

    public a(int n, BundleContext bundleContext) {
        TraceClient.init("VCalendarDbProviderReply");
        this.j = TraceClient.createTraceChannel("VCalendarDbProviderReply");
        this.g = n;
        this.h = new VCalendarDbProviderProxy(n, this);
        this.h.getProxy().getLifecycle().setListener(this);
        this.i = this.h.getProxy();
        this.i.connectAsync();
        de.eso.a.d.b.c(new StringBuffer().append("VCalendarParser starting on instance id=").append(this.g).toString());
        this.c.schedule(this.d, 0, (long)0);
        if (this.b == null) {
            de.eso.a.d.b.c("SerializationWorker starting");
            this.b = new d("SerializationWorker", 500);
            de.eso.a.d.b.c("SerializationWorker started");
            this.b.start(Activator.a);
        }
    }

    public boolean a() {
        boolean bl = false;
        if (this.h == null) {
            this.h = new VCalendarDbProviderProxy(this.g, this);
            if (this.h != null) {
                this.i = this.h.getProxy();
                if (this.i != null) {
                    // empty if block
                }
            }
        } else if (this.i == null) {
            this.i = this.h.getProxy();
            Lifecycle lifecycle = this.i.getLifecycle();
            if (lifecycle != null) {
                lifecycle.setListener(this);
            }
        }
        if (this.i != null) {
            bl = this.i.isAlive() ? true : this.i.connectAsync();
        }
        return bl;
    }

    public boolean b() {
        boolean bl = true;
        if (this.h != null && this.i != null) {
            try {
                if (this.i.isAlive()) {
                    this.i.disconnectAsync();
                    this.i.waitUntilDead();
                }
            }
            catch (InterruptedException interruptedException) {
                bl = false;
            }
            this.i = null;
            this.h = null;
        }
        return bl;
    }

    public void c() {
        if (this.i != null) {
            de.eso.a.d.b.c(new StringBuffer().append("CalendarDBClient alive state =").append(this.i.isAlive()).toString());
        }
    }

    public void d() {
        this.b();
        try {
            this.a();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void e() {
        de.eso.a.d.b.b(new StringBuffer().append("-> JVCALENDAR[").append(this.g).append("] initialization started.").toString());
        this.b.start(Activator.a);
        de.eso.a.d.b.b(new StringBuffer().append("<- JVCALENDAR[").append(this.g).append("] initialization done.").toString());
    }

    private boolean a(int n) {
        boolean bl = true;
        switch (n) {
            case 0: {
                bl = false;
                break;
            }
            case 2: {
                break;
            }
            case 4: {
                break;
            }
            case 3: {
                break;
            }
        }
        return bl;
    }

    public void a(String string) {
        this.j.log((short)3, "_______________>parseVCalendar<_______________");
        de.eso.a.d.b.c(new StringBuffer().append(string).append(" should be parsed.").toString());
        File file = new File(string);
        if (!file.exists()) {
            de.eso.a.d.b.d(new StringBuffer().append("VCalendar not found: ").append(file.getAbsolutePath()).toString());
            return;
        }
        if (this.h != null && this.i != null && this.i.isAlive()) {
            this.b.a(file, this.g, this.h);
            this.j.log((short)3, "_______________>worker.addSerializeObject added <_______________");
        }
    }

    public void a(int n, int n2, VCalendar[] vCalendarArray) {
        this.h.addEntries(n, n2, vCalendarArray);
    }

    @Override
    public void addEntriesResult(int n) {
        this.j.log((short)3, "_______________>addEntriesResult <_______________");
        this.a(n);
    }

    @Override
    public void beginTransactionResult(int n) {
    }

    @Override
    public void commitTransactionResult(int n) {
        this.h.commitTransaction();
    }

    @Override
    public void forceGetData() {
        int n = 0;
        this.h.forceGetDataResult(n);
    }

    public void a(VersionInfo[] versionInfoArray) {
    }

    @Override
    public void removeAllResult(int n) {
    }

    @Override
    public void removeEntriesResult(int n) {
    }

    @Override
    public void removeProfileResult(int n) {
    }

    @Override
    public void setActiveProfilesResult(int n) {
    }

    @Override
    public void lifecycleChanged(Lifecycle lifecycle, Object object) {
        this.j.log((short)3, "_______________>lifecycleChanged: Connected <_______________");
    }

    @Override
    public void getVersionResult(VersionInfo[] versionInfoArray) {
    }

    @Override
    public void deleteProfileResult(int n) {
    }

    @Override
    public void getCalendarConfigResult(int n, CalendarConfig calendarConfig) {
    }

    @Override
    public void getCalendarEntryResult(int n, VEvent vEvent) {
    }

    @Override
    public void getCalendarSummariesResult(int n, VEvent[] vEventArray) {
    }

    @Override
    public void insertProfileResult(int n) {
    }

    @Override
    public void setCalendarConfigResult(int n) {
    }

    static Proxy a(a a2) {
        return a2.i;
    }

    static VCalendarDbProviderProxy a(a a2, VCalendarDbProviderProxy vCalendarDbProviderProxy) {
        a2.h = vCalendarDbProviderProxy;
        return a2.h;
    }

    static Proxy a(a a2, Proxy proxy) {
        a2.i = proxy;
        return a2.i;
    }

    static int b(a a2) {
        return a2.g;
    }

    static VCalendarDbProviderProxy c(a a2) {
        return a2.h;
    }

    static TraceChannel d(a a2) {
        return a2.j;
    }

    static String[] f() {
        return e;
    }
}


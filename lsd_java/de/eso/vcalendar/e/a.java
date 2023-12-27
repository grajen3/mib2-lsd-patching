/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.e;

import de.eso.vcalendar.b.c;
import de.eso.vcalendar.b.d;
import de.eso.vcalendar.b.e;
import de.eso.vcalendar.b.h;
import de.eso.vcalendar.b.j;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.dsi.ifc.calendar.VAlarm;
import org.dsi.ifc.calendar.VAttendee;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.calendar.VEvent;
import org.dsi.ifc.calendar.VTimeZone;
import org.dsi.ifc.calendar.VTimeZoneStandard;

public class a {
    public static boolean a(byte[] byArray, int n) {
        if (n + "BEGIN".length() > byArray.length) {
            return false;
        }
        boolean bl = true;
        for (int i2 = n; i2 < n + "BEGIN".length(); ++i2) {
            byte by = byArray[i2];
            int n2 = i2 - n;
            if (a.a((char)by, "BEGIN".charAt(n2))) continue;
            bl = false;
            break;
        }
        return bl;
    }

    public static String a(String string, char c2, String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) != c2) {
                stringBuffer.append(string.charAt(i2));
                continue;
            }
            if (string.charAt(i2) != c2 || string2 == null) continue;
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    public static boolean a(char c2, char c3) {
        return c2 == c3 || c2 - 32 == c3 || c2 + 32 == c3;
    }

    public static VCalendar a(d d2) {
        int n;
        VCalendar vCalendar = new VCalendar();
        vCalendar.summary = d2.c();
        vCalendar.version = d2.f();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d2.g());
        arrayList.addAll(d2.h());
        arrayList.addAll(d2.i());
        arrayList.addAll(d2.j());
        int n2 = arrayList.size();
        vCalendar.vevent = new VEvent[n2];
        for (n = 0; n < n2; ++n) {
            vCalendar.vevent[n] = a.a(arrayList.get(n));
        }
        n = d2.d().size();
        vCalendar.timeZone = new VTimeZone[n];
        for (int i2 = 0; i2 < n; ++i2) {
            vCalendar.timeZone[i2] = a.a((h)d2.d().get(i2));
        }
        return vCalendar;
    }

    private static VTimeZone a(h h2) {
        int n;
        VTimeZone vTimeZone = new VTimeZone();
        ArrayList arrayList = new ArrayList();
        vTimeZone.tzID = h2.c();
        arrayList.addAll(h2.b());
        arrayList.addAll(h2.a());
        vTimeZone.daylight = new VTimeZoneStandard[h2.b().size()];
        vTimeZone.standard = new VTimeZoneStandard[h2.a().size()];
        for (n = 0; n < h2.b().size(); ++n) {
            if (h2.b().get(n) == null) continue;
            vTimeZone.daylight[n] = a.b((j)h2.b().get(n));
        }
        for (n = 0; n < h2.a().size(); ++n) {
            if (h2.a().get(n) == null) continue;
            vTimeZone.standard[n] = a.b((j)h2.a().get(n));
        }
        return vTimeZone;
    }

    private static VTimeZoneStandard b(Object object) {
        VTimeZoneStandard vTimeZoneStandard = new VTimeZoneStandard();
        j j2 = (j)object;
        vTimeZoneStandard.dtStart = j2.a();
        vTimeZoneStandard.rrule = j2.c();
        vTimeZoneStandard.tzOffsetFrom = j2.e();
        vTimeZoneStandard.tzOffsetTo = j2.f();
        vTimeZoneStandard.tzName = j2.d();
        vTimeZoneStandard.due = j2.g();
        vTimeZoneStandard.exdate = j2.h();
        vTimeZoneStandard.rdate = j2.b();
        return vTimeZoneStandard;
    }

    public static VEvent a(Object object) {
        VEvent vEvent = new VEvent();
        e e2 = (e)object;
        vEvent.entryType = e2.u();
        vEvent.categories = e2.q();
        vEvent.classTyp = e2.f();
        vEvent.created = e2.g();
        vEvent.description = e2.h();
        vEvent.dtEnd = e2.i();
        vEvent.dtStamp = e2.r();
        vEvent.dtStart = e2.j();
        vEvent.duration = e2.k();
        vEvent.lastModified = e2.l();
        vEvent.location = e2.m();
        vEvent.rrule = e2.c();
        vEvent.sequence = e2.a();
        vEvent.summary = e2.o();
        vEvent.uid = e2.p();
        vEvent.url = e2.t();
        if (e2.d() != null) {
            vEvent.alarm = a.a(e2.d());
        }
        List list = e2.e();
        c c2 = e2.s();
        boolean bl = c2 != null;
        int n = list.size();
        int n2 = n + (bl ? 1 : 0);
        vEvent.attendeeList = new VAttendee[n2];
        for (int i2 = 0; i2 < n; ++i2) {
            vEvent.attendeeList[i2] = a.a((c)list.get(i2));
        }
        if (bl) {
            vEvent.attendeeList[n] = a.a(c2);
        }
        return vEvent;
    }

    public static VAlarm a(de.eso.vcalendar.b.a a2) {
        VAlarm vAlarm = new VAlarm();
        vAlarm.trigger = a2.c();
        vAlarm.action = a2.a();
        vAlarm.description = a2.b();
        return vAlarm;
    }

    public static VAttendee a(c c2) {
        VAttendee vAttendee = new VAttendee();
        vAttendee.role = c2.d();
        vAttendee.cn = c2.a();
        vAttendee.cutype = c2.b();
        vAttendee.mailto = c2.c();
        vAttendee.rsvp = c2.e();
        return vAttendee;
    }

    private static String a(long l, int n) {
        long l2 = 1L << n * 4;
        return Long.toHexString(l2 | l & l2 - 1L);
    }

    public static String a() {
        byte[] byArray;
        String string = Calendar.getInstance().getTime().toString();
        try {
            byArray = string.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            byArray = string.getBytes();
        }
        long l = 0L;
        long l2 = 0L;
        if (byArray.length > 16) {
            int n;
            for (n = 0; n < 8; ++n) {
                l = l << 8 | (long)(byArray[n] & 0xFF);
            }
            for (n = 8; n < 16; ++n) {
                l2 = l2 << 8 | (long)(byArray[n] & 0xFF);
            }
        }
        string = new StringBuffer().append(a.a(l >> 32, 8)).append("-").append(a.a(l >> 16, 4)).append("-").append(a.a(l, 4)).append("-").append(a.a(l2 >> 48, 4)).append("-").append(a.a(l2, 12)).toString();
        return string;
    }
}


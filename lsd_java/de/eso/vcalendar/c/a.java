/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.c;

import de.eso.vcalendar.b.c;
import de.eso.vcalendar.b.d;
import de.eso.vcalendar.b.e;
import de.eso.vcalendar.b.f;
import de.eso.vcalendar.b.g;
import de.eso.vcalendar.b.h;
import de.eso.vcalendar.b.i;
import de.eso.vcalendar.b.j;
import de.eso.vcalendar.b.k;
import de.eso.vcalendar.c.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a
implements de.eso.a.b.f {
    private String a = null;
    private String b = null;
    private de.eso.a.b.i c = new de.eso.a.b.h();
    private List d = new ArrayList();
    private d e = null;
    private Object f = null;
    private LinkedList g = new LinkedList();
    private int h = 0;
    private de.eso.a.a.b i;

    public a(d d2) {
        this.e = d2;
        this.i = new b(this);
    }

    public a(de.eso.a.a.b b2) {
        this.e = new d();
        this.i = b2;
    }

    @Override
    public void d(String string) {
    }

    @Override
    public void a(String string) {
        if (string != null) {
            string = string.toUpperCase();
        }
        this.a = string;
    }

    @Override
    public void e() {
        this.a(this.a, this.c, this.d);
        this.a = null;
        this.b = null;
        this.c.clear();
        this.d.clear();
    }

    @Override
    public void d() {
        String string;
        if (this.g()) {
            return;
        }
        if (this.g.size() > 1) {
            this.g.removeLast();
        }
        String string2 = string = this.g.size() == 0 || this.g.getLast() == null ? "" : (String)this.g.getLast();
        if (string.length() == 0 || string.equals("")) {
            this.f = null;
            return;
        }
        if (string.equalsIgnoreCase("VTIMEZONE")) {
            int n = this.e.d().size() - 1;
            this.f = this.e.d().get(n);
        } else if (string.equalsIgnoreCase("VCALENDAR")) {
            this.f(new StringBuffer().append("countImportedObjects = ").append(this.h).append(" maxAmountOfImportObjects = ").append(this.i.a()).toString());
            if (this.h >= this.i.a()) {
                this.g.clear();
                return;
            }
            this.f = this.e;
            ++this.h;
        }
    }

    @Override
    public void b(String string) {
        if (string != null) {
            string = string.toUpperCase();
        }
        this.b = string;
    }

    @Override
    public void c(String string) {
        if (string != null) {
            string = string.toUpperCase();
        }
        this.c.put(this.b, string);
    }

    @Override
    public void a(String string, int n) {
        this.d.add(string);
    }

    @Override
    public void a(File file, int n) {
        this.d.add(file);
    }

    @Override
    public void a(byte[] byArray, int n) {
        this.d.add(byArray);
    }

    private void a(String string, de.eso.a.b.i i2, List list) {
        if (string == null) {
            return;
        }
        if ("BEGIN".equalsIgnoreCase(string)) {
            if (list != null && list.size() > 0) {
                String string2 = (String)list.get(0);
                this.e(string2);
            }
        } else {
            if ("END".equalsIgnoreCase(string)) {
                return;
            }
            this.c(string, i2, list);
        }
    }

    private void e(String string) {
        if (string != null && string.length() > 0) {
            if (this.h >= this.i.a()) {
                this.g.clear();
                return;
            }
            if (string.equalsIgnoreCase("VCALENDAR")) {
                this.g.clear();
                if (this.e == null) {
                    this.e = new d();
                }
                this.f = this.e;
            } else if (string.equalsIgnoreCase("VTIMEZONE")) {
                h h2 = new h();
                this.e.d().add(h2);
                this.f = h2;
            } else if (string.equalsIgnoreCase("STANDARD")) {
                h h3 = (h)this.f;
                j j2 = new j();
                j2.i("STANDARD");
                h3.a().add(j2);
                this.f = j2;
            } else if (string.equalsIgnoreCase("DAYLIGHT")) {
                h h4 = (h)this.f;
                i i2 = new i();
                i2.i("DAYLIGHT");
                h4.b().add(i2);
                this.f = i2;
            } else if (string.equalsIgnoreCase("VEVENT")) {
                e e2 = new e();
                e2.r("VEVENT");
                this.e.g().add(e2);
                this.f = e2;
            } else if (string.equalsIgnoreCase("VJOURNAL")) {
                g g2 = new g();
                g2.r("VJOURNAL");
                this.e.i().add(g2);
                this.f = g2;
            } else if (string.equalsIgnoreCase("VEVENT")) {
                f f2 = new f();
                f2.r("FREEBUSY");
                this.e.h().add(f2);
                this.f = f2;
            } else if (string.equalsIgnoreCase("VTODO")) {
                k k2 = new k();
                k2.r("VTODO");
                this.e.j().add(k2);
                this.f = k2;
            } else if (string.equalsIgnoreCase("VALARM")) {
                this.a();
            } else {
                StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
                int n = stackTraceElement.getLineNumber();
                String string2 = stackTraceElement.getMethodName();
                this.f(new StringBuffer().append(string2).append("-").append(n).append("conversion for ").append(string).append(" is not implemented").toString());
            }
            this.g.add(string);
        }
    }

    private void a() {
        if (this.f instanceof e) {
            e e2 = (e)this.f;
            de.eso.vcalendar.b.a a2 = new de.eso.vcalendar.b.a();
            e2.a(a2);
            this.f = a2;
        } else if (this.f instanceof g) {
            g g2 = (g)this.f;
            de.eso.vcalendar.b.a a3 = new de.eso.vcalendar.b.a();
            g2.a(a3);
            this.f = a3;
        } else if (this.f instanceof f) {
            f f2 = (f)this.f;
            de.eso.vcalendar.b.a a4 = new de.eso.vcalendar.b.a();
            f2.a(a4);
            this.f = a4;
        }
    }

    private void b(String string, de.eso.a.b.i i2, List list) {
        d d2 = (d)this.f;
        if (string.equalsIgnoreCase("VERSION")) {
            d2.e(this.a(list, 0));
        } else if (string.equalsIgnoreCase("DESCRIPTION")) {
            d2.a(this.a(list, 0));
        } else if (string.equalsIgnoreCase("DTSTART")) {
            String string2 = de.eso.vcalendar.e.a.a(this.a(i2, "TZID"), '\"', null);
            if (string2 != null && string2.length() > 0) {
                String string3 = de.eso.vcalendar.e.a.a(this.a(list, 0), '\"', "");
                d2.f(this.a(string2, string3));
            } else {
                d2.f(this.a(list, 0));
            }
        } else if (string.equalsIgnoreCase("DTEND")) {
            String string4 = de.eso.vcalendar.e.a.a(this.a(i2, "TZID"), '\"', null);
            if (string4 != null && string4.length() > 0) {
                String string5 = de.eso.vcalendar.e.a.a(this.a(list, 0), '\"', null);
                d2.g(new StringBuffer().append("TZID=\"").append(this.a(string4, string5)).toString());
            } else {
                d2.g(this.a(list, 0));
            }
        } else if (string.equalsIgnoreCase("SUMMARY")) {
            d2.c(this.a(list, 0));
        } else {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
            int n = stackTraceElement.getLineNumber();
            String string6 = stackTraceElement.getMethodName();
            this.f(new StringBuffer().append(string6).append("-LINE:").append(n).append("- VCalendar-Reader does not support property ").append(string).append("").toString());
        }
    }

    private void c(String string, de.eso.a.b.i i2, List list) {
        if (this.f instanceof d) {
            this.b(string, i2, list);
        } else if (this.f instanceof h) {
            h h2 = (h)this.f;
            h2.a((String)list.get(0));
        } else if (this.f instanceof j || this.f instanceof i) {
            this.e(string, i2, list);
        } else if (this.f instanceof e || this.f instanceof g || this.f instanceof f) {
            this.d(string, i2, list);
        } else if (this.f instanceof de.eso.vcalendar.b.a) {
            this.a(string, (Map)i2, list);
        } else {
            int n = new Exception().getStackTrace()[0].getLineNumber();
            this.f(new StringBuffer().append(super.getClass().getName()).append("-LINE:").append(n).append("- converter for ").append(this.f.getClass().getName()).append(" ist not implemented").toString());
        }
    }

    private void a(String string, Map map, List list) {
        de.eso.vcalendar.b.a a2 = (de.eso.vcalendar.b.a)this.f;
        if (string.equalsIgnoreCase("ACTION")) {
            a2.a(this.a(list, 0));
        } else if (string.equalsIgnoreCase("DESCRIPTION")) {
            a2.b(this.a(list, 0));
        } else if (string.equalsIgnoreCase("TRIGGER")) {
            a2.c(this.a(list, 0));
        } else {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
            int n = stackTraceElement.getLineNumber();
            String string2 = stackTraceElement.getMethodName();
            this.f(new StringBuffer().append(string2).append("-LINE:").append(n).append("- VCalendar-Reader does not support property ").append(string).append("").toString());
        }
    }

    private String a(String string, String string2) {
        string = string2.indexOf(58) > 0 ? de.eso.vcalendar.e.a.a(string2, ':', "") : string2;
        return string;
    }

    private void d(String string, de.eso.a.b.i i2, List list) {
        e e2 = (e)this.f;
        if (string.equalsIgnoreCase("CREATED")) {
            e2.e(this.a(list, 0));
        } else if (string.equalsIgnoreCase("UID")) {
            e2.n(this.a(list, 0));
        } else if (string.equalsIgnoreCase("SUMMARY")) {
            e2.m(this.a(list, 0));
        } else if (string.equalsIgnoreCase("DTSTAMP")) {
            e2.p(this.a(list, 0));
        } else if (string.equalsIgnoreCase("LAST-MODIFIED")) {
            e2.j(this.a(list, 0));
        } else if (string.equalsIgnoreCase("DTSTART")) {
            String string2 = de.eso.vcalendar.e.a.a(this.a(i2, "TZID"), '\"', null);
            if (string2 != null && string2.length() > 0) {
                String string3 = de.eso.vcalendar.e.a.a(this.a(list, 0), '\"', null);
                e2.h(this.a(string2, string3));
            } else {
                e2.h(this.a(list, 0));
            }
        } else if (string.equalsIgnoreCase("DTEND")) {
            String string4 = de.eso.vcalendar.e.a.a(this.a(i2, "TZID"), '\"', null);
            if (string4 != null && string4.length() > 0) {
                String string5 = de.eso.vcalendar.e.a.a(this.a(list, 0), '\"', null);
                e2.g(this.a(string4, string5));
            } else {
                e2.g(this.a(list, 0));
            }
        } else if (string.equalsIgnoreCase("CLASS")) {
            e2.d(this.a(list, 0));
        } else if (string.equalsIgnoreCase("DESCRIPTION")) {
            e2.f(this.a(list, 0));
        } else if (string.equalsIgnoreCase("LOCATION")) {
            e2.k(this.a(list, 0));
        } else if (string.equalsIgnoreCase("TRANSP")) {
            e2.b(this.a(list, 0));
        } else if (string.equalsIgnoreCase("ORGANIZER")) {
            e2.a(this.a(i2, list));
        } else if (string.equalsIgnoreCase("ATTACH")) {
            this.b(i2, list);
        } else if (string.equalsIgnoreCase("ATTENDEE")) {
            e2.e().add(this.a(i2, list));
        } else if (string.equalsIgnoreCase("RRULE")) {
            e2.c(this.a(list, 0));
        } else if (string.equalsIgnoreCase("SEQUENCE")) {
            e2.a(this.a(list, 0));
        } else if (string.equalsIgnoreCase("CATEGORIES")) {
            e2.o(this.a(list, 0));
        } else if (string.equalsIgnoreCase("URL")) {
            e2.q(this.a(list, 0));
        } else {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
            int n = stackTraceElement.getLineNumber();
            String string6 = stackTraceElement.getMethodName();
            this.f(new StringBuffer().append(string6).append("-LINE:").append(n).append("- VCalendar-Reader does not support property ").append(string).append("").toString());
        }
        if (e2.p() == null) {
            e2.n(de.eso.vcalendar.e.a.a());
        }
    }

    private c a(de.eso.a.b.i i2, List list) {
        c c2 = new c();
        String string = this.a(i2, "CN");
        String string2 = this.a(i2, "RSVP");
        String string3 = this.a(i2, "ROLE");
        String string4 = this.a(i2, "CUTYPE");
        String string5 = this.a(list, 0);
        c2.a(string);
        c2.e(string2);
        c2.c(string5);
        c2.b(string4);
        c2.d(string3);
        return c2;
    }

    private void b(de.eso.a.b.i i2, List list) {
        block12: {
            if (i2.containsKey("X-FILENAME")) {
                Object object = i2.get("X-FILENAME");
                if (object == null) {
                    return;
                }
                if (object instanceof ArrayList) {
                    try {
                        String string;
                        ArrayList arrayList = (ArrayList)object;
                        String string2 = (String)arrayList.get(0);
                        if (list == null || list.get(0) == null) break block12;
                        File file = (File)list.get(0);
                        if (file.renameTo(new File(new StringBuffer().append(string = file.getPath().substring(0, file.getPath().lastIndexOf(47) + 1)).append(string2).toString()))) {
                            de.eso.a.d.b.c(new StringBuffer().append("rename okay ").append(file.getAbsoluteFile()).toString());
                            break block12;
                        }
                        de.eso.a.d.b.d(new StringBuffer().append("rename faild ").append(file.getAbsoluteFile()).toString());
                    }
                    catch (ClassCastException classCastException) {
                        this.f(classCastException.getMessage());
                    }
                }
            } else if (list != null && list.size() > 0) {
                Object object = list.get(0);
                if (object instanceof File) {
                    File file = (File)object;
                    if (file.exists() && !file.delete()) {
                        this.f(new StringBuffer().append(file).append(" can not be deleted").toString());
                    }
                } else if (object instanceof String) {
                    // empty if block
                }
            }
        }
    }

    private void e(String string, de.eso.a.b.i i2, List list) {
        j j2 = (j)this.f;
        if (string.equalsIgnoreCase("DTSTART")) {
            String string2 = de.eso.vcalendar.e.a.a(this.a(i2, "TZID"), '\"', null);
            if (string2 != null && string2.length() > 0) {
                String string3 = de.eso.vcalendar.e.a.a(this.a(list, 0), '\"', null);
                j2.a(new StringBuffer().append("TZID=\"").append(this.a(string2, string3)).toString());
            } else {
                j2.a(this.a(list, 0));
            }
        } else if (string.equalsIgnoreCase("RDATE")) {
            j2.b(this.a(list, 0));
        } else if (string.equalsIgnoreCase("TZOFFSETFROM")) {
            j2.e(this.a(list, 0));
        } else if (string.equalsIgnoreCase("TZOFFSETTO")) {
            j2.f(this.a(list, 0));
        } else if (string.equalsIgnoreCase("RRULE")) {
            j2.c(this.a(list, 0));
        } else if (string.equalsIgnoreCase("TZNAME")) {
            j2.d(this.a(list, 0));
        } else {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
            int n = stackTraceElement.getLineNumber();
            String string4 = stackTraceElement.getMethodName();
            this.f(new StringBuffer().append(string4).append("-LINE:").append(n).append("- VCalendar-Reader does not support property ").append(string).append("").toString());
        }
    }

    private void f(String string) {
        de.eso.a.d.b.a(new StringBuffer().append(super.getClass().getName()).append(" | ").append(string).toString());
    }

    private String a(List list, int n) {
        if (list == null || n >= list.size()) {
            return null;
        }
        return (String)list.get(n);
    }

    private String a(de.eso.a.b.i i2, String string) {
        if (i2 == null || i2.size() <= 0) {
            return "";
        }
        try {
            Object object = i2.get(string);
            if (object != null && object instanceof ArrayList) {
                StringBuffer stringBuffer = new StringBuffer();
                ArrayList arrayList = (ArrayList)object;
                if (arrayList.size() > 0) {
                    Iterator iterator = arrayList.iterator();
                    while (iterator.hasNext()) {
                        try {
                            String string2 = (String)iterator.next();
                            stringBuffer.append(string2);
                        }
                        catch (ClassCastException classCastException) {
                            this.f(classCastException.getMessage());
                        }
                    }
                    return stringBuffer.toString();
                }
            }
        }
        catch (ClassCastException classCastException) {
            this.f(classCastException.getMessage());
        }
        return "";
    }

    @Override
    public boolean g() {
        if (this.h >= this.i.a()) {
            return true;
        }
        return this.g.size() <= 0;
    }

    static d a(a a2, d d2) {
        a2.e = d2;
        return a2.e;
    }
}


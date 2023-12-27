/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.eso.vcard.b;

import de.eso.a.b.d;
import de.eso.a.b.f;
import de.eso.a.b.h;
import de.eso.a.b.i;
import de.eso.vcard.b.b;
import de.eso.vcard.b.c;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class a
implements f {
    private AdbEntry a;
    private String b;
    private String c = null;
    private String d = null;
    private boolean e = false;
    private i f = new h();
    private List g = new ArrayList();
    private de.eso.a.d.a h = new de.eso.a.d.a(10);
    private de.eso.a.d.a i = new de.eso.a.d.a(10);
    private de.eso.a.d.a j = new de.eso.a.d.a(10);
    private c k = new c();
    private de.eso.a.a.b l;
    private LinkedList m = new LinkedList();
    private int n = 1;
    private static DecimalFormat o = new DecimalFormat("########0.000000");
    private static final String p;
    private static final String q;
    private static final String r;
    private static final String s;
    private static final String t;
    private static final String u;
    private static final String v;
    private static final String w;
    private static final String x;
    private static final String y;
    private static final String z;
    private static final String A;
    private static final String B;
    private static final String C;
    private static final String D;

    private static void a() {
        DecimalFormatSymbols decimalFormatSymbols = o.getDecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        o.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    public a(AdbEntry adbEntry, boolean bl) {
        this.l = new b(this);
        this.a = adbEntry;
        this.e = bl;
        adbEntry.voiceTagId = -1;
        adbEntry.preferredNumberIdx = -1;
    }

    public a(de.eso.a.a.b b2, boolean bl) {
        this.a = new AdbEntry();
        this.l = b2;
        this.e = bl;
        this.a.voiceTagId = -1;
        this.a.preferredNumberIdx = -1;
    }

    private void b() {
        if (this.a.personalData == null) {
            this.a.personalData = new PersonalData();
        }
    }

    @Override
    public void d(String string) {
        this.b = string;
    }

    @Override
    public void a(String string) {
        if (string != null) {
            string = string.toUpperCase();
        }
        this.c = string;
    }

    @Override
    public void e() {
        this.a(this.c, this.f, this.g);
        this.c = null;
        this.d = null;
        this.b = null;
        this.f.clear();
        this.g.clear();
    }

    @Override
    public void d() {
        if (this.k != null && this.k.a() > 0) {
            this.a.addressData = (AddressData[])this.k.b().clone();
            this.k = new c();
        }
        if (this.i != null && this.i.a() > 0) {
            this.a.phoneData = (PhoneData[])this.i.a(new PhoneData[this.i.a()]);
            this.i.c();
        }
        if (this.h != null && this.h.a() > 0) {
            this.a.emailData = (EmailData[])this.h.a(new EmailData[this.h.a()]);
            this.h.c();
        }
        if (this.j != null && this.j.a() > 0) {
            this.a.urlData = (String[])this.j.a(new String[this.j.a()]);
            this.j.c();
        }
        this.c();
    }

    private void c() {
        if (this.n <= this.l.a()) {
            this.m.add(this.a);
            int n = this.n % this.l.b();
            if (n == 0 || this.n == this.l.a()) {
                this.m.removeAll(Collections.singletonList(null));
                this.l.a(this.m);
                this.m.clear();
            }
            this.a = null;
        }
        ++this.n;
    }

    @Override
    public void b(String string) {
        if (string != null) {
            string = string.toUpperCase();
        }
        this.d = string;
    }

    @Override
    public void c(String string) {
        if (string != null) {
            string = string.toUpperCase();
        }
        this.f.put(this.d, string);
    }

    @Override
    public void a(String string, int n) {
        this.g.add(string);
    }

    @Override
    public void a(File file, int n) {
        this.g.add(file);
    }

    @Override
    public void a(byte[] byArray, int n) {
        this.g.add(byArray);
    }

    private void a(String string, Map map, List list) {
        if (string == null) {
            return;
        }
        if ("N".equalsIgnoreCase(string)) {
            this.l(map, list);
        } else if ("FN".equalsIgnoreCase(string)) {
            this.k(map, list);
        } else if ("EMAIL".equalsIgnoreCase(string)) {
            this.j(map, list);
        } else if ("BDAY".equalsIgnoreCase(string)) {
            this.i(map, list);
        } else if ("URL".equalsIgnoreCase(string)) {
            this.h(map, list);
        } else if ("ADR".equalsIgnoreCase(string)) {
            this.g(map, list);
        } else if ("TEL".equalsIgnoreCase(string)) {
            this.f(map, list);
        } else if ("ORG".equalsIgnoreCase(string)) {
            this.e(map, list);
        } else if ("GEO".equalsIgnoreCase(string)) {
            this.d(map, list);
        } else if ("BEGIN".equalsIgnoreCase(string)) {
            if (this.a == null) {
                this.a = new AdbEntry();
                this.a.voiceTagId = -1;
                this.a.preferredNumberIdx = -1;
            }
            this.b();
        } else if (!("END".equalsIgnoreCase(string) || "VERSION".equalsIgnoreCase(string) || "TITLE".equalsIgnoreCase(string))) {
            if ("PHOTO".equalsIgnoreCase(string)) {
                this.c(map, list);
            } else if ("X-MIB_HIGH_NAV_LOCATION".equalsIgnoreCase(string)) {
                this.b(map, list);
            } else if ("SOUND".equalsIgnoreCase(string)) {
                this.a(map, list);
            } else if ("X-PHONETIC-FIRST-NAME".equalsIgnoreCase(string)) {
                String string2;
                this.a.personalData.firstNameSound = string2 = this.a(list);
            } else if ("X-PHONETIC-LAST-NAME".equalsIgnoreCase(string)) {
                String string3;
                this.a.personalData.lastNameSound = string3 = this.a(list);
            } else {
                this.e(new StringBuffer().append("AdbEntryContentHandler does not support VCard property ").append(string).toString());
            }
        }
    }

    private String a(List list) {
        String string = this.a(list, 0);
        this.b();
        return string;
    }

    private void a(Map map, List list) {
        if (map.containsValue("X-IRMC-N")) {
            this.b();
            this.a.personalData.lastNameSound = this.a(list, 0);
            this.a.personalData.firstNameSound = this.a(list, 1);
        } else if (map.containsValue("X-IRMC-ORG")) {
            this.b();
            this.a.personalData.organizationSound = this.a(list, 0);
        }
    }

    private void b(Map map, List list) {
        byte[] byArray;
        if (list == null || list.size() < 1) {
            return;
        }
        Object object = list.get(0);
        if (object instanceof byte[] && (byArray = (byte[])object) != null) {
            this.k.a(byArray, this.b);
        }
    }

    private void c(Map map, List list) {
        if (list == null || list.size() < 1) {
            return;
        }
        Object object = list.get(0);
        if (object instanceof File) {
            File file = (File)object;
            this.b();
            this.a.personalData.contactPicture = new ResourceLocator(file.getAbsolutePath());
        }
    }

    private void d(Map map, List list) {
        int n;
        String string = this.a(list, 0);
        String string2 = this.a(list, 1);
        if (string2 == null && string != null && (n = string.indexOf(32)) >= 0 && string.length() > n + 2) {
            string2 = string.substring(n + 1);
            string = string.substring(0, n);
        }
        if (string == null || string2 == null) {
            this.e("GEO property is not valid. Valid sample: \"GEO:37.386013;-122.082932\". Will be ommitted.");
            return;
        }
        double d2 = 0.0;
        double d3 = 0.0;
        try {
            d2 = Double.parseDouble((String)string);
            d3 = Double.parseDouble((String)string2);
        }
        catch (NumberFormatException numberFormatException) {
            this.e("Cannot parse geo position from String. Will be ommitted.");
            return;
        }
        string = o.format(d2);
        string2 = o.format(d3);
        int n2 = 0;
        if (map != null && map.size() > 0) {
            n2 = map.containsValue("HOME") ? (n2 |= 2) : (map.containsValue("WORK") ? (n2 |= 1) : 4);
        }
        this.k.a(string, string2, n2, this.b);
    }

    private void e(Map map, List list) {
        this.b();
        this.a.personalData.organization = this.a(list, 0);
    }

    private void f(Map map, List list) {
        if (list == null || list.size() < 1) {
            return;
        }
        String string = this.a(list, 0);
        if (string == null || string.length() < 1) {
            return;
        }
        PhoneData phoneData = new PhoneData();
        phoneData.number = string;
        int n = 0;
        if (map != null && map.size() > 0) {
            if (map.containsValue("MODEM")) {
                n |= 0x200;
            }
            if (map.containsValue("ISDN")) {
                n |= 0x800;
            }
            if (map.containsValue("CAR")) {
                n |= 0x400;
            }
            if (map.containsValue("BBS")) {
                n |= 0x100;
            }
            if (map.containsValue("HOME")) {
                n |= 4;
            }
            if (map.containsValue("MSG")) {
                n |= 0x20;
            }
            if (map.containsValue("CELL")) {
                n |= 0x40;
            }
            if (map.containsValue("WORK")) {
                n |= 2;
            }
            if (map.containsValue("VOICE")) {
                n |= 8;
            }
            if (map.containsValue("PAGER")) {
                n |= 0x80;
            }
            if (map.containsValue("FAX")) {
                n |= 0x10;
            }
            if (map.containsValue("VIDEO")) {
                n |= 0x1000;
            }
        }
        phoneData.numberType = n;
        if (map != null && map.size() > 0 && map.containsValue("PREF")) {
            this.i.a(phoneData);
            this.a.preferredNumberIdx = 0;
        } else {
            this.i.b(phoneData);
        }
    }

    private void g(Map map, List list) {
        if (list == null || list.size() < 1) {
            return;
        }
        AddressData addressData = new AddressData();
        if (this.e && (addressData.street == null || addressData.street.length() < 1)) {
            addressData.street = this.a(list, 1);
        }
        String string = this.a(list, 2);
        if (addressData.street == null || addressData.street.length() < 1) {
            addressData.street = string;
        } else if (string != null && string.length() > 0) {
            addressData.street = new StringBuffer().append(string).append(" ").append(addressData.street).toString();
        }
        addressData.locality = this.a(list, 3);
        addressData.region = this.a(list, 4);
        addressData.postalCode = this.a(list, 5);
        addressData.country = this.a(list, 6);
        if (map != null && map.size() > 0) {
            addressData.addressType = map.containsValue("HOME") ? (addressData.addressType |= 2) : (map.containsValue("WORK") ? (addressData.addressType |= 1) : 4);
        }
        boolean bl = false;
        if (map != null && map.size() > 0 && map.containsValue("PREF")) {
            bl = true;
        }
        this.k.a(addressData, bl, addressData.addressType, this.b);
    }

    private void h(Map map, List list) {
        if (list == null || list.size() < 1) {
            return;
        }
        String string = this.a(list, 0);
        if (string == null) {
            return;
        }
        if (map != null && map.size() > 0 && map.containsValue("PREF")) {
            this.j.a(string);
        } else {
            this.j.b(string);
        }
    }

    private void i(Map map, List list) {
        if (list == null || list.size() < 1) {
            return;
        }
        String string = this.a(list, 0);
        Date date = de.eso.a.b.d.a(string);
        if (date != null) {
            long l = date.getTime();
            this.b();
            this.a.personalData.birthday = new DateTime(l);
        }
    }

    private void j(Map map, List list) {
        if (list == null || list.size() < 1) {
            return;
        }
        String string = this.a(list, 0);
        if (string == null || string.length() < 1) {
            return;
        }
        EmailData emailData = new EmailData();
        emailData.emailAddr = string;
        emailData.emailType = map != null && map.size() > 0 && map.containsValue("INTERNET") ? 1 : 0;
        if (map != null && map.size() > 0 && map.containsValue("PREF")) {
            this.h.a(emailData);
        } else {
            this.h.b(emailData);
        }
    }

    private void k(Map map, List list) {
        if (this.a.personalData != null && (this.a.personalData.lastName != null || this.a.personalData.firstName != null)) {
            return;
        }
        this.b();
        this.a.personalData.lastName = this.a(list, 0);
    }

    private void l(Map map, List list) {
        String string = this.a(list, 0);
        String string2 = this.a(list, 1);
        this.b();
        this.a.personalData.lastName = string;
        this.a.personalData.firstName = string2;
    }

    private void e(String string) {
        de.eso.a.d.b.a(new StringBuffer().append(super.getClass().getName()).append(" | ").append(string).toString());
    }

    private String a(List list, int n) {
        if (list == null || n >= list.size()) {
            return null;
        }
        Object object = list.get(n);
        if (object instanceof String) {
            return (String)list.get(n);
        }
        return null;
    }

    @Override
    public boolean g() {
        return this.n > this.l.a();
    }

    static AdbEntry a(a a2, AdbEntry adbEntry) {
        a2.a = adbEntry;
        return a2.a;
    }

    static {
        de.eso.vcard.b.a.a();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.b;

import de.eso.a.d.b;
import de.eso.vcard.b.d;
import de.eso.vcard.b.e;
import de.eso.vcard.b.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.organizer.AddressData;

public class c {
    private Map a = new HashMap();
    private LinkedList b = new LinkedList();

    public int a() {
        return this.a.size();
    }

    public AddressData[] b() {
        AddressData[] addressDataArray = new AddressData[this.b.size()];
        Iterator iterator = this.b.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            d d2 = (d)iterator.next();
            addressDataArray[n++] = d2.c;
        }
        return addressDataArray;
    }

    private void a(d d2) {
        if (d2 == null || d2.c == null) {
            de.eso.a.d.b.d("Will not store address as it's null.");
            return;
        }
        Object object = this.a(d2.b, d2.a);
        d d3 = (d)this.a.get(object);
        if (d3 == null) {
            this.a.put(object, d2);
            if (d2.d) {
                this.b.addFirst(d2);
            } else {
                this.b.addLast(d2);
            }
        } else {
            if (d3.c != null) {
                byte[] byArray;
                String string = d3.c.geoPosition;
                if (string != null) {
                    d2.c.geoPosition = string;
                }
                if ((byArray = d3.c.navLocation) != null) {
                    d2.c.navLocation = byArray;
                }
            }
            this.a.put(object, d2);
            this.b.remove(d3);
            if (d2.d) {
                this.b.addFirst(d2);
            } else {
                this.b.addLast(d2);
            }
        }
    }

    private void a(f f2) {
        if (f2 == null || f2.c == null) {
            de.eso.a.d.b.d("Will not store navLocation as it's null.");
            return;
        }
        Object object = this.a(f2.b, f2.a);
        d d2 = (d)this.a.get(object);
        if (d2 == null || d2.c == null) {
            d d3 = new d();
            d3.c = new AddressData();
            d3.c.navLocation = f2.c;
            this.a.put(object, d3);
            this.b.add(d3);
        } else {
            d2.c.navLocation = f2.c;
        }
    }

    private void a(e e2) {
        if (e2 == null || e2.c == null) {
            de.eso.a.d.b.d("Will not store geoPosition as it's null.");
            return;
        }
        Object object = this.a(e2.b, e2.a);
        d d2 = (d)this.a.get(object);
        if (d2 == null || d2.c == null) {
            d d3 = new d();
            d3.c = new AddressData();
            d3.c.geoPosition = e2.c;
            this.a.put(object, d3);
            this.b.add(d3);
        } else {
            d2.c.geoPosition = e2.c;
        }
    }

    private Object a(String string, int n) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        Object object = null;
        object = string != null ? string : (n != 4 ? new Integer(n) : new Integer(this.a.size() + 1000));
        return object;
    }

    public void a(AddressData addressData, boolean bl, int n, String string) {
        d d2 = new d();
        d2.c = addressData;
        d2.d = bl;
        d2.a = n;
        d2.b = string;
        this.a(d2);
    }

    public void a(byte[] byArray, String string) {
        f f2 = new f();
        f2.c = byArray;
        f2.b = string;
        this.a(f2);
    }

    public void a(String string, String string2, int n, String string3) {
        e e2 = new e();
        e2.c = new StringBuffer().append(string).append(";").append(string2).toString();
        e2.a = n;
        e2.b = string3;
        this.a(e2);
    }
}


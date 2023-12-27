/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.d;

import de.esolutions.fw.util.commons.Buffer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class a {
    private List a;
    private List b;
    private int c = 0;
    private final int d;

    public a(int n) {
        this.d = n;
        this.a = new ArrayList(n);
        this.b = new ArrayList(n);
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.a.isEmpty() && this.b.isEmpty();
    }

    public Object[] a(Object[] objectArray) {
        if (objectArray.length < this.c) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), this.c);
        }
        for (int i2 = 0; i2 < this.c; ++i2) {
            objectArray[i2] = i2 < this.a.size() ? this.a.get(i2) : this.b.get(i2 - this.a.size());
        }
        return objectArray;
    }

    public boolean a(Object object) {
        if (this.a.size() >= this.d) {
            return false;
        }
        this.a.add(object);
        this.c = Math.min(this.d, this.c + 1);
        return true;
    }

    public boolean b(Object object) {
        if (this.b.size() >= this.d) {
            return false;
        }
        this.b.add(object);
        this.c = Math.min(this.d, this.c + 1);
        return true;
    }

    public void c() {
        this.a.clear();
        this.b.clear();
        this.c = 0;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("BoundedPriorityQueue [size=");
        buffer.append(this.c);
        buffer.append(", maxSize=");
        buffer.append(this.d);
        buffer.append("]");
        return buffer.toString();
    }
}


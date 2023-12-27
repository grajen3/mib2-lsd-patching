/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;

class Hashtable$Entry
extends MapEntry {
    Hashtable$Entry next;

    Hashtable$Entry(Object object, Object object2) {
        super(object, object2);
    }

    @Override
    public Object clone() {
        Hashtable$Entry hashtable$Entry = (Hashtable$Entry)super.clone();
        if (this.next != null) {
            hashtable$Entry.next = (Hashtable$Entry)this.next.clone();
        }
        return hashtable$Entry;
    }

    @Override
    public Object setValue(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    public int getKeyHash() {
        return this.key.hashCode();
    }

    public boolean equalsKey(Object object, int n) {
        return this.key.equals(object);
    }

    public String toString() {
        return new StringBuffer().append(this.key).append("=").append(this.value).toString();
    }
}


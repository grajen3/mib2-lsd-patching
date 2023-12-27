/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;

class HashMap$Entry
extends MapEntry {
    HashMap$Entry next;

    HashMap$Entry(Object object, Object object2) {
        super(object, object2);
    }

    @Override
    public Object clone() {
        HashMap$Entry hashMap$Entry = (HashMap$Entry)super.clone();
        if (this.next != null) {
            hashMap$Entry.next = (HashMap$Entry)this.next.clone();
        }
        return hashMap$Entry;
    }

    public boolean equalsKey(Object object, int n) {
        if (this.key != null) {
            return this.key.equals(object);
        }
        return object == null;
    }

    public String toString() {
        return new StringBuffer().append(this.key).append("=").append(this.value).toString();
    }
}


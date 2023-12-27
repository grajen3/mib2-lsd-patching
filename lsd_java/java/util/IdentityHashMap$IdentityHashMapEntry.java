/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map$Entry;
import java.util.MapEntry;

class IdentityHashMap$IdentityHashMapEntry
extends MapEntry {
    IdentityHashMap$IdentityHashMapEntry(Object object, Object object2) {
        super(object, object2);
    }

    @Override
    public Object clone() {
        return (IdentityHashMap$IdentityHashMapEntry)super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map$Entry) {
            Map$Entry map$Entry = (Map$Entry)object;
            return this.key == map$Entry.getKey() && this.value == map$Entry.getValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this.key) ^ System.identityHashCode(this.value);
    }

    public String toString() {
        return new StringBuffer().append(this.key).append("=").append(this.value).toString();
    }
}


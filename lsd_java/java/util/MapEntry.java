/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map$Entry;

class MapEntry
implements Map$Entry,
Cloneable {
    Object key;
    Object value;

    MapEntry(Object object) {
        this.key = object;
    }

    MapEntry(Object object, Object object2) {
        this.key = object;
        this.value = object2;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map$Entry) {
            Map$Entry map$Entry = (Map$Entry)object;
            return (this.key == null ? map$Entry.getKey() == null : this.key.equals(map$Entry.getKey())) && (this.value == null ? map$Entry.getValue() == null : this.value.equals(map$Entry.getValue()));
        }
        return false;
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
    }

    @Override
    public Object setValue(Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }
}


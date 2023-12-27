/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map$Entry;

class Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry
implements Map$Entry {
    Map$Entry mapEntry;

    Collections$UnmodifiableMap$UnmodifiableEntrySet$UnmodifiableMapEntry(Map$Entry map$Entry) {
        this.mapEntry = map$Entry;
    }

    @Override
    public boolean equals(Object object) {
        return this.mapEntry.equals(object);
    }

    @Override
    public Object getKey() {
        return this.mapEntry.getKey();
    }

    @Override
    public Object getValue() {
        return this.mapEntry.getValue();
    }

    @Override
    public int hashCode() {
        return this.mapEntry.hashCode();
    }

    @Override
    public Object setValue(Object object) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return this.mapEntry.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map$Entry;

final class WeakHashMap$Entry
extends WeakReference
implements Map$Entry {
    int hash;
    boolean isNull;
    Object value;
    WeakHashMap$Entry next;

    WeakHashMap$Entry(Object object, Object object2, ReferenceQueue referenceQueue) {
        super(object, referenceQueue);
        this.isNull = object == null;
        this.hash = this.isNull ? 0 : object.hashCode();
        this.value = object2;
    }

    @Override
    public Object getKey() {
        return super.get();
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public Object setValue(Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        Object object2 = super.get();
        return (object2 == null ? object2 == map$Entry.getKey() : object2.equals(map$Entry.getKey())) && (this.value == null ? this.value == map$Entry.getValue() : this.value.equals(map$Entry.getValue()));
    }

    @Override
    public int hashCode() {
        return this.hash + (this.value == null ? 0 : this.value.hashCode());
    }

    public String toString() {
        return new StringBuffer().append(super.get()).append("=").append(this.value).toString();
    }
}


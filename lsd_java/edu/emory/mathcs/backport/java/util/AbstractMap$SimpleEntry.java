/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import java.util.Map$Entry;

public class AbstractMap$SimpleEntry
implements Map$Entry {
    private final Object key;
    private Object value;

    public AbstractMap$SimpleEntry(Object object, Object object2) {
        this.key = object;
        this.value = object2;
    }

    public AbstractMap$SimpleEntry(Map$Entry map$Entry) {
        this.key = map$Entry.getKey();
        this.value = map$Entry.getValue();
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
        return AbstractMap.access$100(this.key, map$Entry.getKey()) && AbstractMap.access$100(this.value, map$Entry.getValue());
    }

    @Override
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
    }

    public String toString() {
        return new StringBuffer().append(this.key).append("=").append(this.value).toString();
    }
}


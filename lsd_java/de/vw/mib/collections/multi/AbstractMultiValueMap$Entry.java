/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import java.util.Map$Entry;

public class AbstractMultiValueMap$Entry
implements Map$Entry {
    private final Object key;
    private final Object value;

    protected AbstractMultiValueMap$Entry(Object object, Object object2) {
        this.key = object;
        this.value = object2;
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
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return new StringBuffer().append(this.key).append("=").append(this.value).toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections$3;
import java.util.Set;

final class Collections$SingletonMap
extends AbstractMap
implements Serializable {
    private static final long serialVersionUID;
    final Object k;
    final Object v;

    Collections$SingletonMap(Object object, Object object2) {
        this.k = object;
        this.v = object2;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.k == null ? object == null : this.k.equals(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.v == null ? object == null : this.v.equals(object);
    }

    @Override
    public Object get(Object object) {
        if (this.containsKey(object)) {
            return this.v;
        }
        return null;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Set entrySet() {
        return new Collections$3(this);
    }
}


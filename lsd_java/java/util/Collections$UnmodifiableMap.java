/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections$UnmodifiableCollection;
import java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet;
import java.util.Collections$UnmodifiableSet;
import java.util.Map;
import java.util.Set;

class Collections$UnmodifiableMap
implements Map,
Serializable {
    private static final long serialVersionUID;
    private final Map m;

    Collections$UnmodifiableMap(Map map) {
        this.m = map;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.m.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.m.containsValue(object);
    }

    @Override
    public Set entrySet() {
        return new Collections$UnmodifiableMap$UnmodifiableEntrySet(this.m.entrySet());
    }

    @Override
    public boolean equals(Object object) {
        return this.m.equals(object);
    }

    @Override
    public Object get(Object object) {
        return this.m.get(object);
    }

    @Override
    public int hashCode() {
        return this.m.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override
    public Set keySet() {
        return new Collections$UnmodifiableSet(this.m.keySet());
    }

    @Override
    public Object put(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.m.size();
    }

    @Override
    public Collection values() {
        return new Collections$UnmodifiableCollection(this.m.values());
    }
}


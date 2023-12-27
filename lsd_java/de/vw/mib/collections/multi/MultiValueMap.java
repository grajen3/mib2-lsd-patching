/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MultiValueMap {
    public static final int VALUE_COLLECTION_TYPE_LIST;
    public static final int VALUE_COLLECTION_TYPE_HASHSET;
    public static final int VALUE_COLLECTION_TYPE_TREESET;

    default public void put(Object object, Object object2) {
    }

    default public Collection getValues(Object object) {
    }

    default public boolean containsKey(Object object) {
    }

    default public Set keySet() {
    }

    default public void clear() {
    }

    default public Object getSingleValue(Object object) {
    }

    default public Map asMap() {
    }

    default public Set entrySet() {
    }

    default public Collection values() {
    }

    default public void putAll(MultiValueMap multiValueMap) {
    }

    default public int size() {
    }

    default public boolean remove(Object object) {
    }

    default public boolean remove(Object object, Object object2) {
    }
}


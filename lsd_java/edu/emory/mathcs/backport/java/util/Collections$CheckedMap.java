/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedMap$EntrySetView;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;

class Collections$CheckedMap
implements Map,
Serializable {
    final Map map;
    final Class keyType;
    final Class valueType;
    transient Set entrySet;
    private transient Object[] emptyKeyArray;
    private transient Object[] emptyValueArray;

    Collections$CheckedMap(Map map, Class clazz, Class clazz2) {
        if (map == null || clazz == null || clazz2 == null) {
            throw new NullPointerException();
        }
        this.map = map;
        this.keyType = clazz;
        this.valueType = clazz2;
    }

    private void typeCheckKey(Object object) {
        if (!this.keyType.isInstance(object)) {
            throw new ClassCastException(new StringBuffer().append("Attempted to use a key of type ").append(object.getClass().getName()).append(" with a map with keys of type ").append(this.keyType.getName()).toString());
        }
    }

    private void typeCheckValue(Object object) {
        if (!this.valueType.isInstance(object)) {
            throw new ClassCastException(new StringBuffer().append("Attempted to use a value of type ").append(object.getClass().getName()).append(" with a map with values of type ").append(this.valueType.getName()).toString());
        }
    }

    @Override
    public int hashCode() {
        return ((Object)this.map).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object == this || ((Object)this.map).equals(object);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.map.containsValue(object);
    }

    @Override
    public Collection values() {
        return this.map.values();
    }

    @Override
    public Set keySet() {
        return this.map.keySet();
    }

    @Override
    public void putAll(Map map) {
        Object[] objectArray;
        Object[] objectArray2;
        if (this.emptyKeyArray == null) {
            this.emptyKeyArray = (Object[])Array.newInstance(this.keyType, 0);
        }
        if (this.emptyValueArray == null) {
            this.emptyValueArray = (Object[])Array.newInstance(this.valueType, 0);
        }
        try {
            objectArray2 = map.keySet().toArray(this.emptyKeyArray);
        }
        catch (ArrayStoreException arrayStoreException) {
            throw new ClassCastException(new StringBuffer().append("Attempted to use an invalid key type  with a map with keys of type ").append(this.keyType.getName()).toString());
        }
        try {
            objectArray = map.keySet().toArray(this.emptyKeyArray);
        }
        catch (ArrayStoreException arrayStoreException) {
            throw new ClassCastException(new StringBuffer().append("Attempted to use an invalid value type  with a map with values of type ").append(this.valueType.getName()).toString());
        }
        if (objectArray2.length != objectArray.length) {
            throw new ConcurrentModificationException();
        }
        for (int i2 = 0; i2 < objectArray2.length; ++i2) {
            this.map.put(objectArray2[i2], objectArray[i2]);
        }
    }

    @Override
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new Collections$CheckedMap$EntrySetView(this, this.map.entrySet());
        }
        return this.entrySet;
    }

    @Override
    public Object get(Object object) {
        return this.map.get(object);
    }

    @Override
    public Object remove(Object object) {
        return this.map.remove(object);
    }

    @Override
    public Object put(Object object, Object object2) {
        this.typeCheckKey(object);
        this.typeCheckValue(object2);
        return this.map.put(object, object2);
    }

    static /* synthetic */ void access$200(Collections$CheckedMap collections$CheckedMap, Object object) {
        collections$CheckedMap.typeCheckValue(object);
    }
}


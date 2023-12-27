/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class SimpleBiMap
implements Map {
    private Map keyByValue;
    private Map valueByKey = new HashMap();

    public SimpleBiMap() {
        this.keyByValue = new HashMap();
    }

    @Override
    public void clear() {
        this.valueByKey.clear();
        this.keyByValue.clear();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.valueByKey.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.keyByValue.containsKey(object);
    }

    @Override
    public Set entrySet() {
        return Collections.unmodifiableSet(this.valueByKey.entrySet());
    }

    @Override
    public Object get(Object object) {
        return this.getValueByKey(object);
    }

    public Object getKeyByValue(Object object) {
        return this.keyByValue.get(object);
    }

    public Object getValueByKey(Object object) {
        return this.valueByKey.get(object);
    }

    @Override
    public boolean isEmpty() {
        return this.valueByKey.isEmpty();
    }

    @Override
    public Set keySet() {
        return Collections.unmodifiableSet(this.valueByKey.keySet());
    }

    @Override
    public Object put(Object object, Object object2) {
        Object object3 = this.valueByKey.get(object);
        Object object4 = this.keyByValue.get(object2);
        this.valueByKey.remove(object4);
        this.keyByValue.remove(object3);
        this.valueByKey.put(object, object2);
        this.keyByValue.put(object2, object);
        return object3;
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.put(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    @Override
    public Object remove(Object object) {
        return this.removeByKey(object);
    }

    public Object removeByKey(Object object) {
        Object object2 = this.valueByKey.remove(object);
        this.keyByValue.remove(object2);
        return object2;
    }

    public Object removeByValue(Object object) {
        Object object2 = this.keyByValue.remove(object);
        this.valueByKey.remove(object2);
        return object2;
    }

    @Override
    public int size() {
        return this.valueByKey.size();
    }

    @Override
    public Collection values() {
        return this.valueSet();
    }

    public Set valueSet() {
        return Collections.unmodifiableSet(this.keyByValue.keySet());
    }
}


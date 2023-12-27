/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import de.vw.mib.collections.multi.MultiValueMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractMultiValueMap
implements MultiValueMap {
    protected Map map;
    protected int valueCollectionType;
    protected Comparator valueComparator;

    protected AbstractMultiValueMap(int n) {
        this(n, null, null);
    }

    protected AbstractMultiValueMap(int n, Comparator comparator, Comparator comparator2) {
        this.map = this.createMap(comparator);
        this.valueCollectionType = n;
        this.valueComparator = comparator2;
    }

    protected abstract Map createMap(Comparator comparator) {
    }

    protected Collection createCollection() {
        switch (this.valueCollectionType) {
            case 0: {
                return new LinkedList();
            }
            case 1: {
                return new HashSet();
            }
            case 2: {
                if (this.valueComparator == null) {
                    return new TreeSet();
                }
                return new TreeSet(this.valueComparator);
            }
        }
        return new LinkedList();
    }

    @Override
    public void put(Object object, Object object2) {
        Collection collection = (Collection)this.map.get(object);
        if (collection == null) {
            collection = this.createCollection();
            this.map.put(object, collection);
        }
        this.addPayload(object, object2, collection);
    }

    @Override
    public Collection getValues(Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection != null) {
            return this.extractPayload(collection);
        }
        return null;
    }

    protected Collection extractPayload(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            arrayList.add(this.extractPayload(iterator.next()));
        }
        return arrayList;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public Set keySet() {
        return Collections.unmodifiableSet(this.map.keySet());
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Object getSingleValue(Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection != null && !collection.isEmpty()) {
            switch (this.valueCollectionType) {
                case 0: {
                    return this.extractPayload(((List)collection).get(collection.size() - 1));
                }
            }
            return this.extractPayload(collection).iterator().next();
        }
        return null;
    }

    @Override
    public Map asMap() {
        HashMap hashMap = new HashMap();
        Set set = this.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            hashMap.put(map$Entry.getKey(), map$Entry.getValue());
        }
        return hashMap;
    }

    @Override
    public void putAll(MultiValueMap multiValueMap) {
        Set set = multiValueMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.put(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    @Override
    public int size() {
        return this.entrySet().size();
    }

    @Override
    public abstract Set entrySet() {
    }

    protected abstract void addPayload(Object object, Object object2, Collection collection) {
    }

    @Override
    public boolean remove(Object object, Object object2) {
        Collection collection = (Collection)this.map.get(object);
        if (collection != null) {
            return this.removePayload(object, object2, collection);
        }
        return false;
    }

    protected abstract boolean removePayload(Object object, Object object2, Collection collection) {
    }

    protected abstract Object extractPayload(Object object) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import de.vw.mib.collections.multi.AbstractMultiValueMap;
import de.vw.mib.collections.multi.AbstractMultiValueMap$Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map$Entry;
import java.util.Set;

public abstract class AbstractUnlinkedMultiValueMap
extends AbstractMultiValueMap {
    public AbstractUnlinkedMultiValueMap(int n) {
        super(n);
    }

    public AbstractUnlinkedMultiValueMap(int n, Comparator comparator, Comparator comparator2) {
        super(n, comparator, comparator2);
    }

    @Override
    protected void addPayload(Object object, Object object2, Collection collection) {
        collection.add(object2);
    }

    @Override
    protected Object extractPayload(Object object) {
        return object;
    }

    @Override
    public Set entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Set set = this.map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Collection collection = (Collection)map$Entry.getValue();
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                Object object = map$Entry.getKey();
                Object object2 = this.extractPayload(iterator2.next());
                linkedHashSet.add(new AbstractMultiValueMap$Entry(object, object2));
            }
        }
        return linkedHashSet;
    }

    @Override
    public Collection values() {
        ArrayList arrayList = new ArrayList();
        Set set = this.map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Collection collection = (Collection)map$Entry.getValue();
            Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                arrayList.add(this.extractPayload(iterator2.next()));
            }
        }
        return arrayList;
    }

    @Override
    public boolean remove(Object object) {
        return this.map.remove(object) != null;
    }

    @Override
    protected boolean removePayload(Object object, Object object2, Collection collection) {
        return collection.remove(object2);
    }
}


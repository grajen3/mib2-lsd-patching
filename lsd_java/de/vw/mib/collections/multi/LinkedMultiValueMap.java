/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import de.vw.mib.collections.multi.AbstractMultiValueMap;
import de.vw.mib.collections.multi.AbstractMultiValueMap$Entry;
import de.vw.mib.collections.multi.LinkedElementList;
import de.vw.mib.collections.multi.LinkedElementList$LinkedElement;
import de.vw.mib.collections.multi.LinkedMultiValueMap$LinkedMapElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class LinkedMultiValueMap
extends AbstractMultiValueMap {
    protected LinkedElementList list = new LinkedElementList();

    public LinkedMultiValueMap() {
        super(0);
    }

    @Override
    protected void addPayload(Object object, Object object2, Collection collection) {
        LinkedMultiValueMap$LinkedMapElement linkedMultiValueMap$LinkedMapElement = new LinkedMultiValueMap$LinkedMapElement(object, object2);
        collection.add(linkedMultiValueMap$LinkedMapElement);
        this.list.add(linkedMultiValueMap$LinkedMapElement);
    }

    @Override
    public int size() {
        return this.list.getSize();
    }

    @Override
    public Set entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.list.size > 0) {
            LinkedElementList$LinkedElement linkedElementList$LinkedElement = this.list.getFirst();
            while (linkedElementList$LinkedElement != null) {
                Object object = ((LinkedMultiValueMap$LinkedMapElement)linkedElementList$LinkedElement).key;
                Object object2 = linkedElementList$LinkedElement.payload;
                linkedHashSet.add(new AbstractMultiValueMap$Entry(object, object2));
                linkedElementList$LinkedElement = linkedElementList$LinkedElement.next;
            }
        }
        return linkedHashSet;
    }

    @Override
    public Collection values() {
        ArrayList arrayList = new ArrayList();
        if (this.list.size > 0) {
            LinkedElementList$LinkedElement linkedElementList$LinkedElement = this.list.getFirst();
            while (linkedElementList$LinkedElement != null) {
                arrayList.add(linkedElementList$LinkedElement.payload);
                linkedElementList$LinkedElement = linkedElementList$LinkedElement.next;
            }
        }
        return arrayList;
    }

    @Override
    public void clear() {
        super.clear();
        this.list.clear();
    }

    @Override
    protected Map createMap(Comparator comparator) {
        return new HashMap();
    }

    @Override
    protected Object extractPayload(Object object) {
        return ((LinkedElementList$LinkedElement)object).payload;
    }

    @Override
    public boolean remove(Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection != null) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                LinkedMultiValueMap$LinkedMapElement linkedMultiValueMap$LinkedMapElement = (LinkedMultiValueMap$LinkedMapElement)iterator.next();
                this.list.remove(linkedMultiValueMap$LinkedMapElement);
            }
        }
        return this.map.remove(object) != null;
    }

    @Override
    protected boolean removePayload(Object object, Object object2, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            LinkedMultiValueMap$LinkedMapElement linkedMultiValueMap$LinkedMapElement = (LinkedMultiValueMap$LinkedMapElement)iterator.next();
            Object object3 = linkedMultiValueMap$LinkedMapElement.payload;
            if ((object3 != null || object2 != null) && (object3 == null || object2 == null || !object3.equals(object2))) continue;
            iterator.remove();
            this.list.remove(linkedMultiValueMap$LinkedMapElement);
            return true;
        }
        return false;
    }
}


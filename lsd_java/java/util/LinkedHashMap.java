/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap$Entry;
import java.util.Iterator;
import java.util.LinkedHashMap$2;
import java.util.LinkedHashMap$4;
import java.util.LinkedHashMap$LinkedHashMapEntry;
import java.util.LinkedHashMap$LinkedHashMapEntrySet;
import java.util.Map;
import java.util.Map$Entry;
import java.util.MapEntry;
import java.util.Set;

public class LinkedHashMap
extends HashMap {
    private static final long serialVersionUID;
    private final boolean accessOrder;
    private transient LinkedHashMap$LinkedHashMapEntry head;
    private transient LinkedHashMap$LinkedHashMapEntry tail;

    public LinkedHashMap() {
        this.accessOrder = false;
        this.head = null;
    }

    public LinkedHashMap(int n) {
        super(n);
        this.accessOrder = false;
        this.head = null;
    }

    public LinkedHashMap(int n, float f2) {
        super(n, f2);
        this.accessOrder = false;
        this.head = null;
        this.tail = null;
    }

    public LinkedHashMap(int n, float f2, boolean bl) {
        super(n, f2);
        this.accessOrder = bl;
        this.head = null;
        this.tail = null;
    }

    public LinkedHashMap(Map map) {
        this.accessOrder = false;
        this.head = null;
        this.tail = null;
        this.putAll(map);
    }

    @Override
    HashMap$Entry[] newElementArray(int n) {
        return new LinkedHashMap$LinkedHashMapEntry[n];
    }

    @Override
    public Object get(Object object) {
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry = (LinkedHashMap$LinkedHashMapEntry)this.getEntry(object);
        if (linkedHashMap$LinkedHashMapEntry == null) {
            return null;
        }
        if (this.accessOrder && this.tail != linkedHashMap$LinkedHashMapEntry) {
            LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry2 = linkedHashMap$LinkedHashMapEntry.chainBackward;
            LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry3 = linkedHashMap$LinkedHashMapEntry.chainForward;
            linkedHashMap$LinkedHashMapEntry3.chainBackward = linkedHashMap$LinkedHashMapEntry2;
            if (linkedHashMap$LinkedHashMapEntry2 != null) {
                linkedHashMap$LinkedHashMapEntry2.chainForward = linkedHashMap$LinkedHashMapEntry3;
            } else {
                this.head = linkedHashMap$LinkedHashMapEntry3;
            }
            linkedHashMap$LinkedHashMapEntry.chainForward = null;
            linkedHashMap$LinkedHashMapEntry.chainBackward = this.tail;
            this.tail.chainForward = linkedHashMap$LinkedHashMapEntry;
            this.tail = linkedHashMap$LinkedHashMapEntry;
        }
        return linkedHashMap$LinkedHashMapEntry.value;
    }

    @Override
    HashMap$Entry createEntry(Object object, int n, Object object2) {
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry = new LinkedHashMap$LinkedHashMapEntry(object, object2);
        linkedHashMap$LinkedHashMapEntry.next = this.elementData[n];
        this.elementData[n] = linkedHashMap$LinkedHashMapEntry;
        this.linkEntry(linkedHashMap$LinkedHashMapEntry);
        return linkedHashMap$LinkedHashMapEntry;
    }

    @Override
    public Object put(Object object, Object object2) {
        int n = this.getModuloHash(object);
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry = (LinkedHashMap$LinkedHashMapEntry)this.findEntry(object, n);
        if (linkedHashMap$LinkedHashMapEntry == null) {
            ++this.modCount;
            if (++this.elementCount > this.threshold) {
                this.rehash();
                n = object == null ? 0 : (object.hashCode() & 0xFFFFFF7F) % this.elementData.length;
            }
            linkedHashMap$LinkedHashMapEntry = (LinkedHashMap$LinkedHashMapEntry)this.createEntry(object, n, null);
        } else {
            this.linkEntry(linkedHashMap$LinkedHashMapEntry);
        }
        Object object3 = linkedHashMap$LinkedHashMapEntry.value;
        linkedHashMap$LinkedHashMapEntry.value = object2;
        if (this.removeEldestEntry(this.head)) {
            this.remove(this.head.key);
        }
        return object3;
    }

    void linkEntry(LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry) {
        if (this.tail == linkedHashMap$LinkedHashMapEntry) {
            return;
        }
        if (this.head == null) {
            this.head = this.tail = linkedHashMap$LinkedHashMapEntry;
            return;
        }
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry2 = linkedHashMap$LinkedHashMapEntry.chainBackward;
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry3 = linkedHashMap$LinkedHashMapEntry.chainForward;
        if (linkedHashMap$LinkedHashMapEntry2 == null) {
            if (linkedHashMap$LinkedHashMapEntry3 != null) {
                if (this.accessOrder) {
                    this.head = linkedHashMap$LinkedHashMapEntry3;
                    linkedHashMap$LinkedHashMapEntry3.chainBackward = null;
                    linkedHashMap$LinkedHashMapEntry.chainBackward = this.tail;
                    linkedHashMap$LinkedHashMapEntry.chainForward = null;
                    this.tail.chainForward = linkedHashMap$LinkedHashMapEntry;
                    this.tail = linkedHashMap$LinkedHashMapEntry;
                }
            } else {
                linkedHashMap$LinkedHashMapEntry.chainBackward = this.tail;
                linkedHashMap$LinkedHashMapEntry.chainForward = null;
                this.tail.chainForward = linkedHashMap$LinkedHashMapEntry;
                this.tail = linkedHashMap$LinkedHashMapEntry;
            }
            return;
        }
        if (linkedHashMap$LinkedHashMapEntry3 == null) {
            return;
        }
        if (this.accessOrder) {
            linkedHashMap$LinkedHashMapEntry2.chainForward = linkedHashMap$LinkedHashMapEntry3;
            linkedHashMap$LinkedHashMapEntry3.chainBackward = linkedHashMap$LinkedHashMapEntry2;
            linkedHashMap$LinkedHashMapEntry.chainForward = null;
            linkedHashMap$LinkedHashMapEntry.chainBackward = this.tail;
            this.tail.chainForward = linkedHashMap$LinkedHashMapEntry;
            this.tail = linkedHashMap$LinkedHashMapEntry;
        }
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            MapEntry mapEntry = (MapEntry)iterator.next();
            this.put(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    @Override
    public Set entrySet() {
        return new LinkedHashMap$LinkedHashMapEntrySet(this);
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new LinkedHashMap$2(this);
        }
        return this.keySet;
    }

    @Override
    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new LinkedHashMap$4(this);
        }
        return this.valuesCollection;
    }

    @Override
    public Object remove(Object object) {
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry = (LinkedHashMap$LinkedHashMapEntry)this.removeEntry(object);
        if (linkedHashMap$LinkedHashMapEntry == null) {
            return null;
        }
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry2 = linkedHashMap$LinkedHashMapEntry.chainBackward;
        LinkedHashMap$LinkedHashMapEntry linkedHashMap$LinkedHashMapEntry3 = linkedHashMap$LinkedHashMapEntry.chainForward;
        if (linkedHashMap$LinkedHashMapEntry2 != null) {
            linkedHashMap$LinkedHashMapEntry2.chainForward = linkedHashMap$LinkedHashMapEntry3;
        } else {
            this.head = linkedHashMap$LinkedHashMapEntry3;
        }
        if (linkedHashMap$LinkedHashMapEntry3 != null) {
            linkedHashMap$LinkedHashMapEntry3.chainBackward = linkedHashMap$LinkedHashMapEntry2;
        } else {
            this.tail = linkedHashMap$LinkedHashMapEntry2;
        }
        return linkedHashMap$LinkedHashMapEntry.value;
    }

    protected boolean removeEldestEntry(Map$Entry map$Entry) {
        return false;
    }

    @Override
    public void clear() {
        super.clear();
        this.tail = null;
        this.head = null;
    }

    @Override
    public Object clone() {
        LinkedHashMap linkedHashMap = (LinkedHashMap)super.clone();
        linkedHashMap.clear();
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
        }
        return linkedHashMap;
    }

    static /* synthetic */ LinkedHashMap$LinkedHashMapEntry access$0(LinkedHashMap linkedHashMap) {
        return linkedHashMap.head;
    }

    static /* synthetic */ void access$1(LinkedHashMap linkedHashMap, LinkedHashMap$LinkedHashMapEntry linkedHashMapEntry) {
        linkedHashMap.tail = linkedHashMapEntry;
    }

    static /* synthetic */ void access$2(LinkedHashMap linkedHashMap, LinkedHashMap$LinkedHashMapEntry linkedHashMapEntry) {
        linkedHashMap.head = linkedHashMapEntry;
    }
}


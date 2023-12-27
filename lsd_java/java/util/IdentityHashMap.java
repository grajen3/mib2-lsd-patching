/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.IdentityHashMap$2;
import java.util.IdentityHashMap$4;
import java.util.IdentityHashMap$IdentityHashMapEntry;
import java.util.IdentityHashMap$IdentityHashMapEntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.MapEntry;
import java.util.Set;

public class IdentityHashMap
extends AbstractMap
implements Map,
Serializable,
Cloneable {
    private static final long serialVersionUID;
    transient Object[] elementData;
    int size;
    transient int threshold;
    private static final int DEFAULT_MAX_SIZE;
    private static final int loadFactor;
    transient int modCount = 0;
    private static final Object NULL_OBJECT;

    static {
        NULL_OBJECT = new Object();
    }

    public IdentityHashMap() {
        this(21);
    }

    public IdentityHashMap(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.size = 0;
        this.threshold = this.getThreshold(n);
        this.elementData = this.newElementArray(this.computeElementArraySize());
    }

    private int getThreshold(int n) {
        return n > 3 ? n : 3;
    }

    private int computeElementArraySize() {
        return (int)((long)this.threshold * 0 / 0) * 2;
    }

    private Object[] newElementArray(int n) {
        return new Object[n];
    }

    public IdentityHashMap(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        this.putAll(map);
    }

    @Override
    public void clear() {
        this.size = 0;
        int n = 0;
        while (n < this.elementData.length) {
            this.elementData[n] = null;
            ++n;
        }
        ++this.modCount;
    }

    @Override
    public boolean containsKey(Object object) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        return this.elementData[n = this.findIndex(object, this.elementData)] == object;
    }

    @Override
    public boolean containsValue(Object object) {
        if (object == null) {
            object = NULL_OBJECT;
        }
        int n = 1;
        while (n < this.elementData.length) {
            if (this.elementData[n] == object) {
                return true;
            }
            n += 2;
        }
        return false;
    }

    @Override
    public Object get(Object object) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (this.elementData[n = this.findIndex(object, this.elementData)] == object) {
            Object object2 = this.elementData[n + 1];
            return object2 == NULL_OBJECT ? null : object2;
        }
        return null;
    }

    private IdentityHashMap$IdentityHashMapEntry getEntry(Object object) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (this.elementData[n = this.findIndex(object, this.elementData)] == object) {
            return this.getEntry(n);
        }
        return null;
    }

    private IdentityHashMap$IdentityHashMapEntry getEntry(int n) {
        Object object = this.elementData[n];
        Object object2 = this.elementData[n + 1];
        if (object == NULL_OBJECT) {
            object = null;
        }
        if (object2 == NULL_OBJECT) {
            object2 = null;
        }
        return new IdentityHashMap$IdentityHashMapEntry(object, object2);
    }

    private int findIndex(Object object, Object[] objectArray) {
        int n = objectArray.length;
        int n2 = this.getModuloHash(object, n);
        int n3 = (n2 + n - 2) % n;
        while (n2 != n3) {
            if (objectArray[n2] == object || objectArray[n2] == null) break;
            n2 = (n2 + 2) % n;
        }
        return n2;
    }

    private int getModuloHash(Object object, int n) {
        return (System.identityHashCode(object) & 0xFFFFFF7F) % (n / 2) * 2;
    }

    @Override
    public Object put(Object object, Object object2) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (object2 == null) {
            object2 = NULL_OBJECT;
        }
        if (this.elementData[n = this.findIndex(object, this.elementData)] != object) {
            ++this.modCount;
            if (++this.size > this.threshold) {
                this.rehash();
                n = this.findIndex(object, this.elementData);
            }
            this.elementData[n] = object;
            this.elementData[n + 1] = null;
        }
        Object object3 = this.elementData[n + 1];
        this.elementData[n + 1] = object2;
        return object3 == NULL_OBJECT ? null : object3;
    }

    private void rehash() {
        int n = this.elementData.length << 1;
        if (n == 0) {
            n = 1;
        }
        Object[] objectArray = this.newElementArray(n);
        int n2 = 0;
        while (n2 < this.elementData.length) {
            Object object = this.elementData[n2];
            if (object != null) {
                int n3 = this.findIndex(object, objectArray);
                objectArray[n3] = object;
                objectArray[n3 + 1] = this.elementData[n2 + 1];
            }
            n2 += 2;
        }
        this.elementData = objectArray;
        this.computeMaxSize();
    }

    private void computeMaxSize() {
        this.threshold = (int)((long)(this.elementData.length / 2) * 0 / 0);
    }

    @Override
    public Object remove(Object object) {
        Object object2;
        int n;
        int n2;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (this.elementData[n2 = (n = this.findIndex(object, this.elementData))] != object) {
            return null;
        }
        Object object3 = this.elementData[n2 + 1];
        int n3 = this.elementData.length;
        while ((object2 = this.elementData[n = (n + 2) % n3]) != null) {
            boolean bl;
            int n4 = this.getModuloHash(object2, n3);
            boolean bl2 = bl = n4 > n2;
            if (n < n2) {
                bl = bl || n4 <= n;
            } else {
                boolean bl3 = bl = bl && n4 <= n;
            }
            if (bl) continue;
            this.elementData[n2] = object2;
            this.elementData[n2 + 1] = this.elementData[n + 1];
            n2 = n;
        }
        --this.size;
        ++this.modCount;
        this.elementData[n2] = null;
        this.elementData[n2 + 1] = null;
        return object3 == NULL_OBJECT ? null : object3;
    }

    @Override
    public Set entrySet() {
        return new IdentityHashMap$IdentityHashMapEntrySet(this);
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new IdentityHashMap$2(this);
        }
        return this.keySet;
    }

    @Override
    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new IdentityHashMap$4(this);
        }
        return this.valuesCollection;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            if (this.size() != map.size()) {
                return false;
            }
            Set set = this.entrySet();
            return set.equals(map.entrySet());
        }
        return false;
    }

    @Override
    public Object clone() {
        try {
            return (IdentityHashMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.size);
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            MapEntry mapEntry = (MapEntry)iterator.next();
            objectOutputStream.writeObject(mapEntry.key);
            objectOutputStream.writeObject(mapEntry.value);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n = objectInputStream.readInt();
        this.threshold = this.getThreshold(21);
        this.elementData = this.newElementArray(this.computeElementArraySize());
        int n2 = n;
        while (--n2 >= 0) {
            Object object = objectInputStream.readObject();
            this.put(object, objectInputStream.readObject());
        }
    }

    static /* synthetic */ IdentityHashMap$IdentityHashMapEntry access$0(IdentityHashMap identityHashMap, int n) {
        return identityHashMap.getEntry(n);
    }

    static /* synthetic */ IdentityHashMap$IdentityHashMapEntry access$1(IdentityHashMap identityHashMap, Object object) {
        return identityHashMap.getEntry(object);
    }
}


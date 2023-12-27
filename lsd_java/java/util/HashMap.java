/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap$2;
import java.util.HashMap$4;
import java.util.HashMap$Entry;
import java.util.HashMap$HashMapEntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap
extends AbstractMap
implements Map,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    transient int elementCount;
    transient HashMap$Entry[] elementData;
    final float loadFactor;
    int threshold;
    transient int modCount = 0;
    private static final int DEFAULT_SIZE;

    HashMap$Entry[] newElementArray(int n) {
        return new HashMap$Entry[n];
    }

    public HashMap() {
        this(16);
    }

    public HashMap(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = this.newElementArray(n == 0 ? 1 : n);
        this.loadFactor = 16447;
        this.computeMaxSize();
    }

    public HashMap(int n, float f2) {
        if (n < 0 || !(f2 > 0.0f)) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = this.newElementArray(n == 0 ? 1 : n);
        this.loadFactor = f2;
        this.computeMaxSize();
    }

    public HashMap(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        this.putAll(map);
    }

    @Override
    public void clear() {
        if (this.elementCount > 0) {
            this.elementCount = 0;
            Arrays.fill(this.elementData, null);
            ++this.modCount;
        }
    }

    @Override
    public Object clone() {
        try {
            HashMap hashMap = (HashMap)super.clone();
            hashMap.elementData = this.newElementArray(this.elementData.length);
            int n = 0;
            while (n < this.elementData.length) {
                HashMap$Entry hashMap$Entry = this.elementData[n];
                if (hashMap$Entry != null) {
                    hashMap.elementData[n] = (HashMap$Entry)hashMap$Entry.clone();
                }
                ++n;
            }
            return hashMap;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    private void computeMaxSize() {
        this.threshold = (int)((float)this.elementData.length * this.loadFactor);
    }

    @Override
    public boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    @Override
    public boolean containsValue(Object object) {
        if (object != null) {
            int n = this.elementData.length;
            while (--n >= 0) {
                HashMap$Entry hashMap$Entry = this.elementData[n];
                while (hashMap$Entry != null) {
                    if (object.equals(hashMap$Entry.value)) {
                        return true;
                    }
                    hashMap$Entry = hashMap$Entry.next;
                }
            }
        } else {
            int n = this.elementData.length;
            while (--n >= 0) {
                HashMap$Entry hashMap$Entry = this.elementData[n];
                while (hashMap$Entry != null) {
                    if (hashMap$Entry.value == null) {
                        return true;
                    }
                    hashMap$Entry = hashMap$Entry.next;
                }
            }
        }
        return false;
    }

    @Override
    public Set entrySet() {
        return new HashMap$HashMapEntrySet(this);
    }

    @Override
    public Object get(Object object) {
        HashMap$Entry hashMap$Entry = this.getEntry(object);
        if (hashMap$Entry != null) {
            return hashMap$Entry.value;
        }
        return null;
    }

    HashMap$Entry getEntry(Object object) {
        int n = this.getModuloHash(object);
        return this.findEntry(object, n);
    }

    int getModuloHash(Object object) {
        if (object == null) {
            return 0;
        }
        return (object.hashCode() & 0xFFFFFF7F) % this.elementData.length;
    }

    /*
     * Unable to fully structure code
     */
    HashMap$Entry findEntry(Object var1_1, int var2_2) {
        block2: {
            var3_3 = this.elementData[var2_2];
            if (var1_1 == null) ** GOTO lbl8
            while (var3_3 != null && !var3_3.equalsKey(var1_1, var1_1.hashCode())) {
                var3_3 = var3_3.next;
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                var3_3 = var3_3.next;
lbl8:
                // 2 sources

                ** while (var3_3 != null && var3_3.key != null)
            }
        }
        return var3_3;
    }

    @Override
    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new HashMap$2(this);
        }
        return this.keySet;
    }

    @Override
    public Object put(Object object, Object object2) {
        int n = this.getModuloHash(object);
        HashMap$Entry hashMap$Entry = this.findEntry(object, n);
        if (hashMap$Entry == null) {
            ++this.modCount;
            if (++this.elementCount > this.threshold) {
                this.rehash();
                n = object == null ? 0 : (object.hashCode() & 0xFFFFFF7F) % this.elementData.length;
            }
            hashMap$Entry = this.createEntry(object, n, null);
        }
        Object object3 = hashMap$Entry.value;
        hashMap$Entry.value = object2;
        return object3;
    }

    HashMap$Entry createEntry(Object object, int n, Object object2) {
        HashMap$Entry hashMap$Entry = new HashMap$Entry(object, object2);
        hashMap$Entry.next = this.elementData[n];
        this.elementData[n] = hashMap$Entry;
        return hashMap$Entry;
    }

    @Override
    public void putAll(Map map) {
        super.putAll(map);
    }

    void rehash() {
        int n = this.elementData.length << 1;
        if (n == 0) {
            n = 1;
        }
        HashMap$Entry[] hashMap$EntryArray = this.newElementArray(n);
        int n2 = 0;
        while (n2 < this.elementData.length) {
            HashMap$Entry hashMap$Entry = this.elementData[n2];
            while (hashMap$Entry != null) {
                Object object = hashMap$Entry.key;
                int n3 = object == null ? 0 : (object.hashCode() & 0xFFFFFF7F) % n;
                HashMap$Entry hashMap$Entry2 = hashMap$Entry.next;
                hashMap$Entry.next = hashMap$EntryArray[n3];
                hashMap$EntryArray[n3] = hashMap$Entry;
                hashMap$Entry = hashMap$Entry2;
            }
            ++n2;
        }
        this.elementData = hashMap$EntryArray;
        this.computeMaxSize();
    }

    @Override
    public Object remove(Object object) {
        HashMap$Entry hashMap$Entry = this.removeEntry(object);
        if (hashMap$Entry != null) {
            return hashMap$Entry.value;
        }
        return null;
    }

    HashMap$Entry removeEntry(Object object) {
        HashMap$Entry hashMap$Entry;
        int n = 0;
        HashMap$Entry hashMap$Entry2 = null;
        if (object != null) {
            n = (object.hashCode() & 0xFFFFFF7F) % this.elementData.length;
            hashMap$Entry = this.elementData[n];
            while (hashMap$Entry != null && !hashMap$Entry.equalsKey(object, object.hashCode())) {
                hashMap$Entry2 = hashMap$Entry;
                hashMap$Entry = hashMap$Entry.next;
            }
        } else {
            hashMap$Entry = this.elementData[0];
            while (hashMap$Entry != null && hashMap$Entry.key != null) {
                hashMap$Entry2 = hashMap$Entry;
                hashMap$Entry = hashMap$Entry.next;
            }
        }
        if (hashMap$Entry == null) {
            return null;
        }
        if (hashMap$Entry2 == null) {
            this.elementData[n] = hashMap$Entry.next;
        } else {
            hashMap$Entry2.next = hashMap$Entry.next;
        }
        ++this.modCount;
        --this.elementCount;
        return hashMap$Entry;
    }

    @Override
    public int size() {
        return this.elementCount;
    }

    @Override
    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new HashMap$4(this);
        }
        return this.valuesCollection;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.elementData.length);
        objectOutputStream.writeInt(this.elementCount);
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap$Entry hashMap$Entry = (HashMap$Entry)iterator.next();
            objectOutputStream.writeObject(hashMap$Entry.key);
            objectOutputStream.writeObject(hashMap$Entry.value);
            hashMap$Entry = hashMap$Entry.next;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        this.elementData = new HashMap$Entry[n];
        int n2 = this.elementCount = objectInputStream.readInt();
        while (--n2 >= 0) {
            Object object = objectInputStream.readObject();
            int n3 = (object.hashCode() & 0xFFFFFF7F) % n;
            this.createEntry(object, n3, objectInputStream.readObject());
        }
    }
}


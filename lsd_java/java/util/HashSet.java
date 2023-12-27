/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap$Entry;
import java.util.Iterator;
import java.util.Set;

public class HashSet
extends AbstractSet
implements Set,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    transient HashMap backingMap;

    public HashSet() {
        this(new HashMap());
    }

    public HashSet(int n) {
        this(new HashMap(n));
    }

    public HashSet(int n, float f2) {
        this(new HashMap(n, f2));
    }

    public HashSet(Collection collection) {
        this(new HashMap(collection.size() < 6 ? 11 : collection.size() * 2));
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    HashSet(HashMap hashMap) {
        this.backingMap = hashMap;
    }

    @Override
    public boolean add(Object object) {
        return this.backingMap.put(object, this) == null;
    }

    @Override
    public void clear() {
        this.backingMap.clear();
    }

    public Object clone() {
        try {
            HashSet hashSet = (HashSet)super.clone();
            hashSet.backingMap = (HashMap)this.backingMap.clone();
            return hashSet;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean contains(Object object) {
        return this.backingMap.containsKey(object);
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return this.backingMap.keySet().iterator();
    }

    @Override
    public boolean remove(Object object) {
        return this.backingMap.remove(object) != null;
    }

    @Override
    public int size() {
        return this.backingMap.size();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.backingMap.elementData.length);
        objectOutputStream.writeFloat(this.backingMap.loadFactor);
        objectOutputStream.writeInt(this.backingMap.elementCount);
        int n = this.backingMap.elementData.length;
        while (--n >= 0) {
            HashMap$Entry hashMap$Entry = this.backingMap.elementData[n];
            while (hashMap$Entry != null) {
                objectOutputStream.writeObject(hashMap$Entry.key);
                hashMap$Entry = hashMap$Entry.next;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n;
        objectInputStream.defaultReadObject();
        int n2 = objectInputStream.readInt();
        float f2 = objectInputStream.readFloat();
        this.backingMap = this.createBackingMap(n2, f2);
        int n3 = n = objectInputStream.readInt();
        while (--n3 >= 0) {
            Object object = objectInputStream.readObject();
            this.backingMap.put(object, this);
        }
    }

    HashMap createBackingMap(int n, float f2) {
        return new HashMap(n, f2);
    }
}


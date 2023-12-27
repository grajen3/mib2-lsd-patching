/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections$SynchronizedCollection;
import java.util.Collections$SynchronizedSet;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable$1;
import java.util.Hashtable$3;
import java.util.Hashtable$5;
import java.util.Hashtable$Entry;
import java.util.Hashtable$HashEnumerator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class Hashtable
extends Dictionary
implements Map,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    transient int elementCount;
    transient Hashtable$Entry[] elementData;
    private float loadFactor;
    private int threshold;
    transient int firstSlot = 0;
    transient int lastSlot = -1;
    transient int modCount = 0;
    private static final Enumeration emptyEnumerator;

    static {
        emptyEnumerator = new Hashtable(0).getEmptyEnumerator();
    }

    private static Hashtable$Entry newEntry(Object object, Object object2, int n) {
        return new Hashtable$Entry(object, object2);
    }

    public Hashtable() {
        this(11);
    }

    public Hashtable(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = new Hashtable$Entry[n == 0 ? 1 : n];
        this.firstSlot = this.elementData.length;
        this.loadFactor = 16447;
        this.computeMaxSize();
    }

    public Hashtable(int n, float f2) {
        if (n < 0 || !(f2 > 0.0f)) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.firstSlot = n;
        this.elementData = new Hashtable$Entry[n == 0 ? 1 : n];
        this.loadFactor = f2;
        this.computeMaxSize();
    }

    public Hashtable(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 4 / 3 + 11);
        this.putAll(map);
    }

    private Hashtable$HashEnumerator getEmptyEnumerator() {
        return new Hashtable$HashEnumerator(this, false);
    }

    @Override
    public synchronized void clear() {
        this.elementCount = 0;
        Arrays.fill(this.elementData, null);
        ++this.modCount;
    }

    public synchronized Object clone() {
        try {
            Hashtable hashtable = (Hashtable)super.clone();
            hashtable.elementData = new Hashtable$Entry[this.elementData.length];
            int n = this.elementData.length;
            while (--n >= 0) {
                Hashtable$Entry hashtable$Entry = this.elementData[n];
                if (hashtable$Entry == null) continue;
                hashtable.elementData[n] = (Hashtable$Entry)hashtable$Entry.clone();
            }
            return hashtable;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    private void computeMaxSize() {
        this.threshold = (int)((float)this.elementData.length * this.loadFactor);
    }

    public synchronized boolean contains(Object object) {
        if (object != null) {
            int n = this.elementData.length;
            while (--n >= 0) {
                Hashtable$Entry hashtable$Entry = this.elementData[n];
                while (hashtable$Entry != null) {
                    if (object.equals(hashtable$Entry.value)) {
                        return true;
                    }
                    hashtable$Entry = hashtable$Entry.next;
                }
            }
            return false;
        }
        throw new NullPointerException();
    }

    @Override
    public synchronized boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    @Override
    public boolean containsValue(Object object) {
        return this.contains(object);
    }

    @Override
    public synchronized Enumeration elements() {
        if (this.elementCount == 0) {
            return emptyEnumerator;
        }
        return new Hashtable$HashEnumerator(this, false);
    }

    @Override
    public Set entrySet() {
        return new Collections$SynchronizedSet(new Hashtable$1(this), (Object)this);
    }

    @Override
    public synchronized boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            if (this.size() != map.size()) {
                return false;
            }
            Set set = map.entrySet();
            Iterator iterator = this.entrySet().iterator();
            while (iterator.hasNext()) {
                if (set.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public synchronized Object get(Object object) {
        int n = object.hashCode();
        int n2 = (n & 0xFFFFFF7F) % this.elementData.length;
        Hashtable$Entry hashtable$Entry = this.elementData[n2];
        while (hashtable$Entry != null) {
            if (hashtable$Entry.equalsKey(object, n)) {
                return hashtable$Entry.value;
            }
            hashtable$Entry = hashtable$Entry.next;
        }
        return null;
    }

    Hashtable$Entry getEntry(Object object) {
        int n = object.hashCode();
        int n2 = (n & 0xFFFFFF7F) % this.elementData.length;
        Hashtable$Entry hashtable$Entry = this.elementData[n2];
        while (hashtable$Entry != null) {
            if (hashtable$Entry.equalsKey(object, n)) {
                return hashtable$Entry;
            }
            hashtable$Entry = hashtable$Entry.next;
        }
        return null;
    }

    @Override
    public synchronized int hashCode() {
        int n = 0;
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Object object = map$Entry.getKey();
            Object object2 = map$Entry.getValue();
            int n2 = (object != this ? object.hashCode() : 0) ^ (object2 != this ? (object2 != null ? object2.hashCode() : 0) : 0);
            n += n2;
        }
        return n;
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    @Override
    public synchronized Enumeration keys() {
        if (this.elementCount == 0) {
            return emptyEnumerator;
        }
        return new Hashtable$HashEnumerator(this, true);
    }

    @Override
    public Set keySet() {
        return new Collections$SynchronizedSet(new Hashtable$3(this), (Object)this);
    }

    @Override
    public synchronized Object put(Object object, Object object2) {
        if (object != null && object2 != null) {
            int n = object.hashCode();
            int n2 = (n & 0xFFFFFF7F) % this.elementData.length;
            Hashtable$Entry hashtable$Entry = this.elementData[n2];
            while (hashtable$Entry != null && !hashtable$Entry.equalsKey(object, n)) {
                hashtable$Entry = hashtable$Entry.next;
            }
            if (hashtable$Entry == null) {
                ++this.modCount;
                if (++this.elementCount > this.threshold) {
                    this.rehash();
                    n2 = (n & 0xFFFFFF7F) % this.elementData.length;
                }
                if (n2 < this.firstSlot) {
                    this.firstSlot = n2;
                }
                if (n2 > this.lastSlot) {
                    this.lastSlot = n2;
                }
                hashtable$Entry = Hashtable.newEntry(object, object2, n);
                hashtable$Entry.next = this.elementData[n2];
                this.elementData[n2] = hashtable$Entry;
                return null;
            }
            Object object3 = hashtable$Entry.value;
            hashtable$Entry.value = object2;
            return object3;
        }
        throw new NullPointerException();
    }

    @Override
    public synchronized void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.put(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    protected void rehash() {
        int n = (this.elementData.length << 1) + 1;
        if (n == 0) {
            n = 1;
        }
        int n2 = n;
        int n3 = -1;
        Hashtable$Entry[] hashtable$EntryArray = new Hashtable$Entry[n];
        int n4 = this.lastSlot + 1;
        while (--n4 >= this.firstSlot) {
            Hashtable$Entry hashtable$Entry = this.elementData[n4];
            while (hashtable$Entry != null) {
                int n5 = (hashtable$Entry.getKeyHash() & 0xFFFFFF7F) % n;
                if (n5 < n2) {
                    n2 = n5;
                }
                if (n5 > n3) {
                    n3 = n5;
                }
                Hashtable$Entry hashtable$Entry2 = hashtable$Entry.next;
                hashtable$Entry.next = hashtable$EntryArray[n5];
                hashtable$EntryArray[n5] = hashtable$Entry;
                hashtable$Entry = hashtable$Entry2;
            }
        }
        this.firstSlot = n2;
        this.lastSlot = n3;
        this.elementData = hashtable$EntryArray;
        this.computeMaxSize();
    }

    @Override
    public synchronized Object remove(Object object) {
        int n = object.hashCode();
        int n2 = (n & 0xFFFFFF7F) % this.elementData.length;
        Hashtable$Entry hashtable$Entry = null;
        Hashtable$Entry hashtable$Entry2 = this.elementData[n2];
        while (hashtable$Entry2 != null && !hashtable$Entry2.equalsKey(object, n)) {
            hashtable$Entry = hashtable$Entry2;
            hashtable$Entry2 = hashtable$Entry2.next;
        }
        if (hashtable$Entry2 != null) {
            ++this.modCount;
            if (hashtable$Entry == null) {
                this.elementData[n2] = hashtable$Entry2.next;
            } else {
                hashtable$Entry.next = hashtable$Entry2.next;
            }
            --this.elementCount;
            Object object2 = hashtable$Entry2.value;
            hashtable$Entry2.value = null;
            return object2;
        }
        return null;
    }

    @Override
    public synchronized int size() {
        return this.elementCount;
    }

    public synchronized String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(this.size() * 28);
        stringBuffer.append('{');
        int n = this.lastSlot;
        while (n >= this.firstSlot) {
            Hashtable$Entry hashtable$Entry = this.elementData[n];
            while (hashtable$Entry != null) {
                if (hashtable$Entry.key != this) {
                    stringBuffer.append(hashtable$Entry.key);
                } else {
                    stringBuffer.append("(this Map)");
                }
                stringBuffer.append('=');
                if (hashtable$Entry.value != this) {
                    stringBuffer.append(hashtable$Entry.value);
                } else {
                    stringBuffer.append("(this Map)");
                }
                stringBuffer.append(", ");
                hashtable$Entry = hashtable$Entry.next;
            }
            --n;
        }
        if (this.elementCount > 0) {
            stringBuffer.setLength(stringBuffer.length() - 2);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override
    public Collection values() {
        return new Collections$SynchronizedCollection(new Hashtable$5(this), this);
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.elementData.length);
        objectOutputStream.writeInt(this.elementCount);
        int n = this.elementData.length;
        while (--n >= 0) {
            Hashtable$Entry hashtable$Entry = this.elementData[n];
            while (hashtable$Entry != null) {
                objectOutputStream.writeObject(hashtable$Entry.key);
                objectOutputStream.writeObject(hashtable$Entry.value);
                hashtable$Entry = hashtable$Entry.next;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        this.elementData = new Hashtable$Entry[n];
        int n2 = this.elementCount = objectInputStream.readInt();
        while (--n2 >= 0) {
            Object object = objectInputStream.readObject();
            int n3 = object.hashCode();
            int n4 = (n3 & 0xFFFFFF7F) % n;
            if (n4 < this.firstSlot) {
                this.firstSlot = n4;
            }
            if (n4 > this.lastSlot) {
                this.lastSlot = n4;
            }
            Hashtable$Entry hashtable$Entry = Hashtable.newEntry(object, objectInputStream.readObject(), n3);
            hashtable$Entry.next = this.elementData[n4];
            this.elementData[n4] = hashtable$Entry;
        }
    }
}


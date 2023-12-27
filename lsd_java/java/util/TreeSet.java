/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeMap$Entry;
import java.util.TreeSet$SubSet;

public class TreeSet
extends AbstractSet
implements SortedSet,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    private transient TreeMap backingMap;

    public TreeSet() {
        this.backingMap = new TreeMap();
    }

    public TreeSet(Collection collection) {
        this();
        this.addAll(collection);
    }

    public TreeSet(Comparator comparator) {
        this.backingMap = new TreeMap(comparator);
    }

    public TreeSet(SortedSet sortedSet) {
        this(sortedSet.comparator());
        Iterator iterator = sortedSet.iterator();
        if (iterator.hasNext()) {
            TreeMap$Entry treeMap$Entry;
            Object object = iterator.next();
            this.backingMap.root = treeMap$Entry = new TreeMap$Entry(object, object);
            this.backingMap.size = 1;
            while (iterator.hasNext()) {
                object = iterator.next();
                TreeMap$Entry treeMap$Entry2 = new TreeMap$Entry(object, object);
                treeMap$Entry2.parent = treeMap$Entry;
                treeMap$Entry.right = treeMap$Entry2;
                ++this.backingMap.size;
                this.backingMap.balance(treeMap$Entry2);
                treeMap$Entry = treeMap$Entry2;
            }
        }
    }

    @Override
    public boolean add(Object object) {
        return this.backingMap.put(object, object) == null;
    }

    @Override
    public boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    @Override
    public void clear() {
        this.backingMap.clear();
    }

    public Object clone() {
        try {
            TreeSet treeSet = (TreeSet)super.clone();
            treeSet.backingMap = (TreeMap)this.backingMap.clone();
            return treeSet;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public Comparator comparator() {
        return this.backingMap.comparator();
    }

    @Override
    public boolean contains(Object object) {
        return this.backingMap.containsKey(object);
    }

    @Override
    public Object first() {
        return this.backingMap.firstKey();
    }

    @Override
    public SortedSet headSet(Object object) {
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            comparator.compare(object, object);
        }
        return new TreeSet$SubSet(this.backingMap, object);
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
    public Object last() {
        return this.backingMap.lastKey();
    }

    @Override
    public boolean remove(Object object) {
        return this.backingMap.remove(object) != null;
    }

    @Override
    public int size() {
        return this.backingMap.size();
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null ? ((Comparable)object).compareTo(object2) <= 0 : comparator.compare(object, object2) <= 0) {
            return new TreeSet$SubSet(object, this.backingMap, object2);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public SortedSet tailSet(Object object) {
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            comparator.compare(object, object);
        }
        return new TreeSet$SubSet(object, this.backingMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.backingMap.comparator());
        objectOutputStream.writeInt(this.backingMap.size);
        if (this.backingMap.size > 0) {
            TreeMap$Entry treeMap$Entry = TreeMap.minimum(this.backingMap.root);
            while (treeMap$Entry != null) {
                objectOutputStream.writeObject(treeMap$Entry.key);
                treeMap$Entry = TreeMap.successor(treeMap$Entry);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.backingMap = new TreeMap((Comparator)objectInputStream.readObject());
        this.backingMap.size = objectInputStream.readInt();
        TreeMap$Entry treeMap$Entry = null;
        int n = this.backingMap.size;
        while (--n >= 0) {
            TreeMap$Entry treeMap$Entry2 = new TreeMap$Entry(objectInputStream.readObject());
            treeMap$Entry2.value = this;
            if (treeMap$Entry == null) {
                this.backingMap.root = treeMap$Entry2;
            } else {
                treeMap$Entry2.parent = treeMap$Entry;
                treeMap$Entry.right = treeMap$Entry2;
                this.backingMap.balance(treeMap$Entry2);
            }
            treeMap$Entry = treeMap$Entry2;
        }
    }
}


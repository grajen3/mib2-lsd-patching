/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorIOException;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorNoClassException;
import edu.emory.mathcs.backport.java.util.TreeSet$IOIterator;
import edu.emory.mathcs.backport.java.util.TreeSet$MapIterator;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.SortedSet;

public class TreeSet
extends AbstractSet
implements NavigableSet,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static final Object PRESENT;
    private transient NavigableMap map;

    public TreeSet() {
        this.map = new TreeMap();
    }

    public TreeSet(Comparator comparator) {
        this.map = new TreeMap(comparator);
    }

    public TreeSet(Collection collection) {
        this.map = new TreeMap();
        this.addAll(collection);
    }

    public TreeSet(SortedSet sortedSet) {
        this.map = new TreeMap(sortedSet.comparator());
        this.addAll(sortedSet);
    }

    private TreeSet(NavigableMap navigableMap) {
        this.map = navigableMap;
    }

    @Override
    public Object lower(Object object) {
        return this.map.lowerKey(object);
    }

    @Override
    public Object floor(Object object) {
        return this.map.floorKey(object);
    }

    @Override
    public Object ceiling(Object object) {
        return this.map.ceilingKey(object);
    }

    @Override
    public Object higher(Object object) {
        return this.map.higherKey(object);
    }

    @Override
    public Object pollFirst() {
        Map$Entry map$Entry = this.map.pollFirstEntry();
        return map$Entry != null ? map$Entry.getKey() : null;
    }

    @Override
    public Object pollLast() {
        Map$Entry map$Entry = this.map.pollLastEntry();
        return map$Entry != null ? map$Entry.getKey() : null;
    }

    @Override
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public Iterator descendingIterator() {
        return this.map.descendingKeySet().iterator();
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    @Override
    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }

    @Override
    public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
        return new TreeSet(this.map.subMap(object, bl, object2, bl2));
    }

    @Override
    public NavigableSet headSet(Object object, boolean bl) {
        return new TreeSet(this.map.headMap(object, bl));
    }

    @Override
    public NavigableSet tailSet(Object object, boolean bl) {
        return new TreeSet(this.map.tailMap(object, bl));
    }

    @Override
    public NavigableSet descendingSet() {
        return new TreeSet(this.map.descendingMap());
    }

    @Override
    public Comparator comparator() {
        return this.map.comparator();
    }

    @Override
    public Object first() {
        return this.map.firstKey();
    }

    @Override
    public Object last() {
        return this.map.lastKey();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.map.keySet().toArray(objectArray);
    }

    @Override
    public boolean add(Object object) {
        return this.map.put(object, PRESENT) == null;
    }

    @Override
    public boolean remove(Object object) {
        return this.map.remove(object) != null;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (this.map.size() == 0 && collection.size() > 0 && collection instanceof SortedSet && this.map instanceof TreeMap && TreeSet.eq(((SortedSet)collection).comparator(), this.comparator())) {
            ((TreeMap)this.map).buildFromSorted(new TreeSet$MapIterator(collection.iterator()), collection.size());
            return true;
        }
        return super.addAll(collection);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        TreeSet treeSet;
        try {
            treeSet = (TreeSet)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        treeSet.map = new TreeMap(this.map);
        return treeSet;
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map.comparator());
        objectOutputStream.writeInt(this.map.size());
        Iterator iterator = this.map.keySet().iterator();
        while (iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator)objectInputStream.readObject();
        TreeMap treeMap = new TreeMap(comparator);
        int n = objectInputStream.readInt();
        try {
            treeMap.buildFromSorted(new TreeSet$IOIterator(objectInputStream, n), n);
            this.map = treeMap;
        }
        catch (TreeMap$IteratorIOException treeMap$IteratorIOException) {
            throw treeMap$IteratorIOException.getException();
        }
        catch (TreeMap$IteratorNoClassException treeMap$IteratorNoClassException) {
            throw treeMap$IteratorNoClassException.getException();
        }
    }

    static /* synthetic */ Object access$000() {
        return PRESENT;
    }

    static {
        PRESENT = new Object();
    }
}


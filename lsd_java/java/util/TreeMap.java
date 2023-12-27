/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap$10;
import java.util.TreeMap$6;
import java.util.TreeMap$8;
import java.util.TreeMap$Entry;
import java.util.TreeMap$SubMap;

public class TreeMap
extends AbstractMap
implements SortedMap,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    transient int size = 0;
    transient TreeMap$Entry root;
    private Comparator comparator;
    transient int modCount = 0;

    public TreeMap() {
    }

    public TreeMap(Comparator comparator) {
        this.comparator = comparator;
    }

    public TreeMap(Map map) {
        this();
        this.putAll(map);
    }

    public TreeMap(SortedMap sortedMap) {
        this(sortedMap.comparator());
        Iterator iterator = sortedMap.entrySet().iterator();
        if (iterator.hasNext()) {
            TreeMap$Entry treeMap$Entry;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.root = treeMap$Entry = new TreeMap$Entry(map$Entry.getKey(), map$Entry.getValue());
            this.size = 1;
            while (iterator.hasNext()) {
                map$Entry = (Map$Entry)iterator.next();
                TreeMap$Entry treeMap$Entry2 = new TreeMap$Entry(map$Entry.getKey(), map$Entry.getValue());
                treeMap$Entry2.parent = treeMap$Entry;
                treeMap$Entry.right = treeMap$Entry2;
                ++this.size;
                this.balance(treeMap$Entry2);
                treeMap$Entry = treeMap$Entry2;
            }
        }
    }

    void balance(TreeMap$Entry treeMap$Entry) {
        treeMap$Entry.color = true;
        while (treeMap$Entry != this.root && treeMap$Entry.parent.color) {
            TreeMap$Entry treeMap$Entry2;
            if (treeMap$Entry.parent == treeMap$Entry.parent.parent.left) {
                treeMap$Entry2 = treeMap$Entry.parent.parent.right;
                if (treeMap$Entry2 != null && treeMap$Entry2.color) {
                    treeMap$Entry.parent.color = false;
                    treeMap$Entry2.color = false;
                    treeMap$Entry.parent.parent.color = true;
                    treeMap$Entry = treeMap$Entry.parent.parent;
                    continue;
                }
                if (treeMap$Entry == treeMap$Entry.parent.right) {
                    treeMap$Entry = treeMap$Entry.parent;
                    this.leftRotate(treeMap$Entry);
                }
                treeMap$Entry.parent.color = false;
                treeMap$Entry.parent.parent.color = true;
                this.rightRotate(treeMap$Entry.parent.parent);
                continue;
            }
            treeMap$Entry2 = treeMap$Entry.parent.parent.left;
            if (treeMap$Entry2 != null && treeMap$Entry2.color) {
                treeMap$Entry.parent.color = false;
                treeMap$Entry2.color = false;
                treeMap$Entry.parent.parent.color = true;
                treeMap$Entry = treeMap$Entry.parent.parent;
                continue;
            }
            if (treeMap$Entry == treeMap$Entry.parent.left) {
                treeMap$Entry = treeMap$Entry.parent;
                this.rightRotate(treeMap$Entry);
            }
            treeMap$Entry.parent.color = false;
            treeMap$Entry.parent.parent.color = true;
            this.leftRotate(treeMap$Entry.parent.parent);
        }
        this.root.color = false;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
    }

    @Override
    public Object clone() {
        try {
            TreeMap treeMap = (TreeMap)super.clone();
            if (this.root != null) {
                treeMap.root = this.root.clone(null);
            }
            return treeMap;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public Comparator comparator() {
        return this.comparator;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.find(object) != null;
    }

    @Override
    public boolean containsValue(Object object) {
        if (this.root != null) {
            return this.containsValue(this.root, object);
        }
        return false;
    }

    private boolean containsValue(TreeMap$Entry treeMap$Entry, Object object) {
        if (object == null ? treeMap$Entry.value == null : object.equals(treeMap$Entry.value)) {
            return true;
        }
        if (treeMap$Entry.left != null && this.containsValue(treeMap$Entry.left, object)) {
            return true;
        }
        return treeMap$Entry.right != null && this.containsValue(treeMap$Entry.right, object);
    }

    @Override
    public Set entrySet() {
        return new TreeMap$6(this);
    }

    private TreeMap$Entry find(Object object) {
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        TreeMap$Entry treeMap$Entry = this.root;
        while (treeMap$Entry != null) {
            int n;
            int n2 = n = comparable != null ? comparable.compareTo(treeMap$Entry.key) : this.comparator.compare(object, treeMap$Entry.key);
            if (n == 0) {
                return treeMap$Entry;
            }
            TreeMap$Entry treeMap$Entry2 = treeMap$Entry = n < 0 ? treeMap$Entry.left : treeMap$Entry.right;
        }
        return null;
    }

    TreeMap$Entry findAfter(Object object) {
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        TreeMap$Entry treeMap$Entry = this.root;
        TreeMap$Entry treeMap$Entry2 = null;
        while (treeMap$Entry != null) {
            int n;
            int n2 = n = comparable != null ? comparable.compareTo(treeMap$Entry.key) : this.comparator.compare(object, treeMap$Entry.key);
            if (n == 0) {
                return treeMap$Entry;
            }
            if (n < 0) {
                treeMap$Entry2 = treeMap$Entry;
                treeMap$Entry = treeMap$Entry.left;
                continue;
            }
            treeMap$Entry = treeMap$Entry.right;
        }
        return treeMap$Entry2;
    }

    TreeMap$Entry findBefore(Object object) {
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        TreeMap$Entry treeMap$Entry = this.root;
        TreeMap$Entry treeMap$Entry2 = null;
        while (treeMap$Entry != null) {
            int n;
            int n2 = n = comparable != null ? comparable.compareTo(treeMap$Entry.key) : this.comparator.compare(object, treeMap$Entry.key);
            if (n <= 0) {
                treeMap$Entry = treeMap$Entry.left;
                continue;
            }
            treeMap$Entry2 = treeMap$Entry;
            treeMap$Entry = treeMap$Entry.right;
        }
        return treeMap$Entry2;
    }

    @Override
    public Object firstKey() {
        if (this.root != null) {
            return TreeMap.minimum((TreeMap$Entry)this.root).key;
        }
        throw new NoSuchElementException();
    }

    private void fixup(TreeMap$Entry treeMap$Entry) {
        while (treeMap$Entry != this.root && !treeMap$Entry.color) {
            TreeMap$Entry treeMap$Entry2;
            if (treeMap$Entry == treeMap$Entry.parent.left) {
                treeMap$Entry2 = treeMap$Entry.parent.right;
                if (treeMap$Entry2 == null) {
                    treeMap$Entry = treeMap$Entry.parent;
                    continue;
                }
                if (treeMap$Entry2.color) {
                    treeMap$Entry2.color = false;
                    treeMap$Entry.parent.color = true;
                    this.leftRotate(treeMap$Entry.parent);
                    treeMap$Entry2 = treeMap$Entry.parent.right;
                    if (treeMap$Entry2 == null) {
                        treeMap$Entry = treeMap$Entry.parent;
                        continue;
                    }
                }
                if (!(treeMap$Entry2.left != null && treeMap$Entry2.left.color || treeMap$Entry2.right != null && treeMap$Entry2.right.color)) {
                    treeMap$Entry2.color = true;
                    treeMap$Entry = treeMap$Entry.parent;
                    continue;
                }
                if (treeMap$Entry2.right == null || !treeMap$Entry2.right.color) {
                    treeMap$Entry2.left.color = false;
                    treeMap$Entry2.color = true;
                    this.rightRotate(treeMap$Entry2);
                    treeMap$Entry2 = treeMap$Entry.parent.right;
                }
                treeMap$Entry2.color = treeMap$Entry.parent.color;
                treeMap$Entry.parent.color = false;
                treeMap$Entry2.right.color = false;
                this.leftRotate(treeMap$Entry.parent);
                treeMap$Entry = this.root;
                continue;
            }
            treeMap$Entry2 = treeMap$Entry.parent.left;
            if (treeMap$Entry2 == null) {
                treeMap$Entry = treeMap$Entry.parent;
                continue;
            }
            if (treeMap$Entry2.color) {
                treeMap$Entry2.color = false;
                treeMap$Entry.parent.color = true;
                this.rightRotate(treeMap$Entry.parent);
                treeMap$Entry2 = treeMap$Entry.parent.left;
                if (treeMap$Entry2 == null) {
                    treeMap$Entry = treeMap$Entry.parent;
                    continue;
                }
            }
            if (!(treeMap$Entry2.left != null && treeMap$Entry2.left.color || treeMap$Entry2.right != null && treeMap$Entry2.right.color)) {
                treeMap$Entry2.color = true;
                treeMap$Entry = treeMap$Entry.parent;
                continue;
            }
            if (treeMap$Entry2.left == null || !treeMap$Entry2.left.color) {
                treeMap$Entry2.right.color = false;
                treeMap$Entry2.color = true;
                this.leftRotate(treeMap$Entry2);
                treeMap$Entry2 = treeMap$Entry.parent.left;
            }
            treeMap$Entry2.color = treeMap$Entry.parent.color;
            treeMap$Entry.parent.color = false;
            treeMap$Entry2.left.color = false;
            this.rightRotate(treeMap$Entry.parent);
            treeMap$Entry = this.root;
        }
        treeMap$Entry.color = false;
    }

    @Override
    public Object get(Object object) {
        TreeMap$Entry treeMap$Entry = this.find(object);
        if (treeMap$Entry != null) {
            return treeMap$Entry.value;
        }
        return null;
    }

    @Override
    public SortedMap headMap(Object object) {
        if (this.comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            this.comparator.compare(object, object);
        }
        return new TreeMap$SubMap(this, object);
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new TreeMap$8(this);
        }
        return this.keySet;
    }

    @Override
    public Object lastKey() {
        if (this.root != null) {
            return TreeMap.maximum((TreeMap$Entry)this.root).key;
        }
        throw new NoSuchElementException();
    }

    private void leftRotate(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2 = treeMap$Entry.right;
        treeMap$Entry.right = treeMap$Entry2.left;
        if (treeMap$Entry2.left != null) {
            treeMap$Entry2.left.parent = treeMap$Entry;
        }
        treeMap$Entry2.parent = treeMap$Entry.parent;
        if (treeMap$Entry.parent == null) {
            this.root = treeMap$Entry2;
        } else if (treeMap$Entry == treeMap$Entry.parent.left) {
            treeMap$Entry.parent.left = treeMap$Entry2;
        } else {
            treeMap$Entry.parent.right = treeMap$Entry2;
        }
        treeMap$Entry2.left = treeMap$Entry;
        treeMap$Entry.parent = treeMap$Entry2;
    }

    static TreeMap$Entry maximum(TreeMap$Entry treeMap$Entry) {
        while (treeMap$Entry.right != null) {
            treeMap$Entry = treeMap$Entry.right;
        }
        return treeMap$Entry;
    }

    static TreeMap$Entry minimum(TreeMap$Entry treeMap$Entry) {
        while (treeMap$Entry.left != null) {
            treeMap$Entry = treeMap$Entry.left;
        }
        return treeMap$Entry;
    }

    static TreeMap$Entry predecessor(TreeMap$Entry treeMap$Entry) {
        if (treeMap$Entry.left != null) {
            return TreeMap.maximum(treeMap$Entry.left);
        }
        TreeMap$Entry treeMap$Entry2 = treeMap$Entry.parent;
        while (treeMap$Entry2 != null && treeMap$Entry == treeMap$Entry2.left) {
            treeMap$Entry = treeMap$Entry2;
            treeMap$Entry2 = treeMap$Entry2.parent;
        }
        return treeMap$Entry2;
    }

    @Override
    public Object put(Object object, Object object2) {
        TreeMap$Entry treeMap$Entry = this.rbInsert(object);
        Object object3 = treeMap$Entry.value;
        treeMap$Entry.value = object2;
        return object3;
    }

    @Override
    public void putAll(Map map) {
        super.putAll(map);
    }

    void rbDelete(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2;
        TreeMap$Entry treeMap$Entry3 = treeMap$Entry.left == null || treeMap$Entry.right == null ? treeMap$Entry : TreeMap.successor(treeMap$Entry);
        TreeMap$Entry treeMap$Entry4 = treeMap$Entry2 = treeMap$Entry3.left != null ? treeMap$Entry3.left : treeMap$Entry3.right;
        if (treeMap$Entry2 != null) {
            treeMap$Entry2.parent = treeMap$Entry3.parent;
        }
        if (treeMap$Entry3.parent == null) {
            this.root = treeMap$Entry2;
        } else if (treeMap$Entry3 == treeMap$Entry3.parent.left) {
            treeMap$Entry3.parent.left = treeMap$Entry2;
        } else {
            treeMap$Entry3.parent.right = treeMap$Entry2;
        }
        ++this.modCount;
        if (treeMap$Entry3 != treeMap$Entry) {
            treeMap$Entry.key = treeMap$Entry3.key;
            treeMap$Entry.value = treeMap$Entry3.value;
        }
        if (!treeMap$Entry3.color && this.root != null) {
            if (treeMap$Entry2 == null) {
                this.fixup(treeMap$Entry3.parent);
            } else {
                this.fixup(treeMap$Entry2);
            }
        }
        --this.size;
    }

    private TreeMap$Entry rbInsert(Object object) {
        int n = 0;
        Comparable comparable = null;
        if (this.comparator == null) {
            comparable = (Comparable)object;
        }
        TreeMap$Entry treeMap$Entry = null;
        TreeMap$Entry treeMap$Entry2 = this.root;
        while (treeMap$Entry2 != null) {
            treeMap$Entry = treeMap$Entry2;
            int n2 = n = comparable != null ? comparable.compareTo(treeMap$Entry2.key) : this.comparator.compare(object, treeMap$Entry2.key);
            if (n == 0) {
                return treeMap$Entry2;
            }
            TreeMap$Entry treeMap$Entry3 = treeMap$Entry2 = n < 0 ? treeMap$Entry2.left : treeMap$Entry2.right;
        }
        ++this.size;
        ++this.modCount;
        TreeMap$Entry treeMap$Entry4 = new TreeMap$Entry(object);
        if (treeMap$Entry == null) {
            this.root = treeMap$Entry4;
            return this.root;
        }
        treeMap$Entry4.parent = treeMap$Entry;
        if (n < 0) {
            treeMap$Entry.left = treeMap$Entry4;
        } else {
            treeMap$Entry.right = treeMap$Entry4;
        }
        this.balance(treeMap$Entry4);
        return treeMap$Entry4;
    }

    @Override
    public Object remove(Object object) {
        TreeMap$Entry treeMap$Entry = this.find(object);
        if (treeMap$Entry == null) {
            return null;
        }
        Object object2 = treeMap$Entry.value;
        this.rbDelete(treeMap$Entry);
        return object2;
    }

    private void rightRotate(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2 = treeMap$Entry.left;
        treeMap$Entry.left = treeMap$Entry2.right;
        if (treeMap$Entry2.right != null) {
            treeMap$Entry2.right.parent = treeMap$Entry;
        }
        treeMap$Entry2.parent = treeMap$Entry.parent;
        if (treeMap$Entry.parent == null) {
            this.root = treeMap$Entry2;
        } else if (treeMap$Entry == treeMap$Entry.parent.right) {
            treeMap$Entry.parent.right = treeMap$Entry2;
        } else {
            treeMap$Entry.parent.left = treeMap$Entry2;
        }
        treeMap$Entry2.right = treeMap$Entry;
        treeMap$Entry.parent = treeMap$Entry2;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        if (this.comparator == null ? ((Comparable)object).compareTo(object2) <= 0 : this.comparator.compare(object, object2) <= 0) {
            return new TreeMap$SubMap(object, this, object2);
        }
        throw new IllegalArgumentException();
    }

    static TreeMap$Entry successor(TreeMap$Entry treeMap$Entry) {
        if (treeMap$Entry.right != null) {
            return TreeMap.minimum(treeMap$Entry.right);
        }
        TreeMap$Entry treeMap$Entry2 = treeMap$Entry.parent;
        while (treeMap$Entry2 != null && treeMap$Entry == treeMap$Entry2.right) {
            treeMap$Entry = treeMap$Entry2;
            treeMap$Entry2 = treeMap$Entry2.parent;
        }
        return treeMap$Entry2;
    }

    @Override
    public SortedMap tailMap(Object object) {
        if (this.comparator == null) {
            ((Comparable)object).compareTo(object);
        } else {
            this.comparator.compare(object, object);
        }
        return new TreeMap$SubMap(object, this);
    }

    @Override
    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new TreeMap$10(this);
        }
        return this.valuesCollection;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        if (this.size > 0) {
            TreeMap$Entry treeMap$Entry = TreeMap.minimum(this.root);
            while (treeMap$Entry != null) {
                objectOutputStream.writeObject(treeMap$Entry.key);
                objectOutputStream.writeObject(treeMap$Entry.value);
                treeMap$Entry = TreeMap.successor(treeMap$Entry);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.size = objectInputStream.readInt();
        TreeMap$Entry treeMap$Entry = null;
        int n = this.size;
        while (--n >= 0) {
            TreeMap$Entry treeMap$Entry2 = new TreeMap$Entry(objectInputStream.readObject());
            treeMap$Entry2.value = objectInputStream.readObject();
            if (treeMap$Entry == null) {
                this.root = treeMap$Entry2;
            } else {
                treeMap$Entry2.parent = treeMap$Entry;
                treeMap$Entry.right = treeMap$Entry2;
                this.balance(treeMap$Entry2);
            }
            treeMap$Entry = treeMap$Entry2;
        }
    }
}


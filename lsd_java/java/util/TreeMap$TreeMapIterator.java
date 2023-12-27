/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.MapEntry$Type;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeMap$Entry;

final class TreeMap$TreeMapIterator
implements Iterator {
    private final TreeMap backingMap;
    private int expectedModCount;
    private final MapEntry$Type type;
    private boolean hasEnd = false;
    private TreeMap$Entry node;
    private TreeMap$Entry lastNode;
    private Object endKey;

    TreeMap$TreeMapIterator(TreeMap treeMap, MapEntry$Type mapEntry$Type) {
        this.backingMap = treeMap;
        this.type = mapEntry$Type;
        this.expectedModCount = treeMap.modCount;
        if (treeMap.root != null) {
            this.node = TreeMap.minimum(treeMap.root);
        }
    }

    TreeMap$TreeMapIterator(TreeMap treeMap, MapEntry$Type mapEntry$Type, TreeMap$Entry treeMap$Entry, boolean bl, Object object) {
        this.backingMap = treeMap;
        this.type = mapEntry$Type;
        this.expectedModCount = treeMap.modCount;
        this.node = treeMap$Entry;
        this.hasEnd = bl;
        this.endKey = object;
    }

    @Override
    public boolean hasNext() {
        return this.node != null;
    }

    @Override
    public Object next() {
        if (this.expectedModCount == this.backingMap.modCount) {
            if (this.node != null) {
                this.lastNode = this.node;
                this.node = TreeMap.successor(this.node);
                if (this.hasEnd && this.node != null) {
                    Comparator comparator = this.backingMap.comparator();
                    if (comparator == null) {
                        if (((Comparable)this.endKey).compareTo(this.node.key) <= 0) {
                            this.node = null;
                        }
                    } else if (comparator.compare(this.endKey, this.node.key) <= 0) {
                        this.node = null;
                    }
                }
                return this.type.get(this.lastNode);
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void remove() {
        if (this.expectedModCount != this.backingMap.modCount) throw new ConcurrentModificationException();
        if (this.lastNode == null) throw new IllegalStateException();
        Object object = this.lastNode.key;
        this.backingMap.rbDelete(this.lastNode);
        if (this.lastNode.key != object) {
            this.node = this.lastNode;
        }
        this.lastNode = null;
        ++this.expectedModCount;
    }
}


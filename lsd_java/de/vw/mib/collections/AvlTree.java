/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.AvlTree$1;
import de.vw.mib.collections.AvlTree$AvlNode;
import de.vw.mib.collections.AvlTree$AvlNodePool;
import de.vw.mib.collections.AvlTree$AvlTreeIterator;
import de.vw.mib.collections.AvlTree$AvlTreeVisitor;
import de.vw.mib.collections.HashCodeBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class AvlTree
implements Set {
    static final Object NO_VALUE = new Object();
    static final AvlTree$AvlNode NO_NODE = new AvlTree$AvlNode();
    private static final int DEFAULT_MAXIMUM_NUMBER_OF_POOLED_NODES;
    private static final Comparator DEFAULT_COMPARATOR;
    private static final boolean KEEP_TREE;
    private static final boolean CLEAR_TREE;
    private AvlTree$AvlNode root;
    private Comparator comp;
    private final transient AvlTree$AvlNodePool pool;
    transient int modifications;

    public AvlTree() {
        this(new AvlTree$AvlNodePool(100), DEFAULT_COMPARATOR);
    }

    public AvlTree(Comparator comparator) {
        this(new AvlTree$AvlNodePool(100), comparator);
    }

    public AvlTree(int n, Comparator comparator) {
        this(new AvlTree$AvlNodePool(n), comparator);
    }

    public AvlTree(int n) {
        this(new AvlTree$AvlNodePool(n), DEFAULT_COMPARATOR);
    }

    private AvlTree(AvlTree$AvlNodePool avlTree$AvlNodePool, Comparator comparator) {
        this.pool = avlTree$AvlNodePool;
        this.comp = comparator;
        this.root = NO_NODE;
        this.modifications = 0;
    }

    public void init(Comparator comparator) {
        this.comp = comparator;
        this.clear();
    }

    public void setComparator(Comparator comparator) {
        Object[] objectArray = this.toArray();
        this.init(comparator);
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            this.add(objectArray[i2]);
        }
    }

    public Comparator getComparator() {
        return this.comp;
    }

    public Object first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        AvlTree$AvlNode avlTree$AvlNode = this.root;
        while (avlTree$AvlNode.left != NO_NODE) {
            avlTree$AvlNode = avlTree$AvlNode.left;
        }
        return avlTree$AvlNode.value;
    }

    public Object last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        AvlTree$AvlNode avlTree$AvlNode = this.root;
        while (avlTree$AvlNode.right != NO_NODE) {
            avlTree$AvlNode = avlTree$AvlNode.right;
        }
        return avlTree$AvlNode.value;
    }

    @Override
    public boolean add(Object object) {
        int n = this.root.size;
        this.root = this.add(object, this.root);
        return n < this.root.size;
    }

    private AvlTree$AvlNode add(Object object, AvlTree$AvlNode avlTree$AvlNode) {
        if (NO_NODE == avlTree$AvlNode) {
            AvlTree$AvlNode avlTree$AvlNode2 = (AvlTree$AvlNode)((Object)this.pool.borrowObject());
            avlTree$AvlNode2.init(object);
            ++this.modifications;
            return avlTree$AvlNode2;
        }
        int n = this.comp.compare(object, avlTree$AvlNode.value);
        if (n < 0) {
            avlTree$AvlNode.left = this.add(object, avlTree$AvlNode.left);
            avlTree$AvlNode = this.repairLeftIfNecessary(avlTree$AvlNode);
        } else if (n > 0) {
            avlTree$AvlNode.right = this.add(object, avlTree$AvlNode.right);
            avlTree$AvlNode = this.repairRightIfNecessary(avlTree$AvlNode);
        }
        avlTree$AvlNode.recalculate();
        return avlTree$AvlNode;
    }

    private AvlTree$AvlNode repairLeftIfNecessary(AvlTree$AvlNode avlTree$AvlNode) {
        if (avlTree$AvlNode.left.height - avlTree$AvlNode.right.height < 2) {
            return avlTree$AvlNode;
        }
        if (avlTree$AvlNode.left.left.height >= avlTree$AvlNode.left.right.height) {
            AvlTree$AvlNode avlTree$AvlNode2 = avlTree$AvlNode.left;
            avlTree$AvlNode.left = avlTree$AvlNode2.right;
            avlTree$AvlNode2.right = avlTree$AvlNode;
            avlTree$AvlNode.recalculate();
            avlTree$AvlNode2.recalculate();
            return avlTree$AvlNode2;
        }
        AvlTree$AvlNode avlTree$AvlNode3 = avlTree$AvlNode.left;
        AvlTree$AvlNode avlTree$AvlNode4 = avlTree$AvlNode3.right;
        avlTree$AvlNode.left = avlTree$AvlNode4.right;
        avlTree$AvlNode3.right = avlTree$AvlNode4.left;
        avlTree$AvlNode4.right = avlTree$AvlNode;
        avlTree$AvlNode4.left = avlTree$AvlNode3;
        avlTree$AvlNode.recalculate();
        avlTree$AvlNode3.recalculate();
        avlTree$AvlNode4.recalculate();
        return avlTree$AvlNode4;
    }

    private AvlTree$AvlNode repairRightIfNecessary(AvlTree$AvlNode avlTree$AvlNode) {
        if (avlTree$AvlNode.right.height - avlTree$AvlNode.left.height < 2) {
            return avlTree$AvlNode;
        }
        if (avlTree$AvlNode.right.right.height >= avlTree$AvlNode.right.left.height) {
            AvlTree$AvlNode avlTree$AvlNode2 = avlTree$AvlNode.right;
            avlTree$AvlNode.right = avlTree$AvlNode2.left;
            avlTree$AvlNode2.left = avlTree$AvlNode;
            avlTree$AvlNode.recalculate();
            avlTree$AvlNode2.recalculate();
            return avlTree$AvlNode2;
        }
        AvlTree$AvlNode avlTree$AvlNode3 = avlTree$AvlNode.right;
        AvlTree$AvlNode avlTree$AvlNode4 = avlTree$AvlNode3.left;
        avlTree$AvlNode.right = avlTree$AvlNode4.left;
        avlTree$AvlNode3.left = avlTree$AvlNode4.right;
        avlTree$AvlNode4.left = avlTree$AvlNode;
        avlTree$AvlNode4.right = avlTree$AvlNode3;
        avlTree$AvlNode.recalculate();
        avlTree$AvlNode3.recalculate();
        avlTree$AvlNode4.recalculate();
        return avlTree$AvlNode4;
    }

    @Override
    public boolean addAll(Collection collection) {
        int n = this.root.size;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return n < this.root.size;
    }

    @Override
    public void clear() {
        this.root.release();
        this.root = NO_NODE;
        ++this.modifications;
    }

    @Override
    public boolean contains(Object object) {
        AvlTree$AvlNode avlTree$AvlNode = this.find(object);
        return avlTree$AvlNode != NO_NODE;
    }

    private AvlTree$AvlNode find(Object object) {
        AvlTree$AvlNode avlTree$AvlNode = this.root;
        while (NO_NODE != avlTree$AvlNode) {
            int n = this.comp.compare(object, avlTree$AvlNode.value);
            if (n < 0) {
                avlTree$AvlNode = avlTree$AvlNode.left;
                continue;
            }
            if (n <= 0) break;
            avlTree$AvlNode = avlTree$AvlNode.right;
        }
        return avlTree$AvlNode;
    }

    @Override
    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.root == NO_NODE;
    }

    @Override
    public Iterator iterator() {
        return new AvlTree$AvlTreeIterator(this);
    }

    @Override
    public boolean remove(Object object) {
        int n = this.root.size;
        this.root = this.searchAndRemove(object, this.root);
        return n > this.root.size;
    }

    private AvlTree$AvlNode searchAndRemove(Object object, AvlTree$AvlNode avlTree$AvlNode) {
        if (NO_NODE == avlTree$AvlNode) {
            return NO_NODE;
        }
        int n = this.comp.compare(object, avlTree$AvlNode.value);
        if (n < 0) {
            avlTree$AvlNode.left = this.searchAndRemove(object, avlTree$AvlNode.left);
            avlTree$AvlNode = this.repairLeftIfNecessary(avlTree$AvlNode);
        } else if (n > 0) {
            avlTree$AvlNode.right = this.searchAndRemove(object, avlTree$AvlNode.right);
            avlTree$AvlNode = this.repairRightIfNecessary(avlTree$AvlNode);
        } else {
            ++this.modifications;
            if (avlTree$AvlNode.height < 2) {
                avlTree$AvlNode.release();
                return NO_NODE;
            }
            if (avlTree$AvlNode.left.height >= avlTree$AvlNode.right.height) {
                avlTree$AvlNode.left = this.foundAndRemoveMostRight(avlTree$AvlNode.left, avlTree$AvlNode);
                avlTree$AvlNode = this.repairLeftIfNecessary(avlTree$AvlNode);
            } else {
                avlTree$AvlNode.right = this.foundAndRemoveMostLeft(avlTree$AvlNode.right, avlTree$AvlNode);
                avlTree$AvlNode = this.repairRightIfNecessary(avlTree$AvlNode);
            }
        }
        avlTree$AvlNode.recalculate();
        return avlTree$AvlNode;
    }

    private AvlTree$AvlNode foundAndRemoveMostRight(AvlTree$AvlNode avlTree$AvlNode, AvlTree$AvlNode avlTree$AvlNode2) {
        if (NO_NODE == avlTree$AvlNode.right) {
            avlTree$AvlNode2.value = avlTree$AvlNode.value;
            AvlTree$AvlNode avlTree$AvlNode3 = avlTree$AvlNode.left;
            avlTree$AvlNode.left = NO_NODE;
            avlTree$AvlNode.release();
            return avlTree$AvlNode3;
        }
        avlTree$AvlNode.right = this.foundAndRemoveMostRight(avlTree$AvlNode.right, avlTree$AvlNode2);
        avlTree$AvlNode = this.repairRightIfNecessary(avlTree$AvlNode);
        avlTree$AvlNode.recalculate();
        return avlTree$AvlNode;
    }

    private AvlTree$AvlNode foundAndRemoveMostLeft(AvlTree$AvlNode avlTree$AvlNode, AvlTree$AvlNode avlTree$AvlNode2) {
        if (NO_NODE == avlTree$AvlNode.left) {
            avlTree$AvlNode2.value = avlTree$AvlNode.value;
            AvlTree$AvlNode avlTree$AvlNode3 = avlTree$AvlNode.right;
            avlTree$AvlNode.right = NO_NODE;
            avlTree$AvlNode.release();
            return avlTree$AvlNode3;
        }
        avlTree$AvlNode.left = this.foundAndRemoveMostLeft(avlTree$AvlNode.left, avlTree$AvlNode2);
        avlTree$AvlNode = this.repairLeftIfNecessary(avlTree$AvlNode);
        avlTree$AvlNode.recalculate();
        return avlTree$AvlNode;
    }

    @Override
    public boolean removeAll(Collection collection) {
        int n = this.root.size;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.remove(iterator.next());
        }
        return n > this.root.size;
    }

    @Override
    public boolean retainAll(Collection collection) {
        int n = this.root.size;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
        }
        return n > this.root.size;
    }

    @Override
    public int size() {
        return this.root.size;
    }

    public Object get(int n) {
        if (n < 0 || n >= this.root.size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("try to access ").append(n).append(", while size is ").append(this.root.size).toString());
        }
        AvlTree$AvlNode avlTree$AvlNode = this.root;
        int n2 = avlTree$AvlNode.left.size;
        while (n2 != n) {
            if (n < n2) {
                avlTree$AvlNode = avlTree$AvlNode.left;
                n2 = n2 - 1 - avlTree$AvlNode.right.size;
                continue;
            }
            avlTree$AvlNode = avlTree$AvlNode.right;
            n2 = n2 + 1 + avlTree$AvlNode.left.size;
        }
        return avlTree$AvlNode.value;
    }

    public int indexOf(Object object) {
        AvlTree$AvlNode avlTree$AvlNode = this.root;
        int n = avlTree$AvlNode.left.size;
        while (NO_NODE != avlTree$AvlNode) {
            int n2 = this.comp.compare(object, avlTree$AvlNode.value);
            if (n2 < 0) {
                avlTree$AvlNode = avlTree$AvlNode.left;
                n = n - 1 - avlTree$AvlNode.right.size;
                continue;
            }
            if (n2 > 0) {
                avlTree$AvlNode = avlTree$AvlNode.right;
                n = n + 1 + avlTree$AvlNode.left.size;
                continue;
            }
            return n;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.root.size], false);
    }

    public Object[] toArrayAndClear() {
        return this.toArray(new Object[this.root.size], true);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.toArray(objectArray, false);
    }

    public Object[] toArrayAndClear(Object[] objectArray) {
        return this.toArray(objectArray, true);
    }

    private Object[] toArray(Object[] objectArray, boolean bl) {
        Object[] objectArray2 = objectArray;
        int n = this.root.size;
        if (objectArray2.length < n) {
            Class clazz = super.getClass();
            objectArray2 = (Object[])Array.newInstance(clazz.getComponentType(), n);
        }
        if (bl) {
            ++this.modifications;
            this.root.toDataAndRelease(objectArray2, 0);
            this.root = NO_NODE;
        } else {
            this.root.toData(objectArray2, 0);
        }
        if (objectArray2.length > n) {
            objectArray2[n] = null;
        }
        return objectArray2;
    }

    public String toString() {
        return Arrays.toString(this.toArray());
    }

    @Override
    public int hashCode() {
        return (int)HashCodeBuilder.hash(this.root);
    }

    public void visitAllElements(AvlTreeVisitor avlTreeVisitor) {
        int n = this.modifications;
        this.root.accept(avlTreeVisitor);
        this.checkConcurrentModification(n);
    }

    void checkConcurrentModification(int n) {
        if (this.modifications != n) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AvlTree avlTree = (AvlTree)object;
        return this.root.equals(avlTree.root);
    }

    static {
        DEFAULT_COMPARATOR = new AvlTree$1();
    }
}


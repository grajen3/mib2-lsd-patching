/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.algorithms.LinkedQuickSort;
import de.vw.mib.collections.AvlTree;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public final class Algorithms {
    private final AvlTree sortAvlTree = new AvlTree();

    Algorithms() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] sort(Object[] objectArray, Comparator comparator) {
        Object[] objectArray2;
        AvlTree avlTree = this.sortAvlTree;
        synchronized (avlTree) {
            this.sortAvlTree.init(comparator);
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                this.sortAvlTree.add(objectArray[i2]);
            }
            objectArray2 = this.sortAvlTree.toArrayAndClear();
        }
        return objectArray2;
    }

    public Object[] sortRemoveDups(Collection collection, Comparator comparator) {
        return this.sortRemoveDups(collection, comparator, new Object[0]);
    }

    public Object[] sortRemoveDups(Collection collection, Comparator comparator, Object[] objectArray) {
        ObjectOptHashSet objectOptHashSet = new ObjectOptHashSet(collection.size());
        objectOptHashSet.addAll(collection);
        Object[] objectArray2 = objectOptHashSet.toArray(objectArray);
        Arrays.sort(objectArray2, comparator);
        return objectArray2;
    }

    public Object[] sortRemoveDups(Collection collection) {
        return this.sortRemoveDups(collection, new Object[0]);
    }

    public Object[] sortRemoveDups(Collection collection, Object[] objectArray) {
        ObjectOptHashSet objectOptHashSet = new ObjectOptHashSet(collection.size());
        objectOptHashSet.addAll(collection);
        Object[] objectArray2 = objectOptHashSet.toArray(objectArray);
        Arrays.sort(objectArray2);
        return objectArray2;
    }

    public Object[] sortRemoveDups(Object[] objectArray, Comparator comparator) {
        return this.sortRemoveDups(objectArray, comparator, new Object[0]);
    }

    public Object[] sortRemoveDups(Object[] objectArray, Comparator comparator, Object[] objectArray2) {
        ObjectOptHashSet objectOptHashSet = new ObjectOptHashSet(objectArray.length);
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            objectOptHashSet.add(objectArray[i2]);
        }
        Object[] objectArray3 = objectOptHashSet.toArray(objectArray2);
        Arrays.sort(objectArray3, comparator);
        return objectArray3;
    }

    public Object[] sortRemoveDups(Object[] objectArray) {
        return this.sortRemoveDups(objectArray, new Object[0]);
    }

    public Object[] sortRemoveDups(Object[] objectArray, Object[] objectArray2) {
        ObjectOptHashSet objectOptHashSet = new ObjectOptHashSet(objectArray.length);
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            objectOptHashSet.add(objectArray[i2]);
        }
        Object[] objectArray3 = objectOptHashSet.toArray(objectArray2);
        Arrays.sort(objectArray3);
        return objectArray3;
    }

    public void sortLinkedArrays(int[] nArray, Object[] objectArray) {
        LinkedQuickSort.sortLinkedArrays(nArray, objectArray);
    }

    public void sortLinkedArrays(Object[] objectArray, Object[] objectArray2) {
        LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2);
    }

    public void sortLinkedArrays(Object[] objectArray, Object[] objectArray2, Comparator comparator) {
        LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2, comparator);
    }

    public HashCodeBuilder createHashCodeBuilder() {
        return new HashCodeBuilder();
    }

    public StringBuilder createStringBuilder(int n) {
        return new StringBuilder(n);
    }
}


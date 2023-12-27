/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.algorithms;

import de.vw.mib.collections.AvlTree;
import java.util.Comparator;

public final class Sorter {
    private static final AvlTree SORT_AVL_TREE = new AvlTree();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Object[] sortByAvlTree(Object[] objectArray, Comparator comparator) {
        Object[] objectArray2;
        AvlTree avlTree = SORT_AVL_TREE;
        synchronized (avlTree) {
            SORT_AVL_TREE.init(comparator);
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                SORT_AVL_TREE.add(objectArray[i2]);
            }
            objectArray2 = SORT_AVL_TREE.toArrayAndClear();
        }
        return objectArray2;
    }

    private Sorter() {
    }
}


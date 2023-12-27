/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.MapEntry;

class TreeMap$Entry
extends MapEntry {
    TreeMap$Entry parent;
    TreeMap$Entry left;
    TreeMap$Entry right;
    boolean color;

    TreeMap$Entry(Object object) {
        super(object);
    }

    TreeMap$Entry(Object object, Object object2) {
        super(object, object2);
    }

    TreeMap$Entry clone(TreeMap$Entry treeMap$Entry) {
        TreeMap$Entry treeMap$Entry2 = (TreeMap$Entry)super.clone();
        treeMap$Entry2.parent = treeMap$Entry;
        if (this.left != null) {
            treeMap$Entry2.left = this.left.clone(treeMap$Entry2);
        }
        if (this.right != null) {
            treeMap$Entry2.right = this.right.clone(treeMap$Entry2);
        }
        return treeMap$Entry2;
    }
}


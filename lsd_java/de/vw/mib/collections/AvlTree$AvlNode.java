/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.AvlTree;
import de.vw.mib.collections.AvlTree$AvlTreeVisitor;
import de.vw.mib.collections.HashCodeBuilder;

class AvlTree$AvlNode {
    Object value;
    AvlTree$AvlNode left = this;
    AvlTree$AvlNode right = this;
    transient int height = 0;
    transient int size = 0;

    AvlTree$AvlNode() {
        this.value = AvlTree.NO_VALUE;
    }

    public boolean accept(AvlTree$AvlTreeVisitor avlTree$AvlTreeVisitor) {
        return true;
    }

    void init(Object object) {
    }

    void release() {
    }

    int toData(Object[] objectArray, int n) {
        return n;
    }

    int toDataAndRelease(Object[] objectArray, int n) {
        return n;
    }

    final void recalculate() {
        this.height = Math.max(this.left.height, this.right.height) + 1;
        this.size = this.left.size + this.right.size + 1;
    }

    public String toString() {
        return "[]";
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.left).append(this.value).append(this.right).hashCode();
    }

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
        AvlTree$AvlNode avlTree$AvlNode = (AvlTree$AvlNode)object;
        if (!this.left.equals(avlTree$AvlNode.left)) {
            return false;
        }
        if (!this.right.equals(avlTree$AvlNode.right)) {
            return false;
        }
        return !(this.value == null ? avlTree$AvlNode.value != null : !this.value.equals(avlTree$AvlNode.value));
    }
}


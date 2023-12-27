/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.AvlTree;
import de.vw.mib.collections.AvlTree$AvlNode;
import de.vw.mib.collections.AvlTree$AvlNodePool;
import de.vw.mib.collections.AvlTree$AvlTreeVisitor;
import de.vw.mib.pool.PooledObject;

class AvlTree$AvlNodePool$PooledAvlNode
extends AvlTree$AvlNode
implements PooledObject {
    private final /* synthetic */ AvlTree$AvlNodePool this$0;

    public AvlTree$AvlNodePool$PooledAvlNode(AvlTree$AvlNodePool avlTree$AvlNodePool) {
        this.this$0 = avlTree$AvlNodePool;
        this.init(AvlTree.NO_VALUE);
    }

    @Override
    public void backToPool() {
    }

    @Override
    void release() {
        this.left.release();
        this.right.release();
        this.init(AvlTree.NO_VALUE);
        this.this$0.releaseObject(this);
    }

    @Override
    void init(Object object) {
        this.value = object;
        this.left = AvlTree.NO_NODE;
        this.right = AvlTree.NO_NODE;
        this.height = 1;
        this.size = 1;
    }

    @Override
    public boolean accept(AvlTree$AvlTreeVisitor avlTree$AvlTreeVisitor) {
        boolean bl = this.left.accept(avlTree$AvlTreeVisitor);
        if (bl) {
            bl = avlTree$AvlTreeVisitor.visit(this.value);
        }
        if (bl) {
            this.right.accept(avlTree$AvlTreeVisitor);
        }
        return bl;
    }

    @Override
    int toData(Object[] objectArray, int n) {
        int n2 = n;
        n2 = this.left.toData(objectArray, n2);
        objectArray[n2] = this.value;
        ++n2;
        n2 = this.right.toData(objectArray, n2);
        return n2;
    }

    @Override
    int toDataAndRelease(Object[] objectArray, int n) {
        int n2 = n;
        n2 = this.left.toDataAndRelease(objectArray, n2);
        objectArray[n2] = this.value;
        ++n2;
        n2 = this.right.toDataAndRelease(objectArray, n2);
        this.init(AvlTree.NO_VALUE);
        this.this$0.releaseObject(this);
        return n2;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("(").append(this.left).append(" / ").append(this.value).append(" / ").append(this.right).append(")").toString();
    }
}


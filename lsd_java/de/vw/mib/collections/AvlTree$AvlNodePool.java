/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.AvlTree$AvlNodePool$PooledAvlNode;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

class AvlTree$AvlNodePool
extends AbstractUnsynchronizedObjectPool {
    AvlTree$AvlNodePool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new AvlTree$AvlNodePool$PooledAvlNode(this);
    }
}


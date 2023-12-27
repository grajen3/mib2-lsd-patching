/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.pool.PoorMansPool;

final class GenericASLList$FetchBlock {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    int start;
    int end;
    GenericASLList$FetchBlock next;

    private GenericASLList$FetchBlock() {
    }

    private GenericASLList$FetchBlock setData(int n, int n2, GenericASLList$FetchBlock genericASLList$FetchBlock) {
        this.start = n;
        this.end = n2;
        this.next = genericASLList$FetchBlock;
        return this;
    }

    boolean intersects(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        return null != genericASLList$FetchBlock && this.start <= genericASLList$FetchBlock.end && this.end >= genericASLList$FetchBlock.start;
    }

    static GenericASLList$FetchBlock borrow(int n, int n2, GenericASLList$FetchBlock genericASLList$FetchBlock) {
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = (GenericASLList$FetchBlock)POOL.borrow();
        if (null == genericASLList$FetchBlock2) {
            genericASLList$FetchBlock2 = new GenericASLList$FetchBlock();
        }
        return genericASLList$FetchBlock2.setData(n, n2, genericASLList$FetchBlock);
    }

    static GenericASLList$FetchBlock clone(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        return GenericASLList$FetchBlock.borrow(genericASLList$FetchBlock.start, genericASLList$FetchBlock.end, null);
    }

    static void release(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        genericASLList$FetchBlock.next = null;
        POOL.release(genericASLList$FetchBlock);
    }

    static {
        POOL = new PoorMansPool("ASLList.FetchBlock", 20);
    }
}


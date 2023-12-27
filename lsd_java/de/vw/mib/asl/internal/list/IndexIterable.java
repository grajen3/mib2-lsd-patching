/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.IndexIterator;

public interface IndexIterable {
    public static final int ITERATOR_UNBOUND;

    default public IndexIterator indexIterator(int n, int n2) {
    }

    default public IndexIterator indexIterator() {
    }
}


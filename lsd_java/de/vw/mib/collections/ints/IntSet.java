/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;

public interface IntSet
extends IntCollection {
    default public IntSet synchronize() {
    }

    default public int get(int n) {
    }
}


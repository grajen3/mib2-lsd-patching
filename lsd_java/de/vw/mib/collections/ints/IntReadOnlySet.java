/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntReadOnlyCollection;
import de.vw.mib.collections.ints.IntSet;

public class IntReadOnlySet
extends IntReadOnlyCollection
implements IntSet {
    public IntReadOnlySet(IntSet intSet) {
        super(intSet);
    }

    @Override
    public IntSet synchronize() {
        return new IntReadOnlySet(((IntSet)this.backing).synchronize());
    }

    @Override
    public int get(int n) {
        return ((IntSet)this.backing).get(n);
    }
}


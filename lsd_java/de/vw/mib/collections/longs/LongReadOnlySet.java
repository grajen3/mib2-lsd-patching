/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongReadOnlyCollection;
import de.vw.mib.collections.longs.LongSet;

public class LongReadOnlySet
extends LongReadOnlyCollection
implements LongSet {
    public LongReadOnlySet(LongSet longSet) {
        super(longSet);
    }

    @Override
    public LongSet synchronize() {
        return new LongReadOnlySet(((LongSet)this.backing).synchronize());
    }

    @Override
    public long get(long l) {
        return ((LongSet)this.backing).get(l);
    }
}


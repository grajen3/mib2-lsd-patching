/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.booleans.BooleanReadOnlyCollection;
import de.vw.mib.collections.booleans.BooleanSet;

public class BooleanReadOnlySet
extends BooleanReadOnlyCollection
implements BooleanSet {
    public BooleanReadOnlySet(BooleanSet booleanSet) {
        super(booleanSet);
    }

    @Override
    public BooleanSet synchronize() {
        return new BooleanReadOnlySet(((BooleanSet)this.backing).synchronize());
    }

    @Override
    public boolean get(boolean bl) {
        return ((BooleanSet)this.backing).get(bl);
    }
}


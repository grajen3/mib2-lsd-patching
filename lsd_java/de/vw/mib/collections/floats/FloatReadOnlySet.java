/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.floats.FloatReadOnlyCollection;
import de.vw.mib.collections.floats.FloatSet;

public class FloatReadOnlySet
extends FloatReadOnlyCollection
implements FloatSet {
    public FloatReadOnlySet(FloatSet floatSet) {
        super(floatSet);
    }

    @Override
    public FloatSet synchronize() {
        return new FloatReadOnlySet(((FloatSet)this.backing).synchronize());
    }

    @Override
    public float get(float f2) {
        return ((FloatSet)this.backing).get(f2);
    }
}


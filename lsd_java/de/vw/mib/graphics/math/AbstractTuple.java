/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.graphics.math.Tuple;

public abstract class AbstractTuple
implements Tuple {
    private static final long serialVersionUID;

    public Object clone() {
        try {
            AbstractTuple abstractTuple = (AbstractTuple)super.clone();
            return abstractTuple;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public abstract int getDimension() {
    }

    @Override
    public abstract boolean isZero() {
    }
}


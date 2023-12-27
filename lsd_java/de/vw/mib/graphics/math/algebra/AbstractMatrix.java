/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.math.algebra.Matrixf;

public abstract class AbstractMatrix
implements Matrixf {
    private static final long serialVersionUID;
    protected final boolean COLUMN_MAJOR;

    public AbstractMatrix() {
        this.COLUMN_MAJOR = true;
    }

    public Object clone() {
        try {
            AbstractMatrix abstractMatrix = (AbstractMatrix)super.clone();
            return abstractMatrix;
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

    @Override
    public abstract boolean isIdentity() {
    }

    @Override
    public final boolean isOrthogonal() {
        throw new NotYetImplementedException();
    }

    @Override
    public abstract float getDeterminant() {
    }

    @Override
    public abstract float get(int n, int n2) {
    }

    @Override
    public abstract void set(int n, int n2, float f2) {
    }
}


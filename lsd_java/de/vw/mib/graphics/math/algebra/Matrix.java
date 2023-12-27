/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.algebra;

import java.io.Serializable;

public interface Matrix
extends Cloneable,
Serializable {
    default public int getDimension() {
    }

    default public boolean isZero() {
    }

    default public boolean isIdentity() {
    }

    default public boolean isOrthogonal() {
    }

    default public float getDeterminant() {
    }
}


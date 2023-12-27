/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

public interface ValueReference
extends Cloneable {
    public static final short VALUE_REFERENCE_INTEGER;
    public static final short VALUE_REFERENCE_FLOAT;
    public static final short VALUE_REFERENCE_BOOLEAN;

    default public Object clone() {
    }

    default public short getReferenceClass() {
    }

    default public void setReferenceClass(short s) {
    }

    default public int getPropertyID() {
    }

    default public void setPropertyID(int n) {
    }
}


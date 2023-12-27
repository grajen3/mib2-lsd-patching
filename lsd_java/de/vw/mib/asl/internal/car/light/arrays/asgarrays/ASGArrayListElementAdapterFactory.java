/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.asgarrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;

public abstract class ASGArrayListElementAdapterFactory {
    protected int size;

    protected int getSize() {
        return this.size;
    }

    protected abstract BAPArrayElement createNewElementAdapter(int n) {
    }

    protected abstract BAPArrayElement createNewElementAdapter() {
    }

    protected abstract BAPArrayElement createNewElementAdapter(BAPArrayElement bAPArrayElement) {
    }
}


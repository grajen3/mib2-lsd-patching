/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.types;

public class GenericEnumValue {
    private final int value;

    protected GenericEnumValue(int n) {
        this.value = n;
    }

    public int value() {
        return this.value;
    }
}


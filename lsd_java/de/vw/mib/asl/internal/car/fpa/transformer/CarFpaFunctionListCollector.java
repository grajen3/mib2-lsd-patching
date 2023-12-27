/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.transformer;

public final class CarFpaFunctionListCollector {
    public boolean isFunctionAvailable;
    public boolean[] optionMask;

    public CarFpaFunctionListCollector(boolean bl, boolean[] blArray) {
        this.isFunctionAvailable = bl;
        this.optionMask = blArray;
    }
}


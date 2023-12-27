/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

public final class CarFunctionCollector {
    public boolean functionAvailable;
    public int functionReason;

    public CarFunctionCollector() {
        this.functionAvailable = false;
        this.functionReason = 0;
    }

    public CarFunctionCollector(boolean bl, int n) {
        this.functionAvailable = bl;
        this.functionReason = n;
    }
}


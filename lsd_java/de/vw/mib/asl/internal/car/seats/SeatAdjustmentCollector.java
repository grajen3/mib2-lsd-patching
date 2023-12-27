/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats;

public class SeatAdjustmentCollector {
    boolean cushionDepth;
    boolean lateralCushion;
    boolean lateralBack;
    boolean upperBack;

    public SeatAdjustmentCollector(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.cushionDepth = bl;
        this.lateralCushion = bl2;
        this.lateralBack = bl3;
        this.upperBack = bl4;
    }

    public SeatAdjustmentCollector() {
        this.cushionDepth = false;
        this.lateralCushion = false;
        this.lateralBack = false;
        this.upperBack = false;
    }

    public boolean isCushionDepth() {
        return this.cushionDepth;
    }

    public boolean isLateralCushion() {
        return this.lateralCushion;
    }

    public boolean isLateralBack() {
        return this.lateralBack;
    }

    public boolean isUpperBack() {
        return this.upperBack;
    }
}


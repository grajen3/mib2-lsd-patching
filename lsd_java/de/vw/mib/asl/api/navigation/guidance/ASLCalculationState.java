/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

public class ASLCalculationState {
    private int calculationState = 0;
    private int progress = 0;

    public int getCalculationState() {
        return this.calculationState;
    }

    public void setCalculationState(int n) {
        this.calculationState = n;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int n) {
        this.progress = n;
    }
}


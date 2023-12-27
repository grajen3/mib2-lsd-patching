/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model;

public class FunctionState {
    private boolean existence;
    private int availableReason;
    private int state;
    private int reason;

    public FunctionState(int n, int n2) {
        this.calculateState(n, n2);
    }

    public boolean isExistence() {
        return this.existence;
    }

    public int getAvailableReason() {
        return this.availableReason;
    }

    public void setFunctionState(int n, int n2) {
        this.calculateState(n, n2);
    }

    private void calculateState(int n, int n2) {
        this.state = n;
        this.reason = n2;
        boolean bl = this.existence = n != 0;
        this.availableReason = n == 2 ? 0 : (n == 1 && n2 == 0 ? 6 : n2);
    }

    public int getFunctionState() {
        return this.state;
    }

    public int getFunctionAvailableReason() {
        return this.reason;
    }
}


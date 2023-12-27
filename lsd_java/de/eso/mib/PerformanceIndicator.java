/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

public final class PerformanceIndicator {
    private boolean enabled;
    private int type;
    private long denominator;
    private long value;

    public PerformanceIndicator(int n, long l, boolean bl) {
        this.enabled = bl;
        this.type = n;
        this.denominator = l;
        this.value = 0L;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setValue(long l) {
        this.value = l;
    }

    public long getValue() {
        return this.value;
    }

    public int getType() {
        return this.type;
    }

    public long getDenominator() {
        return this.denominator;
    }
}


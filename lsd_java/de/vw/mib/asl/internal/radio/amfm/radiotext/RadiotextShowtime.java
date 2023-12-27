/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

final class RadiotextShowtime {
    private boolean mThresholdExceeded = false;
    private int mTime = 2000;

    RadiotextShowtime() {
    }

    void setThresholdExceeded(boolean bl) {
        this.mThresholdExceeded = bl;
    }

    int getTime() {
        if (this.mThresholdExceeded) {
            return this.mTime;
        }
        return 2000;
    }

    void setTime(int n) {
        if (n > 0) {
            this.mTime = n * 1000;
        }
    }
}


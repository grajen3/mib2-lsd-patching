/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

public class SoundRangeContainer {
    private short low = 0;
    private short medium = (short)6;
    private short high = (short)12;
    private short lowMax = (short)(this.low + (this.high - this.low) / 3);
    private short highMin = (short)(this.high - (this.high - this.low) / 3);
    private static final int ASL_LOW;
    private static final int ASL_MEDIUM;
    private static final int ASL_HIGH;
    private boolean isInitialized = false;

    public void initDSIBlocks(int n, int n2) {
        this.low = (short)n;
        this.medium = (short)(n + (n2 - n) / 2);
        this.high = (short)n2;
        this.lowMax = (short)(this.low + (this.high - this.low) / 3);
        this.highMin = (short)(this.high - (this.high - this.low) / 3);
        this.isInitialized = true;
    }

    public short getDSIRangeValue(int n) {
        switch (n) {
            case 0: {
                return this.low;
            }
            case 1: {
                return this.medium;
            }
            case 2: {
                return this.high;
            }
        }
        return this.low;
    }

    public int getASLItemValue(short s) {
        if (s >= this.low && s <= this.lowMax) {
            return 0;
        }
        if (s > this.lowMax && s < this.highMin) {
            return 1;
        }
        if (s >= this.highMin && s <= this.high) {
            return 2;
        }
        return 0;
    }
}


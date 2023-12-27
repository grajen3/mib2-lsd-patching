/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.webradio;

public class FifoArray {
    private Object[] fifoArray;

    FifoArray(int n) {
        if (n > 0) {
            this.fifoArray = new Object[n];
        }
    }

    public void add(Object object) {
        if (null != this.fifoArray) {
            for (int i2 = this.fifoArray.length - 1; i2 > 0; --i2) {
                this.fifoArray[i2] = this.fifoArray[i2 - 1];
            }
            this.fifoArray[0] = object;
        }
    }

    public Object[] get() {
        return this.fifoArray;
    }
}


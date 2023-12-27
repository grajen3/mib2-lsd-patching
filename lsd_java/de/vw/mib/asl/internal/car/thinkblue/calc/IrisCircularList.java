/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc;

import de.vw.mib.asl.internal.car.thinkblue.Common;
import edu.emory.mathcs.backport.java.util.Arrays;

public class IrisCircularList {
    int[] list;
    int currentIdxPos;
    private int counter;

    public IrisCircularList(int n) {
        this.createElements(n);
    }

    public IrisCircularList() {
        this.list = new int[Common.IRIS_SEGS_SIZE];
    }

    private void createElements(int n) {
        this.list = new int[n];
    }

    public void add(int n) {
        this.list[this.currentIdxPos++] = n;
        if (this.currentIdxPos > Common.IRIS_SEGS_SIZE - 1) {
            this.currentIdxPos = 0;
        }
        if (this.counter < this.list.length) {
            ++this.counter;
        }
    }

    public void reset() {
        Arrays.fill(this.list, 0);
        this.currentIdxPos = 0;
        this.counter = 0;
    }

    public int getCurrentBarPosition() {
        return this.currentIdxPos;
    }

    public void setCurrentBarPosition(int n) {
        this.currentIdxPos = n;
    }

    private int getBPSum() {
        int n = 0;
        for (int i2 = 0; i2 < this.list.length; ++i2) {
            n += this.list[i2];
        }
        return n;
    }

    public int getBPAverage() {
        if (this.counter == 0) {
            return 0;
        }
        return this.getBPSum() / this.counter;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int n) {
        this.counter = n;
    }

    public String toString() {
        return new StringBuffer().append("TBT.IrisCircularList [list=").append(this.list != null ? this.arrayToString(this.list, this.list.length) : null).append("]").toString();
    }

    private String arrayToString(int[] nArray, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(nArray[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int[] getList() {
        return this.list;
    }
}


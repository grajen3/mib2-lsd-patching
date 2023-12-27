/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

public class AverageData {
    private int average;
    private int counter;

    public AverageData getad() {
        return null;
    }

    public void reset() {
        this.average = 0;
        this.counter = 0;
    }

    public void addValue(int n) {
        this.average += n;
        ++this.counter;
    }

    public int calculateAverage() {
        if (this.average == 0 || this.counter == 0) {
            return 0;
        }
        return Math.round(this.average / this.counter);
    }

    public int getAverage() {
        return this.average;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setAverage(int n) {
        this.average = n;
    }

    public void setCounter(int n) {
        this.counter = n;
    }
}


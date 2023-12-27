/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import edu.emory.mathcs.backport.java.util.Arrays;

public class HistoryDiagram {
    private static final int HISTORY_BAR_NEWSTYLE;
    private static final int HISTORY_BAR_OLDSTYLE;
    private int[] diagramValues;
    private int[] diagramStates;
    private int counter;
    private float collectedValues;
    private int lastValueAdded;

    public void reset() {
        Arrays.fill(this.diagramStates, 1);
        this.counter = 0;
        this.collectedValues = 0.0f;
    }

    public void setValues(int[] nArray) {
        this.diagramValues = nArray;
    }

    public void setStates(int[] nArray) {
        this.diagramStates = nArray;
    }

    public int[] getValues() {
        return this.diagramValues;
    }

    public int[] getStates() {
        return this.diagramStates;
    }

    public void setNewStyleStateElements(int n) {
        Arrays.fill(this.diagramStates, 1);
        int n2 = 0;
        while (n > 0) {
            this.diagramStates[n2] = 0;
            --n;
            ++n2;
        }
    }

    private void addElementToDiagram(int n) {
        int[] nArray = (int[])this.diagramValues.clone();
        for (int i2 = this.diagramValues.length - 1; i2 > 0; --i2) {
            nArray[i2] = this.diagramValues[i2 - 1];
            this.diagramStates[i2] = this.diagramStates[i2 - 1];
        }
        nArray[0] = n;
        this.diagramStates[0] = 0;
        this.diagramValues = nArray;
    }

    public void calculateAverage() {
        int n;
        this.lastValueAdded = n = Math.round(this.counter > 0 ? (float)Math.round(this.collectedValues / (float)this.counter) : (float)this.lastValueAdded);
        this.addElementToDiagram(n);
        this.counter = 0;
        this.collectedValues = 0.0f;
    }

    public void addValue(float f2) {
        this.collectedValues += f2;
        ++this.counter;
    }
}


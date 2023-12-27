/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState;

public class DrivingState$Builder {
    final int id;
    final String stateName;
    int w1;
    int rating;
    int dataSetWeight;
    int dataSetRate;

    public DrivingState$Builder(int n, String string) {
        this.id = n;
        this.stateName = string;
    }

    public DrivingState$Builder weight(int n, int n2) {
        this.w1 = n;
        this.rating = n2;
        return this;
    }

    public DrivingState$Builder dataSet(int n, int n2) {
        this.dataSetWeight = n;
        this.dataSetRate = n2;
        return this;
    }

    public DrivingState build() {
        return new DrivingState(this);
    }
}


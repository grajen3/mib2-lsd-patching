/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import de.vw.mib.asl.internal.car.thinkblue.calc.table.DrivingState$Builder;

public final class DrivingState {
    private final int id;
    private int w1;
    private int w2;
    private int rating;
    private final String stateName;
    private final int dataSetWeight;
    private final int dataSetRate;

    DrivingState(DrivingState$Builder drivingState$Builder) {
        this.id = drivingState$Builder.id;
        this.w1 = drivingState$Builder.w1;
        this.rating = drivingState$Builder.rating;
        this.w2 = 100 - this.w1;
        this.stateName = drivingState$Builder.stateName;
        this.dataSetWeight = drivingState$Builder.dataSetWeight;
        this.dataSetRate = drivingState$Builder.dataSetRate;
    }

    public int getId() {
        return this.id;
    }

    public int getW1() {
        return this.w1;
    }

    public void setW1(int n) {
        this.w1 = n;
        this.w2 = 100 - n;
    }

    public int getW2() {
        return this.w2;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int n) {
        this.rating = n;
    }

    public String getStateName() {
        return this.stateName;
    }

    public int getDataSetWeight() {
        return this.dataSetWeight;
    }

    public int getDataSetRate() {
        return this.dataSetRate;
    }

    public String toString() {
        return new StringBuffer().append("DrivingState [w1=").append(this.w1).append(", w2=").append(this.w2).append(", rating=").append(this.rating).append("]").toString();
    }
}


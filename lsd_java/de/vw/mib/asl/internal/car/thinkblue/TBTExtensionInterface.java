/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.internal.car.thinkblue.AverageData;

public interface TBTExtensionInterface {
    default public void addBluePoints(int n) {
    }

    default public AverageData getLongTermData() {
    }

    default public AverageData getSinceRefuelData() {
    }

    default public void setLongTermData(AverageData averageData) {
    }

    default public void setSinceRefuelData(AverageData averageData) {
    }

    default public int getLongTermAverage() {
    }

    default public int getSinceRefuelAverage() {
    }
}


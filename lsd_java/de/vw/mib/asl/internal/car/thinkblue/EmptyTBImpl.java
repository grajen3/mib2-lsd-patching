/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.internal.car.thinkblue.AverageData;
import de.vw.mib.asl.internal.car.thinkblue.TBTExtensionInterface;

public class EmptyTBImpl
implements TBTExtensionInterface {
    @Override
    public void addBluePoints(int n) {
    }

    @Override
    public AverageData getLongTermData() {
        return new AverageData();
    }

    @Override
    public AverageData getSinceRefuelData() {
        return new AverageData();
    }

    @Override
    public void setLongTermData(AverageData averageData) {
    }

    @Override
    public void setSinceRefuelData(AverageData averageData) {
    }

    @Override
    public int getLongTermAverage() {
        return 0;
    }

    @Override
    public int getSinceRefuelAverage() {
        return 0;
    }
}


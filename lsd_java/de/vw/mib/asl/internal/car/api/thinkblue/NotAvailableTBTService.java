/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.thinkblue;

import de.vw.mib.asl.api.car.thinkblue.TBTService;

public class NotAvailableTBTService
implements TBTService {
    @Override
    public boolean getBluePointsTrend() {
        return false;
    }

    @Override
    public int getCurrentAcceleration() {
        return 0;
    }

    @Override
    public int getEcoAverageTrip() {
        return 0;
    }

    @Override
    public boolean getConsumptionTrend() {
        return true;
    }

    @Override
    public int getCurrentConsumption() {
        return 0;
    }

    @Override
    public int getCurrentConsumptionDecimal() {
        return 0;
    }

    @Override
    public int getBluePoints() {
        return 0;
    }

    @Override
    public int getCurrentGear() {
        return 0;
    }

    @Override
    public int getCurrentIrisSegment() {
        return 0;
    }

    @Override
    public int[] getIrisSegmentsValues() {
        return null;
    }

    @Override
    public int getMaxAcceleration() {
        return 0;
    }

    @Override
    public int getRecommendedGear() {
        return 0;
    }

    @Override
    public int getDisplayDurationHintIcon() {
        return 0;
    }

    @Override
    public int getDrivingBehaviorMode() {
        return 0;
    }

    @Override
    public void hintIconTimerElapsed() {
    }

    @Override
    public void speedHintIconDisplayed() {
    }
}


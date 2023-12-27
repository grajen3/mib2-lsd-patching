/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.thinkblue;

public interface TBTService {
    public static final int GET_DRIVING_BEHAVIOR_MODE_ENUM_GOOD;
    public static final int GET_DRIVING_BEHAVIOR_MODE_ENUM_SPEEDING;
    public static final int GET_DRIVING_BEHAVIOR_MODE_ENUM_GEAR;
    public static final int GET_DRIVING_BEHAVIOR_MODE_ENUM_PLANNING;
    public static final int GET_DRIVING_BEHAVIOR_MODE_ENUM_NO_ICON;

    default public boolean getBluePointsTrend() {
    }

    default public int getCurrentAcceleration() {
    }

    default public int getEcoAverageTrip() {
    }

    default public boolean getConsumptionTrend() {
    }

    default public int getCurrentConsumption() {
    }

    default public int getCurrentConsumptionDecimal() {
    }

    default public int getBluePoints() {
    }

    default public int getCurrentGear() {
    }

    default public int getCurrentIrisSegment() {
    }

    default public int[] getIrisSegmentsValues() {
    }

    default public int getMaxAcceleration() {
    }

    default public int getRecommendedGear() {
    }

    default public int getDisplayDurationHintIcon() {
    }

    default public int getDrivingBehaviorMode() {
    }

    default public void hintIconTimerElapsed() {
    }

    default public void speedHintIconDisplayed() {
    }
}


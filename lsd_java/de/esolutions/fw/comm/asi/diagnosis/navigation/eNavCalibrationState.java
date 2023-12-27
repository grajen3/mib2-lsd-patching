/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation;

import de.esolutions.fw.comm.core.IEnum;

public interface eNavCalibrationState
extends IEnum {
    public static final int NAV_NO_CALIBRATION;
    public static final int NAV_CALIBRATION_SENSORS_CALIBRATED;
    public static final int NAV_CALIBRATION_POSITIONING_POSSIBLE;
    public static final int NAV_CALIBRATION_POSITIONING_POSSIBLE_WITHOUT_GPS;
    public static final int NAV_CALIBRATION_NEARLY_FINISHED;
    public static final int NAV_CALIBRATION_COMPLETE;
}


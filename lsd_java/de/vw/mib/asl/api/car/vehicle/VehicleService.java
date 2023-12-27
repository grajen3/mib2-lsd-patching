/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vehicle;

public interface VehicleService {
    public static final int GET_OIL_LEVEL_AVAILABILITY_ENUM_NORMAL;
    public static final int GET_OIL_LEVEL_AVAILABILITY_ENUM_IGNITION;
    public static final int GET_OIL_LEVEL_AVAILABILITY_ENUM_INIT;
    public static final int GET_OIL_LEVEL_AVAILABILITY_ENUM_ERROR;
    public static final int GET_OIL_LEVEL_AVAILABILITY_ENUM_SYSTEMERROR;
    public static final int GET_OIL_LEVEL_AVAILABILITY_ENUM_NOT_AVAILABLE;
    public static final int GET_OIL_REFILL_UNIT_ENUM_L;
    public static final int GET_OIL_REFILL_UNIT_ENUM_QT;
    public static final int GET_OIL_WARNING_ENUM_MIN;
    public static final int GET_OIL_WARNING_ENUM_UNDERFILL;
    public static final int GET_OIL_WARNING_ENUM_OVERFILL;
    public static final int GET_OIL_WARNING_ENUM_ERROR;
    public static final int GET_OIL_WARNING_ENUM_OK;
    public static final int GET_OIL_WARNING_ENUM_TILT;
    public static final int GET_OIL_WARNING_ENUM_NO_OPERATING_TEMP;
    public static final int GET_OIL_WARNING_ENUM_MOTOR_RUN;
    public static final int GET_OIL_WARNING_ENUM_NOT_AVAILABLE;
    public static final int GET_OIL_WARNING_ENUM_LOW;
    public static final int GET_FUNCTION_INDEX_ENUM_CAR_STATUS_TIRES;
    public static final int GET_FUNCTION_INDEX_ENUM_CAR_STATUS_OILLEVEL;
    public static final int GET_CAR_GEAR_TYPE_MANUAL;
    public static final int GET_CAR_GEAR_TYPE_AUTOMATIC;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_NO_POSITION;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_P;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_R;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_N;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_D;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_S;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_M_TAP;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_M_BRIEF;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_E;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_B;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_MS;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_S_PLUS;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_MS_PLUS;
    public static final int GET_AUTOMATIC_GEAR_TRANSMISSION_MODE_POSITION_OFFROAD;
    public static final int GET_CLUTCH_NOT_CLUTCHED_IN;
    public static final int GET_CLUTCH_CLUTCHED_IN;
    public static final int GET_PARKING_BRAKE_NOT_ENGAGED;
    public static final int GET_PARKING_BRAKE_ENGAGED;

    default public boolean isValetParkingActive() {
    }

    default public boolean isValetParkingAvailable() {
    }

    default public int getOilLevel() {
    }

    default public int getOilLevelAvailability() {
    }

    default public int getOilRefillQuantity() {
    }

    default public int getOilRefillUnit() {
    }

    default public int getOilWarning() {
    }

    default public boolean[] getSystemState() {
    }

    default public int getWarningCount() {
    }

    default public boolean[] getCarStatusTileSFunctionExistence() {
    }

    default public boolean[] getCarStatusTileSFunctionAvailability() {
    }

    default public int getOilLevelAvailabilityReason() {
    }

    default public int getRDKAvailabilityReason() {
    }

    default public int getCarGearType() {
    }

    default public int getAutomaticGearShiftTransMode() {
    }

    default public int getClutchState() {
    }

    default public int getParkingBrakeState() {
    }

    default public void updateInitState(boolean bl) {
    }
}


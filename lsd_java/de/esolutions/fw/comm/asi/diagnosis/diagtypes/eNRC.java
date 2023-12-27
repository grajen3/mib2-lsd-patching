/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eNRC
extends IEnum {
    public static final int NRC_GENERAL_REJECT;
    public static final int NRC_SERVICE_NOT_SUPPORTED;
    public static final int NRC_SUB_FUNCTION_NOT_SUPPORTED;
    public static final int NRC_INCORRECT_MESSAGE_LENGTH_INVALID_FORMAT;
    public static final int NRC_BUSY_REPEAT_REQUEST;
    public static final int NRC_CONDITIONS_NOT_CORRECT;
    public static final int NRC_REQUEST_SEQUENCE_ERROR;
    public static final int NRC_NO_RESPONSE_FROM_SUBNET_COMPONENT;
    public static final int NRC_FAILURE_PREVENTS_EXECUTION_OF_REQUESTED_ACTION;
    public static final int NRC_REQUEST_OUT_OF_RANGE;
    public static final int NRC_SECURITY_ACCESS_DENIED;
    public static final int NRC_INVALID_KEY;
    public static final int NRC_EXCEED_NUMBER_OF_ATTEMPTS;
    public static final int NRC_REQUIRED_TIME_DELAY_NOT_EXPIRED;
    public static final int NRC_UPLOAD_DOWNLOAD_NOT_ACCEPTED;
    public static final int NRC_TRANSFER_DATA_SUSPENDED;
    public static final int NRC_GENERAL_PROGRAMMING_FAILURE;
    public static final int NRC_WRONG_BLOCK_SEQUENCE_COUNTER;
    public static final int NRC_RESPONSE_PENDING;
    public static final int NRC_SUB_FUNCTION_NOT_SUPPORTED_IN_ACTIVE_DIAGNOSTIC_SESSION;
    public static final int NRC_SERVICE_NOT_SUPPORTED_IN_ACTIVE_DIAGNOSTIC_SESSION;
    public static final int NRC_RPM_TOO_HIGH;
    public static final int NRC_RPM_TOO_LOW;
    public static final int NRC_ENGINE_IS_RUNNING;
    public static final int NRC_ENGINE_IS_NOT_RUNNING;
    public static final int NRC_ENGINE_RUN_TIME_TOO_LOW;
    public static final int NRC_TEMPERATURE_TOO_HIGH;
    public static final int NRC_TEMPERATURE_TOO_LOW;
    public static final int NRC_VEHICLE_SPEED_TOO_HIGH;
    public static final int NRC_VEHICLE_SPEED_TOO_LOW;
    public static final int NRC_THROTTLE_PEDAL_TOO_HIGH;
    public static final int NRC_THROTTLE_PEDAL_TOO_LOW;
    public static final int NRC_TRANSMISSION_RANGE_NOT_IN_NEUTRAL;
    public static final int NRC_TRANSMISSION_RANGE_NOT_IN_GEAR;
    public static final int NRC_BRAKE_SWITCH_NOT_CLOSED;
    public static final int NRC_SHIFTER_LEVER_NOT_IN_PARK;
    public static final int NRC_TORQUE_CONVERTER_CLUTCH_LOCKED;
    public static final int NRC_VOLTAGE_TOO_HIGH;
    public static final int NRC_VOLTAGE_TOO_LOW;
}


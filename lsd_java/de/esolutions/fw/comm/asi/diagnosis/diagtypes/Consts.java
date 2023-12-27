/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class Consts {
    public static final long DTC_SYS_FLASH_MEMORY_ERR;
    public static final long DTC_SYS_OPTICAL_DRIVE_INIT_ERR;
    public static final long DTC_SYS_OPTICAL_DRIVE_MECH_ERR;
    public static final long DTC_SYS_SANITY_CHECK_LANGUAGES;
    public static final long DTC_SYS_SANITY_CHECK_VISIBLE_LANGUAGES;
    public static final long DTC_TEL_TELEPHONE_ANTENNA_1_SHORT_CIRCUIT_TO_GROUND;
    public static final long DTC_TEL_TELEPHONE_ANTENNA_1_OPEN_LOAD;
    public static final long DTC_TEL_TELEPHONE_ANTENNA_1_SHORT_CIRCUIT_TO_BATTERY;
    public static final long DTC_TEL_TELEPHONE_ANTENNA_2_SHORT_CIRCUIT_TO_GROUND;
    public static final long DTC_TEL_TELEPHONE_ANTENNA_2_OPEN_LOAD;
    public static final long DTC_TEL_TELEPHONE_ANTENNA_2_SHORT_CIRCUIT_TO_BATTERY;
    public static final long DTC_TEL_NAD_OVERTEMP;
    public static final long DTC_TEL_NAD_UNDERTEMP;
    public static final long DTC_NAV_DATABASE_HAS_ERRORS;
    public static final long DTC_NAV_DATABASE_NOT_AVAILABLE;
    public static final long DTC_NAV_DATABASE_NOT_ACTIVATED;
    public static final long DTC_OOC_MMX_OVERTEMP;
    public static final long DTC_DISPMGR_RVC_NO_SIGNAL;
    public static final long DTC_MEDIA_USB_COMMUNICATION_ERROR;
    public static final long DTC_MEDIA_DTCP_SIGNATURECHECK_MMX;
    public static final long DTC_MEDIA_DTCP_AUTHENTICATIONERROR_SIGNATURE_SDIS;
    public static final long DTC_MEDIA_DTCP_AUTHENTICATIONERROR_CERTIFICATE_SDIS;
    public static final long DTC_SYS_USB_PORT1_NO_CONNECTION;
    public static final long DTC_SYS_USB_PORT1_SHORTCUT_GROUND;
    public static final long DTC_SYS_USB_PORT2_NO_CONNECTION;
    public static final long DTC_SYS_USB_PORT2_SHORTCUT_GROUND;
    public static final long DTC_SYS_USB_PORT3_NO_CONNECTION;
    public static final long DTC_SYS_USB_PORT3_SHORTCUT_GROUND;
    public static final long DTC_SYS_USB_PORT4_NO_CONNECTION;
    public static final long DTC_SYS_USB_PORT4_SHORTCUT_GROUND;
    public static final long DTC_SYS_USB_NO_CONNECTION;
    public static final long DTC_DUMMY;
    public static final short IO_CONTROL_PARAM_RETURN_CONTROL_TO_ECU;
    public static final short IO_CONTROL_PARAM_SHORT_TERM_ADJUSTMENT;
    public static final short CONTROL_STATE_NO_TEST;
    public static final short CONTROL_STATE_INFINITE_TIMING;
    public static final int DIAG_APP_TELEPHONE;
    public static final int DIAG_APP_BLUETOOTH;
    public static final int DIAG_APP_WLAN;
    public static final int DIAG_APP_MEDIA;
    public static final int DIAG_APP_NAVIGATION;
    public static final int DIAG_APP_SPEECH;
    public static final int DIAG_APP_OOC;
    public static final int DIAG_APP_DISPLAY_MANAGER;
    public static final int DIAG_APP_SWDL;
    public static final int DIAG_APP_OLS;
    public static final int DIAG_APP_HMI;
    public static final int DIAG_APP_SSE;
    public static final int DIAG_APP_MULTIPLE_CLIENTS;
    public static final int TEST_PASSED;
    public static final int TEST_FAILED;
    public static final int REG_OK;
    public static final int REG_CLIENT_ALREADY_REGISTERED;
    public static final int REG_CLIENT_ID_ALREADY_REGISTERED;
    public static final int REG_ERROR;
    public static final int ERR_RESPONSE_ERROR_UNKNOWN;
    public static final int ERR_ROUTINE_REQUEST_SEQUENCE_ERROR;
    public static final int ERR_ROUTINE_ACTION_NOT_SUPPORTED;
    public static final int ERR_REQUEST_OUT_OF_RANGE;
    public static final int STATUSCODING_ERROR;
    public static final int STATUSCODING_OK;
    public static final int STATUSCODING_DONT_CARE;
    public static final int UDS_SESSION_CONTROL;
    public static final int UDS_ECU_RESET;
    public static final int UDS_CLEAR_DTC_INFORMATION;
    public static final int UDS_READ_DTC_INFORMATION;
    public static final int UDS_READ_DATA_BY_IDENTIFIER;
    public static final int UDS_READ_MEMORY_BY_ADRESS;
    public static final int UDS_SECURITY_ACCESS;
    public static final int UDS_COMMUNICATION_CONTROL;
    public static final int UDS_WRITE_DATA_BY_IDENTIFIER;
    public static final int UDS_IO_CONTROL_BY_IDENTIFIER;
    public static final int UDS_ROUTINE_CONTROL;
    public static final int UDS_REQUEST_DOWNLOAD;
    public static final int UDS_REQUEST_UPLOAD;
    public static final int UDS_TRANSFER_DATA;
    public static final int UDS_TRANSFER_DATA_EXIT;
    public static final int UDS_WRITE_MEMORY_BY_ADRESS;
    public static final int UDS_TESTER_PRESENT;
    public static final int UDS_CONTROL_DTC_SETTINGS;
    public static final int UDS_RESPONSE_ON_EVENT;
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
    public static final int ROUTINE_START;
    public static final int ROUTINE_STOP;
    public static final int ROUTINE_RESULTS;
    public static final int ROUTINE_ACTIVE;
    public static final int ROUTINE_NOT_ACTIVE;
    public static final int ROUTINE_ABORTED;
    public static final int ROUTINE_STATUS_DUMMY;
    public static final int ROUTINE_INCORRECT_RESULT;
    public static final int ROUTINE_NO_RESULTS_AVAILABLE;
    public static final int ROUTINE_CORRECT_RESULTS;
    public static final int ROUTINE_RESULTS_DUMMY;
    public static final int SUBSYSTEM_NOT_DETECTED;
    public static final int SUBSYSTEM_DETECTED;
    public static final int SUBSYSTEM_NOT_BUILD_IN;
}


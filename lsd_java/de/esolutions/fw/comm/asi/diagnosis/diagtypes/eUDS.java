/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

import de.esolutions.fw.comm.core.IEnum;

public interface eUDS
extends IEnum {
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
}


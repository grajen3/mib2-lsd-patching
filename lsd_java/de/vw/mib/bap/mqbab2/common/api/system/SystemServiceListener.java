/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.system;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;

public interface SystemServiceListener
extends HMIEventListener {
    public static final int SYSTEM_SERVICE__CURRENT_DISTANCE_UNIT;
    public static final int SYSTEM_SERVICE__ON_OFF_STATE;
    public static final int SYSTEM_SERVICE__DAY_NIGHT_MODE;
    public static final int SYSTEM_SERVICE__TIME_FORMAT;
    public static final int SYSTEM_SERVICE__NAVIGATION_DOMAIN_AVAILABILITY;
    public static final int SYSTEM_SERVICE__PHONE_DOMAIN_AVAILABILITY;
    public static final int SYSTEM_SERVICE__ADDRESSBOOK_DOMAIN_AVAILABILITY;
    public static final int SYSTEM_SERVICE__SPEECH_DOMAIN_AVAILABLE;
    public static final int SYSTEM_SERVICE__DAB_AVAILABILITY;
    public static final int SYSTEM_SERVICE__AM_AVAILABLE;
    public static final int SYSTEM_SERVICE__CURRENT_MAIN_CONTEXT;
    public static final int SYSTEM_SERVICE__COMPONENT_PROTECTION_ACTIVE;
    public static final int SYSTEM_SERVICE__ARABIC_VARIANT_ACTIVE;
    public static final int SYSTEM_SERVICE__HMI_EVENT__CD_DVD_READ_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__CD_TEMPERATURE_WARNING;
    public static final int SYSTEM_SERVICE__HMI_EVENT__CD_DVD_DEVICE_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__CD_DVD_LOADING;
    public static final int SYSTEM_SERVICE__HMI_EVENT__CD_DVD_LOADING_FINISHED;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD1_DEVICE_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD1_LOADING;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD1_LOADING_FINISHED;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD1_READ_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD2_DEVICE_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD2_LOADING;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD2_LOADING_FINISHED;
    public static final int SYSTEM_SERVICE__HMI_EVENT__SD2_READ_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB_READ_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB_LOADING;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB_LOADING_FINISHED;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB_DEVICE_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB2_READ_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB2_LOADING;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB2_LOADING_FINISHED;
    public static final int SYSTEM_SERVICE__HMI_EVENT__USB2_DEVICE_ERROR;
    public static final int SYSTEM_SERVICE__HMI_EVENT__CD_DVD_EJECTED;
    public static final int SYSTEM_SERVICE__HMI_EVENT__START_DIAGNOSE;
    public static final int SYSTEM_SERVICE__HMI_EVENT__END_DIAGNOSE;

    default public void updateSystemData(SystemService systemService, int n) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.powermanagement;

import org.dsi.ifc.base.DSIBase;

public interface DSIPowerManagement
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_POWERMANAGEMENTSTATE;
    public static final int ATTR_POWERMANAGEMENTSTATERIGHT;
    public static final int ATTR_BEMSTATE;
    public static final int ATTR_CLAMPSIGNAL;
    public static final int ATTR_CHILDLOCKSTATE;
    public static final int ATTR_LASTON;
    public static final int ATTR_RVCACTIVE;
    public static final int ATTR_TELMAXPOPUP;
    public static final int ATTR_SPLASHSCREENANIMATION;
    public static final int ATTR_TSTANDBYPOPUP;
    public static final int POWERSTATE_OFF;
    public static final int POWERSTATE_ON;
    public static final int POWERSTATE_STANDBY;
    public static final int POWERSTATE_CRIT_TEMPR;
    public static final int POWERSTATE_STANDBY_RESTRICTED;
    public static final int POWERSTATE_ON_DIAG;
    public static final int POWERSTATE_CUSTOMER_SWDL;
    public static final int POWERSTATE_ON_TEL;
    public static final int POWERSTATE_ON_SWDL;
    public static final int POWERSTATE_STANDBY_PWR_SAVE;
    public static final int POWERSTATE_ON_DELAY;
    public static final int BEMSTATE_0;
    public static final int BEMSTATE_1;
    public static final int BEMSTATE_2;
    public static final int BEMSTATE_3;
    public static final int BEMSTATE_4;
    public static final int BEMSTATE_7;
    public static final int BEMSTATE_21;
    public static final int CHILDLOCK_DISABLED;
    public static final int CHILDLOCK_ENABLED;
    public static final int LASTON_MMI_STANDBY;
    public static final int LASTON_MMI_ON;
    public static final int LASTON_MMI_ON_NO_DISPLAY;
    public static final int LASTON_MMI_IOC;
    public static final int POWEREVENT_CLAMP_S_ON;
    public static final int POWEREVENT_CLAMP_S_OFF;
    public static final int POWEREVENT_CLAMP_15_ON;
    public static final int POWEREVENT_CLAMP_15_OFF;
    public static final int POWEREVENT_HK_DISPLAY;
    public static final int POWEREVENT_HK;
    public static final int POWEREVENT_ONOFF;
    public static final int POWEREVENT_OTHER;
    public static final int POWEREVENT_HK_RADIO;
    public static final int POWEREVENT_HK_MEDIA;
    public static final int POWEREVENT_HK_TEL;
    public static final int POWEREVENT_HK_NAV;
    public static final int POWEREVENT_HK_MENU;
    public static final int POWEREVENT_HK_CAR;
    public static final int POWEREVENT_HK_TONE;
    public static final int POWEREVENT_HK_MAP;
    public static final int POWEREVENT_HK_SOURCE;
    public static final int DEVICETYPE_POWERMANAGEMENT;
    public static final int ANIMATIONSTATUS_OFF;
    public static final int ANIMATIONSTATUS_RUNNING;
    public static final int ANIMATIONSTATUS_END;
    public static final int RT_SETHMIREADY;
    public static final int RT_REBOOTSYSTEM;
    public static final int RT_DISPLAYREADY;
    public static final int RT_REBOOTSYSTEMCRITICAL;
    public static final int RT_SETCHILDLOCKRSE;
    public static final int RT_SETLASTON;

    default public void setHMIReady() {
    }

    default public void rebootSystem() {
    }

    default public void displayReady() {
    }

    default public void rebootSystemCritical() {
    }

    default public void setChildLockRSE(int n) {
    }

    default public void setLastOn(int n) {
    }
}


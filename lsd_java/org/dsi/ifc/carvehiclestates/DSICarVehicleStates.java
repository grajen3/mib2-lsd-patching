/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.base.DSIBase;

public interface DSICarVehicleStates
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_OILLEVELVIEWOPTION;
    public static final int ATTR_OILLEVELDATA;
    public static final int ATTR_VINVIEWOPTION;
    public static final int ATTR_VINDATA;
    public static final int ATTR_KEYVIEWOPTION;
    public static final int ATTR_KEYDATA;
    public static final int ATTR_DRVSCHOOLSYSTEM;
    public static final int ATTR_VEHICLEINFOVIEWOPTIONS;
    public static final int ATTR_DYNAMICVEHICLEINFOHIGHFREQUENTVIEWOPTIONS;
    public static final int ATTR_DYNAMICVEHICLEINFOMIDFREQUENTVIEWOPTIONS;
    public static final int ATTR_DYNAMICVEHICLEINFOHIGHFREQUENT;
    public static final int ATTR_DYNAMICVEHICLEINFOMIDFREQUENT;
    public static final int ATTR_SEMISTATICVEHICLEDATAVIEWOPTIONS;
    public static final int ATTR_SEMISTATICVEHICLEDATA;
    public static final int ATTR_DYNAMICVEHICLEINFOSCR;
    public static final int RT_SETCARMENUSTATE;
    public static final int OILLEVELWARNINGS_MIN;
    public static final int OILLEVELWARNINGS_UNDERFILL;
    public static final int OILLEVELWARNINGS_OVERFILL;
    public static final int OILLEVELWARNINGS_SENSORERROR;
    public static final int OILLEVELWARNINGS_OILOK;
    public static final int OILLEVELWARNINGS_CHECKOIL;
    public static final int OILLEVELWARNINGS_TILT;
    public static final int OILLEVELWARNINGS_NOTUNDERHOTRUNNINGCONDITIONS;
    public static final int OILLEVELWARNINGS_RUNNINGENGINE;
    public static final int OILLEVELWARNINGS_NOTDEFINED;
    public static final int OILLEVELWARNINGS_OILLEVELNOTAVAILABLE;
    public static final int OILLEVELWARNINGS_SYSTEMERROR;
    public static final int SCRSTATE_INIT;
    public static final int SCRSTATE_NORMAL;
    public static final int SCRSTATE_WARNING1;
    public static final int SCRSTATE_WARNING2;
    public static final int SCRSTATE_SYSTEMERROR;
    public static final int SCRSTATE_TILT;
    public static final int SCRSTATE_FROZENMEDIUM;
    public static final int SCRSTATE_WARNING3;
    public static final int BLINKINGSTATE_NOBLINKING;
    public static final int BLINKINGSTATE_LEFTBLINKING;
    public static final int BLINKINGSTATE_RIGHTBLINKING;
    public static final int BLINKINGSTATE_LEFTRIGHTBLINKING;
    public static final int GEARUNIT_NO_GEAR;
    public static final int GEARUNIT_NO_RECOMMENDATION;
    public static final int GEARUNIT_GEAR1;
    public static final int GEARUNIT_GEAR2;
    public static final int GEARUNIT_GEAR3;
    public static final int GEARUNIT_GEAR4;
    public static final int GEARUNIT_GEAR5;
    public static final int GEARUNIT_GEAR6;
    public static final int GEARUNIT_GEAR7;
    public static final int GEARUNIT_GEAR8;
    public static final int GEARUNIT_GEAR9;
    public static final int GEARUNIT_GEAR10;
    public static final int CLUTCH_NOT_CLUTCHED_IN;
    public static final int CLUTCH_CLUTCHED_IN;
    public static final int GEARTRANSMISSIONMODE_NO_POSITION;
    public static final int GEARTRANSMISSIONMODE_POSITION_P;
    public static final int GEARTRANSMISSIONMODE_POSITION_R;
    public static final int GEARTRANSMISSIONMODE_POSITION_N;
    public static final int GEARTRANSMISSIONMODE_POSITION_D;
    public static final int GEARTRANSMISSIONMODE_POSITION_S;
    public static final int GEARTRANSMISSIONMODE_POSITION_M_TAP;
    public static final int GEARTRANSMISSIONMODE_POSITION_M_BRIEF;
    public static final int GEARTRANSMISSIONMODE_POSITION_E;
    public static final int GEARTRANSMISSIONMODE_POSITION_B;
    public static final int GEARTRANSMISSIONMODE_POSITION_MS;
    public static final int GEARTRANSMISSIONMODE_POSITION_S_PLUS;
    public static final int GEARTRANSMISSIONMODE_POSITION_MS_PLUS;
    public static final int GEARTRANSMISSIONMODE_POSITION_OFFROAD;
    public static final int RECUPLEVEL_NO_PRESENTATION;
    public static final int RECUPLEVEL_LEVEL_1;
    public static final int RECUPLEVEL_LEVEL_2;
    public static final int RECUPLEVEL_LEVEL_3;
    public static final int RECUPLEVEL_LEVEL_4;
    public static final int RECUPLEVEL_LEVEL_5;
    public static final int HDCCOLOR_STANDARD;
    public static final int HDCCOLOR_ALTERNATIVE;
    public static final int EDSDISPLAY_NODISPLAY;
    public static final int EDSDISPLAY_EDSNOTACTIVE;
    public static final int EDSDISPLAY_EDSACTIVEFRONTAXLE;
    public static final int EDSDISPLAY_EDSACTIVEREARAXLE;
    public static final int EDSDISPLAY_EDSACTIVEFRONTREARAXLE;
    public static final int EDSDISPLAY_EDSOVERTEMP;
    public static final int EDSDISPLAY_EDSERROR;
    public static final int SERVICEKEYID_UNKNOWN;
    public static final int SERVICEKEYID_SK1;
    public static final int SERVICEKEYID_SK1A;
    public static final int SERVICEKEYID_SK2;
    public static final int SERVICEKEYID_SK3;
    public static final int INJECTIONSYSTEM_TURBO;
    public static final int INJECTIONSYSTEM_ASPIRATION;

    default public void setCarMenuState(boolean bl) {
    }
}


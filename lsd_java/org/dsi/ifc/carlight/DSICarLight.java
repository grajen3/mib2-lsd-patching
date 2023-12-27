/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public interface DSICarLight
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_INTLIGHTVIEWOPTIONS;
    public static final int ATTR_INTLIGHTCOLOUR;
    public static final int ATTR_INTLIGHTSTATE;
    public static final int ATTR_INTLIGHTENVIRONMENT;
    public static final int ATTR_INTLIGHTSPEED;
    public static final int ATTR_INTLIGHTTEMPERATURE;
    public static final int ATTR_INTLIGHTBRIGHTNESS;
    public static final int ATTR_INTLIGHTILLUMINATIONSET1;
    public static final int ATTR_INTLIGHTILLUMINATIONSET2;
    public static final int ATTR_INTLIGHTILLUMINATIONSET3;
    public static final int ATTR_INTLIGHTILLUMINATIONSET4;
    public static final int ATTR_INTLIGHTILLUMINATIONSET5;
    public static final int ATTR_INTLIGHTILLUMINATIONSET6;
    public static final int ATTR_INTLIGHTILLUMINATIONSET7;
    public static final int ATTR_INTLIGHTILLUMINATIONSET8;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE1;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE2;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE3;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE4;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE5;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE6;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE7;
    public static final int ATTR_INTLIGHTILLUMINATIONPROFILE8;
    public static final int ATTR_INTLIGHTACTIVEPROFILE;
    public static final int ATTR_INTLIGHTAMBIENTLIGHTCOLOR;
    public static final int ATTR_INTLIGHTCONTOURLIGHTCOLOR;
    public static final int ATTR_INTLIGHTFOLLOWUPTIME;
    public static final int ATTR_INTLIGHTRGBCOLORLISTUPDATEINFO;
    public static final int ATTR_INTLIGHTRGBCOLORLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_INTLIGHTDOORCONTACT;
    public static final int ATTR_EXTLIGHTVIEWOPTIONS;
    public static final int ATTR_EXTLIGHTCOMINGHOME;
    public static final int ATTR_EXTLIGHTLEAVINGHOME;
    public static final int ATTR_EXTLIGHTSWITCHONSENSITIVITY;
    public static final int ATTR_EXTLIGHTDAYLIGHT;
    public static final int ATTR_EXTLIGHTTOURIST;
    public static final int ATTR_EXTLIGHTADAPTIVE;
    public static final int ATTR_EXTLIGHTHEADLIGHTSYSTEM;
    public static final int ATTR_EXTLIGHTGLIDINGSYSTEM;
    public static final int ATTR_EXTLIGHTMOTORWAYBLINKING;
    public static final int ATTR_EXTLIGHTMASKEDHIGHBEAM;
    public static final int ATTR_EXTLIGHTLAMPERRORDETECTION;
    public static final int ATTR_EXTLIGHTLAMPERRORDETECTIONTRAILER;
    public static final int ATTR_EXTLIGHTSENSORERRORDETECTION;
    public static final int ATTR_EXTLIGHTLASERLIGHT;
    public static final int ATTR_EXTLIGHTAUTOMATICLIGHT;
    public static final int ATTR_EXTLIGHTSIGNATURELIGHT;
    public static final int ATTR_EXTLIGHTHEADLIGHTRANGE;
    public static final int SETUPILLUMINATIONSET_NOT_EXISTING;
    public static final int SETUPILLUMINATIONSET_ROOF_FRONT;
    public static final int SETUPILLUMINATIONSET_ROOF_REAR;
    public static final int SETUPILLUMINATIONSET_FOOTWELL_FRONT;
    public static final int SETUPILLUMINATIONSET_FOOTWELL_REAR;
    public static final int SETUPILLUMINATIONSET_FOOTWELL_FRONTREAR;
    public static final int SETUPILLUMINATIONSET_COCKPIT;
    public static final int SETUPILLUMINATIONSET_DOORS_FRONTREAR;
    public static final int SETUPILLUMINATIONSET_DOORS_FOOTWELLFRONT;
    public static final int SETUPILLUMINATIONSET_NOT_DOORS_FOOTWELLREAR;
    public static final int SETUPILLUMINATIONSET_ALLSETSSYNC;
    public static final int SETUPILLUMINATIONSET_STANDARDSET;
    public static final int SETUPILLUMINATIONSET_SUNROOF;
    public static final int SETUPILLUMINATIONSET_CONTOUR;
    public static final int SETUPILLUMINATIONSET_ROOFFRONTREAR;
    public static final int SETUPILLUMINATIONSET_CENTERCONSOLE;
    public static final int SETUPILLUMINATIONSET_REAR;
    public static final int SETUPILLUMINATIONSET_SURFACE;
    public static final int SETUPILLUMINATIONSET_LINE;
    public static final int COLOUR_WARMWHITE;
    public static final int COLOUR_COLDWHITE;
    public static final int COLOUR_REDWHITE;
    public static final int COLOUR_ORANGE;
    public static final int COLOUR_BLUE;
    public static final int COLOUR_CYAN;
    public static final int LIGHTSTATE_OFF;
    public static final int LIGHTSTATE_NORMAL;
    public static final int LIGHTSTATE_AUTO;
    public static final int LIGHTSTATE_PRIVACY;
    public static final int SETUPILLUMINATIONPROFILE_NOT_EXISTING;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE1;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE2;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE3;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE4;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE5;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE6;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE7;
    public static final int SETUPILLUMINATIONPROFILE_PROFILE8;
    public static final int INTLIGHTARRAYCONTENT_INIT;
    public static final int INTLIGHTARRAYCONTENT_ALL;
    public static final int INTLIGHTARRAYCONTENT_ALL_FORWARD;
    public static final int INTLIGHTARRAYCONTENT_ALL_BACKWARD;
    public static final int INTLIGHTARRAYCONTENT_ONLY_CHANGES;
    public static final int INTLIGHTARRAYCONTENT_ELEMENTS_REMOVED;
    public static final int INTLIGHTARRAYCONTENT_BLOCK_INSERTED;
    public static final int INTLIGHTRECORDCONTENT_RA0;
    public static final int INTLIGHTRECORDCONTENT_RAF;
    public static final int SWITCHONSENSITIVITY_SENSITIVE;
    public static final int SWITCHONSENSITIVITY_NORMAL;
    public static final int SWITCHONSENSITIVITY_INSENSITIVE;
    public static final int MOTORWAYBLINKINGTIMES_2TIMES;
    public static final int MOTORWAYBLINKINGTIMES_3TIMES;
    public static final int MOTORWAYBLINKINGTIMES_4TIMES;
    public static final int MOTORWAYBLINKINGTIMES_5TIMES;
    public static final int LAMPSTATE_OK;
    public static final int LAMPSTATE_DEFECT;
    public static final int SENSORSTATE_OK;
    public static final int SENSORSTATE_BLOCKED;
    public static final int SENSORSTATE_DEFECT;
    public static final int EXTLIGHTLAMPS_UNKNOWN;
    public static final int EXTLIGHTLAMPS_BLINKER_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_HEADLIGHT_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_HIGH_HEADLIGHT_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_ADDON_HIGH_HEADLIGHT_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_SIDE_BLINKER_LEFT;
    public static final int EXTLIGHTLAMPS_TURN_OFF_LIGHT_LEFT;
    public static final int EXTLIGHTLAMPS_BLINKER_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_HEADLIGHT_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_HIGH_HEADLIGHT_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_ADDON_HIGH_HEADLIGHT_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_SIDE_BLINKER_RIGHT;
    public static final int EXTLIGHTLAMPS_TURN_OFF_LIGHT_RIGHT;
    public static final int EXTLIGHTLAMPS_BLINKER_REAR_LEFT;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_REAR_LEFT;
    public static final int EXTLIGHTLAMPS_BRAKELIGHT_REAR_LEFT;
    public static final int EXTLIGHTLAMPS_BACKUP_LIGHT_REAR_LEFT;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_REAR_LEFT;
    public static final int EXTLIGHTLAMPS_3RD_BRAKELIGHT;
    public static final int EXTLIGHTLAMPS_NUMBERBLADELIGHT;
    public static final int EXTLIGHTLAMPS_BLINKER_REAR_RIGHT;
    public static final int EXTLIGHTLAMPS_PARKLIGHT_REAR_RIGHT;
    public static final int EXTLIGHTLAMPS_BRAKELIGHT_REAR_RIGHT;
    public static final int EXTLIGHTLAMPS_BACKUP_LIGHT_REAR_RIGHT;
    public static final int EXTLIGHTLAMPS_FOGLIGHT_REAR_RIGHT;
    public static final int EXTLIGHTLAMPS_REVERSELIGHT_REAR;
    public static final int EXTLIGHTLAMPS_DAYTIME_RUNNINGLIGHT_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_DAYTIME_RUNNINGLIGHT_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_BLINKER_MIRROR_LEFT;
    public static final int EXTLIGHTLAMPS_BLINKER_MIRROR_RIGHT;
    public static final int EXTLIGHTLAMPS_SIDEMARKER_FRONT_LEFT;
    public static final int EXTLIGHTLAMPS_SIDEMARKER_FRONT_RIGHT;
    public static final int EXTLIGHTLAMPS_DAYTIME_RUNNING_LIGHT;
    public static final int EXTLIGHTLAMPS_FLA_INTERIOR_MIRROR_DEFECTIVE;
    public static final int EXTLIGHTLAMPS_FLA_SENSOR_BLOCKED;
    public static final int EXTLIGHTLAMPSTRAILER_UNKNOWN;
    public static final int EXTLIGHTLAMPSTRAILER_BLINKER_LEFT;
    public static final int EXTLIGHTLAMPSTRAILER_REARLIGHT_LEFT;
    public static final int EXTLIGHTLAMPSTRAILER_BRAKELIGHT;
    public static final int EXTLIGHTLAMPSTRAILER_FOGLIGHT;
    public static final int EXTLIGHTLAMPSTRAILER_BLINKER_RIGHT;
    public static final int EXTLIGHTLAMPSTRAILER_REARLIGHT_RIGHT;
    public static final int EXTLIGHTLAMPSTRAILER_BACKUP_LIGHT;
    public static final int SENSORS_UNKNOWN;
    public static final int SENSORS_FLA;
    public static final int RT_SETEXTLIGHTCOMINGHOME;
    public static final int RT_SETEXTLIGHTLEAVINGHOME;
    public static final int RT_SETEXTLIGHTSWITCHONSENSITIVITY;
    public static final int RT_SETEXTLIGHTDAYLIGHT;
    public static final int RT_SETEXTLIGHTHEADLIGHTSYSTEM;
    public static final int RT_SETEXTLIGHTGLIDINGLIGHTSYSTEM;
    public static final int RT_SETEXTLIGHTADAPTIVE;
    public static final int RT_SETEXTLIGHTTOURIST;
    public static final int RT_SETEXTLIGHTMOTORWAYBLINKING;
    public static final int RT_SETEXTLIGHTMASKEDHIGHBEAM;
    public static final int RT_SETEXTLIGHTAUTOMATICLIGHT;
    public static final int RT_SETEXTLIGHTLASERLIGHT;
    public static final int RT_SETEXTLIGHTSIGNATURELIGHT;
    public static final int RT_SETEXTLIGHTHEADLIGHTRANGE;
    public static final int RT_SETEXTLIGHTSETFACTORYDEFAULT;
    public static final int RT_SETINTLIGHTCOLOUR;
    public static final int RT_SETINTLIGHTSTATE;
    public static final int RT_SETINTLIGHTENVIRONMENT;
    public static final int RT_SETINTLIGHTSPEED;
    public static final int RT_SETINTLIGHTTEMPERATURE;
    public static final int RT_SETINTLIGHTBRIGHTNESS;
    public static final int RT_SETINTLIGHTSETFACTORYDEFAULT;
    public static final int RT_SETINTLIGHTILLUMINATIONSET;
    public static final int RT_SETINTLIGHTILLUMINATIONPROFILE;
    public static final int RT_SETINTLIGHTACTIVEPROFILE;
    public static final int RT_SETINTLIGHTAMBIENTLIGHTCOLOR;
    public static final int RT_SETINTLIGHTCONTOURLIGHTCOLOR;
    public static final int RT_SETINTLIGHTFOLLOWUPTIME;
    public static final int RT_REQUESTINTLIGHTRGBCOLORLIST;
    public static final int RT_SETINTLIGHTDOORCONTACT;
    public static final int RP_ACKNOWLEDGEINTLIGHTSETFACTORYDEFAULT;
    public static final int RP_RESPONSEINTLIGHTRGBCOLORLISTRA0;
    public static final int RP_RESPONSEINTLIGHTRGBCOLORLISTRAF;
    public static final int RP_ACKNOWLEDGEEXTLIGHTSETFACTORYDEFAULT;

    default public void setExtLightComingHome(TimeState timeState) {
    }

    default public void setExtLightLeavingHome(TimeState timeState) {
    }

    default public void setExtLightSwitchOnSensitivity(int n) {
    }

    default public void setExtLightDayLight(boolean bl) {
    }

    default public void setExtLightHeadLightSystem(boolean bl) {
    }

    default public void setExtLightGlidingLightSystem(boolean bl) {
    }

    default public void setExtLightAdaptive(boolean bl) {
    }

    default public void setExtLightTourist(boolean bl) {
    }

    default public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
    }

    default public void setExtLightMaskedHighBeam(boolean bl) {
    }

    default public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
    }

    default public void setExtLightSetFactoryDefault() {
    }

    default public void setExtLightLaserLight(boolean bl) {
    }

    default public void setExtLightSignatureLight(boolean bl) {
    }

    default public void setExtLightHeadlightRange(int n) {
    }

    default public void setIntLightIlluminationSet(int n, int n2) {
    }

    default public void setIntLightColour(int n) {
    }

    default public void setIntLightState(int n) {
    }

    default public void setIntLightEnvironment(boolean bl) {
    }

    default public void setIntLightSpeed(boolean bl) {
    }

    default public void setIntLightTemperature(boolean bl) {
    }

    default public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
    }

    default public void setIntLightSetFactoryDefault() {
    }

    default public void setIntLightIlluminationProfile(int n, int n2) {
    }

    default public void setIntLightActiveProfile(int n) {
    }

    default public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
    }

    default public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
    }

    default public void setIntLightFollowUpTime(int n) {
    }

    default public void setIntLightDoorContact(boolean bl) {
    }

    default public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
    }
}


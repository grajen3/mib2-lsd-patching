/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public interface DSICarComfort
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_RGSVIEWOPTIONS;
    public static final int ATTR_RGSBELTPRETENSIONDATAFRONT;
    public static final int ATTR_RGSBELTPRETENSIONDATAREAR;
    public static final int ATTR_RGSPRECRASHSYSTEM;
    public static final int ATTR_RGSPRESENSESYSTEM;
    public static final int ATTR_RGSPRESENSEWARNING;
    public static final int ATTR_RGSLOCALHAZARDDETECTION;
    public static final int ATTR_DOORLOCKINGVIEWOPTIONS;
    public static final int ATTR_DOORLOCKINGMESSAGE;
    public static final int ATTR_DOORLOCKINGLOCKSTATUS;
    public static final int ATTR_DOORLOCKINGWINDOWSTATUS;
    public static final int ATTR_DOORLOCKINGCOMFORTOPENSETTINGS;
    public static final int ATTR_DOORLOCKINGCLBOOTOPEN;
    public static final int ATTR_DOORLOCKINGBOOTOPEN;
    public static final int ATTR_DOORLOCKINGTHEFTWARNINGSETTINGS;
    public static final int ATTR_DOORLOCKINGUNLOCKINGMODE;
    public static final int ATTR_DOORLOCKINGAUTOLOCK;
    public static final int ATTR_DOORLOCKINGAUTOUNLOCK;
    public static final int ATTR_DOORLOCKINGCLBOOTLOCK;
    public static final int ATTR_DOORLOCKINGMIRRORPROTECTION;
    public static final int ATTR_DOORLOCKINGCONFIRMATION;
    public static final int ATTR_DOORLOCKINGRAINCLOSING;
    public static final int ATTR_DOORLOCKINGREARBLIND;
    public static final int ATTR_DOORLOCKINGBOOTCLOSE;
    public static final int ATTR_DOORLOCKINGUSERLISTUPDATEINFO;
    public static final int ATTR_DOORLOCKINGUSERLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_DOORLOCKINGACTIVEUSER;
    public static final int ATTR_DOORLOCKINGUSERPROFILEONOFF;
    public static final int ATTR_DOORLOCKINGWINDOWAUTOCLOSE;
    public static final int ATTR_DOORLOCKINGBLINDSCONTROL;
    public static final int ATTR_DOORLOCKINGBLINDSCONTROLEXTENDED;
    public static final int ATTR_DOORLOCKINGLEFTSIDEBLINDCONTROL;
    public static final int ATTR_DOORLOCKINGRIGHTSIDEBLINDCONTROL;
    public static final int ATTR_DOORLOCKINGUSERPROFILECONTROLPROCESSING;
    public static final int ATTR_DOORLOCKINGPROMPTCONTENT;
    public static final int ATTR_DOORLOCKINGTURNINDREPEAT;
    public static final int ATTR_DOORLOCKINGKEYLESS;
    public static final int ATTR_WIPERVIEWOPTIONS;
    public static final int ATTR_WIPERSERVICEPOSITION;
    public static final int ATTR_WIPERRAINSENSORONOFF;
    public static final int ATTR_WIPERRAINSENSORCONFIG;
    public static final int ATTR_WIPERREARWIPING;
    public static final int ATTR_WIPERTEARSWIPING;
    public static final int ATTR_WIPERWINTERPOSITION;
    public static final int ATTR_EASYENTRYSTEERINGCOLUMN;
    public static final int ATTR_UGDOVIEWOPTIONS;
    public static final int ATTR_UGDOLEARNINGDATA;
    public static final int ATTR_UGDOCONTENT;
    public static final int ATTR_UGDOVERSIONDATA;
    public static final int ATTR_UGDOBUTTONLISTUPDATEINFO;
    public static final int ATTR_UGDOBUTTONLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_UGDODESTINATIONREACHED;
    public static final int ATTR_UGDOOPENDOOR;
    public static final int ATTR_RDKVIEWOPTIONS;
    public static final int ATTR_RDKSYSTEMONOFF;
    public static final int ATTR_RDKTIRESETUPTIRELIST;
    public static final int ATTR_RDKTIRESETUPSELECTEDTIRE;
    public static final int ATTR_RDKTIREDISPLAY;
    public static final int ATTR_RDKSPEEDLIMIT;
    public static final int ATTR_RDKDIFFERENTIALPRESSURE;
    public static final int ATTR_RDKRESIDUALBATTERYLIFETIME;
    public static final int ATTR_RDKPRESSURELEVEL;
    public static final int ATTR_MIRRORVIEWOPTIONS;
    public static final int ATTR_MIRRORLOWERING;
    public static final int ATTR_MIRRORSYNCADJUST;
    public static final int ATTR_MIRRORFOLDING;
    public static final int ATTR_MIRRORDIMMING;
    public static final int ATTR_MIRRORHEATING;
    public static final int ATTR_BRAKEVIEWOPTIONS;
    public static final int ATTR_BRAKEELECTRICALPARKING;
    public static final int ATTR_BRAKEAUTOHOLD;
    public static final int ATTR_BRAKEESCMODE;
    public static final int ATTR_BRAKEHDCMODE;
    public static final int RT_SETRGSBELTPRETENSIONERDATAFRONT;
    public static final int RT_SETRGSBELTPRETENSIONERDATAREAR;
    public static final int RT_SETRGSPRECRASHSYSTEM;
    public static final int RT_SETDOORLOCKINGCOMFORTOPENSETTINGS;
    public static final int RT_SETDOORLOCKINGTHEFTWARNINGSETTINGS;
    public static final int RT_SETDOORLOCKINGCLBOOTOPEN;
    public static final int RT_SETDOORLOCKINGBOOTOPEN;
    public static final int RT_SETDOORLOCKINGUNLOCKINGMODE;
    public static final int RT_SETDOORLOCKINGAUTOLOCK;
    public static final int RT_SETDOORLOCKINGAUTOUNLOCK;
    public static final int RT_SETDOORLOCKINGCLBOOTLOCK;
    public static final int RT_SETDOORLOCKINGMIRRORPROTECTION;
    public static final int RT_SETDOORLOCKINGCONFIRMATION;
    public static final int RT_SETDOORLOCKINGRAINCLOSING;
    public static final int RT_SETDOORLOCKINGREARBLIND;
    public static final int RT_SETWIPERSERVICEPOSITION;
    public static final int RT_SETWIPERRAINSENSORONOFF;
    public static final int RT_SETWIPERRAINSENSORCONFIG;
    public static final int RT_SETWIPERREARWIPING;
    public static final int RT_SETWIPERTEARSWIPING;
    public static final int RT_SETWIPERWINTERPOSITION;
    public static final int RT_SETEASYENTRYSTEERINGCOLUMN;
    public static final int RT_SETUGDOLEARNINGDATA;
    public static final int RT_SHOWUGDOPOPUP;
    public static final int RT_CANCELUGDOPOPUP;
    public static final int RT_DELETEUGDOBUTTON;
    public static final int RT_SETRDKSYSTEMONOFF;
    public static final int RT_SETRDKTIRESETUPSELECTEDTIRE;
    public static final int RT_SETRDKSPEEDLIMIT;
    public static final int RT_SETRDKTIRECHANGED;
    public static final int RT_SETRDKPRESSURECHANGED;
    public static final int RT_SETRDKPRESSURELEVEL;
    public static final int RT_SETRDKSETFACTORYDEFAULT;
    public static final int RT_SETMIRRORLOWERING;
    public static final int RT_SETMIRRORSYNCADJUST;
    public static final int RT_SETMIRRORFOLDING;
    public static final int RT_SETMIRRORDIMMING;
    public static final int RT_SETMIRRORHEATING;
    public static final int RT_SETBRAKEELECTRICALPARKING;
    public static final int RT_SETBRAKEAUTOHOLD;
    public static final int RT_SETBRAKEESCMODE;
    public static final int RT_SETBRAKEHDCMODE;
    public static final int RT_SETWIPERSETFACTORYDEFAULT;
    public static final int RT_SETMIRRORSETFACTORYDEFAULT;
    public static final int RT_SETDOORLOCKINGSETFACTORYDEFAULT;
    public static final int RT_SETUGDOSETFACTORYDEFAULT;
    public static final int RT_SETRGSSETFACTORYDEFAULT;
    public static final int RT_REQUESTRDKLIFEMONITORING;
    public static final int RT_SETUGDOOPENDOOR;
    public static final int RT_SETUGDOSYNCHRONISATION;
    public static final int RT_RESPONSEUGDOSYNCHRONISATION;
    public static final int RT_STARTUGDOLEARNING;
    public static final int RT_ABORTUGDOLEARNING;
    public static final int RT_REQUESTUGDOBUTTONLIST;
    public static final int RT_SETUGDOBUTTONLISTRA0;
    public static final int RT_SETUGDOBUTTONLISTRA1;
    public static final int RT_SETUGDOBUTTONLISTRA2;
    public static final int RT_SETUGDOBUTTONLISTRA3;
    public static final int RT_SETUGDOBUTTONLISTRA4;
    public static final int RT_SETUGDOBUTTONLISTRA5;
    public static final int RT_SETUGDOBUTTONLISTRAF;
    public static final int RT_SETRGSPRESENSESYSTEM;
    public static final int RT_SETRGSPRESENSEWARNING;
    public static final int RT_SETUGDODESTINATIONREACHED;
    public static final int RT_SETHMIISREADY;
    public static final int RT_SETRGSLOCALHAZARDINFORMATION;
    public static final int RT_STARTDOORLOCKINGREMOTELOCKUNLOCK;
    public static final int RT_SENDDOORLOCKINGREMOTELOCKUNLOCKSIGNATURE;
    public static final int RT_STARTDOORLOCKINGREMOTEBLINKING;
    public static final int RT_STARTDOORLOCKINGREMOTEHORN;
    public static final int RT_ABORTDOORLOCKINGREMOTELOCKUNLOCK;
    public static final int RT_SETDOORLOCKINGBOOTCLOSE;
    public static final int RT_REQUESTDOORLOCKINGUSERLIST;
    public static final int RT_SETDOORLOCKINGUSERLISTRA1;
    public static final int RT_SETDOORLOCKINGUSERLISTRAF;
    public static final int RT_STARTDOORLOCKINGUSERPROFILECONTROL;
    public static final int RT_SETDOORLOCKINGACTIVEUSER;
    public static final int RT_SETDOORLOCKINGUSERPROFILEONOFF;
    public static final int RT_ABORTDOORLOCKINGUSERPROFILECONTROL;
    public static final int RT_SETDOORLOCKINGWINDOWAUTOCLOSE;
    public static final int RT_SETDOORLOCKINGBLINDSCONTROL;
    public static final int RT_SETDOORLOCKINGBLINDSCONTROLEXTENDED;
    public static final int RT_SETDOORLOCKINGLEFTSIDEBLINDCONTROL;
    public static final int RT_SETDOORLOCKINGRIGHTSIDEBLINDCONTROL;
    public static final int RT_SHOWDOORLOCKINGPROMPT;
    public static final int RT_CANCELDOORLOCKINGPROMPT;
    public static final int RT_SETDOORLOCKINGTURNINDREPEAT;
    public static final int RT_SETDOORLOCKINGKEYLESS;
    public static final int RP_ACKNOWLEDGEUGDODELETEBUTTON;
    public static final int RP_RESPONSERDKTIRECHANGED;
    public static final int RP_RESPONSERDKPRESSURECHANGED;
    public static final int RP_ACKNOWLEDGEWIPERSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEMIRRORSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEUGDOSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGERGSSETFACTORYDEFAULT;
    public static final int RP_RESPONSERDKLIFEMONITORING;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGREMOTELOCKUNLOCK;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGREMOTEBLINKING;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGREMOTEHORN;
    public static final int RP_RECEIVEDDOORLOCKINGREMOTELOCKUNLOCKSIGNATUREVERIFICATION;
    public static final int RP_RECEIVEDDOORLOCKINGREMOTELOCKUNLOCKAUTHENTIFICATION;
    public static final int RP_ACKNOWLEDGEDOORLOCKINGUSERPROFILECONTROL;
    public static final int RP_ACKNOWLEDGERDKSETFACTORYDEFAULT;
    public static final int IN_REQUESTUGDOPOPUP;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA0;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA1;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA2;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA3;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA4;
    public static final int IN_RESPONSEUGDOBUTTONLISTRA5;
    public static final int IN_RESPONSEUGDOBUTTONLISTRAF;
    public static final int IN_REQUESTUGDOSYNCHRONISATION;
    public static final int IN_ACKNOWLEDGEUGDOSYNCHRONISATION;
    public static final int IN_ACKNOWLEDGEUGDOLEARNING;
    public static final int IN_ACKNOWLEDGEUGDOPOPUP;
    public static final int IN_RESPONSEDOORLOCKINGUSERLISTRA1;
    public static final int IN_RESPONSEDOORLOCKINGUSERLISTRAF;
    public static final int IN_ACKNOWLEDGERDKPRESSURECHANGED;
    public static final int IN_REQUESTDOORLOCKINGPROMPT;
    public static final int IN_ACKNOWLEDGEDOORLOCKINGPROMPT;
    public static final int DRIVERSIDE_LEFT;
    public static final int DRIVERSIDE_RIGHT;
    public static final int DOORSTATUS_CLOSED;
    public static final int DOORSTATUS_OPEN;
    public static final int LOCKSTATUS_LOCKED;
    public static final int LOCKSTATUS_UNLOCKED;
    public static final int WINDOWSTATUS_CLOSED;
    public static final int WINDOWSTATUS_OPEN;
    public static final int WINDOWSTATUS_UNKNOWN;
    public static final int SUNROOFSTATUS_CLOSED;
    public static final int SUNROOFSTATUS_OPEN_SLIDEPOSITION;
    public static final int SUNROOFSTATUS_OPEN_FOLDPOSITION;
    public static final int SUNROOFSTATUS_UNKNOWN;
    public static final int AUTOLOCKOPTIONS_OFF;
    public static final int AUTOLOCKOPTIONS_TRUNK;
    public static final int AUTOLOCKOPTIONS_ALL;
    public static final int UNLOCKINGMODE_OFF;
    public static final int UNLOCKINGMODE_SEPARATEDOOR;
    public static final int UNLOCKINGMODE_SIDE;
    public static final int UNLOCKINGMODE_ALLDOORS;
    public static final int UNLOCKINGMODE_INDIVIDUAL;
    public static final int RAINSENSORCONFIG_SENSITIVE;
    public static final int RAINSENSORCONFIG_NORMAL;
    public static final int RAINSENSORCONFIG_INSENSITIVE;
    public static final int AUTHENTICATIONSTATE_INIT;
    public static final int AUTHENTICATIONSTATE_OK;
    public static final int AUTHENTICATIONSTATE_FAILURE1;
    public static final int AUTHENTICATIONSTATE_FAILURE2;
    public static final int AUTHENTICATIONSTATE_FAILURE3;
    public static final int AUTHENTICATIONSTATE_FAILURE4;
    public static final int AUTHENTICATIONSTATE_FAILURE5;
    public static final int AUTHENTICATIONSTATE_FAILURE7;
    public static final int AUTHENTICATIONSTATE_FAILURE8;
    public static final int AUTHENTICATIONSTATE_FAILURE9;
    public static final int UGDOBUTTONS_BUTTON1;
    public static final int UGDOBUTTONS_BUTTON2;
    public static final int UGDOBUTTONS_BUTTON3;
    public static final int UGDOASGREQUEST_NO_REQUEST;
    public static final int UGDOASGREQUEST_START;
    public static final int UGDOASGREQUEST_ABORT;
    public static final int UGDOASGREQUEST_MOVE_YES;
    public static final int UGDOASGREQUEST_MOVE_NO;
    public static final int UGDOASGREQUEST_START_SYNC;
    public static final int UGDOFSGRESPONSE_IDLE;
    public static final int UGDOFSGRESPONSE_CHECK;
    public static final int UGDOFSGRESPONSE_RESET;
    public static final int UGDOFSGRESPONSE_MOVE;
    public static final int UGDOFSGRESPONSE_REPEAT_RESET;
    public static final int UGDOFSGRESPONSE_SUCCESSFUL;
    public static final int UGDOFSGRESPONSE_ERROR;
    public static final int UGDOFSGRESPONSE_WRONG_BUTTON;
    public static final int UGDOFSGRESPONSE_PRESS_BUTTON;
    public static final int UGDOCODESYSTEM_NOT_AVAILABLE;
    public static final int UGDOCODESYSTEM_UNKNOWN;
    public static final int UGDOCODESYSTEM_FIXED;
    public static final int UGDOCODESYSTEM_ROLLING;
    public static final int UGDOCONTENT_IDLE;
    public static final int UGDOCONTENT_BUTTONPRESSED;
    public static final int UGDOCONTENT_LEARNNEWDOOR;
    public static final int UGDOCONTENT_RELEARNDOOR;
    public static final int UGDOCONTENT_SYNCHRONISE;
    public static final int UGDOCONTENT_SAVEGPSPOSITION;
    public static final int UGDOCONTENT_NOFREESTORAGESPACE;
    public static final int UGDOCONTENT_SAVEGPSPOSITIONNOTPOSSIBLE;
    public static final int UGDOCONTENT_STATEIDLE;
    public static final int UGDOCONTENT_STATEEDUCATE;
    public static final int UGDOCONTENT_STATEDELETE;
    public static final int UGDODOORSTATE_IDLE;
    public static final int UGDODOORSTATE_MOVE;
    public static final int UGDODOORSTATE_OPENING;
    public static final int UGDODOORSTATE_CLOSING;
    public static final int UGDODOORSTATE_MOVEMENTSTOPPED;
    public static final int UGDODOORSTATE_NOCOMMUNICATION;
    public static final int UGDODOORSTATE_COMMUNICATIONERROR;
    public static final int UGDODOORSTATE_ABORTMOVING;
    public static final int UGDOSYNCSTATE_PRESSBUTTON;
    public static final int UGDOSYNCSTATE_RESETRECEIVER;
    public static final int UGDOSYNCSTATE_REPEATRESETRECEIVER;
    public static final int UGDOSYNCSTATE_WRONGBUTTON;
    public static final int UGDOSYNCSTATE_SUCCESSFUL;
    public static final int UGDOSYNCSTATE_SYNCFAILED;
    public static final int UGDOSYNCSTATE_CHECKMOVEMENT;
    public static final int UGDOSYNCSTATE_SYNCABORTED;
    public static final int UGDOSYNCSTATE_INIT;
    public static final int UGDOMOVEMENTSTATE_WAITINGFORUSER;
    public static final int UGDOMOVEMENTSTATE_NODOORMOVEMENT;
    public static final int UGDOMOVEMENTSTATE_DOORMOVEMENT;
    public static final int UGDOMOVEMENTSTATE_INIT;
    public static final int UGDOLEARNINGRESULT_UNKNOWN;
    public static final int UGDOLEARNINGRESULT_FIXEDCODESYSTEM_SUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_ROLLINGCODESYSTEM_SUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_ABORT_SUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_TIMEOUT_NOTSUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_SPEEDTOHIGH_NOTSUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_NOFREESTORAGE_NOTSUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_HARDKEYNOTAVAILABLE_NOTSUCCESSFUL;
    public static final int UGDOLEARNINGRESULT_ABORT_NOTSUCCESSFUL;
    public static final int UGDOLEARNEDSTATE_IDLE;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHPOS;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHOUTPOS;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHLATERSAVEDPOS;
    public static final int UGDOLEARNEDSTATE_LEARNEDWITHOUTSYNCDOOR;
    public static final int UGDOLEARNEDSTATE_FIXKITMODE;
    public static final int UGDOLEARNEDSTATE_DEFAULTMODE;
    public static final int UGDOARRAYCONTENT_NONE;
    public static final int UGDOARRAYCONTENT_ALL;
    public static final int UGDOARRAYCONTENT_ALL_FORWARD;
    public static final int UGDOARRAYCONTENT_ALL_BACKWARD;
    public static final int UGDOARRAYCONTENT_ONLY_CHANGES;
    public static final int UGDOARRAYCONTENT_ELEMENTS_REMOVED;
    public static final int UGDOARRAYCONTENT_BLOCK_INSERTED;
    public static final int UGDOARRAYCONTENT_BACKWARD;
    public static final int UGDORECORDCONTENT_RA0;
    public static final int UGDORECORDCONTENT_RA1;
    public static final int UGDORECORDCONTENT_RA2;
    public static final int UGDORECORDCONTENT_RA3;
    public static final int UGDORECORDCONTENT_RA4;
    public static final int UGDORECORDCONTENT_RA5;
    public static final int UGDORECORDCONTENT_RA6;
    public static final int UGDORECORDCONTENT_RA7;
    public static final int UGDORECORDCONTENT_RA8;
    public static final int UGDORECORDCONTENT_RA9;
    public static final int UGDORECORDCONTENT_RAA;
    public static final int UGDORECORDCONTENT_RAB;
    public static final int UGDORECORDCONTENT_RAC;
    public static final int UGDORECORDCONTENT_RAD;
    public static final int UGDORECORDCONTENT_RAE;
    public static final int UGDORECORDCONTENT_RAF;
    public static final int WHEELTYPE_WINTER;
    public static final int WHEELTYPE_SUMMER;
    public static final int WHEELTYPE_ALLSEASON;
    public static final int WHEELTYPE_CUSTOMTIRE;
    public static final int WHEELTYPE_UNKNOWN;
    public static final int RDKSPEEDLIMITSTATE_NORMAL;
    public static final int RDKSPEEDLIMITSTATE_NO_VALUE;
    public static final int RDKSPEEDLIMITSTATE_NOT_AVAILABLE;
    public static final int RDKWHEELSTATE_OK;
    public static final int RDKWHEELSTATE_NOT_DISPLAYED;
    public static final int RDKWHEELSTATE_LOW_WARNING;
    public static final int RDKWHEELSTATE_HARD_WARNING;
    public static final int RDKWHEELSTATE_BREAKDOWN;
    public static final int RDKWHEELSTATE_UNKNOWN;
    public static final int RDKWHEELSTATE_WHEELCHANGED;
    public static final int RDKWHEELSTATE_PARTLOADOBSERVED;
    public static final int RDKWHEELSTATE_FULLLOADOBSERVED;
    public static final int RDKWHEELSTATE_FASTFORPRESSURE;
    public static final int RDKWHEELSTATE_FASTFORWHEEL;
    public static final int RDKWHEELSTATE_CHANGE_SWITCH_PRESS_LONGER;
    public static final int RDKWHEELSTATE_SWITCH_PRESS_LONGER;
    public static final int RDKWHEELSTATE_CHANGE_PRESS_LONGER;
    public static final int RDKWHEELSTATE_NOT_OK;
    public static final int RDKWHEELSTATE_LEARNING_ABOVE_SPEEDLEVEL;
    public static final int RDKWHEELSTATE_LEARNING_STATE;
    public static final int RDKWHEELSTATE_RACETRACK_MODE;
    public static final int RDKWHEELSTATE_LEARNING_REQUIRED;
    public static final int RDKWHEELSTATE_LEARNING_MODE;
    public static final int RDKWHEELSTATE_CUSTOM_MODE;
    public static final int RDKWHEELSTATE_OVER_TEMPERATURE;
    public static final int RDKWHEELSTATE_OVER_PRESSURE;
    public static final int RDKWHEELSTATE_PRESSURE_STORED;
    public static final int RDKWHEELSTATE_BATTERY_LOW;
    public static final int RDKSYSTEM_LOW;
    public static final int RDKSYSTEM_HIGH;
    public static final int RDKSYSTEM_HIGH_PLUS;
    public static final int RDKSYSTEM_UNKNOWN;
    public static final int RDKSYSTEMTYPE_INDIRECT;
    public static final int RDKSYSTEMTYPE_DIRECT;
    public static final int RDKSYSTEMTYPE_UNKNOWN;
    public static final int RDKSPEEDLIMIT_UNKNOWN;
    public static final int RDKSPEEDLIMIT_LIMIT1;
    public static final int RDKSPEEDLIMIT_LIMIT2;
    public static final int RDKSPEEDLIMIT_LIMIT3;
    public static final int RDKPROGRESS_IDLE;
    public static final int RDKPROGRESS_RUNNING;
    public static final int RDKPROGRESS_SUCCESSFUL;
    public static final int RDKPROGRESS_ERROR;
    public static final int RDKBATTERYLIFETIMEUNIT_MONTH;
    public static final int RDKBATTERYLIFETIMEUNIT_PERCENT;
    public static final int RDKPRESSURELEVEL_UNKNOWN;
    public static final int RDKPRESSURELEVEL_PRESSURE1;
    public static final int RDKPRESSURELEVEL_PRESSURE2;
    public static final int RDKPRESSURELEVEL_PRESSURE3;
    public static final int BRAKEESCMODE_OFF;
    public static final int BRAKEESCMODE_SPORT;
    public static final int BRAKEESCMODE_TCSOFF;
    public static final int BRAKEESCMODE_FULL;
    public static final int BRAKEESCMODE_OFFROAD;
    public static final int BRAKEAUTOHOLD_OFF;
    public static final int BRAKEAUTOHOLD_ON;
    public static final int BRAKEAUTOHOLD_LASTMODE;
    public static final int LOCALHAZARDEVENTTRANSACTION_SET;
    public static final int LOCALHAZARDEVENTTRANSACTION_CANCELLED;
    public static final int LOCALHAZARDEVENTQUALITY_NOQUALITY;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY1;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY2;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY3;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY4;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY5;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY6;
    public static final int LOCALHAZARDEVENTQUALITY_QUALITY7;
    public static final int LOCALHAZARDEVENTTYPE_NOTYPE;
    public static final int LOCALHAZARDEVENTTYPE_ACCIDENT;
    public static final int LOCALHAZARDEVENTTYPE_REDUCEDVISIBILITY;
    public static final int LOCALHAZARDEVENTTYPE_BREAKDOWN;
    public static final int LOCALHAZARDEVENTTYPE_TRACTIONLOSS;
    public static final int RGSPRESENSEWARNING_OFF;
    public static final int RGSPRESENSEWARNING_EARLY;
    public static final int RGSPRESENSEWARNING_MEDIUM;
    public static final int RGSPRESENSEWARNING_LATE;
    public static final int USERLISTTYPE_STRING;
    public static final int USERLISTTYPE_USER1;
    public static final int USERLISTTYPE_USER2;
    public static final int USERLISTTYPE_USER3;
    public static final int USERLISTTYPE_USER4;
    public static final int USERLISTTYPE_USER5;
    public static final int USERLISTTYPE_USER6;
    public static final int USERLISTTYPE_USER7;
    public static final int USERLISTTYPE_GUEST;
    public static final int USERLISTARRAYCONTENT_NONE;
    public static final int USERLISTARRAYCONTENT_ALL;
    public static final int USERLISTARRAYCONTENT_ALL_FORWARD;
    public static final int USERLISTARRAYCONTENT_ALL_BACKWARD;
    public static final int USERLISTARRAYCONTENT_ONLY_CHANGES;
    public static final int USERLISTARRAYCONTENT_ELEMENTS_REMOVED;
    public static final int USERLISTARRAYCONTENT_BLOCK_INSERTED;
    public static final int USERLISTARRAYCONTENT_BACKWARD;
    public static final int USERLISTRECORDCONTENT_RA1;
    public static final int USERLISTRECORDCONTENT_RAF;
    public static final int USERPROFILECONTROL_SETDEFAULT_ALL;
    public static final int USERPROFILECONTROL_SETDEFAULT_ACTIVE;
    public static final int USERPROFILECONTROL_COPYACTIVETOTARGET;
    public static final int USERPROFILECONTROL_SETACTIVETOTARGET;
    public static final int USERPROFILECONTROL_ASSIGNKEYTOTARGET;
    public static final int USERPROFILECONTROL_CONTROL_NOT_AVAILABLE;
    public static final int BLINDSCONTROL_BOOTBLINDDOWN;
    public static final int BLINDSCONTROL_BOOTBLINDUP;
    public static final int BLINDSCONTROL_ALLDOWN;
    public static final int BLINDSCONTROL_ALLUP;
    public static final int BLINDSCONTROLMOTIONSTATE_IDLEORFINISHED;
    public static final int BLINDSCONTROLMOTIONSTATE_MOVINGDOWN;
    public static final int BLINDSCONTROLMOTIONSTATE_MOVINGUP;
    public static final int SIDEBLINDSCONTROLSTATE_DOWN;
    public static final int SIDEBLINDSCONTROLSTATE_UP;
    public static final int SIDEBLINDSCONTROLSTATE_MOVINGDOWN;
    public static final int SIDEBLINDSCONTROLSTATE_MOVINGUP;
    public static final int DOORLOCKINGPROMPTCONTENT_NONE;
    public static final int DOORLOCKINGPROMPTCONTENT_SHOW_ATNE;

    default public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData rGSBeltPretensionData) {
    }

    default public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData rGSBeltPretensionData) {
    }

    default public void setRGSPreCrashSystem(boolean bl) {
    }

    default public void setRgsSetFactoryDefault() {
    }

    default public void setRGSPreSenseSystem(boolean bl) {
    }

    default public void setRGSPreSenseWarning(int n) {
    }

    default public void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
    }

    default public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
    }

    default public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
    }

    default public void setDoorLockingClBootOpen(boolean bl) {
    }

    default public void setDoorLockingBootOpen(boolean bl) {
    }

    default public void setDoorLockingBootClose(boolean bl) {
    }

    default public void startDoorLockingRemoteLockUnlock(String string) {
    }

    default public void abortDoorLockingRemoteLockUnlock() {
    }

    default public void sendDoorLockingRemoteLockUnlockSignature(String string) {
    }

    default public void startDoorLockingRemoteBlinking(int n) {
    }

    default public void startDoorLockingRemoteHorn(int n) {
    }

    default public void setDoorLockingUnlockingMode(int n) {
    }

    default public void setDoorLockingAutoLock(int n) {
    }

    default public void setDoorLockingAutoUnlock(boolean bl) {
    }

    default public void setDoorLockingClBootLock(boolean bl) {
    }

    default public void setDoorLockingMirrorProtection(boolean bl) {
    }

    default public void setDoorLockingConfirmation(boolean bl) {
    }

    default public void setDoorLockingRainClosing(boolean bl) {
    }

    default public void setDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind) {
    }

    default public void setDoorLockingSetFactoryDefault() {
    }

    default public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
    }

    default public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
    }

    default public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
    }

    default public void setDoorLockingActiveUser(int n) {
    }

    default public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
    }

    default public void startDoorLockingUserProfileControl(int n, int n2) {
    }

    default public void abortDoorLockingUserProfileControl() {
    }

    default public void setDoorLockingWindowAutoClose(boolean bl) {
    }

    default public void setDoorlockingBlindsControl(int n) {
    }

    default public void setDoorlockingBlindsControlExtended(int n) {
    }

    default public void setDoorLockingLeftSideBlindControl(int n) {
    }

    default public void setDoorLockingRightSideBlindControl(int n) {
    }

    default public void setDoorLockingTurnIndRepeat(boolean bl) {
    }

    default public void setDoorLockingKeyless(boolean bl) {
    }

    default public void setWiperServicePosition(boolean bl) {
    }

    default public void setWiperRainSensorOnOff(boolean bl) {
    }

    default public void setWiperRainSensorConfig(int n) {
    }

    default public void setWiperRearWiping(boolean bl) {
    }

    default public void setWiperTearsWiping(boolean bl) {
    }

    default public void setWiperWinterPosition(boolean bl) {
    }

    default public void setEasyEntrySteeringColumn(boolean bl) {
    }

    default public void setWiperSetFactoryDefault() {
    }

    default public void setUGDOLearningData(UGDOLearningData uGDOLearningData) {
    }

    default public void showUGDOPopup(UGDOContent uGDOContent) {
    }

    default public void cancelUGDOPopup(UGDOContent uGDOContent) {
    }

    default public void deleteUGDOButton(UGDOSoftkeys uGDOSoftkeys) {
    }

    default public void setUGDOSetFactoryDefault() {
    }

    default public void setUGDODestinationReached(UGDODestinationReached uGDODestinationReached) {
    }

    default public void setUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor) {
    }

    default public void setUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    default public void responseUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    default public void startUGDOLearning(int n, int n2) {
    }

    default public void abortUGDOLearning() {
    }

    default public void requestUGDOButtonList(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
    }

    default public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    default public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    default public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    default public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    default public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    default public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    default public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    default public void setRDKSystemOnOff(boolean bl) {
    }

    default public void setRDKTireSetupSelectedTire(int n) {
    }

    default public void setRDKSpeedLimit(int n) {
    }

    default public void setRDKTireChanged() {
    }

    default public void setRDKPressureChanged() {
    }

    default public void requestRDKLifeMonitoring() {
    }

    default public void setRDKPressureLevel(byte by) {
    }

    default public void setRDKSetFactoryDefault() {
    }

    default public void setMirrorLowering(boolean bl) {
    }

    default public void setMirrorSyncAdjust(boolean bl) {
    }

    default public void setMirrorFolding(boolean bl) {
    }

    default public void setMirrorDimming(boolean bl) {
    }

    default public void setMirrorHeating(boolean bl) {
    }

    default public void setMirrorSetFactoryDefault() {
    }

    default public void setBrakeElectricalParking(boolean bl) {
    }

    default public void setBrakeAutoHold(int n) {
    }

    default public void setBrakeEscMode(int n) {
    }

    default public void setBrakeHdcMode(boolean bl) {
    }

    default public void setHMIIsReady(boolean bl) {
    }

    default public void showDoorLockingPrompt(int n) {
    }

    default public void cancelDoorLockingPrompt(int n) {
    }
}


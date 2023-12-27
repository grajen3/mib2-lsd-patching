/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public interface DSICarplay
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DEVICEINFO;
    public static final int ATTR_NOWPLAYINGDATA;
    public static final int ATTR_PLAYBACKSTATE;
    public static final int ATTR_PLAYPOSITION;
    public static final int ATTR_COVERARTURL;
    public static final int ATTR_TELEPHONYSTATE;
    public static final int ATTR_CALLSTATE;
    public static final int ATTR_MODE;
    public static final int ATTR_TEXTINPUTSTATE;
    public static final int ATTR_MAINAUDIOTYPE;
    public static final int RT_STARTSERVICE;
    public static final int RT_POSTBUTTONEVENT;
    public static final int RT_POSTTOUCHEVENT;
    public static final int RT_POSTROTARYEVENT;
    public static final int RT_RESPONSEBTDEACTIVATION;
    public static final int RT_REQUESTUI;
    public static final int RT_REQUESTMODECHANGE;
    public static final int RT_POSTCHARACTEREVENT;
    public static final int RT_REQUESTNIGHTMODE;
    public static final int RT_REQUESTSIRIACTION;
    public static final int RT_RESPONSEUPDATEMODE;
    public static final int RT_RESPONSEUPDATEMAINAUDIOTYPE;
    public static final int RT_REQUESTUI2;
    public static final int RP_RESPONSEMODECHANGE;
    public static final int IN_REQUESTBTDEACTIVATION;
    public static final int IN_DUCKAUDIO;
    public static final int IN_UNDUCKAUDIO;
    public static final int IN_OEMAPPSELECTED;
    public static final int CHANGEMODERESULT_OK;
    public static final int CHANGEMODERESULT_REJECTED;
    public static final int SPEECHMODE_UNKNOWN;
    public static final int SPEECHMODE_NONE;
    public static final int SPEECHMODE_SPEAKING;
    public static final int SPEECHMODE_RECOGNIZING;
    public static final int APPLICATIONID_UNKNOWN;
    public static final int APPLICATIONID_PHONE;
    public static final int APPLICATIONID_NAVIGATION;
    public static final int APPLICATIONID_SPEECH;
    public static final int APPLICATIONOWNER_UNKNOWN;
    public static final int APPLICATIONOWNER_MAINUNIT;
    public static final int APPLICATIONOWNER_DEVICE;
    public static final int RESOURCE_UNKNOWN;
    public static final int RESOURCE_MAIN_AUDIO;
    public static final int RESOURCE_MAIN_SCREEN;
    public static final int RESOURCEOWNER_UNDEFINED;
    public static final int RESOURCEOWNER_MAINUNIT;
    public static final int RESOURCEOWNER_DEVICE;
    public static final int RESOURCETRANSFERTYPE_UNKNOWN;
    public static final int RESOURCETRANSFERTYPE_TAKE;
    public static final int RESOURCETRANSFERTYPE_UNTAKE;
    public static final int RESOURCETRANSFERTYPE_BORROW;
    public static final int RESOURCETRANSFERTYPE_UNBORROW;
    public static final int RESOURCETRANSFERPRIORITY_UNKNOWN;
    public static final int RESOURCETRANSFERPRIORITY_USER_INITIATED;
    public static final int RESOURCETRANSFERPRIORITY_NICE_TO_HAVE;
    public static final int RESOURCESHARINGPOLICY_UKNOWN;
    public static final int RESOURCESHARINGPOLICY_ALWAYS;
    public static final int RESOURCESHARINGPOLICY_USER_INITIATED;
    public static final int RESOURCESHARINGPOLICY_NEVER;
    public static final int UI_UNKNOWN;
    public static final int UI_HOME;
    public static final int UI_PHONE;
    public static final int UI_NAVIGATION;
    public static final int UI_MEDIA;
    public static final int UI_MEDIA_NOWPLAYING;
    public static final int BUTTON_UNKNOWN;
    public static final int BUTTON_SELECT;
    public static final int BUTTON_HOME;
    public static final int BUTTON_BACK;
    public static final int BUTTON_VOICE;
    public static final int BUTTON_LEFT;
    public static final int BUTTON_RIGHT;
    public static final int BUTTON_UP;
    public static final int BUTTON_DOWN;
    public static final int BUTTON_SKIP_FORWARD;
    public static final int BUTTON_SKIP_BACKWARD;
    public static final int BUTTON_SEEK_FORWARD;
    public static final int BUTTON_SEEK_BACKWARD;
    public static final int BUTTON_ACCEPT_CALL;
    public static final int BUTTON_END_CALL;
    public static final int BUTTON_PLAY_PAUSE;
    public static final int BUTTON_PRIMARY;
    public static final int BUTTON_SECONDARY;
    public static final int BUTTON_PAUSE;
    public static final int BUTTON_PLAY;
    public static final int BUTTON_FLASH_CALL;
    public static final int BUTTONSTATE_PRESSED;
    public static final int BUTTONSTATE_RELEASED;
    public static final int TOUCHSOURCE_TOUCHPAD;
    public static final int TOUCHSOURCE_TOUCHSCREEN;
    public static final int TEXTINPUTSTATE_INACTIVE;
    public static final int TEXTINPUTSTATE_ACTIVE;
    public static final int SCREENRESOLUTION_800_BY_480;
    public static final int SCREENRESOLUTION_960_BY_540;
    public static final int SCREENRESOLUTION_1024_BY_480;
    public static final int SCREENRESOLUTION_CUSTOM;
    public static final int CALLSTATE_DISCONNECTED;
    public static final int CALLSTATE_ACTIVE;
    public static final int CALLSTATE_HOLDING;
    public static final int CALLSTATE_CONNECTING;
    public static final int CALLDIRECTION_INCOMING;
    public static final int CALLDIRECTION_OUTGOING;
    public static final int CALLDIRECTION_UNKNOWN;
    public static final int PLAYBACKSTATE_STOPPED;
    public static final int PLAYBACKSTATE_PLAYING;
    public static final int PLAYBACKSTATE_PAUSED;
    public static final int PLAYBACKSTATE_SEEKFORWARD;
    public static final int PLAYBACKSTATE_SEEKBACKWARD;
    public static final int PLAYBACKMODESHUFFLE_OFF;
    public static final int PLAYBACKMODESHUFFLE_SONGS;
    public static final int PLAYBACKMODESHUFFLE_ALBUMS;
    public static final int PLAYBACKMODEREPEAT_OFF;
    public static final int PLAYBACKMODEREPEAT_ONE;
    public static final int PLAYBACKMODEREPEAT_ALL;
    public static final int SIGNALSTRENGTH_0_BARS_NO_SERVICE;
    public static final int SIGNALSTRENGTH_1_BAR;
    public static final int SIGNALSTRENGTH_2_BARS;
    public static final int SIGNALSTRENGTH_3_BARS;
    public static final int SIGNALSTRENGTH_4_BARS;
    public static final int SIGNALSTRENGTH_5_BARS;
    public static final int REGISTRATIONSTATE_UNKNOWN;
    public static final int REGISTRATIONSTATE_NOT_REGISTERED;
    public static final int REGISTRATIONSTATE_SEARCHING;
    public static final int REGISTRATIONSTATE_DENIED;
    public static final int REGISTRATIONSTATE_REGISTRED_HOME;
    public static final int REGISTRATIONSTATE_ROAMING;
    public static final int REGISTRATIONSTATE_EMERGENCY_CALLS_ONLY;
    public static final int SIRIACTION_PREWARM;
    public static final int SIRIACTION_START;
    public static final int SIRIACTION_STOP;
    public static final int AUDIOTYPE_NONE;
    public static final int AUDIOTYPE_ALERT;
    public static final int AUDIOTYPE_MEDIA;
    public static final int AUDIOTYPE_TELEPHONY;
    public static final int AUDIOTYPE_SPEECHRECOGNITION;
    public static final int INPUTFEATURE_KNOB;
    public static final int INPUTFEATURE_LOWFIDELITYTOUCH;
    public static final int INPUTFEATURE_HIGHFIDELITYTOUCH;
    public static final int INPUTFEATURE_TOUCHPAD;

    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void postCharacterEvent(int n, String[] stringArray) {
    }

    default public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
    }

    default public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void responseBTDeactivation() {
    }

    default public void requestUI(int n) {
    }

    default public void requestNightMode(boolean bl) {
    }

    default public void requestSIRIAction(int n) {
    }

    default public void responseUpdateMainAudioType(int n) {
    }

    default public void requestUI2(String string) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;
import org.dsi.ifc.base.DSIBase;

public interface DSIAndroidAuto
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_NOWPLAYINGDATA;
    public static final int ATTR_PLAYBACKSTATE;
    public static final int ATTR_PLAYPOSITION;
    public static final int ATTR_COVERARTURL;
    public static final int ATTR_TELEPHONYSTATE;
    public static final int ATTR_CALLSTATE;
    public static final int ATTR_NAVIGATIONNEXTTURNEVENT;
    public static final int ATTR_NAVIGATIONNEXTTURNDISTANCE;
    public static final int RT_STARTSERVICE;
    public static final int RT_POSTBUTTONEVENT;
    public static final int RT_POSTTOUCHEVENT;
    public static final int RT_POSTROTARYEVENT;
    public static final int RT_REQUESTNIGHTMODE;
    public static final int RT_RESPONSEMODECHANGE;
    public static final int RT_SETMODE;
    public static final int RP_SETMODE;
    public static final int IN_REQUESTMODECHANGE;
    public static final int IN_SETEXTERNALDESTINATION;
    public static final int APPLICATIONID_UNKNOWN;
    public static final int APPLICATIONID_PHONE;
    public static final int APPLICATIONID_NAVIGATION;
    public static final int APPLICATIONID_SPEECH;
    public static final int APPLICATIONOWNER_UNKNOWN;
    public static final int APPLICATIONOWNER_MAINUNIT;
    public static final int APPLICATIONOWNER_DEVICE;
    public static final int RESOURCE_UNKNOWN;
    public static final int RESOURCE_VIDEO;
    public static final int RESOURCE_MICROPHONE;
    public static final int RESOURCE_AUDIO_MEDIA;
    public static final int RESOURCE_AUDIO_GUIDANCE;
    public static final int RESOURCE_AUDIO_SYSTEM_UI;
    public static final int RESOURCE_AUDIO_TELEPHONY;
    public static final int RESOURCEOWNER_UNDEFINED;
    public static final int RESOURCEOWNER_MAINUNIT;
    public static final int RESOURCEOWNER_DEVICE;
    public static final int RESOURCETRANSFERTYPE_UNKNOWN;
    public static final int RESOURCETRANSFERTYPE_TAKE;
    public static final int RESOURCETRANSFERTYPE_UNTAKE;
    public static final int RESOURCETRANSFERTYPE_BORROW;
    public static final int RESOURCETRANSFERTYPE_UNBORROW;
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
    public static final int BUTTON_MEDIA;
    public static final int BUTTON_NAVIGATION;
    public static final int BUTTON_PHONE;
    public static final int BUTTON_CAR;
    public static final int BUTTON_PLAY;
    public static final int BUTTON_PAUSE;
    public static final int BUTTONSTATE_PRESSED;
    public static final int BUTTONSTATE_RELEASED;
    public static final int TOUCHSOURCE_TOUCHPAD;
    public static final int TOUCHSOURCE_TOUCHSCREEN;
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
    public static final int REGISTRATIONSTATE_UNKNOWN;
    public static final int REGISTRATIONSTATE_NOT_REGISTERED;
    public static final int REGISTRATIONSTATE_SEARCHING;
    public static final int REGISTRATIONSTATE_DENIED;
    public static final int REGISTRATIONSTATE_REGISTRED_HOME;
    public static final int REGISTRATIONSTATE_ROAMING;
    public static final int REGISTRATIONSTATE_EMERGENCY_CALLS_ONLY;
    public static final int POINTERACTION_DOWN;
    public static final int POINTERACTION_UP;
    public static final int POINTERACTION_MOVED;
    public static final int POINTERACTION_POINTER_DOWN;
    public static final int POINTERACTION_POINTER_UP;
    public static final int NAVIGATIONTURNSIDE_UNSPECIFIED;
    public static final int NAVIGATIONTURNSIDE_LEFT;
    public static final int NAVIGATIONTURNSIDE_RIGHT;
    public static final int NAVIGATIONTURNEVENT_UNKNOWN;
    public static final int NAVIGATIONTURNEVENT_DEPART;
    public static final int NAVIGATIONTURNEVENT_NAME_CHANGE;
    public static final int NAVIGATIONTURNEVENT_SLIGHT_TURN;
    public static final int NAVIGATIONTURNEVENT_TURN;
    public static final int NAVIGATIONTURNEVENT_SHARP_TURN;
    public static final int NAVIGATIONTURNEVENT_U_TURN;
    public static final int NAVIGATIONTURNEVENT_ON_RAMP;
    public static final int NAVIGATIONTURNEVENT_OFF_RAMP;
    public static final int NAVIGATIONTURNEVENT_FORK;
    public static final int NAVIGATIONTURNEVENT_MERGE;
    public static final int NAVIGATIONTURNEVENT_ROUNDABOUT_ENTER;
    public static final int NAVIGATIONTURNEVENT_ROUNDABOUT_EXIT;
    public static final int NAVIGATIONTURNEVENT_ROUNDABOUT_ENTER_AND_EXIT;
    public static final int NAVIGATIONTURNEVENT_STRAIGHT;
    public static final int NAVIGATIONTURNEVENT_FERRY_BOAT;
    public static final int NAVIGATIONTURNEVENT_FERRY_TRAIN;
    public static final int NAVIGATIONTURNEVENT_DESTINATION;

    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void requestNightMode(boolean bl) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;
import org.dsi.ifc.base.DSIBase;

public interface DSIAndroidAuto2
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_CALLSTATE;
    public static final int ATTR_TELEPHONYSTATE;
    public static final int ATTR_NOWPLAYINGDATA;
    public static final int ATTR_PLAYBACKSTATE;
    public static final int ATTR_PLAYPOSITION;
    public static final int ATTR_COVERARTURL;
    public static final int ATTR_NAVIGATIONNEXTTURNEVENT;
    public static final int ATTR_NAVIGATIONNEXTTURNDISTANCE;
    public static final int RT_VIDEOFOCUSNOTIFICATION;
    public static final int RT_AUDIOFOCUSNOTIFICATION;
    public static final int RT_MICROPHONENOTIFICATION;
    public static final int RT_NAVFOCUSNOTIFICATION;
    public static final int RT_STARTSERVICE;
    public static final int RT_POSTBUTTONEVENT;
    public static final int RT_POSTTOUCHEVENT;
    public static final int RT_POSTROTARYEVENT;
    public static final int RT_SETNIGHTMODE;
    public static final int RT_BLUETOOTHPAIRINGRESPONSE;
    public static final int RT_BLUETOOTHAUTHENTICATIONDATA;
    public static final int IN_VIDEOFOCUSREQUESTNOTIFICATION;
    public static final int IN_VIDEOAVAILABLE;
    public static final int IN_AUDIOFOCUSREQUESTNOTIFICATION;
    public static final int IN_AUDIOAVAILABLE;
    public static final int IN_VOICESESSIONNOTIFICATION;
    public static final int IN_MICROPHONEREQUESTNOTIFICATION;
    public static final int IN_NAVFOCUSREQUESTNOTIFICATION;
    public static final int IN_SETEXTERNALDESTINATION;
    public static final int IN_BLUETOOTHPAIRINGREQUEST;

    default public void videoFocusNotification(int n, boolean bl) {
    }

    default public void audioFocusNotification(int n, boolean bl) {
    }

    default public void microphoneNotification(int n, boolean bl) {
    }

    default public void navFocusNotification(int n, boolean bl) {
    }

    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void setNightMode(boolean bl) {
    }

    default public void bluetoothPairingResponse(boolean bl) {
    }

    default public void bluetoothAuthenticationData(String string) {
    }
}


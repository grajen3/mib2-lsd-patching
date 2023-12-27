/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.waveplayer;

import org.dsi.ifc.base.DSIBase;

public interface DSIWavePlayer
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETPLAYTONE;
    public static final int RT_AUDIOTRIGGER;
    public static final int RT_AUDIOTRIGGERDEFAULTTONE;
    public static final int ATTR_PLAYTONE;
    public static final int ATTR_AUDIOREQUEST;
    public static final int RP_SETPLAYTONE;
    public static final int RP_AUDIOTRIGGERRESPONSE;
    public static final int AUDIOMODE_START;
    public static final int AUDIOMODE_REPEAT;
    public static final int AUDIOMODE_ABORT;
    public static final int AUDIOMODE_STARTED;
    public static final int AUDIOMODE_STOPPED;
    public static final int AUDIOMODE_ABORTED;
    public static final int AUDIOMODE_ERROR_BUSY;
    public static final int AUDIOMODE_ERROR_NOT_POSSIBLE;
    public static final int AUDIOMODE_ERROR_REGISTRATION_MISSING;
    public static final int AUDIOMODE_ERROR_INTERNAL;
    public static final int AUDIOSTATE_ACTIVE;
    public static final int AUDIOSTATE_IDLE;
    public static final int TONEID_RINGTONE_1;
    public static final int TONEID_RINGTONE_2;
    public static final int TONEID_RINGTONE_3;
    public static final int TONEID_RINGTONE_4;
    public static final int TONEID_RINGTONE_5;
    public static final int TONEID_RINGTONE_6;
    public static final int TONEID_RINGTONE_7;
    public static final int TONEID_RINGTONE_8;
    public static final int TONEID_RINGTONE_9;
    public static final int TONEID_RINGTONE_10;
    public static final int TONEID_HEARTBEAT;
    public static final int TONEID_STREETVIEW;
    public static final int TONEID_SMS_MAIL;
    public static final int TONEID_TOUCHSCREEN;
    public static final int TONEID_BEEP;
    public static final int TONEID_WARNING_1;
    public static final int TONEID_WARNING_2;
    public static final int TONEID_BEEP_2;
    public static final int TONEID_SMS_MAIL_2;
    public static final int TONEID_BEEP_3;
    public static final int TONEID_TOUCHSCREEN_2;
    public static final int TONEID_NAVPOI;
    public static final int PLAYTONERESULT_SUCCESS;
    public static final int PLAYTONERESULT_INVALID_TONE_ID;

    default public void audioTrigger(int n) {
    }

    default public void audioTriggerDefaultTone(int n) {
    }

    default public void setPlayTone(int n) {
    }
}


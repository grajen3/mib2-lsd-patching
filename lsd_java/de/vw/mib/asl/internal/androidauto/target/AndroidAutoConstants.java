/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

public class AndroidAutoConstants {
    public static final int AUDIO_STATE_RELEASED;
    public static final int AUDIO_STATE_REQUESTED;
    public static final int AUDIO_STATE_CONNECTED;
    public static final int ENTERTAINMENT_CONNECTION_STATE_TARGET_NOT_REGISTERED;
    public static final int ENTERTAINMENT_CONNECTION_STATE_TARGET_REGISTER_REQUESTED;
    public static final int ENTERTAINMENT_CONNECTION_STATE_TARGET_REGISTERED;
    public static final int ENTERTAINMENT_CONNECTION_STATE_ENTERTAINMENT_REQUESTED;
    public static final int ENTERTAINMENT_CONNECTION_STATE_AUDIO_REQUESTED;
    public static final int ENTERTAINMENT_CONNECTION_STATE_READY;
    public static final int AAP_AUDIO_FOCUS_REQUEST_UNKNOWN;
    public static final int AAP_AUDIO_FOCUS_REQUEST_GAIN;
    public static final int AAP_AUDIO_FOCUS_REQUEST_GAIN_TRANSIENT;
    public static final int AAP_AUDIO_FOCUS_REQUEST_GAIN_TRANSIENT_MAY_DUCK;
    public static final int AAP_AUDIO_FOCUS_REQUEST_RELEASE;
    public static final String[] AAP_AUDIO_FOCUS_REQUEST;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_UNKNOWN;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_GAIN;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_GAIN_TRANSIENT_GUIDANCE_ONLY;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_GAIN_MEDIA_ONLY;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_LOSS_TRANSIENT_MAY_DUCK;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_LOSS;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_LOSS_TRANSIENT;
    public static final int AAP_AUDIO_FOCUS_NOTIFICATION_STATE_NONE;
    public static final String[] AAP_AUDIO_FOCUS_NOTIFICATION_STATE;
    public static final String[] RESSOURCETRANSFERTYPE;
    public static final String[] RESSOURCEOWNER;
    public static final int HK_PTT_STATE_NONE;
    public static final int HK_PTT_STATE_PRESSED;
    public static final int HK_PTT_STATE_RELEASED;
    public static final int HK_PTT_STATE_LONG_PRESSED;
    public static final int HK_PTT_STATE_LONG_RELEASED;
    public static final long MAX_TIMESTAMP_DELTA;
    public static final long TIMER_50_MS;
    public static final long TIMER_100_MS;
    public static final long TIMER_200_MS;
    public static final long TIMER_300_MS;
    public static final long TIMER_400_MS;
    public static final long TIMER_3000_MS;
    public static final long TIMER_5000_MS;
    public static final boolean ANDROIDAUTO_NAVIGATION_ACTIVE;
    public static final boolean ANDROIDAUTO_NAVIGATION_INACTIVE;
    public static final int SENSOR_MODE_NIGHT;
    public static final String[] VIDEOFOCUS_STATE;

    static {
        AAP_AUDIO_FOCUS_REQUEST = new String[]{"AAP_AUDIO_FOCUS_REQUEST_UNKNOWN", "AAP_AUDIO_FOCUS_REQUEST_GAIN", "AAP_AUDIO_FOCUS_REQUEST_GAIN_TRANSIENT", "AAP_AUDIO_FOCUS_REQUEST_GAIN_TRANSIENT_MAY_DUCK", "AAP_AUDIO_FOCUS_REQUEST_RELEASE"};
        AAP_AUDIO_FOCUS_NOTIFICATION_STATE = new String[]{"AAP_AUDIO_FOCUS_NOTIFICATION_STATE_UNKNOWN", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_GAIN", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_GAIN_TRANSIENT_GUIDANCE_ONLY", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_GAIN_MEDIA_ONLY", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_LOSS_TRANSIENT_MAY_DUCK", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_LOSS", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_LOSS_TRANSIENT", "AAP_AUDIO_FOCUS_NOTIFICATION_STATE_NONE"};
        RESSOURCETRANSFERTYPE = new String[]{"UNKNOWN", "TAKE", "UNTAKE", "BORROW", "UNBORROW"};
        RESSOURCEOWNER = new String[]{"UNDEFINED", "MAINUNIT", "DEVICE"};
        VIDEOFOCUS_STATE = new String[]{"VIDEOFOCUS_UNKNOWN", "VIDEOFOCUS_PROJECTED", "VIDEOFOCUS_NATIVE"};
    }
}


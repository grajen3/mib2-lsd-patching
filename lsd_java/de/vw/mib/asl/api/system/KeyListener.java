/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

public interface KeyListener {
    public static final int KEY_UNKNOWN;
    public static final int KEY_MEDIA;
    public static final int KEY_TELEPHONE;
    public static final int KEY_NAVIGATION;
    public static final int KEY_TRAFFIC;
    public static final int KEY_CAR;
    public static final int KEY_SETTINGS;
    public static final int KEY_PREVIOUS;
    public static final int KEY_MFW_ARROW_A_DOWN;
    public static final int KEY_MFW_ARROW_A_UP;
    public static final int KEY_NEXT;
    public static final int KEY_TUNER;
    public static final int KEY_DDS;
    public static final int KEY_VOLUME;
    public static final int KEY_EJECT;
    public static final int KEY_MFW_PTT_ON;
    public static final int KEY_MENU;
    public static final int KEY_CLIMATE;
    public static final int KEY_TONE;
    public static final int KEY_TP;
    public static final int KEY_MUTE;
    public static final int KEY_MFW_MUTE;
    public static final int KEY_MFW_ROLLER_RIGHT;
    public static final int KEY_TPEG;
    public static final int KEY_DMB;
    public static final int KEY_MAP;
    public static final int KEY_INFO;
    public static final int KEY_MFW_AUDIOSOURCE;
    public static final int KEY_MFW_VOLUME_UP;
    public static final int KEY_MFW_VOLUME_DOWN;
    public static final int KEY_MFW_ARROW_B_UP;
    public static final int KEY_MFW_ARROW_B_DOWN;
    public static final int KEY_MFW_HOOK;
    public static final int KEY_HOME;
    public static final int KEY_SMARTPHONE;
    public static final int KEY_ALL;
    public static final int KBD_ALL;
    public static final int KBD_TOUCHSCREEN_FRONT;
    public static final int KBD_MFW;
    public static final int KBD_FCC;

    default public void onPressed(int n) {
    }

    default public void onReleased(int n) {
    }

    default public void onLongPressed(int n) {
    }

    default public void onLongReleased(int n) {
    }

    default public void onUltraLongPressed(int n) {
    }

    default public void onMultiPressed(int n) {
    }

    default public void onRotationLeft(int n) {
    }

    default public void onRotationRight(int n) {
    }
}


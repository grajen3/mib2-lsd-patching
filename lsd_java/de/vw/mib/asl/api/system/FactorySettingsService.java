/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

public interface FactorySettingsService {
    public static final int CONTEXT_AUDIO;
    public static final int CONTEXT_RADIO;
    public static final int CONTEXT_CAR;
    public static final int CONTEXT_CAR_PARKING_ASSISTANCE;
    public static final int CONTEXT_PHONE;
    public static final int CONTEXT_MEDIA;
    public static final int CONTEXT_SDS;
    public static final int CONTEXT_INTERNETBROWSER;
    public static final int CONTEXT_NAVIGATION;
    public static final int CONTEXT_WLAN;
    public static final int CONTEXT_CONNECTIVITY;
    public static final int CONTEXT_SYSTEM;
    public static final int CONTEXT_TVTUNER;
    public static final int CONTEXT_ONLINE;
    public static final int CONTEXT_MIRRORLINK;
    public static final int CONTEXT_PERSONALIZATION;

    default public void resetToFactorySettings(int n) {
    }

    default public void resetAllToFactorySettings() {
    }

    default public void resetAllToFactorySettingsRemoteControlMode() {
    }
}


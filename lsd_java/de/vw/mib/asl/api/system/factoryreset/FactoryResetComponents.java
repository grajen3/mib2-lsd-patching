/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;

public final class FactoryResetComponents {
    public static final FactoryResetComponent FULL = FactoryResetComponent.createRoot("Full");
    public static final FactoryResetComponent AUDIO = FactoryResetComponent.createChild(FULL, "Audio");
    public static final FactoryResetComponent RADIO = FactoryResetComponent.createChild(FULL, "Radio");
    public static final FactoryResetComponent CAR = FactoryResetComponent.createChild(FULL, "Car");
    public static final FactoryResetComponent CAR_PARKING_ASSISTANCE = FactoryResetComponent.createChild(CAR, "Car Parking Assistance");
    public static final FactoryResetComponent PHONE = FactoryResetComponent.createChild(FULL, "Phone");
    public static final FactoryResetComponent MEDIA = FactoryResetComponent.createChild(FULL, "Media");
    public static final FactoryResetComponent SPEECH = FactoryResetComponent.createChild(FULL, "Speech");
    public static final FactoryResetComponent INTERNET_BROWSER = FactoryResetComponent.createChild(FULL, "Internet Browser");
    public static final FactoryResetComponent NAVIGATION = FactoryResetComponent.createChild(FULL, "Navigation");
    public static final FactoryResetComponent WLAN = FactoryResetComponent.createChild(FULL, "WLAN");
    public static final FactoryResetComponent CONNECTIVITY = FactoryResetComponent.createChild(FULL, "Connectivity");
    public static final FactoryResetComponent SYSTEM = FactoryResetComponent.createChild(FULL, "System");
    public static final FactoryResetComponent TVTUNER = FactoryResetComponent.createChild(FULL, "TV Tuner");
    public static final FactoryResetComponent ONLINE = FactoryResetComponent.createChild(FULL, "Online");
    public static final FactoryResetComponent MIRRORLINK = FactoryResetComponent.createChild(FULL, "Mirrorlink");
    public static final FactoryResetComponent APP_CONNECT = FactoryResetComponent.createChild(FULL, "AppConnect");
    public static final FactoryResetComponent EX_BOX = FactoryResetComponent.createChild(FULL, "Ex Box");
    public static final FactoryResetComponent VICS_ETC = FactoryResetComponent.createChild(FULL, "Vics Etc");
    public static final FactoryResetComponent PERSONALIZATION = FactoryResetComponent.createRoot("Personalization");
}


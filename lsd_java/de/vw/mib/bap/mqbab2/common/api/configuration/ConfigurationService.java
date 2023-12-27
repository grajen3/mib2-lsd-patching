/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.configuration;

import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceLanguageChangeListener;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceListener;

public interface ConfigurationService {
    public static final int RADIO_BAND_AM;
    public static final int RADIO_BAND_FM;
    public static final int RADIO_HD_NO_SUBCHANNEL;
    public static final int RADIO_HD_ANALOG_STATION;
    public static final int CONFIGURATION_SERVICE__INSTRUMENT_CLUSTER_DISPLAY_SIZE__BAP__SMALL;
    public static final int CONFIGURATION_SERVICE__INSTRUMENT_CLUSTER_DISPLAY_SIZE__BAP__MEDIUM;
    public static final int CONFIGURATION_SERVICE__INSTRUMENT_CLUSTER_DISPLAY_SIZE__BAP__LARGE;
    public static final int CONFIGURATION_SERVICE__INSTRUMENT_CLUSTER_DISPLAY_SIZE__SYSTEM__SMALL;
    public static final int CONFIGURATION_SERVICE__INSTRUMENT_CLUSTER_DISPLAY_SIZE__SYSTEM__LARGE;

    default public void addLanguageChangeListener(ConfigurationServiceLanguageChangeListener configurationServiceLanguageChangeListener) {
    }

    default public void removeLanguageChangeListener(ConfigurationServiceLanguageChangeListener configurationServiceLanguageChangeListener) {
    }

    default public void addConfigurationListener(ConfigurationServiceListener configurationServiceListener, int[] nArray) {
    }

    default public void removeConfigurationListener(ConfigurationServiceListener configurationServiceListener, int[] nArray) {
    }

    default public boolean isTvFeatureSelected() {
    }

    default public boolean isWLANFeatureSelected() {
    }

    default public boolean isJapanVariantSelected() {
    }

    default public boolean isNARVariantSelected() {
    }

    default public boolean isChinaVariantSelected() {
    }

    default public boolean isNavigationFeatureSelected() {
    }

    default public boolean isSpeechStartupFeatureSelected() {
    }

    default public boolean isSpeechFeatureBuiltIn() {
    }

    default public boolean isSpeechCoded() {
    }

    default public boolean isSpeechFeatureSWAPSelected() {
    }

    default public boolean isSpeechFeatureSelected() {
    }

    default public boolean isExboxFeatureSelected() {
    }

    default public String getCurrentGUILanguage() {
    }

    default public int getAvailableNumberOfSDCardSlots() {
    }

    default public boolean isBAPTunerDABDoubleTunerAvailable() {
    }

    default public int getBAPFsgFcVersion() {
    }

    default public boolean isMapSwitchingFeatureSelected() {
    }

    default public boolean isAppConnectFeatureSelected() {
    }

    default public boolean isCarLifeFeatureSelected() {
    }

    default public boolean isCarPlayFeatureSelected() {
    }

    default public boolean isAndroidAutoFeatureSelected() {
    }

    default public int mapInstrumentClusterDisplaySizeFromBAPToSystem(int n) {
    }

    default public void setInstrumentClusterDisplaySize(int n) {
    }

    default public boolean isHighVariant() {
    }
}


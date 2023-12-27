/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.lsctng.LscListener;

public interface ConfigurationManagerValueSetter
extends ConfigurationManager,
LscListener {
    default public void setSelectableLanguages(String[] stringArray) {
    }

    default public void setDefaultLanguage(String string) {
    }

    default public void setDefaultSkinId(int n) {
    }

    default public void setPersistedLanguage(String string) {
    }

    default public void setLscState(int n) {
    }

    default public void setFallbackLanguages(String[] stringArray) {
    }

    default public void setCurrentGuiLanguage(String string) {
    }

    default public void setCurrentSkinMode(int n) {
    }

    default public void setFeatureFlagValue(int n, boolean bl) {
    }

    default public void setFeatureFlagValue(String string, boolean bl) {
    }

    default public void setOnlineService(boolean bl) {
    }

    default public void setSdsAvailable(boolean bl) {
    }

    default public void setEncodedVehicleType(String string) {
    }

    default public void setMediaCountryCodeHmi(String string) {
    }

    default public void setDynamicTmDebugProbesCfg(int n) {
    }

    default public void setDynamicTmTraceCfg(int[] nArray) {
    }

    default public void setEngineType(int n) {
    }

    default public void setPrimaryFuelType(int n) {
    }

    default public void setSecondaryFuelType(int n) {
    }

    default public void setDriverSide(int n) {
    }

    default public void setSoftwareMuPartNumber(String string) {
    }

    default public void setPartNumber(String string) {
    }

    default public void setOffClockLayout(int n) {
    }

    default public void setDriverDistractionPreventionConfig(byte[] byArray) {
    }
}


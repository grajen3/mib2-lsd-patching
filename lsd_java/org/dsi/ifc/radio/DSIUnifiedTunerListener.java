/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public interface DSIUnifiedTunerListener
extends DSIListener {
    default public void selectStationStatus(int n) {
    }

    default public void updateAudioStatus(int n, int n2) {
    }

    default public void updateDetectedDevice(int n, int n2) {
    }

    default public void updateSelectedStation(UnifiedStation unifiedStation, int n) {
    }

    default public void updateStationList(UnifiedStation[] unifiedStationArray, int n) {
    }

    default public void updateRadioText(UnifiedRadioText unifiedRadioText, int n) {
    }

    default public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText, int n) {
    }

    default public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
    }

    default public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
    }

    default public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
    }

    default public void listMode(int n) {
    }

    default public void stationFollowingMode(int n) {
    }

    default public void updateSoftLinkSwitchStatus(int n, int n2) {
    }

    default public void updateRegModeStatus(int n, int n2) {
    }

    default public void updateDeviceUsageStatus(int n, int n2) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }
}


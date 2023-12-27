/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.TunerData;

public interface DSINavServicesAPIListener
extends DSIListener {
    default public void initiatePhoneCallToADBEntry(String string, String string2) {
    }

    default public void updateLanguage(String string, int n) {
    }

    default public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    default public void updateIconDirectory(String string, int n) {
    }

    default public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
    }

    default public void updateNavigationState(int n, int n2) {
    }

    default public void phoneDialNumber(String string, String string2) {
    }

    default public void audioRequest(boolean bl) {
    }

    default public void createExportFile(int n, boolean bl) {
    }

    default public void importFile(int n, boolean bl) {
    }

    default public void resetToFactorySettingsResult() {
    }

    default public void deleteCustomerDataResult() {
    }

    default public void setBrowserURL(String string) {
    }

    default public void prepareAndPlayTTS2Announcement(String string) {
    }

    default public void abortTTS2Announcement() {
    }

    default public void updateCurrentPosition(float f2, float f3, int n) {
    }

    default public void efiLinkSelectedResult(boolean bl) {
    }

    default public void selectRemoteSearchLocationResult(AddressData[] addressDataArray) {
    }

    default public void checkLicense(int n) {
    }

    default public void checkDataConnection() {
    }

    default public void requestRrdForLocationDataResult(int n, String[] stringArray, int[] nArray) {
    }
}


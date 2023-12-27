/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public interface DSIRadioDataC {
    default public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
    }

    default public void requestRadioStationLogos(RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
    }

    default public void requestDynamicDatabaseAlteration(RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
    }

    default public void requestCountryListUpdate(int n) {
    }

    default public void requestDatabaseVersionInfo(int n) {
    }

    default public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
    }

    default public void requestCountryRegionData(int n) {
    }

    default public void requestCountryRegionTranslationData(int n, String string, int n2) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}


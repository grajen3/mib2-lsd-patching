/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public interface DSIRadioDataReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
    }

    default public void responseRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
    }

    default public void responseDynamicDatabaseAlteration(int n, int n2) {
    }

    default public void responseCountryList(int[] nArray, int n) {
    }

    default public void responseDatabaseVersionInfo(int n, int n2, int n3, String string, int n4, int n5, int n6) {
    }

    default public void updateDatabaseState(int n, int n2) {
    }

    default public void responsePersistStationLogos(int n, int n2) {
    }

    default public void updateRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
    }

    default public void responseCountryRegionData(CountryRegionData[] countryRegionDataArray, int n) {
    }

    default public void responseCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
    }

    default public void responsePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
    }

    default public void updatePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
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

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


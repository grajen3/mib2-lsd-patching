/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public interface DSIRadioData
extends DSIBase {
    public static final String VERSION;
    public static final int RT_REQUESTRADIOSTATIONDATA;
    public static final int RT_REQUESTRADIOSTATIONLOGOS;
    public static final int RT_REQUESTDYNAMICDATABASEALTERATION;
    public static final int RT_REQUESTCOUNTRYLISTUPDATE;
    public static final int RT_REQUESTDATABASEVERSIONINFO;
    public static final int RT_REQUESTPERSISTSTATIONLOGOS;
    public static final int RT_REQUESTCOUNTRYREGIONDATA;
    public static final int RT_REQUESTCOUNTRYREGIONTRANSLATIONDATA;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_RESPONSERADIOSTATIONDATA;
    public static final int RP_RESPONSERADIOSTATIONLOGOS;
    public static final int RP_RESPONSEDYNAMICDATABASEALTERATION;
    public static final int RP_RESPONSECOUNTRYLIST;
    public static final int RP_RESPONSEDATABASEVERSIONINFO;
    public static final int RP_RESPONSEPERSISTSTATIONLOGOS;
    public static final int RP_RESPONSECOUNTRYREGIONDATA;
    public static final int RP_RESPONSECOUNTRYREGIONTRANSLATIONDATA;
    public static final int RP_RESPONSEPERSISTSTATIONLOGOSWITHCHANGEDURLS;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int ATTR_DATABASESTATE;
    public static final int ATTR_RADIOSTATIONLOGOS;
    public static final int ATTR_PROFILESTATE;
    public static final int ATTR_PERSISTSTATIONLOGOSWITHCHANGEDURLS;
    public static final int DATABASESTATE_DB_DOES_NOT_EXISTS;
    public static final int DATABASESTATE_DB_NOT_AVAILABLE;
    public static final int DATABASESTATE_DB_AVAILABLE;
    public static final int DATABASESTATE_DB_VERSION_UPDATE;
    public static final int DATABASEALTERATION_DELETE_STATION;
    public static final int DATABASEALTERATION_DELETE_LOGO;
    public static final int DATABASEALTERATION_DELETE_STATION_AND_LOGO;
    public static final int DATABASEALTERATION_ADD_STATION;
    public static final int DATABASEALTERATION_ADD_LOGO;
    public static final int DATABASEALTERATION_ADD_STATION_AND_LOGO;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_STATION;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_LOGO;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_STATION_AND_LOGO;
    public static final int DATABASEALTERATIONRESPONSE_ADD_STATION;
    public static final int DATABASEALTERATIONRESPONSE_ADD_LOGO;
    public static final int DATABASEALTERATIONRESPONSE_ADD_STATION_AND_LOGO;
    public static final int DATABASEALTERATIONRESPONSE_DB_DOES_NOT_EXISTS;
    public static final int DATABASEALTERATIONRESPONSE_DB_NOT_AVAILABLE;
    public static final int DATABASEALTERATIONRESPONSE_DB_VERSION_UPDATE;
    public static final int LOGOPRIORITY_MANUAL_LOGO;
    public static final int LOGOPRIORITY_NEWEST_LOGO;
    public static final int LOGOPRIORITY_STATIC_LOGO;
    public static final int LOGOPRIORITY_ALL_LOGOS;
    public static final int LOGOPRIORITY_GENERIC_LOGO;
    public static final int REQUESTPERSISTSTALOGOS_REQUEST_PROCESSED;
    public static final int REQUESTPERSISTSTALOGOS_REQUEST_FAILED;
    public static final int PERSISTSTATIONLOGOSTYPE_PRESETS;
    public static final int PERSISTSTATIONLOGOSTYPE_CURRENT_STATION;
    public static final int PERSISTSTATIONLOGOSTYPE_STATION_LIST;

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
}


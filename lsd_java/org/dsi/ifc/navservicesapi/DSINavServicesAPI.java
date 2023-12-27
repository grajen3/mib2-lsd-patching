/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navservicesapi.ADBPersonalData;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.ProfileInfo;
import org.dsi.ifc.navservicesapi.TryMatchLocationData;

public interface DSINavServicesAPI
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_LANGUAGE;
    public static final int ATTR_AVAILABLELANGUAGES;
    public static final int ATTR_ICONDIRECTORY;
    public static final int ATTR_RECEIVABLESTATIONS;
    public static final int ATTR_NAVIGATIONSTATE;
    public static final int ATTR_CURRENTPOSITION;
    public static final int NAVSTATE_NAVCORE_STATE_NOT_READY;
    public static final int NAVSTATE_NAVCORE_STATE_READY;
    public static final int ADBPROFILE_GLOBAL_PROFILE;
    public static final int ADBPROFILE_PRIVATE_PROFILE_1;
    public static final int ADBPROFILE_PRIVATE_PROFILE_2;
    public static final int ADBPROFILE_PRIVATE_PROFILE_3;
    public static final int ADBPROFILE_PRIVATE_PROFILE_4;
    public static final int ADBTYPE_ADDRESS_TYPE_PRIVATE;
    public static final int ADBTYPE_ADDRESS_TYPE_BUSINESS;
    public static final int EFILINKCONTEXT_NAVIGATION;
    public static final int EFILINKCONTEXT_REMOTE_HMI;
    public static final int DATACONNECTION_ESTABLISHED;
    public static final int DATACONNECTION_ABORTED;
    public static final int DATACONNECTION_UNINITIALISED;
    public static final int DATACONNECTION_ERROR;
    public static final int RT_AUDIOSTART;
    public static final int RT_AUDIOSTOP;
    public static final int RT_SETDISTANCEUNIT;
    public static final int RT_SETLANGUAGE;
    public static final int RT_CREATEEXPORTFILE;
    public static final int RT_IMPORTFILE;
    public static final int RT_SETENGINEERINGMENUSTATE;
    public static final int RT_RESETTOFACTORYSETTINGS;
    public static final int RT_DELETECUSTOMERDATA;
    public static final int RT_INITIATEPHONECALLTOADBENTRYRESULT;
    public static final int RT_NAVIGATETO;
    public static final int RT_DELETEPROFILEDATA;
    public static final int RT_SETPROFILEINFO;
    public static final int RT_TTS2ANNOUNCEMENTFINISHED;
    public static final int RT_STARTROUTEGUIDANCE;
    public static final int RT_EFILINKSELECTED;
    public static final int RT_SELECTREMOTESEARCHLOCATION;
    public static final int RT_CHECKLICENSERESULT;
    public static final int RT_CHECKDATACONNECTIONRESULT;
    public static final int RT_LITRYMATCHLOCATION;
    public static final int RT_REQUESTRRDFORLOCATIONDATA;
    public static final int RP_CREATEEXPORTFILE;
    public static final int RP_IMPORTFILE;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT;
    public static final int RP_DELETECUSTOMERDATARESULT;
    public static final int RP_EFILINKSELECTEDRESULT;
    public static final int RP_SELECTREMOTESEARCHLOCATIONRESULT;
    public static final int RP_REQUESTRRDFORLOCATIONDATARESULT;
    public static final int IN_PHONEDIALNUMBER;
    public static final int IN_AUDIOREQUEST;
    public static final int IN_INITIATEPHONECALLTOADBENTRY;
    public static final int IN_SETBROWSERURL;
    public static final int IN_PREPAREANDPLAYTTS2ANNOUNCEMENT;
    public static final int IN_ABORTTTS2ANNOUNCEMENT;
    public static final int IN_CHECKLICENSE;
    public static final int IN_CHECKDATACONNECTION;

    default public void setProfileInfo(ProfileInfo[] profileInfoArray, int n) {
    }

    default public void navigateTo(String string, int n, ADBPersonalData aDBPersonalData, boolean bl, AddressData[] addressDataArray) {
    }

    default public void initiatePhoneCallToADBEntryResult(String string, boolean bl) {
    }

    default public void deleteProfileData(int n) {
    }

    default public void audioStart() {
    }

    default public void audioStop() {
    }

    default public void setDistanceUnit(int n) {
    }

    default public void setLanguage(String string) {
    }

    default public void createExportFile(String string, int n) {
    }

    default public void importFile(String string, int n) {
    }

    default public void setEngineeringMenuState(int n) {
    }

    default public void resetToFactorySettings() {
    }

    default public void deleteCustomerData() {
    }

    default public void efiLinkSelected(String string, int n) {
    }

    default public void selectRemoteSearchLocation() {
    }

    default public void tts2AnnouncementFinished(int n) {
    }

    default public void startRouteGuidance(int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void checkLicenseResult(int n, int n2, long l) {
    }

    default public void checkDataConnectionResult(int n) {
    }

    default public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
    }

    default public void requestRrdForLocationData(int n, TryMatchLocationData[] tryMatchLocationDataArray) {
    }
}


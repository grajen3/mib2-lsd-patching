/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public interface DSISDARSTunerListener
extends DSIListener {
    default public void updateElectronicSerialCode(String string, int n) {
    }

    default public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
    }

    default public void updateSignalQuality(SignalQuality signalQuality, int n) {
    }

    default public void updateSelectedStation(StationInfo stationInfo, int n) {
    }

    default public void updateStationList(StationInfo[] stationInfoArray, int n) {
    }

    default public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
    }

    default public void informationRadioText(RadioText radioText) {
    }

    default public void informationRadioText2(RadioText[] radioTextArray) {
    }

    default public void updateStaticTaggingInfo(String string, String string2, int n) {
    }

    default public void updateDetectedDevice(int n, int n2) {
    }

    default public void selectStationStatus(int n) {
    }

    default public void responseTime(DateTime dateTime) {
    }

    default public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
    }

    default public void responseEPGDescription(EPGDescription ePGDescription) {
    }

    default public void updateAvailability(int n, int n2) {
    }

    default public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
    }

    default public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
    }

    default public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
    }

    default public void informationChannelArt(ImageInformation[] imageInformationArray) {
    }

    default public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
    }

    default public void informationAlbumArt(ImageInformation[] imageInformationArray) {
    }

    default public void informationGenreArt(ImageInformation[] imageInformationArray) {
    }

    default public void informationStudioArt(ImageInformation[] imageInformationArray) {
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


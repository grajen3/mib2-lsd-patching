/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.sdars;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public final class DSISDARSTunerComplexAnalyzer
extends ComplexAnalyzer
implements DSISDARSTunerListener {
    @Override
    public void selectStationStatus(int n) {
        if (n == 2 || n == 3 || n == 4 || n == 5) {
            this.finished = true;
        }
    }

    @Override
    public void updateAvailability(int n, int n2) {
    }

    @Override
    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
    }

    public void updateRadioText(RadioText radioText, int n) {
    }

    @Override
    public void updateSelectedStation(StationInfo stationInfo, int n) {
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
    }

    @Override
    public void updateSignalQuality(SignalQuality signalQuality, int n) {
    }

    @Override
    public void updateStationList(StationInfo[] stationInfoArray, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2, int n) {
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
    }

    @Override
    public void responseTime(DateTime dateTime) {
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
    }

    public void updateRadioText2(RadioText[] radioTextArray, int n) {
    }

    @Override
    public void informationRadioText(RadioText radioText) {
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
    }

    @Override
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
    }

    @Override
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
    }

    @Override
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationAlbumArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationGenreArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationStudioArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }
}


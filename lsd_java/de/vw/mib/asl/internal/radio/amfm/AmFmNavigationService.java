/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.api.navigation.traffic.INavigationTunerData;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListenerAdapter;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import org.dsi.ifc.radio.Station;

public final class AmFmNavigationService
extends NavigationTrafficListenerAdapter {
    @Override
    public void updateReceivableStations(INavigationTunerData[] iNavigationTunerDataArray, boolean bl) {
        try {
            StationNameFreqList stationNameFreqList;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AmFmNavigationService - updateReceivableStations() - FEAT_IS_TUNER_STATION_NAME_FROM_NAV_DB = ").append(ServiceManager.configManagerDiag.isFeatureFlagSet(423)).append(", flag = ").append(bl).log();
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != iNavigationTunerDataArray && bl && null != (stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(RadioData.getAmfmDatabase().getCurrentStation());
                RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(RadioData.getAmfmDatabase().getCurrentFMStation());
                if (null != AmFmStationListFM.currentFmStationList && !RadioData.getAmfmDatabase().getStationListViewIsOpen()) {
                    RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateFmListToSpeech(this.getJapanStationsWithNames(AmFmStationListFM.currentFmStationList));
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestNavigationStationData() {
        try {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(423)) {
                NavigationTrafficService navigationTrafficService;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmNavigationService - requestNavigationStationData() - FEAT_IS_TUNER_STATION_NAME_FROM_NAV_DB == true").log();
                }
                if (null == (navigationTrafficService = RadioServiceManager.getServiceManager().getNavigationTrafficService())) {
                    ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmNavigationService - requestNavigationStationData() - null == navigationTrafficService").log();
                } else {
                    navigationTrafficService.requestReceivableStations();
                }
            } else if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmNavigationService - requestNavigationStationData() - FEAT_IS_TUNER_STATION_NAME_FROM_NAV_DB == false").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    AmFmStation[] getJapanStationsWithNames(Station[] stationArray) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("HsmTarget - updateJapanStationsNamesToSpeech() ").log();
            }
            AmFmStation[] amFmStationArray = null;
            StationNameFreqList stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList();
            if (null != stationArray && null != stationNameFreqList) {
                amFmStationArray = new AmFmStation[stationArray.length];
                for (int i2 = 0; i2 < stationArray.length; ++i2) {
                    if (null == stationArray[i2]) continue;
                    amFmStationArray[i2] = new AmFmStation(stationArray[i2]);
                    String string = stationNameFreqList.getStationName(amFmStationArray[i2].getFrequency());
                    if (string.length() > 0) {
                        amFmStationArray[i2].setName(string);
                    }
                    if (!ServiceManager.logger.isTraceEnabled(128)) continue;
                    ServiceManager.logger.trace(128).append(new StringBuffer().append("japanFmStationListWithNames[").append(i2).append("] = ").append(amFmStationArray[i2].toString()).toString()).log();
                }
            }
            return amFmStationArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.api.vicsetc.ASLVICSETCAsiaTrafficMenuListenerAdapter;
import de.vw.mib.asl.api.vicsetc.ITunerData;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import org.dsi.ifc.radio.Station;

public class AmFmASLVICSETCAsiaTrafficMenuListenerAdapter
extends ASLVICSETCAsiaTrafficMenuListenerAdapter {
    @Override
    public void updateReceivableStations(ITunerData[] iTunerDataArray, boolean bl) {
        try {
            StationNameFreqList stationNameFreqList;
            ServiceManager.logger.info(128).append("AmFmNavigationService - updateReceivableStations() - FEAT_IS_TUNER_STATION_NAME_FROM_NAV_DB = ").append(ServiceManager.configManagerDiag.isFeatureFlagSet(423)).append(", flag = ").append(bl).log();
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != iTunerDataArray && bl && null != (stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                stationNameFreqList.add(iTunerDataArray);
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


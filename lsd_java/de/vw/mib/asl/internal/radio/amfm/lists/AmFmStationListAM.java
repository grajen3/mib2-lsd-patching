/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationList;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.radio.Station;

public class AmFmStationListAM
extends AmFmStationList {
    private HashSet amSpeechSet = null;
    public static Station[] currentAmStationList = null;

    public AmFmStationListAM() {
        super(FrequencyHDComparatorChain.INSTANCE);
    }

    public void setMWStations(Station[] stationArray) {
        this.amSpeechSet = new HashSet();
        this.stationList.clear();
        for (int i2 = 0; i2 < stationArray.length; ++i2) {
            String string;
            StationNameFreqList stationNameFreqList;
            if (stationArray[i2].waveband != 3) continue;
            AmFmStation amFmStation = new AmFmStation(stationArray[i2]);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList()) && (string = stationNameFreqList.getStationName(amFmStation.getFrequency())).length() > 0) {
                amFmStation.setName(string);
            }
            this.stationList.add(amFmStation);
        }
    }

    public HashSet getAmSpeechSet() {
        return this.amSpeechSet;
    }

    public void setLWStations(Station[] stationArray) {
        for (int i2 = 0; i2 < stationArray.length; ++i2) {
            if (stationArray[i2].waveband != 4) continue;
            this.stationList.add(new AmFmStation(stationArray[i2]));
        }
    }

    private void clearMW() {
        Iterator iterator = this.getStationListIterator();
        if (null != iterator) {
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    if (amFmStation == null || amFmStation.getFrequency() < 530) continue;
                    iterator.remove();
                    continue;
                }
                if (amFmStation == null || amFmStation.getFrequency() < 531) continue;
                iterator.remove();
            }
        }
    }

    private void clearLW() {
        Iterator iterator = this.getStationListIterator();
        if (null != iterator) {
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (amFmStation == null || amFmStation.getFrequency() >= 531) continue;
                iterator.remove();
            }
        }
    }

    @Override
    public void toggleStation(int n) {
        try {
            int n2 = -1;
            if (null == this.stationList || this.stationList.isEmpty()) {
                return;
            }
            Object[] objectArray = this.getListCopyAsArray();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentAmStation();
            switch (n) {
                case 0: {
                    for (int i2 = 0; i2 < objectArray.length; ++i2) {
                        if (((AmFmStation)objectArray[i2]).getFrequency() <= amFmStation.getFrequency()) continue;
                        n2 = i2;
                        break;
                    }
                    if (n2 != -1) break;
                    n2 = 0;
                    break;
                }
                case 1: {
                    for (int i3 = objectArray.length - 1; i3 > -1; --i3) {
                        if (((AmFmStation)objectArray[i3]).getFrequency() >= amFmStation.getFrequency()) continue;
                        n2 = i3;
                        break;
                    }
                    if (n2 != -1) break;
                    n2 = objectArray.length - 1;
                    break;
                }
                default: {
                    return;
                }
            }
            if (n2 > -1 && n2 < objectArray.length && objectArray[n2] != null) {
                AmFmDsiApi.selectStation((AmFmStation)objectArray[n2]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateStationListToHMI() {
        AmFmUIStationList amFmUIStationList = AmFmFactory.getInstanceEUStationListViewWalker();
        amFmUIStationList.loadCurrentStationList();
        AmFmFactory.getAslAmfmModelController().updateAmStationList((AMStationInfoCollector[])amFmUIStationList.getStationInfoCollectors(), amFmUIStationList.getCurrentIndex(), RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()));
    }
}


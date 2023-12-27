/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationListBase;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Comparator;
import java.util.Iterator;
import org.dsi.ifc.radio.Station;

public class AmFmUIStationListNar
extends AmFmUIStationListBase {
    private AmFmStationListFM tempFmList;
    private AmFmStation previousFmStation = null;

    private AmFmStation getPreviousFmStation() {
        this.previousFmStation = new AmFmStation();
        return this.previousFmStation;
    }

    @Override
    public Comparator getFmComparator() {
        return FmPiFrequencyHdComparatorChain.INSTANCE;
    }

    @Override
    public void setFmComparator() {
        this.fmComparator = FmPiFrequencyHdComparatorChain.INSTANCE;
    }

    @Override
    public void loadCurrentStationList(AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (amFmStation.getWaveband() == 1) {
                this.tempFmList = new AmFmStationListFM(this.getFmComparator());
                this.tempFmList.add(RadioData.getAmfmDatabase().getAslStationListFM().getCompleteStationListForNAR());
                this.loadCurrentStationListFm(amFmStation);
                this.getPreviousFmStation().copyOf(amFmStation);
            } else if (amFmStation.getWaveband() == 3 || amFmStation.getWaveband() == 4) {
                this.loadCurrentStationListAm(amFmStation);
            } else {
                ServiceManager.logger.warn(128).append("Unhandled Waveband found in loadCurrentStationList(): ").append(this.type).log();
            }
        } else if (RadioCurrentWaveband.isFm()) {
            this.stationInfoCollector = new FMStationInfoCollector[0];
            this.subStationInfoCollector = new FMStationInfoCollector[0];
        } else if (RadioCurrentWaveband.isAm()) {
            this.stationInfoCollector = new AMStationInfoCollector[0];
        }
    }

    @Override
    public void loadCurrentStationListFm(AmFmStation amFmStation) {
        int n;
        Object object;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" Load UI station list NAR  with station: ").append(amFmStation.getAsDSIStation().toString()).log();
        }
        this.stationInfoCollector = new FMStationInfoCollector[0];
        this.subStationInfoCollector = new FMStationInfoCollector[0];
        this.currentIndex = -1;
        this.currentSubListIndex = -1;
        this.type = 1;
        this.frozenFmList = new AmFmStationListFM();
        if (this.previousFmStation != null && this.previousFmStation.getFrequency() != amFmStation.getFrequency()) {
            ListManager.getGenericASLList(3094).updateList(this.subStationInfoCollector);
        }
        if (this.tempFmList.containsStationWithFrequencyAndServiceID(amFmStation.getFrequency(), amFmStation.getServiceId())) {
            object = amFmStation;
            if (amFmStation.getServiceId() > 1) {
                object = this.tempFmList.getByFrequencyAndSubChannel(amFmStation.getFrequency(), 1);
            }
            if ((n = this.tempFmList.getSubServiceListForMPS((AmFmStation)object).size()) > 0) {
                this.loadCurrentSubStationList(amFmStation);
            }
        } else if (amFmStation.getServiceId() <= 1) {
            this.tempFmList.add(amFmStation);
            this.currentSubListIndex = -1;
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(" Added new MPS station to Station List : ").append(amFmStation.getAsDSIStation().toString()).log();
            }
        } else {
            object = new AmFmStation(amFmStation);
            ((AmFmStation)object).setServiceId(1);
            this.tempFmList.add((AmFmStation)object);
            this.loadCurrentSubStationList(amFmStation);
        }
        if (RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter()) {
            this.frozenFmList.add(this.tempFmList.getMPSListForNARWithHdFilter());
        } else {
            this.frozenFmList.add(this.tempFmList.getMPSListForNAR());
        }
        this.activeStationIndex = this.frozenFmList.indexOfWithFrequency(amFmStation);
        if (amFmStation.getServiceId() <= 1) {
            this.currentIndex = this.activeStationIndex;
            AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.currentIndex);
            ListManager.getGenericASLList(3093).setActiveIndex(this.currentIndex);
        }
        this.stationInfoCollector = new FMStationInfoCollector[this.frozenFmList.size()];
        object = this.frozenFmList.getStationListIterator();
        n = 0;
        while (object.hasNext()) {
            AmFmStation amFmStation2 = (AmFmStation)object.next();
            this.stationInfoCollector[n] = new FMStationInfoCollector(amFmStation2);
            ++n;
        }
    }

    @Override
    public void loadCurrentStationListAm(AmFmStation amFmStation) {
        this.stationInfoCollector = new AMStationInfoCollector[0];
        this.type = amFmStation.getWaveband();
        this.frozenAmList = new AmFmStationListAM();
        this.currentIndex = -1;
        if (RadioData.getAmfmDatabase().getAslStationListAM().getByFrequency(amFmStation.getFrequency()) == null) {
            this.frozenAmList.add(amFmStation);
        }
        this.frozenAmList.add(RadioData.getAmfmDatabase().getAslStationListAM().getListCopy());
        this.currentIndex = this.activeStationIndex = this.frozenAmList.indexOfWithFrequency(amFmStation);
        this.stationInfoCollector = new AMStationInfoCollector[this.frozenAmList.size()];
        Iterator iterator = this.frozenAmList.getStationListIterator();
        int n = 0;
        while (iterator.hasNext()) {
            AmFmStation amFmStation2 = (AmFmStation)iterator.next();
            if (amFmStation2.equalsByFreq(amFmStation)) {
                this.currentIndex = n;
            }
            this.stationInfoCollector[n] = new AMStationInfoCollector(amFmStation2);
            ++n;
        }
    }

    @Override
    public void loadCurrentSubStationList(AmFmStation amFmStation) {
        Object object;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" Load UI sub station list NAR with station: ").append(amFmStation.getAsDSIStation().toString()).log();
        }
        this.subStationInfoCollector = new FMStationInfoCollector[0];
        this.currentSubListIndex = -1;
        this.type = 1;
        this.hmiFmSubStationList = new AmFmStationListFM();
        if (this.tempFmList.containsStationWithFrequencyAndServiceID(amFmStation.getFrequency(), amFmStation.getServiceId())) {
            object = amFmStation;
            if (amFmStation.getServiceId() > 1) {
                object = this.tempFmList.getByFrequencyAndSubChannel(amFmStation.getFrequency(), 1);
            }
            this.hmiFmSubStationList.add(this.tempFmList.getSubServiceListForMPS((AmFmStation)object));
        } else {
            this.hmiFmSubStationList.add(amFmStation);
            this.tempFmList.add(amFmStation);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(" Added new SPS station to Station List : ").append(amFmStation.getAsDSIStation().toString()).log();
            }
        }
        this.subStationInfoCollector = new FMStationInfoCollector[this.hmiFmSubStationList.size()];
        object = this.hmiFmSubStationList.getStationListIterator();
        int n = 0;
        while (object.hasNext()) {
            AmFmStation amFmStation2 = (AmFmStation)object.next();
            if (amFmStation2.equalsByFreq(amFmStation)) {
                this.currentSubListIndex = n;
                AmFmFactory.getAslAmfmModelController().updateFmActiveSubStationIndex(this.currentSubListIndex);
                ListManager.getGenericASLList(3094).setActiveIndex(this.currentSubListIndex);
            }
            this.subStationInfoCollector[n] = new FMStationInfoCollector(amFmStation2);
            ++n;
        }
    }

    @Override
    public void tuneStation(int n) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Tune station with Index : ").append(n).log();
        }
        if (n >= 0 && n < this.stationInfoCollector.length) {
            if (RadioCurrentWaveband.isFm()) {
                if (n != this.activeStationIndex) {
                    if (this.activeStationIndex > -1) {
                        this.stationInfoCollector[this.activeStationIndex].station.setHDStatus(1);
                    }
                    this.loadCurrentSubStationList(this.stationInfoCollector[n].station);
                    ListManager.getGenericASLList(3094).updateList(this.subStationInfoCollector);
                } else {
                    this.subStationInfoCollector[this.currentSubListIndex].station.setHDStatus(1);
                }
            }
            this.currentIndex = n;
            this.currentSubListIndex = -1;
            this.activeStationIndex = n;
            this.updateIndices(this.stationInfoCollector[this.currentIndex].station);
            AmFmDsiApi.selectStation(this.stationInfoCollector[this.currentIndex].station);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" ^^^^^^^^^^^^^TUNED STATION : ").append(this.stationInfoCollector[this.currentIndex].station.getFrequency()).log();
            }
        } else {
            ServiceManager.logger.error(128).append("Invalid newListIndex, val=").append(n).append(",Listlen=").append(this.stationInfoCollector.length).log();
        }
    }

    @Override
    public void tuneSubStation(int n) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Tune sub station with Index : ").append(n).log();
        }
        if (n >= 0 && n < this.subStationInfoCollector.length) {
            if (this.currentSubListIndex > -1) {
                this.subStationInfoCollector[this.currentSubListIndex].station.setHDStatus(1);
            } else {
                this.stationInfoCollector[this.currentIndex].station.setHDStatus(1);
            }
            this.currentSubListIndex = n;
            this.currentIndex = -1;
            this.updateSubIndices(this.subStationInfoCollector[this.currentSubListIndex].station);
            AmFmDsiApi.selectStation(this.subStationInfoCollector[this.currentSubListIndex].station);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" ^^^^^^^^^^^^^TUNED SPS : ").append(this.subStationInfoCollector[this.currentSubListIndex].station.getFrequency()).append(" ServiceID : ").append(this.subStationInfoCollector[this.currentSubListIndex].station.getServiceId()).log();
            }
        }
    }

    @Override
    public void tuneStation(AmFmStation amFmStation) {
        AmFmStation amFmStation2;
        if (null == amFmStation) {
            return;
        }
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Tune to Station with Frequency : ").append(amFmStation.getFrequency()).append(" ServiceID : ").append(amFmStation.getServiceId()).log();
        }
        if (amFmStation.isFM() && null != (amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation()) && (amFmStation.getFrequency() != amFmStation2.getFrequency() || amFmStation.getServiceId() != amFmStation2.getServiceId())) {
            this.loadCurrentSubStationList(amFmStation);
            ListManager.getGenericASLList(3094).updateList(this.subStationInfoCollector);
        }
        this.currentSubListIndex = -1;
        this.updateIndices(amFmStation);
        AmFmDsiApi.selectStation(amFmStation);
    }

    @Override
    public void tuneSubStation(AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Tune to  Sub Station with Frequency : ").append(amFmStation.getFrequency()).append(" ServiceID : ").append(amFmStation.getServiceId()).log();
        }
        boolean bl = false;
        AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
        if (null == amFmStation2) {
            return;
        }
        if (amFmStation.getFrequency() != amFmStation2.getFrequency() || amFmStation.getServiceId() != amFmStation2.getServiceId()) {
            this.loadCurrentSubStationList(amFmStation);
            this.activeStationIndex = this.frozenFmList.indexOfWithFrequency(amFmStation);
            bl = true;
        }
        this.currentIndex = -1;
        this.updateSubIndices(amFmStation);
        AmFmDsiApi.selectStation(amFmStation);
        if (bl) {
            ListManager.getGenericASLList(3094).updateList(this.subStationInfoCollector);
        }
    }

    private void updateIndices(AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR update Indices : ").log();
        }
        long l = -1L;
        int n = -1;
        if (amFmStation != null) {
            l = RadioUtil.computeUniqueID(amFmStation);
            n = AmFmPresetApi.getIndexOfPreset(amFmStation);
        }
        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(l, n);
        if (this.type == 1) {
            ListManager.getGenericASLList(3093).setActiveIndex(this.currentIndex);
            AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.activeStationIndex);
            ListManager.getGenericASLList(3094).setActiveIndex(this.currentSubListIndex);
            AmFmFactory.getAslAmfmModelController().updateFmActiveSubStationIndex(this.currentSubListIndex);
        } else if (this.type == 3 || this.type == 4) {
            ListManager.getGenericASLList(1452).setActiveIndex(this.currentIndex);
            AmFmFactory.getAslAmfmModelController().updateAmActiveStationIndex(this.currentIndex);
        } else {
            ServiceManager.logger.warn(128).append("Unhandled Waveband found in updateIndices(): ").append(this.type).log();
        }
    }

    private void updateSubIndices(AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Update sub indices : ").log();
        }
        long l = -1L;
        int n = -1;
        if (amFmStation != null) {
            l = RadioUtil.computeUniqueID(amFmStation);
            n = AmFmPresetApi.getIndexOfPreset(amFmStation);
        }
        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(l, n);
        ListManager.getGenericASLList(3093).setActiveIndex(this.activeStationIndex);
        AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.activeStationIndex);
        ListManager.getGenericASLList(3094).setActiveIndex(this.currentSubListIndex);
        AmFmFactory.getAslAmfmModelController().updateFmActiveSubStationIndex(this.currentSubListIndex);
    }

    @Override
    public AmFmStation getCurrentStation() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR current station : ").log();
        }
        if (this.currentSubListIndex >= 0 && this.currentSubListIndex < this.subStationInfoCollector.length && RadioCurrentWaveband.isFm()) {
            return this.subStationInfoCollector[this.currentSubListIndex].station;
        }
        if (this.currentIndex >= 0 && this.currentIndex < this.stationInfoCollector.length) {
            return this.stationInfoCollector[this.currentIndex].station;
        }
        if (this.activeStationIndex >= 0 && this.activeStationIndex < this.stationInfoCollector.length) {
            return this.stationInfoCollector[this.activeStationIndex].station;
        }
        return null;
    }

    public boolean updateStation(AmFmStation amFmStation, boolean bl) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Update Station : ").append(amFmStation.toString()).log();
            }
            if (null == amFmStation) {
                return false;
            }
            boolean bl2 = false;
            if (amFmStation.isAM()) {
                this.activeStationIndex = this.frozenAmList.indexOfWithFrequency(amFmStation);
            } else if (amFmStation.isFM()) {
                this.activeStationIndex = this.frozenFmList.indexOfWithFrequency(amFmStation);
            }
            if (this.stationInfoCollector != null) {
                this.currentIndex = this.activeStationIndex;
                if (this.stationInfoCollector[this.currentIndex].station.equals(amFmStation)) {
                    this.stationInfoCollector[this.currentIndex].station.copyOf(amFmStation);
                    if (amFmStation.isFM()) {
                        AmFmFactory.getAslAmfmModelController().updateFmStationListItem((FMStationInfoCollector)this.stationInfoCollector[this.currentIndex], this.currentIndex, this.activeStationIndex);
                        ListManager.getGenericASLList(1270).updateListItem(this.tempFmList.indexOf(amFmStation), this.stationInfoCollector[this.currentIndex].station);
                    } else if (amFmStation.isAM()) {
                        AmFmFactory.getAslAmfmModelController().updateAmStationListItem((AMStationInfoCollector)this.stationInfoCollector[this.currentIndex], this.currentIndex);
                        ListManager.getGenericASLList(1270).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex].station);
                    }
                } else {
                    bl2 = true;
                }
                AmFmPresetApi.syncFmName(amFmStation);
                AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
                if (null != amFmStation2) {
                    int n = amFmStation2.getWaveband();
                    int n2 = AMFMUtil.convertDSIBandConstantToHMIBandConstant(n);
                    AmFmPresetApi.autoCompare(n2, amFmStation2);
                }
            }
            return bl2;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    @Override
    public boolean updateSubStation(AmFmStation amFmStation) {
        try {
            boolean bl = false;
            if (null == amFmStation) {
                return bl;
            }
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Update Sub Station : ").append(amFmStation.toString()).log();
            }
            if (amFmStation.isAM()) {
                this.activeStationIndex = this.frozenAmList.indexOfWithFrequency(amFmStation);
            } else if (amFmStation.isFM()) {
                this.activeStationIndex = this.frozenFmList.indexOfWithFrequency(amFmStation);
            }
            if (this.subStationInfoCollector != null) {
                if (this.currentSubListIndex < 0) {
                    this.loadCurrentSubStationList(amFmStation);
                }
                if (this.subStationInfoCollector[this.currentSubListIndex].station.equals(amFmStation)) {
                    this.subStationInfoCollector[this.currentSubListIndex].station.setName(amFmStation.getName());
                    this.subStationInfoCollector[this.currentSubListIndex].station.setShortNameHD(amFmStation.getShortNameHD());
                    this.subStationInfoCollector[this.currentSubListIndex].station.setLongNameHD(amFmStation.getLongNameHD());
                    this.subStationInfoCollector[this.currentSubListIndex].station.setServiceId(amFmStation.getServiceId());
                    this.subStationInfoCollector[this.currentSubListIndex].station.setHD(amFmStation.isHD());
                    this.subStationInfoCollector[this.currentSubListIndex].station.setRDS(amFmStation.isRds());
                    if (amFmStation.isFM()) {
                        AmFmFactory.getAslAmfmModelController().updateFmSubStationListItem((FMStationInfoCollector)this.subStationInfoCollector[this.currentSubListIndex], this.currentSubListIndex);
                        ListManager.getGenericASLList(1270).updateListItem(this.tempFmList.indexOf(amFmStation), this.subStationInfoCollector[this.currentSubListIndex].station);
                    }
                } else {
                    bl = true;
                }
                AmFmPresetApi.syncFmName(amFmStation);
                AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
                if (null != amFmStation2) {
                    int n = amFmStation2.getWaveband();
                    int n2 = AMFMUtil.convertDSIBandConstantToHMIBandConstant(n);
                    AmFmPresetApi.autoCompare(n2, amFmStation2);
                }
            }
            return bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    @Override
    public void updateStationWithListIndexChange(Station station) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Update Station with list index : ").append(station.toString()).log();
            }
            if (null != station && this.currentIndex >= 0 && this.currentIndex < this.stationInfoCollector.length) {
                AmFmStation amFmStation = new AmFmStation(station);
                if (null != this.stationInfoCollector[this.currentIndex].station && !this.stationInfoCollector[this.currentIndex].station.equals(amFmStation)) {
                    for (int i2 = 0; i2 < this.stationInfoCollector.length; ++i2) {
                        if (null == this.stationInfoCollector[i2].station || !AMFMUtil.compareStations(amFmStation, this.stationInfoCollector[i2].station)) continue;
                        this.currentIndex = i2;
                        this.currentSubListIndex = -1;
                        if (amFmStation.isFM() && null != this.frozenFmList) {
                            ListManager.getGenericASLList(3093).setActiveIndex(this.currentIndex);
                            ListManager.getGenericASLList(3093).updateList(this.stationInfoCollector);
                            GuiApiTunerCommon.updateBapReceptionList(this.tempFmList.toArray());
                            AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.currentIndex);
                            ListManager.getGenericASLList(3094).setActiveIndex(this.currentSubListIndex);
                            AmFmFactory.getAslAmfmModelController().updateFmActiveSubStationIndex(this.currentSubListIndex);
                            continue;
                        }
                        if (!amFmStation.isAM() || null == this.frozenAmList) continue;
                        ListManager.getGenericASLList(1452).setActiveIndex(this.currentIndex);
                        ListManager.getGenericASLList(1452).updateList(this.stationInfoCollector);
                        GuiApiTunerCommon.updateBapReceptionList(this.frozenAmList.toArray());
                        AmFmFactory.getAslAmfmModelController().updateAmActiveStationIndex(this.currentIndex);
                    }
                }
                AmFmPresetApi.syncFmName(amFmStation);
                AmFmPresetApi.autoCompare();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateSubStationWithListIndexChange(Station station) {
        try {
            AmFmStation amFmStation;
            if (null == station) {
                return;
            }
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Update sub Station with list index : ").append(station.toString()).log();
            }
            if (!this.subStationInfoCollector[this.currentSubListIndex].station.equals(amFmStation = new AmFmStation(station))) {
                for (int i2 = 0; i2 < this.subStationInfoCollector.length; ++i2) {
                    if (!this.subStationInfoCollector[i2].station.equals(amFmStation)) continue;
                    this.currentSubListIndex = i2;
                    this.currentIndex = -1;
                    ListManager.getGenericASLList(3093).setActiveIndex(this.activeStationIndex);
                    AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.activeStationIndex);
                    ListManager.getGenericASLList(3094).setActiveIndex(this.currentSubListIndex);
                    ListManager.getGenericASLList(3094).updateList(this.subStationInfoCollector);
                    AmFmFactory.getAslAmfmModelController().updateFmActiveSubStationIndex(this.currentSubListIndex);
                }
            }
            AmFmPresetApi.syncFmName(amFmStation);
            AmFmPresetApi.autoCompare();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public int getIndexOf(AmFmStationInfoCollector[] amFmStationInfoCollectorArray, AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append(" NAR Get Index of Station Frequency : ").append(amFmStation.getFrequency()).append(" ServiceID : ").append(amFmStation.getServiceId()).log();
        }
        if (amFmStation != null && amFmStationInfoCollectorArray != null) {
            for (int i2 = 0; i2 < amFmStationInfoCollectorArray.length; ++i2) {
                if (amFmStation.getFrequency() != amFmStationInfoCollectorArray[i2].station.getFrequency() || amFmStation.getServiceId() != amFmStationInfoCollectorArray[i2].station.getServiceId()) continue;
                return i2;
            }
        }
        return -1;
    }

    @Override
    public void updateActiveListItem() {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (null != amFmStation) {
            if (amFmStation.isFM()) {
                if (amFmStation.getServiceId() > 1) {
                    ListManager.getGenericASLList(3094).updateListItem(this.currentSubListIndex, this.subStationInfoCollector[this.currentSubListIndex]);
                } else {
                    ListManager.getGenericASLList(3093).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex]);
                }
            } else if (amFmStation.isAM()) {
                ListManager.getGenericASLList(1452).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex]);
            }
        }
    }

    @Override
    public void nextStation() {
        AmFmStation amFmStation = null;
        AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
        if (null == amFmStation2) {
            return;
        }
        if (RadioCurrentWaveband.isFm()) {
            if (amFmStation2 != null && this.tempFmList != null) {
                int n = this.tempFmList.indexOf(amFmStation2);
                if (++n >= this.tempFmList.size()) {
                    n = 0;
                }
                amFmStation = this.tempFmList.get(n);
            }
        } else if (RadioCurrentWaveband.isAm() && amFmStation2 != null && this.frozenAmList != null) {
            int n = this.frozenAmList.indexOf(amFmStation2);
            if (++n >= this.frozenAmList.size()) {
                n = 0;
            }
            amFmStation = this.frozenAmList.get(n);
        }
        if (amFmStation != null) {
            if (amFmStation.isSubService()) {
                this.tuneSubStation(amFmStation);
            } else {
                this.tuneStation(amFmStation);
            }
        }
    }

    @Override
    public void previousStation() {
        AmFmStation amFmStation = null;
        AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
        if (null == amFmStation2) {
            return;
        }
        if (RadioCurrentWaveband.isFm()) {
            if (amFmStation2 != null && this.tempFmList != null) {
                int n = this.tempFmList.indexOf(amFmStation2);
                if (--n < 0) {
                    n = this.tempFmList.size() - 1;
                }
                amFmStation = this.tempFmList.get(n);
            }
        } else if (RadioCurrentWaveband.isAm() && amFmStation2 != null && this.frozenAmList != null) {
            int n = this.frozenAmList.indexOf(amFmStation2);
            if (--n < 0) {
                n = this.frozenAmList.size() - 1;
            }
            amFmStation = this.frozenAmList.get(n);
        }
        if (amFmStation != null) {
            if (amFmStation.isSubService()) {
                this.tuneSubStation(amFmStation);
            } else {
                this.tuneStation(amFmStation);
            }
        }
    }
}


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
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.comparator.AslStationFrequencyComparator;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import de.vw.mib.asl.internal.radio.comparator.FmProgrammeServiceNameComparatorThreeGroups;
import de.vw.mib.asl.internal.radio.comparator.PtyComparator;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.dsi.ifc.radio.Station;

public class AmFmUIStationListBase
implements AmFmUIStationList {
    protected Logger logger = ServiceManager.logger;
    protected int type = -1;
    protected int currentIndex = -1;
    AmFmStationInfoCollector[] stationInfoCollector;
    AmFmStationInfoCollector[] subStationInfoCollector;
    AmFmStationListFM hmiFmSubStationList = null;
    Comparator fmComparator = FmPiFrequencyHdComparatorChain.INSTANCE;
    protected int currentSubListIndex = -1;
    protected int activeStationIndex = -1;
    protected AmFmStationList frozenFmList = null;
    protected AmFmStationList frozenAmList = null;
    private static final int FIND_NEXT_STATION_IN_PTY_SORTED_LIST_TRIES;

    public AmFmUIStationListBase() {
        this.setFmComparator();
    }

    @Override
    public AmFmStationInfoCollector[] getStationInfoCollectors() {
        return this.stationInfoCollector;
    }

    @Override
    public void setStationInfoCollector(AmFmStationInfoCollector[] amFmStationInfoCollectorArray) {
        this.stationInfoCollector = amFmStationInfoCollectorArray;
    }

    @Override
    public AmFmStationInfoCollector[] getSubStationInfoCollectors() {
        return this.subStationInfoCollector;
    }

    @Override
    public int getCurrentSubListIndex() {
        return this.currentSubListIndex;
    }

    @Override
    public int getActiveStationIndex() {
        return this.activeStationIndex;
    }

    @Override
    public int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override
    public void loadCurrentStationList() {
        this.loadCurrentStationList(RadioData.getAmfmDatabase().getCurrentStation());
    }

    @Override
    public void loadCurrentStationList(AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (amFmStation.getWaveband() == 1) {
                this.loadCurrentStationListFm(amFmStation);
            } else if (amFmStation.getWaveband() == 3 || amFmStation.getWaveband() == 4) {
                this.loadCurrentStationListAm(amFmStation);
            } else {
                ServiceManager.logger.warn(128).append("Unhandled Waveband found in loadCurrentStationList(): ").append(this.type).log();
            }
        } else if (RadioCurrentWaveband.isFm()) {
            this.stationInfoCollector = new FMStationInfoCollector[0];
        } else if (RadioCurrentWaveband.isAm()) {
            this.stationInfoCollector = new AMStationInfoCollector[0];
        }
    }

    public void loadCurrentStationListFm(AmFmStation amFmStation) {
        try {
            this.type = 1;
            this.frozenFmList = RadioData.getAmfmDatabase().getAslStationListFM().generateFrozenFmList(amFmStation);
            this.stationInfoCollector = new FMStationInfoCollector[this.frozenFmList.size()];
            Iterator iterator = this.frozenFmList.getStationListIterator();
            if (null == iterator) {
                return;
            }
            int n = 0;
            while (iterator.hasNext()) {
                AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                if (amFmStation2.equals(amFmStation, AmfmRDSOption.get())) {
                    this.currentIndex = n;
                    AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.currentIndex);
                    ListManager.getGenericASLList(1462).setActiveIndex(this.currentIndex);
                }
                this.stationInfoCollector[n] = new FMStationInfoCollector(amFmStation2);
                ++n;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            this.stationInfoCollector = new FMStationInfoCollector[0];
        }
    }

    public void loadCurrentStationListAm(AmFmStation amFmStation) {
        try {
            this.type = amFmStation.getWaveband();
            this.currentIndex = RadioData.getAmfmDatabase().getAslStationListAM().indexOf(amFmStation);
            this.frozenAmList = new AmFmStationListAM();
            this.frozenAmList.add(RadioData.getAmfmDatabase().getAslStationListAM().getListCopy());
            if (this.currentIndex < 0) {
                this.frozenAmList.add(amFmStation);
            }
            this.stationInfoCollector = new AMStationInfoCollector[this.frozenAmList.size()];
            Iterator iterator = this.frozenAmList.getStationListIterator();
            int n = 0;
            if (null == iterator) {
                return;
            }
            while (iterator.hasNext()) {
                StationNameFreqList stationNameFreqList;
                AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                if (amFmStation2.equalsByFreq(amFmStation)) {
                    this.currentIndex = n;
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                    amFmStation2.setName(stationNameFreqList.getStationName(amFmStation2.getFrequency()));
                }
                this.stationInfoCollector[n] = new AMStationInfoCollector(amFmStation2);
                ++n;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            this.stationInfoCollector = new AMStationInfoCollector[0];
        }
    }

    @Override
    public void loadCurrentSubStationList(AmFmStation amFmStation) {
    }

    @Override
    public void nextStation() {
        try {
            if (RadioData.getAmfmDatabase().getAslStationListFM().isListSortingFmPtyGroups()) {
                this.setIndexForFmPtySortedList(true);
            } else {
                this.setNextIndex();
            }
            AmFmDsiApi.selectStation(this.stationInfoCollector[this.currentIndex].station);
            this.update();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void previousStation() {
        try {
            if (RadioData.getAmfmDatabase().getAslStationListFM().isListSortingFmPtyGroups()) {
                this.setIndexForFmPtySortedList(false);
            } else {
                this.setPreviousIndex();
            }
            AmFmDsiApi.selectStation(this.stationInfoCollector[this.currentIndex].station);
            this.update();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void tuneStation(int n) {
        if (n >= 0 && n < this.stationInfoCollector.length) {
            this.currentIndex = n;
            AmFmDsiApi.selectStation(this.stationInfoCollector[this.currentIndex].station);
            this.updateIndices();
        } else {
            ServiceManager.logger.error(128).append("Invalid newListIndex, val=").append(n).append(",Listlen=").append(this.stationInfoCollector.length).log();
        }
    }

    @Override
    public void tuneSubStation(int n) {
    }

    @Override
    public void tuneStation(AmFmStation amFmStation) {
    }

    @Override
    public void tuneSubStation(AmFmStation amFmStation) {
    }

    private void updateIndices() {
        try {
            AmFmStation amFmStation = this.getCurrentStation();
            long l = -1L;
            int n = -1;
            if (amFmStation != null) {
                l = RadioUtil.computeUniqueID(amFmStation);
                n = AmFmPresetApi.getIndexOfPreset(amFmStation);
            }
            AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(l, n);
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("index updated to bap : ").append(l).append("index updated to model : ").append(this.currentIndex).log();
            }
            if (this.type == 1) {
                ListManager.getGenericASLList(1462).setActiveIndex(this.currentIndex);
                AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.currentIndex);
            } else if (this.type == 3 || this.type == 4) {
                ListManager.getGenericASLList(1452).setActiveIndex(this.currentIndex);
                AmFmFactory.getAslAmfmModelController().updateAmActiveStationIndex(this.currentIndex);
            } else {
                ServiceManager.logger.warn(128).append("Unhandled Waveband found in updateIndices(): ").append(this.type).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void update() {
        try {
            long l;
            AmFmStation amFmStation = this.getCurrentStation();
            long l2 = l = amFmStation != null ? RadioUtil.computeUniqueID(amFmStation) : -1L;
            if (this.type == 1) {
                AmFmFactory.getAslAmfmModelController().updateFmStationList((FMStationInfoCollector[])this.stationInfoCollector, this.currentIndex, -1, l);
            } else if (this.type == 3 || this.type == 4) {
                AmFmFactory.getAslAmfmModelController().updateAmStationList((AMStationInfoCollector[])this.stationInfoCollector, this.currentIndex, l);
            } else {
                ServiceManager.logger.warn(128).append("Unhandled Waveband found in update(): ").append(this.type).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void clear() {
        this.stationInfoCollector = null;
        this.subStationInfoCollector = null;
    }

    @Override
    public AmFmStation getCurrentStation() {
        AmFmStation amFmStation = null;
        if (this.currentIndex >= 0 && this.currentIndex < this.stationInfoCollector.length) {
            amFmStation = this.stationInfoCollector[this.currentIndex].station;
        }
        return amFmStation;
    }

    @Override
    public int getActiveIndex() {
        return this.currentIndex;
    }

    @Override
    public void setActiveIndex(int n) {
        this.currentIndex = n;
    }

    @Override
    public int getStationIndexById(long l) {
        if (null != this.stationInfoCollector) {
            for (int i2 = 0; i2 < this.stationInfoCollector.length; ++i2) {
                if (this.stationInfoCollector[i2].station.getUniqueId() != l) continue;
                return i2;
            }
        }
        return -1;
    }

    @Override
    public int getStationByDatabaseId(long l) {
        if (null != this.stationInfoCollector) {
            for (int i2 = 0; i2 < this.stationInfoCollector.length; ++i2) {
                if ((long)this.stationInfoCollector[i2].station.getDbStationId() != l) continue;
                return i2;
            }
        }
        return -1;
    }

    @Override
    public boolean updateStation(AmFmStation amFmStation, boolean bl, boolean bl2) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("AmFmUIStationListBase - updateStation( ").append(amFmStation.toString()).append(", ").append(bl).append(", ").append(bl2).append(" )").log();
            }
            if (null == this.stationInfoCollector) {
                this.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("AmFmUIStationListBase - updateStation() - null == stationInfoCollector").log();
                return false;
            }
            if (this.currentIndex >= this.stationInfoCollector.length) {
                this.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("AmFmUIStationListBase - updateStation() - currentIndex >= stationInfoCollector.length").log();
                return false;
            }
            if (AmFmStationList.isListItemPressed()) {
                return false;
            }
            boolean bl3 = false;
            boolean bl4 = true;
            if (bl2 && amFmStation.isFM()) {
                String string = this.stationInfoCollector[this.currentIndex].station.getName();
                String string2 = amFmStation.getName();
                if (null != string && string.length() > 0 || null == string2 || string2.length() < 1) {
                    bl4 = false;
                }
            }
            if (null != amFmStation) {
                if (bl || bl4 && this.stationInfoCollector[this.currentIndex].station.equals(amFmStation)) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("AmFmUIStationListBase - updateStation() - Station update!").log();
                    }
                    this.stationInfoCollector[this.currentIndex].station.copyOf(amFmStation);
                    if (amFmStation.isFM()) {
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                            ListManager.getGenericASLList(3093).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex]);
                        } else {
                            ListManager.getGenericASLList(1462).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex]);
                        }
                        ListManager.getGenericASLList(1270).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex].station);
                        if (this.logger.isTraceEnabled(128)) {
                            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("FM List: updating name of current item: name:").append(amFmStation.getName()).append("  f: ").append(amFmStation.getFrequency()).log();
                        }
                    } else if (amFmStation.isAM()) {
                        ListManager.getGenericASLList(1452).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex]);
                        ListManager.getGenericASLList(1270).updateListItem(this.currentIndex, this.stationInfoCollector[this.currentIndex].station);
                    }
                } else {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("AmFmUIStationListBase - updateStation() - No station update!").log();
                    }
                    bl3 = true;
                }
            }
            return bl3;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    @Override
    public boolean updateSubStation(AmFmStation amFmStation) {
        return false;
    }

    public boolean updateSubStation(Station station) {
        boolean bl = false;
        return bl;
    }

    @Override
    public void updateStationListItem(Station station) {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_STATIONLIST).append("AmFmUIStationListBase - updateStationListItem( ").append(station.toString()).append(" )").log();
            }
            if (null != station && this.currentIndex >= 0 && this.currentIndex < this.stationInfoCollector.length) {
                AmFmStation amFmStation = new AmFmStation(station);
                int n = RadioCurrentWaveband.get();
                amFmStation.setRdsPiIgnoreProperties();
                if (1 == n || 0 == n) {
                    if (null == this.stationInfoCollector[this.currentIndex].station) {
                        this.stationInfoCollector[this.currentIndex].station = new AmFmStation(amFmStation);
                    } else {
                        this.stationInfoCollector[this.currentIndex].station.copyOf(amFmStation);
                    }
                    if (RadioCurrentWaveband.isFm()) {
                        this.updateFmList(this.stationInfoCollector);
                        GuiApiTunerCommon.updateBapReceptionList(this.frozenFmList.toArray());
                        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(amFmStation.getUniqueId(), AmFmPresetApi.getCurrentIndex());
                        AmFmFactory.getAslAmfmModelController().updateFmActiveStationIndex(this.currentIndex);
                        ListManager.getGenericASLList(1462).setActiveIndex(this.currentIndex);
                    } else if (RadioCurrentWaveband.isAm()) {
                        ListManager.getGenericASLList(1452).updateList(this.stationInfoCollector);
                        GuiApiTunerCommon.updateBapReceptionList(this.frozenAmList.toArray());
                        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(amFmStation.getUniqueId(), AmFmPresetApi.getCurrentIndex());
                        AmFmFactory.getAslAmfmModelController().updateAmActiveStationIndex(this.currentIndex);
                        ListManager.getGenericASLList(1452).setActiveIndex(this.currentIndex);
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
    }

    @Override
    public void updateStationIsOnPreset() {
        if (null != this.stationInfoCollector) {
            for (int i2 = 0; i2 < this.stationInfoCollector.length; ++i2) {
                this.stationInfoCollector[i2].autocompare = AmFmPresetApi.getIndexOfPreset(this.stationInfoCollector[i2].station) + 1;
            }
        }
    }

    public int getStationIndex(AmFmStation amFmStation) {
        return 0;
    }

    @Override
    public int getIndexOf(AmFmStationInfoCollector[] amFmStationInfoCollectorArray, AmFmStation amFmStation) {
        return -1;
    }

    @Override
    public void updateActiveListItem() {
    }

    @Override
    public Comparator getFmComparator() {
        return this.fmComparator;
    }

    @Override
    public void setFmComparator() {
        switch (RadioData.getAmfmDatabase().getSettingsPersistable().getFmStationListSortOrder()) {
            case 0: {
                AmFmFactory.getAslAmfmModelController().updateFmStationListSortOrder(0);
                this.fmComparator = FmProgrammeServiceNameComparatorThreeGroups.INSTANCE;
                break;
            }
            case 1: {
                AmFmFactory.getAslAmfmModelController().updateFmStationListSortOrder(1);
                this.fmComparator = FmPiFrequencyHdComparatorChain.INSTANCE;
                break;
            }
            case 3: {
                AmFmFactory.getAslAmfmModelController().updateFmStationListSortOrder(3);
                this.fmComparator = PtyComparator.INSTANCE;
                break;
            }
            default: {
                AmFmFactory.getAslAmfmModelController().updateFmStationListSortOrder(2);
                this.fmComparator = AslStationFrequencyComparator.INSTANCE;
            }
        }
    }

    @Override
    public void setFmStationListSortOrder(int n) {
        try {
            RadioData.getAmfmDatabase().getSettingsPersistable().setFmStationListSortOrder(n);
            this.setFmComparator();
            AmFmStationListFM amFmStationListFM = RadioData.getAmfmDatabase().getAslStationListFM();
            AmFmUIStationList amFmUIStationList = AmFmFactory.getInstanceEUStationListViewWalker();
            if (null != amFmStationListFM && null != amFmUIStationList) {
                AmFmStation[] amFmStationArray = amFmStationListFM.getDeepListCopy();
                amFmStationListFM.stationList = new TreeSet(amFmUIStationList.getFmComparator());
                amFmStationListFM.add(amFmStationArray);
            }
            AmFmStationListFM.setStationListIsFreezed(false);
            if (RadioCurrentWaveband.isFm() && null != amFmStationListFM) {
                ((AmFmStationList)amFmStationListFM).updateStationListToHMI();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public AmFmStationList getFrozenStationList() {
        switch (RadioCurrentWaveband.get()) {
            case 1: {
                return this.frozenFmList;
            }
            case 0: {
                return this.frozenAmList;
            }
        }
        return null;
    }

    @Override
    public void updateStationWithListIndexChange(Station station) {
    }

    @Override
    public void updateFmList(AmFmStationInfoCollector[] amFmStationInfoCollectorArray) {
        ListManager.getGenericASLList(1462).updateList(amFmStationInfoCollectorArray);
    }

    public int setNextIndex() {
        ++this.currentIndex;
        if (this.currentIndex < 0 || this.currentIndex >= this.stationInfoCollector.length) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public int setPreviousIndex() {
        --this.currentIndex;
        if (this.currentIndex < 0 || this.currentIndex >= this.stationInfoCollector.length) {
            this.currentIndex = this.stationInfoCollector.length - 1;
        }
        return this.currentIndex;
    }

    public void setIndexForFmPtySortedList(boolean bl) {
        int n = 0;
        for (int i2 = 0; i2 < 10; ++i2) {
            n = bl ? this.setNextIndex() : this.setPreviousIndex();
            if (!RadioData.getAmfmDatabase().getAslStationListFM().isListItemNoFmPtyGroupTitle(this.stationInfoCollector, n)) continue;
            this.currentIndex = n;
            break;
        }
    }
}


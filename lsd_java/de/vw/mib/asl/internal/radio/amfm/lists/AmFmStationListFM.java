/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmUIStationList;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import de.vw.mib.asl.internal.radio.comparator.PtyComparator;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.dsi.ifc.radio.Station;

public final class AmFmStationListFM
extends AmFmStationList {
    public static Station[] currentFmStationList = null;
    int currentFMListIndex = 0;
    private static boolean isStationListFreezed = false;
    private AmFmStation[] freezedList = null;
    private static HsmTarget amFmTarget = null;
    private HashSet fmSpeechSet;

    public AmFmStationListFM() {
        super(FmPiFrequencyHdComparatorChain.INSTANCE);
        this.fmSpeechSet = null;
    }

    public AmFmStationListFM(Comparator comparator) {
        super(comparator);
    }

    public void setFmStations(Station[] stationArray) {
        boolean bl = false;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            this.syncStationNames(stationArray);
        }
        this.stationList.clear();
        for (int i2 = 0; i2 < stationArray.length; ++i2) {
            boolean bl2;
            if (null == stationArray[i2] || stationArray[i2].waveband != 1) continue;
            if (!stationArray[i2].rds) {
                stationArray[i2].name = "";
                stationArray[i2].pi = -1;
                stationArray[i2].tp = false;
                stationArray[i2].ta = false;
                stationArray[i2].realPS = "";
                stationArray[i2].ptyCode = 0;
            }
            AmFmStation amFmStation = new AmFmStation(stationArray[i2]);
            amFmStation.setRdsPiIgnoreProperties();
            AmFmStationListFM.setFmStationName(amFmStation);
            this.stationList.add(amFmStation);
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2) || !(bl2 = AmFmPresetApi.updateStationLogoFromStationList(amFmStation, amFmStation.getAslWaveband()))) continue;
            bl = bl2;
        }
        if (bl) {
            bl = false;
            AmFmPresetApi.updateGuiList(1);
        }
        if (!(RadioData.getAmfmDatabase().getStationListViewIsOpen() || !RadioCurrentWaveband.isFm() || ServiceManager.configManagerDiag.isFeatureFlagSet(348) && RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive())) {
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateFmListToSpeech(this.getListCopyAsArray());
        }
    }

    public static void setFmStationName(AmFmStation amFmStation) {
        try {
            String string;
            if (null == amFmStation) {
                return;
            }
            if (AmfmRDSOption.get() && (string = RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation.getPi(), amFmStation.getFrequency())) != null && (string = string.trim()).length() > 0) {
                amFmStation.setName(string);
                amFmStation.setScrollingPs(false);
                return;
            }
            string = amFmStation.getName();
            string = string.trim();
            if (amFmStation.isScrollingPS() || string.length() < 1) {
                Object object;
                if (RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForStationList() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive()) {
                    object = RadioDataApi.getFmStationNameFromHmiDataBuffer(amFmStation);
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmStationListFM - setFmStationName() - ").append("stationNameDb: ").append((String)object).log();
                    }
                    if (null != object && ((String)(object = ((String)object).trim())).length() > 0) {
                        amFmStation.setName((String)object);
                        amFmStation.setScrollingPs(false);
                        return;
                    }
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (object = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                    String string2 = ((StationNameFreqList)object).getStationName(amFmStation.getFrequency());
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmStationListFM - setFmStationName() - ").append("Name from NAV database: ").append(string2).log();
                    }
                    if (null != string2 && (string2 = string2.trim()).length() > 0) {
                        amFmStation.setName(string2);
                        amFmStation.setScrollingPs(false);
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public HashSet getFmSpeechSet() {
        return this.fmSpeechSet;
    }

    public Set getMPSListForNAR() {
        TreeSet treeSet = new TreeSet(this.stationList.comparator());
        Iterator iterator = this.stationList.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = (AmFmStation)iterator.next();
            if (amFmStation.getServiceId() > 1) continue;
            treeSet.add(new AmFmStation(amFmStation));
        }
        return treeSet;
    }

    public Set getMPSListForNARWithHdFilter() {
        TreeSet treeSet = new TreeSet(this.stationList.comparator());
        Iterator iterator = this.stationList.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = (AmFmStation)iterator.next();
            if (!amFmStation.isHD() || amFmStation.getServiceId() > 1) continue;
            treeSet.add(new AmFmStation(amFmStation));
        }
        return treeSet;
    }

    public Set getCompleteStationListForNAR() {
        TreeSet treeSet = new TreeSet(this.stationList.comparator());
        Iterator iterator = this.stationList.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = (AmFmStation)iterator.next();
            treeSet.add(new AmFmStation(amFmStation));
        }
        return treeSet;
    }

    public Set getSubServiceListForMPS(AmFmStation amFmStation) {
        TreeSet treeSet = new TreeSet(this.stationList.comparator());
        Iterator iterator = this.stationList.tailSet(amFmStation).iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation2 = (AmFmStation)iterator.next();
            if (amFmStation.getFrequency() != amFmStation2.getFrequency() || amFmStation2.getServiceId() <= 1) continue;
            treeSet.add(new AmFmStation(amFmStation2));
        }
        return treeSet;
    }

    public Set getSubServiceListIncludingMPS(AmFmStation amFmStation) {
        TreeSet treeSet = new TreeSet(this.stationList.comparator());
        Iterator iterator = this.stationList.tailSet(amFmStation).iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation2 = (AmFmStation)iterator.next();
            if (amFmStation.getFrequency() != amFmStation2.getFrequency()) continue;
            treeSet.add(new AmFmStation(amFmStation2));
        }
        return treeSet;
    }

    public int indexOfWithFrequencyAndSubChannel(AmFmStation amFmStation) {
        if (amFmStation != null) {
            int n = -1;
            Iterator iterator = this.getStationListIterator();
            if (null != iterator) {
                while (iterator.hasNext()) {
                    AmFmStation amFmStation2 = (AmFmStation)iterator.next();
                    ++n;
                    if (amFmStation2.getFrequency() != amFmStation.getFrequency() || amFmStation2.getSubChannel() != amFmStation.getSubChannel()) continue;
                    return n;
                }
            }
        }
        return -1;
    }

    private void syncStationNames(Station[] stationArray) {
        block0: for (int i2 = 0; i2 < stationArray.length; ++i2) {
            if (!stationArray[i2].hd || stationArray[i2].shortNameHD.length() != 0) continue;
            Iterator iterator = this.stationList.iterator();
            while (iterator.hasNext()) {
                AmFmStation amFmStation = (AmFmStation)iterator.next();
                if (stationArray[i2].getFrequency() != (long)amFmStation.getFrequency()) continue;
                stationArray[i2].shortNameHD = amFmStation.getShortNameHD();
                continue block0;
            }
        }
    }

    @Override
    public void toggleStation(int n) {
        if (null == this.stationList) {
            return;
        }
        if (this.stationList.isEmpty()) {
            return;
        }
        if (!isStationListFreezed && null != amFmTarget) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmStationListFM - toggleStation(), Start Station List Freezed Timer, isStationListFreezed = ").append(isStationListFreezed).log();
            }
            isStationListFreezed = true;
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation();
            AmFmStationList amFmStationList = this.generateFrozenFmList(amFmStation);
            this.freezedList = amFmStationList.toArray();
            this.currentFMListIndex = this.getIndexFromFreezedList(amFmStation.getUniqueId());
            amFmTarget.startStationListFreezedTimer();
        } else {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmStationListFM - toggleStation(), Restart Station List Freezed Timer, isStationListFreezed = ").append(isStationListFreezed).log();
            }
            amFmTarget.restartStationListFreezedTimer();
        }
        if (null == this.freezedList) {
            return;
        }
        if (this.freezedList.length < 2) {
            return;
        }
        switch (n) {
            case 0: {
                ++this.currentFMListIndex;
                if (this.currentFMListIndex < this.freezedList.length && this.currentFMListIndex >= 0) break;
                this.currentFMListIndex = 0;
                break;
            }
            case 1: {
                --this.currentFMListIndex;
                if (this.currentFMListIndex >= 0 && this.currentFMListIndex < this.freezedList.length) break;
                this.currentFMListIndex = this.freezedList.length - 1;
                break;
            }
            default: {
                return;
            }
        }
        if (this.currentFMListIndex >= 0 && this.currentFMListIndex < this.freezedList.length && this.freezedList[this.currentFMListIndex] != null) {
            AmFmDsiApi.selectStationFromFreezedStationList(this.freezedList[this.currentFMListIndex]);
        }
    }

    public int getIndexFromFreezedList(long l) {
        if (null != this.freezedList) {
            for (int i2 = 0; i2 < this.freezedList.length; ++i2) {
                if (null == this.freezedList[i2] || this.freezedList[i2].getUniqueId() != l) continue;
                return i2;
            }
        }
        return -1;
    }

    public void switchPIComparison() {
        if (!RadioCodingAdapter.isPiActivated()) {
            TreeSet treeSet = new TreeSet(FrequencyHDComparatorChain.INSTANCE);
            treeSet.addAll(this.stationList);
            this.stationList = treeSet;
            this.piMode = false;
        }
    }

    @Override
    public void updateStationListToHMI() {
        block7: {
            try {
                AmFmUIStationList amFmUIStationList = AmFmFactory.getInstanceEUStationListViewWalker();
                amFmUIStationList.loadCurrentStationList();
                long l = RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation());
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    AmFmFactory.getAslAmfmModelController().updateFmStationList((FMStationInfoCollector[])amFmUIStationList.getStationInfoCollectors(), amFmUIStationList.getCurrentIndex(), amFmUIStationList.getActiveStationIndex(), l);
                    AmFmFactory.getAslAmfmModelController().updateFmSubStationList((FMStationInfoCollector[])amFmUIStationList.getSubStationInfoCollectors(), amFmUIStationList.getCurrentSubListIndex(), l);
                    break block7;
                }
                AmFmStationInfoCollector[] amFmStationInfoCollectorArray = null;
                try {
                    amFmStationInfoCollectorArray = (FMStationInfoCollector[])amFmUIStationList.getStationInfoCollectors();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                    amFmStationInfoCollectorArray = null;
                }
                if (null != amFmStationInfoCollectorArray) {
                    if (RadioCodingAdapter.isPiActivated() && AmfmRDSOption.get() && RadioData.getAmfmDatabase().getSettingsPersistable().getFmStationListSortOrder() != 0 && RadioData.getAmfmDatabase().getSettingsPersistable().getFmStationListSortOrder() == 3) {
                        amFmStationInfoCollectorArray = this.setPtyGroupTitle((FMStationInfoCollector[])amFmStationInfoCollectorArray);
                        amFmUIStationList.setStationInfoCollector(amFmStationInfoCollectorArray);
                        amFmUIStationList.setActiveIndex(this.recalculateListIndexForPTYGroup(amFmStationInfoCollectorArray));
                    }
                    AmFmFactory.getAslAmfmModelController().updateFmStationList((FMStationInfoCollector[])amFmStationInfoCollectorArray, amFmUIStationList.getCurrentIndex(), -1, l);
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    private void setFirstItemInNewAlphabeticSection(FMStationInfoCollector[] fMStationInfoCollectorArray) {
        boolean bl = false;
        AmFmStation amFmStation = null;
        if (null != fMStationInfoCollectorArray) {
            for (int i2 = 1; i2 < fMStationInfoCollectorArray.length; ++i2) {
                String string;
                AmFmStation amFmStation2;
                if (null == fMStationInfoCollectorArray[i2] || null == (amFmStation2 = fMStationInfoCollectorArray[i2].station)) continue;
                String string2 = amFmStation2.getRealName();
                if (null != string2 && string2.length() > 0 && amFmStation2.isScrollingPS() && !bl) {
                    if (null != fMStationInfoCollectorArray[i2 - 1] && null != (amFmStation = fMStationInfoCollectorArray[i2 - 1].station) && null != (string = amFmStation.getRealName()) && string.length() > 0 && !amFmStation.isScrollingPS()) {
                        fMStationInfoCollectorArray[i2].setFirstItemInNewSection(true);
                    }
                    bl = true;
                }
                if (null == string2 || string2.length() >= 1) continue;
                if (null != fMStationInfoCollectorArray[i2 - 1] && null != (amFmStation = fMStationInfoCollectorArray[i2 - 1].station) && null != (string = amFmStation.getRealName()) && string.length() > 0) {
                    fMStationInfoCollectorArray[i2].setFirstItemInNewSection(true);
                }
                return;
            }
        }
    }

    public static void setRadioAmFMTarget(HsmTarget hsmTarget) {
        amFmTarget = hsmTarget;
    }

    public static void setStationListIsFreezed(boolean bl) {
        if (!bl) {
            amFmTarget.stopStationListFreezedTimer();
        }
        isStationListFreezed = bl;
    }

    public static void traceStationListFmCollector() {
        Object[] objectArray = ListManager.getGenericASLList(1462).getDSIObjects();
        if (null == objectArray || objectArray.length < 1) {
            return;
        }
        FMStationInfoCollector[] fMStationInfoCollectorArray = (FMStationInfoCollector[])objectArray;
        if (null != fMStationInfoCollectorArray) {
            for (int i2 = 0; i2 < fMStationInfoCollectorArray.length; ++i2) {
                if (null == fMStationInfoCollectorArray[i2]) continue;
            }
        }
    }

    private FMStationInfoCollector[] setPtyGroupTitle(FMStationInfoCollector[] fMStationInfoCollectorArray) {
        int n = -1;
        ArrayList arrayList = new ArrayList(0);
        if (null != fMStationInfoCollectorArray) {
            for (int i2 = 0; i2 < fMStationInfoCollectorArray.length; ++i2) {
                AmFmStation amFmStation;
                if (null == fMStationInfoCollectorArray[i2] || null == (amFmStation = fMStationInfoCollectorArray[i2].station)) continue;
                int n2 = amFmStation.getPtyCode();
                int n3 = PtyComparator.INSTANCE.getPtyGroup(n2);
                if (n != n3) {
                    this.addTitle(arrayList, n3);
                    n = n3;
                }
                arrayList.add(fMStationInfoCollectorArray[i2]);
            }
        }
        return (FMStationInfoCollector[])arrayList.toArray(new FMStationInfoCollector[arrayList.size()]);
    }

    private void addTitle(ArrayList arrayList, int n) {
        AmFmStation amFmStation = new AmFmStation();
        switch (n) {
            case 0: {
                amFmStation.setName("Music");
                break;
            }
            case 1: {
                amFmStation.setName("News");
                break;
            }
            case 2: {
                amFmStation.setName("Sport");
                break;
            }
            case 3: {
                amFmStation.setName("Culture");
                break;
            }
            case 4: {
                amFmStation.setName("Special");
                break;
            }
            case 5: {
                amFmStation.setName("Other");
                break;
            }
            default: {
                amFmStation.setName("");
            }
        }
        FMStationInfoCollector fMStationInfoCollector = new FMStationInfoCollector(amFmStation);
        fMStationInfoCollector.setSelectable(false);
        fMStationInfoCollector.setPtyGroupTitleId(n);
        arrayList.add(fMStationInfoCollector);
    }

    public boolean isListSortingFmPtyGroups() {
        return RadioCurrentWaveband.isFm() && !ServiceManager.configManagerDiag.isFeatureFlagSet(2) && RadioData.getAmfmDatabase().getSettingsPersistable().getFmStationListSortOrder() == 3;
    }

    public boolean isListItemNoFmPtyGroupTitle(AmFmStationInfoCollector[] amFmStationInfoCollectorArray, int n) {
        return null != amFmStationInfoCollectorArray && n >= 0 && n < amFmStationInfoCollectorArray.length && null != amFmStationInfoCollectorArray[n] && amFmStationInfoCollectorArray[n].getPtyGroupTitleId() == -1;
    }

    public int recalculateListIndexForPTYGroup(AmFmStationInfoCollector[] amFmStationInfoCollectorArray) {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (null != amFmStationInfoCollectorArray && null != amFmStation) {
            for (int i2 = 0; i2 < amFmStationInfoCollectorArray.length; ++i2) {
                if (null == amFmStationInfoCollectorArray[i2] || amFmStationInfoCollectorArray[i2].getPtyGroupTitleId() != -1 || !amFmStationInfoCollectorArray[i2].station.equals(amFmStation, AmfmRDSOption.get())) continue;
                return i2;
            }
        }
        return -1;
    }
}


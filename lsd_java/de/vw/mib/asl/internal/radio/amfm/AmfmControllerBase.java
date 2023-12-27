/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmfmController;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmFixedStationListPersistable;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRadioTextOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRegStateOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import de.vw.mib.asl.internal.radio.comparator.SubChannelComparatorChain;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;
import org.dsi.ifc.radiodata.DSIRadioData;

public class AmfmControllerBase
implements AmfmController {
    protected static Logger logger = ServiceManager.logger;
    protected final AmFmStationListFM mFMStationList = new AmFmStationListFM(FmPiFrequencyHdComparatorChain.INSTANCE);
    protected final AmFmStationListAM mAMStationList = new AmFmStationListAM();
    protected final AmFmStationListFM mFMSationListNARMulticast = new AmFmStationListFM(SubChannelComparatorChain.INSTANCE);
    protected AmFmSettingsPersistable mSettingsPersistable = new AmFmSettingsPersistable();
    protected AmFmFixedStationListPersistable fixedStationList = new AmFmFixedStationListPersistable();
    protected int preset_Width = 0;
    protected int preset_Heigth = 0;
    private DSIAMFMTuner dsiAMFMTuner;
    private DSIRadioData dsiRadioData;
    protected AmFmStation freezedAslStation;
    private AmFmStation oldStation = null;
    private AmFmStation stationBeforeSeekStarted = null;
    private boolean stationListViewIsOpen = false;
    private int TIMEOUT_AM_MIN_TUNETIME = 30000;
    private int TIMEOUT_AM_REMOVE = 30000;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;

    @Override
    public void resetOptions() {
        try {
            RadioServiceManager.getServiceManager().setFactoryResetInProgress(true);
            AmFmAlternativeFrequencySwitch.set(RadioCodingAdapter.isAfActivated());
            AmFmAlternativeFrequencySwitch.setAFOnBeforeRDSOff(RadioCodingAdapter.isAfActivated());
            AmFmAlternativeFrequencySwitch.notifyDSI(RadioCodingAdapter.isAfActivated());
            if (null != ServiceManager.configManagerDiag && (ServiceManager.configManagerDiag.isFeatureFlagSet(418) || ServiceManager.configManagerDiag.isFeatureFlagSet(423) || this.noRadioTextForChina())) {
                AmfmRadioTextOption.set(false);
                AmfmRadioTextOption.setRadioTextOnBeforeRDSOff(false);
            } else {
                AmfmRadioTextOption.set(true);
                AmfmRadioTextOption.setRadioTextOnBeforeRDSOff(true);
            }
            AmfmRegStateOptionRequester.reset();
            AmfmRegStateOptionRequester.notifyDsi(AmfmRegStateOptionRequester.get());
            RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActiveChangedByUser(false);
            RadioDataSessionManager.getInstance().countryList.setSetupAutoStoreStationLogoSwitchOnOrOff();
            AmfmRDSOption.set(RadioCodingAdapter.isRdsActivated(), false);
            RadioDataApi.deleteHmiLogoBuffer();
            RadioServiceManager.getServiceManager().setFactoryResetInProgress(false);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private boolean noRadioTextForChina() {
        return !RadioCodingAdapter.isPiActivated() && RadioCodingAdapter.getFmTunerBandSettings() == 5;
    }

    @Override
    public AmFmStation getLastStationForBand(int n) {
        if (RadioCurrentWaveband.isFm(n)) {
            return this.getCurrentFMStation();
        }
        if (RadioCurrentWaveband.isAm(n)) {
            return this.getCurrentAMStation();
        }
        return null;
    }

    @Override
    public AmFmStation getCurrentStation() {
        if (RadioCurrentWaveband.isFm()) {
            return this.getCurrentFMStation();
        }
        if (RadioCurrentWaveband.isAm()) {
            return this.getCurrentAMStation();
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AmfmControllerBase - getCurrentStation() - returns null").log();
        }
        return null;
    }

    @Override
    public AmFmStation getCurrentFMStation() {
        return this.mSettingsPersistable.getCurrentFmStation();
    }

    @Override
    public void setOldStation(AmFmStation amFmStation) {
        this.oldStation = amFmStation;
    }

    @Override
    public AmFmStation getOldStation() {
        return this.oldStation;
    }

    @Override
    public AmFmStation getCurrentAMStation() {
        return this.mSettingsPersistable.getCurrentAmStation();
    }

    @Override
    public void setCurrentStation(AmFmStation amFmStation) {
        if (RadioData.amFmTunerIsInitialized && amFmStation != null) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                amFmStation.toLogString(ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AMFM database, setting current station: ")).log();
            }
            if (null != this.mSettingsPersistable) {
                int n = AMFMUtil.convertDSIBandConstantToHMIBandConstant(amFmStation.getWaveband());
                if (RadioCurrentWaveband.isFm(n)) {
                    this.mSettingsPersistable.setCurrentFmStation(amFmStation);
                } else if (RadioCurrentWaveband.isAm(n)) {
                    this.mSettingsPersistable.setCurrentAmStation(amFmStation);
                }
            }
        }
    }

    @Override
    public void setStationBeforeSeekStarted() {
        this.stationBeforeSeekStarted = new AmFmStation(this.getCurrentStation());
    }

    @Override
    public AmFmStation getStationBeforeSeekStarted() {
        return this.stationBeforeSeekStarted;
    }

    @Override
    public void skipStation(int n) {
        AmFmStationList amFmStationList = this.getCurrentStationList();
        if (null != amFmStationList) {
            amFmStationList.toggleStation(n);
        }
    }

    @Override
    public int getCurrentListSize() {
        AmFmStationList amFmStationList = this.getCurrentStationList();
        if (amFmStationList != null) {
            return amFmStationList.size();
        }
        return -1;
    }

    @Override
    public void setStationListIndex(int n) {
        AmFmStationList amFmStationList = this.getCurrentStationList();
        if (amFmStationList != null) {
            amFmStationList.setCurrentIndex(n);
        }
    }

    @Override
    public void setSubStationListIndex(int n) {
        AmFmStationList amFmStationList = this.getCurrentSubStationList();
        if (amFmStationList != null) {
            amFmStationList.setCurrentIndex(n);
        }
    }

    @Override
    public AmFmStationList getCurrentStationList() {
        if (RadioCurrentWaveband.isAm()) {
            return this.mAMStationList;
        }
        if (RadioCurrentWaveband.isFm()) {
            return this.mFMStationList;
        }
        return null;
    }

    @Override
    public AmFmStationList getCurrentSubStationList() {
        if (RadioCurrentWaveband.isFm()) {
            return this.mFMSationListNARMulticast;
        }
        return null;
    }

    @Override
    public int getCurrentSubStationListSize(AmFmStation amFmStation) {
        if (null != amFmStation && RadioCurrentWaveband.isFm() && amFmStation.getServiceId() <= 1) {
            return this.mFMStationList.getSubServiceListForMPS(amFmStation).size();
        }
        return 0;
    }

    @Override
    public boolean hasSubServiceList(AmFmStation amFmStation) {
        return this.getCurrentSubStationListSize(amFmStation) > 0;
    }

    @Override
    public AmFmStationList getSubStationListWithMPS(AmFmStation amFmStation) {
        if (RadioCurrentWaveband.isFm()) {
            this.mFMSationListNARMulticast.clear();
            this.mFMSationListNARMulticast.add(this.mFMStationList.getSubServiceListForMPS(amFmStation));
            return this.mFMSationListNARMulticast;
        }
        return null;
    }

    @Override
    public void updateStationListToBap() {
        AmFmStationList amFmStationList = this.getCurrentStationList();
        if (amFmStationList != null && amFmStationList.stationList != null) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter() && RadioCurrentWaveband.isAm()) {
                    this.updateFilteredStationListToBap(amFmStationList);
                    this.updateFilteredStationListToHAS(amFmStationList);
                } else if (RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter() && RadioCurrentWaveband.isFm()) {
                    this.updateFilteredStationListToBap(amFmStationList);
                    this.updateFilteredStationListToHAS(amFmStationList);
                } else {
                    GuiApiTunerCommon.updateBapReceptionList(amFmStationList.toArray());
                    if (RadioCurrentWaveband.isFm()) {
                        RadioHASUpdater.updateFmStationList(amFmStationList.toArray());
                    } else if (RadioCurrentWaveband.isAm()) {
                        RadioHASUpdater.updateAmStationList(amFmStationList.toArray());
                    }
                }
            } else {
                GuiApiTunerCommon.updateBapReceptionList(amFmStationList.toArray());
                if (RadioCurrentWaveband.isFm()) {
                    RadioHASUpdater.updateFmStationList(amFmStationList.toArray());
                } else if (RadioCurrentWaveband.isAm()) {
                    RadioHASUpdater.updateAmStationList(amFmStationList.toArray());
                }
            }
        }
    }

    public void updateFilteredStationListToBap(AmFmStationList amFmStationList) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < amFmStationList.size(); ++i2) {
            if (!amFmStationList.get(i2).isHD()) continue;
            arrayList.add(amFmStationList.get(i2));
        }
        GuiApiTunerCommon.updateBapReceptionList(arrayList.toArray(new Object[arrayList.size()]));
    }

    public void updateFilteredStationListToHAS(AmFmStationList amFmStationList) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < amFmStationList.size(); ++i2) {
            if (!amFmStationList.get(i2).isHD()) continue;
            arrayList.add(amFmStationList.get(i2));
        }
        if (RadioCurrentWaveband.isFm()) {
            RadioHASUpdater.updateFmStationList((AmFmStation[])arrayList.toArray(new AmFmStation[arrayList.size()]));
        } else if (RadioCurrentWaveband.isAm()) {
            RadioHASUpdater.updateAmStationList((AmFmStation[])arrayList.toArray(new AmFmStation[arrayList.size()]));
        }
    }

    @Override
    public int getFrequencyForTicks(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = n2;
        if (n == 0) {
            return n2;
        }
        WavebandInfo wavebandInfo = this.getFmBandInfo();
        WavebandInfo wavebandInfo2 = this.getAmBandInfo();
        if (n3 == 1 && wavebandInfo != null) {
            n6 = (int)wavebandInfo.getUpperLimit();
            n5 = (int)wavebandInfo.getLowerLimit();
            n4 = (int)wavebandInfo.getStepWidth();
        } else if (n3 == 0 && wavebandInfo2 != null) {
            n6 = (int)wavebandInfo2.getUpperLimit();
            n5 = (int)wavebandInfo2.getLowerLimit();
            n4 = (int)wavebandInfo2.getStepWidth();
        } else {
            return n2;
        }
        int n8 = n * n4;
        int n9 = n6 - n5;
        if (n8 > 0) {
            if (n2 + n8 > n6) {
                n7 = n2 + n8 - n6;
                n7 = (n7 %= n9 + n4) == 0 ? n6 : n7 + n5 - n4;
            } else {
                n7 = n2 + n8;
            }
        } else if (n2 + n8 < n5) {
            n7 = n5 - (n2 + n8);
            n7 = (n7 %= n9 + n4) == 0 ? n5 : n6 - n7 + n4;
        } else {
            n7 = n2 + n8;
        }
        return n7;
    }

    @Override
    public HdStationInfo getCurrentHDStation() {
        return this.mSettingsPersistable.getCurrentHdStation();
    }

    @Override
    public void setCurrentHDStation(HdStationInfo hdStationInfo) {
        this.mSettingsPersistable.setHdStation(hdStationInfo);
    }

    @Override
    public HdStationInfo getPreviousHDStation() {
        return this.mSettingsPersistable.getPreviousHdStation();
    }

    @Override
    public AmFmStationListAM getAslStationListAM() {
        return this.mAMStationList;
    }

    @Override
    public AmFmStationListFM getAslStationListFM() {
        return this.mFMStationList;
    }

    @Override
    public WavebandInfo getFmBandInfo() {
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            int n = RadioCodingAdapter.getFmTunerBandSettings();
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerChina(n)) {
                return RadioConstants.FM_BANDRANGE_CHINA;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerEuRdw(n)) {
                return RadioConstants.FM_BANDRANGE_EU_RDW;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerJp(n)) {
                return RadioConstants.FM_BANDRANGE_JP;
            }
            if (n == 8) {
                return RadioConstants.FM_BANDRANGE_JP_EXTENDED;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerKor(n)) {
                return RadioConstants.FM_BANDRANGE_KOR;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerNar(n)) {
                return RadioConstants.FM_BANDRANGE_NAR;
            }
            return RadioConstants.FM_BANDRANGE_EU_RDW;
        }
        return RadioConstants.FM_BANDRANGE_EU_RDW;
    }

    @Override
    public WavebandInfo getAmBandInfo() {
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            boolean bl = false;
            int n = RadioCodingAdapter.getAmTunerBandSettings();
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerOff(n)) {
                return RadioConstants.AM_BANDRANGE_AUS;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerEu(n)) {
                return RadioConstants.AM_BANDRANGE_EU;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerEuRdw(n)) {
                return RadioConstants.AM_BANDRANGE_EU_RDW;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerJp(n)) {
                return RadioConstants.AM_BANDRANGE_JP;
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerNar(n)) {
                return RadioConstants.AM_BANDRANGE_NAR;
            }
            return RadioConstants.AM_BANDRANGE_EU_RDW;
        }
        return RadioConstants.AM_BANDRANGE_EU_RDW;
    }

    @Override
    public DSIAMFMTuner getDsiAMFMTuner() {
        HsmTarget hsmTarget;
        if (null == this.dsiAMFMTuner && null != (hsmTarget = RadioServiceManager.getServiceManager().getRadioAmFMTarget()) && null != ServiceManager.dsiServiceLocator) {
            this.dsiAMFMTuner = (DSIAMFMTuner)ServiceManager.dsiServiceLocator.getService(hsmTarget, class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = AmfmControllerBase.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner);
        }
        return this.dsiAMFMTuner;
    }

    @Override
    public AmFmFixedStationListPersistable getFixedStationList() {
        return this.fixedStationList;
    }

    @Override
    public void setFixedStationList(AmFmFixedStationListPersistable amFmFixedStationListPersistable) {
        this.fixedStationList = amFmFixedStationListPersistable;
    }

    @Override
    public AmFmSettingsPersistable getSettingsPersistable() {
        return this.mSettingsPersistable;
    }

    @Override
    public void setPresetWidth(int n) {
        this.preset_Width = n;
    }

    @Override
    public int getPresetWidth() {
        return this.preset_Width;
    }

    @Override
    public void setPresetHeigth(int n) {
        this.preset_Heigth = n;
    }

    @Override
    public int getPresetHeigth() {
        return this.preset_Heigth;
    }

    @Override
    public AmFmStationListFM getFMSationListNARMulticast() {
        return this.mFMSationListNARMulticast;
    }

    @Override
    public void setTimeOutAmMinTuneTime(int n) {
        this.TIMEOUT_AM_MIN_TUNETIME = n;
    }

    @Override
    public int getTimeOutAmMinTuneTime() {
        return this.TIMEOUT_AM_MIN_TUNETIME;
    }

    @Override
    public void setTimeOutAmRemove(int n) {
        this.TIMEOUT_AM_REMOVE = n;
    }

    @Override
    public int getTimeOutAmRemove() {
        return this.TIMEOUT_AM_REMOVE;
    }

    @Override
    public int getTaggingInstance() {
        return this.mSettingsPersistable.getTaggingInstance();
    }

    @Override
    public void setTaggingInstance(int n) {
        this.mSettingsPersistable.setTaggingInstance(n);
    }

    @Override
    public StationNameFreqList getStationNameFreqList() {
        return null;
    }

    @Override
    public void notifyStationChanged(AmFmStation amFmStation) {
    }

    @Override
    public AmFmStation handleStationInfoChange(Station station, Station station2) {
        return null;
    }

    @Override
    public boolean checkForHdStationInfoChanged(HdStationInfo hdStationInfo) {
        return false;
    }

    @Override
    public void clearHdInformation() {
    }

    @Override
    public void setStationListViewIsOpen(boolean bl) {
        this.stationListViewIsOpen = bl;
    }

    @Override
    public boolean getStationListViewIsOpen() {
        return this.stationListViewIsOpen;
    }

    @Override
    public void setStationHdInformationIncomplete(boolean bl) {
    }

    @Override
    public boolean isStationHdInformationIncomplete() {
        return false;
    }

    @Override
    public boolean checkIfStationChanged(Station station, Station station2) {
        return false;
    }

    @Override
    public DSIRadioData getDsiRadioData() {
        return this.dsiRadioData;
    }

    @Override
    public void setDsiRadioData(DSIRadioData dSIRadioData) {
        this.dsiRadioData = dSIRadioData;
    }

    @Override
    public void setMpsCoverArtRemovalTimerRunning(boolean bl) {
    }

    @Override
    public boolean isMpsCoverArtRemovalTimerRunning() {
        return false;
    }

    @Override
    public void setCoverArtReceived(boolean bl) {
    }

    @Override
    public boolean isCoverArtReceived() {
        return false;
    }

    @Override
    public void setTileCoverArtReceived(boolean bl) {
    }

    @Override
    public boolean isTileCoverArtReceived() {
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


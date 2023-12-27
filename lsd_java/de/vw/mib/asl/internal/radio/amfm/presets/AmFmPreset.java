/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetUpdater;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmHDOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.presets.Preset;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.transformer.AMPresetListInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMPresetListInfoCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class AmFmPreset
extends Preset {
    private final int mWaveband;
    private final int mListIndex;
    private AmFmStation mPresetStation = null;
    private AmFmPresetUpdater mUpdater;
    private static int answerTargetId = 0;
    private static int answerEventId = 0;
    private int autoStoredLogoState;
    private boolean manualAsssignedLogo = false;
    private int stationLogoType = 0;

    AmFmPreset(int n, int n2) {
        this.mListIndex = n;
        this.mWaveband = n2;
        this.mPresetStation = new AmFmStation();
        this.autoStoredLogoState = 0;
        this.stationLogoType = 0;
        this.logoDeletedIntentionallyForNar = false;
        if (n2 == 0) {
            this.mPresetStation.setWaveband(3);
        } else {
            this.mPresetStation.setWaveband(1);
        }
        this.setDatabaseStationId(-1L);
    }

    AmFmPreset(AmFmPreset amFmPreset) {
        this.autoStoredLogoState = amFmPreset.autoStoredLogoState;
        this.manualAsssignedLogo = amFmPreset.manualAsssignedLogo;
        this.mListIndex = amFmPreset.mListIndex;
        this.mPresetStation = amFmPreset.mPresetStation;
        this.mUpdater = amFmPreset.mUpdater;
        this.mWaveband = amFmPreset.mWaveband;
        this.stationLogoType = amFmPreset.stationLogoType;
        this.stationImage = amFmPreset.stationImage;
        this.logoDeletedIntentionallyForNar = amFmPreset.logoDeletedIntentionallyForNar;
        this.setDatabaseStationId(amFmPreset.databaseStationId);
    }

    void setUpdater(AmFmPresetUpdater amFmPresetUpdater) {
        this.mUpdater = amFmPresetUpdater;
    }

    boolean activate() {
        try {
            if (!this.isEmpty() && null != this.getPresetStation()) {
                AmFmStation amFmStation = new AmFmStation(this.getPresetStation());
                if (answerTargetId == 0) {
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        amFmStation.setName("");
                    }
                    AmFmDsiApi.selectStation(amFmStation);
                } else {
                    AmFmDsiApi.selectStation(answerTargetId, answerEventId, amFmStation);
                }
                AmFmFactory.getAslAmfmPropertyManager().setPresetTuned(true);
                return true;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return false;
    }

    public void clear() {
        this.clearPreset();
        this.updatePresetOnChange();
    }

    public void clearPreset() {
        if (null == this.mPresetStation) {
            this.mPresetStation = new AmFmStation();
        } else {
            this.mPresetStation.clearAslStation();
            this.mPresetStation.setMpsWithSPSAlreadyStored(false);
            this.mPresetStation.setMpsWithoutSPSAlreadyStored(false);
        }
        this.autoStoredLogoState = 0;
        this.setImage(null, false);
        this.stationLogoType = 0;
        this.deleteDatabaseStationId();
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (this.mWaveband == 1 && null != dSIAMFMTuner) {
            dSIAMFMTuner.freePreset(this.mListIndex);
        }
        AmFmPresetApi.toPersistence(this.mWaveband);
    }

    public AmFmStation getPresetStation() {
        return this.mPresetStation;
    }

    public void setPresetStation(AmFmStation amFmStation) {
        this.mPresetStation = amFmStation;
    }

    public int getFrequency() {
        return this.mPresetStation.getFrequency();
    }

    public int getIndex() {
        return this.mListIndex;
    }

    public String getName() {
        return this.mPresetStation.getName();
    }

    public int getPi() {
        return this.mPresetStation.getPi();
    }

    public int getType() {
        return this.mWaveband;
    }

    public int getServiceID() {
        return this.mPresetStation.getServiceId();
    }

    public boolean isHd() {
        return this.mPresetStation.isHD();
    }

    public String getShortName() {
        return this.mPresetStation.getShortNameHD();
    }

    public long getUniqueId() {
        return this.mPresetStation.getUniqueId();
    }

    public boolean isEmpty() {
        return this.mPresetStation.getFrequency() <= 0;
    }

    public void setEmpty() {
        this.mPresetStation.setFrequency(0L);
    }

    public boolean isValid() {
        return this.mPresetStation.getFrequency() > 0;
    }

    public boolean isLogoManuallyAssignedToPreset() {
        return this.manualAsssignedLogo;
    }

    public void setManualAssignedLogo(boolean bl) {
        this.manualAsssignedLogo = bl;
    }

    public AmFmStation setImage(ResourceLocator resourceLocator, boolean bl) {
        ResourceLocator resourceLocator2 = null;
        if (null != this.stationImage) {
            resourceLocator2 = new ResourceLocator(this.stationImage.getId(), this.stationImage.getUrl());
        }
        if (resourceLocator != null) {
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2) || bl || !this.isLogoDeletedIntentionallyForNar()) {
                this.stationImage = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
                if (null != this.mPresetStation) {
                    ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("##@@##-> setImage in AmFmPreset: ").append(" PresetFreq: ").append(this.mPresetStation.getFrequency()).append(" PresetServID: ").append(this.mPresetStation.getServiceId()).append("stationImageID: ").append(this.stationImage.getId()).append("  stationImageURL: ").append(this.stationImage.getUrl()).log();
                }
                this.setLogoDeletedIntentionallyForNar(false);
                AmFmFactory.getAslAmfmModelController().updateAtLeastOnePresetHasLogo(this.mWaveband, true);
            }
        } else {
            this.stationImage = null;
        }
        if (resourceLocator2 != null && this.manualAsssignedLogo && !AmFmPresetApi.isResourceLocatorUsed(resourceLocator2, this.mPresetStation)) {
            PresetManualPictureStore.deletePicture(new ResourceLocator[]{resourceLocator2}, AmFmPresetApi.getTarget());
        }
        if (RadioCurrentWaveband.isFm() || RadioCurrentWaveband.isAm()) {
            RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
        }
        this.manualAsssignedLogo = bl;
        AmFmPresetApi.toPersistence(this.mWaveband);
        return this.mPresetStation;
    }

    void setName(String string, boolean bl) {
        if (!StringUtil.equalsIgnoreCase(this.mPresetStation.getName(), string)) {
            this.mPresetStation.setName(string);
            this.updateDsi();
            if (bl) {
                this.updatePresetOnChange();
            }
            AmFmPresetApi.toPersistence(this.mWaveband);
        }
    }

    public void updatePresetOnChange() {
        AmFmPresetApi.updateGuiList(RadioCurrentWaveband.get());
        this.updateGuiPresetIndex();
        RadioDataApi.requestPersistStationLogosInSouthSideDb();
    }

    void setStation(AmFmStation amFmStation, boolean bl, boolean bl2) {
        if (null == amFmStation || amFmStation.getFrequency() <= 0) {
            return;
        }
        AmFmPreset amFmPreset = AmFmPresetApi.getPreset(amFmStation);
        ResourceLocator resourceLocator = null;
        boolean bl3 = false;
        if (null != amFmPreset && null != amFmPreset.getImage()) {
            resourceLocator = new ResourceLocator(amFmPreset.getImage().getId(), amFmPreset.getImage().getUrl());
            bl3 = amFmPreset.manualAsssignedLogo;
        }
        if (null == resourceLocator && ServiceManager.configManagerDiag.isFeatureFlagSet(2) && amFmStation != null) {
            boolean bl4;
            Object object;
            if (null == resourceLocator && (object = RadioData.getAmfmDatabase().getCurrentHDStation()) != null && amFmStation.getFrequency() == ((HdStationInfo)object).getFrequency() && amFmStation.getServiceId() == ((HdStationInfo)object).getServiceId() && (bl4 = RadioUtil.isValid(((HdStationInfo)object).getStationArt()))) {
                resourceLocator = ((HdStationInfo)object).getStationArt();
            }
            if (null == resourceLocator) {
                object = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(amFmStation.getFrequency(), amFmStation.getServiceId());
                if (null != object && (bl4 = RadioUtil.isValid(((AmFmStation)object).getStationArt()))) {
                    resourceLocator = ((AmFmStation)object).getStationArt();
                }
                if (null == resourceLocator && (bl4 = RadioUtil.isValid(amFmStation.getStationArt()))) {
                    resourceLocator = amFmStation.getStationArt();
                }
            }
        }
        if (!RadioUtil.isValid(resourceLocator)) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(" getAmFmStationArt: locator.id <= 0 && null == locator.url ").log();
            }
            resourceLocator = null;
        }
        this.logoDeletedIntentionallyForNar = false;
        this.setImage(resourceLocator, bl3);
        this.mPresetStation.copyOf(amFmStation);
        this.mPresetStation.setMpsWithSPSAlreadyStored(false);
        this.mPresetStation.setMpsWithoutSPSAlreadyStored(false);
        if (!this.mPresetStation.isRds()) {
            this.mPresetStation.setPI(-1);
        }
        this.autoStoredLogoState = 0;
        this.setStationName();
        this.stationLogoType = 0;
        this.updateDsi();
        this.deleteDatabaseStationId();
        if (bl2 && null == resourceLocator) {
            this.getStationLogosFromDatabaseSouthSide();
        }
        if (bl) {
            this.updatePresetOnChange();
        }
        AmFmPresetApi.toPersistence(this.mWaveband);
    }

    private void getStationLogosFromDatabaseSouthSide() {
        if (!RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() || ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            return;
        }
        if (this.mWaveband == 1) {
            RadioDataApi.requestRadioFmStationLogos(new AmFmStation[]{this.mPresetStation}, 1);
        } else if (this.mWaveband == 0) {
            RadioDataApi.requestRadioAmStationLogos(new AmFmStation[]{this.mPresetStation}, 0);
        }
    }

    void setAmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        if (radioStationDataRequest.getFrequency() == (long)this.mPresetStation.getFrequency() || n == 5 && null == this.stationImage) {
            this.setDataFromDatabaseSouthSide(resourceLocator, n, "");
        }
    }

    void setFmStationDataFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n, String string) {
        if (n == 5 && null == this.stationImage) {
            this.setDataFromDatabaseSouthSide(resourceLocator, n, "");
        } else if (!ProgramIdentification.isValidPI(this.mPresetStation.getPi()) && !ProgramIdentification.isValidPI(radioStationDataRequest.getPiSid())) {
            if (radioStationDataRequest.getFrequency() == (long)this.mPresetStation.getFrequency()) {
                this.setDataFromDatabaseSouthSide(resourceLocator, n, string);
            }
        } else if (RadioCodingAdapter.isPiActivated() && ProgramIdentification.isValidPI(this.mPresetStation.getPi()) && ProgramIdentification.isValidPI(radioStationDataRequest.getPiSid()) && this.mPresetStation.getPi() == radioStationDataRequest.getPiSid()) {
            this.setDataFromDatabaseSouthSide(resourceLocator, n, string);
        }
    }

    void setDatabaseDataForAmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        RadioStationData[] radioStationDataArray;
        ResourceLocator[] resourceLocatorArray;
        if (null == radioStationLogoResponse) {
            return;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AmFmPreset - setDatabaseDataForAmPreset - stationLogoResponse : ").append(radioStationLogoResponse).log();
        }
        if (null != (resourceLocatorArray = radioStationLogoResponse.getResourceLocators()) && resourceLocatorArray.length > 0 && null != (radioStationDataArray = resourceLocatorArray[0])) {
            this.setAmStationLogoFromDatabaseSouthSide((ResourceLocator)radioStationDataArray, radioStationDataRequest, n);
        }
        if (null == this.stationImage && null != (radioStationDataArray = RadioDataApi.getGenericAmLogoFromHmiLogoBuffer())) {
            this.setDataFromDatabaseSouthSide((ResourceLocator)radioStationDataArray, 5, "");
        }
        if (null != (radioStationDataArray = radioStationLogoResponse.getRadioStationData()) && radioStationDataArray.length > 0 && null != radioStationDataArray[0]) {
            this.setAmDatabaseStationId(radioStationDataArray[0].getStationId(), radioStationDataRequest);
        }
    }

    void setAmDatabaseStationId(int n, RadioStationDataRequest radioStationDataRequest) {
        if (radioStationDataRequest.getFrequency() == (long)this.mPresetStation.getFrequency()) {
            this.setDatabaseStationId(n);
        }
    }

    void setDatabaseDataForFmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        RadioStationData[] radioStationDataArray;
        ResourceLocator[] resourceLocatorArray;
        if (null == radioStationLogoResponse) {
            return;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AmFmPreset - setDatabaseDataForAmPreset - stationLogoResponse : ").append(radioStationLogoResponse).log();
        }
        if (null != (resourceLocatorArray = radioStationLogoResponse.getResourceLocators()) && resourceLocatorArray.length > 0 && null != (radioStationDataArray = resourceLocatorArray[0])) {
            String string = "";
            RadioStationData[] radioStationDataArray2 = radioStationLogoResponse.getRadioStationData();
            if (null != radioStationDataArray2 && radioStationDataArray2.length > 0 && null != radioStationDataArray2[0]) {
                string = radioStationDataArray2[0].shortName;
            }
            if (null == string) {
                string = "";
            }
            this.setFmStationDataFromDatabaseSouthSide((ResourceLocator)radioStationDataArray, radioStationDataRequest, n, string);
        }
        if (null == this.stationImage && null != (radioStationDataArray = RadioDataApi.getGenericFmLogoFromHmiLogoBuffer())) {
            this.setDataFromDatabaseSouthSide((ResourceLocator)radioStationDataArray, 5, "");
        }
        if (null != (radioStationDataArray = radioStationLogoResponse.getRadioStationData()) && radioStationDataArray.length == 1 && null != radioStationDataArray[0]) {
            this.setFmDatabaseStationId(radioStationDataArray[0].getStationId(), radioStationDataRequest);
        }
    }

    void setFmDatabaseStationId(int n, RadioStationDataRequest radioStationDataRequest) {
        if (!ProgramIdentification.isValidPI(this.mPresetStation.getPi()) && !ProgramIdentification.isValidPI(radioStationDataRequest.getPiSid())) {
            if (radioStationDataRequest.getFrequency() == (long)this.mPresetStation.getFrequency()) {
                this.setDatabaseStationId(n);
            }
        } else if (RadioCodingAdapter.isPiActivated() && ProgramIdentification.isValidPI(this.mPresetStation.getPi()) && ProgramIdentification.isValidPI(radioStationDataRequest.getPiSid()) && this.mPresetStation.getPi() == radioStationDataRequest.getPiSid()) {
            this.setDatabaseStationId(n);
        }
    }

    void setManualAssignedFmStationLogo(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        if (!ProgramIdentification.isValidPI(this.mPresetStation.getPi()) && !ProgramIdentification.isValidPI(amFmStation.getPi())) {
            if (amFmStation.getFrequency() == this.mPresetStation.getFrequency()) {
                this.setManualAssignedStationLogo(resourceLocator);
            }
        } else if (RadioCodingAdapter.isPiActivated() && this.mPresetStation.getPi() == amFmStation.getPi()) {
            this.setManualAssignedStationLogo(resourceLocator);
        }
    }

    void setManualAssignedAmStationLogo(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        if (amFmStation.getFrequency() == this.mPresetStation.getFrequency()) {
            this.setManualAssignedStationLogo(resourceLocator);
        }
    }

    void setManualAssignedStationLogo(ResourceLocator resourceLocator) {
        this.stationImage = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
        this.manualAsssignedLogo = true;
        this.stationLogoType = 1;
        AmFmPresetApi.toPersistence(this.mWaveband);
    }

    private void setDataFromDatabaseSouthSide(ResourceLocator resourceLocator, int n, String string) {
        if (null == this.stationImage || this.stationLogoType == 5 || this.stationLogoType == 4 && n == 3) {
            AmFmPresetList amFmPresetList;
            this.stationImage = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            this.manualAsssignedLogo = false;
            this.stationLogoType = n;
            if (null != this.mPresetStation && null != string && string.length() > 0 && RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForPresets() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && this.mPresetStation.getName().length() < 1) {
                this.mPresetStation.setName(string);
            }
            if ((amFmPresetList = AmFmPresetApi.getList(RadioCurrentWaveband.get())) != null && this.mListIndex == amFmPresetList.getIndex()) {
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
            }
            AmFmPresetApi.toPersistence(this.mWaveband);
        }
    }

    private void setStationName() {
        try {
            if (null != this.mPresetStation && this.mPresetStation.getWaveband() == 1) {
                Object object;
                Object object2 = RadioData.getAmfmDatabase().getFixedStationList().getName(this.mPresetStation.getPi(), this.mPresetStation.getFrequency());
                if (object2 == null && RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForPresets() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() && this.mPresetStation.getName().length() < 1) {
                    object = RadioDataApi.getFmStationNameFromHmiDataBuffer(this.mPresetStation);
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmPreset - setStationName() - ").append("stationNameDb: ").append((String)object).log();
                    }
                    if (null != object && ((String)object).length() > 0) {
                        object2 = object;
                    }
                }
                if ((null == object2 || ((String)object2).length() < 1) && this.mPresetStation.getName().length() < 1 && ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (object = RadioData.getAmfmDatabase().getStationNameFreqList())) {
                    object2 = ((StationNameFreqList)object).getStationName(this.mPresetStation.getFrequency());
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmPreset - setStationName() - ").append("Name from NAV database: ").append((String)object2).log();
                    }
                }
                if (object2 == null) {
                    object2 = RadioData.getAmfmDatabase().getFixedStationList().getFreezedPS();
                }
                if (object2 == null) {
                    object2 = this.mPresetStation.getName();
                }
                this.mPresetStation.setName((String)object2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateCurrentPresetStationInfo(AmFmStation amFmStation) {
        if (amFmStation.getFrequency() <= 0) {
            return;
        }
        if (this.checkForPresetValuesChanged(amFmStation)) {
            this.mPresetStation.copyOf(amFmStation);
            AmFmPresetApi.toPersistence(this.mWaveband);
            this.updateDsi();
        }
    }

    private boolean checkForPresetValuesChanged(AmFmStation amFmStation) {
        boolean bl = false;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            if (this.mPresetStation.getFrequency() != amFmStation.getFrequency() || this.mPresetStation.getServiceId() != amFmStation.getServiceId() || !this.mPresetStation.getShortNameHD().equalsIgnoreCase(amFmStation.getShortNameHD()) || this.mPresetStation.isHD() != amFmStation.isHD()) {
                bl = true;
            }
        } else if (this.mPresetStation.getFrequency() != amFmStation.getFrequency() || this.mPresetStation.getPi() != amFmStation.getPi() || !this.mPresetStation.getName().equalsIgnoreCase(amFmStation.getName())) {
            bl = true;
        }
        return bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        if (this.mWaveband == 0) {
            stringBuffer.append("AM");
        } else if (this.mWaveband == 1) {
            stringBuffer.append("FM");
        } else {
            stringBuffer.append("UNKNOWN");
        }
        stringBuffer.append(" Preset ");
        stringBuffer.append(this.getIndex());
        stringBuffer.append(" freq=");
        stringBuffer.append(this.getFrequency());
        if (this.stationImage != null) {
            stringBuffer.append(" image=");
            stringBuffer.append(this.getImage().getId());
        }
        if (this.mWaveband == 1) {
            stringBuffer.append(" pi=");
            stringBuffer.append(Integer.toHexString(this.mPresetStation.getPi()));
            stringBuffer.append(" name=");
            stringBuffer.append(this.mPresetStation.getName());
            stringBuffer.append(" short name=");
            stringBuffer.append(this.mPresetStation.getShortNameHD());
        }
        stringBuffer.append(" HD =");
        stringBuffer.append(this.mPresetStation.isHD());
        stringBuffer.append(" ServiceID =");
        stringBuffer.append(this.mPresetStation.getServiceId());
        stringBuffer.append(" databaseStationId =");
        stringBuffer.append(this.getDatabaseStationId());
        return stringBuffer.toString();
    }

    void updateGuiPresetIndex() {
        if (this.isValid()) {
            AmFmStation amFmStation = this.getPresetStation();
            AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(amFmStation), this.mListIndex);
        }
    }

    void fillCollector(AMPresetListInfoCollector aMPresetListInfoCollector) {
        if (!this.isEmpty() && this.mWaveband == 0) {
            aMPresetListInfoCollector.frequency = this.mPresetStation.getFrequency();
            aMPresetListInfoCollector.hdStationNumber = -1;
            aMPresetListInfoCollector.name = ServiceManager.configManagerDiag.isFeatureFlagSet(423) ? this.mPresetStation.getName() : "";
            if (this.mPresetStation != null && this.mPresetStation.isHD() && AmFmHDOptionRequester.getAm()) {
                aMPresetListInfoCollector.hdStationNumber = 0;
            }
            if (this.stationImage != null) {
                aMPresetListInfoCollector.storedLogoState = 2;
                aMPresetListInfoCollector.listState = true;
            } else {
                aMPresetListInfoCollector.storedLogoState = 0;
                aMPresetListInfoCollector.listState = false;
            }
            aMPresetListInfoCollector.imageResoureLocator = this.stationImage;
            aMPresetListInfoCollector.isElemtStored = true;
        } else {
            aMPresetListInfoCollector.frequency = 0;
            aMPresetListInfoCollector.imageResoureLocator = null;
            aMPresetListInfoCollector.isElemtStored = false;
            aMPresetListInfoCollector.listState = false;
        }
        aMPresetListInfoCollector.iDLong = 0L;
        aMPresetListInfoCollector.stationNumberHD = "";
    }

    void fillCollector(FMPresetListInfoCollector fMPresetListInfoCollector) {
        fMPresetListInfoCollector.attributes = 0;
        if (!this.isEmpty() && this.mWaveband == 1) {
            AmFmStationListFM amFmStationListFM;
            fMPresetListInfoCollector.frequency = this.mPresetStation.getFrequency();
            String string = this.mPresetStation.getStationName();
            fMPresetListInfoCollector.name = string != null ? (ServiceManager.configManagerDiag.isFeatureFlagSet(2) || ServiceManager.configManagerDiag.isFeatureFlagSet(418) || ServiceManager.configManagerDiag.isFeatureFlagSet(423) || RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForPresets() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive() ? string : (null != RadioCodingAdapter.mAmFmCodingData && (!RadioCodingAdapter.isPiActivated() || !AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated()) ? "" : string)) : "";
            fMPresetListInfoCollector.pi = this.mPresetStation.getPi();
            AmFmStation amFmStation = null;
            if (null != RadioData.getAmfmDatabase() && null != (amFmStationListFM = RadioData.getAmfmDatabase().getAslStationListFM())) {
                amFmStation = amFmStationListFM.getByFrequencyAndPi(this.mPresetStation.getFrequency(), this.mPresetStation.getPi());
            }
            if (amFmStation != null) {
                fMPresetListInfoCollector.attributes = fMPresetListInfoCollector.attributes | (amFmStation.isTp() || amFmStation.isTa() ? 32 : 0);
                fMPresetListInfoCollector.attributes = fMPresetListInfoCollector.attributes | (amFmStation.isTmc() ? 64 : 0);
            }
            fMPresetListInfoCollector.isElementStored = true;
            fMPresetListInfoCollector.imageResourceLocator = this.stationImage;
            fMPresetListInfoCollector.storedLogoState = null == this.stationImage ? 0 : 2;
            fMPresetListInfoCollector.autoStoredImageString = "";
        } else {
            fMPresetListInfoCollector.frequency = 0;
            fMPresetListInfoCollector.storedLogoState = 0;
            fMPresetListInfoCollector.imageResourceLocator = null;
            fMPresetListInfoCollector.isElementStored = false;
            fMPresetListInfoCollector.name = "";
        }
        fMPresetListInfoCollector.hdStationNumber = -1;
    }

    void fillCollectorHD(FMPresetListInfoCollector fMPresetListInfoCollector, boolean bl) {
        fMPresetListInfoCollector.attributes = 0;
        if (!this.isEmpty() && this.mWaveband == 1) {
            fMPresetListInfoCollector.frequency = this.mPresetStation.getFrequency();
            fMPresetListInfoCollector.name = this.mPresetStation.getName();
            AmFmStation amFmStation = null;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(" Stored preset information on index : ").append(this.mListIndex).append(" Frequency = ").append(this.mPresetStation.getFrequency()).append(" Service ID = ").append(this.mPresetStation.getServiceId()).log();
            }
            if (null != RadioData.getAmfmDatabase()) {
                if (bl) {
                    amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                } else {
                    AmFmStationListFM amFmStationListFM = RadioData.getAmfmDatabase().getAslStationListFM();
                    if (null != amFmStationListFM) {
                        amFmStation = amFmStationListFM.getStationWithFrequencyHDAndSubChannel(this.mPresetStation.getFrequency(), this.mPresetStation.isHD(), this.mPresetStation.getServiceId());
                    }
                }
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(" Station in the fill collector for presets : ").append(amFmStation != null ? amFmStation.toString() : "null").log();
            }
            if (amFmStation != null && amFmStation.isHD() && AmFmHDOptionRequester.getFm()) {
                fMPresetListInfoCollector.name = amFmStation.getShortNameHD();
            }
            if (null != this.mPresetStation && this.mPresetStation.isHD() && AmFmHDOptionRequester.getFm()) {
                if (null != RadioData.getAmfmDatabase() && (RadioData.getAmfmDatabase().hasSubServiceList(this.mPresetStation) || this.mPresetStation.getServiceId() > 1)) {
                    if (!this.mPresetStation.getMpsWithoutSPSAlreadyStored()) {
                        fMPresetListInfoCollector.hdStationNumber = this.mPresetStation.getSubChannel();
                    }
                    if (this.mPresetStation.getServiceId() == 1 && !this.mPresetStation.getMpsWithoutSPSAlreadyStored()) {
                        this.mPresetStation.setMpsWithSPSAlreadyStored(true);
                    } else if (this.mPresetStation.getServiceId() == 1 && this.mPresetStation.getMpsWithoutSPSAlreadyStored()) {
                        fMPresetListInfoCollector.hdStationNumber = 0;
                    }
                } else if (this.mPresetStation.getMpsWithSpsAlreadyStored()) {
                    fMPresetListInfoCollector.hdStationNumber = 1;
                } else {
                    fMPresetListInfoCollector.hdStationNumber = 0;
                    this.mPresetStation.setMpsWithoutSPSAlreadyStored(true);
                }
            } else {
                fMPresetListInfoCollector.hdStationNumber = -1;
            }
            if (this.stationImage != null) {
                fMPresetListInfoCollector.storedLogoState = this.manualAsssignedLogo ? 2 : 1;
                fMPresetListInfoCollector.imageResourceLocator = this.stationImage;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("##@@##-> fillCollectorHD in AmFmPreset: ").append(" PresetFreq: ").append(this.mPresetStation.getFrequency()).append(" PresetServID: ").append(this.mPresetStation.getServiceId()).append(" stationImageID: ").append(this.stationImage.getId()).append("  stationImageURL: ").append(this.stationImage.getUrl()).log();
                }
            } else {
                fMPresetListInfoCollector.storedLogoState = 0;
                fMPresetListInfoCollector.imageResourceLocator = null;
            }
            fMPresetListInfoCollector.isElementStored = true;
        } else {
            fMPresetListInfoCollector.frequency = 0;
            fMPresetListInfoCollector.imageResourceLocator = null;
            fMPresetListInfoCollector.storedLogoState = 0;
            fMPresetListInfoCollector.isElementStored = false;
            fMPresetListInfoCollector.name = "";
            fMPresetListInfoCollector.hdStationNumber = -1;
        }
    }

    void updateDsi() {
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (this.mWaveband == 1 && null != dSIAMFMTuner) {
            if (this.isEmpty()) {
                dSIAMFMTuner.freePreset(this.mListIndex);
            } else {
                dSIAMFMTuner.isOnPreset(this.mPresetStation.getFrequency(), this.mPresetStation.getPi(), this.mListIndex, this.mPresetStation.getShortNameHD());
            }
        }
    }

    public static void setFeedbackEvent(int n, int n2) {
        answerTargetId = n;
        answerEventId = n2;
    }

    public void deleteLogo() {
        this.autoStoredLogoState = 0;
        this.setImage(null, false);
        this.stationLogoType = 0;
        if (RadioCurrentWaveband.isAm()) {
            RadioDataApi.deleteAmLogoFromHmiLogoBuffer(this.getPresetStation());
        } else {
            RadioDataApi.deleteFmLogoFromHmiLogoBuffer(this.getPresetStation());
        }
        this.setLogoDeletedIntentionallyForNar(true);
        AmFmPresetApi.toPersistence(this.mWaveband);
    }

    public int getAutoStoredLogoState() {
        return this.autoStoredLogoState;
    }

    public void setAutoStoredLogoState(int n) {
        this.autoStoredLogoState = n;
    }

    public int getStationLogoType() {
        return this.stationLogoType;
    }

    public void setStationLogoType(int n) {
        this.stationLogoType = n;
    }

    boolean updateStationLogoFromStationList(AmFmStation amFmStation) {
        try {
            AmFmStation amFmStation2 = RadioData.mAmfmDatabase.getCurrentStation();
            if (null != amFmStation && null != this.mPresetStation && amFmStation.getFrequency() == this.mPresetStation.getFrequency() && amFmStation.getSubChannel() == this.mPresetStation.getSubChannel() && amFmStation.getShortNameHD().equals(this.mPresetStation.getShortNameHD()) && (amFmStation2 == null || amFmStation2.getFrequency() == amFmStation.getFrequency()) && !this.manualAsssignedLogo) {
                ResourceLocator resourceLocator = amFmStation.getStationArt();
                if (!RadioUtil.isValid(resourceLocator)) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(" AmFmPreset - updateStationLogoFromStationList: newLogo.id <= 0 && null == newLogo.url ").log();
                    }
                    return false;
                }
                if (!RadioUtil.equals(resourceLocator, this.stationImage)) {
                    this.setImage(resourceLocator, false);
                    AmFmPresetList amFmPresetList = AmFmPresetApi.getList(RadioCurrentWaveband.get());
                    if (amFmPresetList != null && this.mListIndex == amFmPresetList.getIndex()) {
                        RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
                    }
                    return true;
                }
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    void updateStationLogoFromDatabase(RadioStationData radioStationData, ResourceLocator resourceLocator) {
        if (null != radioStationData && null != this.mPresetStation && radioStationData.getFrequency() == (long)this.mPresetStation.getFrequency() && radioStationData.getPiSid() == this.mPresetStation.getPi() && radioStationData.getSubChannelId() == this.mPresetStation.getSubChannel()) {
            this.stationImage = null == resourceLocator ? null : new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
            AmFmPresetList amFmPresetList = AmFmPresetApi.getList(RadioCurrentWaveband.get());
            if (amFmPresetList != null && this.mListIndex == amFmPresetList.getIndex()) {
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
            }
        }
    }
}


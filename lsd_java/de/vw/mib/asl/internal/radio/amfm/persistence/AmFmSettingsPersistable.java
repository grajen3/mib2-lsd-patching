/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioAdaptationAdapter;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmDefaultSettings;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRegStateOptionRequester;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.radio.HdStationInfo;

public class AmFmSettingsPersistable {
    public static final int USER_SELECTED_HOME_COUNTRY_NOT_AVAILABLE;
    public static final int DATABASE_VERSION_DEFAULT_VALUE;
    public static final int AMFM_DAB_MIN_NO_OF_PRESETS_DEFAULT_VALUE;
    public static final int AMFM_DAB_MAX_NO_OF_PRESETS_DEFAULT_VALUE;
    private HdStationInfo currentHdStation = new HdStationInfo();
    private HdStationInfo previousHdStation = new HdStationInfo();
    public static final int TAGGING_INSTANCE_INVALID_VALUE;
    private int radioInstanceValueForItunes = -1;
    private RadioAmFmSettings radioAmFmSettingsPersistence = null;

    public boolean getRadioTextOption() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isRadiotextOption();
        }
        return false;
    }

    public synchronized void setRadioTextOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRadiotextOption(bl);
        }
    }

    public boolean getRadioTextOnBeforeRDSOff() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isRadiotextOnBeforeRdsOff();
        }
        return false;
    }

    public synchronized void setRadioTextOnBeforeRDSOff(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRadiotextOnBeforeRdsOff(bl);
        }
    }

    public boolean getRadioTextPlusOption() {
        return true;
    }

    public synchronized void setRadioTextPlusOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRadioTextPlusOption(bl);
        }
    }

    public boolean getPty31Option() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isPty31Option();
        }
        return false;
    }

    public synchronized void setPty31Option(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setPty31Option(bl);
        }
    }

    public boolean getTPOption() {
        if (RadioCodingAdapter.isHongKongVariant()) {
            return false;
        }
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isTpOption();
        }
        return false;
    }

    public synchronized void setTPOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setTpOption(bl);
        }
    }

    public boolean isAutoStoreLogoActive() {
        if (null != this.radioAmFmSettingsPersistence) {
            boolean bl = this.radioAmFmSettingsPersistence.isAutoStoreStationLogosActive();
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("AmFmSettingsPersistable - isAutoStoreLogoActive(): ").append(bl).log();
            }
            return bl;
        }
        return false;
    }

    public synchronized void setAutoStoreLogoActive(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("AmFmSettingsPersistable - setAutoStoreLogoActive(): ").append(bl).log();
        }
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAutoStoreStationLogosActive(bl);
            if (AmfmRDSOption.get()) {
                this.setAutoStoreStationLogoOnBeforeRdsOff(bl);
            }
        }
    }

    public boolean isAutoStoreLogoActiveChangedByUser() {
        if (null != this.radioAmFmSettingsPersistence) {
            boolean bl = this.radioAmFmSettingsPersistence.isAutoStoreStationLogosActiveChangedByUser();
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("AmFmSettingsPersistable - isAutoStoreLogoActiveChangedByUser(): ").append(bl).log();
            }
            return bl;
        }
        return false;
    }

    public synchronized void setAutoStoreLogoActiveChangedByUser(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("AmFmSettingsPersistable - setAutoStoreLogoActiveChangedByUser(): ").append(bl).log();
        }
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAutoStoreStationLogosActiveChangedByUser(bl);
        }
    }

    public synchronized void setAutoStoreLogoActive(EventGeneric eventGeneric) {
        try {
            boolean bl = eventGeneric.getBoolean(0);
            AmFmFactory.getAslAmfmModelController().updateLogoAutoStoreActive(bl);
            this.setAutoStoreLogoActive(bl);
            this.setAutoStoreLogoActiveChangedByUser(true);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public synchronized void setEnhancedRadioTextOption(EventGeneric eventGeneric) {
    }

    public synchronized void setEnhancedRadioTextOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setEnhancedRadioTextActive(bl);
            if (AmfmRDSOption.get()) {
                this.setEnhancedRadioTextOptionBeforeRdsOff(bl);
            }
        }
    }

    public synchronized void setEnhancedRadioTextOptionBeforeRdsOff(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setEnhancedRadioTextActiveBeforeRdsOff(bl);
        }
    }

    public boolean isEnhancedRadioTextActive() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isEnhancedRadioTextActive();
        }
        return false;
    }

    public boolean getEnhancedRadioTextActiveBeforeRdsOff() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isEnhancedRadioTextActiveBeforeRdsOff();
        }
        return false;
    }

    public boolean getAFOption() {
        if (null != this.radioAmFmSettingsPersistence) {
            boolean bl = this.radioAmFmSettingsPersistence.isAfOption();
            return bl;
        }
        return false;
    }

    public synchronized void setAFOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAfOption(bl);
        }
    }

    public boolean isAfValueInCoding() {
        boolean bl = false;
        if (null != this.radioAmFmSettingsPersistence) {
            bl = this.radioAmFmSettingsPersistence.isAfValueInCoding();
            return bl;
        }
        return bl;
    }

    public synchronized void setAfValueInCoding(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("AmFmSettingsPersistable - setAfValueInCoding(): ").append(bl).log();
        }
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAfValueInCoding(bl);
        }
    }

    public boolean getAFOnBeforeRDSOff() {
        boolean bl = false;
        if (null != this.radioAmFmSettingsPersistence) {
            bl = this.radioAmFmSettingsPersistence.isAfOnBeforeRdsOff();
        }
        return bl;
    }

    public synchronized void setAFOnBeforeRDSOff(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAfOnBeforeRdsOff(bl);
        }
    }

    public boolean getTpOnBeforeRdsOff() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isTpOnBeforeRdsOff();
        }
        return false;
    }

    public synchronized void setTpOnBeforeRdsOff(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setTpOnBeforeRdsOff(bl);
        }
    }

    public boolean getAutoStoreStationLogoOnBeforeRdsOff() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isAutoStoreStationLogosActiveBeforeRdsOff();
        }
        return false;
    }

    public synchronized void setAutoStoreStationLogoOnBeforeRdsOff(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAutoStoreStationLogosActiveBeforeRdsOff(bl);
        }
    }

    public int getREGOption() {
        if (RadioCodingAdapter.isHongKongVariant()) {
            return 1;
        }
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getRegOption();
        }
        return 0;
    }

    public synchronized void setREGOption(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRegOption(n);
        }
    }

    public boolean getREGFixBeforeRDSOff() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isRegFixBeforeRdsOff();
        }
        return false;
    }

    public synchronized void setREGFixBeforeRDSOff(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRegFixBeforeRdsOff(bl);
        }
    }

    public int getFmStationListSortOrder() {
        if (RadioCodingAdapter.isHongKongVariant()) {
            return 0;
        }
        if (!RadioCodingAdapter.isPiActivated()) {
            return 2;
        }
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getFmStationListSortOrder();
        }
        return 0;
    }

    public synchronized void setFmStationListSortOrder(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                break;
            }
            default: {
                n = 0;
            }
        }
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setFmStationListSortOrder(n);
        }
    }

    public int getAmRangeOption() {
        int n = 2;
        if (null != this.radioAmFmSettingsPersistence) {
            n = this.radioAmFmSettingsPersistence.getAmRangeOption();
        }
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("AmFmSettingsPersistable - getAmRangeOption() - amRange = ").append(n).log();
        }
        return n;
    }

    public synchronized void setAmRangeOption(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAmRangeOption(n);
        }
    }

    public int getScopeOfArrowKeysOption() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getScopeOfArrowButton();
        }
        return 0;
    }

    public synchronized void setScopeOfArrowKeysOption(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setScopeOfArrowButton(n);
        }
    }

    public int getWaveband() {
        int n = 1;
        if (null != this.radioAmFmSettingsPersistence) {
            n = this.radioAmFmSettingsPersistence.getWaveBand();
        }
        if (null != RadioCodingAdapter.mAmFmCodingData && RadioCodingAdapter.isAmDisabled() && 0 == n) {
            n = 1;
        }
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("AmFmSettingsPersistable - getWaveband() - result = ").append(n).log();
        }
        return n;
    }

    public synchronized void setWaveband(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setWaveBand(n);
        }
    }

    public boolean getRDSOption() {
        if (RadioCodingAdapter.isFMBandJapan()) {
            return false;
        }
        boolean bl = false;
        if (RadioCodingAdapter.isRdsButtonVisible()) {
            if (null != this.radioAmFmSettingsPersistence) {
                bl = this.radioAmFmSettingsPersistence.isRdsOption();
            }
        } else {
            bl = RadioCodingAdapter.isRdsActivated();
        }
        return bl;
    }

    public boolean getUserSelectedRdsValue() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isRdsOption();
        }
        return false;
    }

    public synchronized void setRDSOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRdsOption(bl);
        }
    }

    public boolean isRdsValueInCoding() {
        boolean bl = false;
        if (null != this.radioAmFmSettingsPersistence) {
            bl = this.radioAmFmSettingsPersistence.isRdsValueInCoding();
        }
        return bl;
    }

    public synchronized void setRdsValueInCoding(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("AmFmSettingsPersistable - setRdsValueInCoding(): ").append(bl).log();
        }
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setRdsValueInCoding(bl);
        }
    }

    public AmFmStation getCurrentFmStation() {
        AmFmStationPersistence amFmStationPersistence = null;
        if (null != this.radioAmFmSettingsPersistence) {
            amFmStationPersistence = this.radioAmFmSettingsPersistence.getCurrentFmStation();
        }
        AmFmStation amFmStation = null;
        if (null == amFmStationPersistence) {
            amFmStation = new AmFmStation(1, AmFmDefaultSettings.getFmDefaultFrequency());
        } else {
            amFmStation = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createAmFmStationHmi(amFmStationPersistence);
            if (null == amFmStation || !amFmStation.isValidFmStation()) {
                amFmStation = new AmFmStation(1, AmFmDefaultSettings.getFmDefaultFrequency());
            }
        }
        return amFmStation;
    }

    public AmFmStationPersistence getCurrentFmStationPersistence() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getCurrentFmStation();
        }
        return null;
    }

    public AmFmStationPersistence getCurrentAmStationPersistence() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getCurrentAmStation();
        }
        return null;
    }

    public AmFmStationPersistence getCurrentStationPersistence() {
        if (RadioCurrentWaveband.isFm()) {
            return this.getCurrentFmStationPersistence();
        }
        if (RadioCurrentWaveband.isAm()) {
            return this.getCurrentAmStationPersistence();
        }
        return null;
    }

    public synchronized void setCurrentFmStation(AmFmStation amFmStation) {
        Object object;
        if (RadioServiceManager.getServiceManager().isAmFmStationOverridenNotAllowed()) {
            ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("setCurrentFmStation() - failed due to overridden not allowed").log();
            return;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            object = ServiceManager.logger.trace(128);
            object.append(RadioUtil.LOG_PREFIX_AMFM).append("setting LSM FM station: ").append(amFmStation.toLogString((LogMessage)object)).log();
        }
        if (amFmStation == null || !amFmStation.isValidFmStation()) {
            amFmStation = new AmFmStation(1, AmFmDefaultSettings.getFmDefaultFrequency());
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(423)) {
            amFmStation.setName(RadioServiceManager.getServiceManager().getCorrectFmStationName(amFmStation));
        }
        object = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createAmFmStationPersistence(amFmStation);
        if (null != this.radioAmFmSettingsPersistence && null != object) {
            this.radioAmFmSettingsPersistence.setCurrentFmStation((AmFmStationPersistence)object);
        }
    }

    public AmFmStation getCurrentAmStation() {
        AmFmStationPersistence amFmStationPersistence = null;
        if (null != this.radioAmFmSettingsPersistence) {
            amFmStationPersistence = this.radioAmFmSettingsPersistence.getCurrentAmStation();
        }
        AmFmStation amFmStation = null;
        if (null == amFmStationPersistence) {
            amFmStation = new AmFmStation(3, AmFmDefaultSettings.getAmDefaultFrequency());
        } else {
            amFmStation = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createAmFmStationHmi(amFmStationPersistence);
            if (null == amFmStation || !amFmStation.isValidAmStation()) {
                amFmStation = new AmFmStation(3, AmFmDefaultSettings.getAmDefaultFrequency());
            }
        }
        return amFmStation;
    }

    public synchronized void setCurrentAmStation(AmFmStation amFmStation) {
        String string;
        Object object;
        if (RadioServiceManager.getServiceManager().isAmFmStationOverridenNotAllowed()) {
            ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("setCurrentAmStation() - failed due to overridden not allowed").log();
            return;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            object = ServiceManager.logger.trace(128);
            object.append(RadioUtil.LOG_PREFIX_AMFM).append("setting LSM AM station: ").append(amFmStation.toLogString((LogMessage)object)).log();
        }
        if (amFmStation == null || !amFmStation.isValidAmStation()) {
            amFmStation = new AmFmStation(3, AmFmDefaultSettings.getAmDefaultFrequency());
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != (object = RadioData.getAmfmDatabase().getStationNameFreqList()) && (string = ((StationNameFreqList)object).getStationName(amFmStation.getFrequency())).length() > 0) {
            amFmStation.setName(string);
        }
        object = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createAmFmStationPersistence(amFmStation);
        if (null != this.radioAmFmSettingsPersistence && null != object) {
            this.radioAmFmSettingsPersistence.setCurrentAmStation((AmFmStationPersistence)object);
        }
    }

    public synchronized void setFmRangeOption(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setFmRange(n);
        }
    }

    public int getFmRangeOption() {
        int n = 0;
        if (null != this.radioAmFmSettingsPersistence) {
            n = this.radioAmFmSettingsPersistence.getFmRange();
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("AmFmSettingsPersistable - getFmRangeOption() - fmRange = ").append(n).log();
        }
        return n;
    }

    public int getFmViewState() {
        int n = 0;
        if (null != this.radioAmFmSettingsPersistence) {
            n = this.radioAmFmSettingsPersistence.getFmViewState();
        }
        return n;
    }

    public synchronized void setFmViewState(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setFmViewState(n);
        }
    }

    public int getAmViewState() {
        int n = 0;
        if (null != this.radioAmFmSettingsPersistence) {
            n = this.radioAmFmSettingsPersistence.getAmViewState();
        }
        return n;
    }

    public synchronized void setAmViewState(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAmViewState(n);
        }
    }

    public synchronized void setAMHDSetupOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAmHdOption(bl);
        }
    }

    public boolean getAMHDSetupOption() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isAmHdOption();
        }
        return false;
    }

    public synchronized void setTiJapanFrequency(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            if (0 == n) {
                this.radioAmFmSettingsPersistence.setJapanTiFrequency(0);
            } else {
                this.radioAmFmSettingsPersistence.setJapanTiFrequency(1);
            }
        }
    }

    public int getTiJapanFrequency() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getJapanTiFrequency();
        }
        return 0;
    }

    public void setHdStation(HdStationInfo hdStationInfo) {
        this.previousHdStation = null;
        if (this.currentHdStation != null) {
            this.previousHdStation = new HdStationInfo(this.currentHdStation.artistName, this.currentHdStation.albumTitle, this.currentHdStation.songTitle, this.currentHdStation.genre, this.currentHdStation.stationArt, this.currentHdStation.coverArt, this.currentHdStation.language, this.currentHdStation.shortDescription, this.currentHdStation.contentField, this.currentHdStation.price, this.currentHdStation.validUntil, this.currentHdStation.contactURL, this.currentHdStation.receivedAs, this.currentHdStation.nameOfSeller, this.currentHdStation.comrDescription, this.currentHdStation.mimeType, this.currentHdStation.binaryData, this.currentHdStation.affiliateID, this.currentHdStation.iTunesID, this.currentHdStation.iTunesFrontID, this.currentHdStation.podcastFeedURL, this.currentHdStation.unknownData, this.currentHdStation.frequency, this.currentHdStation.pi, this.currentHdStation.serviceId, this.currentHdStation.stationURL);
        }
        this.currentHdStation = hdStationInfo;
    }

    public HdStationInfo getCurrentHdStation() {
        return this.currentHdStation;
    }

    public HdStationInfo getPreviousHdStation() {
        return this.previousHdStation;
    }

    public void setTaggingInstance(int n) {
        this.radioInstanceValueForItunes = n;
    }

    public int getTaggingInstance() {
        return this.radioInstanceValueForItunes;
    }

    public boolean isHomeCountryUserSelected() {
        if (null != this.radioAmFmSettingsPersistence) {
            int n = this.radioAmFmSettingsPersistence.getUserSelectedHomeCountry();
            return -1 != n;
        }
        return false;
    }

    public int getUserSelectedHomeCountry() {
        int n;
        int n2 = RadioAdaptationAdapter.getStationLogoDbMode();
        if (null != this.radioAmFmSettingsPersistence && -1 != (n = this.radioAmFmSettingsPersistence.getUserSelectedHomeCountry())) {
            n2 = n;
        }
        return n2;
    }

    public void setUserSelectedHomeCountry(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setUserSelectedHomeCountry(n);
        }
    }

    public int getCalculatedHomeCountry() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getCalculatedHomeCountry();
        }
        return 1;
    }

    public void setCalculatedHomeCountry(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            if (n >= 1) {
                this.radioAmFmSettingsPersistence.setCalculatedHomeCountry(n);
            } else {
                this.radioAmFmSettingsPersistence.setCalculatedHomeCountry(1);
            }
        }
    }

    public boolean getHomeCountryAutoSelectionActive() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isHomeCountryAutoSelectionActive();
        }
        return false;
    }

    public void setHomeCountryAutoSelectionActive(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setHomeCountryAutoSelectionActive(bl);
        }
    }

    public synchronized void setFMHDSetupOption(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setFmHdOption(bl);
        }
    }

    public synchronized void setFMHDFilter(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setFmHdFilter(bl);
        }
    }

    public synchronized void setAMHDFilter(boolean bl) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setAmHdFilter(bl);
        }
    }

    public boolean getFMHDSetupOption() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isFmHdOption();
        }
        return false;
    }

    public boolean getFMHDFilter() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isFmHdFilter();
        }
        return false;
    }

    public boolean getAMHDFilter() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.isAmHdFilter();
        }
        return false;
    }

    public synchronized void setDatabaseMajorVersion(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setDatabaseVersionMajor(n);
        }
    }

    public int getDatabaseMajorVersion() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getDatabaseVersionMajor();
        }
        return -1;
    }

    public synchronized void setDatabaseMinorVersion(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setDatabaseVersionMinor(n);
        }
    }

    public int getDatabaseMinorVersion() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getDatabaseVersionMinor();
        }
        return -1;
    }

    public synchronized void setDatabaseRevisionVersion(int n) {
        if (null != this.radioAmFmSettingsPersistence) {
            this.radioAmFmSettingsPersistence.setDatabaseVersionRevision(n);
        }
    }

    public int getDatabaseRevisionVersion() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getDatabaseVersionRevision();
        }
        return -1;
    }

    public int getAmFmNoOfPresets() {
        if (null != this.radioAmFmSettingsPersistence) {
            int n;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmSettingsPersistable - getAmFmNoOfPresets() - null != radioAmFmSettingsPersistence: ").append(this.radioAmFmSettingsPersistence.getAmFmNoOfPresets()).log();
            }
            if ((n = this.radioAmFmSettingsPersistence.getAmFmNoOfPresets()) >= 15 && n <= 18) {
                return n;
            }
        } else if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmSettingsPersistable - getAmFmNoOfPresets() - null == radioAmFmSettingsPersistence: ").append(15).log();
        }
        return 15;
    }

    public void setAmFmNoOfPresets(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmSettingsPersistable - setAmFmNoOfPresets() : ").append(n).log();
        }
        if (null != this.radioAmFmSettingsPersistence && n >= 15 && n <= 18) {
            this.radioAmFmSettingsPersistence.setAmFmNoOfPresets(n);
        }
        RadioConstants.PRESETS_PER_BANK = this.getAmFmNoOfPresets() / 3;
    }

    public int getDabNoOfPresets() {
        if (null != this.radioAmFmSettingsPersistence) {
            return this.radioAmFmSettingsPersistence.getDabNoOfPresets();
        }
        return 15;
    }

    public void setDabNoOfPresets(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("setDabNoOfPresets() : ").append(n).log();
        }
        if (null != this.radioAmFmSettingsPersistence && n >= 15 && n <= 18) {
            this.radioAmFmSettingsPersistence.setDabNoOfPresets(n);
        }
    }

    public void setRadioAmFmSettings(RadioAmFmSettings radioAmFmSettings) {
        this.radioAmFmSettingsPersistence = radioAmFmSettings;
    }

    public static boolean getDefaultRadiotextOptionValue() {
        return true;
    }

    public static boolean getDefaultTpOptionValue() {
        return false;
    }

    public static boolean getDefaultRdsOptionValue() {
        return true;
    }

    public static boolean getDefaultAfOptionValue() {
        return true;
    }

    public static int getDefaultRegOptionValue() {
        return AmfmRegStateOptionRequester.hmiToDsi(0);
    }

    public static int getDefaultScopeOfArrowKeyModeValue() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            return 0;
        }
        return 1;
    }

    public static int getDefaultWavebandValue() {
        return 1;
    }

    public static boolean getDefaultPty31OptionValue() {
        return true;
    }

    public static int getDefaultFmViewStateValue() {
        return 0;
    }

    public static int getDefaultAmViewStateValue() {
        return 0;
    }

    public static boolean getDefaultAmHdOptionValue() {
        return true;
    }

    public static boolean getDefaultRadioTextPlusOptionValue() {
        return true;
    }

    public static int getDefaultFmStationListSortOrderValue() {
        return 1;
    }

    public static boolean getDefaultAutoStoreStationLogosActiveValue() {
        return true;
    }

    public static boolean getDefaultAutoStoreStationLogosActiveChangedByUserValue() {
        return false;
    }

    public static boolean getDefaultAfOnBeforeRdsOffValue() {
        return true;
    }

    public static boolean getDefaultRegFixBeforeRdsOffValue() {
        return false;
    }

    public static boolean getDefaultRadiotextOnBeforeRdsOffValue() {
        return true;
    }

    public static boolean getDefaultTpOnBeforeRdsOffValue() {
        return false;
    }

    public static boolean getDefaultAutoStoreStationLogosActiveBeforeRdsOffValue() {
        return true;
    }

    public static boolean getDefaultEnhancedRadioTextActiveValue() {
        return true;
    }

    public static boolean getDefaultEnhancedRadioTextActiveBeforeRdsOffValue() {
        return true;
    }

    public static boolean getDefaultHomeCountryAutoSelectionActiveValue() {
        return true;
    }

    public static boolean getDefaultFmHdOptionValue() {
        return true;
    }

    public static boolean getDefaultFmHdFilterValue() {
        return false;
    }

    public static boolean getDefaultAmHdFilterValue() {
        return false;
    }

    public static int getDefaultJapanTiFrequencyValue() {
        return 0;
    }

    public static int getDefaultDatabaseVersionValue() {
        return -1;
    }

    public static int getDefaultNoOfPresetsValue() {
        return 15;
    }

    public static int getDefaultUserSelectedHomeCountryValue() {
        return -1;
    }

    public static boolean getDefaultManualAsssignedLogoValue() {
        return false;
    }

    public static boolean getDefaultLogoDeletedIntentionallyForNar() {
        return false;
    }

    public static int getDefaultAutoStoredLogoStateValue() {
        return 0;
    }

    public static int getDefaultStationLogoTypeValue() {
        return 0;
    }

    public static long getDefaultDatabaseStationIdValue() {
        return -1L;
    }

    public static int getDefaultPresetIndexValue() {
        return -1;
    }

    public static int getDefaultFmTunerBandSettings() {
        if (-1 == RadioCodingAdapter.getFmTunerBandSettings()) {
            return 0;
        }
        return RadioCodingAdapter.getFmTunerBandSettings();
    }

    public static int getDefaultAmTunerBandSettings() {
        if (-1 == RadioCodingAdapter.getAmTunerBandSettings()) {
            return 2;
        }
        return RadioCodingAdapter.getAmTunerBandSettings();
    }
}


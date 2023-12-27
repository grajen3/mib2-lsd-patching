/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetModel;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetUpdater;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.transformer.AMPresetListInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMPresetListInfoCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class AmFmPresetListBase
implements AmFmPresetList {
    private final int mWaveband;
    protected int currentIndex = -1;
    private static final int MIN_VISIBLE_BANK_INDEX;
    private static final int MAX_VISIBLE_BANK_INDEX;
    private int lastSelectedPresetIndex = -1;
    protected AmFmPreset[] mPresets = null;
    private final AmFmPresetModel mModel;
    private AmFmPresetUpdater mUpdater;

    public AmFmPresetListBase(AmFmPresetModel amFmPresetModel, int n, int n2) {
        this.mModel = amFmPresetModel;
        this.mWaveband = n;
        this.mPresets = new AmFmPreset[RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets()];
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2] = new AmFmPreset(i2, this.mWaveband);
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AmFmPresetListBase() - Namespace = ").append(5005).append(" ,Key = ").append(n2).append(" ,Waveband = ").append(n).log();
        }
    }

    @Override
    public void setUpdater(AmFmPresetUpdater amFmPresetUpdater) {
        this.mUpdater = amFmPresetUpdater;
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].setUpdater(amFmPresetUpdater);
        }
    }

    @Override
    public int getBankIndex() {
        AmFmPresetSettings amFmPresetSettings = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmPresetSettings();
        if (null != amFmPresetSettings) {
            if (this.mWaveband == 0) {
                return amFmPresetSettings.getCurrentBankIndexAm();
            }
            if (this.mWaveband == 1) {
                return amFmPresetSettings.getCurrentBankIndexFm();
            }
        }
        return 0;
    }

    @Override
    public void setVisibleBankIndex(int n) {
        if (n >= 0 && n <= 2) {
            AmFmPresetSettings amFmPresetSettings = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmPresetSettings();
            if (null != amFmPresetSettings && !AmFmPresetApi.isPersistenceWriteAccessBlocked() && !RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (this.mWaveband == 0) {
                    amFmPresetSettings.setCurrentBankIndexAm(n);
                } else if (this.mWaveband == 1) {
                    amFmPresetSettings.setCurrentBankIndexFm(n);
                }
            }
            this.mUpdater.updateGuiBank();
        }
    }

    public void setVisibleBankIndex(int n, int n2) {
        if (n >= 0 && n <= 2) {
            if (n2 == 1) {
                AmFmFactory.getAslAmfmModelController().updateFmIndexOfPresetBank(n * RadioConstants.PRESETS_PER_BANK);
            } else if (n2 == 0) {
                AmFmFactory.getAslAmfmModelController().updateAmIndexOfPresetBank(n * RadioConstants.PRESETS_PER_BANK);
            }
        }
    }

    @Override
    public void setCurrentIndex(int n) {
        if (n >= -1 && n < this.mPresets.length) {
            this.setIndex(n, false);
            this.mModel.autoCompare();
        }
    }

    @Override
    public void clear() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].clearPreset();
        }
        this.setCurrentIndex(-1);
        this.updateGuiList();
        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(-1L, -1);
        this.toPersistence();
    }

    @Override
    public void clearAndChangeBankIndex(boolean bl) {
        this.clear();
        if (bl) {
            this.setVisibleBankIndex(0);
        }
        RadioDataApi.requestPersistStationLogosInSouthSideDb();
    }

    @Override
    public void delete(int n) {
        if (n >= 0 && n < this.mPresets.length) {
            this.mPresets[n].clear();
            if (n == this.currentIndex) {
                int n2 = this.getIndexOfCurrentStation();
                if (n2 != -1) {
                    this.setIndex(n2, false);
                } else {
                    this.setIndex(-1, false);
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), -1);
                    }
                }
            }
        }
    }

    @Override
    public AmFmStation setImage(int n, ResourceLocator resourceLocator, boolean bl) {
        AmFmStation amFmStation = null;
        if (n >= 0 && n < this.mPresets.length) {
            amFmStation = this.mPresets[n].setImage(resourceLocator, bl);
        }
        return amFmStation;
    }

    @Override
    public AmFmStation deleteLogo(int n) {
        AmFmStation amFmStation = null;
        if (n >= 0 && n < this.mPresets.length && !this.mPresets[n].isEmpty() && null != (amFmStation = this.mPresets[n].getPresetStation())) {
            int n2 = amFmStation.getPi();
            int n3 = amFmStation.getFrequency();
            int n4 = amFmStation.getServiceId();
            String string = amFmStation.getShortNameHD();
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                AmFmStation amFmStation2 = this.mPresets[i2].getPresetStation();
                if (null == amFmStation2 || this.mPresets[i2].isEmpty()) continue;
                int n5 = amFmStation2.getPi();
                int n6 = amFmStation2.getFrequency();
                int n7 = amFmStation2.getServiceId();
                String string2 = amFmStation2.getShortNameHD();
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    if (n3 != n6 || n4 != n7 || !string.equals(string2)) continue;
                    this.mPresets[i2].deleteLogo();
                    continue;
                }
                if (!ProgramIdentification.isValidPI(n2) && !ProgramIdentification.isValidPI(n5)) {
                    if (n3 != n6) continue;
                    this.mPresets[i2].deleteLogo();
                    continue;
                }
                if (!ProgramIdentification.isValidPI(n2) || !ProgramIdentification.isValidPI(n5) || n2 != n5) continue;
                this.mPresets[i2].deleteLogo();
            }
        }
        return amFmStation;
    }

    @Override
    public void setAllImages(ResourceLocator resourceLocator, boolean bl) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].setImage(resourceLocator, bl);
        }
    }

    @Override
    public void changeName(AmFmStation amFmStation) {
        int n = amFmStation.getFrequency();
        int n2 = amFmStation.getPi();
        String string = amFmStation.getName();
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (this.mPresets[i2].isEmpty()) continue;
            if (ProgramIdentification.isLocalStation(n2) || !AmFmAlternativeFrequencySwitch.get()) {
                if (this.mPresets[i2].getPi() != n2 || this.mPresets[i2].getFrequency() != n) continue;
                this.mPresets[i2].setName(string, true);
                continue;
            }
            if (this.mPresets[i2].getPi() != n2) continue;
            this.mPresets[i2].setName(string, true);
        }
    }

    @Override
    public void setAmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].setAmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n);
        }
        this.updateGuiList();
    }

    @Override
    public void setFmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].setFmStationDataFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n, "");
        }
        this.updateGuiList();
    }

    @Override
    public void setDatabaseDataForAmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].setDatabaseDataForAmPreset(radioStationLogoResponse, radioStationDataRequest, n);
        }
        this.updateGuiList();
    }

    @Override
    public void setDatabaseDataForFmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].setDatabaseDataForFmPreset(radioStationLogoResponse, radioStationDataRequest, n);
        }
        this.updateGuiList();
    }

    @Override
    public void setManualAssignedFmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].setManualAssignedFmStationLogo(resourceLocator, amFmStation);
        }
        this.updateGuiList();
    }

    @Override
    public void setManualAssignedAmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].setManualAssignedAmStationLogo(resourceLocator, amFmStation);
        }
        this.updateGuiList();
    }

    @Override
    public ResourceLocator getImage(int n) {
        if (n >= 0 && n < this.mPresets.length) {
            return this.mPresets[n].getImage();
        }
        return null;
    }

    @Override
    public void setStation(int n, AmFmStation amFmStation, boolean bl, boolean bl2) {
        if (n < 0 || n >= this.mPresets.length || null == amFmStation) {
            return;
        }
        this.mPresets[n].setStation(amFmStation, bl, bl2);
        this.setIndex(n, false);
    }

    @Override
    public AmFmPreset get(int n) {
        if (n < 0 || n >= this.mPresets.length) {
            return null;
        }
        return this.mPresets[n];
    }

    @Override
    public int getPresetIndexByStationId(long l, boolean bl) {
        long l2 = -1L;
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (this.mPresets[i2].isEmpty() || (l2 = bl ? this.mPresets[i2].getDatabaseStationId() : this.mPresets[i2].getUniqueId()) != l) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public AmFmPreset getPreset(AmFmStation amFmStation) {
        try {
            int n;
            int n2;
            for (n2 = n = this.getBankIndex() * RadioConstants.PRESETS_PER_BANK; n2 < this.mPresets.length; ++n2) {
                if (!this.mPresets[n2].getPresetStation().match(amFmStation, this.mWaveband)) continue;
                return this.mPresets[n2];
            }
            for (n2 = 0; n2 < n && n2 < this.mPresets.length; ++n2) {
                if (!this.mPresets[n2].getPresetStation().match(amFmStation, this.mWaveband)) continue;
                return this.mPresets[n2];
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public AmFmPreset getPresetFromActiveBank(AmFmStation amFmStation) {
        try {
            int n;
            int n2 = this.getBankIndex();
            for (int i2 = n = n2 * RadioConstants.PRESETS_PER_BANK; i2 < n + RadioConstants.PRESETS_PER_BANK; ++i2) {
                if (!this.mPresets[i2].getPresetStation().match(amFmStation, this.mWaveband)) continue;
                return this.mPresets[i2];
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    @Override
    public void setIndexOfCurrentStation() {
        int n = this.getBankIndex() * RadioConstants.PRESETS_PER_BANK;
        AmFmPresetApi.setPresetIndexForParticleBackgroundService(this.currentIndex, this.mWaveband);
        if (this.currentIndex >= n && this.currentIndex < n + RadioConstants.PRESETS_PER_BANK) {
            return;
        }
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        int n2 = -1;
        if (amFmStation != null) {
            int n3;
            for (n3 = n; n3 < this.mPresets.length; ++n3) {
                if (!this.mPresets[n3].getPresetStation().match(amFmStation, this.mWaveband)) continue;
                n2 = n3;
                break;
            }
            if (n2 == -1) {
                for (n3 = 0; n3 < n; ++n3) {
                    if (!this.mPresets[n3].getPresetStation().match(amFmStation, this.mWaveband)) continue;
                    n2 = n3;
                    break;
                }
            }
        }
        if (n2 != -1) {
            this.setIndex(n2, false);
        }
    }

    private int getIndexOfCurrentStation() {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        int n = -1;
        if (amFmStation != null) {
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                if (!this.mPresets[i2].getPresetStation().match(amFmStation, this.mWaveband)) continue;
                n = i2;
                break;
            }
        }
        return n;
    }

    @Override
    public void syncName(AmFmStation amFmStation) {
        if (amFmStation.isFM() && AmfmRDSOption.get() && amFmStation.getPi() > 0) {
            int n = amFmStation.getFrequency();
            int n2 = amFmStation.getPi();
            if (RadioCodingAdapter.isPiActivated() && n != 0 && n2 != 0) {
                String string = RadioData.getAmfmDatabase().getFixedStationList().getName(n2, n);
                if (string == null) {
                    string = amFmStation.getName();
                }
                if (string != null && string.length() > 0) {
                    for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                        String string2;
                        if (this.mPresets[i2].isEmpty() || !this.match(this.mPresets[i2].getFrequency(), this.mPresets[i2].getPi(), n, n2) || (string2 = this.mPresets[i2].getName()) != null && string2.length() != 0) continue;
                        this.mPresets[i2].setName(string, true);
                    }
                }
            }
        }
    }

    private boolean match(int n, int n2, int n3, int n4) {
        if (ProgramIdentification.isLocalStation(n2) && ProgramIdentification.isLocalStation(n4) || !AmFmAlternativeFrequencySwitch.get()) {
            return n == n3 && n2 == n4;
        }
        return n2 == n4;
    }

    @Override
    public AmFmPreset getNextOccupiedPreset() {
        if (this.lastSelectedPresetIndex >= 0 && this.lastSelectedPresetIndex < this.mPresets.length) {
            int n;
            for (n = this.lastSelectedPresetIndex + 1; n < this.mPresets.length; ++n) {
                if (this.mPresets[n].isEmpty()) continue;
                return this.mPresets[n];
            }
            for (n = 0; n <= this.lastSelectedPresetIndex; ++n) {
                if (this.mPresets[n].isEmpty()) continue;
                return this.mPresets[n];
            }
        } else {
            return this.getFirstOccupiedPreset();
        }
        return null;
    }

    @Override
    public AmFmPreset getPreviousOccupiedPreset() {
        if (this.lastSelectedPresetIndex >= 0 && this.lastSelectedPresetIndex < this.mPresets.length) {
            int n;
            for (n = this.lastSelectedPresetIndex - 1; n >= 0; --n) {
                if (this.mPresets[n].isEmpty()) continue;
                return this.mPresets[n];
            }
            for (n = this.mPresets.length - 1; n >= this.lastSelectedPresetIndex; --n) {
                if (this.mPresets[n].isEmpty()) continue;
                return this.mPresets[n];
            }
        } else {
            return this.getFirstOccupiedPreset();
        }
        return null;
    }

    private AmFmPreset getFirstOccupiedPreset() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (this.mPresets[i2].isEmpty()) continue;
            this.setCurrentIndex(i2);
            return this.mPresets[i2];
        }
        return null;
    }

    private void setIndex(int n, boolean bl) {
        if (n >= 0) {
            this.lastSelectedPresetIndex = n;
        }
        if (this.currentIndex != n || bl) {
            this.currentIndex = n;
            if (this.mWaveband == 1) {
                AmFmFactory.getAslAmfmModelController().updateIndexOfActivatedFmPreset(this.currentIndex);
            } else if (this.mWaveband == 0) {
                AmFmFactory.getAslAmfmModelController().updateIndexOfActivatedAmPreset(this.currentIndex);
            }
            this.toPersistence();
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2) || bl) {
                this.updateGuiList();
            }
        }
        AmFmPresetApi.setPresetIndexForParticleBackgroundService(this.currentIndex, this.mWaveband);
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AmFmPresetListBase setIndex() - newIndex = ").append(n).append(" lastSelectedPresetIndex = ").append(this.lastSelectedPresetIndex).append(" currentIndex = ").append(this.currentIndex).append(" updateList = ").append(bl).log();
        }
    }

    @Override
    public String getCurrentPresetName() {
        String string = "";
        if (this.currentIndex >= 0 && this.currentIndex < this.mPresets.length && null != this.mPresets[this.currentIndex]) {
            string = this.mPresets[this.currentIndex].getName();
        }
        return string;
    }

    @Override
    public boolean activatePreset(int n) {
        boolean bl = false;
        if (null == this.mPresets[n] || this.mPresets[n].isEmpty() || n < 0 || n >= this.mPresets.length) {
            return bl;
        }
        if (this.mPresets[n].activate()) {
            this.setIndex(n, false);
            bl = true;
        }
        return bl;
    }

    @Override
    public AmFmPreset activateNextPreset() {
        int n;
        AmFmPreset amFmPreset = this.getNextOccupiedPreset();
        if (amFmPreset != null && (n = amFmPreset.getIndex()) != this.currentIndex && amFmPreset.activate()) {
            this.setIndex(n, false);
        }
        return amFmPreset;
    }

    @Override
    public AmFmPreset activatePreviousPreset() {
        int n;
        AmFmPreset amFmPreset = this.getPreviousOccupiedPreset();
        if (amFmPreset != null && (n = amFmPreset.getIndex()) != this.currentIndex && amFmPreset.activate()) {
            this.setIndex(n, false);
        }
        return amFmPreset;
    }

    @Override
    public int getIndex() {
        return this.currentIndex;
    }

    @Override
    public void autocompare(AmFmStation amFmStation) {
        if (null == amFmStation) {
            ServiceManager.logger.error(128).append("AmFmPresetListBase - autocompare() - null == station").log();
            return;
        }
        AmFmPreset amFmPreset = this.get(this.currentIndex);
        if (amFmPreset != null) {
            AmFmStation amFmStation2 = amFmPreset.getPresetStation();
            if (null == amFmStation2) {
                ServiceManager.logger.error(128).append("AmFmPresetListBase - autocompare() - null == presetStation").log();
            } else {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("AmFmPresetListBase autocompare() - currentIndex = ").append(this.currentIndex).append(" station = ").append(amFmStation.toString()).append(" presetStation = ").append(amFmStation2.toString()).log();
                }
                if (amFmStation2.match(amFmStation, amFmStation.getAslWaveband())) {
                    this.mUpdater.updateCurrentPreset();
                    return;
                }
            }
        }
        if ((amFmPreset = this.getPreset(amFmStation)) != null) {
            this.setIndex(amFmPreset.getIndex(), false);
        } else {
            this.setIndex(-1, false);
        }
    }

    @Override
    public void autoCompareJapan(boolean bl) {
        StationNameFreqList stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList();
        String string = null;
        boolean bl2 = false;
        if (null != stationNameFreqList) {
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                if (!this.mPresets[i2].isValid()) continue;
                string = stationNameFreqList.getStationName(this.mPresets[i2].getFrequency());
                String string2 = this.mPresets[i2].getName();
                if (string2 != null && string2.length() > 0 || null == string || string.length() <= 0) continue;
                this.mPresets[i2].setName(string, false);
                bl2 = true;
            }
            if (bl2 && bl) {
                this.updateGuiList();
            }
        }
    }

    @Override
    public int calcBankIndex(int n) {
        return n / RadioConstants.PRESETS_PER_BANK;
    }

    @Override
    public boolean isVisible(int n) {
        return this.getBankIndex() == this.calcBankIndex(n);
    }

    @Override
    public int getFirstPresetBankIndexWithEmptyElement() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (!this.mPresets[i2].isEmpty()) continue;
            return i2 / RadioConstants.PRESETS_PER_BANK * RadioConstants.PRESETS_PER_BANK;
        }
        return 0;
    }

    @Override
    public int getFirstOccupiedPresetBankIndex() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            return i2 / RadioConstants.PRESETS_PER_BANK * RadioConstants.PRESETS_PER_BANK;
        }
        return -1;
    }

    @Override
    public boolean getAtLeastOnePresetHasLogo() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty() || null == this.mPresets[i2].getImage()) continue;
            return true;
        }
        return false;
    }

    @Override
    public void updateGuiList() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmPresetListBase - updateGuiList() - START").log();
            }
            if (this.mWaveband == 1) {
                int n;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmPresetListBase - updateGuiList() - Waveband == RadioWavebandAsl.FM").log();
                }
                Object[] objectArray = new FMPresetListInfoCollector[this.mPresets.length];
                for (n = 0; n < objectArray.length; ++n) {
                    objectArray[n] = new FMPresetListInfoCollector();
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        this.mPresets[n].fillCollectorHD((FMPresetListInfoCollector)objectArray[n], false);
                        continue;
                    }
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("mPresets[").append(n).append("].getPresetStation() = ").append(this.mPresets[n].toString()).log();
                    }
                    this.mPresets[n].fillCollector((FMPresetListInfoCollector)objectArray[n]);
                }
                ListManager.getGenericASLList(1461).updateList(objectArray);
                n = this.getFirstPresetBankIndexWithEmptyElement();
                AmFmFactory.getAslAmfmModelController().updateFmPresetBankWithEmptyElement(n);
                n = this.getFirstOccupiedPresetBankIndex();
                AmFmFactory.getAslAmfmModelController().updateIndexOfFirstOccupiedPresetFm(n);
                if (RadioCurrentWaveband.isFm() || RadioCurrentWaveband.isAm()) {
                    if (this.currentIndex < 0 || this.currentIndex >= this.mPresets.length) {
                        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), this.currentIndex);
                    } else {
                        AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(this.mPresets[this.currentIndex].getPresetStation()), this.currentIndex);
                    }
                }
                RadioHASUpdater.updateFMPresetList((FMPresetListInfoCollector[])objectArray);
            } else if (this.mWaveband == 0) {
                int n;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmPresetListBase - updateGuiList() - Waveband == RadioWavebandAsl.AM").log();
                }
                Object[] objectArray = new AMPresetListInfoCollector[this.mPresets.length];
                for (n = 0; n < objectArray.length; ++n) {
                    objectArray[n] = new AMPresetListInfoCollector();
                    this.mPresets[n].fillCollector((AMPresetListInfoCollector)objectArray[n]);
                }
                ListManager.getGenericASLList(1451).updateList(objectArray);
                n = this.getFirstPresetBankIndexWithEmptyElement();
                AmFmFactory.getAslAmfmModelController().updatePresetBankWithEmptyElement(n);
                n = this.getFirstOccupiedPresetBankIndex();
                AmFmFactory.getAslAmfmModelController().updateAmIndexOfFirstOccupiedPreset(n);
                if (this.currentIndex < 0 || this.currentIndex >= this.mPresets.length) {
                    AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), this.currentIndex);
                } else {
                    AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(this.mPresets[this.currentIndex].getPresetStation()), this.currentIndex);
                }
                RadioHASUpdater.updateAMPresetList((AMPresetListInfoCollector[])objectArray);
            }
            AmFmFactory.getAslAmfmModelController().updateAtLeastOnePresetHasLogo(this.mWaveband, this.getAtLeastOnePresetHasLogo());
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmPresetListBase - updateGuiList() - END").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void clearAMHdInfoOnPresets() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].getPresetStation().setHD(false);
            this.mPresets[i2].getPresetStation().setServiceId(0);
            this.mPresets[i2].getPresetStation().setShortNameHD("");
            if (this.mPresets[i2].isLogoManuallyAssignedToPreset()) continue;
            this.mPresets[i2].setImage(null, false);
        }
        this.toPersistence();
    }

    @Override
    public void clearFMHdInfoOnPresets() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].getPresetStation().setHD(false);
            this.mPresets[i2].getPresetStation().setServiceId(0);
            this.mPresets[i2].getPresetStation().setShortNameHD("");
            this.mPresets[i2].getPresetStation().setMpsWithoutSPSAlreadyStored(false);
            this.mPresets[i2].getPresetStation().setMpsWithSPSAlreadyStored(false);
            if (this.mPresets[i2].isLogoManuallyAssignedToPreset()) continue;
            this.mPresets[i2].setImage(null, false);
        }
        this.toPersistence();
    }

    @Override
    public void updateGuiBank() {
        if (this.mWaveband == 1) {
            AmFmFactory.getAslAmfmModelController().updateFmIndexOfPresetBank(this.getBankIndex() * RadioConstants.PRESETS_PER_BANK);
        } else if (this.mWaveband == 0) {
            AmFmFactory.getAslAmfmModelController().updateAmIndexOfPresetBank(this.getBankIndex() * RadioConstants.PRESETS_PER_BANK);
        }
    }

    @Override
    public void clearIndex() {
        this.setIndex(-1, false);
    }

    @Override
    public void forceHmiUpdate() {
        this.mUpdater.updateCurrentPreset();
    }

    @Override
    public void updateDsi() {
        if (this.mWaveband == 1) {
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                this.mPresets[i2].updateDsi();
            }
        }
    }

    @Override
    public void updateCurrentPreset() {
        AmFmPreset amFmPreset = this.get(this.currentIndex);
        if (amFmPreset != null) {
            amFmPreset.updateGuiPresetIndex();
        }
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public int getSizeOfNonEmptyPresets() {
        int n = 0;
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (!this.mPresets[i2].isValid()) continue;
            ++n;
        }
        return n;
    }

    @Override
    public AmFmStation[] getValidPresetStations() {
        AmFmStation[] amFmStationArray = null;
        int n = this.getSizeOfNonEmptyPresets();
        if (n > 0) {
            int n2 = 0;
            amFmStationArray = new AmFmStation[n];
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                if (!this.mPresets[i2].isValid() || n2 >= amFmStationArray.length) continue;
                amFmStationArray[n2] = new AmFmStation(this.mPresets[i2].getPresetStation());
                ++n2;
            }
        }
        return amFmStationArray;
    }

    @Override
    public void deleteAllLogos() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].deleteLogo();
        }
    }

    @Override
    public void deleteAllDatabaseStationIds() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].deleteDatabaseStationId();
        }
    }

    @Override
    public void createNewNoOfPresets() {
        AmFmPreset[] amFmPresetArray = this.mPresets;
        this.mPresets = new AmFmPreset[RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets()];
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null != amFmPresetArray && i2 < amFmPresetArray.length && null != amFmPresetArray[i2]) {
                this.mPresets[i2] = new AmFmPreset(amFmPresetArray[i2]);
                continue;
            }
            this.mPresets[i2] = new AmFmPreset(i2, this.mWaveband);
            this.mPresets[i2].setUpdater(AmFmPresetApi.getAmFmPresetUpdater());
        }
        if (this.getIndex() >= this.mPresets.length) {
            this.setIndex(-1, true);
        }
    }

    @Override
    public void clearPresetsForProfileChange() {
        if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AmFmPresetListBase - clearPresetsForProfileChange()").log();
            }
            if (null != this.mPresets) {
                for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                    if (null == this.mPresets[i2]) continue;
                    this.mPresets[i2].setEmpty();
                }
            }
        }
    }

    @Override
    public AmFmPreset[] getPresets() {
        return this.mPresets;
    }

    @Override
    public void toPersistence() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - Start").log();
            }
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (AmFmPresetApi.isPersistenceWriteAccessBlocked()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - AmFmPresetApi.isPersistenceWriteAccessBlocked() == true").log();
                }
                return;
            }
            AmFmPresetSettings amFmPresetSettings = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmPresetSettings();
            if (null != amFmPresetSettings) {
                List list = null;
                if (this.mWaveband == 0) {
                    list = amFmPresetSettings.getAmPresets();
                } else if (this.mWaveband == 1) {
                    list = amFmPresetSettings.getFmPresets();
                } else {
                    ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetListBase - toPersistence() - Wrong waveband!").log();
                }
                if (null != list) {
                    list.clear();
                    for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                        AmFmPresetPersistence amFmPresetPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createAmFmPresetPersistence(this.mPresets[i2]);
                        list.add(amFmPresetPersistence);
                        if (!ServiceManager.logger.isTraceEnabled(128)) continue;
                        if (null == amFmPresetPersistence) {
                            ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - Preset ").append(i2).append(": null == amFmPresetPersistence").log();
                            continue;
                        }
                        AmFmStationPersistence amFmStationPersistence = amFmPresetPersistence.getAmFmStation();
                        if (null == amFmStationPersistence) {
                            ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - Preset ").append(i2).append(": null == amFmPresetPersistence.getAmFmStation()").log();
                            continue;
                        }
                        ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - Preset ").append(i2).append(": Frequency = ").append(amFmStationPersistence.getStationFrequency()).log();
                    }
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - presetsPersistence.size() = ").append(list.size()).log();
                    }
                } else {
                    ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetListBase - toPersistence() - null == presetsPersistence").log();
                }
                if (this.mWaveband == 0) {
                    amFmPresetSettings.setCurrentIndexAm(this.currentIndex);
                } else if (this.mWaveband == 1) {
                    amFmPresetSettings.setCurrentIndexFm(this.currentIndex);
                }
            } else {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetListBase - toPersistence() - null == amFmPresetSettings").log();
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AmFmPresetListBase - toPersistence() - End").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void fromPersistence() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AmFmPresetListBase - fromPersistence() - Start").log();
            }
            AmFmPresetSettings amFmPresetSettings = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmPresetSettings();
            List list = null;
            if (null != amFmPresetSettings) {
                if (this.mWaveband == 0) {
                    list = amFmPresetSettings.getAmPresets();
                } else if (this.mWaveband == 1) {
                    list = amFmPresetSettings.getFmPresets();
                }
                if (null != list) {
                    int n = list.size();
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("AmFmPresetListBase - fromPersistence() - presetsPersistence.size() = ").append(n).log();
                    }
                    if (n >= 15 && n <= 18) {
                        RadioConstants.PRESETS_PER_BANK = n / 3;
                    }
                    Iterator iterator = list.iterator();
                    if (null != iterator) {
                        for (int i2 = 0; iterator.hasNext() && i2 < this.mPresets.length; ++i2) {
                            AmFmPresetPersistence amFmPresetPersistence = (AmFmPresetPersistence)iterator.next();
                            RadioServiceManager.getServiceManager().getAdapterAslPersistence().createAmFmPresetHmi(amFmPresetPersistence, this.mPresets[i2]);
                            if (!ServiceManager.logger.isTraceEnabled(128)) continue;
                            if (null == this.mPresets[i2]) {
                                ServiceManager.logger.trace(128).append("AmFmPresetListBase - fromPersistence() - Preset ").append(i2).append(": null == mPresets[i]").log();
                                continue;
                            }
                            AmFmStation amFmStation = this.mPresets[i2].getPresetStation();
                            if (null == amFmStation) {
                                ServiceManager.logger.trace(128).append("AmFmPresetListBase - fromPersistence() - Preset ").append(i2).append(": null == mPresets[i].getPresetStation()").log();
                                continue;
                            }
                            ServiceManager.logger.trace(128).append("AmFmPresetListBase - fromPersistence() - Preset ").append(i2).append(": Frequency = ").append(amFmStation.getFrequency()).log();
                        }
                    } else {
                        ServiceManager.logger.error(128).append("AmFmPresetListBase - fromPersistence() - null == iterator").log();
                    }
                } else {
                    ServiceManager.logger.error(128).append("AmFmPresetListBase - fromPersistence() - null == presetsPersistence").log();
                }
                if (this.mWaveband == 0) {
                    this.setVisibleBankIndex(amFmPresetSettings.getCurrentBankIndexAm(), 0);
                    this.setIndex(amFmPresetSettings.getCurrentIndexAm(), true);
                } else if (this.mWaveband == 1) {
                    this.setVisibleBankIndex(amFmPresetSettings.getCurrentBankIndexFm(), 1);
                    this.setIndex(amFmPresetSettings.getCurrentIndexFm(), true);
                }
                AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(-1L, -1);
                if (this.mWaveband == 1) {
                    AmFmPresetApi.setFmPresetsLoadedAndInitialized(true);
                } else {
                    AmFmPresetApi.setAmPresetsLoadedAndInitialized(true);
                }
                if (AmFmPresetApi.isAmPresetsLoadedAndInitialized() && AmFmPresetApi.isFmPresetsLoadedAndInitialized()) {
                    AmFmPresetApi.createNewAmFmPresets();
                }
            } else {
                ServiceManager.logger.error(128).append("AmFmPresetListBase - fromPersistence() - null == amFmPresetSettings").log();
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("AmFmPresetListBase - fromPersistence() - End").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void traceAmFmPresetPersistence(List list) {
    }

    @Override
    public void updateStationLogoFromDatabase(RadioStationData radioStationData, ResourceLocator resourceLocator) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty()) continue;
            this.mPresets[i2].updateStationLogoFromDatabase(radioStationData, resourceLocator);
        }
    }

    @Override
    public boolean updateStationLogoFromStationList(AmFmStation amFmStation) {
        boolean bl = false;
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            boolean bl2;
            if (null == this.mPresets[i2] || this.mPresets[i2].isEmpty() || !(bl2 = this.mPresets[i2].updateStationLogoFromStationList(amFmStation))) continue;
            bl = bl2;
        }
        return bl;
    }

    @Override
    public int getLastSelectedPresetIndex() {
        return this.lastSelectedPresetIndex;
    }

    @Override
    public boolean isResourceLocatorUsed(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        if (null == resourceLocator || null == amFmStation) {
            return false;
        }
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (null == this.mPresets[i2]) continue;
            ResourceLocator resourceLocator2 = this.mPresets[i2].getImage();
            if (this.mPresets[i2].isEmpty() || null == resourceLocator2 || resourceLocator2.id != resourceLocator.id || !StringUtil.equals(resourceLocator2.getUrl(), resourceLocator.getUrl()) || !this.isStationEqual(amFmStation, this.mPresets[i2].getPresetStation())) continue;
            return true;
        }
        return false;
    }

    private boolean isStationEqual(AmFmStation amFmStation, AmFmStation amFmStation2) {
        try {
            if (null == amFmStation || null == amFmStation2) {
                return false;
            }
            if (amFmStation.getAslWaveband() == 0 ? amFmStation.getFrequency() == amFmStation2.getFrequency() : (!ProgramIdentification.isValidPI(amFmStation.getPi()) && !ProgramIdentification.isValidPI(amFmStation2.getPi()) ? amFmStation.getFrequency() == amFmStation2.getFrequency() : RadioCodingAdapter.isPiActivated() && amFmStation.getPi() == amFmStation2.getPi())) {
                return true;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return false;
    }
}


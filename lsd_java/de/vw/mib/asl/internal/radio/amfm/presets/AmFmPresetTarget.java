/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmTrafficInformationJapan;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetModel;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.presets.PresetRadioStationLogoSelection;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ServiceInfo;

final class AmFmPresetTarget
extends AbstractTarget {
    private final AmFmPresetModel mModel;

    AmFmPresetTarget(Target target, AmFmPresetModel amFmPresetModel) {
        super(target.getMainObject());
        this.mModel = amFmPresetModel;
        String string = this.getEventDispatcher().getTaskId(target.getTargetId());
        this.getEventDispatcher().registerTarget(this, string);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 128;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received NOTIFY_TARGET_REGISTERED").log();
                }
                this.addObserver(-1811677120);
                this.addObserver(-1794899904);
                this.addObserver(-1425801152);
                this.addObserver(-1694236608);
                this.addObserver(-1677459392);
                this.addObserver(-1660682176);
                this.addObserver(-1073479616);
                this.addObserver(-1039925184);
                this.addObserver(-553385920);
                this.addObserver(-419168192);
                this.addObserver(-1107034048);
                this.addObserver(-1962672064);
                this.addObserver(-1895563200);
                this.addObserver(722075712);
                this.addObserver(1443430464);
                break;
            }
            case 9: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received NOTIFY_TARGET_UNREGISTERED").log();
                }
                this.removeObserver(-1811677120);
                this.removeObserver(-1794899904);
                this.removeObserver(-1425801152);
                this.removeObserver(-1694236608);
                this.removeObserver(-1677459392);
                this.removeObserver(-1660682176);
                this.removeObserver(-1073479616);
                this.removeObserver(-1039925184);
                this.removeObserver(-553385920);
                this.removeObserver(-419168192);
                this.removeObserver(-1107034048);
                this.removeObserver(-1962672064);
                this.removeObserver(-1895563200);
                this.removeObserver(722075712);
                break;
            }
            case 1073742997: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_ACTIVATE_STATION_PRESET__BY_ID").log();
                }
                if (!RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm()) break;
                this.tunePresetStationTriggeredBySpeechControl(eventGeneric);
                break;
            }
            case 1073743038: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_SET_PRESET_ICON_DIMENSION").log();
                }
                RadioData.getAmfmDatabase().setPresetWidth(eventGeneric.getInt(0));
                RadioData.getAmfmDatabase().setPresetHeigth(eventGeneric.getInt(1));
                break;
            }
            case 1073743079: {
                break;
            }
            case 0x400004C0: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_SET_INDEX_OF_PRESET_BANK_AM").log();
                }
                int n = eventGeneric.getInt(0);
                this.mModel.setBankIndex(0, n / RadioConstants.PRESETS_PER_BANK);
                this.setIndexOfCurrStInPresetList(0);
                break;
            }
            case 1073743042: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_SET_INDEX_OF_PRESET_BANK_FM").log();
                }
                int n = eventGeneric.getInt(0);
                this.mModel.setBankIndex(1, n / RadioConstants.PRESETS_PER_BANK);
                this.setIndexOfCurrStInPresetList(1);
                break;
            }
            case 1073743071: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_STORE_CURRENT_STATION_PRESET").log();
                }
                if (RadioCurrentWaveband.isAm() || RadioCurrentWaveband.isFm()) {
                    Object object;
                    int n = eventGeneric.getInt(0);
                    if (this.isTraceEnabled()) {
                        this.trace().append(RadioUtil.LOG_PREFIX_AMFM).append("ASL_RADIO_STORE_CURRENT_STATION_PRESET, preset index: ").append(n).log();
                    }
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        object = RadioData.getAmfmDatabase().getCurrentStation();
                        this.mModel.storeStationOnPreset(n, (AmFmStation)object);
                    } else {
                        this.mModel.storeFreezedStationOnPreset(n);
                    }
                    AmFmFactory.getAslAmfmModelController().presetStoredSuccessfully();
                    object = RadioData.getAmfmDatabase().getCurrentStationList();
                    if (null != object) {
                        ((AmFmStationList)object).updateStationListToHMI();
                    }
                    AmFmFactory.getInstanceEUStationListViewWalker().updateStationIsOnPreset();
                }
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 0x40000494: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_ACTIVATE_STATION_PRESET").log();
                }
                if (!RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm()) break;
                int n = eventGeneric.getInt(0);
                this.activateStationPreset(n);
                break;
            }
            case 1073743003: {
                int n;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_DELETE_ALL_PRESETS").log();
                }
                if (RadioCurrentWaveband.isAm(n = eventGeneric.getInt(0)) || RadioCurrentWaveband.isFm(n)) {
                    this.mModel.deletePresets(n, false);
                    try {
                        TileStationList tileStationList;
                        if (RadioCodingAdapter.isRadioTileFeatureActivated() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                            tileStationList.initTiles();
                        }
                    }
                    catch (Exception exception) {
                        ServiceManager.errorHandler.handleError(exception);
                    }
                }
                AmFmFactory.getAslAmfmModelController().updateAtLeastOnePresetHasLogo(n, false);
                break;
            }
            case 1073743004: {
                int n;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_DELETE_PRESET").log();
                }
                if (!RadioCurrentWaveband.isAm(n = eventGeneric.getInt(0)) && !RadioCurrentWaveband.isFm(n)) break;
                int n2 = eventGeneric.getInt(1);
                this.mModel.deletePreset(n, n2);
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073743005: {
                try {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received DELETE_PRESET_LOGO").log();
                    }
                    int n = eventGeneric.getInt(0);
                    if (RadioCurrentWaveband.isAm() || RadioCurrentWaveband.isFm()) {
                        AmFmPresetApi.deletePresetLogo(RadioCurrentWaveband.get(), n);
                    } else if (RadioCurrentWaveband.isDab()) {
                        ServiceInfo serviceInfo = RadioData.getDabDatabase().dabPresetList.deletePresetPictureForAllMatchingServices(n);
                        RadioData.getDabDatabase().dabPresetList.notifyHmi();
                        RadioDataApi.deleteDabLogoFromHmiLogoBuffer(serviceInfo);
                    }
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073744427: {
                try {
                    int n;
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received DELETE_ALL_PRESET_LOGOS").log();
                    }
                    if ((n = eventGeneric.getInt(0)) == 0) {
                        AmFmPresetApi.deleteAllPresetLogos(0);
                    } else if (n == 1) {
                        AmFmPresetApi.deleteAllPresetLogos(1);
                    } else if (n == 2) {
                        RadioData.getDabDatabase().dabPresetList.deleteAllPresetLogos();
                    }
                    AmFmFactory.getAslAmfmModelController().updateAtLeastOnePresetHasLogo(n, false);
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073743019: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_LOAD_PRESET_LOGO").log();
                }
                if (!RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm()) break;
                int n = eventGeneric.getInt(0);
                ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(1);
                PresetManualPictureStore.storePresetPicture(this, n, resourceLocator, -1618542336, RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets() * 14, 5100);
                break;
            }
            case 1073744214: {
                PresetRadioStationLogoSelection.setUserSelectedStationLogo(eventGeneric);
                break;
            }
            case 100255: {
                boolean bl;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received EV_AMFM_ANSWER_PICTURESTORE").log();
                }
                if (bl = eventGeneric.getBoolean(4)) {
                    ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(3);
                    Integer n = (Integer)eventGeneric.getObject(2);
                    AmFmStation amFmStation = this.mModel.setImage(RadioCurrentWaveband.get(), n, resourceLocator, true);
                    if (null != resourceLocator && null != amFmStation && RadioDataApi.isSouthSideStationLogoDbActive()) {
                        if (RadioCurrentWaveband.isAm()) {
                            RadioDataApi.setAmStationLogoInHmiLogoBuffer(resourceLocator, amFmStation);
                            AmFmPresetApi.setManualAssignedAmStationLogoForAllPresets(resourceLocator, amFmStation);
                        } else if (RadioCurrentWaveband.isFm()) {
                            RadioDataApi.setFmStationLogoInHmiLogoBuffer(resourceLocator, amFmStation);
                            AmFmPresetApi.setManualAssignedFmStationLogoForAllPresets(resourceLocator, amFmStation);
                        }
                    }
                    this.mModel.updateGuiList(RadioCurrentWaveband.get());
                }
                RadioDataApi.requestPersistStationLogosInSouthSideDb();
                break;
            }
            case 1073742987: {
                int n;
                AmFmPreset amFmPreset;
                int n3;
                if (RadioData.getAmfmDatabase().getStationListViewIsOpen() || StateAmFmTrafficInformationJapan.amFmJapanTrafficInfIsActive || RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) break;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_ACTIVATE_NEXT_STATION").log();
                }
                if (!RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm() || (n3 = AmfmScopeOfArrowKeys.get()) != 0 || null == (amFmPreset = this.mModel.activateNextPreset(n = RadioCurrentWaveband.get()))) break;
                this.updateGui(amFmPreset.getPresetStation());
                break;
            }
            case 1073742991: {
                int n;
                AmFmPreset amFmPreset;
                int n4;
                if (RadioData.getAmfmDatabase().getStationListViewIsOpen() || StateAmFmTrafficInformationJapan.amFmJapanTrafficInfIsActive || RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) break;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received ASL_RADIO_ACTIVATE_PREVIOUS_STATION").log();
                }
                if (!RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm() || (n4 = AmfmScopeOfArrowKeys.get()) != 0 || null == (amFmPreset = this.mModel.activatePreviousPreset(n = RadioCurrentWaveband.get()))) break;
                this.updateGui(amFmPreset.getPresetStation());
                break;
            }
            case 100256: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("PresetTarget received EV_PRESET_HIGHLIGHTING_TIMER").log();
                }
                SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                SelectedStationHighlighting.updateGui(true);
                break;
            }
        }
    }

    public boolean activateStationPreset(int n) {
        AmFmPreset amFmPreset;
        int n2 = RadioCurrentWaveband.get();
        boolean bl = false;
        if ((n2 == 0 || n2 == 1) && null != (amFmPreset = this.mModel.getPresetByIndex(n2, n)) && !amFmPreset.isEmpty() && (bl = this.mModel.activatePreset(n2, n))) {
            this.updateGui(amFmPreset.getPresetStation());
        }
        return bl;
    }

    private void updateGui(AmFmStation amFmStation) {
        if (null != amFmStation) {
            SelectedStationHighlighting.setStationSelectionIsActive(true, false);
            AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(amFmStation), AmFmPresetApi.getCurrentIndex());
            AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(amFmStation);
        }
    }

    private void setIndexOfCurrStInPresetList(int n) {
        AmFmPresetList amFmPresetList = this.mModel.getList(n);
        if (amFmPresetList != null) {
            amFmPresetList.setIndexOfCurrentStation();
        }
    }

    public void tunePresetStationTriggeredBySpeechControl(EventGeneric eventGeneric) {
        try {
            long l = eventGeneric.getLong(0);
            int n = RadioCurrentWaveband.get();
            int n2 = -1;
            if ((n == 0 || n == 1) && (n2 = RadioUtil.isIdADatabaseStationId(l) ? this.mModel.getPresetIndexByStationId(n, l >> 1, true) : this.mModel.getPresetIndexByStationId(n, l, false)) > -1) {
                this.activateStationPreset(n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}


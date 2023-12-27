/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.HsmAmFmDsi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmTrafficInformationJapan;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMMath;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DSIAMFMTuner;

public final class AmFmDsiApi {
    private static Logger logger = ServiceManager.logger;
    private static HsmAmFmDsi dsiTarget = null;
    private static HsmTarget mMainAmFmTarget;
    public static int doSwitchLinkingDeviceUsageMode;

    private AmFmDsiApi() {
    }

    public static void start(GenericEvents genericEvents, int n, String string, HsmTarget hsmTarget) {
        dsiTarget = new HsmAmFmDsi(genericEvents, n, string);
        mMainAmFmTarget = hsmTarget;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1601830656);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void stop() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1585053440);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void selectStationFromFreezedStationList(AmFmStation amFmStation) {
        AmFmDsiApi.doSelectStation(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 0, amFmStation);
    }

    public static void selectStation(AmFmStation amFmStation) {
        AmFmDsiApi.selectStation(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 0, amFmStation);
    }

    public static void selectStation(int n, int n2, AmFmStation amFmStation) {
        if (null != amFmStation) {
            AmFmStationListFM.setStationListIsFreezed(false);
            AmFmDsiApi.doSelectStation(n, n2, amFmStation);
            RadioServiceManager.getServiceManager().setAmFmDefaultOrLsmFreqYetTobeTuned(false);
        }
    }

    public static void doSelectStation(int n, int n2, AmFmStation amFmStation) {
        block22: {
            try {
                Object object;
                Object object2;
                AmFmStation amFmStation2;
                if (null == amFmStation) {
                    return;
                }
                int n3 = amFmStation.getFrequency();
                int n4 = amFmStation.getPi();
                int n5 = amFmStation.getServiceId();
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2) && null != (amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation()) && (amFmStation2.getFrequency() != n3 || amFmStation2.getServiceId() != n5)) {
                    TileStationList tileStationList;
                    AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(1);
                    AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(1);
                    object2 = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(n3, n5);
                    object = AmFmPresetApi.getImage(amFmStation);
                    if (null != object2 && null == object && RadioUtil.isValid(((AmFmStation)object2).getStationArt())) {
                        object = ((AmFmStation)object2).getStationArt();
                    }
                    if (!RadioUtil.isValid((ResourceLocator)object)) {
                        object = null;
                    }
                    AmFmFactory.getAslAmfmModelController().updateFrequencyToStoreOnPreset(amFmStation);
                    AmFmFactory.getAslAmfmModelController().updateLogoInStationView((ResourceLocator)object);
                    AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(amFmStation.getFrequency());
                    mMainAmFmTarget.updateSelectedStationHD(amFmStation);
                    AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), AmFmPresetApi.getCurrentIndex());
                    RadioData.getAmfmDatabase().notifyStationChanged(amFmStation);
                    boolean bl = false;
                    if (RadioCodingAdapter.isRadioTileFeatureActivated() && RadioCurrentWaveband.isFm() && AmfmScopeOfArrowKeys.get() == 1 && ServiceManager.configManagerDiag.isFeatureFlagSet(2) && RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible() && !amFmStation2.isHD() && RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter()) {
                        bl = true;
                    }
                    RadioData.getAmfmDatabase().setCurrentStation(amFmStation);
                    if (bl && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                        tileStationList.initTiles();
                    }
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> setCurrentStation() under doSelectStation() in AmFMDsiApi").append("  AmFmStation: ").append(amFmStation.toString()).log();
                    }
                }
                if (!StateAmFmTrafficInformationJapan.amFmJapanTrafficInfIsActive) {
                    if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        mMainAmFmTarget.updateSelectedStation(amFmStation);
                    }
                    AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(true);
                    AmFmFactory.getAslAmfmPropertyManager().setManualModeFrequency(n3);
                    if (mMainAmFmTarget != null) {
                        mMainAmFmTarget.notifyStationChangeForRadioText(amFmStation);
                    }
                }
                int n6 = 0;
                if (null != RadioCodingAdapter.mAmFmCodingData) {
                    n6 = RadioCodingAdapter.mAmFmCodingData.getValue(53);
                }
                if (RadioCodingAdapter.isPiActivated() && AmfmRDSOption.get() && RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband() == 1 && RadioCodingAdapter.mAmFmCodingData.isAfTemporary(n6)) {
                    AmFmAlternativeFrequencySwitch.set(true);
                    AmFmAlternativeFrequencySwitch.setAFOnBeforeRDSOff(true);
                    AmFmAlternativeFrequencySwitch.notifyDSI(true);
                }
                if (logger.isTraceEnabled(128)) {
                    logger.trace(128).append("TUNING STATION **********************").append("select station: frequency: ").append(n3).append("  PI: ").append(AMFMMath.getPICode(n4)).append("  Serviceid : ").append(n5).log();
                }
                object2 = ServiceManager.mGenericEventFactory.newEvent();
                ((EventGeneric)object2).setSenderTargetId(n);
                ((EventGeneric)object2).setSenderEventId(n2);
                ((EventGeneric)object2).setReceiverEventId(-1500905216);
                ((EventGeneric)object2).setInt(0, n3);
                ((EventGeneric)object2).setInt(1, n4);
                ((EventGeneric)object2).setInt(2, n5);
                AmFmDsiApi.send((EventGeneric)object2);
                HsmTarget.waitingForStatusRunning = true;
                if (!RadioCodingAdapter.isRadioTileFeatureActivated()) break block22;
                if (RadioCurrentWaveband.isFm()) {
                    RadioDataApi.requestRadioFmStationLogos(new AmFmStation[]{amFmStation}, 20);
                }
                try {
                    if ((RadioCurrentWaveband.isAm() || RadioCurrentWaveband.isFm()) && !RadioServiceManager.getServiceManager().getTileStationList().isStationSelectionByTiles() && null != (object = RadioServiceManager.getServiceManager().getTileStationList())) {
                        if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                            ((TileStationList)object).updateSelectedAmFmStation(amFmStation, 1170613248);
                        } else {
                            ((TileStationList)object).initTiles();
                        }
                        if (RadioServiceManager.getServiceManager().getTileStationList().isTileLVisible()) {
                            ((TileStationList)object).updateSelectedAmFmStation(amFmStation, 1153836032);
                        }
                    }
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
            }
            catch (Exception exception) {
                logger.error(128, "doSelectStation Got the following exception", exception);
            }
        }
    }

    public static void doAutoSeek(int n, int n2, int n3) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setReceiverEventId(-2004221696);
        eventGeneric.setInt(0, n3);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void abortAutoSeek(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverEventId(-1987444480);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void stopAutoSeek(int n, boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverEventId(-1970667264);
        eventGeneric.setBoolean(0, bl);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void doAutostore(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setReceiverEventId(-1165360896);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void abortAutostore(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverEventId(-1148583680);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void doForceAmUpdate(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setReceiverEventId(-997588736);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void abortAmUpdate(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverEventId(-980811520);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void doForceFmUpdate(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setReceiverEventId(-829816576);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void abortFmUpdate(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverEventId(-813039360);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void doSetAmBandRange(int n, int n2, int n3) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setReceiverEventId(-662044416);
        eventGeneric.setInt(0, n3);
        AmFmDsiApi.send(eventGeneric);
    }

    public static void setSwitchLinkingDeviceUsageMode(int n) {
        doSwitchLinkingDeviceUsageMode = n;
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            dSIAMFMTuner.switchLinkingDeviceUsage(n);
        }
    }

    private static void send(EventGeneric eventGeneric) {
        String string = "dispatching of AMFM state machine events directly to DSI AMFM state machine";
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append("dispatching of AMFM state machine events directly to DSI AMFM state machine").log();
        }
        try {
            dsiTarget.gotEvent(eventGeneric);
        }
        catch (Exception exception) {
            logger.error(128, "dispatching of AMFM state machine events directly to DSI AMFM state machine", exception);
        }
    }

    static {
        doSwitchLinkingDeviceUsageMode = 0;
    }
}


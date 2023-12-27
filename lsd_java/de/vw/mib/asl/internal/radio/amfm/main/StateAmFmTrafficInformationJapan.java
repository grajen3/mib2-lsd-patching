/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmDefaultSettings;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public final class StateAmFmTrafficInformationJapan
extends AbstractHsmState {
    private static final int NO_ANSWER_EVENT_REQUIRED;
    private Logger logger = ServiceManager.logger;
    private static final int FREQ_1620;
    private static final int FREQ_1629;
    private final HsmTarget mTarget;
    private AmFmStation mLastStation;
    private AmFmStation tiStation;
    public static boolean amFmJapanTrafficInfIsActive;
    private static boolean closePopUp;
    private boolean radioDeactivated;

    StateAmFmTrafficInformationJapan(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
        this.radioDeactivated = false;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmTrafficInformationJapan is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - HSM_START").log();
                }
                this.radioDeactivated = false;
                closePopUp = false;
                amFmJapanTrafficInfIsActive = true;
                AmFmFactory.getAslAmfmModelController().updateTrafficInformationFrequency(RadioData.getAmfmDatabase().getSettingsPersistable().getTiJapanFrequency());
                if (null == this.mLastStation) {
                    this.mLastStation = new AmFmStation();
                }
                if (RadioCurrentWaveband.isFm()) {
                    this.mLastStation.copyOf(RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation());
                } else {
                    this.mLastStation.copyOf(RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentAmStation());
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(2482, true);
                if (closePopUp) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - requestAudioConnectionForBand").log();
                }
                AudioConnectionUtils.requestAudioConnection(15, this.mTarget, 2022113536);
                break;
            }
            case 100216: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_AMFM_ANSWER_REQUEST_JAPAN_TI_AM_AUDIO_CONNECTION").log();
                }
                if (eventGeneric.getResult() != 0) {
                    this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - request audio connection NOT OK").log();
                }
                if (closePopUp) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - tune").log();
                }
                this.tune(2055667968);
                break;
            }
            case 100218: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_AMFM_ANSWER_JAPAN_TI_SELECT_AM_STATION").log();
                }
                if (closePopUp) break;
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - requestFadeIn").log();
                }
                AudioConnectionUtils.requestFadeIn(15, this.mTarget, 2089222400);
                break;
            }
            case 100220: {
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_AMFM_ANSWER_JAPAN_TI_FADE_TO_AM_CONNECTION").log();
                break;
            }
            case 1073743747: {
                break;
            }
            case 1073743433: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - SET_TRAFFIC_INFORMATION_FREQUENCY").log();
                }
                if (closePopUp) break;
                int n = eventGeneric.getInt(0);
                RadioData.getAmfmDatabase().getSettingsPersistable().setTiJapanFrequency(n);
                this.tune(-1);
                break;
            }
            case 1073742987: 
            case 1073742991: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - ACTIVATE Next / Prev Station").log();
                }
                if (RadioData.getAmfmDatabase().getSettingsPersistable().getTiJapanFrequency() == 0) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setTiJapanFrequency(1);
                } else {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setTiJapanFrequency(0);
                }
                this.tune(-1);
                break;
            }
            case 1073743748: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - STOP_TRAFFIC_INFORMATION").log();
                }
                if (closePopUp) break;
                closePopUp = true;
                if (this.radioDeactivated) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - STOP_TRAFFIC_INFORMATION - trans stateAmFmActiveIdle").log();
                    }
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                    break;
                }
                if (RadioCurrentWaveband.isFm()) {
                    AudioConnectionUtils.requestAudioConnectionForBand(1, this.mTarget, 2038890752);
                    break;
                }
                AudioConnectionUtils.requestAudioConnectionForBand(0, this.mTarget, -1685651200);
                break;
            }
            case 100217: 
            case 100251: {
                if (eventGeneric.getResult() != 0) {
                    this.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - request audio connection NOT OK").log();
                }
                if (this.radioDeactivated) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_AMFM_ANSWER_REQUEST_JAPAN_TI_FM_AUDIO_CONNECTION - trans stateAmFmActiveIdle").log();
                    }
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                    break;
                }
                if (null == this.mLastStation) {
                    this.mLastStation = RadioCurrentWaveband.isFm() ? new AmFmStation(AmFmDefaultSettings.getFmDefaultFrequency()) : new AmFmStation(AmFmDefaultSettings.getAmDefaultFrequency());
                }
                AmFmDsiApi.doSelectStation(this.mTarget.getTargetId(), 2072445184, this.mLastStation);
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(this.mLastStation);
                break;
            }
            case 100219: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_AMFM_ANSWER_JAPAN_TI_SELECT_FM_STATION").log();
                }
                if (this.radioDeactivated) {
                    if (this.logger.isTraceEnabled(128)) {
                        this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_AMFM_ANSWER_JAPAN_TI_SELECT_FM_STATION - trans stateAmFmActiveIdle").log();
                    }
                } else if (RadioCurrentWaveband.isFm()) {
                    AudioConnectionUtils.requestFadeInForBand(1, this.mTarget, 2105999616);
                } else {
                    AudioConnectionUtils.requestFadeInForBand(0, this.mTarget, -1668873984);
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 4: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - HSM_EXIT").log();
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(2482, false);
                amFmJapanTrafficInfIsActive = false;
                break;
            }
            case 3900004: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - EV_DEACTIVATE_RADIO").log();
                }
                this.radioDeactivated = true;
                break;
            }
            case 1073743055: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - START_SCAN").log();
                }
                hsmState = null;
                break;
            }
            case 1400003: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - ASLEntertainmentmanagerServiceIds.ACTIVATE").log();
                }
                this.radioDeactivated = true;
                hsmState = this.myParent;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void tune(int n) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - tune()").log();
        }
        int n2 = RadioData.getAmfmDatabase().getSettingsPersistable().getTiJapanFrequency();
        AmFmFactory.getAslAmfmModelController().updateTrafficInformationFrequency(n2);
        this.tiStation = n2 == 0 ? new AmFmStation(0) : new AmFmStation(0);
        if (-1 == n) {
            AmFmDsiApi.selectStation(this.tiStation);
        } else {
            AmFmDsiApi.doSelectStation(this.mTarget.getTargetId(), n, this.tiStation);
        }
        AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(this.tiStation);
    }

    public void dsiAMFMTunerUpdateAvailability(int n, int n2) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmTrafficInformationJapan - update availability: ").append(n).append("  validflag: ").append(n2).log();
        }
        if (!closePopUp && ServiceManager.configManagerDiag.isFeatureFlagSet(418) && 2 == n) {
            AudioConnectionUtils.requestAudioConnection(15, this.mTarget, 2022113536);
        }
    }

    static {
        amFmJapanTrafficInfIsActive = false;
        closePopUp = false;
    }
}


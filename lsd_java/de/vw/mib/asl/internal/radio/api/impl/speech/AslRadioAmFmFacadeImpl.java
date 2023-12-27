/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponseListener;
import de.vw.mib.asl.api.radio.speech.amfm.AslRadioAmFmFacade;
import de.vw.mib.asl.api.radio.speech.amfm.FmStationListListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveListView;

public class AslRadioAmFmFacadeImpl
implements AslRadioAmFmFacade {
    @Override
    public void tuneStation(de.vw.mib.asl.api.radio.amFm.AmFmStation amFmStation, AmFmTuningResponseListener amFmTuningResponseListener) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioAmFmFacadeImpl - tuneStation() - requested Speech AMFMStation is null").log();
            }
            HsmTarget hsmTarget = RadioServiceManager.getServiceManager().getRadioAmFMTarget();
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(1) && null != amFmStation) {
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().setSpeechAmFmTuningResponseListener(amFmTuningResponseListener);
                HsmTarget.stationTunedBySpeech = true;
                AmFmStation amFmStation2 = RadioServiceManager.getServiceManager().getAdapterAslSpeech().convertSpeechStationToAmFmStation(amFmStation);
                long l = amFmStation.getHmiUniqueId();
                if (null != hsmTarget && hsmTarget.isListViewActive() && null != hsmTarget.stateAmFmActiveListView && l > 0L) {
                    StateAmFmActiveListView stateAmFmActiveListView = (StateAmFmActiveListView)hsmTarget.stateAmFmActiveListView;
                    if (null != stateAmFmActiveListView) {
                        if (stateAmFmActiveListView.tuneStationTriggeredBySpeechControl(l)) {
                            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                                RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(amFmStation, 1);
                            }
                        } else if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                            RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(amFmStation, 2);
                        }
                    } else if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(amFmStation, 2);
                    }
                } else {
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        if (RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption() && RadioCurrentWaveband.isFm() || RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption() && RadioCurrentWaveband.isAm()) {
                            AmFmStation amFmStation3;
                            if (amFmStation2.getServiceId() > 1 && null == (amFmStation3 = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(amFmStation2.getFrequency(), amFmStation2.getServiceId()))) {
                                amFmStation2.setServiceId(0);
                            }
                        } else {
                            amFmStation2.setServiceId(0);
                        }
                    }
                    AmFmDsiApi.selectStation(amFmStation2);
                    if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(amFmStation, 1);
                    }
                }
            } else {
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(amFmStation, 2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public de.vw.mib.asl.api.radio.amFm.AmFmStation[] registerForFmStationList(FmStationListListener fmStationListListener) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioAmFmFacadeImpl - registerForFmStationList()").log();
            }
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().setSpeechFmStationListListner(fmStationListListener);
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(1)) {
                return RadioServiceManager.getServiceManager().getAdapterAslSpeech().convertAmFmStationListToSpeechStationList(RadioData.getAmfmDatabase().getAslStationListFM().getListCopyAsArray());
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioAmFmFacadeImpl - registerForFmStationList() - FM Band not available").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }
}


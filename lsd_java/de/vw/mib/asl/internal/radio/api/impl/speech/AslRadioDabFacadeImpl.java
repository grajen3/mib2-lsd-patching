/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.dab.DabService;
import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.dab.AslRadioDabFacade;
import de.vw.mib.asl.api.radio.speech.dab.DabServiceListListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.api.impl.speech.TuningResponseImpl;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class AslRadioDabFacadeImpl
implements AslRadioDabFacade {
    @Override
    public void tuneDabService(DabService dabService, TuningResponseListener tuningResponseListener) {
        try {
            if (null == dabService && ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioDabFacadeImpl - tuneDabService() - requested Speech DAB Service is null").log();
            }
            TuningResponseImpl tuningResponseImpl = new TuningResponseImpl();
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(2) && null != dabService) {
                try {
                    this.tuneServiceTriggeredBySpeechControl(RadioServiceManager.getServiceManager().getAdapterAslSpeech().convertSpeechServiceToDab(dabService));
                    tuningResponseImpl.setResultState(1);
                }
                catch (Exception exception) {
                    ServiceManager.logger.error(256, "Exception in AslRadioDabFacadeImpl : ", exception);
                }
            }
            tuningResponseListener.tuningResponse(tuningResponseImpl);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public DabService[] registerForDabServiceList(DabServiceListListener dabServiceListListener) {
        try {
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().setSpeechDabServiceListListener(dabServiceListListener);
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(2)) {
                return RadioServiceManager.getServiceManager().getAdapterAslSpeech().getDabServiceListAsSpeechServiceList();
            }
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioDabFacadeImpl - registerForDabServiceList() - DAB Band not available").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    private void tuneServiceTriggeredBySpeechControl(ServiceInfo serviceInfo) {
        try {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioDabFacadeImpl - tuneServiceTriggeredBySpeechControl() ").log();
            }
            if (serviceInfo != null) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(serviceInfo.toString()).log();
                }
                EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
                FrequencyInfo frequencyInfo = null;
                if (null != ensembleInfo) {
                    frequencyInfo = RadioData.getDabDatabase().mTunerState.getFrequencyByValue(ensembleInfo.frequencyValue);
                }
                RadioData.getDabDatabase().mTunerState.setCurrentService(serviceInfo, ensembleInfo);
                RadioData.getDabDatabase().mTunerState.setCurrentEnsemble(ensembleInfo);
                RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
                RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
                DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}


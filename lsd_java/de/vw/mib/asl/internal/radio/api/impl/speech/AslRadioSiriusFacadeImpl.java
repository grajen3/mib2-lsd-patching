/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.sdars.SiriusChannel;
import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.sirius.AslRadioSiriusFacade;
import de.vw.mib.asl.api.radio.speech.sirius.SiriusChannelListListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.api.impl.speech.TuningResponseImpl;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import org.dsi.ifc.sdars.StationInfo;

public class AslRadioSiriusFacadeImpl
implements AslRadioSiriusFacade {
    @Override
    public void tuneSiriusChannel(SiriusChannel siriusChannel, TuningResponseListener tuningResponseListener) {
        try {
            if (null == siriusChannel && ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioSiriusFacadeImpl - tuneSiriusChannel() - requested Speech Sirius Channel is null").log();
            }
            TuningResponseImpl tuningResponseImpl = new TuningResponseImpl();
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(3) && null != siriusChannel) {
                StationInfo stationInfo = SatDb.getInstance().getChannels().getChannelBySID(siriusChannel.getSid());
                if (null != stationInfo) {
                    SatDb.getInstance().getTuneHandler().tuneChannelSafe(19, stationInfo, false);
                    tuningResponseImpl.setResultState(1);
                } else {
                    tuningResponseImpl.setResultState(2);
                }
            }
            tuningResponseListener.tuningResponse(tuningResponseImpl);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public SiriusChannel[] registerForSiriusChannelList(SiriusChannelListListener siriusChannelListListener) {
        try {
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioSiriusFacadeImpl - registerForSiriusChannelList()").log();
            }
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().setSpeechSiriusChannelListListener(siriusChannelListListener);
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(3)) {
                return RadioServiceManager.getServiceManager().getAdapterAslSpeech().getSiriusChannelListAsSpeechChannelList();
            }
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AslRadioSiriusFacadeImpl - registerForSiriusChannelList() - Sirius Band not available").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }
}


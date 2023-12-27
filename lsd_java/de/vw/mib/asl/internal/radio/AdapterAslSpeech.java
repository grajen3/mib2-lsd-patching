/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.dab.DabService;
import de.vw.mib.asl.api.radio.sdars.SiriusChannel;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponseListener;
import de.vw.mib.asl.api.radio.speech.amfm.FmStationListListener;
import de.vw.mib.asl.api.radio.speech.dab.DabServiceListListener;
import de.vw.mib.asl.api.radio.speech.sirius.SiriusChannelListListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.api.impl.speech.AmFmStationImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.AmFmTuningResponseImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.DabServiceImpl;
import de.vw.mib.asl.internal.radio.api.impl.speech.SiriusChannelImpl;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.sdars.StationInfo;

public final class AdapterAslSpeech {
    private AmFmTuningResponseListener speechAmFmTuningResponseListener;
    private FmStationListListener speechFmStationListListener;
    private DabServiceListListener speechDabServiceListListener;
    private SiriusChannelListListener siriusChannelListListener;

    public AmFmStation convertSpeechStationToAmFmStation(de.vw.mib.asl.api.radio.amFm.AmFmStation amFmStation) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertSpeechStationToAmFmStation() - requested Speech AMFMStation is null").log();
                return null;
            }
            AmFmStation amFmStation2 = new AmFmStation(amFmStation.getFrequency());
            amFmStation2.setServiceId(amFmStation.getHdServiceId());
            amFmStation2.setLongNameHD(amFmStation.getLongName());
            amFmStation2.setPI(amFmStation.getPi());
            amFmStation2.setShortNameHD(amFmStation.getShortName());
            amFmStation2.setUniqueId(amFmStation.getHmiUniqueId());
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertSpeechStationToAmFmStation() - converted AMMFStation is :- ").append(amFmStation2.toString()).log();
            }
            return amFmStation2;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public de.vw.mib.asl.api.radio.amFm.AmFmStation convertAmFmStationToSpeechStation(AmFmStation amFmStation) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertAmFmStationToSpeechStation() - requested AMFMStation is null").log();
                return null;
            }
            AmFmStationImpl amFmStationImpl = new AmFmStationImpl();
            amFmStationImpl.setBand(amFmStation.getWaveband());
            amFmStationImpl.setFrequency(amFmStation.getFrequency());
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                amFmStationImpl.setHdServiceId(amFmStation.getServiceId());
                amFmStationImpl.setLongName(amFmStation.getLongNameHD());
                amFmStationImpl.setShortName(amFmStation.getShortNameHD());
            } else {
                amFmStationImpl.setLongName(amFmStation.getStationName());
                amFmStationImpl.setShortName(amFmStation.getStationName());
            }
            amFmStationImpl.setPi(amFmStation.getPi());
            amFmStationImpl.setHmiUniqueId(amFmStation.getUniqueId());
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertAmFmStationToSpeechStation() - converted SpeechStation is :- ").append(amFmStationImpl.toString()).log();
            }
            return amFmStationImpl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void setSpeechAmFmTuningResponseListener(AmFmTuningResponseListener amFmTuningResponseListener) {
        this.speechAmFmTuningResponseListener = amFmTuningResponseListener;
    }

    public AmFmTuningResponseListener getSpeechAmFmTuningResponseListener() {
        return this.speechAmFmTuningResponseListener;
    }

    public void sendAmFmTuningResponse(de.vw.mib.asl.api.radio.amFm.AmFmStation amFmStation, int n) {
        try {
            AmFmTuningResponseImpl amFmTuningResponseImpl = new AmFmTuningResponseImpl();
            amFmTuningResponseImpl.setAmFmStation(amFmStation);
            amFmTuningResponseImpl.setResultState(n);
            if (null != this.speechAmFmTuningResponseListener) {
                this.speechAmFmTuningResponseListener.tuningResponse(amFmTuningResponseImpl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void sendAmFmTuningResponse(AmFmStation amFmStation, int n) {
        try {
            this.sendAmFmTuningResponse(this.convertAmFmStationToSpeechStation(amFmStation), n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public de.vw.mib.asl.api.radio.amFm.AmFmStation[] convertAmFmStationListToSpeechStationList(Object[] objectArray) {
        AmFmStationImpl[] amFmStationImplArray = null;
        try {
            if (null == objectArray) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertAmFmStationListToSpeechStationList() - RadioData.mAmfmDatabase or radioAmFmList is null").log();
                }
                return amFmStationImplArray;
            }
            if (null != objectArray) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertAmFmStationListToSpeechStationList() - AMFMStations are :- ").log();
                }
                amFmStationImplArray = new AmFmStationImpl[objectArray.length];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    if (null == objectArray[i2]) continue;
                    AmFmStation amFmStation = (AmFmStation)objectArray[i2];
                    amFmStationImplArray[i2] = new AmFmStationImpl();
                    amFmStationImplArray[i2].setBand(amFmStation.getWaveband());
                    amFmStationImplArray[i2].setFrequency(amFmStation.getFrequency());
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        amFmStationImplArray[i2].setHdServiceId(amFmStation.getServiceId());
                        amFmStationImplArray[i2].setLongName(amFmStation.getLongNameHD());
                        amFmStationImplArray[i2].setShortName(amFmStation.getShortNameHD());
                    } else {
                        amFmStationImplArray[i2].setLongName(amFmStation.getStationName());
                        amFmStationImplArray[i2].setShortName(amFmStation.getStationName());
                    }
                    amFmStationImplArray[i2].setHmiUniqueId(amFmStation.getUniqueId());
                    amFmStationImplArray[i2].setPi(amFmStation.getPi());
                    amFmStationImplArray[i2].setRadioDbId(amFmStation.getDbStationId());
                    if (!ServiceManager.logger.isTraceEnabled(128)) continue;
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append(amFmStation.toString()).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return amFmStationImplArray;
    }

    public void setSpeechFmStationListListner(FmStationListListener fmStationListListener) {
        this.speechFmStationListListener = fmStationListListener;
    }

    public FmStationListListener getSpeechFmStationListListener() {
        return this.speechFmStationListListener;
    }

    public void updateFmListToSpeech(Object[] objectArray) {
        try {
            if (null == objectArray) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - updateFmListToSpeech() - radioAmFmList is null").log();
                }
                return;
            }
            de.vw.mib.asl.api.radio.amFm.AmFmStation[] amFmStationArray = this.convertAmFmStationListToSpeechStationList(objectArray);
            if (null != amFmStationArray && null != this.speechFmStationListListener) {
                this.speechFmStationListListener.updateStationList(amFmStationArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ServiceInfo convertSpeechServiceToDab(DabService dabService) {
        try {
            if (null == dabService) {
                ServiceManager.logger.error(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertSpeechServiceToDab() - speechDabService is null").log();
                return null;
            }
            ServiceInfo serviceInfo = new ServiceInfo();
            serviceInfo.sID = dabService.getSid();
            serviceInfo.ensECC = dabService.getEnsEcc();
            serviceInfo.ensID = dabService.getEnsId();
            serviceInfo.fullName = dabService.getLongName();
            serviceInfo.shortName = dabService.getShortName();
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertSpeechServiceToDab() :- ").append(serviceInfo.toString()).log();
            }
            return serviceInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void setSpeechDabServiceListListener(DabServiceListListener dabServiceListListener) {
        this.speechDabServiceListListener = dabServiceListListener;
    }

    public DabServiceListListener getSpeechDabServiceListListener() {
        return this.speechDabServiceListListener;
    }

    public DabService[] getDabServiceListAsSpeechServiceList() {
        DabServiceImpl[] dabServiceImplArray = null;
        try {
            ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServiceList();
            if (null != serviceInfoArray) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - getDabServiceListAsSpeechServiceList() - DAB Services are :- ").log();
                }
                dabServiceImplArray = new DabServiceImpl[serviceInfoArray.length];
                for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                    if (null == serviceInfoArray[i2]) continue;
                    dabServiceImplArray[i2] = new DabServiceImpl();
                    dabServiceImplArray[i2].setBand(2);
                    dabServiceImplArray[i2].setLongName(serviceInfoArray[i2].getFullName());
                    dabServiceImplArray[i2].setShortName(serviceInfoArray[i2].getShortName());
                    dabServiceImplArray[i2].setHmiUniqueId(DabTunerState.calcServiceId(serviceInfoArray[i2].getEnsID(), serviceInfoArray[i2].getEnsECC(), serviceInfoArray[i2].getSID()));
                    dabServiceImplArray[i2].setRadioDbId(RadioDataSessionManager.getInstance().getDbIdForDabService(serviceInfoArray[i2]));
                    dabServiceImplArray[i2].setSid(serviceInfoArray[i2].getSID());
                    dabServiceImplArray[i2].setEnsId(serviceInfoArray[i2].getEnsID());
                    dabServiceImplArray[i2].setEnsEcc(serviceInfoArray[i2].getEnsECC());
                    EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfoArray[i2].getEnsID(), serviceInfoArray[i2].getEnsECC());
                    if (null != ensembleInfo) {
                        dabServiceImplArray[i2].setEnsembleFullName(ensembleInfo.getFullName());
                        dabServiceImplArray[i2].setEnsembleShortName(ensembleInfo.getShortName());
                        dabServiceImplArray[i2].setFrequencyLabel(ensembleInfo.getFrequencyLabel());
                        dabServiceImplArray[i2].setFrequency(ensembleInfo.getFrequencyValue());
                    }
                    if (!ServiceManager.logger.isTraceEnabled(256)) continue;
                    ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append(serviceInfoArray[i2].toString()).log();
                }
            } else if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - getDabServiceListAsSpeechServiceList() - DAB Service list is empty").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return dabServiceImplArray;
    }

    public void updateDabServiceListToSpeech() {
        try {
            DabService[] dabServiceArray;
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - updateDabServiceListToSpeech()").log();
            }
            if (null != (dabServiceArray = this.getDabServiceListAsSpeechServiceList()) && null != this.speechDabServiceListListener) {
                this.speechDabServiceListListener.updateServiceList(dabServiceArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public StationInfo convertSpeechChannelToSirius(SiriusChannel siriusChannel) {
        try {
            if (null == siriusChannel) {
                ServiceManager.logger.error(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertSpeechChannelToSirius() - speechChannel is null").log();
                return null;
            }
            StationInfo stationInfo = new StationInfo();
            stationInfo.sID = siriusChannel.getSid();
            stationInfo.stationNumber = (short)siriusChannel.getStationNumber();
            stationInfo.fullLabel = siriusChannel.getLongName();
            stationInfo.shortLabel = siriusChannel.getShortName();
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - convertSpeechChannelToSirius() :- ").append(stationInfo.toString()).log();
            }
            return stationInfo;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void setSpeechSiriusChannelListListener(SiriusChannelListListener siriusChannelListListener) {
        this.siriusChannelListListener = siriusChannelListListener;
    }

    public SiriusChannelListListener getSpeechSiriusChannelListListener() {
        return this.siriusChannelListListener;
    }

    public SiriusChannel[] getSiriusChannelListAsSpeechChannelList() {
        SiriusChannelImpl[] siriusChannelImplArray = null;
        try {
            StationInfo[] stationInfoArray = SatDb.getInstance().getChannels().getArray();
            if (null != stationInfoArray) {
                if (ServiceManager.logger.isTraceEnabled(512)) {
                    ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - getSiriusChannelListAsSpeechChannelList() - Sirius Channels are :- ").log();
                }
                siriusChannelImplArray = new SiriusChannelImpl[stationInfoArray.length];
                for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                    if (null == stationInfoArray[i2]) continue;
                    siriusChannelImplArray[i2] = new SiriusChannelImpl();
                    siriusChannelImplArray[i2].setBand(3);
                    siriusChannelImplArray[i2].setLongName(stationInfoArray[i2].getFullLabel());
                    siriusChannelImplArray[i2].setShortName(stationInfoArray[i2].getShortLabel());
                    siriusChannelImplArray[i2].setSid(stationInfoArray[i2].getSID());
                    siriusChannelImplArray[i2].setStationNumber(stationInfoArray[i2].getStationNumber());
                }
            } else if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - getSiriusChannelListAsSpeechChannelList() - Sirius Channel list is empty").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return siriusChannelImplArray;
    }

    public void updateSiriusChannelListToSpeech() {
        try {
            SiriusChannel[] siriusChannelArray;
            if (ServiceManager.logger.isTraceEnabled(512)) {
                ServiceManager.logger.trace(512).append(RadioUtil.LOG_PREFIX_RADIO_SPEECH).append("AdapterAslSpeech - updateSiriusChannelListToSpeech()").log();
            }
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(3) && null != (siriusChannelArray = this.getSiriusChannelListAsSpeechChannelList()) && null != this.siriusChannelListListener) {
                this.siriusChannelListListener.updateChannelList(siriusChannelArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.tuner;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.api.radio.dab.DabService;
import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.dab.AslRadioDabFacade;
import de.vw.mib.asl.api.radio.speech.dab.DabServiceListListener;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.DabInterfaceHandler$1;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.RadioInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerDABService;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.TuningCallback;
import java.util.ArrayList;
import java.util.Random;

public class DabInterfaceHandler
extends RadioInterfaceHandler
implements DabServiceListListener,
TuningResponseListener {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerLogger logger;
    private AslRadioDabFacade dabRadio;

    public DabInterfaceHandler(SpeechTunerServiceManager speechTunerServiceManager) {
        super(speechTunerServiceManager, true, "DAB");
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[DabInterfaceHandler] ");
    }

    @Override
    public boolean isReady() {
        return this.dabRadio != null;
    }

    @Override
    public void registerForStationlist() {
        super.registerForStationlist();
        DabService[] dabServiceArray = this.dabRadio.registerForDabServiceList(this);
        this.updateServiceList(dabServiceArray);
    }

    public void setDabRadio(AslRadioDabFacade aslRadioDabFacade) {
        this.dabRadio = aslRadioDabFacade;
        if (this.slotUpdater != null && aslRadioDabFacade != null) {
            this.registerForStationlist();
        }
    }

    @Override
    protected void onSetSlotUpdater() {
        if (this.dabRadio != null && this.slotUpdater != null) {
            this.registerForStationlist();
        }
    }

    @Override
    public boolean addingStationAllowed(Station station) {
        return station.getLongName() != null && !station.getLongName().equals("") || station.getShortName() != null && !station.getShortName().equals("");
    }

    public DabService getAnyStation() {
        Object[] objectArray = this.stationlistCache.getStationList();
        if (objectArray.length > 0) {
            int n = new Random().nextInt(objectArray.length);
            return (DabService)objectArray[n];
        }
        return null;
    }

    @Override
    public void writeAnyStationIntoSelectedItem() {
        DabService dabService = this.getAnyStation();
        if (dabService != null) {
            Object[] objectArray = new SpeechTunerDABService[]{this.createInternalDABService(dabService, null)};
            GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(-601736704);
            if (genericASLList != null) {
                genericASLList.updateList(objectArray);
            } else {
                this.logger.error("ASL list for DAB Selected Item was null.");
            }
        } else {
            this.logger.error("Requested an example DAB service even though there are no speakable services. Check problemhandling because it should have caught this problem before arriving at this point.");
        }
    }

    public void tuneDabService(TuningCallback tuningCallback, SpeechTunerDABService speechTunerDABService) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("tuning DAB service with id ").append(speechTunerDABService.getObjectID()).toString());
        }
        this.lastCaller = tuningCallback;
        DabService dabService = (DabService)this.stationlistCache.getStation(speechTunerDABService.getObjectID());
        if (dabService == null) {
            this.logger.warn("service is not available anymore");
            this.tuningResponse(new DabInterfaceHandler$1(this));
        } else {
            this.dabRadio.tuneDabService(dabService, this);
        }
    }

    public SpeechTunerDABService createInternalDABService(DabService dabService, String string) {
        long l = this.serviceManager.getRadioUtils().getObjectId(dabService);
        String string2 = dabService.getLongName() != null && !dabService.getLongName().equals("") ? dabService.getLongName() : (dabService.getShortName() != null && !dabService.getShortName().equals("") ? dabService.getShortName() : string);
        String string3 = dabService.getEnsembleFullName() != null && !dabService.getEnsembleFullName().equals("") ? dabService.getEnsembleFullName() : dabService.getEnsembleShortName();
        return new SpeechTunerDABService(l, string2, string3);
    }

    @Override
    public void updateServiceList(DabService[] dabServiceArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("received an DAB servicelist update from tuner");
            this.logger.trace("writing DAB services to cache");
        }
        this.stationlistCache.add(dabServiceArray, this);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("writing DAB services from cache to slot");
        }
        this.slotUpdater.updateDABSlotData(dabServiceArray);
    }

    @Override
    public void tuningResponse(TuningResponse tuningResponse) {
        if (this.lastCaller != null) {
            if (tuningResponse == null) {
                this.logger.warn("received invalid DAB tuning response");
                this.lastCaller.onTuningResponse(null);
            } else if (tuningResponse.getResultState() == 1) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("tuning DAB service was successful");
                }
                this.lastCaller.onTuningResponse(tuningResponse);
            } else {
                this.logger.warn("tuning DAB service failed");
                this.lastCaller.onTuningResponse(null);
            }
            this.lastCaller = null;
        } else {
            this.logger.error("received DAB tuning response without a caller that initiated the tuning process");
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("adding additional data to received DAB nbest list");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            SpeechTunerDABService speechTunerDABService;
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) {
                speechTunerDABService = new SpeechTunerDABService(resultItem.getText(), resultItem.getSize());
            } else {
                DabService dabService = (DabService)this.stationlistCache.getStation(resultItem.getIdentifier().getObjectId());
                if (dabService == null) {
                    this.logger.warn(new StringBuffer().append("tried to fetch service with id ").append(resultItem.getIdentifier().getObjectId()).append(" from cache which does not exist").toString());
                    speechTunerDABService = new SpeechTunerDABService(resultItem.getIdentifier().getObjectId(), resultItem.getIdentifier().getRecognizedString(), "");
                } else {
                    speechTunerDABService = this.createInternalDABService(dabService, resultItem.getIdentifier().getRecognizedString());
                }
            }
            arrayList.add(speechTunerDABService);
        }
        Object[] objectArray = new SpeechTunerDABService[arrayList.size()];
        arrayList.toArray(objectArray);
        asyncCallback.onResponse(objectArray);
    }
}


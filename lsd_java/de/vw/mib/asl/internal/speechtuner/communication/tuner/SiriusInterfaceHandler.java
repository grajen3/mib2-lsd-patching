/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.tuner;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.api.radio.sdars.SiriusChannel;
import de.vw.mib.asl.api.radio.sdars.SiriusSubscriptionState;
import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.sirius.AslRadioSiriusFacade;
import de.vw.mib.asl.api.radio.speech.sirius.SiriusChannelListListener;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.RadioInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.SiriusInterfaceHandler$1;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerSiriusChannel;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.TuningCallback;
import java.util.ArrayList;
import java.util.Random;

public class SiriusInterfaceHandler
extends RadioInterfaceHandler
implements SiriusChannelListListener,
TuningResponseListener {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerLogger logger;
    private AslRadioSiriusFacade siriusRadio;
    private SiriusSubscriptionState subscriptionState;

    public SiriusInterfaceHandler(SpeechTunerServiceManager speechTunerServiceManager) {
        super(speechTunerServiceManager, false, "Sirius");
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SiriusInterfaceHandler] ");
    }

    @Override
    public boolean isReady() {
        return this.siriusRadio != null;
    }

    @Override
    public void registerForStationlist() {
        super.registerForStationlist();
        SiriusChannel[] siriusChannelArray = this.siriusRadio.registerForSiriusChannelList(this);
        this.updateChannelList(siriusChannelArray);
    }

    public void setSiriusRadio(AslRadioSiriusFacade aslRadioSiriusFacade) {
        this.siriusRadio = aslRadioSiriusFacade;
        if (this.slotUpdater != null && aslRadioSiriusFacade != null) {
            this.registerForStationlist();
        }
    }

    @Override
    protected void onSetSlotUpdater() {
        if (this.siriusRadio != null && this.slotUpdater != null) {
            this.registerForStationlist();
        }
    }

    @Override
    public boolean addingStationAllowed(Station station) {
        return station.getLongName() != null && !station.getLongName().equals("") || station.getShortName() != null && !station.getShortName().equals("");
    }

    public void setSubscriptionStateInterface(SiriusSubscriptionState siriusSubscriptionState) {
        this.subscriptionState = siriusSubscriptionState;
    }

    public boolean isSubscribed() {
        if (this.subscriptionState != null) {
            return this.subscriptionState.getSiriusSubscriptionState() == 2;
        }
        return false;
    }

    public SiriusChannel getAnyStation() {
        Object[] objectArray = this.stationlistCache.getStationList();
        if (objectArray.length > 0) {
            int n = new Random().nextInt(objectArray.length);
            return (SiriusChannel)objectArray[n];
        }
        return null;
    }

    @Override
    public void writeAnyStationIntoSelectedItem() {
        SiriusChannel siriusChannel = this.getAnyStation();
        if (siriusChannel != null) {
            Object[] objectArray = new SpeechTunerSiriusChannel[]{this.createInternalSiriusChannel(siriusChannel, null)};
            GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(-484296192);
            if (genericASLList != null) {
                genericASLList.updateList(objectArray);
            } else {
                this.logger.error("ASL list for Sirius Selected Item was null.");
            }
        } else {
            this.logger.error("Requested an example Sirius channel even though there are no speakable channels. Check problemhandling because it should have caught this problem before arriving at this point.");
        }
    }

    public void tuneSiriusChannel(TuningCallback tuningCallback, SpeechTunerSiriusChannel speechTunerSiriusChannel) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("tuning Sirius service with id ").append(speechTunerSiriusChannel.getObjectID()).toString());
        }
        this.lastCaller = tuningCallback;
        SiriusChannel siriusChannel = (SiriusChannel)this.stationlistCache.getStation(speechTunerSiriusChannel.getObjectID());
        if (siriusChannel == null) {
            this.logger.warn("channel is not available anymore");
            this.tuningResponse(new SiriusInterfaceHandler$1(this));
        } else {
            this.siriusRadio.tuneSiriusChannel(siriusChannel, this);
        }
    }

    public SpeechTunerSiriusChannel createInternalSiriusChannel(SiriusChannel siriusChannel, String string) {
        long l = this.serviceManager.getRadioUtils().getObjectId(siriusChannel);
        String string2 = siriusChannel.getLongName() != null && !siriusChannel.getLongName().equals("") ? siriusChannel.getLongName() : (siriusChannel.getShortName() != null && !siriusChannel.getShortName().equals("") ? siriusChannel.getShortName() : string);
        int n = siriusChannel.getStationNumber();
        return new SpeechTunerSiriusChannel(l, string2, n);
    }

    @Override
    public void updateChannelList(SiriusChannel[] siriusChannelArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("received a Sirius channellist update from tuner");
            this.logger.trace("writing Sirius channels to cache");
        }
        this.stationlistCache.add(siriusChannelArray, this);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("writing Sirius channels to slot");
        }
        this.slotUpdater.updateSiriusSlotData(siriusChannelArray);
    }

    @Override
    public void tuningResponse(TuningResponse tuningResponse) {
        if (this.lastCaller != null) {
            if (tuningResponse == null) {
                this.logger.warn("received invalid Sirius tuning response");
                this.lastCaller.onTuningResponse(null);
            } else if (tuningResponse.getResultState() == 1) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("tuning Sirius channel was successful");
                }
                this.lastCaller.onTuningResponse(tuningResponse);
            } else {
                this.logger.warn("tuning Sirius channel failed");
                this.lastCaller.onTuningResponse(null);
            }
            this.lastCaller = null;
        } else {
            this.logger.error("received Sirius tuning response without a caller that initiated the tuning process");
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("adding additional data to received Sirius nbest list");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            SpeechTunerSiriusChannel speechTunerSiriusChannel;
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) {
                speechTunerSiriusChannel = new SpeechTunerSiriusChannel(resultItem.getText(), resultItem.getSize());
            } else {
                SiriusChannel siriusChannel = (SiriusChannel)this.stationlistCache.getStation(resultItem.getIdentifier().getObjectId());
                if (siriusChannel == null) {
                    this.logger.warn(new StringBuffer().append("tried to fetch channel with id ").append(resultItem.getIdentifier().getObjectId()).append(" from cache which does not exist").toString());
                    speechTunerSiriusChannel = new SpeechTunerSiriusChannel(resultItem.getIdentifier().getObjectId(), resultItem.getIdentifier().getRecognizedString(), new Long(resultItem.getIdentifier().getObjectId()).intValue());
                } else {
                    speechTunerSiriusChannel = this.createInternalSiriusChannel(siriusChannel, resultItem.getIdentifier().getRecognizedString());
                }
            }
            arrayList.add(speechTunerSiriusChannel);
        }
        Object[] objectArray = new SpeechTunerSiriusChannel[arrayList.size()];
        arrayList.toArray(objectArray);
        asyncCallback.onResponse(objectArray);
    }
}


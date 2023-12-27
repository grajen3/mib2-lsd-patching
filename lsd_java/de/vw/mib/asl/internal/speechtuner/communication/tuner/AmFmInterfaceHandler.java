/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.tuner;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.amFm.AmFrequencyScale;
import de.vw.mib.asl.api.radio.amFm.FmFrequencyScale;
import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponse;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponseListener;
import de.vw.mib.asl.api.radio.speech.amfm.AslRadioAmFmFacade;
import de.vw.mib.asl.api.radio.speech.amfm.FmStationListListener;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.RadioInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.data.external.SpeechTunerExternalAmFmStation;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMStation;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.TuningCallback;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import java.util.ArrayList;
import java.util.Random;

public class AmFmInterfaceHandler
extends RadioInterfaceHandler
implements FmStationListListener,
AmFmTuningResponseListener {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerLogger logger;
    private AslRadioAmFmFacade amFmRadio;
    private IntIntOptHashMap subchannelCounts;

    public AmFmInterfaceHandler(SpeechTunerServiceManager speechTunerServiceManager) {
        super(speechTunerServiceManager, true, "FM");
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[AmFmInterfaceHandler] ");
        this.subchannelCounts = new IntIntOptHashMap();
    }

    @Override
    public boolean isReady() {
        return this.amFmRadio != null;
    }

    @Override
    public void registerForStationlist() {
        super.registerForStationlist();
        AmFmStation[] amFmStationArray = this.amFmRadio.registerForFmStationList(this);
        this.updateStationList(amFmStationArray);
    }

    public void setAmFmRadio(AslRadioAmFmFacade aslRadioAmFmFacade) {
        this.amFmRadio = aslRadioAmFmFacade;
        if (this.slotUpdater != null && aslRadioAmFmFacade != null) {
            this.registerForStationlist();
        }
    }

    @Override
    protected void onSetSlotUpdater() {
        if (this.amFmRadio != null && this.slotUpdater != null) {
            this.registerForStationlist();
        }
    }

    private void writeAMFrequencyScale(int n) {
        this.serviceManager.getModelServices().writeIntegerToDatapool(-551405056, n);
    }

    public void setAmFrequencyScale(AmFrequencyScale amFrequencyScale) {
        int n;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received AM frequency scale ").append(amFrequencyScale).toString());
        }
        if ((n = amFrequencyScale.getAmFrequencyScale()) == 5) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting AM frequency scale to AUS");
            }
            this.writeAMFrequencyScale(1);
        } else if (n == 3) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting AM frequency scale to JP");
            }
            this.writeAMFrequencyScale(2);
        } else if (n == 2 || n == 4) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting AM frequency scale to EU RdW");
            }
            this.writeAMFrequencyScale(0);
        } else if (n == 1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting AM frequency scale to NAR");
            }
            this.writeAMFrequencyScale(3);
        } else {
            this.logger.warn("unknown AM frequency scale");
            this.writeAMFrequencyScale(100);
        }
    }

    private void writeFMFrequencyScale(int n) {
        this.serviceManager.getModelServices().writeIntegerToDatapool(-534627840, n);
    }

    public void setFmFrequencyScale(FmFrequencyScale fmFrequencyScale) {
        int n;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received FM frequency scale ").append(fmFrequencyScale).toString());
        }
        if ((n = fmFrequencyScale.getFmFrequencyScale()) == 4) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting FM frequency scale to CHN");
            }
            this.writeFMFrequencyScale(1);
        } else if (n == 2 || n == 5) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting FM frequency scale to JP");
            }
            this.writeFMFrequencyScale(2);
        } else if (n == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting FM frequency scale to EU RdW");
            }
            this.writeFMFrequencyScale(0);
        } else if (n == 3) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting FM frequency scale to KOR");
            }
            this.writeFMFrequencyScale(4);
        } else if (n == 1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("setting FM frequency scale to NAR");
            }
            this.writeFMFrequencyScale(3);
        } else {
            this.logger.warn("unknown FM frequency scale");
            this.writeFMFrequencyScale(100);
        }
    }

    public AmFmStation getAnyStation() {
        Object[] objectArray = this.stationlistCache.getStationList();
        ArrayList arrayList = new ArrayList();
        if (objectArray.length > 0) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                AmFmStation amFmStation = (AmFmStation)objectArray[i2];
                if ((amFmStation.getLongName() == null || amFmStation.getLongName().equals("")) && (amFmStation.getShortName() == null || amFmStation.getShortName().equals(""))) continue;
                arrayList.add(objectArray[i2]);
            }
            if (arrayList.size() > 0) {
                int n = new Random().nextInt(arrayList.size());
                return (AmFmStation)arrayList.get(n);
            }
            int n = new Random().nextInt(objectArray.length);
            return (AmFmStation)objectArray[n];
        }
        return null;
    }

    @Override
    public void writeAnyStationIntoSelectedItem() {
        AmFmStation amFmStation = this.getAnyStation();
        if (amFmStation != null) {
            Object[] objectArray = new SpeechTunerFMStation[]{this.createInternalFMStation(amFmStation, null)};
            GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(-719177216);
            if (genericASLList != null) {
                genericASLList.updateList(objectArray);
            } else {
                this.logger.error("ASL list for FM Selected Item was null.");
            }
        } else {
            this.logger.error("Requested an example FM station even though there are no speakable stations. Check problemhandling because it should have caught this problem before arriving at this point.");
        }
    }

    public void tuneFmStation(TuningCallback tuningCallback, SpeechTunerFMStation speechTunerFMStation) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("tuning FM station with id ").append(speechTunerFMStation.getObjectID()).append(" and frequency ").append(speechTunerFMStation.getFrequency()).append(" kHz").toString());
        }
        this.lastCaller = tuningCallback;
        AmFmStation amFmStation = (AmFmStation)this.stationlistCache.getStation(speechTunerFMStation.getObjectID());
        if (amFmStation == null) {
            this.logger.warn("trying to tune FM station which is not in cache anymore");
            SpeechTunerFMFrequency speechTunerFMFrequency = new SpeechTunerFMFrequency(this.serviceManager.getRadioUtils(), speechTunerFMStation.getFrequency(), 0, false);
            this.tuneFrequency(tuningCallback, speechTunerFMFrequency);
        } else {
            this.amFmRadio.tuneStation(amFmStation, this);
        }
    }

    public void tuneFrequency(TuningCallback tuningCallback, SpeechTunerFrequency speechTunerFrequency) {
        Object object;
        if (this.logger.isTraceEnabled()) {
            object = speechTunerFrequency.getBand() == 0 ? "AM" : "FM";
            if (speechTunerFrequency.getHdSubChannel() == 0) {
                this.logger.trace(new StringBuffer().append("tuning  ").append((String)object).append(" station by frequency with frequency ").append(speechTunerFrequency.getFrequency()).append(" kHz").toString());
            } else {
                this.logger.trace(new StringBuffer().append("tuning  ").append((String)object).append(" station by frequency with frequency ").append(speechTunerFrequency.getFrequency()).append(" kHz and HD subchannel ").append(speechTunerFrequency.getHdSubChannel()).toString());
            }
        }
        this.lastCaller = tuningCallback;
        object = new SpeechTunerExternalAmFmStation(-1, -1L, speechTunerFrequency.getBand(), speechTunerFrequency.getFrequency(), speechTunerFrequency.getHdSubChannel(), "", "");
        this.amFmRadio.tuneStation((AmFmStation)object, this);
    }

    private void prepareMPSCheck(AmFmStation[] amFmStationArray) {
        this.subchannelCounts.clear();
        for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
            AmFmStation amFmStation = amFmStationArray[i2];
            int n = this.subchannelCounts.get(amFmStation.getFrequency());
            if (n >= 1) {
                this.subchannelCounts.put(amFmStation.getFrequency(), n + 1);
                continue;
            }
            this.subchannelCounts.put(amFmStation.getFrequency(), 1);
        }
    }

    public boolean isMPS(int n) {
        return this.subchannelCounts.get(n) <= 1;
    }

    public SpeechTunerFMStation createInternalFMStation(AmFmStation amFmStation, String string) {
        long l = this.serviceManager.getRadioUtils().getObjectId(amFmStation);
        String string2 = amFmStation.getLongName() != null && !amFmStation.getLongName().equals("") ? amFmStation.getLongName() : (amFmStation.getShortName() != null && !amFmStation.getShortName().equals("") ? amFmStation.getShortName() : (string != null && !string.equals("") ? string : this.serviceManager.getRadioUtils().getStringFromStationWithMHz(amFmStation)));
        int n = amFmStation.getFrequency();
        return new SpeechTunerFMStation(l, string2, n);
    }

    @Override
    public void updateStationList(AmFmStation[] amFmStationArray) {
        if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmByNameCoded()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("received an FM stationlist update from tuner");
                this.logger.trace("writing FM stations to cache");
            }
            this.stationlistCache.add(amFmStationArray, this);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("writing FM stations from cache to slot");
            }
            this.slotUpdater.updateFMSlotData(amFmStationArray);
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmHDFrequencyActive()) {
            this.prepareMPSCheck(amFmStationArray);
        }
    }

    @Override
    public void tuningResponse(TuningResponse tuningResponse) {
        if (this.lastCaller != null) {
            this.logger.warn("received unexpected AM or FM tuning response type from radio interface");
            this.lastCaller.onTuningResponse(null);
            this.lastCaller = null;
        } else {
            this.logger.error("received AM or FM tuning response with unexpected type and without a caller that initiated the tuning process");
        }
    }

    @Override
    public void tuningResponse(AmFmTuningResponse amFmTuningResponse) {
        if (this.lastCaller != null) {
            if (amFmTuningResponse == null || amFmTuningResponse.getAmFmStation() == null) {
                this.logger.warn("received invalid AM or FM tuning response");
                this.lastCaller.onTuningResponse(null);
            } else if (amFmTuningResponse.getResultState() == 1) {
                if (this.logger.isTraceEnabled()) {
                    long l = this.serviceManager.getRadioUtils().getObjectId(amFmTuningResponse.getAmFmStation());
                    String string = amFmTuningResponse.getAmFmStation().getBand() == 0 ? "AM" : "FM";
                    if (amFmTuningResponse.getAmFmStation().getHdServiceId() == 0) {
                        this.logger.trace(new StringBuffer().append("tuning ").append(string).append(" station with id ").append(l).append(" and frequency ").append(amFmTuningResponse.getAmFmStation().getFrequency()).append(" kHz was successful").toString());
                    } else {
                        this.logger.trace(new StringBuffer().append("tuning ").append(string).append(" station with id ").append(l).append(", frequency ").append(amFmTuningResponse.getAmFmStation().getFrequency()).append(" kHz and HD subchannel ").append(amFmTuningResponse.getAmFmStation().getHdServiceId()).append(" was successful").toString());
                    }
                }
                this.lastCaller.onTuningResponse(amFmTuningResponse);
            } else {
                if (this.logger.isTraceEnabled()) {
                    long l = this.serviceManager.getRadioUtils().getObjectId(amFmTuningResponse.getAmFmStation());
                    String string = amFmTuningResponse.getAmFmStation().getBand() == 0 ? "AM" : "FM";
                    if (amFmTuningResponse.getAmFmStation().getHdServiceId() == 0) {
                        this.logger.trace(new StringBuffer().append("tuning ").append(string).append(" station with id ").append(l).append(" and frequency ").append(amFmTuningResponse.getAmFmStation().getFrequency()).append(" kHz failed").toString());
                    } else {
                        this.logger.trace(new StringBuffer().append("tuning ").append(string).append(" station with id ").append(l).append(", frequency ").append(amFmTuningResponse.getAmFmStation().getFrequency()).append(" kHz and HD subchannel ").append(amFmTuningResponse.getAmFmStation().getHdServiceId()).append(" failed").toString());
                    }
                }
                this.lastCaller.onTuningResponse(null);
            }
            this.lastCaller = null;
        } else {
            this.logger.error("received AM or FM tuning response without a caller that initiated the tuning process");
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("adding additional data to received FM nbest list");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            SpeechTunerFMStation speechTunerFMStation;
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) {
                speechTunerFMStation = new SpeechTunerFMStation(resultItem.getText(), resultItem.getSize());
            } else {
                AmFmStation amFmStation = (AmFmStation)this.stationlistCache.getStation(resultItem.getIdentifier().getObjectId());
                if (amFmStation == null) {
                    this.logger.warn(new StringBuffer().append("tried to fetch FM station with id ").append(resultItem.getIdentifier().getObjectId()).append(" from cache which does not exist").toString());
                    speechTunerFMStation = new SpeechTunerFMStation(resultItem.getIdentifier().getObjectId(), resultItem.getIdentifier().getRecognizedString(), -1);
                } else {
                    speechTunerFMStation = this.createInternalFMStation(amFmStation, resultItem.getIdentifier().getRecognizedString());
                }
            }
            arrayList.add(speechTunerFMStation);
        }
        Object[] objectArray = new SpeechTunerFMStation[arrayList.size()];
        arrayList.toArray(objectArray);
        asyncCallback.onResponse(objectArray);
    }
}


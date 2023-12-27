/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.tuner;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechtuner.behavior.cache.StationListCache;
import de.vw.mib.asl.internal.speechtuner.slots.SpeechTunerSlotUpdater;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.TuningCallback;

public abstract class RadioInterfaceHandler
implements AdditionalDataService {
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerSlotUpdater slotUpdater;
    protected TuningCallback lastCaller;
    protected StationListCache stationlistCache;

    public RadioInterfaceHandler(SpeechTunerServiceManager speechTunerServiceManager, boolean bl, String string) {
        this.serviceManager = speechTunerServiceManager;
        this.stationlistCache = new StationListCache(speechTunerServiceManager, bl, string);
    }

    public abstract boolean isReady() {
    }

    public void registerForStationlist() {
        this.stationlistCache.initCleanUpTime();
    }

    protected abstract void onSetSlotUpdater() {
    }

    public void setSlotUpdater(SpeechTunerSlotUpdater speechTunerSlotUpdater) {
        this.slotUpdater = speechTunerSlotUpdater;
        this.onSetSlotUpdater();
    }

    public boolean isCacheEmpty() {
        return this.stationlistCache.isStationlistEmpty();
    }

    public boolean addingStationAllowed(Station station) {
        return true;
    }

    public abstract void writeAnyStationIntoSelectedItem() {
    }
}


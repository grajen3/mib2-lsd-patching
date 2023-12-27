/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.manager;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.Logger;

final class Tuner {
    private Logger logger = ServiceManager.logger;
    private final String mName;
    private final int mTID;
    private boolean mIsLoaded = false;

    Tuner(String string, int n) {
        this.mName = string;
        this.mTID = n;
    }

    void setLoaded() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("got power on: ").append(this.mName).log();
        }
        this.mIsLoaded = true;
    }

    void activate() {
        if (this.mIsLoaded) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("Tuner - activate: ").append(this.mName).log();
            }
            int n = RadioCurrentWaveband.isDab() ? -2054749952 : 0;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(ASLRadioTargetIds.ASL_RADIO_MANAGER, this.mTID, n, -1853423360);
            eventGeneric.setInt(0, RadioCurrentWaveband.get());
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    void deactivate() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MANAGER).append("deactivate: ").append(this.mName).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(ASLRadioTargetIds.ASL_RADIO_MANAGER, this.mTID, -2037972736, -1870200576);
        eventGeneric.setInt(0, RadioCurrentWaveband.get());
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    int getTID() {
        return this.mTID;
    }
}


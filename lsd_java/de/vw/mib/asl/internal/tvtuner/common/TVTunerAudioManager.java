/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.genericevents.EventGeneric;

public class TVTunerAudioManager {
    private boolean isVolumeLockNeeded = false;

    public void requestTVAudioConnection() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerAudioManager#requestTVAudioConnection called");
        }
        if (TVTunerObjectAccessor.getTargetTVTuner().isTVContextEntered()) {
            boolean bl = false;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
            if (TVTunerObjectAccessor.getTargetTVTuner().isAudioAvailable() && TVTunerObjectAccessor.getTargetTVTuner().isTVTunerAvailable()) {
                bl = true;
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerAudioManager#requestTVAudioConnection: Requesting tv audio connection");
                }
                eventGeneric.setInt(0, 27);
            } else {
                bl = false;
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerAudioManager#requestTVAudioConnection: suppressing all audio");
                    TVTunerHelper.trace(new StringBuffer().append("TVTunerAudioManager#requestTVAudioConnection: audio ").append(TVTunerObjectAccessor.getTargetTVTuner().isAudioAvailable() ? "available" : "not available").append(", tv ").append(TVTunerObjectAccessor.getTargetTVTuner().isTVTunerAvailable() ? "available" : "not available").toString());
                }
                eventGeneric.setInt(0, 9);
            }
            eventGeneric.setBoolean(2, true);
            eventGeneric.setSenderEventId(-1601830656);
            TVTunerObjectAccessor.getTargetTVTuner().sendSafe(eventGeneric);
            if (bl) {
                this.checkVolumeLock();
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerAudioManager#requestTVAudioConnection: doing nothing because tv tuner is not active context");
        }
    }

    public void checkVolumeLock() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerAudioManager#checkVolumeLock: setting volume lock = ").append(this.isVolumeLockNeeded() ? "active" : "inactive").toString());
        }
        if (this.isVolumeLockNeeded()) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
            eventGeneric.setInt(0, 27);
            eventGeneric.setSenderEventId(-1551499008);
            TVTunerObjectAccessor.getTargetTVTuner().sendSafe(eventGeneric);
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
            eventGeneric.setInt(0, 27);
            eventGeneric.setSenderEventId(-1534721792);
            TVTunerObjectAccessor.getTargetTVTuner().sendSafe(eventGeneric);
        }
    }

    public boolean isVolumeLockNeeded() {
        return this.isVolumeLockNeeded;
    }

    public void setVolumeLockNeeded(boolean bl) {
        if (TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() == 1) {
            bl = false;
        }
        this.isVolumeLockNeeded = bl;
    }
}


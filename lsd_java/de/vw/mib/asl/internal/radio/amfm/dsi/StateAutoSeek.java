/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActiveTargetSeek;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.util.AbstractState;
import de.vw.mib.asl.internal.radio.util.StateMachineOwner;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public final class StateAutoSeek
extends AbstractState {
    private Logger logger = ServiceManager.logger;
    private static final long TIMEOUT;
    private int mResult;
    private final long mTimeout;
    private int seekMode;

    StateAutoSeek(StateMachineOwner stateMachineOwner, String string, HsmState hsmState) {
        super(stateMachineOwner, string, hsmState);
        this.mTimeout = 0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                HsmTarget.seekAbort = false;
                RadioData.getAmfmDatabase().setStationBeforeSeekStarted();
                EventGeneric eventGeneric2 = this.getRequest();
                this.seekMode = eventGeneric2.getInt(0);
                this.mOwner.getAmfmTuner().seekStation(this.seekMode);
                this.mResult = 0;
                break;
            }
            case 101001: {
                this.mResult = 11;
                this.mOwner.getAmfmTuner().seekStation(3);
                HsmTarget.seekAbort = true;
                break;
            }
            case 101002: {
                this.mResult = 11;
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) {
                    this.mOwner.getAmfmTuner().seekStation(4);
                    break;
                }
                if (6 == this.seekMode) {
                    this.mOwner.getAmfmTuner().seekStation(2);
                    break;
                }
                if (5 == this.seekMode) {
                    this.mOwner.getAmfmTuner().seekStation(1);
                    break;
                }
                this.mOwner.getAmfmTuner().seekStation(4);
                break;
            }
            case 101040: {
                this.mResult = 11;
                this.mOwner.getAmfmTuner().seekStation(3);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    @Override
    public long getTimeout() {
        return this.mTimeout;
    }

    public void dsiAMFMTunerSeekStationStatus(int n) {
        AmFmProxyHelper.seekStationStatus(this.mOwner.getTargetId(), n);
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("dsiAMFMTunerSeekStationStatus: ").append(n).log();
        }
        switch (n) {
            case 0: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                this.getRequest().setResult(this.mResult);
                this.getRequest().setInt(1, n);
                if (StateAmFmActiveTargetSeek.getTargetSeekStatus() == 2) {
                    StateAmFmActiveTargetSeek.setTargetSeekStatus(3);
                    AmFmPresetApi.autoCompare();
                }
                this.transitionToIdle();
                break;
            }
            case 1: {
                super.retriggerTimeout();
                break;
            }
        }
    }

    @Override
    protected void onTimeout() {
        this.mOwner.getAmfmTuner().seekStation(3);
        super.onTimeout();
    }
}


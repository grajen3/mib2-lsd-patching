/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateActivate;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateActivateStep0Precondition;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateActivateStep1Audio;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateActivateStep2Tune;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateActivateStep3FadeIn;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateActive;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateInactive;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateMain;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateMainIdle;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateMainScan;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateNotFunctional;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateSpeller;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateTop;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.hsm.HsmState;

public final class SatMainTarget
extends AbstractASLHsmTarget {
    private final HsmState mStateTop;
    private final HsmState mStateActivate;
    private final HsmState mStateActive;
    private final HsmState mStateInactive;
    private final HsmState mStateMain;
    private final HsmState mStateMainIdle;
    private final HsmState mStateMainScan;
    private final HsmState mStateMainNotFunctional;
    private final HsmState mStateSpeller;
    private final HsmState mStateActivate0;
    private final HsmState mStateActivate1;
    private final HsmState mStateActivate2;
    private final HsmState mStateActivate3;
    private final SatDb mDb;
    private final IAslPool mPool;
    private boolean mTuneSuccess = false;
    private boolean mAudioConnectionValid = false;

    public SatMainTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.hsm.verbose = false;
        this.mDb = SatDb.getInstance();
        this.mDb.initialize(this);
        this.mPool = this.mDb.getPool();
        this.mStateTop = new SatMainStateTop(this.mDb, this, this.hsm, "stateTop", this.getWorkStateParent());
        this.mStateActivate = new SatMainStateActivate(this.mDb, this, this.hsm, this.mStateTop);
        this.mStateActivate0 = new SatMainStateActivateStep0Precondition(this.mDb, this, this.hsm, this.mStateActivate);
        this.mStateActivate1 = new SatMainStateActivateStep1Audio(this.mDb, this, this.hsm, this.mStateActivate);
        this.mStateActivate2 = new SatMainStateActivateStep2Tune(this.mDb, this, this.hsm, this.mStateActivate);
        this.mStateActivate3 = new SatMainStateActivateStep3FadeIn(this.mDb, this, this.hsm, this.mStateActivate);
        this.mStateActive = new SatMainStateActive(this.mDb, this, this.hsm, "stateActive", this.mStateTop);
        this.mStateInactive = new SatMainStateInactive(this.mDb, this, this.hsm, this.mStateTop);
        this.mStateMain = new SatMainStateMain(this.mDb, this, this.hsm, this.mStateActive);
        this.mStateMainIdle = new SatMainStateMainIdle(this.mDb, this, this.hsm, this.mStateMain);
        this.mStateMainScan = new SatMainStateMainScan(this.mDb, this, this.hsm, this.mStateMain);
        this.mStateMainNotFunctional = new SatMainStateNotFunctional(this.mDb, this, this.hsm, this.mStateMain);
        this.mStateSpeller = new SatMainStateSpeller(this.mDb, this, this.hsm, this.mStateActive);
        this.mPool.addListener(147, this.getTargetId(), -1366949632);
    }

    @Override
    public int getDefaultTargetId() {
        return ASLRadioTargetIds.ASL_SDARS_MAIN_TARGET;
    }

    void transStateActive() {
        this.hsm.trans(this.mStateActive);
    }

    void transStateInactive() {
        this.hsm.trans(this.mStateInactive);
    }

    void transStateMainIdle() {
        int n = this.mPool.getInt(147);
        if (n == 0) {
            this.hsm.trans(this.mStateMainNotFunctional);
        } else {
            this.hsm.trans(this.mStateMainIdle);
        }
    }

    void transStateMainNotFunctional() {
        this.hsm.trans(this.mStateMainNotFunctional);
    }

    void transStateMainScan() {
        this.hsm.trans(this.mStateMainScan);
    }

    void transStateSpeller() {
        this.hsm.trans(this.mStateSpeller);
    }

    void transActivate() {
        this.hsm.trans(this.mStateActivate);
    }

    void transActivate0() {
        this.hsm.trans(this.mStateActivate0);
    }

    void transActivate1() {
        this.hsm.trans(this.mStateActivate1);
    }

    void transActivate2() {
        this.hsm.trans(this.mStateActivate2);
    }

    void transActivate3() {
        this.hsm.trans(this.mStateActivate3);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.mStateTop;
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        SatDb.logEvent("Main", eventGeneric);
        switch (eventGeneric.getReceiverEventId()) {
            case 1076141833: {
                this.mDb.getPresetApi().setSatPresetCountFromModel(eventGeneric);
                break;
            }
            default: {
                super.gotEvent(eventGeneric);
            }
        }
    }

    void resetSettings() {
        this.mPool.setInt(35, 0);
        this.mDb.getDsiApi().reset(1);
    }

    boolean hasTuned() {
        return this.mTuneSuccess;
    }

    void setTuned(boolean bl) {
        this.mTuneSuccess = bl;
    }

    boolean isAudioConnectionValid() {
        return this.mAudioConnectionValid;
    }

    void setAudioConnectionValid(boolean bl) {
        this.mAudioConnectionValid = bl;
    }

    public void startTimerCheckPlayingChannel() {
        GenericEvents genericEvents = this.getMainObject();
        TimerServer timerServer = genericEvents.getTimerServer();
        int n = this.mPool.getInt(56);
        if (n > 0) {
            timerServer.restartOrStartTimedEvent(this.getTargetId(), -1400504064, n, false);
        }
    }

    public void restartActivation() {
        this.setTuned(false);
        this.setAudioConnectionValid(false);
        this.transActivate1();
    }
}


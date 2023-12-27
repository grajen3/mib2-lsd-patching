/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.states;

import de.vw.mib.bap.mqbpq.audiosd.states.AudioSdHsmContextDelegate;
import de.vw.mib.bap.mqbpq.audiosd.states.RunningState;
import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.states.FsgHsmContext;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class AudioSdHsmContext
extends FsgHsmContext {
    private HsmState _runningState;
    private AudioSdHsmContextDelegate _delegate;

    public AudioSdHsmContext(Hsm hsm, HsmState hsmState) {
        super(hsm, hsmState);
    }

    @Override
    public HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getTopState());
        }
        return this._runningState;
    }

    @Override
    public HsmContextDelegate getContextDelegate() {
        return this.getAudioSdContextDelegate();
    }

    public AudioSdHsmContextDelegate getAudioSdContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(AudioSdHsmContextDelegate audioSdHsmContextDelegate) {
        this._delegate = audioSdHsmContextDelegate;
    }
}


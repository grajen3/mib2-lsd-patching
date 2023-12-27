/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmSoundWaveplayerHandling$StateWaveplayerHandlingIdle
extends AbstractHsmState {
    private HsmSoundWaveplayerHandling target;
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateWaveplayerHandlingIdle(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                if (this.target.pendingSystemBeep == null) break;
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("SoundWaveplayerHandlingIdle.Start: play pending Beep ").append(this.this$0.getPlayTone(this.target.pendingSystemBeep)).log();
                }
                if (this.this$0.isStaticConnectionTone(HsmSoundWaveplayerHandling.newPlayTone = this.this$0.getPlayTone(this.target.pendingSystemBeep))) {
                    this.trans(this.this$0.stateWaveplayerTonesetting);
                } else {
                    this.trans(this.this$0.stateWaveplayerConnecting);
                }
                this.target.pendingSystemBeep.setBlocked(false);
                this.this$0.sendBack(this.target.pendingSystemBeep);
                this.target.pendingSystemBeep = null;
                break;
            }
            case 4000038: 
            case 0x400004EE: {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("SoundWaveplayerHandlingIdle: received CreateBeep ToneId ").append(this.this$0.getPlayTone(eventGeneric)).log();
                }
                if (this.target.getHsm().isActive(this.this$0.stateWaveplayerIdle)) {
                    HsmSoundWaveplayerHandling.newPlayTone = this.this$0.getPlayTone(eventGeneric);
                    if (this.this$0.isStaticConnectionTone(HsmSoundWaveplayerHandling.newPlayTone)) {
                        this.trans(this.this$0.stateWaveplayerTonesetting);
                        break;
                    }
                    this.trans(this.this$0.stateWaveplayerConnecting);
                    break;
                }
                this.this$0.info(new StringBuffer().append(this.target.getHsm().getState().getName()).append("++SoundWaveplayerHandlingIdle ************* UNEXPECTED CreateBeep ").append(eventGeneric).toString());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiWavePlayerUpdateAudioRequest(int n, int n2) {
        switch (n) {
            default: 
        }
        this.this$0.warn(new StringBuffer().append("SoundWaveplayerHandlingIdle: Unexpected player state ").append(n).append("!").toString());
    }

    public void dsiAudioManagementAsyncException(int n, String string, int n2) {
        this.this$0.trace(new StringBuffer().append("[error]ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").toString());
    }
}


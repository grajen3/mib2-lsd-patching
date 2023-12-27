/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling;
import de.vw.mib.asl.internal.sound.HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;

public class HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit
extends AbstractHsmState {
    private HsmSoundWaveplayerHandling target;
    private final /* synthetic */ HsmSoundWaveplayerHandling this$0;

    public HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit(HsmSoundWaveplayerHandling hsmSoundWaveplayerHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundWaveplayerHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.initDsi();
                this.target.dsiAudioManagement.setNotification(1, (DSIListener)this.this$0.dsiAudioManagementListener);
                this.target.dsiWavePlayer.setNotification(2, (DSIListener)this.this$0.dsiWavePlayerListener);
                this.initFromPersistence();
                this.installProfileChangeListener();
                break;
            }
            case 4: {
                break;
            }
            case 3: {
                break;
            }
            case 1073743082: {
                int n = eventGeneric.getInt(0);
                this.handleTouchscreenFeedback(n == 0);
                break;
            }
            case 4300013: {
                this.handleTouchscreenFeedback(false);
                break;
            }
            case 4300062: {
                this.initFromPersistence();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAudioManagementUpdateAMAvailable(int n, int n2, int n3) {
        if (n == 3) {
            if (!this.target.getHsm().isActive(this.this$0.stateWaveplayerIdle)) {
                this.trans(this.this$0.stateWaveplayerIdle);
            }
        } else {
            this.target.pendingSystemBeep = null;
            if (!this.target.getHsm().getState().equals(this.this$0.stateInit)) {
                this.trans(this.this$0.stateInit);
            }
        }
    }

    void initFromPersistence() {
        boolean bl = ASLSystemFactory.getSystemApi().getSharedSystemCommonPersistence().isAcousticTouchscreenFeedback();
        AbstractASLHsmTarget.writeBooleanToDatapool(1467, bl);
        ServiceManager.soundWaveplayer.setPlayerEnabled(bl);
    }

    private void handleTouchscreenFeedback(boolean bl) {
        ASLSystemFactory.getSystemApi().getSharedSystemCommonPersistence().setAcousticTouchscreenFeedback(bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(1467, bl);
        ServiceManager.soundWaveplayer.setPlayerEnabled(bl);
        if (!(bl || this.target.getHsm().getState().equals(this.this$0.stateInit) || this.target.getHsm().getState().equals(this.this$0.stateWaveplayerIdle))) {
            this.trans(this.this$0.stateWaveplayerIdle);
        }
    }

    private void installProfileChangeListener() {
        ASLSystemFactory.getSystemApi().getSharedSystemCommonPersistence().addProfileChangeListener(new HsmSoundWaveplayerHandling$StateSoundWaveplayerHandlingInit$1(this));
    }
}


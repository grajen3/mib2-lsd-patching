/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.sound.HsmSoundSetterHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;

public class HsmSoundSetterHandling$StateSoundSetterHandlingInit
extends AbstractHsmState {
    private HsmSoundSetterHandling target;
    private final /* synthetic */ HsmSoundSetterHandling this$0;

    public HsmSoundSetterHandling$StateSoundSetterHandlingInit(HsmSoundSetterHandling hsmSoundSetterHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundSetterHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.initDSI();
                this.target.dsiAudioManagement.setNotification(1, (DSIListener)this.target.dsiAudioManagementListener);
                break;
            }
            case 4: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAudioManagementUpdateAMAvailable(int n, int n2, int n3) {
        if (n == 3 && !this.target.getHsm().isActive(this.this$0.stateMain)) {
            this.trans(this.this$0.stateMain);
        }
    }

    public void dsiAudioManagementAsyncException(int n, String string, int n2) {
        this.this$0.trace(new StringBuffer().append("[error]ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").toString());
    }
}


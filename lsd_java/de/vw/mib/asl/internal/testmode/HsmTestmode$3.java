/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.internal.testmode.HsmTestmode;
import de.vw.mib.asl.internal.testmode.TargetETM;
import de.vw.mib.asl.internal.testmode.TargetGEM;
import de.vw.mib.asl.internal.testmode.TargetLanguage;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmTestmode$3
extends AbstractHsmState {
    private final /* synthetic */ HsmTestmode this$0;

    HsmTestmode$3(HsmTestmode hsmTestmode, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmTestmode;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.info().append("[HsmTestmode] ").append("Enter Testmode, enable Targets ETM and GEM").log();
                TargetETM.enableTarget(this.this$0);
                TargetGEM.enableTarget(this.this$0);
                this.this$0.registerGEMService();
                TargetLanguage.enableTarget(this.this$0);
                break;
            }
            case 4: {
                this.this$0.info().append("[HsmTestmode] ").append("Exit Testmode").log();
                TargetGEM.getInstance().triggerExit();
                break;
            }
            default: {
                hsmState = this.this$0.stateWork;
            }
        }
        return hsmState;
    }
}


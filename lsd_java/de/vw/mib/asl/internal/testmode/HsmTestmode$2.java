/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.internal.testmode.HsmTestmode;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmTestmode$2
extends AbstractHsmState {
    private final /* synthetic */ HsmTestmode this$0;

    HsmTestmode$2(HsmTestmode hsmTestmode, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmTestmode;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return this.this$0.stateWork;
    }
}


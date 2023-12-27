/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class RadiotextStateDeviceOn
extends AbstractHsmState {
    private final RadiotextTarget mTarget;

    RadiotextStateDeviceOn(RadiotextTarget radiotextTarget, String string, HsmState hsmState) {
        super(radiotextTarget.getHsm(), string, hsmState);
        this.mTarget = radiotextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: 
            case 100001: {
                this.mTarget.transWaitFreeze();
                break;
            }
            case 100100: {
                this.mTarget.transDeviceOff();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


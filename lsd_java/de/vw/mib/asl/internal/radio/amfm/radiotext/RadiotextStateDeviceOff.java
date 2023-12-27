/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class RadiotextStateDeviceOff
extends AbstractHsmState {
    private final RadiotextTarget mTarget;

    RadiotextStateDeviceOff(RadiotextTarget radiotextTarget, String string, HsmState hsmState) {
        super(radiotextTarget.getHsm(), string, hsmState);
        this.mTarget = radiotextTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.mTarget.register();
                break;
            }
            case 100101: {
                this.mTarget.transDeviceOn();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


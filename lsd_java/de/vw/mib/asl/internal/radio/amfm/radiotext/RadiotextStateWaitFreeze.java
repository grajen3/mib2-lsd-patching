/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextPresenter;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStorage;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class RadiotextStateWaitFreeze
extends AbstractHsmState {
    private final RadiotextTarget mTarget;
    private final RadiotextStorage mRadiotextStorage;
    private final RadiotextPresenter mRadiotextPresenter;

    RadiotextStateWaitFreeze(RadiotextTarget radiotextTarget, String string, HsmState hsmState, RadiotextStorage radiotextStorage, RadiotextPresenter radiotextPresenter) {
        super(radiotextTarget.getHsm(), string, hsmState);
        this.mTarget = radiotextTarget;
        this.mRadiotextStorage = radiotextStorage;
        this.mRadiotextPresenter = radiotextPresenter;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.startTimer(-1568276224, (long)0, false);
                break;
            }
            case 3: {
                this.mRadiotextStorage.clear();
                this.mRadiotextPresenter.show(0);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(-1568276224);
                break;
            }
            case 100001: {
                this.mRadiotextStorage.clear();
                this.mTarget.restartTimer(-1568276224);
                break;
            }
            case 100002: {
                if (this.mRadiotextStorage.isDirty()) {
                    this.mTarget.transShowFreeze();
                    break;
                }
                this.mTarget.transWaitIdle();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


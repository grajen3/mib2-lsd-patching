/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextPresenter;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextShowtime;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStorage;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class RadiotextStateShowFreeze
extends AbstractHsmState {
    private final RadiotextTarget mTarget;
    private final RadiotextStorage mRadiotextStorage;
    private final RadiotextShowtime mRadiotextShowtime;
    private final RadiotextPresenter mRadiotextPresenter;
    private boolean mTimer;

    RadiotextStateShowFreeze(RadiotextTarget radiotextTarget, String string, HsmState hsmState, RadiotextStorage radiotextStorage, RadiotextShowtime radiotextShowtime, RadiotextPresenter radiotextPresenter) {
        super(radiotextTarget.getHsm(), string, hsmState);
        this.mTarget = radiotextTarget;
        this.mRadiotextStorage = radiotextStorage;
        this.mRadiotextShowtime = radiotextShowtime;
        this.mRadiotextPresenter = radiotextPresenter;
        this.mTimer = false;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: 
            case 100002: {
                if (this.mRadiotextStorage.isDirty()) {
                    this.mRadiotextPresenter.show();
                    this.mTarget.startTimer(-1568276224, (long)this.mRadiotextShowtime.getTime(), false);
                    this.mTimer = true;
                    break;
                }
                this.mTimer = false;
                this.mTarget.transShowIdle();
                break;
            }
            case 4: {
                if (!this.mTimer) break;
                this.mTimer = false;
                this.mTarget.stopTimer(-1568276224);
                break;
            }
            case 100004: {
                this.mTarget.transWaitFreeze();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


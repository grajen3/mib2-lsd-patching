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

final class RadiotextStateTop
extends AbstractHsmState {
    private final RadiotextTarget mTarget;
    private final RadiotextPresenter mRadiotextPresenter;
    private final RadiotextStorage mRadiotextStorage;
    private final RadiotextShowtime mRadiotextShowtime;

    RadiotextStateTop(RadiotextTarget radiotextTarget, String string, HsmState hsmState, RadiotextPresenter radiotextPresenter, RadiotextStorage radiotextStorage, RadiotextShowtime radiotextShowtime) {
        super(radiotextTarget.getHsm(), string, hsmState);
        this.mTarget = radiotextTarget;
        this.mRadiotextPresenter = radiotextPresenter;
        this.mRadiotextStorage = radiotextStorage;
        this.mRadiotextShowtime = radiotextShowtime;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.transDeviceOff();
                break;
            }
            case 4300007: {
                boolean bl = eventGeneric.getBoolean(0);
                this.mRadiotextShowtime.setThresholdExceeded(bl);
                break;
            }
            case 4300075: {
                int n = eventGeneric.getInt(0);
                this.mRadiotextShowtime.setTime(n);
                break;
            }
            case 100005: {
                this.mRadiotextStorage.timeout();
                break;
            }
            case 100007: {
                String string = eventGeneric.getString(1);
                String string2 = eventGeneric.getString(2);
                this.mRadiotextPresenter.show(string, string2);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


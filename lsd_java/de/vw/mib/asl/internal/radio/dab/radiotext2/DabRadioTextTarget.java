/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.radiotext2.ReceivedRadioText;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateDABOff;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateDABOn;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateLoading1;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateLoading2;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateNoText;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateTextAvailable1;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateTextAvailable2;
import de.vw.mib.asl.internal.radio.dab.radiotext2.StateTop;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

final class DabRadioTextTarget
extends TargetHsmImpl {
    private final HsmState mStateTop;
    private final HsmState mStateDABOff;
    private final HsmState mStateDABOn;
    private final HsmState mStateLoading1;
    private final HsmState mStateLoading2;
    private final HsmState mStateNoText;
    private final HsmState mStateTextAvailable1;
    private final HsmState mStateTextAvailable2;
    final ReceivedRadioText mRadioText = new ReceivedRadioText(this);
    boolean mSyncAvailable;

    DabRadioTextTarget(GenericEvents genericEvents, String string) {
        super(genericEvents);
        this.mStateTop = new StateTop(this, null);
        this.mStateDABOff = new StateDABOff(this, this.mStateTop);
        this.mStateDABOn = new StateDABOn(this, this.mStateTop);
        this.mStateLoading1 = new StateLoading1(this, this.mStateDABOn);
        this.mStateLoading2 = new StateLoading2(this, this.mStateDABOn);
        this.mStateNoText = new StateNoText(this, this.mStateDABOn);
        this.mStateTextAvailable1 = new StateTextAvailable1(this, this.mStateDABOn);
        this.mStateTextAvailable2 = new StateTextAvailable2(this, this.mStateDABOn);
        try {
            this.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), string, this.mStateTop);
        }
        catch (Exception exception) {
            ServiceManager.logger.error(256, "COULD NOT START DAB RadioText Controller.", exception);
        }
    }

    void transStateDABOn() {
        this.hsm.trans(this.mStateDABOn);
    }

    void transStateDABOff() {
        this.hsm.trans(this.mStateDABOff);
    }

    void transStateLoading1() {
        this.hsm.trans(this.mStateLoading1);
    }

    void transStateLoading2() {
        this.hsm.trans(this.mStateLoading2);
    }

    void transStateNoText() {
        this.hsm.trans(this.mStateNoText);
    }

    void transStateTextAvailable1() {
        this.hsm.trans(this.mStateTextAvailable1);
    }

    void transStateTextAvailable2() {
        this.hsm.trans(this.mStateTextAvailable2);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }
}


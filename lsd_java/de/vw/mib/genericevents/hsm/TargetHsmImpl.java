/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.hsm;

import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class TargetHsmImpl
extends AbstractTarget {
    protected Hsm hsm = new Hsm(this.getMyShortName(), null);

    public TargetHsmImpl() {
    }

    public TargetHsmImpl(GenericEvents genericEvents) {
        super(genericEvents);
    }

    public final Hsm getHsm() {
        return this.hsm;
    }

    public final String getTaskId() {
        return this.getEventDispatcher().getTaskId(this.getTargetId());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        this.hsm.onEvent(eventGeneric);
    }

    public final boolean isStateActive(HsmState hsmState) {
        return this.hsm.isActive(hsmState);
    }

    public final void startHsmAndRegisterTarget(GenericEvents genericEvents, int n, String string, HsmState hsmState) {
        this.setEventContext(genericEvents);
        this.initHsm(null, hsmState, true);
        this.register(this.getMainObject(), n, string);
    }

    private String getMyShortName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            string = string.substring(n + 1);
        }
        if (string == null || string.length() == 0) {
            string = "hsm";
        }
        return string;
    }

    protected void initHsm(String string, HsmState hsmState, boolean bl) {
        String string2 = string == null || string.length() == 0 ? this.getMyShortName() : string;
        this.hsm.init(string2, hsmState);
        this.hsm.verbose = bl;
        this.hsm.onStart();
    }
}


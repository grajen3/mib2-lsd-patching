/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateInactive
extends AbstractHsmState {
    private final HsmDabDsi mDsiHsm;

    StateInactive(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi.getHsm(), string, hsmState);
        this.mDsiHsm = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateInactive is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 100000: {
                break;
            }
            case 100112: {
                this.trans(this.mDsiHsm.stateActivate);
                break;
            }
            case 100113: {
                DabMainApi.notifyTunerDeactivated();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


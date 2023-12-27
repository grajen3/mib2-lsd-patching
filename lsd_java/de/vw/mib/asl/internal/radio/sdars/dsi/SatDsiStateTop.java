/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.sdars.dsi.AbstractDsiState;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatDsiStateTop
extends AbstractDsiState {
    SatDsiStateTop(SatDb satDb, SatDsiTarget satDsiTarget) {
        super(satDb, satDsiTarget, satDsiTarget.getHsm(), "Top", null);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(41, this.getName());
                break;
            }
            case 3: {
                this.mTarget.transStateInactive();
                break;
            }
            case 8: {
                this.mTarget.allocateProxy();
                break;
            }
            case 100107: {
                this.getLogHandler().simpleTrace("-DSISDARSTUNER_ASYNC_EXCEPTION");
                break;
            }
            case 100106: {
                this.getLogHandler().simpleTrace("-RESPONSE_SELECT_STATION");
                break;
            }
            default: {
                SatDb.logEvent("-DSI", eventGeneric);
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


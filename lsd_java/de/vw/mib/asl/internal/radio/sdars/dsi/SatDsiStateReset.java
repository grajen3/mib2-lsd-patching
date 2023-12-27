/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.sdars.dsi.AbstractDsiState;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

final class SatDsiStateReset
extends AbstractDsiState {
    SatDsiStateReset(SatDb satDb, SatDsiTarget satDsiTarget, HsmState hsmState) {
        super(satDb, satDsiTarget, satDsiTarget.getHsm(), "Reset", hsmState);
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
                EventGeneric eventGeneric2 = this.mTarget.getCurrentEvent();
                int n = eventGeneric2.getInt(0);
                this.mTarget.getSdarsTuner().reset(n);
                this.mTarget.transStateIdle();
                break;
            }
            case 100107: {
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                int n2 = eventGeneric.getInt(2);
                this.asyncException(n, string, n2);
                break;
            }
            case 4: {
                this.mTarget.sendAnswer();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void asyncException(int n, String string, int n2) {
        LogMessage logMessage = this.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("DSISDARSTUNER_ASYNCEXCEPTION").log();
        }
        this.mTarget.setResult(3);
        this.mTarget.transStateIdle();
    }
}


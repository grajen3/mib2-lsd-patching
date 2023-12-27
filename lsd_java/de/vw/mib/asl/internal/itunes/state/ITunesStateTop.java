/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.state;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.ITunesHandler;
import de.vw.mib.asl.internal.itunes.state.ITunesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class ITunesStateTop
extends AbstractHsmState {
    private final ITunesTarget mTarget;

    ITunesStateTop(ITunesTarget iTunesTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = iTunesTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                this.mTarget.registerObservers();
                this.mTarget.initializeDSI();
                this.mTarget.setNotifications();
                this.trans(this.mTarget.mStateActive);
                ITunesHandler.getITunesController().notifyItunesStarted();
                ITunesHandler.getITunesController().setFirstTagAfterStartupOrAfterDeviceConnected(true);
                break;
            }
            case 4: {
                break;
            }
            case 40672: {
                String string = eventGeneric.getString(0);
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES     ").append(" Request instance number ").append(" identifier = ").append(string).log();
                }
                ITunesHandler.getITunesController().sendNextInstanceNumberResponse(string);
                break;
            }
            default: {
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES  :: StateTop :   ").append(eventGeneric.getServiceId()).log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


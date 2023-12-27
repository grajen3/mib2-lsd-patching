/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.state;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.state.ITunesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class ITunesStateDeviceNotConnectedIdle
extends AbstractHsmState {
    private final ITunesTarget mTarget;

    ITunesStateDeviceNotConnectedIdle(ITunesTarget iTunesTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = iTunesTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 40670: {
                this.trans(this.mTarget.mStateDeviceNotConnectedProcessing);
                this.mTarget.triggerMe(ServiceManager.mGenericEventFactory.newEvent(eventGeneric), -560070656);
                break;
            }
            case 40675: {
                this.trans(this.mTarget.mStateDeviceNotConnectedProcessing);
                this.mTarget.triggerMe(ServiceManager.mGenericEventFactory.newEvent(eventGeneric), -476184576);
                break;
            }
            default: {
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("           ITUNES  : StateDeviceNotConnectedIdle :   ").append(eventGeneric.getServiceId()).log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


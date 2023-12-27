/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.state;

import de.vw.mib.asl.internal.itunes.ITunesHandler;
import de.vw.mib.asl.internal.itunes.state.ITunesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class ITunesStateDeviceConnected
extends AbstractHsmState {
    private final ITunesTarget mTarget;

    ITunesStateDeviceConnected(ITunesTarget iTunesTarget, Hsm hsm, String string, HsmState hsmState) {
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
                if (ITunesHandler.getITunesController().checkForTagsAvailability()) {
                    this.trans(this.mTarget.mStateDeviceConnectedTransfering);
                    break;
                }
                this.trans(this.mTarget.mStateDeviceConnectedIdle);
                break;
            }
            case 4: {
                break;
            }
            case 40674: {
                int n = eventGeneric.getInt(0);
                ITunesHandler.getITunesController().removeAllTags(n);
                this.trans(this.mTarget.mStateDeviceConnectedIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


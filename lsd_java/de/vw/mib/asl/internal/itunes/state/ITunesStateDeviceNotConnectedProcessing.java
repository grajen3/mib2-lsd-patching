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
import org.dsi.ifc.media.TagInformation;

public class ITunesStateDeviceNotConnectedProcessing
extends AbstractHsmState {
    private final ITunesTarget mTarget;

    ITunesStateDeviceNotConnectedProcessing(ITunesTarget iTunesTarget, Hsm hsm, String string, HsmState hsmState) {
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
                int n = eventGeneric.getInt(0);
                TagInformation tagInformation = (TagInformation)eventGeneric.getObject(1);
                TagInformation tagInformation2 = (TagInformation)eventGeneric.getObject(2);
                ITunesHandler.getITunesController().handleTags(tagInformation, tagInformation2, n, false);
                this.trans(this.mTarget.mStateDeviceNotConnectedIdle);
                break;
            }
            case 40675: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                TagInformation tagInformation = (TagInformation)eventGeneric.getObject(2);
                ITunesHandler.getITunesController().removeTag(tagInformation, n2, n);
                this.trans(this.mTarget.mStateDeviceNotConnectedIdle);
                break;
            }
            case 40674: {
                int n = eventGeneric.getInt(0);
                ITunesHandler.getITunesController().removeAllTags(n);
                this.trans(this.mTarget.mStateDeviceNotConnectedIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


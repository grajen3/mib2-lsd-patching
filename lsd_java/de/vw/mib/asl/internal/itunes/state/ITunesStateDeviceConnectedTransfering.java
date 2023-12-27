/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.state;

import de.vw.mib.asl.internal.itunes.ITunesHandler;
import de.vw.mib.asl.internal.itunes.common.ITunesTagInformation;
import de.vw.mib.asl.internal.itunes.state.ITunesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.media.TagInformation;

public class ITunesStateDeviceConnectedTransfering
extends AbstractHsmState {
    ITunesStateDeviceConnectedTransfering(ITunesTarget iTunesTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                if (!ITunesHandler.getITunesController().checkForTagsAvailability()) break;
                ITunesHandler.getITunesController().sendExistingTagsToDevice();
                break;
            }
            case 4: {
                break;
            }
            case 40670: {
                int n = eventGeneric.getInt(0);
                TagInformation tagInformation = (TagInformation)eventGeneric.getObject(1);
                TagInformation tagInformation2 = (TagInformation)eventGeneric.getObject(2);
                ITunesHandler.getITunesController().handleTags(tagInformation, tagInformation2, n, true);
                break;
            }
            case 40675: {
                int n = eventGeneric.getInt(0);
                ITunesTagInformation iTunesTagInformation = (ITunesTagInformation)eventGeneric.getObject(1);
                ITunesHandler.getITunesController().removeTagWithTagInfo(iTunesTagInformation, n);
                break;
            }
            case 40674: {
                int n = eventGeneric.getInt(0);
                if (n != ITunesHandler.getITunesController().getCurrentInstance()) {
                    ITunesHandler.getITunesController().removeAllTags(n);
                    break;
                }
                hsmState = this.myParent;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiRadioTaggingTagResult(int n) {
        ITunesHandler.getITunesController().transferedTagResult(n);
    }
}


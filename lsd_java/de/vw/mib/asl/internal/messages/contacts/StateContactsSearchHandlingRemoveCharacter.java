/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts;

import de.vw.mib.asl.internal.messages.contacts.HsmMessagingContactsSearchHandling;
import de.vw.mib.asl.internal.messages.contacts.MessagingSearchFetcher;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.organizer.DataSet;

public class StateContactsSearchHandlingRemoveCharacter
extends AbstractHsmState {
    private HsmMessagingContactsSearchHandling target;

    public StateContactsSearchHandlingRemoveCharacter(HsmMessagingContactsSearchHandling hsmMessagingContactsSearchHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmMessagingContactsSearchHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.operationPending = true;
                this.target.dsiAdbList.removeSpellerChar(MessagingSearchFetcher.spellerHandle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 0) {
            this.target.dsiAdbList.addSpellerChars(MessagingSearchFetcher.spellerHandle, this.target.replaceChar);
            this.target.selectionStart = 0;
            this.target.selectionEnd = 0;
            this.trans(this.target.stateContactsSearchHandling);
        }
    }
}


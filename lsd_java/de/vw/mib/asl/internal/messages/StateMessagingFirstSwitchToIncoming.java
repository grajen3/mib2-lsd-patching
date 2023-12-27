/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.messaging.ListEntry;

public class StateMessagingFirstSwitchToIncoming
extends AbstractHsmState {
    private HsmPhoneSMSHandling target;

    public StateMessagingFirstSwitchToIncoming(HsmPhoneSMSHandling hsmPhoneSMSHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneSMSHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            default: 
        }
        hsmState = this.myParent;
        return hsmState;
    }

    public void dsiMessagingListEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            if (listEntryArray[i2].getType() != 1) continue;
            this.target.smsAccountId = listEntryArray[i2].getMessageListEntry().messagingAccountID;
            break;
        }
        this.trans(this.target.stateMessageHandling);
    }
}


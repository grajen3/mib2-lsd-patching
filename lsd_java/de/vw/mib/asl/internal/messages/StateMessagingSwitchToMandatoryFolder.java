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

public class StateMessagingSwitchToMandatoryFolder
extends AbstractHsmState {
    private HsmPhoneSMSHandling target;

    public StateMessagingSwitchToMandatoryFolder(HsmPhoneSMSHandling hsmPhoneSMSHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
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
        if (n2 == 0) {
            int n6 = -1;
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                if (listEntryArray[i2].getType() != 1 || listEntryArray[i2].getFolderEntry().folderType != n6) continue;
                this.target.handleChangeFolder(listEntryArray[i2].getFolderEntry().getFolderID(), listEntryArray[i2], false);
                this.target.handleGetSortingFolder(listEntryArray[i2].getFolderEntry().getFolderType());
                break;
            }
        }
        this.target.setListToLoading(false);
        this.trans(this.target.stateMessageHandling);
    }
}


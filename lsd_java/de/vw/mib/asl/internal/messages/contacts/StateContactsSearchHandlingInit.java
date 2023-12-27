/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts;

import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.contacts.HsmMessagingContactsSearchHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateContactsSearchHandlingInit
extends AbstractHsmState {
    private HsmMessagingContactsSearchHandling target;

    public StateContactsSearchHandlingInit(HsmMessagingContactsSearchHandling hsmMessagingContactsSearchHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmMessagingContactsSearchHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                this.target.init();
                this.target.setNotification();
                this.trans(this.target.stateContactsSearchHandling);
                break;
            }
            case 1073744610: {
                this.target.restartSpeller = false;
                this.target.phoneContactsSize = ASLMessagingData.viewSizeContacts.phone;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


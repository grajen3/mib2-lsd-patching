/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsSearchHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateContactsSearchHandlingInit
extends AbstractHsmState {
    private final HsmPhoneContactsSearchHandling target;

    public StateContactsSearchHandlingInit(HsmPhoneContactsSearchHandling hsmPhoneContactsSearchHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneContactsSearchHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.init();
                this.trans(this.target.stateContactsSearchHandling);
                break;
            }
            case 1073742790: {
                this.target.restartSpeller = false;
                this.target.phoneContactsSize = ASLPhoneData.viewSizeContacts.phone;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


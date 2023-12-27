/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsEditHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmPhoneContactsEditHandling$1
extends AbstractHsmState {
    private final /* synthetic */ HsmPhoneContactsEditHandling this$0;

    HsmPhoneContactsEditHandling$1(HsmPhoneContactsEditHandling hsmPhoneContactsEditHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmPhoneContactsEditHandling;
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
                this.trans(this.this$0.stateContactsEditHandling);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


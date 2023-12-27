/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsEditHandling;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.AdbEntry;

class HsmPhoneContactsEditHandling$2
extends AbstractHsmState {
    private final /* synthetic */ HsmPhoneContactsEditHandling this$0;

    HsmPhoneContactsEditHandling$2(HsmPhoneContactsEditHandling hsmPhoneContactsEditHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmPhoneContactsEditHandling;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 100300: {
                if (eventGeneric.getResult() != 0) break;
                AdbEntry adbEntry = (AdbEntry)eventGeneric.getObject(1);
                ListManager.getGenericASLList(1189).updateList(PhoneUtil.ripADBPhoneData(adbEntry.phoneData));
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


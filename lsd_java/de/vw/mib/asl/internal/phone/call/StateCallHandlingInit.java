/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.phone.call.HsmPhoneCallHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;

public class StateCallHandlingInit
extends AbstractHsmState {
    private final HsmPhoneCallHandling target;

    public StateCallHandlingInit(HsmPhoneCallHandling hsmPhoneCallHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneCallHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                ListManager.getGenericASLList(1169).enableWindowing(new ASLListItemSoftCacheImpl(), this.target, 5, 0);
                ListManager.getGenericASLList(1169).setColumn4ObjectId(0);
                this.target.dsiAdbListTelephone.setListStyle(0, 1, 5);
                ServiceManager.aslPropertyManager.valueChangedInteger(1152, 0);
                break;
            }
            case 3500006: {
                this.target.dsiAdbListTelephone.setListStyle(0, 1, 5);
                break;
            }
            case 3: {
                this.trans(this.target.stateCallHandling);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}


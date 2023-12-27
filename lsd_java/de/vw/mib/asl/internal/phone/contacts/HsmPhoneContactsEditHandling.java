/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsEditHandling$1;
import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsEditHandling$2;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

public class HsmPhoneContactsEditHandling
extends AbstractASLHsmPhoneTarget {
    protected static final int EV_ASL_INT_RESP_GET_ENTRY_RESULT;
    public HsmState stateInit;
    public final HsmState stateContactsEditHandling;

    public HsmPhoneContactsEditHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new HsmPhoneContactsEditHandling$1(this, this.hsm, "PhoneContactsEditHandlingInit", this.getWorkStateParent());
        this.stateContactsEditHandling = new HsmPhoneContactsEditHandling$2(this, this.hsm, "PhoneContactsEditHandling", this.stateInit);
    }

    @Override
    public int getDefaultTargetId() {
        return 5271;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }
}


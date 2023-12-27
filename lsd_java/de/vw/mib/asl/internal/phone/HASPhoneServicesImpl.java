/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.phone.TargetASLPhoneHAS;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.contexts.phone.PhoneServicesAdapter;

public class HASPhoneServicesImpl
extends PhoneServicesAdapter {
    TargetASLPhoneHAS target;

    public HASPhoneServicesImpl(TargetASLPhoneHAS targetASLPhoneHAS) {
        this.target = targetASLPhoneHAS;
    }

    @Override
    public void callContact(int n, ContactContainer contactContainer) {
        this.target.callContact(n, contactContainer);
    }
}


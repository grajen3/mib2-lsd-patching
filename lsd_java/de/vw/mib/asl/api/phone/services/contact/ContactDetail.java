/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.contact;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.CommonContact;

public interface ContactDetail
extends CommonContact {
    default public PhoneNumber[] getPhoneNumbers() {
    }
}


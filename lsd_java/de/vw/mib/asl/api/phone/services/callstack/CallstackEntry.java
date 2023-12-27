/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.callstack;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.CommonContact;
import de.vw.mib.asl.api.phone.services.callstack.CallstackDateTime;

public interface CallstackEntry
extends CommonContact {
    public static final int CALLSTACKTYPE_ACCEPTED;
    public static final int CALLSTACKTYPE_DIALED;
    public static final int CALLSTACKTYPE_MISSED;

    default public int getCallstackId() {
    }

    @Override
    default public long getContactId() {
    }

    default public PhoneNumber getPhoneNumber() {
    }

    default public CallstackDateTime getDateTime() {
    }

    default public int getSpecialNumber() {
    }

    default public int getCallstackType() {
    }
}


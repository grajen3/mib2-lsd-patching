/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone;

import de.vw.mib.asl.api.phone.callback.ContactlistUpdates;
import de.vw.mib.asl.api.phone.callback.PhoneConnectedUpdate;
import de.vw.mib.asl.api.phone.callback.SpecialNumbersUpdate;
import de.vw.mib.asl.api.phone.services.calls.CallService;

public interface PhoneService
extends CallService {
    public static final int SPECIAL_NUMBER__NONE;
    public static final int SPECIAL_NUMBER__EMERGENGY;
    public static final int SPECIAL_NUMBER__MAILBOX;
    public static final int SPECIAL_NUMBER__INFO;
    public static final int SPECIAL_NUMBER__SERVICE;

    default public int numberSpeciality(String string) {
    }

    default public String getSpecialNumber(int n) {
    }

    default public void registerContactlistUpdates(ContactlistUpdates contactlistUpdates) {
    }

    default public void registerPhoneConnectedUpdates(PhoneConnectedUpdate phoneConnectedUpdate) {
    }

    default public void registerSpecialNumberUpdate(SpecialNumbersUpdate specialNumbersUpdate) {
    }
}


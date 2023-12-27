/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.calls;

import de.vw.mib.asl.api.phone.model.PhoneNumber;

public interface CallService {
    default public void dialNumber(String string) {
    }

    default public void dialNumber(PhoneNumber phoneNumber) {
    }
}


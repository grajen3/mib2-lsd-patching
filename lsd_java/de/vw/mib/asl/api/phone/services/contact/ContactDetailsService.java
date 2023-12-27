/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.contact;

import de.vw.mib.asl.api.phone.services.contact.ContactDetailsResponse;

public interface ContactDetailsService {
    default public void requestAdditionalData(ContactDetailsResponse contactDetailsResponse, long l) {
    }

    default public void requestAdditionalData(ContactDetailsResponse contactDetailsResponse, long[] lArray) {
    }
}


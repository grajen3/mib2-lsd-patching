/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.ContactAddress;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.AbstractSpeechNavigationControllerContactsAddressesTransformer;

public class SpeechNavigationControllerContactsAddressesTransformer
extends AbstractSpeechNavigationControllerContactsAddressesTransformer {
    @Override
    public int getInt(int n, Object object) {
        ContactAddress contactAddress = (ContactAddress)object;
        switch (n) {
            case 3: {
                return contactAddress.addressIndex;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        ContactAddress contactAddress = (ContactAddress)object;
        switch (n) {
            case 0: {
                return contactAddress.toShortString();
            }
            case 1: {
                return contactAddress.toLongString();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}


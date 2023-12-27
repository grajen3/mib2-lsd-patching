/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.AbstractSpeechNavigationControllerContactsContactsTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechNavigationControllerContactsContactsTransformer
extends AbstractSpeechNavigationControllerContactsContactsTransformer {
    @Override
    public int getInt(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 1: {
                return contact.groupSize;
            }
            case 6: {
                return contact.getAddressesStatus();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 0: {
                return contact.contactId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 3: {
                return contact.contactPicture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 2: {
                return contact.contactName;
            }
            case 4: {
                return contact.getFirstAddress().toShortString();
            }
            case 5: {
                return contact.getFirstAddress().toLongString();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}


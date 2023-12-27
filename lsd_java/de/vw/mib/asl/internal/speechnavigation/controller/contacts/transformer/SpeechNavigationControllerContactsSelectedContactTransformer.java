/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.AbstractSpeechNavigationControllerContactsSelectedContactTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechNavigationControllerContactsSelectedContactTransformer
extends AbstractSpeechNavigationControllerContactsSelectedContactTransformer {
    @Override
    public int getInt(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 3: {
                return contact.getAddressesStatus();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 4: {
                return contact.contactId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 2: {
                return contact.contactPicture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        Contact contact = (Contact)object;
        switch (n) {
            case 1: {
                return contact.contactName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}


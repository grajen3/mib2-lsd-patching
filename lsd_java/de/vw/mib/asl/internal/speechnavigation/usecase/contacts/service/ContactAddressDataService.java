/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.ContactAddress;
import de.vw.mib.collections.ObjectArrayList;

public class ContactAddressDataService
implements DataService {
    private Contact selectedContact = null;

    public void setContact(Contact contact) {
        this.selectedContact = contact;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        if (this.selectedContact != null) {
            ObjectArrayList objectArrayList = new ObjectArrayList(this.selectedContact.contactAddresses.length);
            for (int i2 = 0; i2 < this.selectedContact.contactAddresses.length; ++i2) {
                if (this.selectedContact.contactAddresses[i2] == null) continue;
                objectArrayList.add(this.selectedContact.contactAddresses[i2]);
            }
            asyncCallback.onResponse(objectArrayList.toArray());
        } else {
            asyncCallback.onResponse(new ContactAddress[0]);
        }
    }
}


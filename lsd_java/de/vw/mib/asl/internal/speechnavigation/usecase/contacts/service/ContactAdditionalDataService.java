/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.ContactsService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service.ContactAdditionalDataService$1;
import de.vw.mib.collections.longs.LongArrayList;

public class ContactAdditionalDataService
implements AdditionalDataService {
    private final ContactsService contactsService = NavigationMemoryServiceAdapter.getContactsService();

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        LongArrayList longArrayList = new LongArrayList(resultItemArray.length);
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) continue;
            longArrayList.add(resultItem.getIdentifier().getObjectId());
        }
        this.contactsService.getContacts(new ContactAdditionalDataService$1(this, resultItemArray, asyncCallback), longArrayList.toArray());
    }
}


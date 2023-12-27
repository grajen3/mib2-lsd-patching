/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service;

import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetContactsListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service.ContactAdditionalDataService;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.longs.LongObjectOptHashMap;

class ContactAdditionalDataService$1
implements GetContactsListener {
    private final /* synthetic */ ResultItem[] val$items;
    private final /* synthetic */ AsyncCallback val$caller;
    private final /* synthetic */ ContactAdditionalDataService this$0;

    ContactAdditionalDataService$1(ContactAdditionalDataService contactAdditionalDataService, ResultItem[] resultItemArray, AsyncCallback asyncCallback) {
        this.this$0 = contactAdditionalDataService;
        this.val$items = resultItemArray;
        this.val$caller = asyncCallback;
    }

    @Override
    public void getContactsResponse(int n, INavigationContact[] iNavigationContactArray) {
        LongObjectOptHashMap longObjectOptHashMap = new LongObjectOptHashMap();
        for (int i2 = 0; i2 < iNavigationContactArray.length; ++i2) {
            if ("null".equalsIgnoreCase(iNavigationContactArray[i2].toString())) continue;
            longObjectOptHashMap.put(iNavigationContactArray[i2].getId(), iNavigationContactArray[i2]);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(this.val$items.length);
        for (int i3 = 0; i3 < this.val$items.length; ++i3) {
            ResultItem resultItem = this.val$items[i3];
            if (resultItem.isGroup()) {
                objectArrayList.add(new Contact(resultItem));
                continue;
            }
            INavigationContact iNavigationContact = (INavigationContact)longObjectOptHashMap.get(resultItem.getIdentifier().getObjectId());
            if (iNavigationContact == null) continue;
            objectArrayList.add(new Contact(iNavigationContact));
        }
        if (objectArrayList.size() == 0) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", the returned contacts list is empty, the contacts could not be resolved by ids (viewType invalid?)").toString());
        }
        this.val$caller.onResponse(objectArrayList.toArray());
    }
}


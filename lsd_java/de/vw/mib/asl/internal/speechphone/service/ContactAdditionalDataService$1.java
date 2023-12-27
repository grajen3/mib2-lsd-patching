/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.service;

import de.vw.mib.asl.api.phone.services.contact.ContactDetail;
import de.vw.mib.asl.api.phone.services.contact.ContactDetailsResponse;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.service.ContactAdditionalDataService;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.longs.LongObjectOptHashMap;

class ContactAdditionalDataService$1
implements ContactDetailsResponse {
    private final /* synthetic */ ResultItem[] val$items;
    private final /* synthetic */ AsyncCallback val$caller;
    private final /* synthetic */ ContactAdditionalDataService this$0;

    ContactAdditionalDataService$1(ContactAdditionalDataService contactAdditionalDataService, ResultItem[] resultItemArray, AsyncCallback asyncCallback) {
        this.this$0 = contactAdditionalDataService;
        this.val$items = resultItemArray;
        this.val$caller = asyncCallback;
    }

    @Override
    public void response(ContactDetail[] contactDetailArray) {
        if (contactDetailArray == null) {
            this.this$0.logger.error("Phone API sended error on contact recognition");
            this.this$0.serviceFunctions.sendHMIEvent(-1901511936);
        } else {
            LongObjectOptHashMap longObjectOptHashMap = new LongObjectOptHashMap();
            for (int i2 = 0; i2 < contactDetailArray.length; ++i2) {
                longObjectOptHashMap.put(contactDetailArray[i2].getContactId(), contactDetailArray[i2]);
            }
            ObjectArrayList objectArrayList = new ObjectArrayList(this.val$items.length);
            for (int i3 = 0; i3 < this.val$items.length; ++i3) {
                ResultItem resultItem = this.val$items[i3];
                if (resultItem.isGroup()) {
                    objectArrayList.add(new ContactNameModel(this.this$0.serviceFunctions, resultItem));
                    continue;
                }
                ContactDetail contactDetail = (ContactDetail)longObjectOptHashMap.get(resultItem.getIdentifier().getObjectId());
                if (contactDetail == null) continue;
                objectArrayList.add(new ContactNameModel(this.this$0.serviceFunctions, contactDetail));
            }
            this.val$caller.onResponse(objectArrayList.toArray());
        }
    }
}


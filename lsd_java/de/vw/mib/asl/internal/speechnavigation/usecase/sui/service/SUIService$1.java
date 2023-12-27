/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.service;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.model.SUIModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUIService;
import de.vw.mib.collections.longs.LongIntMap;

class SUIService$1
implements AsyncCallback {
    private final /* synthetic */ LongIntMap val$contactObjectIdToIndex;
    private final /* synthetic */ AsyncCallback val$caller;
    private final /* synthetic */ SUIService this$0;

    SUIService$1(SUIService sUIService, LongIntMap longIntMap, AsyncCallback asyncCallback) {
        this.this$0 = sUIService;
        this.val$contactObjectIdToIndex = longIntMap;
        this.val$caller = asyncCallback;
    }

    @Override
    public void onResponse(Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Contact contact = (Contact)objectArray[i2];
            int n = this.val$contactObjectIdToIndex.get(contact.contactId);
            this.this$0.suiItems.set(n, new SUIModel(n, contact));
        }
        this.val$caller.onResponse(this.this$0.suiItems.toArray());
    }
}


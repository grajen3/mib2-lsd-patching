/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.service;

import de.vw.mib.asl.api.phone.services.contact.ContactDetailsResponse;
import de.vw.mib.asl.api.phone.services.contact.ContactDetailsService;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechphone.service.ContactAdditionalDataService$1;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.collections.longs.LongArrayList;

public class ContactAdditionalDataService
implements AdditionalDataService {
    final SpeechPhoneLogger2 logger;
    private final ContactDetailsService contactDetailsService;
    final ServiceFunctions serviceFunctions;

    public ContactAdditionalDataService(ServiceFunctions serviceFunctions, ContactDetailsService contactDetailsService) {
        this.contactDetailsService = contactDetailsService;
        this.serviceFunctions = serviceFunctions;
        this.logger = serviceFunctions.createLogger("ContactAdditionalDataService");
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        LongArrayList longArrayList = new LongArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) continue;
            longArrayList.add(resultItem.getIdentifier().getObjectId());
        }
        this.contactDetailsService.requestAdditionalData((ContactDetailsResponse)new ContactAdditionalDataService$1(this, resultItemArray, asyncCallback), longArrayList.toArray());
    }
}


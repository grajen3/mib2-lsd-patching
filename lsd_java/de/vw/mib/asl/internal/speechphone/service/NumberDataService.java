/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.service;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class NumberDataService
implements DataService {
    private final SpeechPhoneLogger2 logger;
    private int locTypeFirst;
    private final ServiceFunctions serviceFunctions;

    public NumberDataService(ServiceFunctions serviceFunctions) {
        this.serviceFunctions = serviceFunctions;
        this.logger = serviceFunctions.createLogger("NumberDataService");
    }

    public void setLocTypeFirst(int n) {
        this.locTypeFirst = n;
        if (this.logger.isTraceEnabled()) {
            if (n > 0) {
                this.logger.trace(new StringBuffer().append("Set ").append(LocTypeIndexHandler.LOCTYPESTRING[n]).append(" to sort to top").toString());
            } else {
                this.logger.trace("No special sort order");
            }
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        ContactNameModel contactNameModel = this.serviceFunctions.getSelectedContact();
        if (contactNameModel != null) {
            Object[] objectArray = contactNameModel.getSortedNumberList(this.locTypeFirst).toArray();
            asyncCallback.onResponse(objectArray);
        }
    }
}


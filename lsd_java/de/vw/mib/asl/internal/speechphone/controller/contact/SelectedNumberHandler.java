/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.internal.speechphone.communication.phone.ContactNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class SelectedNumberHandler {
    private final SpeechPhoneLogger2 logger;
    private PhoneNumber numberToCall;
    private ContactNumberHandler contactNumberHandler;

    public SelectedNumberHandler(ServiceFunctions serviceFunctions, ContactNumberHandler contactNumberHandler) {
        this.logger = serviceFunctions.createLogger("SelectedNumberHandler");
        this.contactNumberHandler = contactNumberHandler;
    }

    public void reset() {
        this.numberToCall = null;
        this.contactNumberHandler.getterUpdateMailboxOrEmergency(this.numberToCall);
    }

    public void selectFirstNumber(ContactNameModel contactNameModel) {
        this.numberToCall = contactNameModel.getPhoneNumber(0);
        this.contactNumberHandler.getterUpdateMailboxOrEmergency(this.numberToCall);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("number to call is set to the contact's first found number");
        }
    }

    public void selectNumber(ContactNameModel contactNameModel, int n) {
        this.numberToCall = contactNameModel.getPhoneNumber(n);
        this.contactNumberHandler.getterUpdateMailboxOrEmergency(this.numberToCall);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("number to call is set to the contact's number with index ").append(n).toString());
        }
    }

    public void selectNumberByLocType_First(ContactNameModel contactNameModel, LocTypeIndexHandler locTypeIndexHandler) {
        this.numberToCall = contactNameModel.getFirstFoundPhoneNumber(locTypeIndexHandler);
        this.contactNumberHandler.getterUpdateMailboxOrEmergency(this.numberToCall);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("number to call is set to the contact's (first)").append(LocTypeIndexHandler.LOCTYPESTRING[locTypeIndexHandler.getLoctype()]).append(" number").toString());
        }
    }

    public void selectNumberByLocType_Index(ContactNameModel contactNameModel, LocTypeIndexHandler locTypeIndexHandler) {
        this.numberToCall = contactNameModel.getPhoneNumber(locTypeIndexHandler);
        this.contactNumberHandler.getterUpdateMailboxOrEmergency(this.numberToCall);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("number to call is set to the contact's ").append(LocTypeIndexHandler.LOCTYPESTRING[locTypeIndexHandler.getLoctype()]).append(" number with index ").append(locTypeIndexHandler.getIndex()).toString());
        }
    }

    public PhoneNumber getNumberToCall() {
        return this.numberToCall;
    }

    public void setNumberToCall(PhoneNumber phoneNumber) {
        this.numberToCall = phoneNumber;
        this.contactNumberHandler.getterUpdateMailboxOrEmergency(phoneNumber);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("number to call is set to the phonenumber: ").append(phoneNumber.getNumber()).toString());
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialMailboxAction
extends AbstractCheckedPhoneAction {
    public DialMailboxAction(ServiceFunctions serviceFunctions, PhoneNumberHandler phoneNumberHandler) {
        super(serviceFunctions, 6, phoneNumberHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        ((PhoneNumberHandler)this.phoneHandler).setMailboxToCall();
        if (((PhoneNumberHandler)this.phoneHandler).isNumberDefined()) {
            this.serviceFunctions.sendHMIEvent(-2052506880);
        } else {
            this.serviceFunctions.sendHMIEvent(-1884734720);
            this.serviceFunctions.sendHMIEvent(-643220736);
        }
    }
}


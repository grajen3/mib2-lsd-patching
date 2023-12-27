/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialServiceAction
extends AbstractCheckedPhoneAction {
    public DialServiceAction(ServiceFunctions serviceFunctions, PhoneNumberHandler phoneNumberHandler) {
        super(serviceFunctions, 13, phoneNumberHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        ((PhoneNumberHandler)this.phoneHandler).setServiceToCall();
        this.serviceFunctions.sendHMIEvent(-2002175232);
    }
}


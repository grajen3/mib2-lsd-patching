/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialInformationAction
extends AbstractCheckedPhoneAction {
    public DialInformationAction(ServiceFunctions serviceFunctions, PhoneNumberHandler phoneNumberHandler) {
        super(serviceFunctions, 14, phoneNumberHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        ((PhoneNumberHandler)this.phoneHandler).setInformationToCall();
        this.serviceFunctions.sendHMIEvent(-1985398016);
    }
}


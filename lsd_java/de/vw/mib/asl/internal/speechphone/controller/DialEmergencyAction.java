/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialEmergencyAction
extends AbstractCheckedPhoneAction {
    public DialEmergencyAction(ServiceFunctions serviceFunctions, PhoneNumberHandler phoneNumberHandler) {
        super(serviceFunctions, 12, phoneNumberHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        ((PhoneNumberHandler)this.phoneHandler).setEmergencyToCall();
        this.serviceFunctions.sendHMIEvent(-2018952448);
        this.serviceFunctions.sendHMIEvent(-1851180288);
    }
}


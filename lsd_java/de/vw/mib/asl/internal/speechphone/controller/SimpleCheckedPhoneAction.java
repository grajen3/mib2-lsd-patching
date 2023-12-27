/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class SimpleCheckedPhoneAction
extends AbstractCheckedPhoneAction {
    private final int eventId;

    public SimpleCheckedPhoneAction(ServiceFunctions serviceFunctions, int n, int n2, PhoneHandler phoneHandler) {
        super(serviceFunctions, n2, phoneHandler);
        this.eventId = n;
    }

    @Override
    protected void reactOnRequest(int n) {
        this.serviceFunctions.sendHMIEvent(this.eventId);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractDialNumberLengthAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialNumberGlobalAction
extends AbstractDialNumberLengthAction {
    public DialNumberGlobalAction(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler) {
        super(serviceFunctions, phoneHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        this.handleResettingNumber();
        this.serviceFunctions.sendHMIEvent(-2136392960);
    }
}


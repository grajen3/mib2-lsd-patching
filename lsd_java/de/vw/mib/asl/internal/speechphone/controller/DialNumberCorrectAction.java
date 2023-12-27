/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneDialNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractDialNumberLengthAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialNumberCorrectAction
extends AbstractDialNumberLengthAction {
    public DialNumberCorrectAction(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler) {
        super(serviceFunctions, phoneHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        ((PhoneDialNumberHandler)this.phoneHandler).deleteLastNumberPart();
        if (this.handleNumberMaxLength(((PhoneDialNumberHandler)this.phoneHandler).getLastNumberPart())) {
            if (this.handleNumberMinLength()) {
                this.serviceFunctions.sendHMIEvent(-1700185344);
            } else {
                this.serviceFunctions.sendHMIEvent(-1716962560);
            }
        }
    }
}


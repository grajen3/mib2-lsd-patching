/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneDialNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractDialNumberResultItemController;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialNumberXGlobalController
extends AbstractDialNumberResultItemController {
    public DialNumberXGlobalController(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler, ResultItemHandler resultItemHandler) {
        super(serviceFunctions, phoneHandler, resultItemHandler);
    }

    @Override
    protected void onRecognizedNumber(String string) {
        ((PhoneDialNumberHandler)this.phoneHandler).deleteNumberPartList();
        ((PhoneDialNumberHandler)this.phoneHandler).addNumberPart(string);
        if (this.handleNumberMaxLength(string)) {
            this.handleNumberMinLength();
            this.serviceFunctions.sendHMIEvent(-1666630912);
        }
    }
}


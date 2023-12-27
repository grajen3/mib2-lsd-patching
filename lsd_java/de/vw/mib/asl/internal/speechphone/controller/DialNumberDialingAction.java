/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneDialNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialNumberDialingAction
extends AbstractCheckedPhoneAction {
    public DialNumberDialingAction(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler) {
        super(serviceFunctions, 3, phoneHandler);
    }

    @Override
    protected void reactOnRequest(int n) {
        switch (((PhoneDialNumberHandler)this.phoneHandler).checkNumberToCall()) {
            case 1: {
                this.serviceFunctions.sendHMIEvent(-2018952448);
                this.serviceFunctions.sendHMIEvent(-1851180288);
                break;
            }
            case 3: {
                this.serviceFunctions.sendHMIEvent(-1985398016);
                break;
            }
            case 4: {
                this.serviceFunctions.sendHMIEvent(-2002175232);
                break;
            }
            case 2: {
                this.serviceFunctions.sendHMIEvent(-2052506880);
                break;
            }
            default: {
                this.serviceFunctions.sendHMIEvent(-1733739776);
            }
        }
    }
}


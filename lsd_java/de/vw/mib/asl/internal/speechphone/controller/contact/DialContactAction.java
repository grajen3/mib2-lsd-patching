/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public class DialContactAction
extends AbstractCheckedPhoneAction {
    private final DialogBackstack dialogBackstack;
    private final int systemEvent;

    public DialContactAction(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler, DialogBackstack dialogBackstack, int n) {
        super(serviceFunctions, 5, phoneHandler);
        this.dialogBackstack = dialogBackstack;
        this.systemEvent = n;
    }

    @Override
    protected void reactOnRequest(int n) {
        if (this.phoneHandler.areContactsAvailable()) {
            this.dialogBackstack.clear();
            this.serviceFunctions.sendHMIEvent(this.systemEvent);
        }
    }
}


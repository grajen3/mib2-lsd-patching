/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialFunction;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCombinedAction;

public class TriggerDialingAction
extends AbstractCombinedAction
implements DialFunction {
    protected final PhoneNumberHandler phoneNumberHandler;
    private DialHandler dialHandler;

    public TriggerDialingAction(PhoneNumberHandler phoneNumberHandler, DialogStateRouter dialogStateRouter) {
        this.phoneNumberHandler = phoneNumberHandler;
        this.dialHandler = new DialHandler(this, dialogStateRouter, phoneNumberHandler);
    }

    @Override
    protected void onAction(int n) {
        if (this.phoneNumberHandler.isPhoneAvailable()) {
            this.dialHandler.handleDialing();
        }
    }

    @Override
    public void dial() {
        this.phoneNumberHandler.dialNumber();
    }
}


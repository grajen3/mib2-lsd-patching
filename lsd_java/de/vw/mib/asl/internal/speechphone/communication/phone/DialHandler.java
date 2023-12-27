/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.phone;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialFunction;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;

public class DialHandler
implements DialogStateConsumer {
    private DialFunction dialFunction;
    private boolean isNumberTriggered;
    private boolean wasDialogStateShutdownInactive;
    private PhoneNumberHandler phoneNumberHandler;

    public DialHandler(DialFunction dialFunction, DialogStateRouter dialogStateRouter, PhoneNumberHandler phoneNumberHandler) {
        this.dialFunction = dialFunction;
        this.phoneNumberHandler = phoneNumberHandler;
        this.isNumberTriggered = false;
        this.wasDialogStateShutdownInactive = false;
        dialogStateRouter.register(this);
    }

    public void handleDialing() {
        if (!this.isNumberTriggered) {
            this.isNumberTriggered = true;
            this.phoneNumberHandler.changeToPhoneDialContext();
        }
        this.handleDialWhenSpeechInactive();
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 2) {
            this.wasDialogStateShutdownInactive = false;
            return;
        }
        if (n == 9) {
            this.wasDialogStateShutdownInactive = true;
        }
        this.handleDialWhenSpeechInactive();
    }

    private void handleDialWhenSpeechInactive() {
        if (this.wasDialogStateShutdownInactive && this.isNumberTriggered) {
            this.isNumberTriggered = false;
            this.wasDialogStateShutdownInactive = false;
            this.dialFunction.dial();
        }
    }
}


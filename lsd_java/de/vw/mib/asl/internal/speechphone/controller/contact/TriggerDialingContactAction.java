/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.internal.speechphone.communication.phone.ContactNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialFunction;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCombinedAction;
import de.vw.mib.asl.internal.speechphone.controller.contact.SelectedNumberHandler;

public class TriggerDialingContactAction
extends AbstractCombinedAction
implements DialFunction {
    protected final ContactNumberHandler contactNumberHandler;
    protected final SelectedNumberHandler selectedNumberHandler;
    private DialHandler dialHandler;

    public TriggerDialingContactAction(ContactNumberHandler contactNumberHandler, DialogStateRouter dialogStateRouter, SelectedNumberHandler selectedNumberHandler) {
        this.contactNumberHandler = contactNumberHandler;
        this.selectedNumberHandler = selectedNumberHandler;
        this.dialHandler = new DialHandler(this, dialogStateRouter, contactNumberHandler);
    }

    @Override
    protected void onAction(int n) {
        if (this.contactNumberHandler.isPhoneAvailable() && !this.contactNumberHandler.isMailboxOrEmergencyAndTriggerSystemEvents(this.selectedNumberHandler.getNumberToCall())) {
            this.dialHandler.handleDialing();
        }
    }

    @Override
    public void dial() {
        this.contactNumberHandler.dialNumber(this.selectedNumberHandler.getNumberToCall());
    }
}


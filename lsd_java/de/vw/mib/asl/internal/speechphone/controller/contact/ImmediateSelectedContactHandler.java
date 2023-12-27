/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.internal.speechphone.controller.contact.AbstractSelectedContactHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.SelectedNumberHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;

public class ImmediateSelectedContactHandler
extends AbstractSelectedContactHandler {
    private final SpeechPhoneLogger2 logger;
    private int systemEventToPropagate;

    public ImmediateSelectedContactHandler(ServiceFunctions serviceFunctions, LocTypeIndexHandler locTypeIndexHandler, SelectedNumberHandler selectedNumberHandler) {
        super(serviceFunctions, locTypeIndexHandler, selectedNumberHandler);
        this.logger = serviceFunctions.createLogger("ImmediateSelectedContactHandler");
    }

    @Override
    protected void notifyModel(ContactNameModel contactNameModel, int n) {
        this.serviceFunctions.sendHMIEvent(n);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("System event, which prompt to play is fired immediately.");
        }
    }

    public void fireStoredSystemEvent() {
        this.serviceFunctions.sendHMIEvent(this.systemEventToPropagate);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("The stored system event ").append(this.systemEventToPropagate).append(" is fired.").toString());
        }
    }

    public void fetchSystemEvent(EventGeneric eventGeneric) {
        this.systemEventToPropagate = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("The propagated system event ").append(this.systemEventToPropagate).append(" is stored.").toString());
        }
    }

    @Override
    protected void triggerPromptDialLocType() {
        this.serviceFunctions.sendHMIEvent(-1314309376);
    }

    @Override
    protected void triggerPromptDialLocTypeIndex() {
        this.serviceFunctions.sendHMIEvent(-1331086592);
    }
}


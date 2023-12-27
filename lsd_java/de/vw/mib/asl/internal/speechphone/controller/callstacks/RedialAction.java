/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.callstacks;

import de.vw.mib.asl.internal.speechphone.communication.phone.CallstackNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.data.internal.CallstackEntryModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class RedialAction
extends AbstractCheckedPhoneAction {
    private SpeechPhoneLogger2 logger;
    private CallstackNumberHandler callstackNumberHandler;

    public RedialAction(ServiceFunctions serviceFunctions, CallstackNumberHandler callstackNumberHandler) {
        super(serviceFunctions, 4, callstackNumberHandler);
        this.callstackNumberHandler = callstackNumberHandler;
        this.logger = serviceFunctions.createLogger("RedialAction");
    }

    @Override
    protected void reactOnRequest(int n) {
        CallstackEntryModel callstackEntryModel = this.callstackNumberHandler.getLastDialedNumber();
        this.callstackNumberHandler.setLastSelectedItem(callstackEntryModel);
        if (n == 1820474176) {
            if (callstackEntryModel == null) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("there is no last dialed number");
                }
                this.serviceFunctions.sendHMIEvent(-1062651136);
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("initialize redialling and play parrot prompt");
                }
                this.serviceFunctions.sendHMIEvent(-2119615744);
            }
        } else if (n == -1685963968) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("do the redial precheck to check if it is a special number and maybe trigger special number call");
            }
            if (!this.callstackNumberHandler.isSpecialNumber()) {
                if (callstackEntryModel.isContactInformationAvailable()) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("the last dialed number was a normal number from a contact");
                    }
                    this.callstackNumberHandler.fillSelectedCallstackEntryIntoModel(callstackEntryModel);
                    this.serviceFunctions.sendHMIEvent(-1029096704);
                } else {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("the last dialed number was a normal number without a contact");
                    }
                    this.serviceFunctions.sendHMIEvent(-1045873920);
                }
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("the last dialed number was a special number");
                }
                this.callstackNumberHandler.triggerDialing();
            }
        } else if (n == -1669186752) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("dial the last dialed number (no special number)");
            }
            this.callstackNumberHandler.triggerDialing();
        } else {
            this.logger.error("received unsupported request");
        }
    }
}


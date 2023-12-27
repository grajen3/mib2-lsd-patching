/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedResultItemController;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class DialNumberRowNumberController
extends AbstractCheckedResultItemController {
    private final SpeechPhoneLogger2 logger;

    public DialNumberRowNumberController(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler, ResultItemHandler resultItemHandler) {
        super(serviceFunctions, 3, phoneHandler, resultItemHandler);
        this.logger = serviceFunctions.createLogger("DialNumberRowNumberController");
    }

    @Override
    public void notifyResultCompleted(ResultItem resultItem) {
        block3: {
            try {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Row number recognized: ").append(resultItem.getTag()).toString());
                }
                this.serviceFunctions.writeIntegerToDatapool(2074688256, Integer.parseInt(resultItem.getTag()));
                this.serviceFunctions.sendHMIEvent(-1834403072);
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block3;
                this.logger.warn(new StringBuffer().append("This wasn't a row number: ").append(resultItem.toString()).toString());
            }
        }
    }
}


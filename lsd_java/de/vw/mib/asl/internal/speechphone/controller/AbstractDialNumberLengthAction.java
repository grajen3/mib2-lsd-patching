/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneDialNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public abstract class AbstractDialNumberLengthAction
extends AbstractCheckedPhoneAction {
    private final SpeechPhoneLogger2 logger;
    private final int MAXIMUM_NUMBER_LENGTH;

    public AbstractDialNumberLengthAction(ServiceFunctions serviceFunctions, PhoneHandler phoneHandler) {
        super(serviceFunctions, 3, phoneHandler);
        this.logger = serviceFunctions.createLogger("AbstractDialNumberLengthAction");
        this.MAXIMUM_NUMBER_LENGTH = serviceFunctions.getPhoneMaxPhoneNumberCharacters();
    }

    protected boolean handleNumberMaxLength(String string) {
        this.serviceFunctions.writeStringToDatapool(2125019904, string);
        String string2 = ((PhoneDialNumberHandler)this.phoneHandler).convertNumberPartList();
        if (string2.length() > this.MAXIMUM_NUMBER_LENGTH) {
            ((PhoneDialNumberHandler)this.phoneHandler).deleteLastNumberPart();
            string2 = ((PhoneDialNumberHandler)this.phoneHandler).convertNumberPartList();
            this.serviceFunctions.writeStringToDatapool(2091465472, string2);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("phone number too long, last number block deleted");
            }
            if (this.handleNumberMinLength()) {
                this.serviceFunctions.sendHMIEvent(-1767294208);
            } else {
                this.serviceFunctions.sendHMIEvent(-1649853696);
            }
            return false;
        }
        this.serviceFunctions.writeStringToDatapool(2091465472, string2);
        if (string2.length() == this.MAXIMUM_NUMBER_LENGTH) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("phone number has maximum length");
            }
            this.handleNumberMinLength();
            this.serviceFunctions.sendHMIEvent(-1784071424);
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("phone number length is below maximum");
        }
        return true;
    }

    protected boolean handleNumberMinLength() {
        boolean bl = ((PhoneDialNumberHandler)this.phoneHandler).isNumberDefined();
        this.serviceFunctions.writeBooleanToDatapool(-2136392960, bl);
        if (this.logger.isTraceEnabled()) {
            if (bl) {
                this.logger.trace("phone number length is more than zero");
            } else {
                this.logger.trace("phone number has zero length");
            }
        }
        return bl;
    }

    protected void handleResettingNumber() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Resetting phone number");
        }
        ((PhoneDialNumberHandler)this.phoneHandler).deleteNumberPartList();
        this.serviceFunctions.writeStringToDatapool(2125019904, "");
        this.serviceFunctions.writeStringToDatapool(2091465472, "");
        this.serviceFunctions.writeBooleanToDatapool(-2136392960, false);
    }
}


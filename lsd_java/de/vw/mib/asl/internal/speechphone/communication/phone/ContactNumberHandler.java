/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.phone;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneDialNumberHandler;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class ContactNumberHandler
extends PhoneDialNumberHandler {
    private final SpeechPhoneLogger2 logger;

    public ContactNumberHandler(ServiceFunctions serviceFunctions, SlotStateRouter slotStateRouter, PhoneService phoneService, AudioAccessor audioAccessor) {
        super(serviceFunctions, slotStateRouter, phoneService, audioAccessor);
        this.logger = serviceFunctions.createLogger("ContactNumberHandler");
    }

    public boolean isSpecialNumberAndTriggerSystemEvents(PhoneNumber phoneNumber) {
        this.numberToCall = phoneNumber == null ? "" : phoneNumber.getNumber();
        switch (this.checkNumberToCall()) {
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
                return false;
            }
        }
        return true;
    }

    public boolean isMailboxOrEmergencyAndTriggerSystemEvents(PhoneNumber phoneNumber) {
        this.numberToCall = phoneNumber == null ? "" : phoneNumber.getNumber();
        switch (this.checkNumberToCall()) {
            case 1: {
                this.serviceFunctions.sendHMIEvent(-2018952448);
                this.serviceFunctions.sendHMIEvent(-1851180288);
                break;
            }
            case 2: {
                this.serviceFunctions.sendHMIEvent(-2052506880);
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    public void getterUpdateMailboxOrEmergency(PhoneNumber phoneNumber) {
        if (phoneNumber == null) {
            this.numberToCall = "";
            this.serviceFunctions.writeBooleanToDatapool(-1414972672, false);
        } else {
            this.numberToCall = phoneNumber.getNumber();
            switch (this.checkNumberToCall()) {
                case 1: {
                    this.serviceFunctions.writeBooleanToDatapool(-1414972672, true);
                    break;
                }
                case 2: {
                    this.serviceFunctions.writeBooleanToDatapool(-1414972672, true);
                    break;
                }
                default: {
                    this.serviceFunctions.writeBooleanToDatapool(-1414972672, false);
                }
            }
        }
    }

    public void dialNumber(PhoneNumber phoneNumber) {
        if (!this.isEmergencyCall) {
            if (this.isNumberDefined()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Dialing number: ").append(this.numberToCall).toString());
                }
                this.phoneService.dialNumber(phoneNumber);
            } else if (this.logger.isTraceEnabled()) {
                this.logger.warn("Number to dial is not set or empty !!!");
            }
        }
    }
}


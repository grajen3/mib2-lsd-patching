/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.phone;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.callback.SpecialNumbersUpdate;
import de.vw.mib.asl.api.phone.model.SpecialNumbers;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class PhoneNumberHandler
extends PhoneHandler
implements SpecialNumbersUpdate {
    private final SpeechPhoneLogger2 logger;
    protected String numberToCall;
    protected boolean isEmergencyCall;
    private String informationNumber;
    private String serviceNumber;
    private String emergencyNumber;
    private String mailboxNumber;
    protected final AudioAccessor audioAccessor;
    private static final int AUDIO_ACCESSOR_TIMEOUT;

    public PhoneNumberHandler(ServiceFunctions serviceFunctions, SlotStateRouter slotStateRouter, PhoneService phoneService, AudioAccessor audioAccessor) {
        super(serviceFunctions, slotStateRouter, phoneService);
        this.audioAccessor = audioAccessor;
        this.logger = serviceFunctions.createLogger("PhoneNumberHandler");
        this.numberToCall = "";
        this.isEmergencyCall = false;
        phoneService.registerSpecialNumberUpdate(this);
    }

    protected int checkForSpecialNumber() {
        if (this.isNumberDefined()) {
            if (this.serviceFunctions.isFeatEmergency() && this.isNumberDefined(this.emergencyNumber) && this.numberToCall.compareTo(this.emergencyNumber.trim()) == 0) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Emergency number recognized");
                }
                return 1;
            }
            if (this.serviceFunctions.isFeatService() && this.isNumberDefined(this.serviceNumber) && this.numberToCall.compareTo(this.serviceNumber.trim()) == 0) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Service number recognized");
                }
                return 4;
            }
            if (this.serviceFunctions.isFeatInfo() && this.isNumberDefined(this.informationNumber) && this.numberToCall.compareTo(this.informationNumber.trim()) == 0) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Info number recognized");
                }
                return 3;
            }
            if (this.serviceFunctions.isFeatMailbox() && this.isNumberDefined(this.mailboxNumber) && this.numberToCall.compareTo(this.mailboxNumber.trim()) == 0) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Mailbox number recognized");
                }
                return 2;
            }
        }
        return 0;
    }

    public void setNumberToCall(String string) {
        this.isEmergencyCall = false;
        this.numberToCall = string;
        if (this.logger.isTraceEnabled()) {
            if (this.isNumberDefined()) {
                this.logger.trace(new StringBuffer().append("Number to call set to: ").append(this.numberToCall).toString());
            } else {
                this.logger.warn("Number to call is not available or empty !!!");
            }
        }
    }

    public void setEmergencyToCall() {
        this.isEmergencyCall = true;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Emergency number has to be called");
        }
    }

    public void setMailboxToCall() {
        this.setNumberToCall(this.mailboxNumber);
    }

    public void setInformationToCall() {
        this.setNumberToCall(this.informationNumber);
    }

    public void setServiceToCall() {
        this.setNumberToCall(this.serviceNumber);
    }

    public boolean isNumberDefined() {
        return this.numberToCall != null && this.numberToCall.length() > 0;
    }

    public boolean isNumberDefined(String string) {
        return string != null && string.length() > 0;
    }

    public void dialNumber() {
        if (!this.isEmergencyCall) {
            if (this.isNumberDefined()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Dialing number: ").append(this.numberToCall).toString());
                }
                this.phoneService.dialNumber(this.numberToCall);
            } else if (this.logger.isTraceEnabled()) {
                this.logger.warn("Number to dial is not set or empty !!!");
            }
        }
    }

    public void changeToPhoneDialContext() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Keep the audio connection for the next 10000 milli-seconds");
        }
        if (this.isEmergencyCall) {
            this.serviceFunctions.sendHMIEvent(-1851180288);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Triggering context change to phone dial emergency");
            }
        } else {
            this.audioAccessor.hangOn(1683233024, 10000);
            this.serviceFunctions.sendHMIEvent(-1867957504);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Triggering context change to phone dial");
            }
        }
    }

    @Override
    public void onUpdate(SpecialNumbers specialNumbers) {
        this.informationNumber = specialNumbers.getInfo();
        this.serviceFunctions.writeBooleanToDatapool(1974024960, this.isNumberDefined(this.informationNumber));
        this.serviceNumber = specialNumbers.getService();
        this.serviceFunctions.writeBooleanToDatapool(1957247744, this.isNumberDefined(this.serviceNumber));
        this.emergencyNumber = specialNumbers.getEmergency();
        this.serviceFunctions.writeBooleanToDatapool(1940470528, this.isNumberDefined(this.emergencyNumber));
        this.mailboxNumber = specialNumbers.getMailbox();
        if (this.logger.isTraceEnabled()) {
            if (this.isNumberDefined(this.informationNumber)) {
                this.logger.trace(new StringBuffer().append("Information number set to: ").append(this.informationNumber).toString());
            }
            if (this.isNumberDefined(this.serviceNumber)) {
                this.logger.trace(new StringBuffer().append("Service number set to: ").append(this.serviceNumber).toString());
            }
            if (this.isNumberDefined(this.emergencyNumber)) {
                this.logger.trace(new StringBuffer().append("Emergency number set to: ").append(this.emergencyNumber).toString());
            }
            if (this.isNumberDefined(this.mailboxNumber)) {
                this.logger.trace(new StringBuffer().append("Mailbox number set to: ").append(this.mailboxNumber).toString());
            }
        }
    }
}


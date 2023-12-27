/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.phone;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneNumberHandler;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.util.StringBuilder;

public class PhoneDialNumberHandler
extends PhoneNumberHandler {
    private final SpeechPhoneLogger2 logger;
    private ObjectArrayList numberParts;

    public PhoneDialNumberHandler(ServiceFunctions serviceFunctions, SlotStateRouter slotStateRouter, PhoneService phoneService, AudioAccessor audioAccessor) {
        super(serviceFunctions, slotStateRouter, phoneService, audioAccessor);
        this.logger = serviceFunctions.createLogger("PhoneDialNumberHandler");
        this.numberParts = new ObjectArrayList(serviceFunctions.getPhoneMaxPhoneNumberCharacters());
    }

    public void addNumberPart(String string) {
        this.numberParts.add(string);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Adding a number part. Now the list contains ").append(Integer.toString(this.numberParts.size())).append(" parts.").toString());
        }
    }

    public String getLastNumberPart() {
        if (this.numberParts.isEmpty()) {
            return "";
        }
        return (String)this.numberParts.last();
    }

    public void deleteLastNumberPart() {
        this.numberParts.removeLast();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Deleting the last number part. Now the list contains ").append(Integer.toString(this.numberParts.size())).append(" parts.").toString());
        }
    }

    public void deleteNumberPartList() {
        this.numberParts.clear();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Resetting the number parts. Now the list contains ").append(Integer.toString(this.numberParts.size())).append(" parts.").toString());
        }
    }

    public String convertNumberPartList() {
        if (this.numberParts.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < this.numberParts.size(); ++i2) {
                stringBuilder.append((String)this.numberParts.get(i2));
            }
            this.numberToCall = stringBuilder.toString();
        } else {
            this.numberToCall = "";
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("The phone number derived from the part list: ").append(this.numberToCall).toString());
        }
        return this.numberToCall;
    }

    public int checkNumberToCall() {
        int n = this.checkForSpecialNumber();
        boolean bl = this.isEmergencyCall = n == 1;
        if (this.logger.isTraceEnabled()) {
            if (this.isNumberDefined()) {
                if (n == 0) {
                    this.logger.trace(new StringBuffer().append("Number to call set to: ").append(this.numberToCall).toString());
                } else {
                    this.logger.trace(new StringBuffer().append("Special number to be called: ").append(this.numberToCall).toString());
                }
            } else {
                this.logger.warn("Number to call is not available or empty !!!");
            }
        }
        return n;
    }
}


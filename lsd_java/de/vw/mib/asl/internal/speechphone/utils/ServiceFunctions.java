/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.utils;

import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneParameters;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;

public class ServiceFunctions {
    private SpeechPhoneLogger2 logger;
    private SpeechPhoneParameters parameters;
    private int targetId;

    public ServiceFunctions(SpeechPhoneParameters speechPhoneParameters, int n) {
        this.parameters = speechPhoneParameters;
        this.targetId = n;
        this.logger = this.createLogger("ServiceFunctions");
    }

    public void addObserver(int n) {
        this.parameters.serviceRegister().addObserver(n, this.targetId);
    }

    public void sendHMIEvent(int n) {
        this.parameters.systemEventDispatcher().createAndSubmitHMIEvent(n);
    }

    public int getPhoneMaxPhoneNumberCharacters() {
        return this.parameters.configurationManager().getPhoneMaxPhoneNumberCharactersSds();
    }

    public boolean isFeatEmergency() {
        return this.parameters.configurationManager().isFeatureFlagSet(554);
    }

    public boolean isFeatService() {
        return this.parameters.configurationManager().isFeatureFlagSet(557);
    }

    public boolean isFeatInfo() {
        return this.parameters.configurationManager().isFeatureFlagSet(555);
    }

    public boolean isFeatMailbox() {
        return this.parameters.configurationManager().isFeatureFlagSet(559);
    }

    public void writeStringToDatapool(int n, String string) {
        this.parameters.aslPropertyManager().valueChangedString(n, string);
    }

    public void writeIntegerToDatapool(int n, int n2) {
        this.parameters.aslPropertyManager().valueChangedInteger(n, n2);
    }

    public void writeBooleanToDatapool(int n, boolean bl) {
        this.parameters.aslPropertyManager().valueChangedBoolean(n, bl);
    }

    public boolean updateList(int n, Object[] objectArray) {
        GenericASLList genericASLList = this.parameters.aslListManager().getGenericASLList(n);
        if (genericASLList != null) {
            genericASLList.updateList(objectArray);
            return true;
        }
        return false;
    }

    public Object[] getListObjects(int n) {
        Object[] objectArray = this.parameters.aslListManager().getGenericASLList(n).getDSIObjects();
        if (objectArray.length == 0) {
            return null;
        }
        return objectArray;
    }

    public ASLListManager aslListManager() {
        return this.parameters.aslListManager();
    }

    public void sendInternalEvent(int n, int n2) {
        try {
            EventGeneric eventGeneric = this.parameters.eventFactory().newEvent(1683233024, 1683233024, n);
            eventGeneric.setInt(0, n2);
            this.parameters.eventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.logger.error(new StringBuffer().append("Cannot send internal event: ( ").append(n).append(" ) - ").append(genericEventException.getMessage()).toString());
        }
    }

    public ContactNameModel getSelectedContact() {
        Object[] objectArray = this.getListObjects(-1985398016);
        if (objectArray == null) {
            this.logger.error("Selected object list was null or empty.");
            this.sendHMIEvent(-1968620800);
            return null;
        }
        return (ContactNameModel)objectArray[0];
    }

    public SpeechPhoneLogger2 createLogger(String string) {
        return new SpeechPhoneLogger2(this.parameters.classifiedLogger(), string);
    }
}


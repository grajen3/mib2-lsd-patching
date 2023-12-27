/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.callstack.CallstackDateTime;
import de.vw.mib.asl.api.phone.services.callstack.CallstackEntry;
import de.vw.mib.asl.internal.phone.api.model.CallstackDateTimeImpl;
import de.vw.mib.asl.internal.phone.api.model.CommonContactImpl;
import de.vw.mib.asl.internal.phone.api.model.PhoneNumberImpl;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;

public final class CallstackEntryImpl
extends CommonContactImpl
implements CallstackEntry {
    private final int id;
    private final int phoneDataCount;
    private final PhoneNumber phoneNumber;
    private final CallstackDateTime dateTime;
    private final int specialNumber;
    private final int callstackType;

    public CallstackEntryImpl(PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector) {
        super(phoneCallstacksCallstacksCollector.callListEntry.adbEntryID, phoneCallstacksCallstacksCollector.callListEntry.clName, phoneCallstacksCallstacksCollector.callListEntry.adbPictureID, phoneCallstacksCallstacksCollector.entryType);
        this.id = phoneCallstacksCallstacksCollector.callListEntry.clEntryID;
        this.phoneDataCount = phoneCallstacksCallstacksCollector.callListEntry.adbPhoneDataCount;
        this.phoneNumber = new PhoneNumberImpl(phoneCallstacksCallstacksCollector.callListEntry.clNumber, this, phoneCallstacksCallstacksCollector.callListEntry.adbNumberType);
        this.dateTime = new CallstackDateTimeImpl(phoneCallstacksCallstacksCollector.callListEntry.clYear, phoneCallstacksCallstacksCollector.callListEntry.clMonth, phoneCallstacksCallstacksCollector.callListEntry.clDay, phoneCallstacksCallstacksCollector.callListEntry.clHour, phoneCallstacksCallstacksCollector.callListEntry.clMinute, phoneCallstacksCallstacksCollector.callListEntry.clSecond);
        this.specialNumber = CallstackEntryImpl.convertSpecialNumber(phoneCallstacksCallstacksCollector.callType);
        this.callstackType = CallstackEntryImpl.convertCallstackType(phoneCallstacksCallstacksCollector.entryType);
    }

    private static int convertSpecialNumber(int n) {
        switch (n) {
            case 3: {
                return 1;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 2;
            }
        }
        return 0;
    }

    private static int convertCallstackType(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 3;
            }
        }
        return 0;
    }

    @Override
    public int getCallstackId() {
        return this.id;
    }

    @Override
    public int getNumberCount() {
        return this.phoneDataCount;
    }

    @Override
    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public CallstackDateTime getDateTime() {
        return this.dateTime;
    }

    @Override
    public int getSpecialNumber() {
        return this.specialNumber;
    }

    @Override
    public int getCallstackType() {
        return this.callstackType;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("CallstackEntryImpl [id=").append(this.id).append(", phoneNumber=").append(this.phoneNumber).append(", dateTime=").append(this.dateTime).append(", specialNumber=").append(this.specialNumber).append(", callstackType=").append(this.callstackType).append(", toString()=").append(super.toString()).append("]").toString();
    }
}


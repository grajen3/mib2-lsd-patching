/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.global.ResourceLocator;

public class CallStackEntry {
    public int clEntryID;
    public String clNumber;
    public String clName;
    public String lastName;
    public String firstName;
    public String organization;
    public int clEntryOrigin;
    public int clEntryType;
    public short clYear;
    public short clMonth;
    public short clDay;
    public short clHour;
    public short clMinute;
    public short clSecond;
    public ResourceLocator adbPictureID;
    public long adbEntryID;
    public int adbPhoneDataIndex;
    public int adbPhoneDataCount;
    public int newMissedCallAttempts;
    public int adbNumberType;

    public CallStackEntry() {
        this.clEntryID = 0;
        this.clNumber = null;
        this.clName = null;
        this.lastName = null;
        this.firstName = null;
        this.organization = null;
        this.clEntryOrigin = 0;
        this.clYear = 0;
        this.clMonth = 0;
        this.clDay = 0;
        this.clHour = 0;
        this.clMinute = 0;
        this.clSecond = 0;
        this.adbPictureID = null;
        this.adbEntryID = 0L;
        this.adbPhoneDataIndex = 0;
        this.adbPhoneDataCount = 0;
        this.newMissedCallAttempts = 0;
        this.adbNumberType = 0;
    }

    public CallStackEntry(int n, String string, String string2, int n2, int n3, short s, short s2, short s3, short s4, short s5, short s6, ResourceLocator resourceLocator, long l, int n4, int n5, int n6, int n7) {
        this.clEntryID = n;
        this.clNumber = string;
        this.clName = string2;
        this.lastName = null;
        this.firstName = null;
        this.organization = null;
        this.clEntryOrigin = n2;
        this.clEntryType = n3;
        this.clYear = s;
        this.clMonth = s2;
        this.clDay = s3;
        this.clHour = s4;
        this.clMinute = s5;
        this.clSecond = s6;
        this.adbPictureID = resourceLocator;
        this.adbEntryID = l;
        this.adbPhoneDataIndex = n4;
        this.adbPhoneDataCount = n5;
        this.newMissedCallAttempts = n6;
        this.adbNumberType = n7;
    }

    public CallStackEntry(int n, String string, String string2, String string3, String string4, String string5, int n2, int n3, short s, short s2, short s3, short s4, short s5, short s6, ResourceLocator resourceLocator, long l, int n4, int n5, int n6, int n7) {
        this.clEntryID = n;
        this.clNumber = string;
        this.clName = string2;
        this.lastName = string3;
        this.firstName = string4;
        this.organization = string5;
        this.clEntryOrigin = n2;
        this.clEntryType = n3;
        this.clYear = s;
        this.clMonth = s2;
        this.clDay = s3;
        this.clHour = s4;
        this.clMinute = s5;
        this.clSecond = s6;
        this.adbPictureID = resourceLocator;
        this.adbEntryID = l;
        this.adbPhoneDataIndex = n4;
        this.adbPhoneDataCount = n5;
        this.newMissedCallAttempts = n6;
        this.adbNumberType = n7;
    }

    public int getClEntryID() {
        return this.clEntryID;
    }

    public String getClNumber() {
        return this.clNumber;
    }

    public String getClName() {
        return this.clName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getOrganization() {
        return this.organization;
    }

    public int getClEntryOrigin() {
        return this.clEntryOrigin;
    }

    public int getClEntryType() {
        return this.clEntryType;
    }

    public short getClYear() {
        return this.clYear;
    }

    public short getClMonth() {
        return this.clMonth;
    }

    public short getClDay() {
        return this.clDay;
    }

    public short getClHour() {
        return this.clHour;
    }

    public short getClMinute() {
        return this.clMinute;
    }

    public short getClSecond() {
        return this.clSecond;
    }

    public ResourceLocator getAdbPictureID() {
        return this.adbPictureID;
    }

    public long getAdbEntryID() {
        return this.adbEntryID;
    }

    public int getAdbPhoneDataIndex() {
        return this.adbPhoneDataIndex;
    }

    public int getAdbPhoneDataCount() {
        return this.adbPhoneDataCount;
    }

    public int getNewMissedCallAttempts() {
        return this.newMissedCallAttempts;
    }

    public int getAdbNumberType() {
        return this.adbNumberType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2150);
        stringBuffer.append("CallStackEntry");
        stringBuffer.append('(');
        stringBuffer.append("clEntryID");
        stringBuffer.append('=');
        stringBuffer.append(this.clEntryID);
        stringBuffer.append(',');
        stringBuffer.append("clNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.clNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("clName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.clName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("lastName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("organization");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.organization);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("clEntryOrigin");
        stringBuffer.append('=');
        stringBuffer.append(this.clEntryOrigin);
        stringBuffer.append(',');
        stringBuffer.append("clEntryType");
        stringBuffer.append('=');
        stringBuffer.append(this.clEntryType);
        stringBuffer.append(',');
        stringBuffer.append("clYear");
        stringBuffer.append('=');
        stringBuffer.append(this.clYear);
        stringBuffer.append(',');
        stringBuffer.append("clMonth");
        stringBuffer.append('=');
        stringBuffer.append(this.clMonth);
        stringBuffer.append(',');
        stringBuffer.append("clDay");
        stringBuffer.append('=');
        stringBuffer.append(this.clDay);
        stringBuffer.append(',');
        stringBuffer.append("clHour");
        stringBuffer.append('=');
        stringBuffer.append(this.clHour);
        stringBuffer.append(',');
        stringBuffer.append("clMinute");
        stringBuffer.append('=');
        stringBuffer.append(this.clMinute);
        stringBuffer.append(',');
        stringBuffer.append("clSecond");
        stringBuffer.append('=');
        stringBuffer.append(this.clSecond);
        stringBuffer.append(',');
        stringBuffer.append("adbPictureID");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPictureID);
        stringBuffer.append(',');
        stringBuffer.append("adbEntryID");
        stringBuffer.append('=');
        stringBuffer.append(this.adbEntryID);
        stringBuffer.append(',');
        stringBuffer.append("adbPhoneDataIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPhoneDataIndex);
        stringBuffer.append(',');
        stringBuffer.append("adbPhoneDataCount");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPhoneDataCount);
        stringBuffer.append(',');
        stringBuffer.append("newMissedCallAttempts");
        stringBuffer.append('=');
        stringBuffer.append(this.newMissedCallAttempts);
        stringBuffer.append(',');
        stringBuffer.append("adbNumberType");
        stringBuffer.append('=');
        stringBuffer.append(this.adbNumberType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


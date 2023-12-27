/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallInformationExt;

public class CallInformation {
    public short telCallID;
    public int telCallState;
    public int telMpty;
    public String telRemName;
    public String telRemLastName;
    public String telRemFirstName;
    public String telRemOrganization;
    public String telRemNumber;
    public ResourceLocator telRemPictureId;
    public short telNumType;
    public int telCallType;
    public long telRemEntryId;
    public int telRemNumberType;
    public int telCallStartingTime;
    public CallInformationExt extendedCallInformation;
    public int telCallCarrier;

    public CallInformation() {
        this.telCallID = 0;
        this.telCallState = 0;
        this.telMpty = 0;
        this.telRemName = null;
        this.telRemLastName = null;
        this.telRemFirstName = null;
        this.telRemOrganization = null;
        this.telRemNumber = null;
        this.telRemPictureId = null;
        this.telNumType = 0;
        this.telCallType = 0;
        this.telCallType = 0;
        this.telRemEntryId = 0L;
        this.telRemNumberType = 0;
        this.telCallStartingTime = 0;
        this.extendedCallInformation = null;
        this.telCallCarrier = 0;
    }

    public CallInformation(short s, int n, int n2, String string, String string2, ResourceLocator resourceLocator, short s2, int n3, long l, int n4, int n5, CallInformationExt callInformationExt, int n6) {
        this.telCallID = s;
        this.telCallState = n;
        this.telMpty = n2;
        this.telRemName = string;
        this.telRemLastName = null;
        this.telRemFirstName = null;
        this.telRemOrganization = null;
        this.telRemNumber = string2;
        this.telRemPictureId = resourceLocator;
        this.telNumType = s2;
        this.telCallType = n3;
        this.telRemEntryId = l;
        this.telRemNumberType = n4;
        this.telCallStartingTime = n5;
        this.extendedCallInformation = callInformationExt;
    }

    public CallInformation(short s, int n, int n2, String string, String string2, String string3, String string4, String string5, ResourceLocator resourceLocator, short s2, int n3, long l, int n4, int n5, CallInformationExt callInformationExt, int n6) {
        this.telCallID = s;
        this.telCallState = n;
        this.telMpty = n2;
        this.telRemName = string;
        this.telRemLastName = string2;
        this.telRemFirstName = string3;
        this.telRemOrganization = string4;
        this.telRemNumber = string5;
        this.telRemPictureId = resourceLocator;
        this.telNumType = s2;
        this.telCallType = n3;
        this.telRemEntryId = l;
        this.telRemNumberType = n4;
        this.telCallStartingTime = n5;
        this.extendedCallInformation = callInformationExt;
    }

    public short getTelCallID() {
        return this.telCallID;
    }

    public int getTelCallState() {
        return this.telCallState;
    }

    public int getTelMpty() {
        return this.telMpty;
    }

    public String getTelRemName() {
        return this.telRemName;
    }

    public String getTelRemLastName() {
        return this.telRemLastName;
    }

    public String getTelRemFirstName() {
        return this.telRemFirstName;
    }

    public String getTelRemOrganization() {
        return this.telRemOrganization;
    }

    public String getTelRemNumber() {
        return this.telRemNumber;
    }

    public ResourceLocator getTelRemPictureId() {
        return this.telRemPictureId;
    }

    public short getTelNumType() {
        return this.telNumType;
    }

    public int getTelCallType() {
        return this.telCallType;
    }

    public long getTelRemEntryId() {
        return this.telRemEntryId;
    }

    public int getTelRemNumberType() {
        return this.telRemNumberType;
    }

    public int getTelCallStartingTime() {
        return this.telCallStartingTime;
    }

    public CallInformationExt getExtendedCallInformation() {
        return this.extendedCallInformation;
    }

    public int getTelCallCarrier() {
        return this.telCallCarrier;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3050);
        stringBuffer.append("CallInformation");
        stringBuffer.append('(');
        stringBuffer.append("telCallID");
        stringBuffer.append('=');
        stringBuffer.append(this.telCallID);
        stringBuffer.append(',');
        stringBuffer.append("telCallState");
        stringBuffer.append('=');
        stringBuffer.append(this.telCallState);
        stringBuffer.append(',');
        stringBuffer.append("telMpty");
        stringBuffer.append('=');
        stringBuffer.append(this.telMpty);
        stringBuffer.append(',');
        stringBuffer.append("telRemName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telRemName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telRemLastName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telRemLastName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telRemFirstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telRemFirstName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telRemOrganization");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telRemOrganization);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telRemNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telRemNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telRemPictureId");
        stringBuffer.append('=');
        stringBuffer.append(this.telRemPictureId);
        stringBuffer.append(',');
        stringBuffer.append("telNumType");
        stringBuffer.append('=');
        stringBuffer.append(this.telNumType);
        stringBuffer.append(',');
        stringBuffer.append("telCallType");
        stringBuffer.append('=');
        stringBuffer.append(this.telCallType);
        stringBuffer.append(',');
        stringBuffer.append("telRemEntryId");
        stringBuffer.append('=');
        stringBuffer.append(this.telRemEntryId);
        stringBuffer.append(',');
        stringBuffer.append("telRemNumberType");
        stringBuffer.append('=');
        stringBuffer.append(this.telRemNumberType);
        stringBuffer.append(',');
        stringBuffer.append("telCallStartingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.telCallStartingTime);
        stringBuffer.append(',');
        stringBuffer.append("extendedCallInformation");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedCallInformation);
        stringBuffer.append(',');
        stringBuffer.append("telCallCarrier");
        stringBuffer.append('=');
        stringBuffer.append(this.telCallCarrier);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class AdbEntry {
    public long entryId;
    public int entryType;
    public String combinedName;
    public int preferredNumberIdx;
    public int voiceTagId;
    public PhoneData[] phoneData;
    public AddressData[] addressData;
    public EmailData[] emailData;
    public String[] urlData;
    public PersonalData personalData;
    public String referenceId;

    public AdbEntry() {
        this.entryId = 0L;
        this.entryType = 0;
        this.combinedName = null;
        this.preferredNumberIdx = 0;
        this.voiceTagId = 0;
        this.phoneData = null;
        this.addressData = null;
        this.emailData = null;
        this.urlData = null;
        this.personalData = null;
        this.referenceId = null;
    }

    public AdbEntry(long l, int n, String string, int n2, int n3, PhoneData[] phoneDataArray, AddressData[] addressDataArray, EmailData[] emailDataArray, String[] stringArray, PersonalData personalData, String string2) {
        this.entryId = l;
        this.entryType = n;
        this.combinedName = string;
        this.preferredNumberIdx = n2;
        this.voiceTagId = n3;
        this.phoneData = phoneDataArray;
        this.addressData = addressDataArray;
        this.emailData = emailDataArray;
        this.urlData = stringArray;
        this.personalData = personalData;
        this.referenceId = string2;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public int getEntryType() {
        return this.entryType;
    }

    public String getCombinedName() {
        return this.combinedName;
    }

    public int getPreferredNumberIdx() {
        return this.preferredNumberIdx;
    }

    public int getVoiceTagId() {
        return this.voiceTagId;
    }

    public PhoneData[] getPhoneData() {
        return this.phoneData;
    }

    public AddressData[] getAddressData() {
        return this.addressData;
    }

    public EmailData[] getEmailData() {
        return this.emailData;
    }

    public String[] getUrlData() {
        return this.urlData;
    }

    public PersonalData getPersonalData() {
        return this.personalData;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("AdbEntry");
        stringBuffer.append('(');
        stringBuffer.append("entryId");
        stringBuffer.append('=');
        stringBuffer.append(this.entryId);
        stringBuffer.append(',');
        stringBuffer.append("entryType");
        stringBuffer.append('=');
        stringBuffer.append(this.entryType);
        stringBuffer.append(',');
        stringBuffer.append("combinedName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.combinedName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("preferredNumberIdx");
        stringBuffer.append('=');
        stringBuffer.append(this.preferredNumberIdx);
        stringBuffer.append(',');
        stringBuffer.append("voiceTagId");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceTagId);
        stringBuffer.append(',');
        stringBuffer.append("phoneData");
        stringBuffer.append('[');
        if (this.phoneData != null) {
            stringBuffer.append(this.phoneData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.phoneData != null) {
            n3 = this.phoneData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.phoneData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.phoneData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("addressData");
        stringBuffer.append('[');
        if (this.addressData != null) {
            stringBuffer.append(this.addressData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.addressData != null) {
            n3 = this.addressData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.addressData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.addressData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("emailData");
        stringBuffer.append('[');
        if (this.emailData != null) {
            stringBuffer.append(this.emailData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.emailData != null) {
            n3 = this.emailData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.emailData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.emailData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("urlData");
        stringBuffer.append('[');
        if (this.urlData != null) {
            stringBuffer.append(this.urlData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.urlData != null) {
            n3 = this.urlData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.urlData[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.urlData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("personalData");
        stringBuffer.append('=');
        stringBuffer.append(this.personalData);
        stringBuffer.append(',');
        stringBuffer.append("referenceId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.referenceId);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


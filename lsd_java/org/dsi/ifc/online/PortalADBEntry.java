/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.PortalAddressData;
import org.dsi.ifc.online.PortalMessagingData;
import org.dsi.ifc.online.PortalNavigationData;
import org.dsi.ifc.online.PortalPersonalData;
import org.dsi.ifc.online.PortalPhoneData;

public class PortalADBEntry {
    public long entryID;
    public long entryType;
    public String generalDescription;
    public String additionalDescription;
    public int voiceTagID;
    public int preferedNumber;
    public long oadbHashcode;
    public long initialNoNavHashcode;
    public PortalPersonalData personalData;
    public PortalPhoneData[] phoneData;
    public PortalAddressData[] addressData;
    public PortalNavigationData[] navigationData;
    public PortalMessagingData[] messagingData;

    public PortalADBEntry() {
        this.entryID = 0L;
        this.entryType = 0L;
        this.generalDescription = null;
        this.additionalDescription = null;
        this.voiceTagID = -1;
        this.preferedNumber = 0;
        this.oadbHashcode = 0L;
        this.initialNoNavHashcode = 0L;
        this.personalData = null;
        this.phoneData = null;
        this.addressData = null;
        this.navigationData = null;
        this.messagingData = null;
    }

    public PortalADBEntry(long l, long l2, String string, String string2, int n, int n2, long l3, long l4, PortalPersonalData portalPersonalData, PortalPhoneData[] portalPhoneDataArray, PortalAddressData[] portalAddressDataArray, PortalNavigationData[] portalNavigationDataArray, PortalMessagingData[] portalMessagingDataArray) {
        this.entryID = l;
        this.entryType = l2;
        this.generalDescription = string;
        this.additionalDescription = string2;
        this.voiceTagID = n;
        this.preferedNumber = n2;
        this.oadbHashcode = l3;
        this.initialNoNavHashcode = l4;
        this.personalData = portalPersonalData;
        this.phoneData = portalPhoneDataArray;
        this.addressData = portalAddressDataArray;
        this.navigationData = portalNavigationDataArray;
        this.messagingData = portalMessagingDataArray;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public long getEntryType() {
        return this.entryType;
    }

    public String getGeneralDescription() {
        return this.generalDescription;
    }

    public String getAdditionalDescription() {
        return this.additionalDescription;
    }

    public int getVoiceTagID() {
        return this.voiceTagID;
    }

    public int getPreferedNumber() {
        return this.preferedNumber;
    }

    public long getOadbHashcode() {
        return this.oadbHashcode;
    }

    public long getInitialNoNavHashcode() {
        return this.initialNoNavHashcode;
    }

    public PortalPersonalData getPersonalData() {
        return this.personalData;
    }

    public PortalPhoneData[] getPhoneData() {
        return this.phoneData;
    }

    public PortalAddressData[] getAddressData() {
        return this.addressData;
    }

    public PortalNavigationData[] getNavigationData() {
        return this.navigationData;
    }

    public PortalMessagingData[] getMessagingData() {
        return this.messagingData;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1900);
        stringBuffer.append("PortalADBEntry");
        stringBuffer.append('(');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
        stringBuffer.append(',');
        stringBuffer.append("entryType");
        stringBuffer.append('=');
        stringBuffer.append(this.entryType);
        stringBuffer.append(',');
        stringBuffer.append("generalDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.generalDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("additionalDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.additionalDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("voiceTagID");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceTagID);
        stringBuffer.append(',');
        stringBuffer.append("preferedNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.preferedNumber);
        stringBuffer.append(',');
        stringBuffer.append("oadbHashcode");
        stringBuffer.append('=');
        stringBuffer.append(this.oadbHashcode);
        stringBuffer.append(',');
        stringBuffer.append("initialNoNavHashcode");
        stringBuffer.append('=');
        stringBuffer.append(this.initialNoNavHashcode);
        stringBuffer.append(',');
        stringBuffer.append("personalData");
        stringBuffer.append('=');
        stringBuffer.append(this.personalData);
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
        stringBuffer.append("navigationData");
        stringBuffer.append('[');
        if (this.navigationData != null) {
            stringBuffer.append(this.navigationData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.navigationData != null) {
            n3 = this.navigationData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.navigationData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.navigationData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("messagingData");
        stringBuffer.append('[');
        if (this.messagingData != null) {
            stringBuffer.append(this.messagingData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.messagingData != null) {
            n3 = this.messagingData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.messagingData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.messagingData);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


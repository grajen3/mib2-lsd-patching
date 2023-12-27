/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.OSRServiceListEntry;

public class OSRServiceState {
    public String serviceID;
    public String symbolicName;
    public int errorCode;
    public int privacyConflict;
    public OSRServiceListEntry serviceListEntry;
    public String[] onlineserviceassignments;

    public OSRServiceState() {
        this.serviceID = null;
        this.symbolicName = null;
        this.privacyConflict = 0;
        this.errorCode = 0;
        this.serviceListEntry = null;
        this.onlineserviceassignments = null;
    }

    public OSRServiceState(String string, String string2, int n, int n2, OSRServiceListEntry oSRServiceListEntry, String[] stringArray) {
        this.serviceID = string;
        this.symbolicName = string2;
        this.errorCode = n;
        this.serviceListEntry = oSRServiceListEntry;
        this.privacyConflict = n2;
        this.onlineserviceassignments = stringArray;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public String getSymbolicName() {
        return this.symbolicName;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getPrivacyConflict() {
        return this.privacyConflict;
    }

    public OSRServiceListEntry getServiceListEntry() {
        return this.serviceListEntry;
    }

    public String[] getOnlineserviceassignments() {
        return this.onlineserviceassignments;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("OSRServiceState");
        stringBuffer.append('(');
        stringBuffer.append("serviceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serviceID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("symbolicName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.symbolicName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("errorCode");
        stringBuffer.append('=');
        stringBuffer.append(this.errorCode);
        stringBuffer.append(',');
        stringBuffer.append("privacyConflict");
        stringBuffer.append('=');
        stringBuffer.append(this.privacyConflict);
        stringBuffer.append(',');
        stringBuffer.append("serviceListEntry");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceListEntry);
        stringBuffer.append(',');
        stringBuffer.append("onlineserviceassignments");
        stringBuffer.append('[');
        if (this.onlineserviceassignments != null) {
            stringBuffer.append(this.onlineserviceassignments.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.onlineserviceassignments != null) {
            int n = this.onlineserviceassignments.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.onlineserviceassignments[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.onlineserviceassignments);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


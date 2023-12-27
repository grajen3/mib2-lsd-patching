/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class OSRNotifyPropertiesSL {
    public String serviceID;
    public String symbolicName;
    public int reasonConnectivity;
    public int reasonConfig;
    public int reasonLicense;
    public int reasonBackend;
    public int privacyConflict;

    public OSRNotifyPropertiesSL() {
        this.serviceID = "";
        this.symbolicName = "";
        this.reasonConnectivity = 0;
        this.reasonConfig = 0;
        this.reasonLicense = 0;
        this.reasonBackend = 0;
        this.privacyConflict = 0;
    }

    public OSRNotifyPropertiesSL(String string, String string2, int n, int n2, int n3, int n4, int n5) {
        this.serviceID = string;
        this.symbolicName = string2;
        this.reasonConnectivity = n;
        this.reasonConfig = n2;
        this.reasonLicense = n3;
        this.reasonBackend = n4;
        this.privacyConflict = n5;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public String getSymbolicName() {
        return this.symbolicName;
    }

    public int getReasonConfig() {
        return this.reasonConfig;
    }

    public int getReasonLicense() {
        return this.reasonLicense;
    }

    public int getReasonBackend() {
        return this.reasonBackend;
    }

    public int getPrivacyConflict() {
        return this.privacyConflict;
    }

    public int getReasonConnectivity() {
        return this.reasonConnectivity;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("OSRNotifyPropertiesSL");
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
        stringBuffer.append("reasonConnectivity");
        stringBuffer.append('=');
        stringBuffer.append(this.reasonConnectivity);
        stringBuffer.append(',');
        stringBuffer.append("reasonConfig");
        stringBuffer.append('=');
        stringBuffer.append(this.reasonConfig);
        stringBuffer.append(',');
        stringBuffer.append("reasonLicense");
        stringBuffer.append('=');
        stringBuffer.append(this.reasonLicense);
        stringBuffer.append(',');
        stringBuffer.append("reasonBackend");
        stringBuffer.append('=');
        stringBuffer.append(this.reasonBackend);
        stringBuffer.append(',');
        stringBuffer.append("privacyConflict");
        stringBuffer.append('=');
        stringBuffer.append(this.privacyConflict);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


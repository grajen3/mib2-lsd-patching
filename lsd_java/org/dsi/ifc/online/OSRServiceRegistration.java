/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class OSRServiceRegistration {
    public String appID;
    public String serviceID;
    public String symbolicName;
    public String localizedDescription;
    public boolean mandatoryFlag;

    public OSRServiceRegistration() {
        this.appID = null;
        this.serviceID = null;
        this.symbolicName = null;
        this.localizedDescription = null;
        this.mandatoryFlag = false;
    }

    public OSRServiceRegistration(String string, String string2, String string3, String string4, boolean bl) {
        this.appID = string;
        this.serviceID = string2;
        this.symbolicName = string3;
        this.localizedDescription = string4;
        this.mandatoryFlag = bl;
    }

    public String getAppID() {
        return this.appID;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public String getSymbolicName() {
        return this.symbolicName;
    }

    public String getLocalizedDescription() {
        return this.localizedDescription;
    }

    public boolean isMandatoryFlag() {
        return this.mandatoryFlag;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("OSRServiceRegistration");
        stringBuffer.append('(');
        stringBuffer.append("appID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.appID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
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
        stringBuffer.append("localizedDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.localizedDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mandatoryFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.mandatoryFlag);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


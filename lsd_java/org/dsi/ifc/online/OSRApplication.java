/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRLicense;

public class OSRApplication {
    public String id;
    public int state;
    public boolean demandstate;
    public OSRLicense[] licenseList;
    public OSRApplicationProperties[] propertyList;

    public OSRApplication(String string, int n, boolean bl, OSRLicense[] oSRLicenseArray, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        this.id = string;
        this.state = n;
        this.demandstate = bl;
        this.licenseList = oSRLicenseArray;
        this.propertyList = oSRApplicationPropertiesArray;
    }

    public OSRApplication() {
        this.id = null;
        this.state = 0;
        this.demandstate = false;
        this.licenseList = null;
        this.propertyList = null;
    }

    public String getId() {
        return this.id;
    }

    public int getState() {
        return this.state;
    }

    public OSRLicense[] getLicenseList() {
        return this.licenseList;
    }

    public boolean isDemandstate() {
        return this.demandstate;
    }

    public OSRApplicationProperties[] getPropertyList() {
        return this.propertyList;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("OSRApplication");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.id);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("demandstate");
        stringBuffer.append('=');
        stringBuffer.append(this.demandstate);
        stringBuffer.append(',');
        stringBuffer.append("licenseList");
        stringBuffer.append('[');
        if (this.licenseList != null) {
            stringBuffer.append(this.licenseList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.licenseList != null) {
            n3 = this.licenseList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.licenseList[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.licenseList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("propertyList");
        stringBuffer.append('[');
        if (this.propertyList != null) {
            stringBuffer.append(this.propertyList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.propertyList != null) {
            n3 = this.propertyList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.propertyList[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.propertyList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


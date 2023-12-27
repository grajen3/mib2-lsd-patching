/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRPersonalIdentifier;

public class OSRUser {
    public String authIdentifier;
    public String portalUser;
    public String hash1;
    public String hash2;
    public String name;
    public OSRPersonalIdentifier personalIdentifier;
    public OSRDevice[] devicesForAutologin;
    public int privacyFlag;
    public int usertype;

    public OSRUser() {
        this.authIdentifier = null;
        this.portalUser = null;
        this.hash1 = null;
        this.hash2 = null;
        this.name = null;
        this.personalIdentifier = null;
        this.devicesForAutologin = null;
        this.privacyFlag = 0;
        this.usertype = 0;
    }

    public OSRUser(String string, String string2, String string3, String string4, String string5, OSRPersonalIdentifier oSRPersonalIdentifier, OSRDevice[] oSRDeviceArray, int n, int n2) {
        this.authIdentifier = string;
        this.portalUser = string2;
        this.hash1 = string3;
        this.hash2 = string4;
        this.personalIdentifier = oSRPersonalIdentifier;
        this.devicesForAutologin = oSRDeviceArray;
        this.name = string5;
        this.privacyFlag = n;
        this.usertype = n2;
    }

    public String getAuthIdentifier() {
        return this.authIdentifier;
    }

    public String getPortalUser() {
        return this.portalUser;
    }

    public String getName() {
        return this.name;
    }

    public String getHash1() {
        return this.hash1;
    }

    public String getHash2() {
        return this.hash2;
    }

    public OSRPersonalIdentifier getPersonalIdentifier() {
        return this.personalIdentifier;
    }

    public OSRDevice[] getDevicesForAutologin() {
        return this.devicesForAutologin;
    }

    public int getPrivacyFlag() {
        return this.privacyFlag;
    }

    public int getUsertype() {
        return this.usertype;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1600);
        stringBuffer.append("OSRUser");
        stringBuffer.append('(');
        stringBuffer.append("authIdentifier");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.authIdentifier);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("portalUser");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.portalUser);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hash1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.hash1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hash2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.hash2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("personalIdentifier");
        stringBuffer.append('=');
        stringBuffer.append(this.personalIdentifier);
        stringBuffer.append(',');
        stringBuffer.append("devicesForAutologin");
        stringBuffer.append('[');
        if (this.devicesForAutologin != null) {
            stringBuffer.append(this.devicesForAutologin.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.devicesForAutologin != null) {
            int n = this.devicesForAutologin.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.devicesForAutologin[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.devicesForAutologin);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("privacyFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.privacyFlag);
        stringBuffer.append(',');
        stringBuffer.append("usertype");
        stringBuffer.append('=');
        stringBuffer.append(this.usertype);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


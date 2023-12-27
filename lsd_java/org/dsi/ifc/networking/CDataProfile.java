/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

public class CDataProfile {
    public int profileID;
    public String dataProfileName;
    public String dataAPN;
    public String dataUserName;
    public String dataPassword;
    public int dataAuthentication;
    public String provider;
    public boolean isAPNvisible;
    public String dataAPN2;
    public String dataUserName2;
    public String dataPassword2;
    public boolean isAPN2visible;

    public CDataProfile() {
        this.profileID = 0;
        this.dataProfileName = null;
        this.dataAPN = null;
        this.dataUserName = null;
        this.dataPassword = null;
        this.dataAuthentication = 0;
        this.provider = null;
        this.isAPNvisible = false;
        this.dataAPN2 = null;
        this.dataUserName2 = null;
        this.dataPassword2 = null;
        this.isAPN2visible = false;
    }

    public CDataProfile(int n, String string, String string2, String string3, String string4, int n2, String string5) {
        this.profileID = n;
        this.dataProfileName = string;
        this.dataAPN = string2;
        this.dataUserName = string3;
        this.dataPassword = string4;
        this.dataAuthentication = n2;
        this.provider = string5;
        this.isAPNvisible = false;
        this.dataAPN2 = null;
        this.dataUserName2 = null;
        this.dataPassword2 = null;
        this.isAPN2visible = false;
    }

    public CDataProfile(int n, String string, String string2, String string3, String string4, int n2, String string5, boolean bl, String string6, String string7, String string8, boolean bl2) {
        this.profileID = n;
        this.dataProfileName = string;
        this.dataAPN = string2;
        this.dataUserName = string3;
        this.dataPassword = string4;
        this.dataAuthentication = n2;
        this.provider = string5;
        this.isAPNvisible = bl;
        this.dataAPN2 = string6;
        this.dataUserName2 = string7;
        this.dataPassword2 = string8;
        this.isAPN2visible = bl2;
    }

    public boolean isIsAPNvisible() {
        return this.isAPNvisible;
    }

    public String getDataAPN2() {
        return this.dataAPN2;
    }

    public String getDataUserName2() {
        return this.dataUserName2;
    }

    public String getDataPassword2() {
        return this.dataPassword2;
    }

    public boolean isIsAPN2visible() {
        return this.isAPN2visible;
    }

    public int getProfileID() {
        return this.profileID;
    }

    public String getDataProfileName() {
        return this.dataProfileName;
    }

    public String getDataAPN() {
        return this.dataAPN;
    }

    public String getDataUserName() {
        return this.dataUserName;
    }

    public String getDataPassword() {
        return this.dataPassword;
    }

    public int getDataAuthentication() {
        return this.dataAuthentication;
    }

    public String getProvider() {
        return this.provider;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(900);
        stringBuffer.append("CDataProfile");
        stringBuffer.append('(');
        stringBuffer.append("profileID");
        stringBuffer.append('=');
        stringBuffer.append(this.profileID);
        stringBuffer.append(',');
        stringBuffer.append("dataProfileName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataProfileName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataAPN");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataAPN);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataUserName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataUserName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataPassword");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataPassword);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataAuthentication");
        stringBuffer.append('=');
        stringBuffer.append(this.dataAuthentication);
        stringBuffer.append(',');
        stringBuffer.append("provider");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.provider);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("isAPNvisible");
        stringBuffer.append('=');
        stringBuffer.append(this.isAPNvisible);
        stringBuffer.append(',');
        stringBuffer.append("dataAPN2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataAPN2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataUserName2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataUserName2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataPassword2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dataPassword2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("isAPN2visible");
        stringBuffer.append('=');
        stringBuffer.append(this.isAPN2visible);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class PhoneInformation {
    public String imsi;
    public String simId;
    public String nadIMEI;
    public String meIMEI;
    public String meBtAddress;
    public String meFriendlyName;
    public int telNetIdAvailIMSI;
    public int telNetIdAvailSimId;
    public int telNetIdAvailNadIMEI;
    public int telNetIdAvailMeIMEI;
    public int telNetIdAvailMeBtAddress;
    public int telNetIdAvailMeFriendlyName;
    public String simName;

    public PhoneInformation() {
        this.imsi = null;
        this.simId = null;
        this.nadIMEI = null;
        this.meIMEI = null;
        this.meBtAddress = null;
        this.meFriendlyName = null;
        this.telNetIdAvailIMSI = 0;
        this.telNetIdAvailSimId = 0;
        this.telNetIdAvailNadIMEI = 0;
        this.telNetIdAvailMeIMEI = 0;
        this.telNetIdAvailMeBtAddress = 0;
        this.telNetIdAvailMeFriendlyName = 0;
        this.simName = null;
    }

    public PhoneInformation(String string, String string2, String string3, String string4, String string5, String string6, int n, int n2, int n3, int n4, int n5, int n6, String string7) {
        this.imsi = string;
        this.simId = string2;
        this.nadIMEI = string3;
        this.meIMEI = string4;
        this.meBtAddress = string5;
        this.meFriendlyName = string6;
        this.telNetIdAvailIMSI = n;
        this.telNetIdAvailSimId = n2;
        this.telNetIdAvailNadIMEI = n3;
        this.telNetIdAvailMeIMEI = n4;
        this.telNetIdAvailMeBtAddress = n5;
        this.telNetIdAvailMeFriendlyName = n6;
        this.simName = string7;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getSimId() {
        return this.simId;
    }

    public String getNadIMEI() {
        return this.nadIMEI;
    }

    public String getMeIMEI() {
        return this.meIMEI;
    }

    public String getMeBtAddress() {
        return this.meBtAddress;
    }

    public String getMeFriendlyName() {
        return this.meFriendlyName;
    }

    public int getTelNetIdAvailIMSI() {
        return this.telNetIdAvailIMSI;
    }

    public int getTelNetIdAvailSimId() {
        return this.telNetIdAvailSimId;
    }

    public int getTelNetIdAvailNadIMEI() {
        return this.telNetIdAvailNadIMEI;
    }

    public int getTelNetIdAvailMeIMEI() {
        return this.telNetIdAvailMeIMEI;
    }

    public int getTelNetIdAvailMeBtAddress() {
        return this.telNetIdAvailMeBtAddress;
    }

    public int getTelNetIdAvailMeFriendlyName() {
        return this.telNetIdAvailMeFriendlyName;
    }

    public String getSimName() {
        return this.simName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("PhoneInformation");
        stringBuffer.append('(');
        stringBuffer.append("imsi");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imsi);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("simId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.simId);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("nadIMEI");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.nadIMEI);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("meIMEI");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.meIMEI);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("meBtAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.meBtAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("meFriendlyName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.meFriendlyName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telNetIdAvailIMSI");
        stringBuffer.append('=');
        stringBuffer.append(this.telNetIdAvailIMSI);
        stringBuffer.append(',');
        stringBuffer.append("telNetIdAvailSimId");
        stringBuffer.append('=');
        stringBuffer.append(this.telNetIdAvailSimId);
        stringBuffer.append(',');
        stringBuffer.append("telNetIdAvailNadIMEI");
        stringBuffer.append('=');
        stringBuffer.append(this.telNetIdAvailNadIMEI);
        stringBuffer.append(',');
        stringBuffer.append("telNetIdAvailMeIMEI");
        stringBuffer.append('=');
        stringBuffer.append(this.telNetIdAvailMeIMEI);
        stringBuffer.append(',');
        stringBuffer.append("telNetIdAvailMeBtAddress");
        stringBuffer.append('=');
        stringBuffer.append(this.telNetIdAvailMeBtAddress);
        stringBuffer.append(',');
        stringBuffer.append("telNetIdAvailMeFriendlyName");
        stringBuffer.append('=');
        stringBuffer.append(this.telNetIdAvailMeFriendlyName);
        stringBuffer.append(',');
        stringBuffer.append("simName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.simName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


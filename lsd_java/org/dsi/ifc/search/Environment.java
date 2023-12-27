/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class Environment {
    public String oem;
    public String region;
    public String countryCoding;
    public String dealer;

    public Environment() {
        this.oem = null;
        this.region = null;
        this.countryCoding = null;
        this.dealer = null;
    }

    public Environment(String string, String string2, String string3) {
        this.oem = string;
        this.region = string2;
        this.countryCoding = string3;
        this.dealer = null;
    }

    public Environment(String string, String string2, String string3, String string4) {
        this.oem = string;
        this.region = string2;
        this.countryCoding = string3;
        this.dealer = string4;
    }

    public String getOem() {
        return this.oem;
    }

    public String getRegion() {
        return this.region;
    }

    public String getCountryCoding() {
        return this.countryCoding;
    }

    public String getDealer() {
        return this.dealer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Environment");
        stringBuffer.append('(');
        stringBuffer.append("oem");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.oem);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("region");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.region);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryCoding");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryCoding);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dealer");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dealer);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class DataServiceInfo {
    public int ensID;
    public int ensECC;
    public long sID;
    public int sCIDI;
    public int type;
    public int serviceAbbreviationMatrix;
    public String serviceShortName;
    public String serviceFullName;
    public int componentAbbreviationMatrix;
    public String componentShortName;
    public String componentFullName;
    public String uRL;

    public DataServiceInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0L;
        this.sCIDI = 0;
        this.type = 0;
        this.serviceAbbreviationMatrix = 0;
        this.serviceShortName = "";
        this.serviceFullName = "";
        this.componentAbbreviationMatrix = 0;
        this.componentShortName = "";
        this.componentFullName = "";
        this.uRL = null;
    }

    public DataServiceInfo(int n, int n2, long l, int n3, int n4, int n5, String string, String string2, int n6, String string3, String string4, String string5) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = l;
        this.sCIDI = n3;
        this.type = n4;
        this.serviceAbbreviationMatrix = n5;
        this.serviceShortName = string;
        this.serviceFullName = string2;
        this.componentAbbreviationMatrix = n6;
        this.componentShortName = string3;
        this.componentFullName = string4;
        this.uRL = string5;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public long getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public int getType() {
        return this.type;
    }

    public int getServiceAbbreviationMatrix() {
        return this.serviceAbbreviationMatrix;
    }

    public String getServiceShortName() {
        return this.serviceShortName;
    }

    public String getServiceFullName() {
        return this.serviceFullName;
    }

    public int getComponentAbbreviationMatrix() {
        return this.componentAbbreviationMatrix;
    }

    public String getComponentShortName() {
        return this.componentShortName;
    }

    public String getComponentFullName() {
        return this.componentFullName;
    }

    public String getURL() {
        return this.uRL;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(850);
        stringBuffer.append("DataServiceInfo");
        stringBuffer.append('(');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("serviceAbbreviationMatrix");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceAbbreviationMatrix);
        stringBuffer.append(',');
        stringBuffer.append("serviceShortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serviceShortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("serviceFullName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serviceFullName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("componentAbbreviationMatrix");
        stringBuffer.append('=');
        stringBuffer.append(this.componentAbbreviationMatrix);
        stringBuffer.append(',');
        stringBuffer.append("componentShortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.componentShortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("componentFullName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.componentFullName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("uRL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.uRL);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


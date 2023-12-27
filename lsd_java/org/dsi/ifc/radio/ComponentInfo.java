/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class ComponentInfo {
    public int ensID;
    public int ensECC;
    public long sID;
    public int sCIDI;
    public String shortName;
    public String fullName;
    public boolean primaryService;
    public boolean radiotext;

    public ComponentInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0L;
        this.sCIDI = 0;
        this.shortName = "";
        this.fullName = "";
        this.primaryService = false;
        this.radiotext = false;
    }

    public ComponentInfo(int n, int n2, long l, int n3, String string, String string2, boolean bl, boolean bl2) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = l;
        this.sCIDI = n3;
        this.shortName = string;
        this.fullName = string2;
        this.primaryService = bl;
        this.radiotext = bl2;
    }

    public boolean isRadiotext() {
        return this.radiotext;
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

    public String getShortName() {
        return this.shortName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public boolean isPrimaryService() {
        return this.primaryService;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("ComponentInfo");
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
        stringBuffer.append("shortName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fullName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fullName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("primaryService");
        stringBuffer.append('=');
        stringBuffer.append(this.primaryService);
        stringBuffer.append(',');
        stringBuffer.append("radiotext");
        stringBuffer.append('=');
        stringBuffer.append(this.radiotext);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


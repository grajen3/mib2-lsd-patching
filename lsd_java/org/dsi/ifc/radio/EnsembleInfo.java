/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class EnsembleInfo {
    public int ensID;
    public int ensECC;
    public String shortName;
    public String fullName;
    public String frequencyLabel;
    public int frequencyValue;
    public boolean tp;
    public boolean potentiallyReceivable;

    public EnsembleInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.shortName = "";
        this.fullName = "";
        this.frequencyLabel = "";
        this.frequencyValue = 0;
        this.tp = false;
        this.potentiallyReceivable = true;
    }

    public EnsembleInfo(int n, int n2, String string, String string2, String string3, int n3, boolean bl, boolean bl2) {
        this.ensID = n;
        this.ensECC = n2;
        this.shortName = string;
        this.fullName = string2;
        this.frequencyLabel = string3;
        this.frequencyValue = n3;
        this.tp = bl;
        this.potentiallyReceivable = bl2;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getFrequencyLabel() {
        return this.frequencyLabel;
    }

    public int getFrequencyValue() {
        return this.frequencyValue;
    }

    public boolean isTp() {
        return this.tp;
    }

    public boolean isPotentiallyReceivable() {
        return this.potentiallyReceivable;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("EnsembleInfo");
        stringBuffer.append('(');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
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
        stringBuffer.append("frequencyLabel");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.frequencyLabel);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequencyValue");
        stringBuffer.append('=');
        stringBuffer.append(this.frequencyValue);
        stringBuffer.append(',');
        stringBuffer.append("tp");
        stringBuffer.append('=');
        stringBuffer.append(this.tp);
        stringBuffer.append(',');
        stringBuffer.append("potentiallyReceivable");
        stringBuffer.append('=');
        stringBuffer.append(this.potentiallyReceivable);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


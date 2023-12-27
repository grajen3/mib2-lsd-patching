/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class UnifiedRadioText {
    public int piSId;
    public int ensId;
    public int ecc;
    public int sCIDI;
    public String radioText;
    public int source;

    public UnifiedRadioText() {
        this.ensId = 0;
        this.ecc = 0;
        this.piSId = 0;
        this.sCIDI = 0;
        this.radioText = "";
        this.source = 0;
    }

    public UnifiedRadioText(int n, int n2, int n3, int n4, String string, int n5) {
        this.ensId = n2;
        this.ecc = n3;
        this.piSId = n;
        this.sCIDI = n4;
        this.radioText = string;
        this.source = n5;
    }

    public int getEnsId() {
        return this.ensId;
    }

    public int getEcc() {
        return this.ecc;
    }

    public int getPiSId() {
        return this.piSId;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public String getRadioText() {
        return this.radioText;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("UnifiedRadioText");
        stringBuffer.append('(');
        stringBuffer.append("piSId");
        stringBuffer.append('=');
        stringBuffer.append(this.piSId);
        stringBuffer.append(',');
        stringBuffer.append("ensId");
        stringBuffer.append('=');
        stringBuffer.append(this.ensId);
        stringBuffer.append(',');
        stringBuffer.append("ecc");
        stringBuffer.append('=');
        stringBuffer.append(this.ecc);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("radioText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.radioText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("source");
        stringBuffer.append('=');
        stringBuffer.append(this.source);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


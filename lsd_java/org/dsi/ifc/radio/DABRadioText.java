/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class DABRadioText {
    public int ensID;
    public int ensECC;
    public int sID;
    public int sCIDI;
    public String text;

    public DABRadioText() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0;
        this.sCIDI = 0;
        this.text = "";
    }

    public DABRadioText(int n, int n2, int n3, int n4, String string) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = n3;
        this.sCIDI = n4;
        this.text = string;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public int getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DABRadioText");
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
        stringBuffer.append("text");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.text);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


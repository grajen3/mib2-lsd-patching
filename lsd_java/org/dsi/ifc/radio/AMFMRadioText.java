/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class AMFMRadioText {
    public int pi;
    public String text;

    public AMFMRadioText() {
        this.pi = 0;
        this.text = "";
    }

    public AMFMRadioText(int n, String string) {
        this.pi = n;
        this.text = string;
    }

    public int getPi() {
        return this.pi;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AMFMRadioText");
        stringBuffer.append('(');
        stringBuffer.append("pi");
        stringBuffer.append('=');
        stringBuffer.append(this.pi);
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


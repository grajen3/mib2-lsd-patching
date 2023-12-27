/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class PhonemeData {
    public String alphabet;
    public String phoneme;

    public PhonemeData() {
        this.alphabet = null;
        this.phoneme = null;
    }

    public PhonemeData(String string, String string2) {
        this.alphabet = string;
        this.phoneme = string2;
    }

    public String getAlphabet() {
        return this.alphabet;
    }

    public String getPhoneme() {
        return this.phoneme;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PhonemeData");
        stringBuffer.append('(');
        stringBuffer.append("alphabet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.alphabet);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phoneme");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phoneme);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


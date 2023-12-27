/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

public class PhoneticEntry {
    public String alphabet;
    public String language;
    public String transcription;

    public PhoneticEntry() {
        this.alphabet = "";
        this.language = "";
        this.transcription = "";
    }

    public PhoneticEntry(String string, String string2, String string3) {
        this.alphabet = string;
        this.language = string2;
        this.transcription = string3;
    }

    public String getAlphabet() {
        return this.alphabet;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getTranscription() {
        return this.transcription;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("PhoneticEntry");
        stringBuffer.append('(');
        stringBuffer.append("alphabet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.alphabet);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("language");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.language);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("transcription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.transcription);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


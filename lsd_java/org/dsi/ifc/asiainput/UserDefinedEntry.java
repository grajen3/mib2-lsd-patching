/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiainput;

public class UserDefinedEntry {
    public String phrase;
    public String spelling;

    public UserDefinedEntry() {
        this.phrase = null;
        this.spelling = null;
    }

    public UserDefinedEntry(String string, String string2) {
        this.phrase = string;
        this.spelling = string2;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public String getSpelling() {
        return this.spelling;
    }

    public void setPhrase(String string) {
        this.phrase = string;
    }

    public void setSpelling(String string) {
        this.spelling = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("UserDefinedEntry");
        stringBuffer.append('(');
        stringBuffer.append("phrase");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phrase);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("spelling");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.spelling);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


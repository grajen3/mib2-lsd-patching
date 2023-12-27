/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.speechrec.PhoneticEntry;

public class DictionaryEntry {
    public String orthography;
    public int ttsTransIndex;
    public PhoneticEntry[] phoneticList;

    public DictionaryEntry() {
        this.orthography = "";
        this.ttsTransIndex = 0;
        this.phoneticList = new PhoneticEntry[0];
    }

    public DictionaryEntry(String string, int n, PhoneticEntry[] phoneticEntryArray) {
        this.orthography = string;
        this.ttsTransIndex = n;
        this.phoneticList = phoneticEntryArray;
    }

    public String getOrthography() {
        return this.orthography;
    }

    public int getTtsTransIndex() {
        return this.ttsTransIndex;
    }

    public PhoneticEntry[] getPhoneticList() {
        return this.phoneticList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DictionaryEntry");
        stringBuffer.append('(');
        stringBuffer.append("orthography");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.orthography);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ttsTransIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.ttsTransIndex);
        stringBuffer.append(',');
        stringBuffer.append("phoneticList");
        stringBuffer.append('[');
        if (this.phoneticList != null) {
            stringBuffer.append(this.phoneticList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.phoneticList != null) {
            int n = this.phoneticList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.phoneticList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.phoneticList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


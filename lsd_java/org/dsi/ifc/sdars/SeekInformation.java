/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class SeekInformation {
    public int seekInfo;
    public String seekText;

    public SeekInformation() {
        this.seekInfo = 0;
        this.seekText = null;
    }

    public SeekInformation(int n, String string) {
        this.seekInfo = n;
        this.seekText = string;
    }

    public int getSeekInfo() {
        return this.seekInfo;
    }

    public String getSeekText() {
        return this.seekText;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SeekInformation");
        stringBuffer.append('(');
        stringBuffer.append("seekInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.seekInfo);
        stringBuffer.append(',');
        stringBuffer.append("seekText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.seekText);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


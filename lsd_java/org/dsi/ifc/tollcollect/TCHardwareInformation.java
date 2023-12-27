/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

public class TCHardwareInformation {
    public int key;
    public String value;

    public TCHardwareInformation() {
        this.key = 0;
        this.value = null;
    }

    public TCHardwareInformation(int n, String string) {
        this.key = n;
        this.value = string;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TCHardwareInformation");
        stringBuffer.append('(');
        stringBuffer.append("key");
        stringBuffer.append('=');
        stringBuffer.append(this.key);
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


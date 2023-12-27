/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class AddressData {
    public int key;
    public String value;

    public AddressData() {
        this.key = 0;
        this.value = null;
    }

    public AddressData(int n, String string) {
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
        stringBuffer.append("AddressData");
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


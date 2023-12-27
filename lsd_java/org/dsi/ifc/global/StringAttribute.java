/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class StringAttribute {
    public String key;
    public String value;

    public StringAttribute() {
        this.key = null;
        this.value = null;
    }

    public StringAttribute(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("StringAttribute");
        stringBuffer.append('(');
        stringBuffer.append("key");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.key);
        stringBuffer.append('\"');
        stringBuffer.append(",");
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}


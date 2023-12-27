/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class OSRApplicationProperties {
    public int group;
    public String key;
    public String value;

    public OSRApplicationProperties() {
        this.key = "";
        this.value = "";
    }

    public OSRApplicationProperties(int n, String string, String string2) {
        this.group = n;
        this.key = string;
        this.value = string2;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int getGroup() {
        return this.group;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("OSRApplicationProperties");
        stringBuffer.append('(');
        stringBuffer.append("group");
        stringBuffer.append('=');
        stringBuffer.append(this.group);
        stringBuffer.append(',');
        stringBuffer.append("key");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.key);
        stringBuffer.append('\"');
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


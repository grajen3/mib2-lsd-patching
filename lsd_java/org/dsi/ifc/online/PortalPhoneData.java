/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PortalPhoneData {
    public String number;
    public long type;

    public PortalPhoneData() {
        this.number = null;
        this.type = 0L;
    }

    public PortalPhoneData(String string, long l) {
        this.number = string;
        this.type = l;
    }

    public String getNumber() {
        return this.number;
    }

    public long getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PortalPhoneData");
        stringBuffer.append('(');
        stringBuffer.append("number");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.number);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


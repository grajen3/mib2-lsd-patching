/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class OSRPersonalIdentifier {
    public int pType;
    public String pIdentifier;

    public OSRPersonalIdentifier() {
        this.pType = 0;
        this.pIdentifier = "";
    }

    public OSRPersonalIdentifier(int n, String string) {
        this.pType = n;
        this.pIdentifier = string;
    }

    public int getPType() {
        return this.pType;
    }

    public String getPIdentifier() {
        return this.pIdentifier;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("OSRPersonalIdentifier");
        stringBuffer.append('(');
        stringBuffer.append("pType");
        stringBuffer.append('=');
        stringBuffer.append(this.pType);
        stringBuffer.append(',');
        stringBuffer.append("pIdentifier");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.pIdentifier);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


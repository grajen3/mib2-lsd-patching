/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class Favorite {
    public String name;
    public String number;

    public Favorite() {
        this.name = null;
        this.number = null;
    }

    public Favorite(String string, String string2) {
        this.name = string;
        this.number = string2;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("Favorite");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("number");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.number);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


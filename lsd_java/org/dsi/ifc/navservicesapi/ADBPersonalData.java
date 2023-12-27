/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class ADBPersonalData {
    public String name;
    public String firstName;
    public String soundName;
    public String soundFirstName;

    public ADBPersonalData() {
        this.name = null;
        this.firstName = null;
        this.soundName = null;
        this.soundFirstName = null;
    }

    public ADBPersonalData(String string, String string2, String string3, String string4) {
        this.name = string;
        this.firstName = string2;
        this.soundName = string3;
        this.soundFirstName = string4;
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSoundName() {
        return this.soundName;
    }

    public String getSoundFirstName() {
        return this.soundFirstName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("ADBPersonalData");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("soundName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.soundName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("soundFirstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.soundFirstName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class TrafficInfo {
    public int messageID;
    public int priority;
    public String streetName;
    public String location;
    public String infoText;
    public int length;
    public int unit;

    public TrafficInfo() {
        this.messageID = 0;
        this.priority = 0;
        this.streetName = "";
        this.location = "";
        this.infoText = "";
        this.length = 0;
        this.unit = 0;
    }

    public TrafficInfo(int n, int n2, String string, String string2, String string3, int n3, int n4) {
        this.messageID = n;
        this.priority = n2;
        this.streetName = string;
        this.location = string2;
        this.infoText = string3;
        this.length = n3;
        this.unit = n4;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public String getLocation() {
        return this.location;
    }

    public String getInfoText() {
        return this.infoText;
    }

    public int getLength() {
        return this.length;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("TrafficInfo");
        stringBuffer.append('(');
        stringBuffer.append("messageID");
        stringBuffer.append('=');
        stringBuffer.append(this.messageID);
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("streetName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.location);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("infoText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.infoText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("length");
        stringBuffer.append('=');
        stringBuffer.append(this.length);
        stringBuffer.append(',');
        stringBuffer.append("unit");
        stringBuffer.append('=');
        stringBuffer.append(this.unit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

public class TCPaymentInfoDetails {
    public String entranceMotorwayName;
    public String entranceIC;
    public String exitMotorwayName;
    public String exitIC;
    public boolean isFlatRate;

    public TCPaymentInfoDetails() {
        this.entranceMotorwayName = null;
        this.entranceIC = null;
        this.exitMotorwayName = null;
        this.exitIC = null;
        this.isFlatRate = false;
    }

    public TCPaymentInfoDetails(String string, String string2, String string3, String string4, boolean bl) {
        this.entranceMotorwayName = string;
        this.entranceIC = string2;
        this.exitMotorwayName = string3;
        this.exitIC = string4;
        this.isFlatRate = bl;
    }

    public String getEntranceMotorwayName() {
        return this.entranceMotorwayName;
    }

    public String getEntranceIC() {
        return this.entranceIC;
    }

    public String getExitMotorwayName() {
        return this.exitMotorwayName;
    }

    public String getExitIC() {
        return this.exitIC;
    }

    public boolean isIsFlatRate() {
        return this.isFlatRate;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("TCPaymentInfoDetails");
        stringBuffer.append('(');
        stringBuffer.append("entranceMotorwayName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.entranceMotorwayName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("entranceIC");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.entranceIC);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exitMotorwayName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exitMotorwayName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exitIC");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exitIC);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("isFlatRate");
        stringBuffer.append('=');
        stringBuffer.append(this.isFlatRate);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


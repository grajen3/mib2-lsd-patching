/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class ServiceNumbers {
    public String infonumber;
    public String infonumberRoaming;
    public String breakdownNumber;
    public String breakdownNumberRoaming;

    public ServiceNumbers() {
        this.infonumber = null;
        this.infonumberRoaming = null;
        this.breakdownNumber = null;
        this.breakdownNumberRoaming = null;
    }

    public ServiceNumbers(String string, String string2, String string3, String string4) {
        this.infonumber = string;
        this.infonumberRoaming = string2;
        this.breakdownNumber = string3;
        this.breakdownNumberRoaming = string4;
    }

    public String getInfonumber() {
        return this.infonumber;
    }

    public String getInfonumberRoaming() {
        return this.infonumberRoaming;
    }

    public String getBreakdownNumber() {
        return this.breakdownNumber;
    }

    public String getBreakdownNumberRoaming() {
        return this.breakdownNumberRoaming;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("ServiceNumbers");
        stringBuffer.append('(');
        stringBuffer.append("infonumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.infonumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("infonumberRoaming");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.infonumberRoaming);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("breakdownNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.breakdownNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("breakdownNumberRoaming");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.breakdownNumberRoaming);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


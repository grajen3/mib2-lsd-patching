/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class CFRequestData {
    public int telCFMode;
    public int telCFCondition;
    public String telCFNumber;
    public short telClass;
    public short telCFTime;

    public CFRequestData() {
        this.telCFMode = 0;
        this.telCFCondition = 0;
        this.telCFNumber = null;
        this.telClass = 0;
        this.telCFTime = 0;
    }

    public CFRequestData(int n, int n2, String string, short s, short s2) {
        this.telCFMode = n;
        this.telCFCondition = n2;
        this.telCFNumber = string;
        this.telClass = s;
        this.telCFTime = s2;
    }

    public int getTelCFMode() {
        return this.telCFMode;
    }

    public int getTelCFCondition() {
        return this.telCFCondition;
    }

    public String getTelCFNumber() {
        return this.telCFNumber;
    }

    public short getTelClass() {
        return this.telClass;
    }

    public short getTelCFTime() {
        return this.telCFTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("CFRequestData");
        stringBuffer.append('(');
        stringBuffer.append("telCFMode");
        stringBuffer.append('=');
        stringBuffer.append(this.telCFMode);
        stringBuffer.append(',');
        stringBuffer.append("telCFCondition");
        stringBuffer.append('=');
        stringBuffer.append(this.telCFCondition);
        stringBuffer.append(',');
        stringBuffer.append("telCFNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telCFNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("telClass");
        stringBuffer.append('=');
        stringBuffer.append(this.telClass);
        stringBuffer.append(',');
        stringBuffer.append("telCFTime");
        stringBuffer.append('=');
        stringBuffer.append(this.telCFTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


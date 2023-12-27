/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class CFResponseData {
    public int telCFStatus;
    public int telCFCondition;
    public String telCFNumber;
    public short telClass;
    public short telNumType;
    public short telCFTime;
    public int result;

    public CFResponseData() {
        this.telCFStatus = 0;
        this.telCFCondition = 0;
        this.telCFNumber = null;
        this.telClass = 0;
        this.telNumType = 0;
        this.telCFTime = 0;
        this.result = 0;
    }

    public CFResponseData(int n, int n2, String string, short s, short s2, short s3) {
        this.telCFStatus = n;
        this.telCFCondition = n2;
        this.telCFNumber = string;
        this.telClass = s;
        this.telNumType = s2;
        this.telCFTime = s3;
        this.result = 0;
    }

    public CFResponseData(int n, int n2, String string, short s, short s2, short s3, int n3) {
        this.telCFStatus = n;
        this.telCFCondition = n2;
        this.telCFNumber = string;
        this.telClass = s;
        this.telNumType = s2;
        this.telCFTime = s3;
        this.result = n3;
    }

    public int getTelCFStatus() {
        return this.telCFStatus;
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

    public short getTelNumType() {
        return this.telNumType;
    }

    public short getTelCFTime() {
        return this.telCFTime;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("CFResponseData");
        stringBuffer.append('(');
        stringBuffer.append("telCFStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.telCFStatus);
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
        stringBuffer.append("telNumType");
        stringBuffer.append('=');
        stringBuffer.append(this.telNumType);
        stringBuffer.append(',');
        stringBuffer.append("telCFTime");
        stringBuffer.append('=');
        stringBuffer.append(this.telCFTime);
        stringBuffer.append(',');
        stringBuffer.append("result");
        stringBuffer.append('=');
        stringBuffer.append(this.result);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


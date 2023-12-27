/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.TSDSignInfo;

public class TSDSignFct {
    public int sign;
    public int signDynamicValue;
    public int addSign;
    public String addSignDynamicValue;
    public TSDSignInfo signInfo;

    public TSDSignFct() {
        this.sign = 0;
        this.signDynamicValue = 0;
        this.addSign = 0;
        this.addSignDynamicValue = "";
        this.signInfo = null;
    }

    public TSDSignFct(int n, int n2, int n3, String string, TSDSignInfo tSDSignInfo) {
        this.sign = n;
        this.signDynamicValue = n2;
        this.addSign = n3;
        this.addSignDynamicValue = string;
        this.signInfo = tSDSignInfo;
    }

    public int getSign() {
        return this.sign;
    }

    public int getSignDynamicValue() {
        return this.signDynamicValue;
    }

    public int getAddSign() {
        return this.addSign;
    }

    public String getAddSignDynamicValue() {
        return this.addSignDynamicValue;
    }

    public TSDSignInfo getSignInfo() {
        return this.signInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("TSDSignFct");
        stringBuffer.append('(');
        stringBuffer.append("sign");
        stringBuffer.append('=');
        stringBuffer.append(this.sign);
        stringBuffer.append(',');
        stringBuffer.append("signDynamicValue");
        stringBuffer.append('=');
        stringBuffer.append(this.signDynamicValue);
        stringBuffer.append(',');
        stringBuffer.append("addSign");
        stringBuffer.append('=');
        stringBuffer.append(this.addSign);
        stringBuffer.append(',');
        stringBuffer.append("addSignDynamicValue");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.addSignDynamicValue);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("signInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.signInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


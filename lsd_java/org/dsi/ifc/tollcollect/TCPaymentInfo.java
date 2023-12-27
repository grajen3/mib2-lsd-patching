/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.NavPriceInfo;

public class TCPaymentInfo {
    public int paymentInfoID;
    public DateTime timeStamp;
    public NavPriceInfo tollAmount;

    public TCPaymentInfo() {
        this.paymentInfoID = 0;
        this.timeStamp = null;
        this.tollAmount = null;
    }

    public TCPaymentInfo(int n, DateTime dateTime, NavPriceInfo navPriceInfo) {
        this.paymentInfoID = n;
        this.timeStamp = dateTime;
        this.tollAmount = navPriceInfo;
    }

    public int getPaymentInfoID() {
        return this.paymentInfoID;
    }

    public DateTime getTimeStamp() {
        return this.timeStamp;
    }

    public NavPriceInfo getTollAmount() {
        return this.tollAmount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2150);
        stringBuffer.append("TCPaymentInfo");
        stringBuffer.append('(');
        stringBuffer.append("paymentInfoID");
        stringBuffer.append('=');
        stringBuffer.append(this.paymentInfoID);
        stringBuffer.append(',');
        stringBuffer.append("timeStamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timeStamp);
        stringBuffer.append(',');
        stringBuffer.append("tollAmount");
        stringBuffer.append('=');
        stringBuffer.append(this.tollAmount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class SubscriptionStatus {
    public int subscription;
    public int reasonCode;
    public int suspendDay;
    public int suspendMonth;
    public int suspendYear;
    public String reasonText;
    public String phoneNumber;

    public SubscriptionStatus() {
        this.subscription = 0;
        this.reasonCode = 0;
        this.suspendDay = 0;
        this.suspendMonth = 0;
        this.suspendYear = 0;
        this.reasonText = null;
        this.phoneNumber = null;
    }

    public SubscriptionStatus(int n, int n2, int n3, int n4, int n5, String string, String string2) {
        this.subscription = n;
        this.reasonCode = n2;
        this.suspendDay = n3;
        this.suspendMonth = n4;
        this.suspendYear = n5;
        this.reasonText = string;
        this.phoneNumber = string2;
    }

    public int getSubscription() {
        return this.subscription;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public int getSuspendDay() {
        return this.suspendDay;
    }

    public int getSuspendMonth() {
        return this.suspendMonth;
    }

    public int getSuspendYear() {
        return this.suspendYear;
    }

    public String getReasonText() {
        return this.reasonText;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("SubscriptionStatus");
        stringBuffer.append('(');
        stringBuffer.append("subscription");
        stringBuffer.append('=');
        stringBuffer.append(this.subscription);
        stringBuffer.append(',');
        stringBuffer.append("reasonCode");
        stringBuffer.append('=');
        stringBuffer.append(this.reasonCode);
        stringBuffer.append(',');
        stringBuffer.append("suspendDay");
        stringBuffer.append('=');
        stringBuffer.append(this.suspendDay);
        stringBuffer.append(',');
        stringBuffer.append("suspendMonth");
        stringBuffer.append('=');
        stringBuffer.append(this.suspendMonth);
        stringBuffer.append(',');
        stringBuffer.append("suspendYear");
        stringBuffer.append('=');
        stringBuffer.append(this.suspendYear);
        stringBuffer.append(',');
        stringBuffer.append("reasonText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.reasonText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phoneNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phoneNumber);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


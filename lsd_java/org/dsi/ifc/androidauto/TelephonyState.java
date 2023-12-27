/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

import java.io.PrintWriter;

public class TelephonyState {
    public int signalStrength;
    public int registrationStatus;
    public boolean airplaneMode;
    public String mobileOperator;

    public TelephonyState() {
        this.signalStrength = 0;
        this.registrationStatus = 0;
        this.airplaneMode = false;
        this.mobileOperator = "";
    }

    public TelephonyState(int n, int n2, boolean bl, String string) {
        this.signalStrength = n;
        this.registrationStatus = n2;
        this.airplaneMode = bl;
        this.mobileOperator = string;
    }

    public int getSignalStrength() {
        return this.signalStrength;
    }

    public int getRegistrationStatus() {
        return this.registrationStatus;
    }

    public boolean isAirplaneMode() {
        return this.airplaneMode;
    }

    public String getMobileOperator() {
        return this.mobileOperator;
    }

    public void toTrace(PrintWriter printWriter) {
        if (printWriter == null) {
            return;
        }
        printWriter.print("TelephonyState");
        printWriter.print('(');
        printWriter.print("signalStrength");
        printWriter.print('=');
        printWriter.print(this.signalStrength);
        printWriter.print(',');
        printWriter.print("registrationStatus");
        printWriter.print('=');
        printWriter.print(this.registrationStatus);
        printWriter.print(',');
        printWriter.print("airplaneMode");
        printWriter.print('=');
        printWriter.print(this.airplaneMode);
        printWriter.print(',');
        printWriter.print("mobileOperator");
        printWriter.print('=');
        printWriter.print('\"');
        printWriter.print(this.mobileOperator);
        printWriter.print('\"');
        printWriter.print(')');
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("TelephonyState");
        stringBuffer.append('(');
        stringBuffer.append("signalStrength");
        stringBuffer.append('=');
        stringBuffer.append(this.signalStrength);
        stringBuffer.append(',');
        stringBuffer.append("registrationStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.registrationStatus);
        stringBuffer.append(',');
        stringBuffer.append("airplaneMode");
        stringBuffer.append('=');
        stringBuffer.append(this.airplaneMode);
        stringBuffer.append(',');
        stringBuffer.append("mobileOperator");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mobileOperator);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


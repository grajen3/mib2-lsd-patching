/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.telephoneng.CFResponseData;

public class SuppServiceResponseStruct {
    public int telCWStatus;
    public CFResponseData[] telCFResponseData;
    public boolean simPINRequired;
    public int telCLIRState;
    public int telCLIRNWState;
    public int telServiceState;
    public String telResponseText;

    public SuppServiceResponseStruct() {
        this.telCWStatus = 0;
        this.telCFResponseData = null;
        this.simPINRequired = false;
        this.telCLIRState = 0;
        this.telCLIRNWState = 0;
        this.telServiceState = 0;
        this.telResponseText = null;
    }

    public SuppServiceResponseStruct(int n, CFResponseData[] cFResponseDataArray, boolean bl, int n2, int n3, int n4, String string) {
        this.telCWStatus = n;
        this.telCFResponseData = cFResponseDataArray;
        this.simPINRequired = bl;
        this.telCLIRState = n2;
        this.telCLIRNWState = n3;
        this.telServiceState = n4;
        this.telResponseText = string;
    }

    public int getTelCWStatus() {
        return this.telCWStatus;
    }

    public CFResponseData[] getTelCFResponseData() {
        return this.telCFResponseData;
    }

    public boolean isSimPINRequired() {
        return this.simPINRequired;
    }

    public int getTelCLIRState() {
        return this.telCLIRState;
    }

    public int getTelCLIRNWState() {
        return this.telCLIRNWState;
    }

    public int getTelServiceState() {
        return this.telServiceState;
    }

    public String getTelResponseText() {
        return this.telResponseText;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("SuppServiceResponseStruct");
        stringBuffer.append('(');
        stringBuffer.append("telCWStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.telCWStatus);
        stringBuffer.append(',');
        stringBuffer.append("telCFResponseData");
        stringBuffer.append('[');
        if (this.telCFResponseData != null) {
            stringBuffer.append(this.telCFResponseData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.telCFResponseData != null) {
            int n = this.telCFResponseData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.telCFResponseData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.telCFResponseData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("simPINRequired");
        stringBuffer.append('=');
        stringBuffer.append(this.simPINRequired);
        stringBuffer.append(',');
        stringBuffer.append("telCLIRState");
        stringBuffer.append('=');
        stringBuffer.append(this.telCLIRState);
        stringBuffer.append(',');
        stringBuffer.append("telCLIRNWState");
        stringBuffer.append('=');
        stringBuffer.append(this.telCLIRNWState);
        stringBuffer.append(',');
        stringBuffer.append("telServiceState");
        stringBuffer.append('=');
        stringBuffer.append(this.telServiceState);
        stringBuffer.append(',');
        stringBuffer.append("telResponseText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telResponseText);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


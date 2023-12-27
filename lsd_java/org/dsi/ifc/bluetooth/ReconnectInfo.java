/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

public class ReconnectInfo {
    public int reconnectIndicator;
    public String[] deviceNameList;
    public int[] serviceTypeList;

    public ReconnectInfo() {
        this.reconnectIndicator = 0;
        this.deviceNameList = null;
        this.serviceTypeList = null;
    }

    public ReconnectInfo(int n, String[] stringArray, int[] nArray) {
        this.reconnectIndicator = n;
        this.deviceNameList = stringArray;
        this.serviceTypeList = nArray;
    }

    public int getReconnectIndicator() {
        return this.reconnectIndicator;
    }

    public String[] getDeviceNameList() {
        return this.deviceNameList;
    }

    public int[] getServiceTypeList() {
        return this.serviceTypeList;
    }

    private String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (object instanceof int[]) {
                stringBuffer.append(((int[])object)[i2]);
            }
            if (!(object instanceof Object[])) continue;
            stringBuffer.append(((Object[])object)[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ReconnectInfo");
        stringBuffer.append('(');
        stringBuffer.append("reconnectIndicator");
        stringBuffer.append('=');
        stringBuffer.append(this.reconnectIndicator);
        stringBuffer.append(',');
        stringBuffer.append("deviceNameList");
        stringBuffer.append('[');
        if (this.deviceNameList != null) {
            stringBuffer.append(this.deviceNameList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.deviceNameList != null) {
            n3 = this.deviceNameList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.deviceNameList[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.deviceNameList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("serviceTypeList");
        stringBuffer.append('[');
        if (this.serviceTypeList != null) {
            stringBuffer.append(this.serviceTypeList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.serviceTypeList != null) {
            n3 = this.serviceTypeList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.serviceTypeList[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.serviceTypeList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


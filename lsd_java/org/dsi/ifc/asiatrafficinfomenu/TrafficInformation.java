/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class TrafficInformation {
    public int trafficType;
    public TrafficMessage[] trafficMessages;

    public TrafficInformation() {
        this.trafficType = 0;
        this.trafficMessages = null;
    }

    public TrafficInformation(int n, TrafficMessage[] trafficMessageArray) {
        this.trafficType = n;
        this.trafficMessages = trafficMessageArray;
    }

    public int getTrafficType() {
        return this.trafficType;
    }

    public TrafficMessage[] getTrafficMessages() {
        return this.trafficMessages;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TrafficInformation");
        stringBuffer.append('(');
        stringBuffer.append("trafficType");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficType);
        stringBuffer.append(',');
        stringBuffer.append("trafficMessages");
        stringBuffer.append('[');
        if (this.trafficMessages != null) {
            stringBuffer.append(this.trafficMessages.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.trafficMessages != null) {
            int n = this.trafficMessages.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.trafficMessages[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.trafficMessages);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


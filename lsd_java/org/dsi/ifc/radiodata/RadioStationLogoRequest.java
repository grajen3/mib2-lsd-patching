/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

import org.dsi.ifc.radiodata.RadioStationDataRequest;

public class RadioStationLogoRequest {
    public RadioStationDataRequest radioStationDataRequest;
    public int[] priorities;

    public RadioStationLogoRequest() {
        this.radioStationDataRequest = null;
        this.priorities = null;
    }

    public RadioStationLogoRequest(RadioStationDataRequest radioStationDataRequest, int[] nArray) {
        this.radioStationDataRequest = radioStationDataRequest;
        this.priorities = nArray;
    }

    public RadioStationDataRequest getRadioStationDataRequest() {
        return this.radioStationDataRequest;
    }

    public int[] getPriorities() {
        return this.priorities;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("RadioStationLogoRequest");
        stringBuffer.append('(');
        stringBuffer.append("radioStationDataRequest");
        stringBuffer.append('=');
        stringBuffer.append(this.radioStationDataRequest);
        stringBuffer.append(',');
        stringBuffer.append("priorities");
        stringBuffer.append('[');
        if (this.priorities != null) {
            stringBuffer.append(this.priorities.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.priorities != null) {
            int n = this.priorities.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.priorities[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.priorities);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


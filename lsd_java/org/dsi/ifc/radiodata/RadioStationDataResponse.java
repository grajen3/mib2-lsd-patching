/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

import org.dsi.ifc.radiodata.RadioStationData;

public class RadioStationDataResponse {
    public int totalItemCount;
    public RadioStationData[] radioStationData;

    public RadioStationDataResponse() {
        this.totalItemCount = 0;
        this.radioStationData = null;
    }

    public RadioStationDataResponse(int n, RadioStationData[] radioStationDataArray) {
        this.totalItemCount = n;
        this.radioStationData = radioStationDataArray;
    }

    public int getTotalItemCount() {
        return this.totalItemCount;
    }

    public RadioStationData[] getRadioStationData() {
        return this.radioStationData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RadioStationDataResponse");
        stringBuffer.append('(');
        stringBuffer.append("totalItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.totalItemCount);
        stringBuffer.append(',');
        stringBuffer.append("radioStationData");
        stringBuffer.append('[');
        if (this.radioStationData != null) {
            stringBuffer.append(this.radioStationData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.radioStationData != null) {
            int n = this.radioStationData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.radioStationData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.radioStationData);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


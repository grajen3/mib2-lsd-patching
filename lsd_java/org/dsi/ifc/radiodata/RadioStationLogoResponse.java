/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;

public class RadioStationLogoResponse {
    public int totalItemCount;
    public ResourceLocator[] resourceLocators;
    public RadioStationData[] radioStationData;

    public RadioStationLogoResponse() {
        this.totalItemCount = 0;
        this.resourceLocators = null;
        this.radioStationData = null;
    }

    public RadioStationLogoResponse(int n, ResourceLocator[] resourceLocatorArray, RadioStationData[] radioStationDataArray) {
        this.totalItemCount = n;
        this.resourceLocators = resourceLocatorArray;
        this.radioStationData = radioStationDataArray;
    }

    public int getTotalItemCount() {
        return this.totalItemCount;
    }

    public ResourceLocator[] getResourceLocators() {
        return this.resourceLocators;
    }

    public RadioStationData[] getRadioStationData() {
        return this.radioStationData;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RadioStationLogoResponse");
        stringBuffer.append('(');
        stringBuffer.append("totalItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.totalItemCount);
        stringBuffer.append(',');
        stringBuffer.append("resourceLocators");
        stringBuffer.append('[');
        if (this.resourceLocators != null) {
            stringBuffer.append(this.resourceLocators.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.resourceLocators != null) {
            n3 = this.resourceLocators.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.resourceLocators[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.resourceLocators);
        }
        stringBuffer.append('}');
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
            n3 = this.radioStationData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.radioStationData[n]);
                if (n >= n2) continue;
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


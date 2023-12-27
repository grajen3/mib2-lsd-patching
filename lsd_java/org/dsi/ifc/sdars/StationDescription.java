/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class StationDescription {
    public int sID;
    public String shortStationDescription;
    public String longStationDescription;
    public int[] relatedStationArray;

    public StationDescription() {
        this.sID = 0;
        this.shortStationDescription = null;
        this.longStationDescription = null;
        this.relatedStationArray = null;
    }

    public StationDescription(int n, String string, String string2, int[] nArray) {
        this.sID = n;
        this.shortStationDescription = string;
        this.longStationDescription = string2;
        this.relatedStationArray = nArray;
    }

    public int getSID() {
        return this.sID;
    }

    public String getShortStationDescription() {
        return this.shortStationDescription;
    }

    public String getLongStationDescription() {
        return this.longStationDescription;
    }

    public int[] getRelatedStationArray() {
        return this.relatedStationArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("StationDescription");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("shortStationDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortStationDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longStationDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longStationDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("relatedStationArray");
        stringBuffer.append('[');
        if (this.relatedStationArray != null) {
            stringBuffer.append(this.relatedStationArray.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.relatedStationArray != null) {
            int n = this.relatedStationArray.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.relatedStationArray[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.relatedStationArray);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


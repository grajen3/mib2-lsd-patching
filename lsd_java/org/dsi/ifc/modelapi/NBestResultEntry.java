/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

public class NBestResultEntry {
    public String[] nBestIDs;
    public String[] nBestData;

    public NBestResultEntry() {
        this.nBestIDs = null;
        this.nBestData = null;
    }

    public NBestResultEntry(String[] stringArray, String[] stringArray2) {
        this.nBestIDs = stringArray;
        this.nBestData = stringArray2;
    }

    public String[] getNBestIDs() {
        return this.nBestIDs;
    }

    public String[] getNBestData() {
        return this.nBestData;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("NBestResultEntry");
        stringBuffer.append('(');
        stringBuffer.append("nBestIDs");
        stringBuffer.append('[');
        if (this.nBestIDs != null) {
            stringBuffer.append(this.nBestIDs.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.nBestIDs != null) {
            n3 = this.nBestIDs.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.nBestIDs[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.nBestIDs);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("nBestData");
        stringBuffer.append('[');
        if (this.nBestData != null) {
            stringBuffer.append(this.nBestData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.nBestData != null) {
            n3 = this.nBestData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.nBestData[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.nBestData);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


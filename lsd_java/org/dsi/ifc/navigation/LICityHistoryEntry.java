/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.LIExtData;

public class LICityHistoryEntry {
    public String name;
    public boolean streetsInCity;
    public long id;
    public LIExtData[] extendedData;

    public LICityHistoryEntry() {
        this.name = null;
        this.streetsInCity = false;
        this.id = 0L;
        this.extendedData = null;
    }

    public LICityHistoryEntry(String string, boolean bl, long l, LIExtData[] lIExtDataArray) {
        this.name = string;
        this.streetsInCity = bl;
        this.id = l;
        this.extendedData = lIExtDataArray;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public boolean isStreetsInCity() {
        return this.streetsInCity;
    }

    public LIExtData[] getExtendedData() {
        return this.extendedData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("LICityHistoryEntry");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetsInCity");
        stringBuffer.append('=');
        stringBuffer.append(this.streetsInCity);
        stringBuffer.append(',');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("extendedData");
        stringBuffer.append('[');
        if (this.extendedData != null) {
            stringBuffer.append(this.extendedData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.extendedData != null) {
            int n = this.extendedData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.extendedData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.extendedData);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.LIExtData;

public class LIStateHistoryEntry {
    public String name;
    public boolean citiesInState;
    public long id;
    public LIExtData[] extendedData;

    public LIStateHistoryEntry() {
        this.name = null;
        this.citiesInState = false;
        this.id = 0L;
        this.extendedData = null;
    }

    public LIStateHistoryEntry(String string, boolean bl, long l, LIExtData[] lIExtDataArray) {
        this.name = string;
        this.citiesInState = bl;
        this.id = l;
        this.extendedData = lIExtDataArray;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public boolean isCitiesInState() {
        return this.citiesInState;
    }

    public LIExtData[] getExtendedData() {
        return this.extendedData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("LIStateHistoryEntry");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("citiesInState");
        stringBuffer.append('=');
        stringBuffer.append(this.citiesInState);
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


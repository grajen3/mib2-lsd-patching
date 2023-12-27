/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavPoiInfoConfiguration {
    public int[] excludedTypes;

    public NavPoiInfoConfiguration() {
        this.excludedTypes = null;
    }

    public NavPoiInfoConfiguration(int[] nArray) {
        this.excludedTypes = nArray;
    }

    public int[] getExcludedTypes() {
        return this.excludedTypes;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("NavPoiInfoConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("excludedTypes");
        stringBuffer.append('[');
        if (this.excludedTypes != null) {
            stringBuffer.append(this.excludedTypes.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.excludedTypes != null) {
            int n = this.excludedTypes.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.excludedTypes[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.excludedTypes);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


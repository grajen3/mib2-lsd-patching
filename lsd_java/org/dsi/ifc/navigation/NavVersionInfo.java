/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavVersionInfo {
    public String[] navVersion;

    public NavVersionInfo() {
        this.navVersion = null;
    }

    public NavVersionInfo(String[] stringArray) {
        this.navVersion = stringArray;
    }

    public String[] getNavVersion() {
        return this.navVersion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("NavVersionInfo");
        stringBuffer.append('(');
        stringBuffer.append("navVersion");
        stringBuffer.append('[');
        if (this.navVersion != null) {
            stringBuffer.append(this.navVersion.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.navVersion != null) {
            int n = this.navVersion.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.navVersion[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.navVersion);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


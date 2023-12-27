/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.IntellitextSubmenu;

public class IntellitextMenu {
    public String name;
    public IntellitextSubmenu[] submenuList;

    public IntellitextMenu() {
        this.name = "";
        this.submenuList = null;
    }

    public IntellitextMenu(String string, IntellitextSubmenu[] intellitextSubmenuArray) {
        this.name = string;
        this.submenuList = intellitextSubmenuArray;
    }

    public String getName() {
        return this.name;
    }

    public IntellitextSubmenu[] getSubmenuList() {
        return this.submenuList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("IntellitextMenu");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("submenuList");
        stringBuffer.append('[');
        if (this.submenuList != null) {
            stringBuffer.append(this.submenuList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.submenuList != null) {
            int n = this.submenuList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.submenuList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.submenuList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


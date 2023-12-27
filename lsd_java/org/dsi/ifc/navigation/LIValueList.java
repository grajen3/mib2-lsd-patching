/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.LIValueListElement;

public class LIValueList {
    public LIValueListElement[] list;
    public boolean hasNextPage;
    public boolean hasPrevPage;

    public LIValueList() {
        this.list = null;
        this.hasNextPage = false;
        this.hasPrevPage = false;
    }

    public LIValueList(LIValueListElement[] lIValueListElementArray, boolean bl, boolean bl2) {
        this.list = lIValueListElementArray;
        this.hasNextPage = bl;
        this.hasPrevPage = bl2;
    }

    public LIValueListElement[] getList() {
        return this.list;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public boolean isHasPrevPage() {
        return this.hasPrevPage;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("LIValueList");
        stringBuffer.append('(');
        stringBuffer.append("list");
        stringBuffer.append('[');
        if (this.list != null) {
            stringBuffer.append(this.list.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.list != null) {
            int n = this.list.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.list[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.list);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("hasNextPage");
        stringBuffer.append('=');
        stringBuffer.append(this.hasNextPage);
        stringBuffer.append(',');
        stringBuffer.append("hasPrevPage");
        stringBuffer.append('=');
        stringBuffer.append(this.hasPrevPage);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


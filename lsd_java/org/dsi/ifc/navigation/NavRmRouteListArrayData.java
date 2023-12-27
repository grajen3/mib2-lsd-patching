/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.NavRmRouteListData;

public class NavRmRouteListArrayData {
    public int rmId;
    public NavRmRouteListData[] routeList;
    public int totalSlots;

    public NavRmRouteListArrayData() {
        this.rmId = 0;
        this.routeList = null;
        this.totalSlots = 0;
    }

    public NavRmRouteListArrayData(int n, NavRmRouteListData[] navRmRouteListDataArray, int n2) {
        this.rmId = n;
        this.routeList = navRmRouteListDataArray;
        this.totalSlots = n2;
    }

    public int getRmId() {
        return this.rmId;
    }

    public NavRmRouteListData[] getRouteList() {
        return this.routeList;
    }

    public int getTotalSlots() {
        return this.totalSlots;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("NavRmRouteListArrayData");
        stringBuffer.append('(');
        stringBuffer.append("rmId");
        stringBuffer.append('=');
        stringBuffer.append(this.rmId);
        stringBuffer.append(',');
        stringBuffer.append("routeList");
        stringBuffer.append('[');
        if (this.routeList != null) {
            stringBuffer.append(this.routeList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.routeList != null) {
            int n = this.routeList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.routeList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.routeList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("totalSlots");
        stringBuffer.append('=');
        stringBuffer.append(this.totalSlots);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


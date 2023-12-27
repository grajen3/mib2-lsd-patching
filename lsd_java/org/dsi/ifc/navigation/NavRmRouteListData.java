/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavRmRouteListData {
    public long routeId;
    public String name;

    public NavRmRouteListData() {
        this.routeId = 0L;
        this.name = null;
    }

    public NavRmRouteListData(long l, String string) {
        this.routeId = l;
        this.name = string;
    }

    public long getRouteId() {
        return this.routeId;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("NavRmRouteListData");
        stringBuffer.append('(');
        stringBuffer.append("routeId");
        stringBuffer.append('=');
        stringBuffer.append(this.routeId);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


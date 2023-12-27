/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.RouteDestination;

public class Route {
    public long indexOfCurrentDestination;
    public long routeID;
    public RouteDestination[] routelist;
    public String routename;

    public Route() {
        this.routelist = null;
        this.routename = null;
        this.routeID = 0L;
        this.indexOfCurrentDestination = 0L;
    }

    public Route(long l, long l2, RouteDestination[] routeDestinationArray, String string) {
        this.indexOfCurrentDestination = l;
        this.routeID = l2;
        this.routelist = routeDestinationArray;
        this.routename = string;
    }

    public long getIndexOfCurrentDestination() {
        return this.indexOfCurrentDestination;
    }

    public long getRouteID() {
        return this.routeID;
    }

    public RouteDestination[] getRoutelist() {
        return this.routelist;
    }

    public String getRoutename() {
        return this.routename;
    }

    public void setIndexOfCurrentDestination(long l) {
        if (this.routelist == null || l < 0L || l >= (long)this.routelist.length) {
            throw new ArrayIndexOutOfBoundsException((int)l);
        }
        this.indexOfCurrentDestination = l;
    }

    public void setRouteID(long l) {
        this.routeID = l;
    }

    public void setRoutename(String string) {
        this.routename = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Route");
        stringBuffer.append('(');
        stringBuffer.append("indexOfCurrentDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.indexOfCurrentDestination);
        stringBuffer.append(',');
        stringBuffer.append("routeID");
        stringBuffer.append('=');
        stringBuffer.append(this.routeID);
        stringBuffer.append(',');
        stringBuffer.append("routelist");
        stringBuffer.append('[');
        if (this.routelist != null) {
            stringBuffer.append(this.routelist.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.routelist != null) {
            int n = this.routelist.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.routelist[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.routelist);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("routename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.routename);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


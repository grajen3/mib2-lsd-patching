/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.RouteOptions;

public class RouteDestination {
    public NavLocation routeLocation;
    public RouteOptions[] routeOptions;
    public int destinationType;

    public RouteDestination() {
        this.routeLocation = null;
        this.routeOptions = null;
        this.destinationType = 1;
    }

    public RouteDestination(NavLocation navLocation, RouteOptions[] routeOptionsArray, int n) {
        this.routeLocation = navLocation;
        this.routeOptions = routeOptionsArray;
        this.destinationType = n;
    }

    public NavLocation getRouteLocation() {
        return this.routeLocation;
    }

    public RouteOptions[] getRouteOptions() {
        return this.routeOptions;
    }

    public int getDestinationType() {
        return this.destinationType;
    }

    public void setRouteLocation(NavLocation navLocation) {
        this.routeLocation = navLocation;
    }

    public void setRouteOptions(RouteOptions[] routeOptionsArray) {
        this.routeOptions = routeOptionsArray;
    }

    public void setDestinationType(int n) {
        this.destinationType = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("RouteDestination");
        stringBuffer.append('(');
        stringBuffer.append("routeLocation");
        stringBuffer.append('=');
        stringBuffer.append(this.routeLocation);
        stringBuffer.append(',');
        stringBuffer.append("routeOptions");
        stringBuffer.append('[');
        if (this.routeOptions != null) {
            stringBuffer.append(this.routeOptions.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.routeOptions != null) {
            int n = this.routeOptions.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.routeOptions[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.routeOptions);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("destinationType");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


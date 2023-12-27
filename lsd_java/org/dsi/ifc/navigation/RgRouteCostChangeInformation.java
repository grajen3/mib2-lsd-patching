/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RouteSectionInfo;

public class RgRouteCostChangeInformation {
    public CalculatedRouteListElement oldRoute;
    public CalculatedRouteListElement newRoute;
    public boolean newRouteRecommended;
    public int tmcMsgId;
    public int[] tmcMsgIds;
    public NavRectangle boundingRectangle;
    public RouteSectionInfo[] detours;

    public RgRouteCostChangeInformation() {
        this.oldRoute = null;
        this.newRoute = null;
        this.newRouteRecommended = false;
        this.tmcMsgId = 0;
        this.tmcMsgIds = null;
        this.boundingRectangle = null;
        this.detours = null;
    }

    public RgRouteCostChangeInformation(CalculatedRouteListElement calculatedRouteListElement, CalculatedRouteListElement calculatedRouteListElement2, boolean bl, int n, int[] nArray, NavRectangle navRectangle, RouteSectionInfo[] routeSectionInfoArray) {
        this.oldRoute = calculatedRouteListElement;
        this.newRoute = calculatedRouteListElement2;
        this.newRouteRecommended = bl;
        this.tmcMsgId = n;
        this.tmcMsgIds = nArray;
        this.boundingRectangle = navRectangle;
        this.detours = routeSectionInfoArray;
    }

    public CalculatedRouteListElement getOldRoute() {
        return this.oldRoute;
    }

    public CalculatedRouteListElement getNewRoute() {
        return this.newRoute;
    }

    public boolean isNewRouteRecommended() {
        return this.newRouteRecommended;
    }

    public int getTmcMsgId() {
        return this.tmcMsgId;
    }

    public int[] getTmcMsgIds() {
        return this.tmcMsgIds;
    }

    public NavRectangle getBoundingRectangle() {
        return this.boundingRectangle;
    }

    public RouteSectionInfo[] getDetours() {
        return this.detours;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(3300);
        stringBuffer.append("RgRouteCostChangeInformation");
        stringBuffer.append('(');
        stringBuffer.append("oldRoute");
        stringBuffer.append('=');
        stringBuffer.append(this.oldRoute);
        stringBuffer.append(',');
        stringBuffer.append("newRoute");
        stringBuffer.append('=');
        stringBuffer.append(this.newRoute);
        stringBuffer.append(',');
        stringBuffer.append("newRouteRecommended");
        stringBuffer.append('=');
        stringBuffer.append(this.newRouteRecommended);
        stringBuffer.append(',');
        stringBuffer.append("tmcMsgId");
        stringBuffer.append('=');
        stringBuffer.append(this.tmcMsgId);
        stringBuffer.append(',');
        stringBuffer.append("tmcMsgIds");
        stringBuffer.append('[');
        if (this.tmcMsgIds != null) {
            stringBuffer.append(this.tmcMsgIds.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.tmcMsgIds != null) {
            n3 = this.tmcMsgIds.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.tmcMsgIds[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.tmcMsgIds);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("boundingRectangle");
        stringBuffer.append('=');
        stringBuffer.append(this.boundingRectangle);
        stringBuffer.append(',');
        stringBuffer.append("detours");
        stringBuffer.append('[');
        if (this.detours != null) {
            stringBuffer.append(this.detours.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.detours != null) {
            n3 = this.detours.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.detours[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.detours);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


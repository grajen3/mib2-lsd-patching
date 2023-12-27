/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class NavRouteListData {
    public NavRouteListDataIcon[] icons;
    public int startDistance;
    public int endDistance;
    public int remainingTravelTime;
    public int timeLagToNextDest;
    public String streetname;
    public boolean inProgressData;
    public long motorwayLength;
    public long tollLength;
    public long tollCostAmount;
    public int tollCostCurrency;
    public boolean tunnelOnWay;
    public boolean ferryOnWay;
    public boolean timeRestricted;
    public boolean carTrainOnWay;
    public boolean seasonalRestricted;
    public boolean vignetteNeededOnWay;
    public int remainingTravelTimeStatus;

    public NavRouteListData() {
        this.icons = null;
        this.startDistance = 0;
        this.endDistance = 0;
        this.remainingTravelTime = 0;
        this.timeLagToNextDest = 0;
        this.streetname = null;
        this.inProgressData = false;
        this.motorwayLength = 0L;
        this.tollLength = 0L;
        this.tollCostAmount = 0L;
        this.tollCostCurrency = 0;
        this.tunnelOnWay = false;
        this.ferryOnWay = false;
        this.timeRestricted = false;
        this.carTrainOnWay = false;
        this.seasonalRestricted = false;
        this.vignetteNeededOnWay = false;
        this.remainingTravelTimeStatus = 0;
    }

    public NavRouteListData(NavRouteListDataIcon[] navRouteListDataIconArray, int n, int n2, int n3, int n4, String string, boolean bl, long l, long l2, long l3, int n5, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n6) {
        this.icons = navRouteListDataIconArray;
        this.startDistance = n;
        this.endDistance = n2;
        this.remainingTravelTime = n3;
        this.timeLagToNextDest = n4;
        this.streetname = string;
        this.inProgressData = bl;
        this.motorwayLength = l;
        this.tollLength = l2;
        this.tollCostAmount = l3;
        this.tollCostCurrency = n5;
        this.tunnelOnWay = bl2;
        this.ferryOnWay = bl3;
        this.timeRestricted = bl4;
        this.carTrainOnWay = bl5;
        this.seasonalRestricted = bl6;
        this.vignetteNeededOnWay = bl7;
        this.remainingTravelTimeStatus = n6;
    }

    public NavRouteListDataIcon[] getIcons() {
        return this.icons;
    }

    public int getStartDistance() {
        return this.startDistance;
    }

    public int getEndDistance() {
        return this.endDistance;
    }

    public int getRemainingTravelTime() {
        return this.remainingTravelTime;
    }

    public int getTimeLagToNextDest() {
        return this.timeLagToNextDest;
    }

    public String getStreetname() {
        return this.streetname;
    }

    public boolean isInProgressData() {
        return this.inProgressData;
    }

    public long getMotorwayLength() {
        return this.motorwayLength;
    }

    public long getTollLength() {
        return this.tollLength;
    }

    public long getTollCostAmount() {
        return this.tollCostAmount;
    }

    public int getTollCostCurrency() {
        return this.tollCostCurrency;
    }

    public boolean isTunnelOnWay() {
        return this.tunnelOnWay;
    }

    public boolean isFerryOnWay() {
        return this.ferryOnWay;
    }

    public boolean isTimeRestricted() {
        return this.timeRestricted;
    }

    public boolean isCarTrainOnWay() {
        return this.carTrainOnWay;
    }

    public boolean isSeasonalRestricted() {
        return this.seasonalRestricted;
    }

    public boolean isVignetteNeededOnWay() {
        return this.vignetteNeededOnWay;
    }

    public int getRemainingTravelTimeStatus() {
        return this.remainingTravelTimeStatus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("NavRouteListData");
        stringBuffer.append('(');
        stringBuffer.append("icons");
        stringBuffer.append('[');
        if (this.icons != null) {
            stringBuffer.append(this.icons.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.icons != null) {
            int n = this.icons.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.icons[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.icons);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("startDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.startDistance);
        stringBuffer.append(',');
        stringBuffer.append("endDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.endDistance);
        stringBuffer.append(',');
        stringBuffer.append("remainingTravelTime");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTravelTime);
        stringBuffer.append(',');
        stringBuffer.append("timeLagToNextDest");
        stringBuffer.append('=');
        stringBuffer.append(this.timeLagToNextDest);
        stringBuffer.append(',');
        stringBuffer.append("streetname");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetname);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("inProgressData");
        stringBuffer.append('=');
        stringBuffer.append(this.inProgressData);
        stringBuffer.append(',');
        stringBuffer.append("motorwayLength");
        stringBuffer.append('=');
        stringBuffer.append(this.motorwayLength);
        stringBuffer.append(',');
        stringBuffer.append("tollLength");
        stringBuffer.append('=');
        stringBuffer.append(this.tollLength);
        stringBuffer.append(',');
        stringBuffer.append("tollCostAmount");
        stringBuffer.append('=');
        stringBuffer.append(this.tollCostAmount);
        stringBuffer.append(',');
        stringBuffer.append("tollCostCurrency");
        stringBuffer.append('=');
        stringBuffer.append(this.tollCostCurrency);
        stringBuffer.append(',');
        stringBuffer.append("tunnelOnWay");
        stringBuffer.append('=');
        stringBuffer.append(this.tunnelOnWay);
        stringBuffer.append(',');
        stringBuffer.append("ferryOnWay");
        stringBuffer.append('=');
        stringBuffer.append(this.ferryOnWay);
        stringBuffer.append(',');
        stringBuffer.append("timeRestricted");
        stringBuffer.append('=');
        stringBuffer.append(this.timeRestricted);
        stringBuffer.append(',');
        stringBuffer.append("carTrainOnWay");
        stringBuffer.append('=');
        stringBuffer.append(this.carTrainOnWay);
        stringBuffer.append(',');
        stringBuffer.append("seasonalRestricted");
        stringBuffer.append('=');
        stringBuffer.append(this.seasonalRestricted);
        stringBuffer.append(',');
        stringBuffer.append("vignetteNeededOnWay");
        stringBuffer.append('=');
        stringBuffer.append(this.vignetteNeededOnWay);
        stringBuffer.append(',');
        stringBuffer.append("remainingTravelTimeStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTravelTimeStatus);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


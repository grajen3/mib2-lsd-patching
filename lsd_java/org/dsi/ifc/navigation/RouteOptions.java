/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class RouteOptions {
    public int routeType;
    public int weighting;
    public int hybridMode;
    public int dynamic;
    public int dynamicSpeedFlow;
    public int dynamicTrafficPattern;
    public int dynamicTrafficPatternOnline;
    public int dynamicTrafficPatternRecorded;
    public int motorways;
    public int ferries;
    public int tollroads;
    public int tollroadsCostPenalty;
    public int tunnels;
    public int leftRightTurn;
    public int slopes;
    public int slopesMaxFactor;
    public int vignette;
    public int[] vignetteCountryList;
    public int cityMaut;
    public int[] cityMautList;
    public int cartrain;
    public int timeDomain;
    public int seasonalTimeDomain;
    public int unpaved;
    public int residentialAreaHandling;
    public int trailer;
    public int hovCarPoolsLane;
    public int border;
    public int ipd;
    public int trail;
    public int waypointMode;
    public int economicTurns;
    public int styleId;

    public RouteOptions() {
        this.routeType = 0;
        this.weighting = 0;
        this.hybridMode = 0;
        this.dynamic = 0;
        this.dynamicSpeedFlow = 0;
        this.dynamicTrafficPattern = 0;
        this.dynamicTrafficPatternOnline = 0;
        this.dynamicTrafficPatternRecorded = 0;
        this.motorways = 0;
        this.ferries = 0;
        this.tollroads = 0;
        this.tollroadsCostPenalty = 0;
        this.tunnels = 0;
        this.leftRightTurn = 0;
        this.slopes = 0;
        this.slopesMaxFactor = 0;
        this.vignette = 0;
        this.vignetteCountryList = null;
        this.cityMaut = 0;
        this.cityMautList = null;
        this.cartrain = 0;
        this.timeDomain = 0;
        this.seasonalTimeDomain = 0;
        this.unpaved = 0;
        this.residentialAreaHandling = 0;
        this.trailer = 0;
        this.hovCarPoolsLane = 0;
        this.border = 0;
        this.ipd = 0;
        this.trail = 0;
        this.waypointMode = 2;
        this.economicTurns = 0;
        this.styleId = 0;
    }

    public RouteOptions(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int[] nArray, int n18, int[] nArray2, int n19, int n20, int n21, int n22, int n23, int n24, int n25, int n26, int n27, int n28, int n29, int n30, int n31) {
        this.routeType = n;
        this.weighting = n2;
        this.hybridMode = n3;
        this.dynamic = n4;
        this.dynamicSpeedFlow = n5;
        this.dynamicTrafficPattern = n6;
        this.dynamicTrafficPatternOnline = n7;
        this.dynamicTrafficPatternRecorded = n8;
        this.motorways = n9;
        this.ferries = n10;
        this.tollroads = n11;
        this.tollroadsCostPenalty = n12;
        this.tunnels = n13;
        this.leftRightTurn = n14;
        this.slopes = n15;
        this.slopesMaxFactor = n16;
        this.vignette = n17;
        this.vignetteCountryList = nArray;
        this.cityMaut = n18;
        this.cityMautList = nArray2;
        this.cartrain = n19;
        this.timeDomain = n20;
        this.seasonalTimeDomain = n21;
        this.unpaved = n22;
        this.residentialAreaHandling = n23;
        this.trailer = n24;
        this.hovCarPoolsLane = n25;
        this.border = n26;
        this.ipd = n27;
        this.trail = n28;
        this.waypointMode = n29;
        this.economicTurns = n30;
        this.styleId = n31;
    }

    public int getRouteType() {
        return this.routeType;
    }

    public int getWeighting() {
        return this.weighting;
    }

    public int getHybridMode() {
        return this.hybridMode;
    }

    public int getDynamic() {
        return this.dynamic;
    }

    public int getDynamicSpeedFlow() {
        return this.dynamicSpeedFlow;
    }

    public int getDynamicTrafficPattern() {
        return this.dynamicTrafficPattern;
    }

    public int getDynamicTrafficPatternOnline() {
        return this.dynamicTrafficPatternOnline;
    }

    public int getDynamicTrafficPatternRecorded() {
        return this.dynamicTrafficPatternRecorded;
    }

    public int getMotorways() {
        return this.motorways;
    }

    public int getFerries() {
        return this.ferries;
    }

    public int getTollroads() {
        return this.tollroads;
    }

    public int getTollroadsCostPenalty() {
        return this.tollroadsCostPenalty;
    }

    public int getTunnels() {
        return this.tunnels;
    }

    public int getLeftRightTurn() {
        return this.leftRightTurn;
    }

    public int getSlopes() {
        return this.slopes;
    }

    public int getSlopesMaxFactor() {
        return this.slopesMaxFactor;
    }

    public int getVignette() {
        return this.vignette;
    }

    public int[] getVignetteCountryList() {
        return this.vignetteCountryList;
    }

    public int getCityMaut() {
        return this.cityMaut;
    }

    public int[] getCityMautList() {
        return this.cityMautList;
    }

    public int getCartrain() {
        return this.cartrain;
    }

    public int getTimeDomain() {
        return this.timeDomain;
    }

    public int getSeasonalTimeDomain() {
        return this.seasonalTimeDomain;
    }

    public int getUnpaved() {
        return this.unpaved;
    }

    public int getResidentialAreaHandling() {
        return this.residentialAreaHandling;
    }

    public int getTrailer() {
        return this.trailer;
    }

    public int getHovCarPoolsLane() {
        return this.hovCarPoolsLane;
    }

    public int getBorder() {
        return this.border;
    }

    public int getIpd() {
        return this.ipd;
    }

    public int getTrail() {
        return this.trail;
    }

    public int getWaypointMode() {
        return this.waypointMode;
    }

    public int getEconomicTurns() {
        return this.economicTurns;
    }

    public int getStyleId() {
        return this.styleId;
    }

    public void setRouteType(int n) {
        this.routeType = n;
    }

    public void setWeighting(int n) {
        this.weighting = n;
    }

    public void setHybridMode(int n) {
        this.hybridMode = n;
    }

    public void setDynamic(int n) {
        this.dynamic = n;
    }

    public void setDynamicSpeedFlow(int n) {
        this.dynamicSpeedFlow = n;
    }

    public void setDynamicTrafficPattern(int n) {
        this.dynamicTrafficPattern = n;
    }

    public void setDynamicTrafficPatternOnline(int n) {
        this.dynamicTrafficPatternOnline = n;
    }

    public void setDynamicTrafficPatternRecorded(int n) {
        this.dynamicTrafficPatternRecorded = n;
    }

    public void setMotorways(int n) {
        this.motorways = n;
    }

    public void setFerries(int n) {
        this.ferries = n;
    }

    public void setTollroads(int n) {
        this.tollroads = n;
    }

    public void setTollroadsCostPenalty(int n) {
        this.tollroadsCostPenalty = n;
    }

    public void setTunnels(int n) {
        this.tunnels = n;
    }

    public void setLeftRightTurn(int n) {
        this.leftRightTurn = n;
    }

    public void setSlopes(int n) {
        this.slopes = n;
    }

    public void setSlopesMaxFactor(int n) {
        this.slopesMaxFactor = n;
    }

    public void setVignette(int n) {
        this.vignette = n;
    }

    public void setVignetteCountryList(int[] nArray) {
        this.vignetteCountryList = nArray;
    }

    public void setCityMaut(int n) {
        this.cityMaut = n;
    }

    public void setCityMautList(int[] nArray) {
        this.cityMautList = nArray;
    }

    public void setCartrain(int n) {
        this.cartrain = n;
    }

    public void setTimeDomain(int n) {
        this.timeDomain = n;
    }

    public void setSeasonalTimeDomain(int n) {
        this.seasonalTimeDomain = n;
    }

    public void setUnpaved(int n) {
        this.unpaved = n;
    }

    public void setResidentialAreaHandling(int n) {
        this.residentialAreaHandling = n;
    }

    public void setTrailer(int n) {
        this.trailer = n;
    }

    public void setHovCarPoolsLane(int n) {
        this.hovCarPoolsLane = n;
    }

    public void setBorder(int n) {
        this.border = n;
    }

    public void setIpd(int n) {
        this.ipd = n;
    }

    public void setTrail(int n) {
        this.trail = n;
    }

    public void setWaypointMode(int n) {
        this.waypointMode = n;
    }

    public void setEconomicTurns(int n) {
        this.economicTurns = n;
    }

    public void setStyleId(int n) {
        this.styleId = n;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1850);
        stringBuffer.append("RouteOptions");
        stringBuffer.append('(');
        stringBuffer.append("routeType");
        stringBuffer.append('=');
        stringBuffer.append(this.routeType);
        stringBuffer.append(',');
        stringBuffer.append("weighting");
        stringBuffer.append('=');
        stringBuffer.append(this.weighting);
        stringBuffer.append(',');
        stringBuffer.append("hybridMode");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridMode);
        stringBuffer.append(',');
        stringBuffer.append("dynamic");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamic);
        stringBuffer.append(',');
        stringBuffer.append("dynamicSpeedFlow");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamicSpeedFlow);
        stringBuffer.append(',');
        stringBuffer.append("dynamicTrafficPattern");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamicTrafficPattern);
        stringBuffer.append(',');
        stringBuffer.append("dynamicTrafficPatternOnline");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamicTrafficPatternOnline);
        stringBuffer.append(',');
        stringBuffer.append("dynamicTrafficPatternRecorded");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamicTrafficPatternRecorded);
        stringBuffer.append(',');
        stringBuffer.append("motorways");
        stringBuffer.append('=');
        stringBuffer.append(this.motorways);
        stringBuffer.append(',');
        stringBuffer.append("ferries");
        stringBuffer.append('=');
        stringBuffer.append(this.ferries);
        stringBuffer.append(',');
        stringBuffer.append("tollroads");
        stringBuffer.append('=');
        stringBuffer.append(this.tollroads);
        stringBuffer.append(',');
        stringBuffer.append("tollroadsCostPenalty");
        stringBuffer.append('=');
        stringBuffer.append(this.tollroadsCostPenalty);
        stringBuffer.append(',');
        stringBuffer.append("tunnels");
        stringBuffer.append('=');
        stringBuffer.append(this.tunnels);
        stringBuffer.append(',');
        stringBuffer.append("leftRightTurn");
        stringBuffer.append('=');
        stringBuffer.append(this.leftRightTurn);
        stringBuffer.append(',');
        stringBuffer.append("slopes");
        stringBuffer.append('=');
        stringBuffer.append(this.slopes);
        stringBuffer.append(',');
        stringBuffer.append("slopesMaxFactor");
        stringBuffer.append('=');
        stringBuffer.append(this.slopesMaxFactor);
        stringBuffer.append(',');
        stringBuffer.append("vignette");
        stringBuffer.append('=');
        stringBuffer.append(this.vignette);
        stringBuffer.append(',');
        stringBuffer.append("vignetteCountryList");
        stringBuffer.append('[');
        if (this.vignetteCountryList != null) {
            stringBuffer.append(this.vignetteCountryList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.vignetteCountryList != null) {
            n3 = this.vignetteCountryList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.vignetteCountryList[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.vignetteCountryList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("cityMaut");
        stringBuffer.append('=');
        stringBuffer.append(this.cityMaut);
        stringBuffer.append(',');
        stringBuffer.append("cityMautList");
        stringBuffer.append('[');
        if (this.cityMautList != null) {
            stringBuffer.append(this.cityMautList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.cityMautList != null) {
            n3 = this.cityMautList.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.cityMautList[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.cityMautList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("cartrain");
        stringBuffer.append('=');
        stringBuffer.append(this.cartrain);
        stringBuffer.append(',');
        stringBuffer.append("timeDomain");
        stringBuffer.append('=');
        stringBuffer.append(this.timeDomain);
        stringBuffer.append(',');
        stringBuffer.append("seasonalTimeDomain");
        stringBuffer.append('=');
        stringBuffer.append(this.seasonalTimeDomain);
        stringBuffer.append(',');
        stringBuffer.append("unpaved");
        stringBuffer.append('=');
        stringBuffer.append(this.unpaved);
        stringBuffer.append(',');
        stringBuffer.append("residentialAreaHandling");
        stringBuffer.append('=');
        stringBuffer.append(this.residentialAreaHandling);
        stringBuffer.append(',');
        stringBuffer.append("trailer");
        stringBuffer.append('=');
        stringBuffer.append(this.trailer);
        stringBuffer.append(',');
        stringBuffer.append("hovCarPoolsLane");
        stringBuffer.append('=');
        stringBuffer.append(this.hovCarPoolsLane);
        stringBuffer.append(',');
        stringBuffer.append("border");
        stringBuffer.append('=');
        stringBuffer.append(this.border);
        stringBuffer.append(',');
        stringBuffer.append("ipd");
        stringBuffer.append('=');
        stringBuffer.append(this.ipd);
        stringBuffer.append(',');
        stringBuffer.append("trail");
        stringBuffer.append('=');
        stringBuffer.append(this.trail);
        stringBuffer.append(',');
        stringBuffer.append("waypointMode");
        stringBuffer.append('=');
        stringBuffer.append(this.waypointMode);
        stringBuffer.append(',');
        stringBuffer.append("economicTurns");
        stringBuffer.append('=');
        stringBuffer.append(this.economicTurns);
        stringBuffer.append(',');
        stringBuffer.append("styleId");
        stringBuffer.append('=');
        stringBuffer.append(this.styleId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


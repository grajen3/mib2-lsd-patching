/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.pnav.transformer;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class NavigationPnavLikelyDestinationListCollector {
    LikelyDestination likelyDest;
    ResourceLocator routeColorResourceLocator;

    public NavigationPnavLikelyDestinationListCollector(LikelyDestination likelyDestination, ResourceLocator resourceLocator) {
        this.likelyDest = likelyDestination;
        this.routeColorResourceLocator = resourceLocator;
    }

    public int getCalculationState() {
        return this.likelyDest.getCalculationState();
    }

    public int getCalculationProgress() {
        return this.likelyDest.getCalculationProgress();
    }

    public int getLikelihood() {
        return this.likelyDest.getLikelihood();
    }

    public long getDistance() {
        return this.likelyDest.getDistance();
    }

    public long getRemainingTravelTime() {
        return this.likelyDest.getRemainingTravelTime();
    }

    public long getTimeDelay() {
        return this.likelyDest.getTimeDelay();
    }

    public int getRouteColor() {
        return this.likelyDest.getRouteColor();
    }

    public int getRouteColorIconId() {
        return this.likelyDest.getRouteColorIconId();
    }

    public NavLocation getDestination() {
        return this.likelyDest.getDestination();
    }

    public NavSegmentID getSegmentId() {
        return this.likelyDest.getSegmentId();
    }

    public ResourceLocator getRouteColorIcon() {
        return this.routeColorResourceLocator;
    }

    public void setRouteColorIconIdResourceLocator(ResourceLocator resourceLocator) {
        this.routeColorResourceLocator = resourceLocator;
    }
}


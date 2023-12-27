/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.tourmode.transformer;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.RouteDestination;

public class NavigationTourModeTourDestinationCollector {
    public ILocationWrapper routeLocation;
    private int dtd;
    private int etaD;
    private int etaH;
    private int etaM;
    private RouteDestination destination;
    private boolean passed;
    private ResourceLocator poiIcon;
    private FixFormatterFieldData fffd;
    private int tollCost;
    private int tollLength;
    private int tollCurrency;

    public NavigationTourModeTourDestinationCollector(RouteDestination routeDestination, int n, int n2) {
        this.routeLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(routeDestination.getRouteLocation());
        this.destination = routeDestination;
        this.fffd = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(this.routeLocation);
    }

    public int getTollCost() {
        return this.tollCost;
    }

    public void setTollCost(int n) {
        this.tollCost = n;
    }

    public int getTollLength() {
        return this.tollLength;
    }

    public void setTollLength(int n) {
        this.tollLength = n;
    }

    public int getTollCurrency() {
        return this.tollCurrency;
    }

    public void setTollCurrency(int n) {
        this.tollCurrency = n;
    }

    public int getDtd() {
        return this.dtd;
    }

    public void setDtd(int n) {
        this.dtd = n;
    }

    public int getEtaD() {
        return this.etaD;
    }

    public void setEtaD(int n) {
        this.etaD = n;
    }

    public int getEtaH() {
        return this.etaH;
    }

    public void setEtaH(int n) {
        this.etaH = n;
    }

    public int getEtaM() {
        return this.etaM;
    }

    public void setEtaM(int n) {
        this.etaM = n;
    }

    public RouteDestination getDestination() {
        return this.destination;
    }

    public void setDestination(RouteDestination routeDestination) {
        this.destination = routeDestination;
        this.routeLocation.setLocation(routeDestination.getRouteLocation());
        this.fffd = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(this.routeLocation);
        this.poiIcon = null;
    }

    public boolean isPassed() {
        return this.passed;
    }

    public void setPassed(boolean bl) {
        this.passed = bl;
    }

    public ResourceLocator getPoiIcon() {
        return this.poiIcon;
    }

    public void setPoiIcon(ResourceLocator resourceLocator) {
        this.poiIcon = resourceLocator;
    }

    public FixFormatterFieldData getFixFormatterFieldData() {
        return this.fffd;
    }

    public boolean isRubberbandDestination() {
        return this.destination.getDestinationType() == 2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NavigationTourModeTourDestinationCollector [routeLocation=");
        stringBuffer.append(this.routeLocation);
        stringBuffer.append(", dtd=");
        stringBuffer.append(this.dtd);
        stringBuffer.append(", etaD=");
        stringBuffer.append(this.etaD);
        stringBuffer.append(", etaH=");
        stringBuffer.append(this.etaH);
        stringBuffer.append(", etaM=");
        stringBuffer.append(this.etaM);
        stringBuffer.append(", destination=");
        stringBuffer.append(this.destination);
        stringBuffer.append(", passed=");
        stringBuffer.append(this.passed);
        stringBuffer.append(", poiIcon=");
        stringBuffer.append(this.poiIcon);
        stringBuffer.append(", fffd=");
        stringBuffer.append(this.fffd);
        stringBuffer.append(", tollCost=");
        stringBuffer.append(this.tollCost);
        stringBuffer.append(", tollLength=");
        stringBuffer.append(this.tollLength);
        stringBuffer.append(", tollCurrency=");
        stringBuffer.append(this.tollCurrency);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main.rc;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.main.rc.ASLCalculatedRouteListElement;
import de.vw.mib.asl.internal.navigation.guidance.transformer.AlternativeRouteIconsCollector;
import de.vw.mib.asl.internal.navigation.guidance.transformer.CalculatedRouteDetailsCollector;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RCAlternativeRouteDetailsModelNotifier {
    private CalculatedRouteDetailsCollector[] routeDetailsCollectors;
    private AlternativeRouteIconsCollector[] alternativeRouteIconsCollector;

    public void resetToDefaultValues() {
        int n;
        int n2 = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes();
        this.routeDetailsCollectors = new CalculatedRouteDetailsCollector[n2];
        for (n = 0; n < this.routeDetailsCollectors.length; ++n) {
            this.routeDetailsCollectors[n] = new CalculatedRouteDetailsCollector();
        }
        ListManager.getGenericASLList(822).updateList(this.routeDetailsCollectors);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(107)) {
            this.alternativeRouteIconsCollector = new AlternativeRouteIconsCollector[4];
            this.alternativeRouteIconsCollector[0] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[0].icons.length; ++n) {
                this.alternativeRouteIconsCollector[0].icons[n] = 3;
            }
            this.alternativeRouteIconsCollector[1] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[1].icons.length; ++n) {
                this.alternativeRouteIconsCollector[1].icons[n] = 9;
            }
            this.alternativeRouteIconsCollector[2] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[2].icons.length; ++n) {
                this.alternativeRouteIconsCollector[2].icons[n] = 7;
            }
            this.alternativeRouteIconsCollector[3] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[3].icons.length; ++n) {
                this.alternativeRouteIconsCollector[3].icons[n] = 5;
            }
        } else {
            this.alternativeRouteIconsCollector = new AlternativeRouteIconsCollector[3];
            this.alternativeRouteIconsCollector[0] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[0].icons.length; ++n) {
                this.alternativeRouteIconsCollector[0].icons[n] = 1;
            }
            this.alternativeRouteIconsCollector[1] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[1].icons.length; ++n) {
                this.alternativeRouteIconsCollector[1].icons[n] = 3;
            }
            this.alternativeRouteIconsCollector[2] = new AlternativeRouteIconsCollector();
            for (n = 0; n < this.alternativeRouteIconsCollector[2].icons.length; ++n) {
                this.alternativeRouteIconsCollector[2].icons[n] = 5;
            }
        }
        ListManager.getGenericASLList(824).updateList(this.alternativeRouteIconsCollector);
    }

    public void updateDetails(CalculatedRouteListElement calculatedRouteListElement, int n) {
        this.routeDetailsCollectors[n].myDTD = (int)calculatedRouteListElement.distance;
        this.setRTT((int)calculatedRouteListElement.eta, n);
        this.routeDetailsCollectors[n].myTollCost = (int)calculatedRouteListElement.tollCostAmount;
        this.routeDetailsCollectors[n].myTollLength = (int)calculatedRouteListElement.tollLength;
        this.routeDetailsCollectors[n].myTollCurrency = this.getCurrency(calculatedRouteListElement.tollCostCurrency);
        this.routeDetailsCollectors[n].myFirstMotorwayEntry = this.getFirstMotorwayEntry(calculatedRouteListElement);
        this.routeDetailsCollectors[n].myLastMotorwayExit = this.getLastMotorwayExit(calculatedRouteListElement);
    }

    private void setRTT(int n, int n2) {
        int n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttMinutes(n);
        int n4 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttHours(n);
        if (n3 > 0 && n3 % 60 == 0) {
            ++n4;
            n3 = 0;
        }
        this.routeDetailsCollectors[n2].myTTH = n4;
        this.routeDetailsCollectors[n2].myTTM = n3;
    }

    public void updateDetails(ASLCalculatedRouteListElement aSLCalculatedRouteListElement) {
        int n = aSLCalculatedRouteListElement.getModelCalculationIndex();
        CalculatedRouteListElement calculatedRouteListElement = aSLCalculatedRouteListElement.getCalculatedRouteListElement();
        this.routeDetailsCollectors[n].myDTD = (int)calculatedRouteListElement.distance;
        this.setRTT((int)calculatedRouteListElement.eta, n);
        this.routeDetailsCollectors[n].myTollCost = (int)calculatedRouteListElement.tollCostAmount;
        this.routeDetailsCollectors[n].myTollLength = (int)calculatedRouteListElement.tollLength;
        this.routeDetailsCollectors[n].myTollCurrency = this.getCurrency(calculatedRouteListElement.tollCostCurrency);
        this.routeDetailsCollectors[n].myCalculationState = aSLCalculatedRouteListElement.getCalculationStateId();
        this.routeDetailsCollectors[n].myProgress = aSLCalculatedRouteListElement.getCalculationProgress();
        this.routeDetailsCollectors[n].myFirstMotorwayEntry = this.getFirstMotorwayEntry(calculatedRouteListElement);
        this.routeDetailsCollectors[n].myLastMotorwayExit = this.getLastMotorwayExit(calculatedRouteListElement);
    }

    private String getLastMotorwayExit(CalculatedRouteListElement calculatedRouteListElement) {
        String string = "";
        if (calculatedRouteListElement != null && calculatedRouteListElement.additionalRouteDataKeys != null && calculatedRouteListElement.additionalRouteDataValues != null && calculatedRouteListElement.additionalRouteDataKeys.length == calculatedRouteListElement.additionalRouteDataValues.length) {
            for (int i2 = 0; i2 < calculatedRouteListElement.additionalRouteDataKeys.length; ++i2) {
                if (calculatedRouteListElement.additionalRouteDataKeys[i2] != 2) continue;
                string = calculatedRouteListElement.additionalRouteDataValues[i2];
                break;
            }
        }
        return string;
    }

    private String getFirstMotorwayEntry(CalculatedRouteListElement calculatedRouteListElement) {
        String string = "";
        if (calculatedRouteListElement != null && calculatedRouteListElement.additionalRouteDataKeys != null && calculatedRouteListElement.additionalRouteDataValues != null && calculatedRouteListElement.additionalRouteDataKeys.length == calculatedRouteListElement.additionalRouteDataValues.length) {
            for (int i2 = 0; i2 < calculatedRouteListElement.additionalRouteDataKeys.length; ++i2) {
                if (calculatedRouteListElement.additionalRouteDataKeys[i2] != 1) continue;
                string = calculatedRouteListElement.additionalRouteDataValues[i2];
                break;
            }
        }
        return string;
    }

    private int getCurrency(int n) {
        int n2 = 0;
        switch (n) {
            case 2: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    public void updateIcons(CalculatedRouteListElement calculatedRouteListElement, int n) {
        int n2 = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes();
        int[] nArray = new int[n2];
        int n3 = 0;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(107)) {
            this.alternativeRouteIconsCollector[0].icons[n] = calculatedRouteListElement.getTollLength() > 0L ? 2 : 3;
            this.alternativeRouteIconsCollector[1].icons[n] = calculatedRouteListElement.motorwayLength > 0L ? 8 : 9;
            this.alternativeRouteIconsCollector[2].icons[n] = calculatedRouteListElement.hasTunnel ? 6 : 7;
            this.alternativeRouteIconsCollector[3].icons[n] = calculatedRouteListElement.hasFerry || calculatedRouteListElement.hasCarTrain ? 4 : 5;
        } else {
            if (calculatedRouteListElement.isNeedsVignette()) {
                nArray[n3] = 0;
                ++n3;
            }
            if (calculatedRouteListElement.getTollLength() > 0L) {
                nArray[n3] = 2;
                ++n3;
            }
            if (calculatedRouteListElement.hasFerry || calculatedRouteListElement.hasCarTrain) {
                nArray[n3] = 4;
                ++n3;
            }
            if (n3 < RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() && calculatedRouteListElement.hasTunnel) {
                nArray[n3] = 6;
                ++n3;
            }
            if (n3 < RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() && calculatedRouteListElement.motorwayLength > 0L) {
                nArray[n3] = 8;
                ++n3;
            }
            if (n3 < RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() && !calculatedRouteListElement.isNeedsVignette()) {
                nArray[n3] = 1;
                ++n3;
            }
            if (n3 < RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() && calculatedRouteListElement.getTollLength() <= 0L) {
                nArray[n3] = 3;
                ++n3;
            }
            if (!(n3 >= RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() || calculatedRouteListElement.hasFerry && calculatedRouteListElement.hasCarTrain)) {
                nArray[n3] = 5;
                ++n3;
            } else if (n3 < RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() && !calculatedRouteListElement.hasTunnel) {
                nArray[n3] = 7;
                ++n3;
            } else if (n3 < RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes() && calculatedRouteListElement.motorwayLength <= 0L) {
                nArray[n3] = 9;
            }
            for (int i2 = 0; i2 < this.alternativeRouteIconsCollector.length; ++i2) {
                this.alternativeRouteIconsCollector[i2].icons[n] = nArray[i2];
            }
        }
    }

    public void notifyModel() {
        ListManager.getGenericASLList(822).updateList(this.routeDetailsCollectors);
        ListManager.getGenericASLList(824).updateList(this.alternativeRouteIconsCollector);
    }
}


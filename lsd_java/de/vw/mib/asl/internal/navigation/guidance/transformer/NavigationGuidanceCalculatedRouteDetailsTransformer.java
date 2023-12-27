/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.navigation.guidance.transformer.CalculatedRouteDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.AbstractNavigationGuidanceCalculatedRouteDetailsTransformer;

public class NavigationGuidanceCalculatedRouteDetailsTransformer
extends AbstractNavigationGuidanceCalculatedRouteDetailsTransformer {
    @Override
    public int getInt(int n, Object object) {
        CalculatedRouteDetailsCollector calculatedRouteDetailsCollector = (CalculatedRouteDetailsCollector)object;
        switch (n) {
            case 0: {
                return calculatedRouteDetailsCollector.myTTH;
            }
            case 1: {
                return calculatedRouteDetailsCollector.myTTM;
            }
            case 2: {
                return calculatedRouteDetailsCollector.myDTD;
            }
            case 3: {
                return calculatedRouteDetailsCollector.myTollCost;
            }
            case 4: {
                return calculatedRouteDetailsCollector.myTollLength;
            }
            case 6: {
                return calculatedRouteDetailsCollector.myProgress;
            }
            case 5: {
                return calculatedRouteDetailsCollector.myCalculationState;
            }
            case 11: {
                return calculatedRouteDetailsCollector.myTollCurrency;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        CalculatedRouteDetailsCollector calculatedRouteDetailsCollector = (CalculatedRouteDetailsCollector)object;
        switch (n) {
            case 9: {
                return calculatedRouteDetailsCollector.myFirstMotorwayEntry;
            }
            case 10: {
                return calculatedRouteDetailsCollector.myLastMotorwayExit;
            }
        }
        throw new IllegalArgumentException();
    }
}


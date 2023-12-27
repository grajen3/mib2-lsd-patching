/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions.variant;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.routeoptions.PersistableRouteOptionsSetup;
import de.vw.mib.asl.internal.navigation.routeoptions.util.RouteOptionsHelper;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessor;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.RouteOptions;

public class PersistableRouteOptionsAccessorImpl
extends PersistableRouteOptionsAccessor {
    @Override
    public void setRouteCalcType(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        Object object;
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            object = ServiceManager.logger.trace(16384);
            object.append(super.getClass());
            object.append(": ");
            object.append("setRouteCalcType() ");
            object.append(n);
            object.log();
        }
        persistableRouteOptionsSetup.setRouteCalculationType(n);
        persistableRouteOptionsSetup.updatePropertyRouteCalculationType();
        object = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        switch (n) {
            case 0: {
                ((RouteOptions)object).routeType = 0;
                break;
            }
            case 1: {
                ((RouteOptions)object).routeType = 1;
                break;
            }
            case 2: {
                ((RouteOptions)object).routeType = 7;
                break;
            }
        }
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions((RouteOptions)object);
    }

    @Override
    public RouteOptions[] getAlternativeRouteOptions(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getAlternativeRouteOptions()");
        RouteOptions[] routeOptionsArray = new RouteOptions[3];
        RouteOptions routeOptions = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        routeOptionsArray[0] = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptionsArray[0].routeType = 7;
        routeOptionsArray[1] = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptionsArray[1].routeType = 0;
        routeOptionsArray[2] = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptionsArray[2].routeType = 1;
        return routeOptionsArray;
    }

    @Override
    public int[] getAlternativeRouteOptionsOrderDSI(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getAlternativeRouteOptionsOrderDSI()");
        int[] nArray = new int[]{2, 0, 1};
        return nArray;
    }

    @Override
    public int[] getAlternativeRouteOptionsOrderHMI() {
        this.trace("getAlternativeRouteOptionsOrderHMI()");
        int[] nArray = new int[]{2, 0, 1};
        return nArray;
    }

    @Override
    public int convertDsiRouteTypeToAslSetterRouteType(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("convertDsiRouteTypeToAslSetterRouteType()");
        int n = 0;
        RouteOptions routeOptions = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        switch (routeOptions.routeType) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 7: {
                n = 2;
                break;
            }
        }
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append("convertDsiRouteTypeToAslSetterRouteType() ");
            logMessage.append(n);
            logMessage.log();
        }
        return n;
    }
}


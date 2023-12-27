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

public class PersistableRouteOptionsAccessorJPNImpl
extends PersistableRouteOptionsAccessor {
    @Override
    public void setRouteCalcType(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        Object object;
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            object = ServiceManager.logger.trace(16384);
            object.append(super.getClass());
            object.append(": ");
            object.append("setRouteType() ");
            object.append(n);
            object.log();
        }
        persistableRouteOptionsSetup.setRouteCalculationType(n);
        persistableRouteOptionsSetup.updatePropertyRouteCalculationType();
        object = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        boolean[] blArray = persistableRouteOptionsSetup.getAvoidRoadTypes();
        switch (n) {
            case 0: {
                ((RouteOptions)object).routeType = 0;
                ((RouteOptions)object).motorways = 1;
                ((RouteOptions)object).tollroads = 1;
                blArray[0] = false;
                blArray[1] = false;
                break;
            }
            case 1: {
                ((RouteOptions)object).routeType = 1;
                ((RouteOptions)object).motorways = 1;
                ((RouteOptions)object).tollroads = 1;
                blArray[0] = false;
                blArray[1] = false;
                break;
            }
            case 2: {
                ((RouteOptions)object).routeType = 7;
                ((RouteOptions)object).motorways = 1;
                ((RouteOptions)object).tollroads = 1;
                blArray[0] = false;
                blArray[1] = false;
                break;
            }
            case 3: {
                ((RouteOptions)object).routeType = 7;
                ((RouteOptions)object).motorways = 1;
                ((RouteOptions)object).tollroads = 3;
                blArray[0] = false;
                blArray[1] = true;
                break;
            }
            case 5: {
                ((RouteOptions)object).routeType = 5;
                ((RouteOptions)object).motorways = 1;
                ((RouteOptions)object).tollroads = 1;
                blArray[0] = false;
                blArray[1] = false;
                break;
            }
        }
        persistableRouteOptionsSetup.setAvoidRoadTypes(blArray);
        persistableRouteOptionsSetup.updatePropertyAvoidRoadTypes();
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions((RouteOptions)object);
    }

    @Override
    public RouteOptions[] getAlternativeRouteOptions(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getAlternativeRouteOptions()");
        RouteOptions routeOptions = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        RouteOptions routeOptions2 = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptions2.routeType = 7;
        routeOptions2.motorways = 1;
        routeOptions2.tollroads = 1;
        RouteOptions routeOptions3 = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptions3.routeType = 1;
        routeOptions3.motorways = 1;
        routeOptions3.tollroads = 1;
        RouteOptions routeOptions4 = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptions4.routeType = 0;
        routeOptions4.motorways = 1;
        routeOptions4.tollroads = 1;
        RouteOptions routeOptions5 = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptions5.routeType = 7;
        routeOptions5.motorways = 1;
        routeOptions5.tollroads = 3;
        RouteOptions routeOptions6 = RouteOptionsHelper.copyRouteOptions(routeOptions);
        routeOptions6.routeType = 5;
        routeOptions6.motorways = 1;
        routeOptions6.tollroads = 1;
        RouteOptions[] routeOptionsArray = new RouteOptions[5];
        switch (this.getHmiRouteType(persistableRouteOptionsSetup)) {
            case 0: {
                this.trace("getAlternativeRouteOptions() -> getting FAST profile!");
                routeOptionsArray[0] = routeOptions4;
                routeOptionsArray[1] = routeOptions6;
                routeOptionsArray[2] = routeOptions2;
                routeOptionsArray[3] = routeOptions3;
                routeOptionsArray[4] = routeOptions5;
                break;
            }
            case 1: {
                this.trace("getAlternativeRouteOptions() -> getting SHORT profile!");
                routeOptionsArray[0] = routeOptions3;
                routeOptionsArray[1] = routeOptions6;
                routeOptionsArray[2] = routeOptions2;
                routeOptionsArray[3] = routeOptions4;
                routeOptionsArray[4] = routeOptions5;
                break;
            }
            case 2: {
                this.trace("getAlternativeRouteOptions() -> getting ECO profile!");
                routeOptionsArray[0] = routeOptions2;
                routeOptionsArray[1] = routeOptions6;
                routeOptionsArray[2] = routeOptions4;
                routeOptionsArray[3] = routeOptions3;
                routeOptionsArray[4] = routeOptions5;
                break;
            }
            case 3: {
                this.trace("getAlternativeRouteOptions() -> getting AVOIDTOLL profile!");
                routeOptionsArray[0] = routeOptions5;
                routeOptionsArray[1] = routeOptions6;
                routeOptionsArray[2] = routeOptions2;
                routeOptionsArray[3] = routeOptions4;
                routeOptionsArray[4] = routeOptions3;
                break;
            }
            case 5: {
                this.trace("getAlternativeRouteOptions() -> getting ECONOMICAL profile!");
                routeOptionsArray[0] = routeOptions6;
                routeOptionsArray[1] = routeOptions2;
                routeOptionsArray[2] = routeOptions4;
                routeOptionsArray[3] = routeOptions3;
                routeOptionsArray[4] = routeOptions5;
                break;
            }
        }
        return routeOptionsArray;
    }

    @Override
    public int[] getAlternativeRouteOptionsOrderDSI(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getAlternativeRouteOptionsOrder()");
        int[] nArray = new int[5];
        switch (this.getHmiRouteType(persistableRouteOptionsSetup)) {
            case 0: {
                this.trace("getAlternativeRouteOptionsOrderDSI() -> getting FAST profile!");
                nArray[0] = 0;
                nArray[1] = 5;
                nArray[2] = 2;
                nArray[3] = 1;
                nArray[4] = 3;
                break;
            }
            case 1: {
                this.trace("getAlternativeRouteOptionsOrderDSI() -> getting SHORT profile!");
                nArray[0] = 1;
                nArray[1] = 5;
                nArray[2] = 2;
                nArray[3] = 0;
                nArray[4] = 3;
                break;
            }
            case 2: {
                this.trace("getAlternativeRouteOptionsOrderDSI() -> getting ECO profile!");
                nArray[0] = 2;
                nArray[1] = 5;
                nArray[2] = 0;
                nArray[3] = 1;
                nArray[4] = 3;
                break;
            }
            case 3: {
                this.trace("getAlternativeRouteOptionsOrderDSI() -> getting AVOIDTOLL profile!");
                nArray[0] = 3;
                nArray[1] = 5;
                nArray[2] = 2;
                nArray[3] = 0;
                nArray[4] = 1;
                break;
            }
            case 5: {
                this.trace("getAlternativeRouteOptionsOrderDSI() -> getting ECONOMICAL profile!");
                nArray[0] = 5;
                nArray[1] = 2;
                nArray[2] = 0;
                nArray[3] = 1;
                nArray[4] = 3;
                break;
            }
        }
        return nArray;
    }

    @Override
    public int[] getAlternativeRouteOptionsOrderHMI() {
        this.trace("getAlternativeRouteOptionsOrderHMI()");
        int[] nArray = new int[]{5, 2, 0, 1, 3};
        return nArray;
    }

    @Override
    public int convertDsiRouteTypeToAslSetterRouteType(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("convertDsiRouteTypeToAslSetterRouteType()");
        int n = 5;
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
                if (routeOptions.tollroads == 3) {
                    n = 3;
                    break;
                }
                n = 2;
                break;
            }
            case 5: {
                n = 5;
                break;
            }
        }
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append("current route type -> ");
            logMessage.append(routeOptions.routeType);
            logMessage.append(" result -> ");
            logMessage.append(n);
            logMessage.log();
        }
        return n;
    }

    @Override
    public void toggleAvoidRoadType(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        this.trace("toggleAvoidRoadType()");
        if (n == 3) {
            RouteOptions routeOptions = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
            boolean[] blArray = persistableRouteOptionsSetup.getAvoidRoadTypes();
            boolean bl = !blArray[n];
            blArray[n] = bl;
            persistableRouteOptionsSetup.setAvoidRoadTypes(blArray);
            persistableRouteOptionsSetup.updatePropertyAvoidRoadTypes();
            if (!blArray[n]) {
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger.trace(16384);
                    logMessage.append(super.getClass());
                    logMessage.append(": ");
                    logMessage.append("toggleAvoidRoadType(): USE road type ");
                    logMessage.append(n);
                    logMessage.log();
                }
                routeOptions.ferries = 1;
                routeOptions.cartrain = 1;
            } else {
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    LogMessage logMessage = ServiceManager.logger.trace(16384);
                    logMessage.append(super.getClass());
                    logMessage.append(": ");
                    logMessage.append("toggleAvoidRoadType(): AVOID road type ");
                    logMessage.append(n);
                    logMessage.log();
                }
                routeOptions.ferries = 3;
                routeOptions.cartrain = 3;
            }
            persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions(routeOptions);
        } else {
            super.toggleAvoidRoadType(persistableRouteOptionsSetup, n);
        }
    }

    @Override
    public void setAvoidRoadTypes(PersistableRouteOptionsSetup persistableRouteOptionsSetup, boolean[] blArray) {
        Object object;
        this.trace("setAvoidRoadTypes()");
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            object = ServiceManager.logger.trace(16384);
            object.append(super.getClass());
            object.append(": ");
            object.append("setAvoidRoadTypes():");
            for (int i2 = 0; i2 < blArray.length; ++i2) {
                object.append(" ");
                object.append(blArray[i2]);
            }
            object.log();
        }
        persistableRouteOptionsSetup.setAvoidRoadTypes(blArray);
        persistableRouteOptionsSetup.updatePropertyAvoidRoadTypes();
        object = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        ((RouteOptions)object).motorways = blArray[0] ? 3 : 1;
        ((RouteOptions)object).tollroads = blArray[1] ? 3 : 1;
        ((RouteOptions)object).vignette = blArray[2] ? 8 : 1;
        if (blArray[3]) {
            ((RouteOptions)object).ferries = 3;
            ((RouteOptions)object).cartrain = 3;
        } else {
            ((RouteOptions)object).ferries = 1;
            ((RouteOptions)object).cartrain = 1;
        }
        ((RouteOptions)object).tunnels = blArray[4] ? 3 : 1;
        ((RouteOptions)object).cityMaut = blArray[5] ? 3 : 1;
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions((RouteOptions)object);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions.variant;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.routeoptions.ConfigManager;
import de.vw.mib.asl.internal.navigation.routeoptions.PersistableRouteOptionsSetup;
import de.vw.mib.asl.internal.navigation.routeoptions.transformer.VignetteCountryListCollector;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.RouteOptions;

public abstract class PersistableRouteOptionsAccessor {
    public void trace(String string) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public RouteOptions getRouteOptions(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getRouteOptions()");
        return persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
    }

    public int getHmiDynamic(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getHmiDynamic()");
        return persistableRouteOptionsSetup.getDynamicRouteCalculation();
    }

    public int getHmiRouteType(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getHmiRouteType()");
        return persistableRouteOptionsSetup.getRouteCalculationType();
    }

    public boolean isHmiAlternativeRouteCalculation(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("isHmiAlternativeRouteCalculation()");
        return persistableRouteOptionsSetup.getAlternativeRouteCalculation();
    }

    public void toggleAvoidRoadType(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        this.trace("toggleAvoidRoadType()");
        RouteOptions routeOptions = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        boolean[] blArray = persistableRouteOptionsSetup.getAvoidRoadTypes();
        blArray[n] = !blArray[n];
        persistableRouteOptionsSetup.setAvoidRoadTypes(blArray);
        persistableRouteOptionsSetup.updatePropertyAvoidRoadTypes();
        if (blArray[n]) {
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger.trace(16384);
                logMessage.append(super.getClass());
                logMessage.append(": ");
                logMessage.append("toggleAvoidRoadType(): AVOID road type ");
                logMessage.append(n);
                logMessage.log();
            }
            switch (n) {
                case 0: {
                    routeOptions.motorways = 3;
                    break;
                }
                case 1: {
                    routeOptions.tollroads = 3;
                    break;
                }
                case 2: {
                    routeOptions.vignette = 8;
                    break;
                }
                case 3: {
                    routeOptions.ferries = 3;
                    routeOptions.cartrain = 3;
                    break;
                }
                case 4: {
                    routeOptions.tunnels = 3;
                    break;
                }
                case 5: {
                    routeOptions.cityMaut = 3;
                    break;
                }
            }
        } else {
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger.trace(16384);
                logMessage.append(super.getClass());
                logMessage.append(": ");
                logMessage.append("toggleAvoidRoadType(): USE road type ");
                logMessage.append(n);
                logMessage.log();
            }
            switch (n) {
                case 0: {
                    routeOptions.motorways = 1;
                    break;
                }
                case 1: {
                    routeOptions.tollroads = 1;
                    break;
                }
                case 2: {
                    routeOptions.vignette = 1;
                    break;
                }
                case 3: {
                    routeOptions.ferries = 1;
                    routeOptions.cartrain = 1;
                    break;
                }
                case 4: {
                    routeOptions.tunnels = 1;
                    break;
                }
                case 5: {
                    routeOptions.cityMaut = 1;
                    break;
                }
            }
        }
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions(routeOptions);
    }

    public void setHmiAlternativeRouteCalculation(PersistableRouteOptionsSetup persistableRouteOptionsSetup, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append("setHmiAlternativeRouteCalculation() ");
            logMessage.append(bl);
            logMessage.log();
        }
        persistableRouteOptionsSetup.setAlternativeRouteCalculation(bl);
        persistableRouteOptionsSetup.updatePropertyAlternativeRouteCalculation();
    }

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

    public void setDynamic(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        Object object;
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            object = ServiceManager.logger.trace(16384);
            object.append(super.getClass());
            object.append(": ");
            object.append("setDynamic() ");
            object.append(n);
            object.log();
        }
        object = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        switch (n) {
            case 0: {
                ((RouteOptions)object).dynamic = 6;
                persistableRouteOptionsSetup.setDynamicRouteCalculation(0);
                persistableRouteOptionsSetup.updatePropertyDynamicRouteCalculation();
                break;
            }
            case 1: {
                ((RouteOptions)object).dynamic = 7;
                persistableRouteOptionsSetup.setDynamicRouteCalculation(1);
                persistableRouteOptionsSetup.updatePropertyDynamicRouteCalculation();
                break;
            }
        }
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions((RouteOptions)object);
    }

    public void setSelectedVignetteCountries(PersistableRouteOptionsSetup persistableRouteOptionsSetup, VignetteCountryListCollector[] vignetteCountryListCollectorArray) {
        this.trace("setSelectedVignetteCountries(PersistableRouteOptions options, VignetteCountryListCollector[] theCollector)");
        int n = 0;
        for (int i2 = 0; i2 < vignetteCountryListCollectorArray.length; ++i2) {
            if (!vignetteCountryListCollectorArray[i2].isCountrySelected) continue;
            ++n;
        }
        int[] nArray = new int[n];
        n = 0;
        for (int i3 = 0; i3 < vignetteCountryListCollectorArray.length; ++i3) {
            if (!vignetteCountryListCollectorArray[i3].isCountrySelected) continue;
            nArray[n] = vignetteCountryListCollectorArray[i3].countryID;
            ++n;
        }
        this.setSelectedVignetteCountries(persistableRouteOptionsSetup, nArray);
    }

    public void setSelectedVignetteCountries(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int[] nArray) {
        Object object;
        this.trace("setSelectedVignetteCountries(PersistableRouteOptions options, int[] countryIds)");
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            object = ServiceManager.logger.trace(16384);
            object.append(super.getClass());
            object.append(": ");
            object.append("setSelectedVignetteCountries():");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                object.append(" ");
                object.append(nArray[i2]);
            }
            object.log();
        }
        object = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        ((RouteOptions)object).vignetteCountryList = nArray;
        persistableRouteOptionsSetup.setVignetteAvailableCountryIDs(nArray);
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions((RouteOptions)object);
    }

    public void setTrailerMode(PersistableRouteOptionsSetup persistableRouteOptionsSetup, boolean bl) {
        this.trace("setTrailerMode()");
        RouteOptions routeOptions = persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions();
        routeOptions.trailer = ServiceManager.configManagerDiag.isFeatureFlagSet(70) ? (bl ? 1 : 2) : (bl ? 2 : 1);
        persistableRouteOptionsSetup.dsiRouteOptions.setRouteOptions(routeOptions);
    }

    public boolean getTrailerMode(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("getTrailerMode()");
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            return persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions().trailer == 1;
        }
        return persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions().trailer == 2;
    }

    public void clearSettings(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        this.trace("clearSettings()");
        persistableRouteOptionsSetup.dsiRouteOptions.initDefaultDSIRouteOptions();
        persistableRouteOptionsSetup.dsiVignetteList.deselectAll();
        this.setAvoidRoadTypes(persistableRouteOptionsSetup, this.getAvoidRoadTypesHMIDefault());
        this.setHmiAlternativeRouteCalculation(persistableRouteOptionsSetup, ConfigManager.HMI_ALTERNATIVE_ROUTE_CALCULATION);
        this.setRouteCalcType(persistableRouteOptionsSetup, this.convertDsiRouteTypeToAslSetterRouteType(persistableRouteOptionsSetup));
        this.setDynamic(persistableRouteOptionsSetup, this.getDynamicHMIDefault());
        this.setHOV(persistableRouteOptionsSetup, this.getHOVUsageDefault());
        this.setStatisticalData(persistableRouteOptionsSetup, false);
        this.setSeasonalRestrictions(persistableRouteOptionsSetup, true);
        persistableRouteOptionsSetup.updateProperties();
    }

    private boolean getHOVUsageDefault() {
        return false;
    }

    private int getDynamicHMIDefault() {
        this.trace("getDynamicHMIDefault()");
        int n = 0;
        n = ConfigManager.DSI_DYNAMIC == 6 ? 0 : 1;
        return n;
    }

    private boolean[] getAvoidRoadTypesHMIDefault() {
        this.trace("getAvoidRoadTypesHMIDefault()");
        boolean[] blArray = new boolean[]{ConfigManager.DSI_MOTORWAYS == 3, ConfigManager.DSI_TOLLROADS == 3, ConfigManager.DSI_VIGNETTE == 8, ConfigManager.DSI_FERRIES == 3 && ConfigManager.DSI_CARTRAIN == 3, ConfigManager.DSI_TUNNELS == 3, ConfigManager.DSI_CITY_MAUT == 3};
        return blArray;
    }

    public int getDsiIndexFromRouteCalcType(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        Object object;
        this.trace("getDSIIndexFormRouteCalcType()");
        int n2 = 0;
        if (persistableRouteOptionsSetup.getAlternativeRouteCalculation()) {
            int n3;
            object = this.getAlternativeRouteOptionsOrderDSI(persistableRouteOptionsSetup);
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(super.getClass());
            logMessage.append(": ");
            for (n3 = 0; n3 < ((Object)object).length; ++n3) {
                logMessage.append((int)object[n3]);
                logMessage.append(", ");
            }
            logMessage.log();
            for (n3 = 0; n3 < ((Object)object).length; ++n3) {
                if (object[n3] != n) continue;
                n2 = n3;
            }
        }
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            object = ServiceManager.logger.trace(16384);
            object.append(super.getClass());
            object.append(": ");
            object.append("getDSIIndexFormRouteCalcType() input -> ");
            object.append(n);
            object.append(" result -> ");
            object.append(n2);
            object.log();
        }
        return n2;
    }

    public int getModelIndexFromRouteCalcType(int n) {
        int n2 = 0;
        int[] nArray = this.getAlternativeRouteOptionsOrderHMI();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public int getRouteCalcTypeFromModelIndex(int n) {
        this.trace("getRouteCalcTypeFromModelIndex()");
        int[] nArray = this.getAlternativeRouteOptionsOrderHMI();
        return nArray[n];
    }

    public int getModelIndexFromDsiIndex(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        this.trace("getModelIndexFromDsiIndex()");
        int n2 = 0;
        int[] nArray = this.getAlternativeRouteOptionsOrderDSI(persistableRouteOptionsSetup);
        n2 = this.getModelIndexFromRouteCalcType(nArray[n]);
        return n2;
    }

    public int getDSIIndexFromModelIndex(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
        this.trace("getDSIIndexFromModelIndex()");
        int n2 = 0;
        int n3 = this.getRouteCalcTypeFromModelIndex(n);
        n2 = this.getDsiIndexFromRouteCalcType(persistableRouteOptionsSetup, n3);
        return n2;
    }

    public abstract void setRouteCalcType(PersistableRouteOptionsSetup persistableRouteOptionsSetup, int n) {
    }

    public abstract RouteOptions[] getAlternativeRouteOptions(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
    }

    public abstract int[] getAlternativeRouteOptionsOrderDSI(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
    }

    public abstract int[] getAlternativeRouteOptionsOrderHMI() {
    }

    public abstract int convertDsiRouteTypeToAslSetterRouteType(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
    }

    public void setHOV(PersistableRouteOptionsSetup persistableRouteOptionsSetup, boolean bl) {
        persistableRouteOptionsSetup.setHOVUsage(bl);
        persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions().setHovCarPoolsLane(bl ? 1 : 0);
        persistableRouteOptionsSetup.updatePropertyHOVUsage();
    }

    public void setSeasonalRestrictions(PersistableRouteOptionsSetup persistableRouteOptionsSetup, boolean bl) {
        persistableRouteOptionsSetup.setSeasonalRestrictions(bl);
        persistableRouteOptionsSetup.dsiRouteOptions.getRouteOptions().setSeasonalTimeDomain(bl ? 1 : 2);
        persistableRouteOptionsSetup.updatePropertySeasonalRestrictions();
    }

    public void setStatisticalData(PersistableRouteOptionsSetup persistableRouteOptionsSetup, boolean bl) {
        persistableRouteOptionsSetup.setStatisticalData(bl);
        persistableRouteOptionsSetup.updatePropertyStatisticalData();
    }

    public boolean getStatisticalData(PersistableRouteOptionsSetup persistableRouteOptionsSetup) {
        return persistableRouteOptionsSetup.getStatisticalData();
    }
}


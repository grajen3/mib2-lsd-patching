/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.api.navigation.guidance.IPersistedRouteOptionsSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.IPersistenceDefaults;
import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.routeoptions.DSIRouteOptions;
import de.vw.mib.asl.internal.navigation.routeoptions.DSIVignetteList;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessor;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.routeoptions.transformer.NavigationRouteOptionsRoadTypesAvoidedCollector;

public final class PersistableRouteOptionsSetup
implements ReloadPersistedDataListener,
IPersistedRouteOptionsSetup {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[PersistableRouteOptionsSetup] ");
    public static final String ROUTEOPTIONS_HMI_ALTERNATIVE_ROUTE_CALCULATION;
    public static final String ROUTEOPTIONS_HMI_ROUTECALCULATION_TYPE;
    public static final String ROUTEOPTIONS_HMI_AVOID_ROAD_TYPES;
    public static final int[] ROUTEOPTIONS_HMI_AVOID_ROAD_TYPES_DEFAULT;
    public static final String ROUTEOPTIONS_HMI_DYNAMIC_ROUTE_CALCULATION;
    public static final String ROUTEOPTIONS_HMI_VIGNETTE_AVAILABLE_COUNRTY_IDS;
    public static final int[] ROUTEOPTIONS_HMI_VIGNETTE_AVAILABLE_COUNRTY_IDS_DEFAULT;
    public static final String ROUTEOPTIONS_HMI_USE_HOV_LANES;
    public static final String ROUTEOPTIONS_HMI_USE_SEASONAL_RESTRICTIONS;
    public static final boolean ROUTEOPTIONS_HMI_USE_SEASONAL_RESTRICTIONS_DEFAULT;
    public static final String ROUTEOPTIONS_HMI_USE_STATISTICAL_DATA;
    public static final boolean ROUTEOPTIONS_HMI_USE_STATISTICAL_DATA_DEFAULT;
    public PersistableMap persistableMap;
    private static PersistableRouteOptionsSetup myInstance;
    public DSIRouteOptions dsiRouteOptions = new DSIRouteOptions();
    public DSIVignetteList dsiVignetteList = new DSIVignetteList();

    private PersistableRouteOptionsSetup() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("PersistableRouteOptionsSetup()");
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    public static PersistableRouteOptionsSetup getInstance() {
        return myInstance;
    }

    public void setStatisticalData(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setStatisticalData(): ").append(bl).log();
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setRouteOptionsStatisticalData(bl);
    }

    public boolean getStatisticalData() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getStatisticalData(): ").log();
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isStatisticalData();
    }

    public void updatePropertyStatisticalData() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertyStatisticalData()");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1494216704, this.getStatisticalData());
    }

    public void setSeasonalRestrictions(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setSeasonalRestrictions(): ").append(bl).log();
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setRouteOptionsSeasonalRestrictions(bl);
    }

    public boolean getSeasonalRestrictions() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getSeasonalRestrictions(): ").log();
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isSeasonalRestrictions();
    }

    public void updatePropertySeasonalRestrictions() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertySeasonalRestriction()");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1510993920, this.getSeasonalRestrictions());
    }

    public void setAlternativeRouteCalculation(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setAlternativeRouteCalculation(): ").append(bl).log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setRouteOptionsAlternativeRouteCalc(bl);
        } else {
            this.persistableMap.setBoolean("alternativeRouteCalculation", bl);
            this.persistableMap.setSurviving("alternativeRouteCalculation", true);
        }
    }

    public boolean getAlternativeRouteCalculation() {
        boolean bl = ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE") ? ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isRouteOptionsAlternativeRouteCalc() : this.persistableMap.getBoolean("alternativeRouteCalculation", IPersistenceDefaults.ROUTEOPTIONS_HMI_ALTERNATIVE_ROUTE_CALCULATION_DEFAULT);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getAlternativeRouteCalculation(): ").append(bl).log();
        }
        return bl;
    }

    public void updatePropertyAlternativeRouteCalculation() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertyAlternativeRouteCalculation()");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(955, this.getAlternativeRouteCalculation());
        ServiceManager.aslPropertyManager.valueChangedBoolean(737, this.getAlternativeRouteCalculation());
    }

    public void setRouteCalculationType(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setRouteCalculationType(): ").append(n).log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setRouteOptionsRouteCalculationType(n);
        } else {
            this.persistableMap.setInt("routeCalculationType", n);
            this.persistableMap.setSurviving("routeCalculationType", true);
        }
    }

    @Override
    public int getRouteCalculationType() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("getRouteCalculationType()");
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsRouteCalculationType();
        }
        return this.persistableMap.getInt("routeCalculationType", 0);
    }

    public void updatePropertyRouteCalculationType() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertyRouteCalculationType()");
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(957, this.getRouteCalculationType());
    }

    public void setVignetteAvailableCountryIDs(int[] nArray) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.makeTrace();
            logMessage.append("setVignetteAvailableCountryIDs(): [");
            if (nArray != null) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    logMessage.append(nArray[i2]);
                }
            }
            logMessage.append("]").log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsVignetteAvailableCountryIds().clear();
            for (int i3 = 0; nArray != null && i3 < nArray.length; ++i3) {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsVignetteAvailableCountryIds().add(nArray[i3]);
            }
        } else {
            this.persistableMap.setIntArray("vignetteAvailableCountryIds", nArray);
            this.persistableMap.setSurviving("vignetteAvailableCountryIds", true);
        }
    }

    public int[] getVignetteAvailableCountryIDs() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("getVignetteAvailableCountryIDs()");
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsVignetteAvailableCountryIds().toArray();
            if (nArray == null || nArray.length == 0) {
                nArray = ROUTEOPTIONS_HMI_VIGNETTE_AVAILABLE_COUNRTY_IDS_DEFAULT;
            }
            return nArray;
        }
        int[] nArray = this.persistableMap.getIntArray("vignetteAvailableCountryIds", ROUTEOPTIONS_HMI_VIGNETTE_AVAILABLE_COUNRTY_IDS_DEFAULT);
        return nArray;
    }

    public void setAvoidRoadTypes(boolean[] blArray) {
        if (blArray != null) {
            int n;
            Object object;
            if (this.logger.isTraceEnabled()) {
                object = this.logger.makeTrace();
                object.append("setAvoidRoadTypes(): [");
                for (n = 0; n < blArray.length; ++n) {
                    object.append(blArray[n]);
                }
                object.append("]").log();
            }
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsAvoidRoadTypes().clear();
                for (int i2 = 0; blArray != null && i2 < blArray.length; ++i2) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsAvoidRoadTypes().add(blArray[i2]);
                }
            } else {
                object = new int[blArray.length];
                for (n = 0; n < blArray.length; ++n) {
                    object[n] = blArray[n] ? (Object)true : (Object)false;
                }
                this.persistableMap.setIntArray("avoidRoadTypes", (int[])object);
                this.persistableMap.setSurviving("avoidRoadTypes", true);
            }
        }
    }

    public boolean[] getAvoidRoadTypes() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("getAvoidRoadTypes()");
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            boolean[] blArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsAvoidRoadTypes().toArray();
            if (blArray == null || blArray.length == 0) {
                blArray = new boolean[ROUTEOPTIONS_HMI_AVOID_ROAD_TYPES_DEFAULT.length];
            }
            return blArray;
        }
        int[] nArray = this.persistableMap.getIntArray("avoidRoadTypes", ROUTEOPTIONS_HMI_AVOID_ROAD_TYPES_DEFAULT);
        boolean[] blArray = new boolean[nArray.length];
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            blArray[i2] = nArray[i2] == 1;
        }
        return blArray;
    }

    public void updatePropertyAvoidRoadTypes() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertyAvoidRoadTypes()");
        }
        Object[] objectArray = (NavigationRouteOptionsRoadTypesAvoidedCollector[])ListManager.getGenericASLList(961).getDSIObjects();
        boolean[] blArray = this.getAvoidRoadTypes();
        if (blArray.length >= 5) {
            objectArray[0].navigation_routeoptions_road_types_highway_avoided = blArray[0];
            objectArray[0].navigation_routeoptions_road_types_tollroads_avoided = blArray[1];
            objectArray[0].navigation_routeoptions_road_types_vignette_avoided = blArray[2];
            objectArray[0].navigation_routeoptions_road_types_transport_avoided = blArray[3];
            objectArray[0].navigation_routeoptions_road_types_tunnel_avoided = blArray[4];
            ListManager.getGenericASLList(961).updateList(objectArray);
        }
    }

    public void setDynamicRouteCalculation(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setDynamicRouteCalculation(): ").append(n).log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setRouteOptionsDynamicRouteCalculation(n);
        } else {
            this.persistableMap.setInt("dynamicRouteCalculation", n);
            this.persistableMap.setSurviving("dynamicRouteCalculation", true);
        }
    }

    public int getDynamicRouteCalculation() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("getDynamicRouteCalculation()");
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getRouteOptionsDynamicRouteCalculation();
        }
        return this.persistableMap.getInt("dynamicRouteCalculation", 0);
    }

    public void updatePropertyDynamicRouteCalculation() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertyDynamicRouteCalculation()");
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(956, this.getDynamicRouteCalculation());
    }

    public void updateProperties() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateProperties()");
        }
        this.updatePropertyAlternativeRouteCalculation();
        this.updatePropertyRouteCalculationType();
        this.updatePropertyAvoidRoadTypes();
        this.updatePropertyDynamicRouteCalculation();
        this.updatePropertyHOVUsage();
        this.updatePropertySeasonalRestrictions();
        this.updatePropertyStatisticalData();
    }

    @Override
    public void reloadPersistedData() {
        PersistableRouteOptionsAccessor persistableRouteOptionsAccessor = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getPersistableRouteOptionsAccessor();
        persistableRouteOptionsAccessor.setAvoidRoadTypes(this, this.getAvoidRoadTypes());
        persistableRouteOptionsAccessor.setDynamic(this, this.getDynamicRouteCalculation());
        persistableRouteOptionsAccessor.setHmiAlternativeRouteCalculation(this, this.getAlternativeRouteCalculation());
        persistableRouteOptionsAccessor.setRouteCalcType(this, this.getRouteCalculationType());
        persistableRouteOptionsAccessor.setSelectedVignetteCountries(this, this.getVignetteAvailableCountryIDs());
        persistableRouteOptionsAccessor.setHOV(this, this.getHOVUsage());
        persistableRouteOptionsAccessor.setSeasonalRestrictions(this, this.getSeasonalRestrictions());
        persistableRouteOptionsAccessor.setStatisticalData(this, this.getStatisticalData());
    }

    public void setHOVUsage(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setHOVUsage(): ").append(bl).log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setHOVUsage(bl);
        } else {
            this.persistableMap.setBoolean("hov", bl);
            this.persistableMap.setSurviving("hov", true);
        }
    }

    public boolean getHOVUsage() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("getHOVUsage()");
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isHOVUsage();
        }
        return this.persistableMap.getBoolean("hov", false);
    }

    public void updatePropertyHOVUsage() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updatePropertyHOV()");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1880092672, this.getHOVUsage());
    }

    static {
        ROUTEOPTIONS_HMI_AVOID_ROAD_TYPES_DEFAULT = new int[]{0, 0, 0, 0, 0, 0};
        ROUTEOPTIONS_HMI_VIGNETTE_AVAILABLE_COUNRTY_IDS_DEFAULT = new int[0];
        myInstance = new PersistableRouteOptionsSetup();
    }
}


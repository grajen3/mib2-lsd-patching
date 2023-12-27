/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions.services;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.routeoptions.PersistableRouteOptionsSetup;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessor;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessorCHNImpl;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessorImpl;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessorJPNImpl;
import org.dsi.ifc.navigation.RouteOptions;

public class RouteOptionsProvider {
    private PersistableRouteOptionsAccessor routeOptionsAccessor;
    private PersistableRouteOptionsSetup persistableRouteOptionsSetup = PersistableRouteOptionsSetup.getInstance();

    public RouteOptionsProvider() {
        this.persistableRouteOptionsSetup.persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("routeOptions");
        this.createRouteOptionsAccessor();
    }

    public PersistableRouteOptionsAccessor getPersistableRouteOptionsAccessor() {
        return this.routeOptionsAccessor;
    }

    private void createRouteOptionsAccessor() {
        this.routeOptionsAccessor = ServiceManager.configManagerDiag.isFeatureFlagSet(107) ? (ServiceManager.configManagerDiag.isFeatureFlagSet(75) ? new PersistableRouteOptionsAccessorJPNImpl() : new PersistableRouteOptionsAccessorCHNImpl()) : new PersistableRouteOptionsAccessorImpl();
    }

    public RouteOptions[] getSingleRouteOptions() {
        return new RouteOptions[]{this.routeOptionsAccessor.getRouteOptions(this.persistableRouteOptionsSetup)};
    }

    public RouteOptions[] getAlternativeRouteOptions() {
        return this.routeOptionsAccessor.getAlternativeRouteOptions(this.persistableRouteOptionsSetup);
    }

    public int getNumberOfAlternativeRoutes() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(107)) {
            return 5;
        }
        return 3;
    }

    public boolean isAlternativeRouteCalculation() {
        return this.persistableRouteOptionsSetup.getAlternativeRouteCalculation();
    }

    public int getRouteCalcTypeFromModelIndex(int n) {
        return this.routeOptionsAccessor.getRouteCalcTypeFromModelIndex(n);
    }

    public int getDsiIndexFromRouteCalcType(int n) {
        return this.routeOptionsAccessor.getDsiIndexFromRouteCalcType(this.persistableRouteOptionsSetup, n);
    }

    public int getModelIndexOfCurrentRouteCalcType() {
        return this.routeOptionsAccessor.getModelIndexFromRouteCalcType(this.persistableRouteOptionsSetup.getRouteCalculationType());
    }

    public int getModelIndexFromDsiIndex(int n) {
        return this.routeOptionsAccessor.getModelIndexFromDsiIndex(this.persistableRouteOptionsSetup, n);
    }

    public int getDSIIndexFromModelIndex(int n) {
        return this.routeOptionsAccessor.getDSIIndexFromModelIndex(this.persistableRouteOptionsSetup, n);
    }

    public void setRouteCalcType(int n) {
        this.routeOptionsAccessor.setRouteCalcType(this.persistableRouteOptionsSetup, n);
    }
}


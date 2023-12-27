/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.citymodel;

import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.navigation.map.dsi.citymodel.CityModelService$1;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.hmi.utils.Preconditions;
import org.dsi.ifc.map.DSIMapViewerControl;

public class CityModelService {
    private final DriverDistractionPreventionService ddpService;
    private final DSIMapViewerControl dsiMapViewerControl;
    private final boolean isDdpFeatureCodedAndAvailable;
    private int intendedCityModelMode;
    private int activeCityModelMode;
    private boolean firstCallOccurred;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$util$IExtLogger;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$DriverDistractionPreventionService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public CityModelService(IExtLogger iExtLogger, DSIProxy dSIProxy, DriverDistractionPreventionService driverDistractionPreventionService, MapViewerDatapoolShared mapViewerDatapoolShared) {
        Preconditions.checkNotNull(iExtLogger, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$api$navigation$util$IExtLogger == null ? (class$de$vw$mib$asl$api$navigation$util$IExtLogger = CityModelService.class$("de.vw.mib.asl.api.navigation.util.IExtLogger")) : class$de$vw$mib$asl$api$navigation$util$IExtLogger).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(dSIProxy, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy == null ? (class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy = CityModelService.class$("de.vw.mib.asl.framework.api.dsiproxy.DSIProxy")) : class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxy).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(driverDistractionPreventionService, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$api$system$DriverDistractionPreventionService == null ? (class$de$vw$mib$asl$api$system$DriverDistractionPreventionService = CityModelService.class$("de.vw.mib.asl.api.system.DriverDistractionPreventionService")) : class$de$vw$mib$asl$api$system$DriverDistractionPreventionService).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(mapViewerDatapoolShared, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared == null ? (class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared = CityModelService.class$("de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared")) : class$de$vw$mib$asl$internal$navigation$map$mainmap$MapViewerDatapoolShared).getName()).append(" must not be null!").toString());
        this.ddpService = driverDistractionPreventionService;
        this.isDdpFeatureCodedAndAvailable = mapViewerDatapoolShared.isDriverDistractionPreventionFeatureAvailable();
        this.intendedCityModelMode = 0;
        this.activeCityModelMode = 0;
        this.firstCallOccurred = false;
        this.dsiMapViewerControl = this.connectDsi(dSIProxy);
        this.installDriverDistractionPreventionListener(iExtLogger, driverDistractionPreventionService);
    }

    public int getIntendedCityModelMode() {
        return this.intendedCityModelMode;
    }

    public int getActiveCityModelMode() {
        return this.activeCityModelMode;
    }

    public void setIntendedCityModelMode(int n) {
        if (!this.firstCallOccurred || n != this.intendedCityModelMode) {
            this.intendedCityModelMode = n;
            this.updateCityModelMode(this.ddpService.isDriverDistractionPreventionRequired());
        }
    }

    void updateCityModelMode(boolean bl) {
        int n;
        int n2 = n = bl && this.isDdpFeatureCodedAndAvailable ? 0 : this.intendedCityModelMode;
        if (!this.firstCallOccurred || n != this.activeCityModelMode) {
            this.firstCallOccurred = true;
            this.activeCityModelMode = n;
            this.dsiMapViewerControl.setCityModelMode(this.activeCityModelMode);
        }
    }

    private DSIMapViewerControl connectDsi(DSIProxy dSIProxy) {
        return (DSIMapViewerControl)dSIProxy.getService(null, class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = CityModelService.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl);
    }

    private DriverDistractionPreventionThresholdListener createDriverDistractionPreventionThresholdListener() {
        return new CityModelService$1(this);
    }

    private void installDriverDistractionPreventionListener(IExtLogger iExtLogger, DriverDistractionPreventionService driverDistractionPreventionService) {
        if (this.isDdpFeatureCodedAndAvailable) {
            driverDistractionPreventionService.addDriverDistractionPreventionListener(this.createDriverDistractionPreventionThresholdListener());
        } else {
            iExtLogger.warn("Driver Distraction Prevention for City Model Mode not coded, city model mode is velocity independent.");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


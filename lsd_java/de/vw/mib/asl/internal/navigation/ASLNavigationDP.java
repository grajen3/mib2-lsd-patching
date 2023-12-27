/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.navigation.util.IPersistableExtension;
import de.vw.mib.asl.api.navigation.util.IPersonalNaviPersistence;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.util.ExtLoggerHelper;
import de.vw.mib.asl.internal.navigation.util.IPersonalNaviPersistenceImpl;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.asl.internal.navigation.util.PersistableExtension;
import de.vw.mib.asl.internal.navigation.util.personalization.NavProfileChangeHandler;
import de.vw.mib.asl.navi.persistence.NaviPersistenceService;
import de.vw.mib.asl.navi.persistence.NaviPersistenceServiceImpl;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public final class ASLNavigationDP
implements INavigationDP {
    private static final ASLNavigationDP DATAPOOL = new ASLNavigationDP();
    private NavLocation crosshairLocation;
    private Route currentRoute;
    private NavLocation defaultLocation;
    private PersistableExtension extendedNavPersistence = PersistableExtension.getInstance();
    private boolean isSharedPersistableRegistered = false;
    private NavLocation clickInMapLocation;
    private NavLocation myDestInputLocation;
    private NavLocation myMapInput;
    private NavLocation myMemoryLocation;
    private boolean myMemoryLocationTopDest;
    private NavLocation wpmLocation;
    private NavLocation myPOILocation;
    private NavLocation myRouteInfoLocation;
    private NavLocation mySpellerLocation;
    private NavLocation poiSearchLocation;
    private NavLocation detailViewLocation;
    private NavLocation guidanceInfoLocation;
    private NavLocation topOfLastDestLocation;
    private int[] preferredBrandUids = null;
    private boolean saveCorrectedAddressToEntry;
    private int searchArea;
    private boolean topPoisHaveBeenLoadedSuccessfully = false;
    private NavLocation tourmodeLocation;
    private Route tourmodeRoute;
    private NavLocation externalLocationInputLocation;
    private int guidanceType = 1;
    private boolean wpmActive = false;
    private int wpmMode = 0;
    private NaviPersistenceService persistableNavService;
    private Navigation personalNaviPersistence = null;
    private ArrayList personalPersistenceListeners = new ArrayList();
    private boolean isPNavActive = false;
    private int lastClamp15OffTime = 0;
    private boolean wpmClusterShowmaneuver = true;
    private int onlineToursAvailable = 0;
    private int[][] locationIDs;
    private String selectedPoiJpnCategory = "";
    private String invalidDestMemLocationAddressParts = "";
    private NavLocation sldeVicinityLocation;
    private boolean clamp15On = false;
    private boolean mapExternalConfigured;

    public static ASLNavigationDP getInstance() {
        return DATAPOOL;
    }

    @Override
    public int getLastClamp15OffTime() {
        return this.lastClamp15OffTime;
    }

    @Override
    public void setLastClamp15OffTime(int n) {
        this.lastClamp15OffTime = n;
    }

    @Override
    public boolean isPNavActive() {
        return this.isPNavActive;
    }

    @Override
    public void setPNavActive(boolean bl) {
        this.isPNavActive = bl;
    }

    @Override
    public boolean isWpmClusterShowmaneuver() {
        return this.wpmClusterShowmaneuver;
    }

    @Override
    public void setWpmClusterShowmaneuver(boolean bl) {
        this.wpmClusterShowmaneuver = bl;
    }

    @Override
    public void addReloadPersistedDataListener(ReloadPersistedDataListener reloadPersistedDataListener) {
        this.personalPersistenceListeners.add(reloadPersistedDataListener);
    }

    @Override
    public void removeReloadPersistedDataListener(ReloadPersistedDataListener reloadPersistedDataListener) {
        this.personalPersistenceListeners.remove(reloadPersistedDataListener);
    }

    public Navigation getMyPersonalNaviPersistence() {
        if (this.personalNaviPersistence == null) {
            try {
                this.personalNaviPersistence = this.getPersonalPersistenceServices().loadNavigation();
                this.notifyPersistenceListeners();
            }
            catch (Exception exception) {
                this.personalNaviPersistence = this.getPersonalPersistenceServices().createNavigation();
                this.notifyPersistenceListeners();
            }
        }
        return this.personalNaviPersistence;
    }

    public NaviPersistenceService getPersonalPersistenceServices() {
        return this.persistableNavService;
    }

    public void setPersonalNaviPersistence(Navigation navigation) {
        this.personalNaviPersistence = navigation;
    }

    private ASLNavigationDP() {
        this.persistableNavService = NaviPersistenceServiceImpl.getInstance();
        NavProfileChangeHandler navProfileChangeHandler = new NavProfileChangeHandler();
        this.getPersonalPersistenceServices().addProfileChangeListener(navProfileChangeHandler);
        this.getMyPersonalNaviPersistence();
    }

    @Override
    public NavLocation getCrosshairLocation() {
        return this.crosshairLocation;
    }

    @Override
    public Route getCurrentRoute() {
        return this.currentRoute;
    }

    @Override
    public NavLocation getDefaultLocation() {
        return this.defaultLocation;
    }

    @Override
    public NavLocation getDemoLocation() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDemoDest();
    }

    @Override
    public NavLocation getDestInputLocation() {
        return this.myDestInputLocation;
    }

    @Override
    public IPersistableExtension getExtendedNavPersistence() {
        return this.extendedNavPersistence;
    }

    @Override
    public NavLocation getExternalLocationInputLocation() {
        return this.externalLocationInputLocation;
    }

    @Override
    public NavLocation getMapInputLocation() {
        return this.myMapInput;
    }

    @Override
    public NavLocation getMemoryLocation() {
        return this.myMemoryLocation;
    }

    @Override
    public NavLocation getWpmLocation() {
        return this.wpmLocation;
    }

    @Override
    public void setWpmLocation(NavLocation navLocation) {
        this.wpmLocation = navLocation;
    }

    @Override
    public NavLocation getPOILocation() {
        return this.myPOILocation;
    }

    @Override
    public int getPoiSearchArea() {
        return this.searchArea;
    }

    @Override
    public NavLocation getPoiSearchLocation() {
        return this.poiSearchLocation;
    }

    @Override
    public int[] getPreferredBrandUids() {
        return this.preferredBrandUids;
    }

    @Override
    public boolean getRGIsActive() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive();
    }

    @Override
    public NavLocation getRouteInfoLocation() {
        return this.myRouteInfoLocation;
    }

    @Override
    public NavLocation getSpellerLocation() {
        return this.mySpellerLocation;
    }

    @Override
    public NavLocation getTourmodeLocation() {
        return this.tourmodeLocation;
    }

    @Override
    public Route getTourmodeRoute() {
        return this.tourmodeRoute;
    }

    @Override
    public boolean isMemoryLocationTopDest() {
        return this.myMemoryLocationTopDest;
    }

    @Override
    public boolean isSaveCorrectedAddressToEntry() {
        return this.saveCorrectedAddressToEntry;
    }

    @Override
    public boolean isTopPoisHaveBeenLoadedSuccessfully() {
        return this.topPoisHaveBeenLoadedSuccessfully;
    }

    @Override
    public void loadPersistables() {
        this.setDefaultLocation();
        if (!this.isSharedPersistableRegistered) {
            ServiceManager.logger.info(16384).append("deserializing persistables").log();
            this.isSharedPersistableRegistered = true;
            ServiceManager.persistence.registerSharedPersistable(this.extendedNavPersistence);
        }
        try {
            ServiceManager.persistence.loadPersistable(5006, 0, this.extendedNavPersistence);
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
        }
    }

    @Override
    public void setCrosshairLocation(NavLocation navLocation) {
        ExtLoggerHelper.getInstance().traceWithLocation(ServiceManager.logger, 16384, "storing Crosshair location: ", navLocation, "");
        this.crosshairLocation = navLocation;
    }

    @Override
    public void setCurrentRoute(Route route) {
        this.currentRoute = route;
    }

    private void setDefaultLocation() {
        if (this.defaultLocation == null) {
            boolean bl = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(0);
            int n = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(2);
            int n2 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(3);
            int n3 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(5);
            boolean bl2 = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(4);
            int n4 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(1);
            int n5 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(0);
            int n6 = ServiceManager.configManagerDiag.getNaviLocationOptionDefault(4);
            int n7 = NaviHelper.getInstance().degMinSecToDsi(new double[]{n, n2, n3}, bl);
            int n8 = NaviHelper.getInstance().degMinSecToDsi(new double[]{n4, n5, n6}, bl2);
            this.defaultLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n7, n8).getLocation();
        }
    }

    @Override
    public void setDefaultLocation(NavLocation navLocation) {
        this.defaultLocation = navLocation;
    }

    @Override
    public void setDemoLocation(NavLocation navLocation) {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().setDemoDest(navLocation);
    }

    @Override
    public void setDestInputLocation(NavLocation navLocation) {
        this.setDestInputLocation(navLocation, true);
    }

    @Override
    public void setDestInputLocation(NavLocation navLocation, boolean bl) {
        ExtLoggerHelper.getInstance().traceWithLocation(ServiceManager.logger, 16384, "storing DESTINPUT location: ", navLocation, "");
        this.myDestInputLocation = navLocation;
        if (bl) {
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                ServiceManager.logger.info(16384).append("resetting location input initialization state.").log();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(3656, 7);
        }
    }

    @Override
    public void setExternalLocationInputLocation(NavLocation navLocation) {
        ExtLoggerHelper.getInstance().traceWithLocation(ServiceManager.logger, 16384, "storing EXTERNAL LOCATION INPUT location: ", navLocation, "");
        this.externalLocationInputLocation = navLocation;
    }

    @Override
    public void setMapInputLocation(NavLocation navLocation) {
        this.myMapInput = navLocation;
    }

    @Override
    public void setMemoryLocation(NavLocation navLocation) {
        ExtLoggerHelper.getInstance().traceWithLocation(ServiceManager.logger, 16384, "storing MEMORY location: ", navLocation, "");
        this.myMemoryLocation = navLocation;
    }

    @Override
    public void setMemoryLocationIsTopDest(boolean bl) {
        this.myMemoryLocationTopDest = bl;
    }

    @Override
    public void setPOILocation(NavLocation navLocation) {
        ExtLoggerHelper.getInstance().traceWithLocation(ServiceManager.logger, 16384, "storing POI location: ", navLocation, "");
        this.myPOILocation = navLocation;
    }

    @Override
    public void setPoiSearchArea(int n) {
        this.searchArea = n;
    }

    @Override
    public void setPoiSearchLocation(NavLocation navLocation) {
        this.poiSearchLocation = navLocation;
    }

    @Override
    public void setPreferredBrandUids(int[] nArray) {
        this.preferredBrandUids = nArray;
    }

    @Override
    public void setRouteInfoLocation(NavLocation navLocation) {
        this.myRouteInfoLocation = navLocation;
    }

    @Override
    public void setSaveCorrectedAddressToEntry(boolean bl) {
        this.saveCorrectedAddressToEntry = bl;
    }

    @Override
    public void setSpellerLocation(NavLocation navLocation) {
        this.mySpellerLocation = navLocation;
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("Speller location changed to: ");
            ExtLoggerHelper.getInstance().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
    }

    @Override
    public void setTopPoisHaveBeenLoadedSuccessfully(boolean bl) {
        this.topPoisHaveBeenLoadedSuccessfully = bl;
    }

    @Override
    public void setTourmodeLocation(NavLocation navLocation) {
        this.tourmodeLocation = navLocation;
    }

    @Override
    public void setTourmodeRoute(Route route) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            String string = route != null ? (route.getRoutelist() != null ? String.valueOf(route.getRoutelist().length) : "RouteList = null") : "Route = null";
            ServiceManager.logger.trace(16384).append("ASLNavDP.setTourModeRoute with n destinations: ").append(string).log();
        }
        this.tourmodeRoute = route;
    }

    @Override
    public void setGuidanceType(int n) {
        this.guidanceType = n;
    }

    @Override
    public int getGuidanceType() {
        return this.guidanceType;
    }

    @Override
    public boolean isWpmActive() {
        return this.wpmActive;
    }

    @Override
    public void setWpmActive(boolean bl) {
        this.wpmActive = bl;
    }

    @Override
    public void setWpmMode(int n) {
        this.wpmMode = n;
    }

    @Override
    public int getWpmMode() {
        return this.wpmMode;
    }

    void notifyPersistenceListeners() {
        for (int i2 = 0; i2 < this.personalPersistenceListeners.size(); ++i2) {
            try {
                ((ReloadPersistedDataListener)this.personalPersistenceListeners.get(i2)).reloadPersistedData();
                continue;
            }
            catch (Throwable throwable) {
                ServiceManager.errorHandler.handleError(throwable);
            }
        }
    }

    @Override
    public IPersonalNaviPersistence getPersonalNaviPersistence() {
        return IPersonalNaviPersistenceImpl.getInstance(this);
    }

    public IPersistedGuidanceSetup getGuidanceOptions() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup();
    }

    @Override
    public NavLocation getClickInMapLocation() {
        return this.clickInMapLocation;
    }

    @Override
    public void setClickInMapLocation(NavLocation navLocation) {
        this.clickInMapLocation = navLocation;
    }

    @Override
    public void reloadPersonalNaviPersistence() {
        this.setPersonalNaviPersistence(this.getPersonalPersistenceServices().loadNavigation());
        this.notifyPersistenceListeners();
        ServiceManager.aslPropertyManager.valueChangedBoolean(756, true);
    }

    @Override
    public void setOnlineToursAvailable(int n) {
        this.getPersonalNaviPersistence().setOnlineToursAvailable(n);
    }

    @Override
    public int getOnlineToursAvailable() {
        return this.getPersonalNaviPersistence().getOnlineToursAvailable();
    }

    @Override
    public void storeVisibleLocationIDs(int[][] nArray) {
        this.traceLocationIDs(nArray);
        this.locationIDs = nArray;
    }

    private void traceLocationIDs(int[][] nArray) {
        if (nArray != null && ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("storeVisibleLocationIDs: ");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                logMessage.append(new StringBuffer().append("[").append(nArray[i2][0]).append(",").append(nArray[i2][1]).append("] ").toString());
            }
            logMessage.log();
        }
    }

    @Override
    public int[][] getVisibleLocationIDs() {
        return this.locationIDs;
    }

    @Override
    public String getPoiJpnCategory() {
        return this.selectedPoiJpnCategory;
    }

    @Override
    public void setPoiJpnCategory(String string) {
        this.selectedPoiJpnCategory = string;
    }

    @Override
    public NavLocation getDetailViewLocation() {
        return this.detailViewLocation;
    }

    @Override
    public NavLocation getGuidanceInfoLocation() {
        return this.guidanceInfoLocation;
    }

    @Override
    public NavLocation getTopOfLastDestLocation() {
        return this.topOfLastDestLocation;
    }

    @Override
    public void setDetailViewLocation(NavLocation navLocation) {
        this.detailViewLocation = navLocation;
    }

    @Override
    public void setGuidanceInfoLocation(NavLocation navLocation) {
        this.guidanceInfoLocation = navLocation;
    }

    @Override
    public void setTopOfLastDestLocation(NavLocation navLocation) {
        this.topOfLastDestLocation = navLocation;
    }

    @Override
    public NavLocation getSldeVicinityLocation() {
        return this.sldeVicinityLocation;
    }

    @Override
    public void setSldeVicinityLocation(NavLocation navLocation) {
        this.sldeVicinityLocation = navLocation;
    }

    @Override
    public String getInvalidDestMemLocationAddressParts() {
        return this.invalidDestMemLocationAddressParts;
    }

    @Override
    public void setInvalidDestMemLocationAddressParts(String string) {
        this.invalidDestMemLocationAddressParts = string;
    }

    @Override
    public boolean getClamp15On() {
        return this.clamp15On;
    }

    @Override
    public void setClamp15On(boolean bl) {
        this.clamp15On = bl;
    }

    @Override
    public void setMapExternalConfigured(boolean bl) {
        this.mapExternalConfigured = bl;
    }

    @Override
    public boolean isMapExternalConfigured() {
        return this.mapExternalConfigured;
    }
}


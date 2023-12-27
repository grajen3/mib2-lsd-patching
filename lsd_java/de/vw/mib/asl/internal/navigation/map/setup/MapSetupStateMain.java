/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.map.setup.MapFavoriteDescriptor;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public final class MapSetupStateMain
extends AbstractHsmState
implements UnitChangeListener,
TargetForResetNavigation {
    private final IExtLogger logger;
    private final MapSetupTargetHSM target;
    private int updateHomeFavorite;
    private ArrayList homeFavoriteUpdateList;
    private FactoryResetParticipantWithCallback navigationResetParticipant;

    public MapSetupStateMain(MapSetupTargetHSM mapSetupTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapSetupTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapSetupStateMain]");
        this.updateHomeFavorite = 0;
        this.homeFavoriteUpdateList = new ArrayList(12);
    }

    public HsmState dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        Object object;
        this.logger.trace("dsiAdbEditGetEntriesResult()");
        if (n != 0) {
            this.logger.error("No top destinations delivered by the DSI.");
            return null;
        }
        AdbEntry[] adbEntryArray2 = adbEntryArray;
        if (adbEntryArray2 == null) {
            this.logger.info("Entries table is null!");
            return null;
        }
        int n2 = 0;
        ArrayList arrayList = new ArrayList(12);
        for (int i2 = 0; i2 < adbEntryArray2.length; ++i2) {
            AdbEntry adbEntry = adbEntryArray2[i2];
            object = adbEntry.getAddressData();
            for (int i3 = 0; i3 < ((Object)object).length; ++i3) {
                ASLNavigationServices aSLNavigationServices;
                int[] nArray;
                Object object2 = object[i3];
                if (!((AddressData)object2).isTopDestination() || StringUtil.isEmpty(((AddressData)object2).getGeoPosition()) || !MapFavoriteDescriptor.isPositionValid(nArray = (aSLNavigationServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(null)).parseGeoPositionVCard3_0(((AddressData)object2).getGeoPosition()))) continue;
                arrayList.add(new MapFavoriteDescriptor(nArray, adbEntry.getCombinedName(), adbEntry.getEntryId(), n2 + 10, ((AddressData)object2).getCountry(), ((AddressData)object2).getLocality(), ((AddressData)object2).getStreet()));
                ++n2;
            }
        }
        MapFlag[] mapFlagArray = new MapFlag[n2];
        int n3 = 0;
        object = arrayList.iterator();
        while (object.hasNext()) {
            MapFavoriteDescriptor mapFavoriteDescriptor = (MapFavoriteDescriptor)object.next();
            mapFlagArray[n3] = new MapFlag(mapFavoriteDescriptor.getLongitude(), mapFavoriteDescriptor.getLatitude(), 28, mapFavoriteDescriptor.getFlagId());
            ++n3;
        }
        this.target.datapool.setFavoritesList(arrayList);
        this.target.datapool.setMapFlags(mapFlagArray);
        this.setUpdateHomeFavorite(true, mapFlagArray);
        this.target.notifierDSI.dsiMapViewerMainConfigureFlags(0, mapFlagArray);
        return null;
    }

    public HsmState dsiMapViewerControlConfigureFlags(long[] lArray) {
        MapFlag[] mapFlagArray;
        this.logger.trace("dsiMapViewerControlConfigureFlags()");
        if (lArray != null && lArray.length > 0 && (mapFlagArray = this.isUpdateHomeFavorite()) != null && mapFlagArray.length > 0) {
            if (mapFlagArray[0].styleIndex == 23) {
                this.target.datapool.setHomeLocationID(lArray[0]);
                this.setUpdateHomeFavorite(false, null);
            } else if (mapFlagArray[0].styleIndex == 28) {
                ArrayList arrayList = this.target.datapool.getFavoritesList();
                int n = 0;
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    MapFavoriteDescriptor mapFavoriteDescriptor = (MapFavoriteDescriptor)iterator.next();
                    mapFavoriteDescriptor.setManagedFlagId(lArray[n]);
                    if (this.logger.isTraceEnabled()) {
                        this.logger.makeTrace().append("dsiMapViewerControlConfigureFlags(flagId= ").append(mapFavoriteDescriptor.getFlagId()).append(", managedId=").append(mapFavoriteDescriptor.getManagedFlagId()).append(")").log();
                    }
                    ++n;
                }
                this.setUpdateHomeFavorite(false, null);
            }
        }
        if (lArray == null || lArray.length == 0) {
            this.target.datapool.setConfiguredFlagHandles(new long[0]);
        } else {
            this.target.datapool.setConfiguredFlagHandles(lArray);
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateEhCategoryVisibility(int[] nArray, int n) {
        this.logger.trace("dsiMapViewerControlUpdateEhCategoryVisibility()");
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainEhSetCategoryVisibilityResult(nArray);
        this.target.notifierModel.notifyPOICategoriesAvailable();
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 2: {
                this.handleEntry();
                break;
            }
            case 3400007: {
                this.handleAslNaviMapSetContentReady();
                break;
            }
            case 3499045: {
                this.handleEvMapMainSwitchMapViewerDone();
                break;
            }
            case 1073742384: {
                this.handleLaneGuidanceToggle();
                break;
            }
            case 1073742386: {
                this.handleShowFavoritesToggle();
                break;
            }
            case 1073742388: {
                this.handleToggleBrandMarker();
                break;
            }
            case 3499032: {
                this.handleEvAdressBookEntryChanged(eventGeneric);
                break;
            }
            case 3499011: {
                this.handleEvNaviSetupPreferredBrandsHaveChanged();
                break;
            }
            case 4300048: {
                this.handleSetDsiDistanceUnit(eventGeneric);
                break;
            }
            case 101001: {
                this.handleNaviTargetGoOn();
                break;
            }
            case 3499033: {
                this.handleEvNaviPostStartup();
                break;
            }
            case 1073742387: {
                this.handleASLNavigationMapSetupShowPoiToggle();
                break;
            }
            case 3499024: {
                this.handleEhSetCategoryVisibility(eventGeneric);
                break;
            }
            case 3499025: {
                this.handleEhSetCategoryVisibilityToDefault(eventGeneric);
                break;
            }
            case 3499027: {
                this.handleRbSelectAlternativeRoute(eventGeneric);
                break;
            }
            case 3499003: {
                this.handleHomeLocationChanged();
                break;
            }
            case 1073742287: {
                this.handleDualScreenSetMapVisibility(eventGeneric);
                break;
            }
            case 3499055: {
                this.handleEvMapMainWaypointModeRecordDestinationFlag(eventGeneric);
                break;
            }
            case 3499056: {
                this.handleEvMapMainRouteVisibility(eventGeneric);
                break;
            }
            case 1074841955: {
                this.target.handleDayNightMode(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapSetupShowPoiToggle() {
        this.logger.trace("handleASLNavigationMapSetupShowPoiToggle()");
        boolean bl = !this.target.datapool.isMainMapShowPoiIcons();
        this.target.datapool.setMainMapShowPoiIcons(bl);
        this.target.changePoiVisibility(bl);
    }

    private void handleAslNaviMapSetContentReady() {
        this.logger.trace("handleAslNaviMapSetContentReady()");
        this.configureAllFlags();
    }

    private void configureAllFlags() {
        this.configureHomeLocation();
        this.target.showFavorites(this.target.datapool.isMainMapShowFavoritesIcons());
        if (this.target.datapool.getMapFlagWayPointMode() != null) {
            this.target.notifierDSI.dsiMapViewerMainConfigureFlags(0, new MapFlag[]{this.target.datapool.getMapFlagWayPointMode()});
        }
    }

    private void handleEvMapMainSwitchMapViewerDone() {
        this.logger.trace("handleEvMapMainSwitchMapViewerDone()");
        this.configureAllFlags();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(",Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleDualScreenSetMapVisibility(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDualScreenSetMapVisibility(viewId= ").append(n).append(", mapVisible=").append(n2).append(")").log();
        }
        int[] nArray = this.target.datapool.getDualScreenVisibilities();
        if (n < 0 || n >= nArray.length) {
            this.logger.makeError().append("handleDualScreenSetMapVisibility(viewId= ").append(n).append(", mapVisible=").append(n2).append(") - The viewId is out of range! The value will not set or persisted.").log();
            return;
        }
        nArray[n] = n2;
        this.target.notifierModel.updateListDualScreenMapVisibilities(nArray);
        this.target.datapool.setDualScreenVisibilities(nArray);
    }

    private void handleEhSetCategoryVisibility(EventGeneric eventGeneric) {
        this.logger.trace("handleEhSetCategoryVisibility()");
        int[] nArray = (int[])eventGeneric.getObject(0);
        boolean[] blArray = (boolean[])eventGeneric.getObject(1);
        this.target.notifierDSI.dsiMapViewerMainEhSetCategoryVisibility(nArray, blArray);
    }

    private void handleEhSetCategoryVisibilityToDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleEhSetCategoryVisibilityToDefault()");
        this.target.notifierDSI.dsiMapViewerMainEhSetCategoryVisibilityToDefault();
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
    }

    private void handleEvAdressBookEntryChanged(EventGeneric eventGeneric) {
        this.logger.trace("handleEvAdressBookEntryChanged()");
        this.target.datapool.setAdbEntryChanged(true);
    }

    private void handleEvMapMainRouteVisibility(EventGeneric eventGeneric) {
        this.logger.trace("handleEvMapMainRouteVisibility()");
        boolean bl = eventGeneric.getBoolean(0);
        this.target.datapool.setPnavRouteVisibility(bl);
        this.target.notifierDSI.dsiMapViewerMainSetRouteVisibility(bl);
    }

    private void handleEvMapMainWaypointModeRecordDestinationFlag(EventGeneric eventGeneric) {
        this.logger.trace("handleEvMapMainWaypointModeRecordDestinationFlag()");
        NavLocation navLocation = (NavLocation)eventGeneric.getObject(0);
        int n = eventGeneric.getInt(1);
        if (navLocation == null) {
            if (this.target.datapool.getMapFlagWayPointMode() != null) {
                this.logger.trace("The NavLocation is empty, removing all flags from map.");
                this.target.notifierDSI.dsiMapViewerMainConfigureFlags(2, new MapFlag[]{this.target.datapool.getMapFlagWayPointMode()});
                this.target.datapool.setMapFlagWayPointMode(null);
            }
            return;
        }
        this.logger.trace("adding waypoint mode record destination flag to map");
        MapFlag mapFlag = new MapFlag(navLocation.longitude, navLocation.latitude, n, 0L);
        this.target.datapool.setMapFlagWayPointMode(mapFlag);
        this.target.notifierDSI.dsiMapViewerMainConfigureFlags(0, new MapFlag[]{mapFlag});
    }

    private void handleEvNaviPostStartup() {
        this.logger.trace("handleEvNaviSetupMapPostStartup()");
        this.target.showFavorites(this.target.datapool.isMainMapShowFavoritesIcons());
    }

    private void handleEvNaviSetupPreferredBrandsHaveChanged() {
        this.logger.trace("handleEvNaviSetupPreferredBrandsHaveChanged()");
        this.target.setBrandIconstyle();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
        this.target.removeDayNightModeListener();
    }

    private void handleHomeLocationChanged() {
        this.logger.trace("handleHomeLocationChanged()");
        NavLocation navLocation = this.target.datapool.getHomeLocation();
        if (navLocation == null) {
            this.target.notifierDSI.dsiMapViewerMainConfigureFlags(1, null);
        } else {
            MapFlag[] mapFlagArray = new MapFlag[]{new MapFlag(navLocation.longitude, navLocation.latitude, 23, 0)};
            this.setUpdateHomeFavorite(true, mapFlagArray);
            this.target.notifierDSI.dsiMapViewerMainConfigureFlags(0, mapFlagArray);
        }
    }

    void configureHomeLocation() {
        this.logger.trace("configureHomeLocation()");
        NavLocation navLocation = this.target.datapool.getHomeLocation();
        this.target.notifierDSI.dsiMapViewerMainConfigureFlags(1, null);
        if (navLocation != null) {
            MapFlag[] mapFlagArray = new MapFlag[]{new MapFlag(navLocation.longitude, navLocation.latitude, 23, 0)};
            this.setUpdateHomeFavorite(true, mapFlagArray);
            this.target.notifierDSI.dsiMapViewerMainConfigureFlags(0, mapFlagArray);
        }
    }

    private void handleLaneGuidanceToggle() {
        this.logger.trace("handleLaneGuidanceToggle()");
        boolean bl = !this.target.datapool.isLaneGuidance();
        this.target.configureLaneGuidance(bl);
    }

    private void handleNaviTargetGoOn() {
        this.logger.trace("handleNaviTargetGoOn()");
    }

    private void handleRbSelectAlternativeRoute(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleRbSelectAlternativeRoute(routeIndex=").append(n).append(")").log();
        }
        this.target.notifierDSI.dsiMapViewerMainRbSelectAlternativeRoute(n);
    }

    private void handleSetDsiDistanceUnit(EventGeneric eventGeneric) {
        int n;
        int n2 = eventGeneric.getInt(0);
        if (n2 == 0) {
            n = 2;
        } else if (n2 == 1) {
            n = ServiceManager.configManagerDiag.isFeatureFlagSet(155) ? 3 : 4;
        } else {
            this.logger.error("handleSetDsiDistanceUnit() invalid distance unit");
            return;
        }
        this.target.notifierDSI.dsiMapViewerMainSetMetricSystem(n);
    }

    private void handleShowFavoritesToggle() {
        this.logger.trace("handleShowFavoritesToggle()");
        this.target.showFavorites(!this.target.datapool.isMainMapShowFavoritesIcons());
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleToggleBrandMarker() {
        this.logger.trace("handleToggleBrandMarker()");
        boolean bl = !this.target.datapool.isMainMapShowBrandIcons();
        this.target.changeBrandIconStyle(bl);
    }

    @Override
    public void onUnitChanged(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("onUnitChanged(), type=").append(n).append(",unit=").append(n2).log();
        }
        int n3 = this.target.convertTempUnitSystem2DSI(n2);
        this.target.notifierDSI.dsiMapViewerMainSetTemperatureScale(n3);
    }

    private void resetShowFavorites() {
        this.logger.trace("resetShowFavorites()");
        this.target.showFavorites(true);
    }

    private void resetShowPOI() {
        this.logger.trace("resetShowPOI()");
        this.target.notifierDSI.dsiMapViewerMainSetGeneralPoiVisibility(this.target.datapool.isMainMapShowPoiIcons());
    }

    synchronized void setUpdateHomeFavorite(boolean bl, MapFlag[] mapFlagArray) {
        if (bl) {
            if (mapFlagArray != null && mapFlagArray.length > 0) {
                this.homeFavoriteUpdateList.add(mapFlagArray);
                ++this.updateHomeFavorite;
            }
        } else if (this.updateHomeFavorite > 0) {
            --this.updateHomeFavorite;
            this.homeFavoriteUpdateList.remove(0);
        }
    }

    private MapFlag[] isUpdateHomeFavorite() {
        if (this.updateHomeFavorite > 0) {
            return (MapFlag[])this.homeFavoriteUpdateList.get(0);
        }
        return null;
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.logger.trace("handleAslSystemResetNavigationSettings()");
        this.target.datapool.clear();
        this.resetShowFavorites();
        this.resetShowPOI();
        try {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().resetToDefaults();
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
        }
        this.target.setPersistedModelValues();
        this.navigationResetParticipant.notifyResetDone();
    }
}


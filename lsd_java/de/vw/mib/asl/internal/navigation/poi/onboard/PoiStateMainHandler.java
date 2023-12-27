/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.ASLNavigationSldeFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.ASLNavigationDP;
import de.vw.mib.asl.internal.navigation.gateway.NavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiGetXt9LDBs;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndStrip;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiEvents;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateMain;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.asl.internal.navigation.util.LocationFormatter;
import de.vw.mib.asl.internal.navigation.util.LocationHelper;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import de.vw.mib.asl.internal.navigation.util.NavDebugFlagsBase;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.asl.internal.navigation.util.SpellerDataHelper;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.NavigationPOIOnlineServicesGoogleLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchLocationCollector;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public final class PoiStateMainHandler {
    private PoiHsmTarget myTarget;
    private PoiStateMain state;
    private boolean preventInfiniteLoop = false;
    private boolean wasServiceStateListenerRegistered = false;
    private boolean isWaitingForCancelSpellerResult = false;
    private int pendingUsecaseAfterCancelSpellerResult = -1;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;

    public PoiStateMainHandler(PoiStateMain poiStateMain, PoiHsmTarget poiHsmTarget) {
        this.state = poiStateMain;
        this.myTarget = poiHsmTarget;
    }

    public void targetGoOn(EventGeneric eventGeneric) {
        if (!this.wasServiceStateListenerRegistered) {
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PoiStateMainHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this.myTarget);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = PoiStateMainHandler.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco, this.myTarget);
            this.wasServiceStateListenerRegistered = true;
        }
        this.myTarget.blockedGoOnEvent = eventGeneric;
        this.myTarget.blockedGoOnEvent.setBlocked(true);
        PoiEvents.addObserver(this.myTarget);
        this.requestTopCategories();
        this.myTarget.myTrace(this.state, "NAVI_TARGET_GO_ON done");
    }

    public void initSearchArea(int n, boolean bl) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("initSearchArea() searchArea=").append(n).log();
        }
        DynamicPoiCategoryHandler.hideOnlineSearchButton();
        this.stopPreviousPoiSearches();
        this.preventInfiniteLoop = false;
        int n2 = this.handleSpecialSearchAreas(n, bl);
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("newSearchArea=").append(n2).log();
        }
        n2 = this.setReferenceLocation(n2);
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("newSearchArea=").append(n2).log();
        }
        this.traceReferenceLocation();
        this.setUseCaseDependingOnSearchArea(n2);
        ASLNavigationDP.getInstance().setPoiSearchArea(n2);
        this.myTarget.notifierModel.notifySearchAreaSelected(n2);
        this.saveSearchArea(n2);
        ASLNavigationDP.getInstance().setPoiSearchLocation(PoiDatapool.getInstance().getReferenceLocation().getLocation());
        if (PoiDatapool.getInstance().getReferenceLocation().getLocationType() != 0) {
            this.writeModelGetterForSelectedSearchArea(n2, PoiDatapool.getInstance().getReferenceLocation());
        }
        this.writeSearchLocationsToPersistence();
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("LocationType:").append(PoiDatapool.getInstance().getReferenceLocation().getLocationType()).log();
        }
        if (PoiDatapool.getInstance().getReferenceLocation().getLocationType() == 0) {
            if (n == 9 || n == 6) {
                this.myTarget.myTrace(this.state, "CmdTransformAndStrip");
                this.traceReferenceLocation();
                new CmdTransformAndStrip(this.state, PoiDatapool.getInstance().getReferenceLocation().getLocation(), 16).execute();
            } else {
                this.myTarget.myTrace(this.state, "CmdGetLocationDescriptionTransform");
                this.traceReferenceLocation();
                new CmdGetLocationDescriptionTransform(this.state, PoiDatapool.getInstance().getReferenceLocation().getLocation()).execute();
            }
        } else {
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        }
    }

    public void startPoiSearch(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("startPoiSearch() useCase=").append(n).log();
        }
        int n2 = this.mapUseCaseToInternalUseCase(n);
        PoiDatapool.getInstance().setCurrentUseCase(n2);
        this.setCcpAsReference();
        PoiDatapool.getInstance().setPoiActiveFlag(true);
        this.myTarget.clearAllModelData();
        this.myTarget.getDsiNavigation().poiSetListStyle(1);
        if (DynamicPoiCategoryHandler.isUseCaseTopPoiSearch() || DynamicPoiCategoryHandler.isUseCaseFuelWarningSearch()) {
            int n3 = PoiDatapool.getInstance().getFilterCategoryUid();
            if (n3 != -1) {
                DynamicPoiCategoryHandler.updateByOnboardUid(n3);
            }
        } else {
            DynamicPoiCategoryHandler.hideOnlineSearchButton();
        }
        if (3 != n) {
            PoiDatapool.getInstance().setFilterName(ASLNavigationSldeFactory.getNavigationSldeApi().getSldeSpellerData().getEnteredText());
        }
    }

    private int setReferenceLocation(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("setReferenceLocation() searchArea=").append(n).log();
        }
        PoiDatapool.getInstance().setReferenceDirection(0);
        Route route = ASLNavigationDP.getInstance().getCurrentRoute();
        switch (n) {
            case 1: {
                this.setCcpAsReference();
                break;
            }
            case 3: {
                if (route == null) break;
                PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(route.routelist[route.routelist.length - 1].getRouteLocation()));
                break;
            }
            case 4: {
                if (route != null && route.getRoutelist() != null) {
                    RouteDestination[] routeDestinationArray = route.getRoutelist();
                    int n2 = routeDestinationArray.length - 1;
                    for (int i2 = (int)route.getIndexOfCurrentDestination(); i2 < routeDestinationArray.length - 1; ++i2) {
                        if (route.getRoutelist()[i2] == null || routeDestinationArray[i2].getDestinationType() != 1) continue;
                        n2 = i2;
                        break;
                    }
                    PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(routeDestinationArray[n2].getRouteLocation()));
                    if (n2 != routeDestinationArray.length - 1) break;
                    n = 3;
                    break;
                }
                n = 1;
                this.setCcpAsReference();
                break;
            }
            case 5: {
                if (route == null) break;
                PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(route.routelist[route.routelist.length - 1].getRouteLocation()));
                break;
            }
            case 6: {
                if (PersistedPoiSetup.getInstance().getLocationForSearchAreaAddress() == null) {
                    this.setCcpAsReference();
                    break;
                }
                PoiDatapool.getInstance().getReferenceLocation().setLocation(PersistedPoiSetup.getInstance().getLocationForSearchAreaAddress());
                break;
            }
            case 2: {
                if (PersistedPoiSetup.getInstance().getLocationForSearchAreaMap() == null) {
                    this.setCcpAsReference();
                    break;
                }
                PoiDatapool.getInstance().getReferenceLocation().setLocation(PersistedPoiSetup.getInstance().getLocationForSearchAreaMap());
                break;
            }
            case 9: {
                if (PersistedPoiSetup.getInstance().getLocationForSearchAreaAddress() == null) {
                    this.setCcpAsReference();
                    break;
                }
                PoiDatapool.getInstance().getReferenceLocation().setLocation(PersistedPoiSetup.getInstance().getLocationForSearchAreaAddress());
                break;
            }
            case 12: {
                if (ASLNavigationDP.getInstance().getCrosshairLocation() != null) {
                    PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(ASLNavigationDP.getInstance().getCrosshairLocation()));
                    break;
                }
                this.myTarget.myError(this.state, "Error - NavLocation==null!");
                this.setCcpAsReference();
                break;
            }
            case 11: {
                if (ASLNavigationDP.getInstance().getDestInputLocation() != null) {
                    PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(ASLNavigationDP.getInstance().getDestInputLocation()));
                    break;
                }
                this.myTarget.myError(this.state, "Error - NavLocation==null!");
                this.setCcpAsReference();
                break;
            }
            default: {
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this.state).append("Search area not handled:").append(ASLNavigationDP.getInstance().getPoiSearchArea()).log();
            }
        }
        return n;
    }

    public void searchStart() {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("searchStart currentUseCase=").append(PoiDatapool.getInstance().getCurrentUseCase()).log();
        }
        this.preparePoiSearch(false, false);
        switch (PoiDatapool.getInstance().getCurrentUseCase()) {
            case 14: {
                this.setNameFilter();
                this.clearSpelledData();
                this.setCcpAsReference();
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
                break;
            }
            case 11: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiCategoryGroup);
                break;
            }
            case 12: {
                this.setCcpAsReference();
                this.myTarget.transAfterCallback(this.myTarget.statePoiCategoryGroup);
                break;
            }
            case 16: 
            case 18: {
                this.setCcpAsReference();
            }
            case 15: 
            case 17: {
                this.performCancelSpeller(PoiDatapool.getInstance().getCurrentUseCase());
                this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
                this.setNameFilter();
                this.setCategoryFilter(PoiDatapool.getInstance().getCategoryUidForUidSearch());
                this.clearSpelledData();
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 20: {
                this.performCancelSpeller(PoiDatapool.getInstance().getCurrentUseCase());
                break;
            }
            case 0: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementNoSurrounding);
                break;
            }
            case 32783: {
                this.setCategoryFilter(PoiDatapool.getInstance().getCategoryUidForUidSearch());
                this.setNameFilter();
                this.clearSpelledData();
                PoiDatapool.getInstance().setAreaLocation(PoiDatapool.getInstance().getReferenceLocation());
                this.setCcpAsReference();
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementNoSurrounding);
                break;
            }
            case 2: {
                PoiStateDetail.currentDestinationLocation = PoiStateElementNoSurrounding.poiFromMapLocation;
                this.myTarget.transAfterCallback(this.myTarget.statePoiDetail);
                break;
            }
            default: {
                this.myTarget.myError(this.state, "Unknown use case - can't start POI search");
            }
        }
    }

    private void setUseCaseDependingOnSearchArea(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("setUseCaseDependingOnSearchArea() searchArea=").append(n).log();
        }
        switch (n) {
            case 1: {
                PoiDatapool.getInstance().setCurrentUseCase(11);
                break;
            }
            case 3: {
                PoiDatapool.getInstance().setCurrentUseCase(11);
                break;
            }
            case 4: {
                PoiDatapool.getInstance().setCurrentUseCase(11);
                break;
            }
            case 5: {
                PoiDatapool.getInstance().setCurrentUseCase(12);
                break;
            }
            case 6: {
                PoiDatapool.getInstance().setCurrentUseCase(0xF800000);
                break;
            }
            case 2: {
                PoiDatapool.getInstance().setCurrentUseCase(11);
                break;
            }
            case 9: {
                PoiDatapool.getInstance().setCurrentUseCase(0xF800000);
                break;
            }
            case 11: {
                PoiDatapool.getInstance().setCurrentUseCase(11);
                break;
            }
            case 12: {
                PoiDatapool.getInstance().setCurrentUseCase(11);
                break;
            }
            default: {
                this.myTarget.myError(this.state, "Search-area not defined!");
            }
        }
    }

    private int handleSpecialSearchAreas(int n, boolean bl) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("handleSpecialSearchAreas() searchArea=").append(n).log();
        }
        int n2 = n;
        if (n == 0) {
            n2 = NavGateway.getInstance().isRgActive() ? PersistedPoiSetup.getInstance().getSearchAreaActiveGuidance() : PersistedPoiSetup.getInstance().getSearchAreaNoGuidance();
        } else if (n == 10) {
            n2 = PoiDatapool.getInstance().getLastSearchArea();
        } else if (n == 12) {
            PoiDatapool.getInstance().setSelectedCategoryUid(-1);
            this.clearFilters();
            this.clearSpelledData();
        } else if (n == 11) {
            PoiDatapool.getInstance().setSelectedCategoryUid(-1);
            this.clearFilters();
            this.clearSpelledData();
        } else if (n == 13) {
            PoiDatapool.getInstance().setSelectedCategoryUid(-1);
            this.clearFilters();
            this.clearPOINameData();
            this.clearNameSpellerHistory();
            n2 = NavGateway.getInstance().isRgActive() ? PersistedPoiSetup.getInstance().getSearchAreaActiveGuidance() : PersistedPoiSetup.getInstance().getSearchAreaNoGuidance();
        } else if (n == 7) {
            PersistedPoiSetup.getInstance().setLocationForSearchAreaAddress(ASLNavigationDP.getInstance().getDestInputLocation());
            n2 = 6;
        }
        if (bl && n2 == 5) {
            this.clearNameSpellerHistory();
            n2 = 3;
        }
        return n2;
    }

    private void clearNameSpellerHistory() {
        PoiDatapool.getInstance().setFreetextSpellerPreviousInputString(null);
    }

    private void selectTopCategory(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("Top category index:").append(n).append(" selected.").log();
        }
        int n2 = this.getTopPoiCategory(n);
        PoiDatapool.getInstance().setLastSelectedTopPoiUid(n2);
        PoiDatapool.getInstance().setFilterCategoryUid(PoiDatapool.getInstance().getLastSelectedTopPoiUid());
        PoiDatapool.getInstance().setSelectedCategoryUid(n2);
        PoiDatapool.getInstance().setSelectedCategoryName(PoiDatapool.getInstance().getTopPoiCategoryName(n2));
        this.myTarget.notifierModel.notifySelectedCategoryName(PoiDatapool.getInstance().getSelectedCategoryName());
        PoiDatapool.getInstance().setEnteredName("");
        this.myTarget.notifierModel.notifyEnteredName(PoiDatapool.getInstance().getEnteredName());
        PoiDatapool.getInstance().setFilterName("");
        this.myTarget.notifierModel.notifyNameFilter(PoiDatapool.getInstance().getFilterName());
        PoiDatapool.getInstance().setCurrentUseCase(4);
    }

    private int getTopPoiCategory(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.trace().append("Top Poi Categories! Selection does not implemented!").log();
            }
        }
        return PoiDatapool.getInstance().getTopPoiCategoryUid(n2);
    }

    public void initPoiCategories() {
        this.myTarget.myTrace(this.state, "initPoiCategories");
        this.myTarget.clearAllModelData();
        this.myTarget.transAfterCallback(this.myTarget.statePoiCategoryGroup);
    }

    public void clearAllButton() {
        this.myTarget.myTrace(this.state, "clearAllButton");
        this.clearFilters();
        this.clearPOINameData();
        this.clearNameSpellerHistory();
        PoiDatapool.getInstance().setCategoryUidForUidSearch(-1);
        PoiDatapool.getInstance().setSelectedCategoryUid(-1);
        this.myTarget.notifierModel.notifySelectedCategoryName(PoiDatapool.getInstance().getSelectedCategoryName());
        this.myTarget.notifierModel.notifyEnteredName(PoiDatapool.getInstance().getEnteredName());
        if (ASLNavigationDP.getInstance().getPoiSearchArea() == 9 || ASLNavigationDP.getInstance().getPoiSearchArea() == 6) {
            this.myTarget.myTrace(this.state, "CmdTransformAndStrip");
            this.setCcpAsReference();
            new CmdTransformAndStrip(this.state, PoiDatapool.getInstance().getReferenceLocation().getLocation(), 16).execute();
        } else {
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        }
    }

    public void searchStartWithoutCategorySelection() {
        this.myTarget.myTrace(this.state, "searchStartWithoutCategorySelection");
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        if (PoiDatapool.getInstance().getCurrentUseCase() == 11) {
            PoiDatapool.getInstance().setCurrentUseCase(15);
        } else if (PoiDatapool.getInstance().getCurrentUseCase() == 12) {
            PoiDatapool.getInstance().setCurrentUseCase(16);
        }
        PoiDatapool.getInstance().setCategoryUidForUidSearch(PoiDatapool.getInstance().getSelectedCategoryUid());
        this.searchStart();
    }

    public void continueToDetailView() {
        this.myTarget.myTrace(this.state, "continueToDetailView");
        this.setCcpAsReference();
        this.searchStart();
    }

    private void stopPreviousPoiSearches() {
        this.myTarget.myTrace(this.state, "stopPreviousPoiSearches");
        PoiStateElementSurrounding.ignoreUpdates = true;
        PoiStateElementNoSurrounding.stopRequestingValueList = true;
        PoiAbstractElementCommon.continueSearch = false;
        PoiAbstractElementCommon.isOnboardDualListViewActive = false;
        PoiAbstractElementCommon.searchIsRunning = false;
    }

    private void saveSearchArea(int n) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("saveSearchArea() searchArea=").append(n).log();
        }
        if (n != 12 && n != 11) {
            if (NavGateway.getInstance().isRgActive()) {
                PersistedPoiSetup.getInstance().setSearchAreaActiveGuidance(n);
            } else {
                PersistedPoiSetup.getInstance().setSearchAreaNoGuidance(n);
            }
        }
        PoiDatapool.getInstance().setLastSearchArea(n);
    }

    private void writeModelGetterForSelectedSearchArea(int n, ILocationWrapper iLocationWrapper) {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("writeModelGetterForSelectedSearchArea() searchArea=").append(n).log();
        }
        this.myTarget.myTrace(this.state, iLocationWrapper.toString());
        GenericASLList genericASLList = ListManager.getGenericASLList(3099);
        NavigationPOISearchLocationCollector navigationPOISearchLocationCollector = (NavigationPOISearchLocationCollector)genericASLList.getRowItemCacheOnly(0);
        navigationPOISearchLocationCollector.navigation_poi_search_location_address_details_for_fix_formatter = LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
        navigationPOISearchLocationCollector.navigation_poi_search_location_province = iLocationWrapper.getProvince();
        navigationPOISearchLocationCollector.navigation_poi_search_location_city = iLocationWrapper.getCity();
        navigationPOISearchLocationCollector.navigation_poi_search_location_guideable = iLocationWrapper.isNavigable();
        navigationPOISearchLocationCollector.navigation_poi_search_location_resolved = true;
        genericASLList.updateList(new NavigationPOISearchLocationCollector[]{navigationPOISearchLocationCollector});
        GenericASLList genericASLList2 = ListManager.getGenericASLList(3760);
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = new NavigationPOIOnlineServicesGoogleLocationCollector();
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_direction = 0;
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_address_details_for_fix_formatter = LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
        genericASLList2.updateList(new NavigationPOIOnlineServicesGoogleLocationCollector[]{navigationPOIOnlineServicesGoogleLocationCollector});
        this.myTarget.notifierModel.notifySelectedCategoryName(PoiDatapool.getInstance().getSelectedCategoryName());
        this.myTarget.notifierModel.notifyEnteredName(PoiDatapool.getInstance().getEnteredName());
    }

    private void setCategoryFilter(int n) {
        this.myTarget.myTrace(this.state, "setCategoryFilter");
        PoiDatapool.getInstance().setFilterCategoryUid(n);
    }

    private void setNameFilter() {
        this.myTarget.myTrace(this.state, "setNameFilter");
        if (PoiDatapool.getInstance().getFilterNameWithSeparators() != null && PoiDatapool.getInstance().getFilterNameWithSeparators().length() > 0) {
            this.setNameFilter(PoiDatapool.getInstance().getFilterNameWithSeparators());
        } else if (PoiDatapool.getInstance().getCurrentUseCase() == 14) {
            this.setNameFilter(PoiDatapool.getInstance().getFilterName());
        } else {
            this.setNameFilter(PoiDatapool.getInstance().getEnteredName());
        }
    }

    private void setNameFilter(String string) {
        this.myTarget.myTrace(this.state, "setNameFilter");
        PoiDatapool.getInstance().setFilterName(string);
    }

    private void clearFilters() {
        this.myTarget.myTrace(this.state, "clearFilters");
        PoiDatapool.getInstance().setFilterCategoryUid(-1);
        PoiDatapool.getInstance().setFilterName("");
        PoiDatapool.getInstance().setSelectedCategoryName("");
    }

    private void clearSpelledData() {
        SpellerDataHelper.clear(PoiDatapool.getInstance().getSpellerData());
        PoiDatapool.getInstance().getSpellerData().setCursorPosition(0);
    }

    private void clearPOINameData() {
        PoiDatapool.getInstance().setEnteredName("");
        PoiDatapool.getInstance().setFilterNameWithSeparators("");
        this.clearSpelledData();
    }

    public void fuelWarning(int n) {
        this.myTarget.myTrace(this.state, "fuelWarning");
        PoiDatapool.getInstance().setCurrentUseCase(n);
        this.setCcpAsReference();
        this.searchStart();
    }

    public void startPoiSearchWithCategoryUid(int n, int n2) {
        this.myTarget.myTrace(this.state, "startPoiSearchWithCategoryUid()");
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("CategoryUID:").append(n).append("  SearchArea:").append(n2).log();
        }
        this.setReferenceLocation(n2);
        this.setUseCaseDependingOnSearchArea(n2);
        if (PoiDatapool.getInstance().getCurrentUseCase() == 11) {
            PoiDatapool.getInstance().setCurrentUseCase(17);
        } else if (PoiDatapool.getInstance().getCurrentUseCase() == 12) {
            PoiDatapool.getInstance().setCurrentUseCase(18);
        } else {
            this.myTarget.myError(this.state, "NavLocation from map is null");
        }
        this.myTarget.clearAllModelData();
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        PoiDatapool.getInstance().setCategoryUidForUidSearch(n);
        this.searchStart();
    }

    public void selectPoiFromMap(EventGeneric eventGeneric) {
        this.myTarget.myTrace(this.state, "selectPoiFromMap");
        PoiDatapool.getInstance().setCurrentUseCase(2);
        PoiStateElementNoSurrounding.poiFromMapLocation = (NavLocation)eventGeneric.getObject(0);
        if (PoiStateElementNoSurrounding.poiFromMapLocation == null) {
            this.myTarget.myError(this.state, "NavLocation from map is null");
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append(PoiStateElementNoSurrounding.poiFromMapLocation.toString()).log();
        }
        this.myTarget.notifierModel.notifyClickedTmcOnMap();
    }

    public void selectPoiStackFromMap(EventGeneric eventGeneric) {
        NavLocation navLocation;
        this.myTarget.myTrace(this.state, "selectPoiStackFromMap");
        this.myTarget.notifierModel.notifyClickedPoiStackOnMap();
        PoiDatapool.getInstance().setCurrentUseCase(0);
        PoiStateElementNoSurrounding.poiFromMapLocation = navLocation = (NavLocation)eventGeneric.getObject(0);
    }

    public void selectPoiStackFromMapFinished() {
        this.myTarget.myTrace(this.state, "selectPoiStackFromMapFinished");
        this.setCcpAsReference();
        this.searchStart();
    }

    public void selectGeoPositionFromMap(EventGeneric eventGeneric) {
        this.myTarget.myTrace(this.state, "selectGeoPositionFromMap");
        if ((NavLocation)eventGeneric.getObject(0) != null) {
            PersistedPoiSetup.getInstance().setLocationForSearchAreaMap(LocationHelper.cloneLocation((NavLocation)eventGeneric.getObject(0)));
        } else {
            this.myTarget.myError(this.state, "NavLocation from map input is NULL!");
        }
    }

    public void selectTopPoiCategory(EventGeneric eventGeneric) {
        this.myTarget.myTrace(this.state, "selectTopPoiCategory");
        PoiDatapool.getInstance().setCurrentUseCase(4);
        this.setCcpAsReference();
        this.selectTopCategory(eventGeneric.getInt(0));
        this.myTarget.clearAllModelData();
        int n = PoiDatapool.getInstance().getLastSelectedTopPoiUid();
        DynamicPoiCategoryHandler.updateByOnboardUid(n);
        if (!this.isWaitingForCancelSpellerResult) {
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        }
    }

    public void batteryWarning(EventGeneric eventGeneric) {
        boolean bl = NavGateway.getInstance().isRgActive();
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("batteryWarning mode:").append(bl ? "RG active" : "RG inactive").log();
        }
        if (bl) {
            this.fuelWarning(9);
        } else {
            this.fuelWarning(10);
        }
    }

    public void stopRunningSearch() {
        this.myTarget.myTrace(this.state, "stopRunningSearch");
        PoiDatapool.getInstance().setPoiActiveFlag(false);
        this.stopPreviousPoiSearches();
        this.performCancelSpeller(-1);
    }

    public void initFreetextSpellerMode(int n) {
        this.myTarget.myTrace(this.state, "initFreetextSpellerMode");
        switch (n) {
            case 0: {
                this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
                break;
            }
            case 1: {
                this.clearSpelledData();
                PoiDatapool.getInstance().setAreaLocation(PoiDatapool.getInstance().getReferenceLocation());
                this.setCcpAsReference();
                if (NavDebugFlagsBase.getASLDebugFlag("REQUEST_XT9_DATABASE_STRINGS_DISABLED")) {
                    this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
                    break;
                }
                this.getXT9LDBs();
                break;
            }
            default: {
                if (!this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) break;
                this.myTarget.makeError(this.state).append("Error! Unknown speller mode ").append(n).log();
            }
        }
        PoiDatapool.getInstance().setFreetextSpellerMode(n);
    }

    void enterFreetextSpeller(boolean bl) {
        this.myTarget.myTrace(this.state, "enterFreetextSpeller");
        this.preparePoiSearch(bl, bl);
        PoiDatapool.getInstance().setCategoryUidForUidSearch(PoiDatapool.getInstance().getSelectedCategoryUid());
        this.setNameFilter(PoiDatapool.getInstance().getEnteredName());
        this.clearSpelledData();
        this.myTarget.transAfterCallback(this.myTarget.statePoiFreetextSpeller);
    }

    private void traceReferenceLocation() {
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append(PoiDatapool.getInstance().getReferenceLocation().toString()).log();
        }
    }

    private void writeSearchLocationsToPersistence() {
        this.myTarget.myTrace(this.state, "writeSearchLocationsToPersistence");
        if (ASLNavigationDP.getInstance().getPoiSearchArea() == 2) {
            PersistedPoiSetup.getInstance().setLocationForSearchAreaMap(LocationHelper.cloneLocation(PoiDatapool.getInstance().getReferenceLocation().getLocation()));
        } else if (ASLNavigationDP.getInstance().getPoiSearchArea() == 6 || ASLNavigationDP.getInstance().getPoiSearchArea() == 9) {
            PersistedPoiSetup.getInstance().setLocationForSearchAreaAddress(LocationHelper.cloneLocation(PoiDatapool.getInstance().getReferenceLocation().getLocation()));
        }
    }

    private void getXT9LDBs() {
        this.myTarget.myTrace(this.state, "initFreetextSpellerMode");
        int n = 0;
        switch (PoiDatapool.getInstance().getLastSearchArea()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 11: 
            case 12: {
                n = 1;
                break;
            }
            case 5: {
                n = 2;
                break;
            }
            case 9: {
                n = 3;
                break;
            }
            default: {
                n = 0;
                this.myTarget.myError(this.state, "No mapping for current search area to XT9 mode available! Common LDB used.");
            }
        }
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append("mode: ").append(n).log();
            this.myTarget.makeTrace(this.state).append("NavLocation: ").append(PoiDatapool.getInstance().getReferenceLocation().toString()).log();
        }
        if (n != 0) {
            new CmdPoiGetXt9LDBs(this.state, PoiDatapool.getInstance().getAreaLocation().getLocation(), n).execute();
        } else {
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        }
    }

    private void performCancelSpeller(int n) {
        this.myTarget.myTrace(this.state, "performCancelSpeller");
        if (n == -1) {
            int n2 = PoiDatapool.getInstance().getCurrentUseCase();
            this.myTarget.makeTrace(this.state).append("PoiDatapool.currentUseCase=").append(n2).log();
            if (n2 != 11) {
                new CmdCancelSpeller(this.state).execute();
                this.isWaitingForCancelSpellerResult = true;
            } else {
                this.isWaitingForCancelSpellerResult = false;
            }
        } else {
            new CmdCancelSpeller(this.state).execute();
            this.isWaitingForCancelSpellerResult = true;
        }
        this.pendingUsecaseAfterCancelSpellerResult = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
        this.myTarget.myCmdTrace(this.state, cmdCancelSpeller);
        try {
            if (cmdCancelSpeller.liResult_ReturnCode != 0L) {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeError(this.state).append("Error! returnCode=").append(cmdCancelSpeller.liResult_ReturnCode).log();
                }
                return;
            }
            if (this.isWaitingForCancelSpellerResult) {
                this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
                if (PoiDatapool.getInstance().getCurrentUseCase() == this.pendingUsecaseAfterCancelSpellerResult && this.pendingUsecaseAfterCancelSpellerResult >= 0) {
                    this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
                }
            }
        }
        finally {
            this.isWaitingForCancelSpellerResult = false;
            this.pendingUsecaseAfterCancelSpellerResult = -1;
        }
    }

    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.myTarget.myCmdTrace(this.state, cmdGetLocationDescriptionTransform);
        PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation));
        this.traceReferenceLocation();
        this.writeSearchLocationsToPersistence();
        ASLNavigationDP.getInstance().setPoiSearchLocation(PoiDatapool.getInstance().getReferenceLocation().getLocation());
        this.writeModelGetterForSelectedSearchArea(PoiDatapool.getInstance().getLastSearchArea(), PoiDatapool.getInstance().getReferenceLocation());
        this.myTarget.notifierModel.notifySearchAreaSelected(PoiDatapool.getInstance().getLastSearchArea());
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    public void handleCommandCmdTransformAndStrip(CmdTransformAndStrip cmdTransformAndStrip) {
        this.myTarget.myCmdTrace(this.state, cmdTransformAndStrip);
        PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(cmdTransformAndStrip.location));
        this.traceReferenceLocation();
        this.writeSearchLocationsToPersistence();
        ASLNavigationDP.getInstance().setPoiSearchLocation(PoiDatapool.getInstance().getReferenceLocation().getLocation());
        this.writeModelGetterForSelectedSearchArea(PoiDatapool.getInstance().getLastSearchArea(), PoiDatapool.getInstance().getReferenceLocation());
        this.myTarget.notifierModel.notifySearchAreaSelected(PoiDatapool.getInstance().getLastSearchArea());
        if (!PoiDatapool.getInstance().getReferenceLocation().isCountryAvailable() && !this.preventInfiniteLoop) {
            PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(ASLNavigationDP.getInstance().getDefaultLocation()));
            new CmdTransformAndStrip(this.state, PoiDatapool.getInstance().getReferenceLocation().getLocation(), 16).execute();
            this.preventInfiniteLoop = true;
        } else {
            this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
        }
    }

    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        this.myTarget.myCmdTrace(this.state, cmdSetLiValueListWindowSize);
        if (cmdSetLiValueListWindowSize.liResult_ReturnCode != 0L) {
            this.myTarget.myError(this.state, "CmdSetLiValueListWindowSize failded.");
            return;
        }
    }

    public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
        this.myTarget.myCmdTrace(this.state, cmdPoiGetXt9LDBs);
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            for (int i2 = 0; i2 < cmdPoiGetXt9LDBs.poiGetXt9LdbResult_xt9Databases.length; ++i2) {
                String string = cmdPoiGetXt9LDBs.poiGetXt9LdbResult_xt9Databases[i2];
                if (string != null) {
                    this.myTarget.makeTrace(this.state).append("LDB ").append(i2).append(": ").append(string).log();
                    continue;
                }
                this.myTarget.makeError(this.state).append("LDB ").append(i2).append(": is NULL!").log();
            }
            if (cmdPoiGetXt9LDBs.poiGetXt9LdbResult_xt9Databases.length == 0) {
                this.myTarget.makeTrace(this.state).append("No LDB names available -> use common LDB").log();
            }
        }
        PoiDatapool.getInstance().setXt9Databases(cmdPoiGetXt9LDBs.poiGetXt9LdbResult_xt9Databases);
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    public void dsiCarEcoUpdateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        if (n == 1 && bCmECurrentRange != null && bCmECurrentRange.rangeValuePrimary != -16842752 && bCmECurrentRange.rangeValuePrimary != -65536) {
            if (bCmECurrentRange.rangeUnit == 1) {
                PoiDatapool.getInstance().setRemainingBatteryRange(NaviHelper.getInstance().milesToKm(bCmECurrentRange.rangeValuePrimary) * 100);
            } else {
                PoiDatapool.getInstance().setRemainingBatteryRange(bCmECurrentRange.rangeValuePrimary * 100);
            }
        }
    }

    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        this.myTarget.myTrace(this.state, "dsiNavigationUpdatePersonalPOISearchStatus");
        if (n == 1 && (navDataBaseArray == null || navDataBaseArray.length == 0) && PoiDatapool.getInstance().isPoiActiveFlag()) {
            this.myTarget.myTrace(this.state, "resetNavigationModel");
            NaviHelper.getInstance().resetNavigationModel();
        }
    }

    public void onActivated(ISpellerContext iSpellerContext) {
        this.myTarget.myTrace(this.state, "onActivated()");
        this.traceReferenceLocation();
        iSpellerContext.setLocation(PoiDatapool.getInstance().getReferenceLocation().getLocation());
    }

    public void onLocationSaved(ISpellerContext iSpellerContext) {
        this.myTarget.myTrace(this.state, "onLocationSaved");
        PoiDatapool.getInstance().getReferenceLocation().setLocation(LocationHelper.cloneLocation(iSpellerContext.getLocation()));
        this.writeSearchLocationsToPersistence();
    }

    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.myTarget.myTrace(this.state, "onLocationDiscarded");
    }

    public void onContext(ISpellerContext iSpellerContext) {
        this.myTarget.myTrace(this.state, "onContext");
        this.traceReferenceLocation();
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append(iSpellerContext.getLocation()).append(")").log();
        }
    }

    private void preparePoiSearch(boolean bl, boolean bl2) {
        this.myTarget.myTrace(this.state, "preparePoiSearch");
        PoiDatapool.getInstance().setPoiActiveFlag(true);
        this.myTarget.clearAllModelData();
        if (bl) {
            this.clearFilters();
        }
        if (bl2) {
            PoiDatapool.getInstance().setSelectedCategoryUid(-1);
        }
        this.stopPreviousPoiSearches();
        this.myTarget.getDsiNavigation().poiSetListStyle(0);
        if (DynamicPoiCategoryHandler.isUseCaseTopPoiSearch() || DynamicPoiCategoryHandler.isUseCaseFuelWarningSearch()) {
            int n = PoiDatapool.getInstance().getSelectedCategoryUid();
            if (n != -1) {
                DynamicPoiCategoryHandler.updateByOnboardUid(n);
            }
        } else {
            DynamicPoiCategoryHandler.hideOnlineSearchButton();
        }
        PoiDatapool.getInstance().setCcp(new LocationWrapper(NavGateway.getInstance().getSoPosPosition().latitude, NavGateway.getInstance().getSoPosPosition().longitude));
    }

    public void prepareSelectPoiFromMap(EventGeneric eventGeneric) {
        this.myTarget.myTrace(this.state, "prepareSelectPoiFromMap");
        PoiStateElementNoSurrounding.poiFromMapLocation = (NavLocation)eventGeneric.getObject(0);
        if (PoiStateElementNoSurrounding.poiFromMapLocation == null) {
            this.myTarget.myError(this.state, "NavLocation from map is null");
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this.state).append(PoiStateElementNoSurrounding.poiFromMapLocation.toString()).log();
        }
        this.myTarget.notifierModel.notifyClickedTmcOnMap();
    }

    public void prepareSelectPoiStackFromMap(EventGeneric eventGeneric) {
        NavLocation navLocation;
        this.myTarget.myTrace(this.state, "prepareSelectPoiStackFromMap");
        PoiStateElementNoSurrounding.poiFromMapLocation = navLocation = (NavLocation)eventGeneric.getObject(0);
        this.myTarget.notifierModel.notifyClickedPoiStackOnMap();
    }

    public void prepareSelectTopPoiCategory(EventGeneric eventGeneric) {
        this.myTarget.myTrace(this.state, "prepareSelectTopPoiCategory");
        this.selectTopCategory(eventGeneric.getInt(0));
        int n = PoiDatapool.getInstance().getLastSelectedTopPoiUid();
        DynamicPoiCategoryHandler.updateByOnboardUid(n);
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    public void requestTopCategories() {
        this.myTarget.myTrace(this.state, "requestTopCategories()");
        this.myTarget.transAfterCallback(this.myTarget.statePoiTopCategories);
    }

    private void setCcpAsReference() {
        this.myTarget.myTrace(this.state, "setCcpAsReference");
        PoiDatapool.getInstance().setReferenceLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition()));
        PoiDatapool.getInstance().setReferenceDirection(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getDirectionAngle());
    }

    public void selectOnlinePoiCategory(EventGeneric eventGeneric) {
        this.myTarget.myTrace(this.state, "selectOnlinePoiCategory");
        PoiDatapool.getInstance().setCurrentUseCase(4);
        this.setCcpAsReference();
        this.myTarget.clearAllModelData();
        int n = eventGeneric.getInt(0);
        this.myTarget.notifierModel.notifySelectedCategoryName("");
        this.myTarget.notifierModel.notifyEnteredName("");
        DynamicPoiCategoryHandler.updateByOnlineUid(n);
        this.myTarget.notifierModel.notifyNaviPoiDataLoadFinished();
    }

    int mapUseCaseToInternalUseCase(int n) {
        this.myTarget.myTrace(this.state, "mapUseCaseToInternalUseCase");
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 14;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 5;
                break;
            }
            case 5: {
                n2 = 6;
                break;
            }
            case 6: {
                n2 = 7;
                break;
            }
            case 7: {
                n2 = 8;
                break;
            }
            case 8: {
                n2 = 9;
                break;
            }
        }
        return n2;
    }

    public void setupSlde(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 1) {
            ASLNavigationSldeFactory.getNavigationSldeApi().sldeSpellerHandlerInitXt9(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription());
        }
    }

    public void initXt9Finished() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1693454336, true);
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


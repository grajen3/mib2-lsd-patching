/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationSldeFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.AbstractDualListViewHandler;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.poi.IPersistedPoiSetup;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemHardCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.online.AbstractOnlinePoiTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiDataPool;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiEvents;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiModelNotifier;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget$1;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget$2;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget$3;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget$4;
import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.ResultListCollector;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.NavigationPOIOnlineServicesGoogleLocationCollector;
import java.util.ArrayList;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public final class OnlinePoiTarget
extends AbstractOnlinePoiTarget
implements ASLListElementFetcher,
ASLOnlineServiceListener {
    private static final String RESOLVE_FAKE_NAV_LOCATION;
    private static final String FAKE_LOCATION;
    private static final String RESULT_LIST_COLLECTOR;
    private static final String CURRENT_INDEX_OF_FIRST_ITEM;
    private static final String CURRENT_TOTAL_ITEMS;
    private static final String SERVICE_ID_STRING;
    private static final INavigationDP NAVIGATION_DP;
    private static final OnlinePoiDataPool DATAPOOL;
    OnlinePoiModelNotifier model;
    private SpellerData spellerData = new SpellerData();
    private String searchString;
    private AbstractDualListViewHandler dualListHandler;
    int lastDsiDynPoiCategory;
    private boolean vicinityModeActive;
    Vector onlinePoiSearchResultsForSlde = new Vector();
    NavLocation currentSearchLocation;
    ASLOnlineCoreServices coreServices;
    GenericASLList poiOnlineResultList;
    private static boolean registered;
    String dynamicPoiServiceId = null;
    private boolean onlineServiceFirstUpdate = true;
    private boolean searchCanceled;
    int searchState = 3;
    private int selectedIndex = -1;
    private IntObjectOptHashMap precheckMap = new IntObjectOptHashMap();
    private boolean onlineServiceAvailable = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearchListener;

    public static boolean isOnlinePoiReady() {
        return registered;
    }

    public OnlinePoiTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.printTrace("NAVI_TARGET_PREPARE_ON");
                this.model = new OnlinePoiModelNotifier();
                this.coreServices = ASLOnlineFactory.getOnlineCoreServices();
                break;
            }
            case 101001: {
                this.printTrace("NAVI_TARGET_GO_ON");
                this.registerDSIServiceStateListener();
                this.initializeResultList();
                this.onlineServiceFirstUpdate = true;
                this.coreServices.registerForServiceUpdate(this.coreServices.getServiceIDWithNumericServiceID(4), this);
                this.searchState = 3;
                this.model.setSearchState(this.searchState);
                break;
            }
            case 101002: {
                this.printTrace("NAVI_TARGET_PREPARE_OFF");
                this.poiOnlineResultList.disableWindowing();
                break;
            }
            case 101000: {
                this.printTrace("NAVI_TARGET_GO_OFF");
                this.coreServices.unRegisterForServiceUpdate(this.coreServices.getServiceIDWithNumericServiceID(4), this);
                break;
            }
            case 1073744519: {
                this.printTrace("SEARCH_SPELLER_INIT");
                this.caseSpellerInit();
                break;
            }
            case 1073744515: {
                this.printTrace("SEARCH_SET_NAME_SET_CHAR");
                this.caseSpellerSetChar(eventGeneric);
                break;
            }
            case 1073744514: {
                this.printTrace("SEARCH_SET_NAME_DEL_CHAR");
                this.caseSpellerDelChar();
                break;
            }
            case 1073744516: {
                this.printTrace("SEARCH_SET_NAME_SET_CURSOR_POSITION");
                this.caseSpellerSetCursorPosition(eventGeneric);
                break;
            }
            case 1073744513: {
                this.printTrace("SEARCH_SET_NAME");
                this.caseSpellerSave();
                break;
            }
            case 1074841925: {
                break;
            }
            case 1073744520: {
                this.printTrace("SEARCH_START");
                this.caseStartSearch();
                break;
            }
            case 1073744523: {
                this.printTrace("SEARCH_STOP");
                this.caseCancelSearch();
                break;
            }
            case 1073744547: {
                this.printTrace("REQUEST_NEXT_PAGE");
                this.caseRequestNextPage();
                break;
            }
            case 1073744503: {
                this.printTrace("RESULT_SELECT_DETAILS");
                this.caseResultSelectDetails(eventGeneric);
                break;
            }
            case 1073744504: {
                this.printTrace("RESULT_SELECT_NEXT_DETAILS");
                this.caseResultSelectNextDetails(eventGeneric);
                break;
            }
            case 1073744505: {
                this.printTrace("RESULT_SELECT_PREV_DETAILS");
                this.caseResultSelectPrevDetails(eventGeneric);
                break;
            }
            case 1073744565: {
                this.printTrace("NOTIFY_GOOGLE_ABOUT_USED_POI");
                this.caseNotifyGoogle(eventGeneric);
                break;
            }
            case 3400009: {
                this.printTrace("ASL_NAVI_ONLINE_SERVICES_CHANGE_LANGUAGE");
                this.changeLanguage();
                break;
            }
            case 1074841853: {
                this.printTrace("START_SEARCH_DYNAMIC");
                this.caseStartSearchDynamic(eventGeneric);
                break;
            }
            case 1074841862: {
                this.printTrace("START_ONLINE_POI_VOICE_SEARCH");
                this.caseStartVoiceSearch();
                break;
            }
            case 4800003: {
                boolean bl = eventGeneric.getBoolean(0);
                this.printTrace(new StringBuffer().append("ASL_ONLINE_DESTINATIONIMPORT_ACTIVE").append(bl).toString());
                ServiceManager.aslPropertyManager.valueChangedBoolean(82841600, bl);
                break;
            }
            case 1074841946: {
                this.handleSetupSlde(eventGeneric);
                break;
            }
            case 3488002: {
                this.selectByIndexSlde(eventGeneric);
                break;
            }
            case 3492008: {
                if (!this.precheckMap.containsKey(eventGeneric.getInt(0))) {
                    this.precheckMap.put(eventGeneric.getInt(0), new ArrayList());
                }
                ((ArrayList)this.precheckMap.get(eventGeneric.getInt(0))).add(eventGeneric.getObject(1));
                this.dsiPoiOnlineSearch.precheckDynamicPOICategory(eventGeneric.getInt(0));
                break;
            }
            default: {
                this.trace("OnlinePoiTarget: Default event with id: ", eventGeneric.getReceiverEventId());
            }
        }
    }

    private void selectByIndexSlde(EventGeneric eventGeneric) {
        Integer n = (Integer)eventGeneric.getObject(54080768);
        this.selectedIndex = n;
        NavLocation navLocation = (NavLocation)eventGeneric.getObject(70857984);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        this.setPoiLocationToCurrentSearchLocation(iLocationWrapper.getLocation());
        this.updateModelDetailsScreen(iLocationWrapper);
        this.sendAslNavigationInternalSldeExternalResultResolved(n, iLocationWrapper);
    }

    private void sendAslNavigationInternalSldeExternalResultResolved(Integer n, ILocationWrapper iLocationWrapper) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverTargetId(-884272128);
        eventGeneric.setReceiverEventId(1630090496);
        eventGeneric.setObject(1646867712, iLocationWrapper.getLocation());
        eventGeneric.setObject(1663644928, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void resolveFakeNavLocation(Integer n, Vector vector, ResultListCollector[] resultListCollectorArray, Integer n2, Integer n3, String string) {
        if (n >= resultListCollectorArray.length + n2) {
            boolean bl = resultListCollectorArray.length + n2 < n3;
            this.model.setNextPageAvailable(bl);
            if (this.isTraceEnabled()) {
                this.trace().append("resolveFakeNavLocation recursion finished. isNextPageAvailable: ").append(bl);
            }
            if (this.lastServiceIdMatches(string)) {
                this.searchState = 3;
                this.model.setSearchState(this.searchState);
            }
            return;
        }
        this.searchState = 0;
        this.model.setSearchState(this.searchState);
        if (this.isTraceEnabled()) {
            this.trace().append("resolveFakeNavLocation[ listIndex:").append(n).append(", currentIndexOfFirstItem: ").append(n2).append(", currentTotalItems: ").append(n3).append(", onlinePoiSearchResultsForSlde: ").append(vector.size()).append(", nextResults: ").append(resultListCollectorArray.length).append(", serviceId: ").append(string).append(", lastServiceIdString: ").log();
        }
        NavLocation navLocation = (NavLocation)vector.get(n);
        CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform = new CmdGetLocationDescriptionTransform(this, navLocation);
        cmdGetLocationDescriptionTransform.setBlindArgument("RESOLVE_FAKE_NAV_LOCATION", n);
        cmdGetLocationDescriptionTransform.setBlindArgument("FAKE_LOCATION", vector);
        cmdGetLocationDescriptionTransform.setBlindArgument("RESULT_LIST_COLLECTOR", resultListCollectorArray);
        cmdGetLocationDescriptionTransform.setBlindArgument("CURRENT_INDEX_OF_FIRST_ITEM", n2);
        cmdGetLocationDescriptionTransform.setBlindArgument("CURRENT_TOTAL_ITEMS", n3);
        cmdGetLocationDescriptionTransform.setBlindArgument("SERVICE_ID_STRING", string);
        cmdGetLocationDescriptionTransform.execute();
    }

    public void updateSearchPosition() {
        if (this.vicinityModeActive) {
            this.currentSearchLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDestInputLocation();
            this.trace("OnlinePoiTarget: updateSearchPosition for vicinity mode");
        } else {
            this.currentSearchLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
            this.trace("OnlinePoiTarget: updateSearchPosition for local (ccp) search");
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiSearchLocation(this.currentSearchLocation);
    }

    private void handleSetupSlde(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 2 || n == 4) {
            int n2 = eventGeneric.getInt(1);
            this.vicinityModeActive = n != 2;
            ASLNavigationSldeFactory.getNavigationSldeApi().getSldeSpellerData().setMatchCompletion("");
            switch (n2) {
                case 0: {
                    this.updateSearchPosition();
                    this.setCurrentSearchLocation(this.currentSearchLocation);
                    break;
                }
                case 2: {
                    break;
                }
                case 1: {
                    this.updateSearchPosition();
                    this.setCurrentSearchLocation(this.currentSearchLocation);
                    break;
                }
                case 3: {
                    break;
                }
            }
            ASLNavigationSldeFactory.getNavigationSldeApi().sldeSpellerHandlerInitXt9(this.currentSearchLocation);
            this.printTrace(new StringBuffer().append("Online POI Search set up with configuration=").append(n2).toString());
        }
    }

    private void setCurrentSearchLocation(NavLocation navLocation) {
        if (navLocation != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            FixFormatterFieldData fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            ServiceManager.aslPropertyManager.valueChangedFixFormatterFieldData(-1712320512, fixFormatterFieldData);
            this.printTrace(new StringBuffer().append("setCurrentSearchLocation: ").append(navLocation).toString());
        } else {
            this.printTrace("Current search location is null!");
        }
    }

    void printTrace(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("OnlinePoiTarget: ").append(string).toString()).log();
        }
    }

    private void initializeResultList() {
        this.poiOnlineResultList = ListManager.getGenericASLList(3748);
        this.poiOnlineResultList.enableWindowing(new ASLListItemHardCacheImpl(), this, 10, 0);
        this.dualListHandler = new OnlinePoiTarget$1(this);
        this.poiOnlineResultList.addListViewListener(this.dualListHandler);
    }

    private void requestPersistedOnlineProviderLogo() {
        if (!DATAPOOL.isOnlineProviderLogoAvailable()) {
            IPersistedPoiSetup iPersistedPoiSetup = PersistedPoiSetup.getInstance();
            String string = iPersistedPoiSetup.getOnlineSearchProviderUrl();
            if (string != null) {
                String string2 = iPersistedPoiSetup.getOnlineSearchProviderChecksum();
                this.getProviderLogoOnlinePoiAndUpdateModel(string, string2);
            } else {
                this.printTrace("Not requesting provider logo for online POI, because URL is null");
            }
        }
    }

    private void getProviderLogoOnlinePoiAndUpdateModel(String string, String string2) {
        this.printTrace(new StringBuffer().append("getProviderLogoOnlinePoiAndUpdateModel: Requesting provider logo for online POI url=").append(string).append(" checksum=").append(string2).toString());
        String string3 = ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(4);
        ResourceLocator resourceLocator = this.coreServices.getOnlineImage(0, string3, 0, string, string2, new OnlinePoiTarget$2(this));
        if (resourceLocator != null) {
            this.printTrace(new StringBuffer().append("Updating model provider logo with icon: ").append(resourceLocator.toString()).toString());
        }
        this.model.setProviderLogoOnlinePOI(resourceLocator);
    }

    private void requestPersistedDynamicProviderLogo(int n) {
        boolean bl = DATAPOOL.isDynamicProviderLogoAvailable(n);
        if (!bl && ServiceManager.configManagerDiag.isFeatureFlagSet(186)) {
            IPersistedPoiSetup iPersistedPoiSetup = PersistedPoiSetup.getInstance();
            String string = iPersistedPoiSetup.getOnlineSearchProviderDynamicUrl(n);
            String string2 = iPersistedPoiSetup.getOnlineSearchProviderDynamicChecksum(n);
            if (string != null) {
                this.getProviderLogoIconDynamicPoiAndUpdateModel(n, string, string2);
            } else {
                this.printTrace("Not requesting dynamic provider logo for online POI, because URL ist null");
            }
        }
    }

    private void getProviderLogoIconDynamicPoiAndUpdateModel(int n, String string, String string2) {
        this.printTrace("getProviderLogoIconDynamicPoiAndUpdateModel");
        try {
            ASLNavigationFactory.getNavigationApi().getNavigationOnlinePoiService(new OnlinePoiTarget$3(this, string, string2, n)).dynPoi2Service(n);
        }
        catch (NavigationServiceException navigationServiceException) {
            this.printTrace(new StringBuffer().append("NavigationServiceException caught:").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void caseSpellerInit() {
        if (this.spellerData.getEnteredText() != null && this.spellerData.getEnteredText().length() > 0) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().selectAll(this.spellerData);
            this.spellerData.setCursorPosition(this.spellerData.getEnteredText().length());
            this.updateModelSpellerData();
        }
    }

    private void caseSpellerSetChar(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().addChar(this.spellerData, string);
        this.updateModelSpellerData();
    }

    private void caseSpellerDelChar() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deleteChar(this.spellerData);
        this.updateModelSpellerData();
    }

    private void caseSpellerSetCursorPosition(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deselectAll(this.spellerData);
        this.spellerData.setCursorPosition(n);
        this.updateModelSpellerData();
    }

    private void caseSpellerSave() {
        this.searchString = this.spellerData.getEnteredText().trim();
        this.model.setSearchTerm(this.searchString);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().clear(this.spellerData);
        this.updateModelSpellerData();
    }

    private void caseResultSelectNextDetails(EventGeneric eventGeneric) {
        ++this.selectedIndex;
        this.calculateNavLocationForSelectedPoi();
    }

    private void caseResultSelectPrevDetails(EventGeneric eventGeneric) {
        --this.selectedIndex;
        this.calculateNavLocationForSelectedPoi();
    }

    private void caseStartSearch() {
        this.updateSearchPosition();
        this.onlinePoiSearchResultsForSlde = new Vector();
        this.setSldeSearchResults(this.onlinePoiSearchResultsForSlde, true, this.currentSearchLocation);
        this.referenceLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(NAVIGATION_DP.getPoiSearchLocation());
        if (this.referenceLocation != null) {
            DATAPOOL.setSearchType(0);
            this.resetSearchResults();
            this.printTrace(new StringBuffer().append("caseSearchStart() location: ").append(this.referenceLocation.getLocation().toString()).toString());
            this.printTrace(new StringBuffer().append("caseSearchStart() search term: ").append(this.searchString).toString());
            this.dualListHandler.setMapFlagType(1);
            int n = this.referenceLocation.getLongitude();
            int n2 = this.referenceLocation.getLatitude();
            this.dsiPoiOnlineSearch.poiStartSelection(this.searchString, n, n2, 500, 10);
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("PoiOnlineSearch.caseStartSearch: No location is set from the regular POI context.");
        }
    }

    private void caseStartSearchDynamic(EventGeneric eventGeneric) {
        this.onlinePoiSearchResultsForSlde = new Vector();
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        this.caseStartSearchDynamic(n, n2);
    }

    void caseStartSearchDynamic(int n, int n2) {
        this.lastDsiDynPoiCategory = DynamicPoiCategoryHandler.modelToDsiCategory(n);
        this.requestPersistedDynamicProviderLogo(this.lastDsiDynPoiCategory);
        int n3 = this.modelToDsiSortBy(n2);
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        if (posPosition != null) {
            this.referenceLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition);
            DATAPOOL.setSearchType(1);
            this.resetSearchResults();
            this.dualListHandler.setMapFlagType(0);
            this.dsiPoiOnlineSearch.dynamicPoiStartSelection(this.lastDsiDynPoiCategory, n3, posPosition.getLongitude(), posPosition.getLatitude(), 500, 10);
            PoiDatapool.getInstance().setCurrentUseCase(20);
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("PoiOnlineSearch.caseStartSearchDynamic: CCP location is not available.");
        }
    }

    private void caseStartVoiceSearch() {
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        DynamicPoiCategoryHandler.hideOnlineSearchButton();
        if (posPosition != null) {
            this.referenceLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition);
            DATAPOOL.setSearchType(2);
            this.resetSearchResults();
            this.dualListHandler.setMapFlagType(1);
            this.dsiPoiOnlineSearch.poiVoiceSearchActive();
            this.dsiPoiOnlineSearch.poiStartVoiceSelection(posPosition.getLongitude(), posPosition.getLatitude(), 500, 0, true, 10);
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("PoiOnlineSearch.caseStartVoiceSearch: CCP location is not available.");
        }
    }

    private int modelToDsiSortBy(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public void dsiPoiOnlineSearchPoiResult(int n, int n2, int n3) {
        this.printTrace(new StringBuffer().append("poiResult() with returnCode: ").append(n3).toString());
        this.searchCanceled = false;
        switch (n3) {
            case 10: {
                this.searchState = 0;
                if (n2 != 1) break;
                this.dsiPoiOnlineSearch.poiRawVoiceDataAvailable("/tmp/speech-online.pcm", 2);
                break;
            }
            case 11: {
                this.searchState = 3;
                break;
            }
            case 12: {
                if (this.isTraceEnabled()) {
                    this.trace("dsiPoiOnlineSearchPoiResult - Search canceled successfully");
                }
                this.model.setNextPageAvailable(false);
                this.searchState = 3;
                this.searchCanceled = true;
                break;
            }
            case 44: 
            case 57: 
            case 58: 
            case 59: 
            case 62: {
                this.model.setNextPageAvailable(false);
                this.searchState = 2;
                this.setSldeSearchResults(new Vector(), false, this.currentSearchLocation);
                break;
            }
            default: {
                this.model.setNextPageAvailable(false);
                this.setSldeSearchResults(new Vector(), false, this.currentSearchLocation);
                this.searchState = 4;
            }
        }
        if (this.searchState == 0) {
            this.model.updateSearchStatus(true);
        } else {
            this.model.updateSearchStatus(false);
        }
        if (this.searchState == 3) {
            this.searchState = 0;
        }
        this.model.setSearchState(this.searchState);
        this.model.leaveWaitState();
    }

    @Override
    public void dsiPoiOnlineSearchPoiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        if (this.searchCanceled) {
            this.warn("OnlinePoiTarget: Ignore poiValueList() after cancel search.");
            this.searchCanceled = false;
            return;
        }
        this.updateProviderInfo(poiOnlineSearchValuelist, n);
        if (poiOnlineSearchValuelist != null && poiOnlineSearchValuelist.getList() != null) {
            this.printTrace(new StringBuffer().append("poiValueList() with ").append(poiOnlineSearchValuelist.getList().length).append(" elements. Start index: ").append(n3).append(", total results: ").append(n4).toString());
            PoiOnlineSearchValuelist poiOnlineSearchValuelist2 = poiOnlineSearchValuelist;
            int n5 = n3;
            int n6 = n4;
            switch (n) {
                case 2: {
                    if (poiOnlineSearchValuelist.list.length > 0) {
                        try {
                            ASLNavigationFactory.getNavigationApi().getNavigationOnlinePoiService(new OnlinePoiTarget$4(this, poiOnlineSearchValuelist2, n5, n6)).dynPoi2Service(poiOnlineSearchValuelist.list[0].category);
                        }
                        catch (NavigationServiceException navigationServiceException) {}
                        break;
                    }
                    if (this.isTraceEnabled()) {
                        this.trace("dsiPoiOnlineSearchPoiValueList - list is empty, no serviceId needed for the images");
                    }
                    this.notifyModelAndSlde(poiOnlineSearchValuelist2, n5, n6, null);
                    break;
                }
                default: {
                    if (this.isTraceEnabled()) {
                        this.trace("dsiPoiOnlineSearchPoiValueList - searching for online poi");
                    }
                    this.notifyModelAndSlde(poiOnlineSearchValuelist2, n5, n6, this.coreServices.getServiceIDWithNumericServiceID(4));
                    break;
                }
            }
        } else {
            if (this.isTraceEnabled()) {
                this.trace("OnlinePoiTarget: Found no search results, probably connection error.");
            }
            this.model.setNextPageAvailable(false);
            if (this.searchState == 3) {
                this.searchState = 2;
            }
        }
        this.model.setSearchState(this.searchState);
    }

    public void dsiPoiOnlineSearchPrecheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
        this.notifyNavigationOnlinePoiListener(n, oSRServiceState);
    }

    private void notifyNavigationOnlinePoiListener(int n, OSRServiceState oSRServiceState) {
        ArrayList arrayList = (ArrayList)this.precheckMap.remove(n);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                NavigationOnlinePoiListener navigationOnlinePoiListener = (NavigationOnlinePoiListener)arrayList.get(i2);
                try {
                    if (oSRServiceState == null) continue;
                    navigationOnlinePoiListener.updateDynPoi2ServiceID(n, oSRServiceState.serviceID);
                    continue;
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
            }
        }
    }

    void appendResultsToSldeResultList(PoiOnlineSearchValuelist poiOnlineSearchValuelist) {
        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = poiOnlineSearchValuelist.getList();
        for (int i2 = 0; i2 < poiOnlineSearchValuelistElementArray.length; ++i2) {
            this.onlinePoiSearchResultsForSlde.add(this.createFakeNavLocation(poiOnlineSearchValuelistElementArray, i2));
        }
    }

    private NavLocation createFakeNavLocation(PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray, int n) {
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = poiOnlineSearchValuelistElementArray[n];
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(poiOnlineSearchValuelistElement.getLatitude(), poiOnlineSearchValuelistElement.getLongitude()).getLocation();
        navLocation.positionValid = true;
        navLocation.proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor(), new NavLocationDescriptor()};
        navLocation.proprietaryData[0].selectionCriterion = 16641;
        navLocation.proprietaryData[0].data = poiOnlineSearchValuelistElement.getName();
        navLocation.proprietaryData[1].selectionCriterion = 520;
        navLocation.proprietaryData[1].data = new Integer(0).toString();
        navLocation.proprietaryData[2].selectionCriterion = 282;
        navLocation.proprietaryData[2].data = new Integer(0).toString();
        int n2 = this.calculateDirectionArrowToLocation(poiOnlineSearchValuelistElement);
        navLocation.proprietaryData[3].selectionCriterion = 124;
        navLocation.proprietaryData[3].data = new Integer(n2).toString();
        int n3 = this.calculateDistanceToLocation(poiOnlineSearchValuelistElement);
        navLocation.proprietaryData[4].selectionCriterion = 123;
        navLocation.proprietaryData[4].data = new Integer(n3).toString();
        navLocation.proprietaryData[5].selectionCriterion = 4097;
        navLocation.proprietaryData[5].data = new Integer(this.onlinePoiSearchResultsForSlde.size()).toString();
        navLocation.proprietaryData[6].selectionCriterion = 128;
        navLocation.proprietaryData[6].data = poiOnlineSearchValuelistElement.getUrl();
        navLocation.proprietaryData[7].selectionCriterion = 8;
        navLocation.proprietaryData[7].data = poiOnlineSearchValuelistElement.getPhone();
        navLocation.proprietaryData[8].selectionCriterion = 0;
        navLocation.proprietaryData[8].data = new Integer(this.getTargetId()).toString();
        navLocation.proprietaryData[9].selectionCriterion = 310378496;
        navLocation.proprietaryData[9].data = poiOnlineSearchValuelistElement.getImageUrl();
        return navLocation;
    }

    @Override
    public void dsiPoiOnlineSearchAsyncException(int n, String string, int n2) {
        if (n2 == 1015) {
            this.notifyNavigationOnlinePoiListener(this.lastDsiDynPoiCategory, new OSRServiceState("", "", n, 0, null, null));
        }
        if (n == 8304 && (n2 == 1002 || n2 == 1000 || n2 == 1013 || n2 == 1008)) {
            this.searchState = 4;
            this.model.setSearchState(this.searchState);
        }
    }

    public void dsiNavigationLiTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        if (tryMatchLocationResultDataArray != null && tryMatchLocationResultDataArray.length > 0) {
            TryMatchLocationResultData tryMatchLocationResultData = this.findBestTryMatchLocationResult(tryMatchLocationResultDataArray);
            if (tryMatchLocationResultData != null && tryMatchLocationResultData.getLocation() != null) {
                this.updateModelDetailsScreen(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(tryMatchLocationResultData.getLocation()));
                this.model.leaveWaitState();
            }
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("PoiOnlineSearch.liTryMatchLocationResult: No location resolved for the selected POI");
        }
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        Object object = cmdGetLocationDescriptionTransform.getBlindArgument("RESOLVE_FAKE_NAV_LOCATION");
        if (object != null) {
            NavLocation navLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            Integer n = (Integer)object;
            ResultListCollector[] resultListCollectorArray = (ResultListCollector[])cmdGetLocationDescriptionTransform.getBlindArgument("RESULT_LIST_COLLECTOR");
            Vector vector = (Vector)cmdGetLocationDescriptionTransform.getBlindArgument("FAKE_LOCATION");
            NavLocation navLocation2 = (NavLocation)vector.get(n);
            iLocationWrapper.setMmiInternalDataValue(3, navLocation2.proprietaryData[0].data);
            iLocationWrapper.setMmiInternalDataValue(4, navLocation2.proprietaryData[7].data);
            Integer n2 = (Integer)cmdGetLocationDescriptionTransform.getBlindArgument("CURRENT_INDEX_OF_FIRST_ITEM");
            ResultListCollector resultListCollector = resultListCollectorArray[n - n2];
            resultListCollector.setAddressType(4);
            FixFormatterFieldDataImpl fixFormatterFieldDataImpl = (FixFormatterFieldDataImpl)ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(iLocationWrapper);
            resultListCollector.setFixFormatterFieldData(fixFormatterFieldDataImpl);
            OnlinePoiTarget.put(fixFormatterFieldDataImpl, "Phonenumber", navLocation2.proprietaryData[7].data);
            OnlinePoiTarget.put(fixFormatterFieldDataImpl, "PoiName", navLocation2.proprietaryData[0].data);
            String string = (String)cmdGetLocationDescriptionTransform.getBlindArgument("SERVICE_ID_STRING");
            String string2 = ASLNavigationPoiFactory.getNavigationPoiApi().getLastServiceIdString();
            boolean bl = this.lastServiceIdMatches(string);
            if (this.isTraceEnabled()) {
                this.trace().append("handleCommandCmdGetLocationDescriptionTransform with lastServiceIdString: ").append(string2).append(" serviceIdString: ").append(string).append(" lastServiceIdMatches: ").append(bl);
            }
            if (!bl) {
                if (this.isTraceEnabled()) {
                    this.trace().append("resolveFakeNavLocation recursion finished. lastServiceIdMatches: ").append(bl);
                }
                return;
            }
            resultListCollector.setToUpdateList();
            this.poiOnlineResultList.updateListItems(n, new ResultListCollector[]{resultListCollector});
            if (DATAPOOL.getSearchType() == 0) {
                ASLNavigationTruffelFactory.getNavigationTruffelApi().setSearchResult(navLocation2, n, iLocationWrapper.getLocation(), false, this.currentSearchLocation, true);
            }
            this.resolveFakeNavLocation(new Integer(n + 1), vector, resultListCollectorArray, n2, (Integer)cmdGetLocationDescriptionTransform.getBlindArgument("CURRENT_TOTAL_ITEMS"), string);
        } else if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation != null) {
            this.updateModelDetailsScreen(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation));
            this.model.leaveWaitState();
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("PoiOnlineSearch.liGetLocationDescriptionTransformResult: No location resolved for the selected POI");
        }
    }

    private boolean lastServiceIdMatches(String string) {
        boolean bl = true;
        String string2 = ASLNavigationPoiFactory.getNavigationPoiApi().getLastServiceIdString();
        if (string2 != null && string != null && !string2.equals(string)) {
            bl = false;
        }
        return bl;
    }

    private static void put(FixFormatterFieldDataImpl fixFormatterFieldDataImpl, String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            fixFormatterFieldDataImpl.put(string, string2);
        }
    }

    protected void setPoiLocationToCurrentSearchLocation(NavLocation navLocation) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("OnliPoiTarget: handleCommandCmdGetLocationDescriptionTransform() - setPoiSearchLocation to : ").append(navLocation).toString());
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation(navLocation);
    }

    private void resetSearchResults() {
        if (this.searchState == 0) {
            this.dsiPoiOnlineSearch.poiStopSelection();
        }
        this.model.setTotalResultCount(0);
        this.model.setNextPageAvailable(false);
        this.model.setPreviousPageAvailable(false);
        this.poiOnlineResultList.updateList(new Object[0]);
    }

    ResultListCollector[] createResultList(PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n, String string) {
        this.printTrace(new StringBuffer().append("createResultList(serviceIdString = ").append(string).append(")").toString());
        ResultListCollector[] resultListCollectorArray = new ResultListCollector[poiOnlineSearchValuelist.getList().length];
        for (int i2 = 0; i2 < resultListCollectorArray.length; ++i2) {
            ResultListCollector resultListCollector;
            resultListCollectorArray[i2] = resultListCollector = this.createResultListCollector(poiOnlineSearchValuelist, n, string, i2);
        }
        return resultListCollectorArray;
    }

    private ResultListCollector createResultListCollector(PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n, String string, int n2) {
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = poiOnlineSearchValuelist.getList()[n2];
        int n3 = this.calculateDistanceToLocation(poiOnlineSearchValuelistElement);
        int n4 = this.calculateDirectionArrowToLocation(poiOnlineSearchValuelistElement);
        if (!StringUtil.isEmpty(poiOnlineSearchValuelistElement.getImageUrl())) {
            this.printTrace(new StringBuffer().append("Requesting brand icon url: ").append(poiOnlineSearchValuelistElement.getImageUrl()).toString());
        }
        ResultListCollector resultListCollector = new ResultListCollector(poiOnlineSearchValuelistElement, n2 + n, n4, n3, true, string, false);
        return resultListCollector;
    }

    private void updateProviderInfo(PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n) {
        IPersistedPoiSetup iPersistedPoiSetup = PersistedPoiSetup.getInstance();
        this.printTrace(new StringBuffer().append("updateProviderInfo(): requesting logo from core services with url: ").append(poiOnlineSearchValuelist.imageUrl).toString());
        if (this.coreServices != null) {
            switch (n) {
                case 2: {
                    iPersistedPoiSetup.setOnlineSearchProviderDynamicUrl(poiOnlineSearchValuelist.getImageUrl(), this.lastDsiDynPoiCategory);
                    iPersistedPoiSetup.setOnlineSearchProviderDynamicChecksum(poiOnlineSearchValuelist.getImageCheckSum(), this.lastDsiDynPoiCategory);
                    this.getProviderLogoIconDynamicPoiAndUpdateModel(this.lastDsiDynPoiCategory, poiOnlineSearchValuelist.imageUrl, poiOnlineSearchValuelist.imageCheckSum);
                    break;
                }
                default: {
                    iPersistedPoiSetup.setOnlineSearchProviderChecksum(poiOnlineSearchValuelist.getImageCheckSum());
                    iPersistedPoiSetup.setOnlineSearchProviderUrl(poiOnlineSearchValuelist.getImageUrl());
                    this.getProviderLogoOnlinePoiAndUpdateModel(poiOnlineSearchValuelist.imageUrl, poiOnlineSearchValuelist.imageCheckSum);
                }
            }
        }
    }

    private void updateModelDetailsScreen(ILocationWrapper iLocationWrapper) {
        FixFormatterFieldData fixFormatterFieldData;
        int n;
        ResultListCollector resultListCollector = this.getSelectedOnlinePoi();
        iLocationWrapper.setMmiInternalDataValue(3, resultListCollector.getName());
        iLocationWrapper.setMmiInternalDataValue(4, resultListCollector.getPhone());
        NAVIGATION_DP.setPOILocation(iLocationWrapper.getLocation());
        switch (DATAPOOL.getSearchType()) {
            case 0: 
            case 2: {
                n = 2;
                break;
            }
            default: {
                n = 90;
            }
        }
        MapConfiguration mapConfiguration = new MapConfiguration(iLocationWrapper.getLocation(), n, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(13, mapConfiguration);
        NavigationPOIOnlineServicesGoogleLocationCollector navigationPOIOnlineServicesGoogleLocationCollector = (NavigationPOIOnlineServicesGoogleLocationCollector)ListManager.getGenericASLList(3760).getRowItemCacheOnly(0);
        this.model.setPoiURL(resultListCollector.getUrl());
        if (iLocationWrapper.isPoiNameAvailable()) {
            fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_name = iLocationWrapper.getPoiName();
        } else {
            fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper, resultListCollector.getName(), resultListCollector.getPhone());
            navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_name = resultListCollector.getName();
        }
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_address_details_for_fix_formatter = fixFormatterFieldData;
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_direction = resultListCollector.getDirectionArrow();
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_distance = resultListCollector.getDistance();
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_city = iLocationWrapper.getCity();
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_phonenumber = iLocationWrapper.getPhonenumber();
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_is_navigateable = iLocationWrapper.isNavigable();
        navigationPOIOnlineServicesGoogleLocationCollector.navigation_poi_onlineservices_google_location_icon = resultListCollector.getIcon();
        ListManager.getGenericASLList(3760).updateList(new Object[]{navigationPOIOnlineServicesGoogleLocationCollector});
    }

    private TryMatchLocationResultData findBestTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        TryMatchLocationResultData tryMatchLocationResultData = null;
        if (tryMatchLocationResultDataArray != null && tryMatchLocationResultDataArray.length > 0) {
            int n = -1;
            int n2 = -1;
            int n3 = -1;
            block6: for (int i2 = 0; i2 < tryMatchLocationResultDataArray.length; ++i2) {
                switch (tryMatchLocationResultDataArray[i2].getMatchLevel()) {
                    case 1: {
                        return tryMatchLocationResultDataArray[i2];
                    }
                    case 3: {
                        if (n != -1) continue block6;
                        n = i2;
                        continue block6;
                    }
                    case 4: {
                        if (n2 != -1) continue block6;
                        n2 = i2;
                        continue block6;
                    }
                    case 2: {
                        if (n3 != -1) continue block6;
                        n3 = i2;
                        continue block6;
                    }
                }
            }
            if (n != -1) {
                tryMatchLocationResultData = tryMatchLocationResultDataArray[n];
            } else if (n2 != -1) {
                tryMatchLocationResultData = tryMatchLocationResultDataArray[n2];
            } else if (n3 != -1) {
                tryMatchLocationResultData = tryMatchLocationResultDataArray[n3];
            }
        }
        return tryMatchLocationResultData;
    }

    private void updateModelSpellerData() {
        this.model.setSearchTerm(this.spellerData.getEnteredText());
        this.model.setSearchSpellerData(this.spellerData);
    }

    private void caseRequestNextPage() {
        if (this.referenceLocation != null) {
            int n = this.poiOnlineResultList.getSize();
            this.model.setNextPageAvailable(false);
            this.model.setSearchState(0);
            this.dsiPoiOnlineSearch.poiRequestValueList(n, 10);
        }
    }

    private ResultListCollector getSelectedOnlinePoi() {
        return (ResultListCollector)this.poiOnlineResultList.getRowItemCacheOnly(this.selectedIndex);
    }

    private void calculateNavLocationForSelectedPoi() {
        ResultListCollector resultListCollector = this.getSelectedOnlinePoi();
        if (resultListCollector != null) {
            TryMatchLocationData tryMatchLocationData = new TryMatchLocationData();
            tryMatchLocationData.country = resultListCollector.getCountry();
            tryMatchLocationData.houseNumber = "";
            tryMatchLocationData.junction = "";
            tryMatchLocationData.latitude = resultListCollector.getLatitude();
            tryMatchLocationData.longitude = resultListCollector.getLongitude();
            tryMatchLocationData.poiCategory = 0;
            tryMatchLocationData.poiName = resultListCollector.getName();
            tryMatchLocationData.postalCode = resultListCollector.getPostal();
            tryMatchLocationData.state = resultListCollector.getRegion();
            tryMatchLocationData.street = resultListCollector.getStreet();
            tryMatchLocationData.town = resultListCollector.getCity();
            tryMatchLocationData.unstructured = "";
            new CmdGetLocationDescriptionTransform(this, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(resultListCollector.getLatitude(), resultListCollector.getLongitude()).getLocation()).execute();
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("OnlinePoiTarget.calculateNavLocationForSelectedPoi: No list item available for the selected index!");
        }
    }

    private void caseResultSelectDetails(EventGeneric eventGeneric) {
        this.selectedIndex = eventGeneric.getInt(0);
        this.calculateNavLocationForSelectedPoi();
    }

    private void caseNotifyGoogle(EventGeneric eventGeneric) {
        int n;
        switch (eventGeneric.getInt(0)) {
            case 0: {
                n = 10;
                break;
            }
            case 1: {
                n = 11;
                break;
            }
            case 2: {
                n = 12;
                break;
            }
            default: {
                n = 0;
            }
        }
        this.dsiPoiOnlineSearch.usedPoi(this.getSelectedOnlinePoi(), n);
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()) && this.dsiNavigation == null) {
            this.registerDSINavigation();
        } else if (string.equals((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName()) && this.dsiPoiOnlineSearch == null) {
            this.registerDSIPoiOnlineSearch();
        }
        if (this.dsiNavigation != null && this.dsiPoiOnlineSearch != null && !registered) {
            this.printTrace("Registering observers for ASL/Model events");
            OnlinePoiEvents.addObservers(this);
            registered = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
                this.unregisterDSINavigation();
            } else if (string.equals((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName())) {
                this.unregisterDSIPoiOnlineSearch();
            }
            if ((this.dsiNavigation == null || this.dsiPoiOnlineSearch == null) && registered) {
                this.printTrace("Unregistering observers for ASL/Model events");
                OnlinePoiEvents.removeObservers(this);
                registered = false;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.referenceLocation != null) {
            this.dsiPoiOnlineSearch.poiRequestValueList(n, n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    private void changeLanguage() {
        String string;
        if (this.dsiPoiOnlineSearch != null && (string = ServiceManager.configManagerDiag.getCurrentGuiLanguage()) != null && string.length() > 0) {
            String string2 = ServiceManager.configManagerDiag.getFallbackLanguage(string);
            this.printTrace(new StringBuffer().append("Set fallback language to ").append(string2).toString());
            if (string2 != null && string2.length() > 0) {
                this.dsiPoiOnlineSearch.setFallbackLanguage(string2);
            }
            this.printTrace(new StringBuffer().append("Set language to ").append(string).toString());
            this.dsiPoiOnlineSearch.setLanguage(string);
        }
    }

    private void registerDSIPoiOnlineSearch() {
        this.dsiPoiOnlineSearch = (DSIPoiOnlineSearch)this.proxy.getService(this, class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch);
        this.dsiPoiOnlineSearchListener = this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = OnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener);
        this.proxy.addResponseListener(this, class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = OnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener, this.dsiPoiOnlineSearchListener);
        this.changeLanguage();
    }

    protected int calculateDirectionArrowToLocation(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        if (poiOnlineSearchValuelistElement == null) {
            this.error("calculateDirectionArrowToLocation(): element was null");
            return 0;
        }
        if (this.referenceLocation == null) {
            this.error("calculateDirectionArrowToLocation(): referenceLocation was null");
            return 0;
        }
        int n = 0;
        if (NAVIGATION_DP.getPoiSearchArea() == 1) {
            n = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getDirectionAngle();
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(this.referenceLocation.getLongitude(), this.referenceLocation.getLatitude(), poiOnlineSearchValuelistElement.getLongitude(), poiOnlineSearchValuelistElement.getLatitude(), n);
    }

    void notifyModelAndSlde(PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n, int n2, String string) {
        ASLNavigationPoiFactory.getNavigationPoiApi().setLastServiceIdString(string);
        this.model.setNextPageAvailable(false);
        this.model.setTotalResultCount(n2);
        ResultListCollector[] resultListCollectorArray = this.createResultList(poiOnlineSearchValuelist, n, string);
        if (this.searchState == 0 && poiOnlineSearchValuelist.getList().length + n == 0) {
            this.searchState = 2;
        }
        this.appendResultsToSldeResultList(poiOnlineSearchValuelist);
        if (this.searchState == 0) {
            this.resolveFakeNavLocation(new Integer(0 + n), this.onlinePoiSearchResultsForSlde, resultListCollectorArray, new Integer(n), new Integer(n2), string);
        }
    }

    public void initXt9Finished() {
        this.printTrace("initXt9Finished");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1693454336, true);
    }

    void setSldeSearchResults(Vector vector, boolean bl, NavLocation navLocation) {
        if (DATAPOOL.getSearchType() == 0) {
            ASLNavigationTruffelFactory.getNavigationTruffelApi().setSearchResults(vector, bl, navLocation, true);
        }
    }

    public String getSelectedOnlinePoiUrl() {
        if (this.getSelectedOnlinePoi() != null) {
            return this.getSelectedOnlinePoi().getUrl();
        }
        return "";
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        switch (n) {
            case 0: 
            case 7: {
                if (this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = true;
                this.requestPersistedOnlineProviderLogo();
                break;
            }
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

    static {
        NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
        DATAPOOL = OnlinePoiDataPool.getInstance();
    }
}


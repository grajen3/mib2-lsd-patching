/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.IEConnector;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryMatchLocation;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldDsiHandler;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldDualListViewHandler;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldEvents;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldModelNotifier;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldResultListHandler;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield$1;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield$2;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldResultConnectorDetailsCollector;
import de.vw.mib.asl.internal.navigation.slde.SldeEventHelper;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldLocationCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchResult;

public class TargetShield
extends AbstractResettableNavGatewayTarget
implements CacheClient,
TargetForResetNavigation,
TargetForFullFactoryReset {
    private boolean allowReceivingEvents = false;
    ShieldDsiHandler dsiHandler;
    ShieldModelNotifier modelNotifier = new ShieldModelNotifier();
    private ShieldResultListHandler resultListHandler = new ShieldResultListHandler(this);
    ShieldDualListViewHandler dualListViewHandler = new ShieldDualListViewHandler(this, this.modelNotifier);
    SldeSpellerHandler spellerHandler = SldeSpellerHandler.getInstance();
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SHIELD");
    public static String housenumber = "";
    int destinationDistance = 0;
    int destinationDirection = 0;
    public static NavLocation location;
    public static boolean addLocationToHistory;
    public static SearchResult selectedSearchResult;
    public boolean waitingForSearchResultsToBeResolved = false;
    private boolean vicinityModeActive = false;
    NavLocation currentSearchPosition;
    private boolean sldeViewActive = false;
    Vector pendingResolveSearchResultRequests = new Vector();
    boolean discardTryMatchLocations = false;
    private boolean isChnEnabled = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;
    private boolean acceptIncomingSearchResults;
    private boolean searchIsPending = false;
    private boolean searchIsActive = false;
    private String queuedNeedle = "";
    private boolean queuedResumeQuery;
    private Command queuedCmd;
    private Object[] queuedItemsToResolve;
    private boolean queuedCancel = false;
    private int queuedSetupSldeType = -1;
    private int queuedSetupSldeConfiguration = -1;
    private boolean lastSearchCompleted = true;
    private boolean searchWasCanceled = false;
    private boolean initializationInProgress = false;
    private boolean showLastDests = false;
    private boolean quitModelWaitstate;
    private boolean resolveResults;
    private Collection lastFlags = new ArrayList();
    private boolean initializationDoneAtLeasOnce;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;

    public TargetShield(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.dsiHandler = new ShieldDsiHandler(genericEvents, -817163264, string, this);
    }

    void doSearchQuery(String string, boolean bl) {
        TargetShield.printTrace(new StringBuffer().append("doSearchQuery for ").append(string).append(" resumeSearch=").append(bl).toString());
        if (this.searchIsActive || this.searchIsPending || this.initializationInProgress) {
            TargetShield.printTrace("doSearchQuery: queueing search because there is an active/pending search or dsi init not yet complete.");
            this.queuedNeedle = string;
            this.queuedResumeQuery = bl;
            if (!this.initializationInProgress) {
                this.cancelQuery();
            } else {
                this.modelNotifier.updateSearchStatus(true);
            }
        } else if (string.length() > 0) {
            this.modelNotifier.updateSearchStatus(true);
            if (!bl) {
                this.clearResultList();
            }
            this.acceptIncomingSearchResults = true;
            this.dsiHandler.startQuery(string);
            this.searchWasCanceled = false;
            this.searchIsPending = true;
        } else {
            TargetShield.printTrace("doSearchQuery: Needle empty. Last query canceled. But not starting new query.");
        }
    }

    public void updateSearchPosition() {
        if (this.vicinityModeActive) {
            this.currentSearchPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDestInputLocation();
            TargetShield.printTrace("Get searchposition for vicinity mode from DP");
        } else {
            this.currentSearchPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
            TargetShield.printTrace("Get searchposition from CCP");
        }
        if (this.currentSearchPosition != null) {
            float f2 = (float)((double)this.currentSearchPosition.latitude / 1.1930464E7);
            float f3 = (float)((double)this.currentSearchPosition.longitude / 1.1930464E7);
            this.initializationInProgress = true;
            this.dsiHandler.setCurrentPosition(new NavPosition(f2, f3));
            this.modelNotifier.setCurrentSearchLocation(this.currentSearchPosition);
        } else {
            TargetShield.printTrace("updateSearchPosition got null from ccp or NavDP getDestInputLocation");
        }
        this.spellerHandler.initXt9(this.currentSearchPosition);
        this.modelNotifier.setCurrentSearchLocation(this.currentSearchPosition);
    }

    private void fillLastDests() {
        TargetShield.printTrace(new StringBuffer().append("fillLastDests with ").append(this.resultListHandler.getLastDests().size()).append(" results").toString());
        this.showLastDests = true;
        this.modelNotifier.updateSearchResultList(this.resultListHandler.getLastDests());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                ShieldEvents.addObservers(this);
                this.registerLscTarget();
                break;
            }
            case 106: {
                TargetShield.printTrace("TARGETSHIELD: POWER_ON");
                if (this.navigationResetParticipant == null) {
                    this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                }
                if (this.fullFactoryResetParticipant != null) break;
                this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                break;
            }
            case 107: {
                TargetShield.printTrace("TARGETSHIELD: POWER_OFF");
                if (this.navigationResetParticipant != null) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                    this.navigationResetParticipant = null;
                }
                if (this.fullFactoryResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                this.fullFactoryResetParticipant = null;
                break;
            }
            case 1074841946: {
                if (!this.allowReceivingEvents) break;
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                if (this.searchIsActive || this.searchIsPending || this.initializationInProgress) {
                    TargetShield.printTrace("Queueing setup handling because there is an active or pending search.");
                    this.queuedSetupSldeType = n;
                    this.queuedSetupSldeConfiguration = n2;
                    this.cancelQuery();
                    break;
                }
                this.handleSetupSlde(n, n2);
                break;
            }
            case 1074841926: {
                if (!this.allowReceivingEvents) break;
                this.handleCancelSearch();
                break;
            }
            case 1074841892: {
                if (!this.allowReceivingEvents) break;
                this.handleSelectResultById(eventGeneric);
                break;
            }
            case 3488006: {
                this.handleResolveResult(eventGeneric);
                break;
            }
            case 3488008: {
                this.handleResultResolved(eventGeneric);
                break;
            }
            case 40003: {
                TargetShield.printTrace("Target Handle-LSC entered LSCTNG_CHANGE_LANGUAGE.");
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                this.sldeViewActive = false;
                this.handleLscRequest(n, string);
                break;
            }
            default: {
                TargetShield.printTrace(new StringBuffer().append("TargetShield has not implemented handling of event: ").append(eventGeneric.getReceiverEventId()).toString());
            }
        }
    }

    private void registerLscTarget() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1083965440);
        eventGeneric.setInt(0, this.getTargetId());
        eventGeneric.setInt(1, 6);
        eventGeneric.setString(2, ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getLanguage());
        this.send(eventGeneric);
    }

    private void handleLscRequest(int n, String string) {
        try {
            this.cancelQuery();
            this.finishManualLanguageChange(true, n, string);
        }
        catch (GenericEventException genericEventException) {
            TargetShield.printTrace("Error handling finishManualLanguageChange");
        }
    }

    private void finishManualLanguageChange(boolean bl, int n, String string) {
        if (this.isTraceEnabled()) {
            this.trace("Language Changed: Finishing manual language change. Success: ", new Boolean(bl).toString());
        }
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1151074304);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setString(2, string);
        this.send(eventGeneric);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleResultResolved(EventGeneric eventGeneric) {
        try {
            NavLocation navLocation = (NavLocation)eventGeneric.getObject(154744064);
            ShieldCollector shieldCollector = (ShieldCollector)eventGeneric.getObject(171521280);
            if (navLocation != null && navLocation.isPositionValid() && navLocation.latitude != 0 && navLocation.longitude != 0) {
                shieldCollector.lat = (float)ASLNavigationUtilFactory.getNavigationUtilApi().dsiToDecimal(navLocation.getLatitude());
                shieldCollector.lon = (float)ASLNavigationUtilFactory.getNavigationUtilApi().dsiToDecimal(navLocation.getLongitude());
                shieldCollector.navLocation = navLocation;
                shieldCollector.recalculatedDirection();
            }
            Vector vector = this.pendingResolveSearchResultRequests;
            synchronized (vector) {
                this.pendingResolveSearchResultRequests.remove(shieldCollector);
                TargetShield.printTrace(new StringBuffer().append("handleResultResolved, removed searchresult to be resolved. Count=").append(this.pendingResolveSearchResultRequests.size()).toString());
            }
            if (this.pendingResolveSearchResultRequests.size() == 0) {
                this.waitingForSearchResultsToBeResolved = false;
                this.resolveResults = false;
                if (!this.discardTryMatchLocations) {
                    this.handleAllSearchResultsResolved();
                } else {
                    this.discardTryMatchLocations = false;
                    this.modelNotifier.quitModelWaitstate("handleResultResolved all results resolved and discard trymatchlocations");
                }
            }
        }
        catch (GenericEventException genericEventException) {
            this.error("Object cannot be extracted from event");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleResolveResult(EventGeneric eventGeneric) {
        try {
            ShieldCollector shieldCollector = (ShieldCollector)eventGeneric.getObject(121189632);
            TryMatchLocationData tryMatchLocationData = this.createTryMatchLocationData(shieldCollector);
            CmdTryMatchLocation cmdTryMatchLocation = new CmdTryMatchLocation(this, tryMatchLocationData);
            Vector vector = this.pendingResolveSearchResultRequests;
            synchronized (vector) {
                this.pendingResolveSearchResultRequests.add(shieldCollector);
                TargetShield.printTrace(new StringBuffer().append("handleResolveResult, added searchresult to be resolved. Count=").append(this.pendingResolveSearchResultRequests.size()).toString());
            }
            cmdTryMatchLocation.setBlindArgument("Command", new TargetShield$1(this, cmdTryMatchLocation, shieldCollector));
            cmdTryMatchLocation.execute();
        }
        catch (Exception exception) {
            TargetShield.printTrace("handleResolveResult: Failed to cast event parameter to shieldcollector");
        }
    }

    public void handleCancelSearch() {
        this.sldeViewActive = false;
        if (this.initializationInProgress) {
            TargetShield.printTrace("handleCancelSearch: Leaving speller while init still running. Deleting queued searchsstring.");
            this.queuedNeedle = "";
        }
        this.cancelQuery();
        if (this.waitingForSearchResultsToBeResolved) {
            this.discardTryMatchLocations = true;
        }
    }

    public void spellerTextChanged() {
        TargetShield.printTrace("spellerDataChanged");
        this.acceptIncomingSearchResults = false;
        this.clearResultList();
        this.modelNotifier.resetSearchResultListCount();
        if (this.spellerHandler.isSpellerTextEmpty()) {
            TargetShield.printTrace("Text empty, stop accepting incoming results.");
            this.modelNotifier.updateSearchStatus(false);
            this.fillLastDests();
            this.queuedNeedle = "";
            if (!this.initializationInProgress && !this.vicinityModeActive && this.sldeViewActive) {
                this.updateSearchPosition();
            }
            this.cancelQuery();
        } else {
            TargetShield.printTrace(new StringBuffer().append("Searching for: ").append(this.spellerHandler.getSpellerData().getEnteredText()).toString());
            this.doSearchQuery(this.spellerHandler.getSpellerData().getEnteredText(), false);
        }
    }

    private void handleSelectResultById(EventGeneric eventGeneric) {
        ShieldCollector shieldCollector;
        int n = eventGeneric.getInt(0);
        TargetShield.printTrace(new StringBuffer().append("Got event: LIST_SELECT_BY_ID. Selected element: ").append(n).toString());
        if (this.spellerHandler.isSpellerTextEmpty()) {
            this.modelNotifier.updateSearchStatus(false);
            shieldCollector = this.modelNotifier.getSearchResultFromListByIndex(n);
        } else {
            shieldCollector = this.resultListHandler.getSearchResult(n);
        }
        if (shieldCollector != null) {
            if (this.spellerHandler.isSpellerTextEmpty()) {
                this.destinationDistance = 0;
                this.destinationDirection = 0;
                this.lastDestSelected(shieldCollector);
            } else {
                this.destinationDistance = shieldCollector.res.distanceMeters;
                this.destinationDirection = shieldCollector.directionArrowIndex;
                this.searchResultSelected(shieldCollector);
            }
        }
    }

    private void handleSetupSlde(int n, int n2) {
        this.sldeViewActive = true;
        this.vicinityModeActive = n != 0;
        this.modelNotifier.setHousenumberAlternativesAvailable(false);
        TargetShield.resetSHIELDHousenumber();
        switch (n2) {
            case 0: {
                this.initializationInProgress = true;
                this.dsiHandler.configureDsiSearch();
                this.fillLastDests();
                this.initializationDoneAtLeasOnce = true;
                break;
            }
            case 2: {
                if (!this.lastSearchCompleted) {
                    this.doSearchQuery(this.spellerHandler.getSpellerData().getEnteredText(), true);
                    break;
                }
                TargetShield.printTrace("handleSetupSlde, don't resume search because this search was already completed");
                break;
            }
            case 1: {
                if (!this.initializationDoneAtLeasOnce) {
                    this.initializationInProgress = true;
                    this.dsiHandler.configureDsiSearch();
                    this.initializationDoneAtLeasOnce = true;
                }
                this.updateSearchPosition();
                if (this.spellerHandler.isSpellerTextEmpty()) {
                    this.fillLastDests();
                    break;
                }
                this.doSearchQuery(this.spellerHandler.getSpellerData().getEnteredText(), false);
                break;
            }
            case 3: {
                this.doSearchQuery(this.spellerHandler.getSpellerData().getEnteredText(), false);
                break;
            }
            case 4: {
                this.initializationInProgress = true;
                this.dsiHandler.configureDsiSearch();
                this.fillLastDests();
                this.spellerHandler.addCharacters(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPoiJpnCategory(), 0, 0);
                break;
            }
            case 5: {
                this.initializationInProgress = true;
                this.dsiHandler.configureDsiSearch();
                this.fillLastDests();
                this.spellerHandler.addCharacters(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getInvalidDestMemLocationAddressParts(), 0, 0);
                break;
            }
        }
        TargetShield.printTrace(new StringBuffer().append("SHIELD set up with configuration=").append(n2).toString());
        if (n2 != 0) {
            this.modelNotifier.quitModelWaitstate("handleSetupSlde with configuration != C0");
        }
    }

    private TryMatchLocationData createTryMatchLocationData(ShieldCollector shieldCollector) {
        TryMatchLocationData tryMatchLocationData = new TryMatchLocationData();
        tryMatchLocationData.latitude = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(shieldCollector.lat);
        tryMatchLocationData.longitude = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(shieldCollector.lon);
        tryMatchLocationData.poiCategory = -1;
        tryMatchLocationData.unstructured = "";
        block12: for (int i2 = 0; i2 < shieldCollector.res.tokens.length; ++i2) {
            if (shieldCollector.res.tokens[i2] == null) continue;
            switch (shieldCollector.res.tokens[i2].wordType) {
                case 1: {
                    tryMatchLocationData.town = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 2: {
                    tryMatchLocationData.townPart = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 3: {
                    tryMatchLocationData.street = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 103: {
                    tryMatchLocationData.junction = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 4: {
                    tryMatchLocationData.postalCode = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 5: {
                    tryMatchLocationData.poiName = shieldCollector.res.tokens[i2].token;
                    tryMatchLocationData.poiCategory = shieldCollector.res.poiType;
                    continue block12;
                }
                case 6: {
                    tryMatchLocationData.state = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 7: {
                    tryMatchLocationData.houseNumber = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 17: {
                    tryMatchLocationData.country = shieldCollector.res.tokens[i2].token;
                    continue block12;
                }
                case 80: {
                    continue block12;
                }
                default: {
                    tryMatchLocationData.unstructured = new StringBuffer().append(tryMatchLocationData.unstructured).append(" ").append(shieldCollector.res.tokens[i2].token).toString();
                }
            }
        }
        return tryMatchLocationData;
    }

    private void searchResultSelected(ShieldCollector shieldCollector) {
        Command command;
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
        if (bl && shieldCollector.getSourceOfEntry() == 4) {
            this.waitingForSearchResultsToBeResolved = true;
            SearchResult searchResult = shieldCollector.getSearchResult();
            byte[] byArray = searchResult.applicationData;
            command = new CmdStreamToNavLocation(this, 0, byArray);
        } else {
            this.waitingForSearchResultsToBeResolved = true;
            TryMatchLocationData tryMatchLocationData = this.createTryMatchLocationData(shieldCollector);
            if (tryMatchLocationData.houseNumber != null && !tryMatchLocationData.houseNumber.equals("")) {
                TargetShield.setSHIELDHousenumber(tryMatchLocationData.houseNumber);
            }
            command = new CmdTryMatchLocation(this, tryMatchLocationData);
            command.setBlindArgument("Command", new TargetShield$2(this, command, bl));
            TargetShield.setSelectedSearchResult(shieldCollector.res);
        }
        if (this.searchIsActive || this.searchIsPending) {
            this.queuedCmd = command;
            this.cancelQuery();
        } else {
            command.execute();
        }
    }

    private void resolveSearchResult(ShieldCollector shieldCollector) {
        this.waitingForSearchResultsToBeResolved = true;
        TargetShield.printTrace("resolveSearchResult, entry");
        logger.makeTrace().append("resolveSearchResult for NavLocation ").append(shieldCollector.navLocation).log();
        if (shieldCollector.navLocation.proprietaryData.length >= 9 && shieldCollector.navLocation.proprietaryData[8].data != null) {
            EventGeneric eventGeneric = SldeEventHelper.generateEvent(new Integer(shieldCollector.navLocation.proprietaryData[8].data), 104412416);
            eventGeneric.setObject(121189632, shieldCollector);
            TargetShield.printTrace(new StringBuffer().append("resolveSearchResult, send resolve event for result ").append(shieldCollector.id).toString());
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    private void lastDestSelected(ShieldCollector shieldCollector) {
        NavLocation navLocation = this.resultListHandler.getLastDest(shieldCollector);
        TargetShield.printTrace(new StringBuffer().append("LIST_SELECT_BY_ID: Lastdest selected element is: ").append(navLocation).toString());
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        NavigationShieldLocationCollector navigationShieldLocationCollector = new NavigationShieldLocationCollector();
        navigationShieldLocationCollector.navigation_shield_location_address_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(iLocationWrapper);
        navigationShieldLocationCollector.navigation_shield_location_guidable = navLocation.positionValid;
        navigationShieldLocationCollector.navigation_shield_location_phone_number = iLocationWrapper.getPhonenumber();
        navigationShieldLocationCollector.navigation_shield_location_address_type = iLocationWrapper.isPoiNameAvailable() ? 6 : 2;
        ASLNavigationUtilFactory.getNavigationUtilApi().setDestInputLocation(iLocationWrapper.getLocation());
        navigationShieldLocationCollector.navigation_shield_location_icon = this.getIconResourceLocator(iLocationWrapper, navigationShieldLocationCollector);
        this.updateSelectedSearchResultsAndCharging(iLocationWrapper, navigationShieldLocationCollector);
        this.centerMap(navLocation);
        TargetShield.setLocation(shieldCollector.navLocation);
        addLocationToHistory = false;
        this.modelNotifier.quitModelWaitstate("lastDestSelected");
    }

    void centerMap(NavLocation navLocation) {
        int n = 25;
        if (this.resultListHandler.isOnlineResultList()) {
            n = 2;
        }
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, n, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(3, mapConfiguration);
    }

    public void handleSearchResultReceived(SearchResult searchResult) {
        if (this.acceptIncomingSearchResults) {
            this.resultListHandler.addSearchResult(searchResult, this.currentSearchPosition);
            this.modelNotifier.setNextPageAvailable(this.resultListHandler.isNextPageAvailable());
            SearchResult searchResult2 = this.resultListHandler.getFirstResult();
            if (searchResult2 == searchResult) {
                if (searchResult.suggestion != null && !this.isChnEnabled) {
                    this.spellerHandler.setMatchCompletion(searchResult.suggestion.getSuggestion());
                    TargetShield.printTrace(new StringBuffer().append("Got searchresult with suggestion: '").append(searchResult.suggestion.getSuggestion()).append("'").toString());
                } else {
                    this.spellerHandler.setMatchCompletion("");
                }
            }
            TargetShield.printTrace(new StringBuffer().append("SearchResult returned: ").append(searchResult.toString()).toString());
            this.showLastDests = false;
            this.modelNotifier.updateSearchResultList(this.resultListHandler.getSearchResults());
        } else {
            TargetShield.printTrace("SearchResult received but not accepted because acceptIncomingSearchResults==false");
        }
    }

    public void handleSearchIsActive(boolean bl) {
        this.searchIsActive = bl;
        if (bl) {
            this.modelNotifier.updateSearchStatus(bl);
            this.lastSearchCompleted = true;
            this.searchWasCanceled = false;
            this.searchIsPending = false;
            if (this.queuedCancel) {
                TargetShield.printTrace("handleSearchIsActive, executing queued cancel request.");
                this.queuedCancel = false;
                this.cancelQuery();
            }
        } else {
            if (this.searchWasCanceled) {
                TargetShield.printTrace("handleSearchIsActive, search aborted because cancelQuery was called.");
                this.lastSearchCompleted = false;
            } else {
                TargetShield.printTrace("handleSearchIsActive, search naturally ended.");
                this.modelNotifier.updateSearchStatus(bl);
            }
            if (this.queuedSetupSldeType != -1) {
                try {
                    TargetShield.printTrace("Search finished. Executing queued setup slde handling.");
                    this.handleSetupSlde(this.queuedSetupSldeType, this.queuedSetupSldeConfiguration);
                }
                catch (GenericEventException genericEventException) {
                    TargetShield.printTrace("Error executing queued setup slde handling.");
                }
                this.queuedSetupSldeType = -1;
                this.queuedSetupSldeConfiguration = -1;
            }
            if (this.queuedCmd != null) {
                this.queuedCmd.execute();
                this.queuedCmd = null;
            }
            if (this.queuedItemsToResolve != null) {
                this.resolveResults(this.queuedItemsToResolve);
            }
        }
        if (!bl && !this.queuedNeedle.equals("")) {
            this.doSearchQuery(this.queuedNeedle, this.queuedResumeQuery);
            this.queuedNeedle = "";
        }
    }

    public void handleCountriesSet() {
        this.updateSearchPosition();
        TargetShield.printTrace("handleCountriesSet, waiting for xt9init to finish until waitstate is quit");
    }

    public void handleSetCurrentPositionResult(int n) {
        TargetShield.printTrace("handleSetCurrentPositionResult, init finished");
        this.initializationInProgress = false;
        if (this.queuedSetupSldeType != -1 && !this.searchIsActive && !this.searchIsPending) {
            try {
                TargetShield.printTrace("Search finished. Executing queued setup slde handling.");
                this.handleSetupSlde(this.queuedSetupSldeType, this.queuedSetupSldeConfiguration);
            }
            catch (GenericEventException genericEventException) {
                TargetShield.printTrace("Error executing queued setup slde handling.");
            }
            this.queuedSetupSldeType = -1;
            this.queuedSetupSldeConfiguration = -1;
        }
        if (this.queuedCancel) {
            TargetShield.printTrace("handleSetCurrentPositionResult, executing queued cancel request.");
            this.queuedCancel = false;
            this.cancelQuery();
        }
        if (!this.queuedNeedle.equals("")) {
            this.doSearchQuery(this.queuedNeedle, this.queuedResumeQuery);
            this.queuedNeedle = "";
        }
    }

    public void handleCancelQueryResult(int n, int n2) {
        if (n2 == 0) {
            if (!this.waitingForSearchResultsToBeResolved && !this.resolveResults) {
                this.modelNotifier.quitModelWaitstate("handleCancelQueryResult received and not waiting for results to be resolved.");
            } else {
                TargetShield.printTrace("dsiSearchCancelQueryResult throw away event because we are waiting for dsiNavigationLiTryMatchLocationResult.");
            }
        } else {
            TargetShield.printTrace(new StringBuffer().append("dsiSearchCancelQueryResult throw away event because success ==").append(n2).toString());
        }
    }

    public void handleLiCurrentState(int[] nArray, int[] nArray2, NavLocation navLocation) {
        TargetShield.printTrace(new StringBuffer().append("dsiNavigationLiSetCurrentLD returns new location: ").append(navLocation.toString()).toString());
        this.updateNextAvailableCriterions(nArray, navLocation);
        this.setHousenumberSpellerToUse(nArray2);
        this.centerMap(navLocation);
        this.modelNotifier.quitModelWaitstate("handleLiCurrentState completely processed");
    }

    private void setHousenumberSpellerToUse(int[] nArray) {
        if (nArray == null) {
            this.setDefaultHousenumberSpeller();
            TargetShield.printTrace("Usefulrefinements are null.");
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 136) {
                this.setDefaultHousenumberSpeller();
                return;
            }
            if (nArray[i2] != 5) continue;
            TargetShield.resetSHIELDHousenumber();
            this.setPointLocationHousenumberSpeller();
            return;
        }
        this.setDefaultHousenumberSpeller();
        TargetShield.printTrace("Fallback to default hnr speller. No housenumber speller available in usefulrefinementcriteria");
    }

    private void setDefaultHousenumberSpeller() {
        TargetShield.printTrace("Enable default hnr speller");
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setPointLocation(false);
        this.updatePointLocationGetter(false);
    }

    private void setPointLocationHousenumberSpeller() {
        TargetShield.printTrace("Enable nvc hnr speller");
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setPointLocation(true);
        this.updatePointLocationGetter(true);
    }

    private void updatePointLocationGetter(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-152104960, bl);
    }

    public void handleLastDestinationsUpdate(LDListElement[] lDListElementArray) {
        TargetShield.printTrace("UPDATE: lastDestinationsList updated");
        this.resultListHandler.clearLastDests();
        this.resolveLastDests(lDListElementArray);
    }

    public void handleLastDestionationUpdate(NavLocation navLocation) {
        this.resultListHandler.updateLastDests(navLocation);
        if (this.showLastDests) {
            this.fillLastDests();
        }
        TargetShield.printTrace(new StringBuffer().append("dsiNavigationDmLastDestinationsGetResult -> Adding location: ").append(navLocation.toString()).append(" to SHIELD LastdestsLocations").toString());
    }

    @Override
    public void handleCommandCmdTryMatchLocation(CmdTryMatchLocation cmdTryMatchLocation) {
        Object object = cmdTryMatchLocation.getBlindArgument("Command");
        if (object != null && object instanceof Runnable) {
            ((Runnable)object).run();
        }
    }

    @Override
    public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
        NavLocation navLocation;
        if (!cmdStreamToNavLocation.isResultSuccess()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("StreamToNavLocationResult didn't succeed on southside");
        }
        if ((navLocation = cmdStreamToNavLocation.getLocationToStream()) == null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("StreamToNavLocationResult didn't succeed on southside - Returned location is null");
        }
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        NavigationShieldLocationCollector navigationShieldLocationCollector = new NavigationShieldLocationCollector();
        navigationShieldLocationCollector.navigation_shield_location_address_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(iLocationWrapper);
        navigationShieldLocationCollector.navigation_shield_location_guidable = iLocationWrapper.isNavigable();
        navigationShieldLocationCollector.navigation_shield_location_distance = this.destinationDistance;
        navigationShieldLocationCollector.navigation_shield_location_direction_arrow_index = this.destinationDirection;
        navigationShieldLocationCollector.navigation_shield_location_phone_number = iLocationWrapper.getPhonenumber();
        navigationShieldLocationCollector.navigation_shield_location_url = iLocationWrapper.getURLAddress();
        navigationShieldLocationCollector.navigation_shield_location_address_type = iLocationWrapper.isPoiNameAvailable() ? 4 : 2;
        navigationShieldLocationCollector.navigation_shield_location_icon = this.getIconResourceLocator(iLocationWrapper, navigationShieldLocationCollector);
        this.updateSelectedSearchResultsAndCharging(iLocationWrapper, navigationShieldLocationCollector);
        TargetShield.printTrace(new StringBuffer().append("dsiNavigationStreamToNavLocationResult returns new location: ").append(iLocationWrapper.getLocation().toString()).toString());
        ASLNavigationUtilFactory.getNavigationUtilApi().setDestInputLocation(iLocationWrapper.getLocation());
        this.centerMap(iLocationWrapper.getLocation());
        TargetShield.printTrace("dsiNavigationStreamToNavLocationResult setting shield location to null to prevent writing it in history again");
        TargetShield.setLocation(iLocationWrapper.getLocation());
        this.modelNotifier.setHousenumberAlternativesAvailable(false);
        addLocationToHistory = false;
        this.waitingForSearchResultsToBeResolved = false;
        this.modelNotifier.quitModelWaitstate("handleCommandCmdStreamToNavLocation");
    }

    private void updateNextAvailableCriterions(int[] nArray, NavLocation navLocation) {
        boolean bl = false;
        boolean bl2 = false;
        if (nArray == null) {
            ServiceManager.logger.error(16384).append(" TargetShield: No nextAvailableCriterions are being received").log();
        } else {
            LogMessage logMessage = null;
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                logMessage = ServiceManager.logger.trace(16384).append(" TargetShield: updateNextAvailableCriterions([");
            }
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (ServiceManager.logger.isTraceEnabled(16384) && logMessage != null) {
                    logMessage = logMessage.append(nArray[i2]).append(", ");
                }
                if (nArray[i2] == 5) {
                    bl2 = true;
                }
                if (nArray[i2] != 136) continue;
                bl = true;
            }
            if (ServiceManager.logger.isTraceEnabled(16384) && logMessage != null) {
                logMessage.append("], ").append(navLocation.toString()).log();
            }
        }
        this.modelNotifier.updateRefinementsForHNO(bl2, bl);
    }

    private void resolveLastDests(LDListElement[] lDListElementArray) {
        if (lDListElementArray == null) {
            logger.makeError().append("lastDestinationList is null").log();
        } else {
            for (int i2 = 0; i2 < lDListElementArray.length; ++i2) {
                LDListElement lDListElement = lDListElementArray[i2];
                this.dsiHandler.dmLastDestionsGet(lDListElement.getId());
            }
        }
    }

    static void printTrace(String string) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(string).log();
        }
    }

    static void printError(String string) {
        if (logger.isTraceEnabled()) {
            logger.makeError().append(string).log();
        }
    }

    private void clearResultList() {
        this.resultListHandler.clear();
        this.showLastDests = false;
        this.modelNotifier.updateSearchResultList(this.resultListHandler.getSearchResults());
    }

    ResourceLocator getIconResourceLocator(ILocationWrapper iLocationWrapper, Object object) {
        int n = iLocationWrapper.getIconIndex();
        return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(n, iLocationWrapper.getSubIconIndex(), 0, this, object);
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        TargetShield.printTrace(" SHIELD: handleIconCacheUpdate");
        if (object instanceof NavigationShieldLocationCollector) {
            this.modelNotifier.updateLocationIcon(resourceLocator);
        }
        if (object instanceof ShieldCollector) {
            ((ShieldCollector)object).resourceLocator = resourceLocator;
            this.showLastDests = false;
            this.modelNotifier.updateSearchResultList(this.resultListHandler.getSearchResults());
        }
    }

    public static void setSHIELDHousenumber(String string) {
        TargetShield.printTrace(new StringBuffer().append("Setting housenumber that has to be searched for in LocationInput: ").append(string).toString());
        housenumber = string;
    }

    public static void resetSHIELDHousenumber() {
        TargetShield.printTrace("Resetting housenumber ");
        housenumber = "";
    }

    public static void setLocation(NavLocation navLocation) {
        location = navLocation;
    }

    public static void setSelectedSearchResult(SearchResult searchResult) {
        selectedSearchResult = searchResult;
    }

    public void setSearchResults(Vector vector, boolean bl, NavLocation navLocation, boolean bl2) {
        TargetShield.printTrace(new StringBuffer().append("setSearchResults called with ").append(vector.size()).append(" results. Search active: ").append(bl).toString());
        if (vector.size() == 0) {
            this.lastFlags = new ArrayList();
        }
        this.resultListHandler.setSearchResults(vector, navLocation, bl2);
        this.showLastDests = false;
        this.modelNotifier.updateSearchResultList(this.resultListHandler.getSearchResults());
        this.modelNotifier.updateMapSearchResultList(this.resultListHandler.getSearchResults());
        if (!bl) {
            this.setFlags();
        }
    }

    public void switchToResultMapView(boolean bl) {
        this.quitModelWaitstate = bl;
        this.modelNotifier.setNextPageAvailable(false);
        this.resultListHandler.freezeResultList();
        List list = (List)this.resultListHandler.getFrozenResults();
        this.modelNotifier.updateMapSearchResultList(list);
        int n = 6;
        if (list.size() <= 6 && list.size() >= 0) {
            n = list.size();
        }
        this.resolveResults(list.subList(0, n).toArray(new ShieldCollector[0]));
    }

    private void cancelQuery() {
        if (this.searchIsActive || this.searchIsPending) {
            if (!this.searchWasCanceled) {
                if (!this.initializationInProgress && !this.searchIsPending) {
                    this.searchWasCanceled = true;
                    this.dsiHandler.cancelQuery();
                } else {
                    TargetShield.printTrace("cancelquery, init in progress or search started but not yet acknowledged by southside. Waiting until it's done.");
                    this.queuedCancel = true;
                }
            } else {
                TargetShield.printTrace("cancelquery, don't send cancelQuery because cancel for this search was already sent.");
            }
        } else {
            TargetShield.printTrace("cancelquery, don't send cancelQuery because search is not active or pending.");
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.dsiHandler.resetSettingsForNavi();
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1041231872, true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setShowSldeHelp(true);
        this.navigationResetParticipant.notifyResetDone();
    }

    @Override
    public void handleFullFacotryReset() {
        this.dsiHandler.resetSettingsForFullFactoryReset();
        this.fullFactoryResetParticipant.notifyResetDone();
    }

    void resolveResults(Object[] objectArray) {
        this.resolveResults = true;
        TargetShield.printTrace(new StringBuffer().append("resolveResults resultcount=").append(objectArray.length).toString());
        if (this.searchIsActive || this.searchIsPending) {
            TargetShield.printTrace("resolveResults waiting for search to end. First canceling running query");
            this.queuedItemsToResolve = objectArray;
            this.cancelQuery();
        } else {
            TargetShield.printTrace("resolveResults lets go");
            boolean bl = true;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ShieldCollector shieldCollector = (ShieldCollector)objectArray[i2];
                if (shieldCollector.lat != 0.0f || shieldCollector.lon != 0.0f) continue;
                bl = false;
                this.dualListViewHandler.setMapReady(false);
                this.resolveSearchResult(shieldCollector);
            }
            if (bl && this.pendingResolveSearchResultRequests.size() == 0) {
                TargetShield.printTrace("resolveResults, nothing to be resolved");
                this.handleAllSearchResultsResolved();
            }
            this.queuedItemsToResolve = null;
        }
    }

    void handleAllSearchResultsResolved() {
        int n = this.dualListViewHandler.getCurrentStartIndex();
        int n2 = this.dualListViewHandler.getCurrentStartIndex() + this.dualListViewHandler.getCurrentItemCount();
        TargetShield.printTrace(new StringBuffer().append("handleAllSearchResultsResolved, get sublist from ").append(n).append(" to ").append(n2).toString());
        this.lastFlags = this.resultListHandler.getSubList(n, n2);
        this.setFlags();
        this.drawFlags();
        if (!this.resultListHandler.isExternalResultList() && !this.lastSearchCompleted) {
            this.doSearchQuery(this.spellerHandler.getSpellerData().getEnteredText(), true);
        } else {
            TargetShield.printTrace("handleAllSearchResultsResolved, do not continue search because we are not in shield mode or last search was complete");
        }
        if (this.quitModelWaitstate && !this.isWaitingForTryMatchLocationResults()) {
            this.modelNotifier.quitModelWaitstate("handleAllSearchResultsResolved");
            this.quitModelWaitstate = false;
        }
    }

    private void setFlags() {
        if (this.resultListHandler.isOnlineResultList()) {
            TargetShield.printTrace(new StringBuffer().append("handleAllSearchResultsResolved, setting flags for ").append(this.lastFlags.size()).append(" elements of type online").toString());
            this.dualListViewHandler.setFlags(this.lastFlags, true);
        } else {
            TargetShield.printTrace(new StringBuffer().append("handleAllSearchResultsResolved, setting flags for ").append(this.lastFlags.size()).append(" elements of type VW").toString());
            this.dualListViewHandler.setFlags(this.lastFlags, false);
        }
    }

    private void drawFlags() {
        TargetShield.printTrace(new StringBuffer().append("handleAllSearchResultsResolved, drawing ").append(this.lastFlags.size()).append(" flags").toString());
        this.dualListViewHandler.drawFlags();
    }

    public boolean isWaitingForTryMatchLocationResults() {
        return this.waitingForSearchResultsToBeResolved;
    }

    public ShieldResultListHandler getResultListHandler() {
        return this.resultListHandler;
    }

    void handleSelectedSearchResult(NavLocation navLocation, int n, int n2, int n3, boolean bl) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        NavigationShieldLocationCollector navigationShieldLocationCollector = new NavigationShieldLocationCollector();
        navigationShieldLocationCollector.navigation_shield_location_address_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(iLocationWrapper);
        navigationShieldLocationCollector.navigation_shield_location_guidable = iLocationWrapper.isNavigable();
        navigationShieldLocationCollector.navigation_shield_location_distance = n;
        navigationShieldLocationCollector.navigation_shield_location_direction_arrow_index = n2;
        navigationShieldLocationCollector.navigation_shield_location_phone_number = iLocationWrapper.getPhonenumber();
        navigationShieldLocationCollector.navigation_shield_location_url = iLocationWrapper.getURLAddress();
        navigationShieldLocationCollector.navigation_shield_location_address_type = iLocationWrapper.isPoiNameAvailable() ? 4 : 2;
        navigationShieldLocationCollector.navigation_shield_location_icon = this.getIconResourceLocator(iLocationWrapper, navigationShieldLocationCollector);
        this.updateSelectedSearchResultsAndCharging(iLocationWrapper, navigationShieldLocationCollector);
        ASLNavigationUtilFactory.getNavigationUtilApi().setDestInputLocation(iLocationWrapper.getLocation());
        this.centerMap(iLocationWrapper.getLocation());
        TargetShield.setLocation(iLocationWrapper.getLocation());
        if (n3 == 5) {
            ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setSpellerContextLocation(iLocationWrapper.getLocation());
            this.modelNotifier.setHousenumberAlternativesAvailable(true);
            addLocationToHistory = true;
            this.dsiHandler.liSetCurrentLd(iLocationWrapper.getLocation());
        } else {
            this.modelNotifier.setHousenumberAlternativesAvailable(false);
            if (bl) {
                addLocationToHistory = true;
                TargetShield.setSHIELDHousenumber(iLocationWrapper.getLocation().getHousenumber());
            } else {
                addLocationToHistory = false;
            }
            this.modelNotifier.quitModelWaitstate("handleSelectedSearchResult completed");
        }
    }

    void handleSelectedOnlineSearchResult(ShieldCollector shieldCollector, NavLocation navLocation) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        NavigationShieldLocationCollector navigationShieldLocationCollector = new NavigationShieldLocationCollector();
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = (FixFormatterFieldDataImpl)ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(iLocationWrapper);
        fixFormatterFieldDataImpl.put("PoiName", shieldCollector.fakeNavLocation.proprietaryData[0].data);
        fixFormatterFieldDataImpl.put("URLAddress", shieldCollector.fakeNavLocation.proprietaryData[6].data);
        fixFormatterFieldDataImpl.put("Phonenumber", shieldCollector.fakeNavLocation.proprietaryData[7].data);
        navigationShieldLocationCollector.navigation_shield_location_address_details_for_fix_formatter = fixFormatterFieldDataImpl;
        navigationShieldLocationCollector.navigation_shield_location_guidable = iLocationWrapper.isNavigable();
        navigationShieldLocationCollector.navigation_shield_location_distance = new Integer(shieldCollector.fakeNavLocation.proprietaryData[4].data);
        navigationShieldLocationCollector.navigation_shield_location_direction_arrow_index = new Integer(shieldCollector.fakeNavLocation.proprietaryData[3].data);
        navigationShieldLocationCollector.navigation_shield_location_phone_number = shieldCollector.fakeNavLocation.proprietaryData[7].data;
        navigationShieldLocationCollector.navigation_shield_location_url = shieldCollector.fakeNavLocation.proprietaryData[6].data;
        navigationShieldLocationCollector.navigation_shield_location_address_type = 4;
        navigationShieldLocationCollector.navigation_shield_location_icon = this.getIconResourceLocator(iLocationWrapper, navigationShieldLocationCollector);
        this.updateSelectedSearchResultsAndCharging(iLocationWrapper, navigationShieldLocationCollector);
        ASLNavigationUtilFactory.getNavigationUtilApi().setDestInputLocation(iLocationWrapper.getLocation());
        this.centerMap(iLocationWrapper.getLocation());
        TargetShield.setLocation(iLocationWrapper.getLocation());
        this.modelNotifier.setHousenumberAlternativesAvailable(false);
        addLocationToHistory = false;
        this.modelNotifier.quitModelWaitstate("handleSelectedOnlineSearchResult completed");
    }

    private void updateSelectedSearchResultsAndCharging(ILocationWrapper iLocationWrapper, NavigationShieldLocationCollector navigationShieldLocationCollector) {
        this.writePoiChargingStationDetails(navigationShieldLocationCollector, iLocationWrapper);
        this.modelNotifier.updateSelectedSearchResult(navigationShieldLocationCollector);
        ShieldResultConnectorDetailsCollector[] shieldResultConnectorDetailsCollectorArray = new ShieldResultConnectorDetailsCollector[iLocationWrapper.getEConnectorCount()];
        this.writeConnectorDetails(shieldResultConnectorDetailsCollectorArray, iLocationWrapper);
        this.modelNotifier.notifyConnectorDetails(shieldResultConnectorDetailsCollectorArray);
    }

    private void writeConnectorDetails(ShieldResultConnectorDetailsCollector[] shieldResultConnectorDetailsCollectorArray, ILocationWrapper iLocationWrapper) {
        IEConnector[] iEConnectorArray = iLocationWrapper.getEConnectors();
        for (int i2 = 0; i2 < iLocationWrapper.getEConnectorCount(); ++i2) {
            String string;
            String string2;
            int n;
            String string3;
            String string4;
            shieldResultConnectorDetailsCollectorArray[i2] = new ShieldResultConnectorDetailsCollector(0, "", "", "", "", 0, 0);
            if (iEConnectorArray[i2] == null) {
                TargetShield.printError(new StringBuffer().append("eConnector[").append(i2).append("] == null!").toString());
                continue;
            }
            shieldResultConnectorDetailsCollectorArray[i2].chargeMode = string4 = iEConnectorArray[i2].getChargeMode() != null ? iEConnectorArray[i2].getChargeMode() : "";
            shieldResultConnectorDetailsCollectorArray[i2].chargeLevel = string3 = iEConnectorArray[i2].getChargeLevel() != null ? iEConnectorArray[i2].getChargeLevel() : "";
            shieldResultConnectorDetailsCollectorArray[i2].count = n = iEConnectorArray[i2].getCountAvailable();
            shieldResultConnectorDetailsCollectorArray[i2].fuseProtection = string2 = iEConnectorArray[i2].getFuseProtection() != null ? iEConnectorArray[i2].getFuseProtection() : "";
            shieldResultConnectorDetailsCollectorArray[i2].name = string = iEConnectorArray[i2].getName() != null ? iEConnectorArray[i2].getName() : "";
            float f2 = iEConnectorArray[i2].getPowerOutput();
            shieldResultConnectorDetailsCollectorArray[i2].poweroutput = (int)(f2 * 31300);
            int n2 = iEConnectorArray[i2].getType();
            switch (n2) {
                case -1: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 0;
                    break;
                }
                case 15: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 1;
                    break;
                }
                case 32: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 2;
                    break;
                }
                case 33: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 3;
                    break;
                }
                case 42: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 4;
                    break;
                }
                case 43: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 5;
                    break;
                }
                case 31: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 6;
                    break;
                }
                case 41: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 7;
                    break;
                }
                default: {
                    shieldResultConnectorDetailsCollectorArray[i2].type = 0;
                    TargetShield.printError("'type' unknown value!");
                }
            }
            TargetShield.printTrace(new StringBuffer().append("chargeMode=").append(string4).toString());
            TargetShield.printTrace(new StringBuffer().append("chargeLevel=").append(string3).toString());
            TargetShield.printTrace(new StringBuffer().append("countAvailable=").append(n).toString());
            TargetShield.printTrace(new StringBuffer().append("fuseProtection=").append(string2).toString());
            TargetShield.printTrace(new StringBuffer().append("name=").append(string).toString());
            TargetShield.printTrace(new StringBuffer().append("powerOutput=").append(f2).toString());
            TargetShield.printTrace(new StringBuffer().append("type=").append(n2).toString());
        }
    }

    private void writePoiChargingStationDetails(NavigationShieldLocationCollector navigationShieldLocationCollector, ILocationWrapper iLocationWrapper) {
        String string = iLocationWrapper.getChargingStationProvider() != null ? iLocationWrapper.getChargingStationProvider() : "";
        int n = iLocationWrapper.getChargingStationAccess();
        int n2 = iLocationWrapper.getChargingStationOnSitePayment();
        int n3 = iLocationWrapper.getChargingStationOpen24h();
        int n4 = iLocationWrapper.getChargingStationPay();
        int n5 = iLocationWrapper.getChargingStationSubscription();
        int n6 = iLocationWrapper.getEConnectorCount();
        navigationShieldLocationCollector.navigation_shield_location_result_selected_details_provider_available = string != null && string.length() > 0;
        navigationShieldLocationCollector.navigation_shield_location_result_selected_details_provider = string;
        switch (n) {
            case -1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access = 0;
                break;
            }
            case 0: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access = 1;
                break;
            }
            case 1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access = 2;
                break;
            }
            case 2: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access = 3;
                break;
            }
            case 3: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access = 4;
                break;
            }
            default: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_access = 0;
                TargetShield.printError("'chargingAccess' unknown value!");
            }
        }
        switch (n2) {
            case -1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment_available = false;
                break;
            }
            case 0: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment_available = false;
                break;
            }
            case 1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment_available = true;
                break;
            }
            default: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment_available = false;
                TargetShield.printError("'chargingStationOnSitePayment' unknown value!");
            }
        }
        switch (n2) {
            case -1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment__enum = 0;
                break;
            }
            case 0: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment__enum = 2;
                break;
            }
            case 1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment__enum = 1;
                break;
            }
            default: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_onsitepayment__enum = 0;
                TargetShield.printError("'chargingStationOnSitePayment' unknown value!");
            }
        }
        switch (n3) {
            case 1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_open24h = 2;
                break;
            }
            default: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_open24h = 0;
            }
        }
        switch (n4) {
            case -1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_payment = 0;
                break;
            }
            case 0: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_payment = 2;
                break;
            }
            case 1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_payment = 1;
                break;
            }
            default: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_payment = 0;
                TargetShield.printError("'chargingStationPay' unknown value!");
            }
        }
        switch (n5) {
            case -1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_subscription = 0;
                break;
            }
            case 0: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_subscription = 2;
                break;
            }
            case 1: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_subscription = 1;
                break;
            }
            default: {
                navigationShieldLocationCollector.navigation_shield_location_result_selected_details_subscription = 0;
                TargetShield.printError("'chargingStationSubscription' unknown value!");
            }
        }
        navigationShieldLocationCollector.navigation_shield_location_result_selected_details_connector_count = n6;
        TargetShield.printTrace(new StringBuffer().append("chargingProvider=").append(string).toString());
        TargetShield.printTrace(new StringBuffer().append("chargingAccess=").append(n).toString());
        TargetShield.printTrace(new StringBuffer().append("chargingStationOnSitePayment=").append(n2).toString());
        TargetShield.printTrace(new StringBuffer().append("chargingStationOpen24h=").append(n3).toString());
        TargetShield.printTrace(new StringBuffer().append("chargingStationPay=").append(n4).toString());
        TargetShield.printTrace(new StringBuffer().append("chargingStationSubscription=").append(n5).toString());
        TargetShield.printTrace(new StringBuffer().append("eConnectorCount=").append(n6).toString());
    }

    public void setSelectedSearchResultFromExternal(NavLocation navLocation, Integer n) {
        ShieldCollector shieldCollector = this.resultListHandler.getSearchResult(n);
        if (this.resultListHandler.isOnlineResultList()) {
            this.handleSelectedOnlineSearchResult(shieldCollector, navLocation);
        } else {
            int n2 = new Integer(shieldCollector.navLocation.proprietaryData[4].data);
            int n3 = new Integer(shieldCollector.navLocation.proprietaryData[3].data);
            this.handleSelectedSearchResult(navLocation, n2, n3, 3, false);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        this.dsiHandler.reset(hashMap);
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = TargetShield.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("TargetShield: resetting values after DSI restart");
            }
            this.initLocalVariables();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetShield: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        housenumber = "";
        this.destinationDistance = 0;
        this.destinationDirection = 0;
        location = null;
        addLocationToHistory = false;
        selectedSearchResult = null;
        this.waitingForSearchResultsToBeResolved = false;
        this.vicinityModeActive = false;
        this.currentSearchPosition = null;
        this.sldeViewActive = false;
        this.pendingResolveSearchResultRequests = new Vector();
        this.discardTryMatchLocations = false;
        this.acceptIncomingSearchResults = false;
        this.searchIsPending = false;
        this.searchIsActive = false;
        this.queuedNeedle = "";
        this.queuedResumeQuery = false;
        this.queuedCmd = null;
        this.queuedItemsToResolve = null;
        this.queuedCancel = false;
        this.queuedSetupSldeType = -1;
        this.queuedSetupSldeConfiguration = -1;
        this.lastSearchCompleted = true;
        this.searchWasCanceled = false;
        this.initializationInProgress = false;
        this.showLastDests = false;
        this.resolveResults = false;
        this.lastFlags = new ArrayList();
    }

    public void setAllowReceivingEvents(boolean bl) {
        this.allowReceivingEvents = bl;
    }

    public void initXt9Finished() {
        TargetShield.printTrace("initXt9Finished");
        this.modelNotifier.quitModelWaitstate("handleCountriesSet, initXt9Finished");
    }

    public void setSearchResult(NavLocation navLocation, int n, NavLocation navLocation2, boolean bl, NavLocation navLocation3, boolean bl2) {
        TargetShield.printTrace(new StringBuffer().append("setSearchResult called with ").append(navLocation2).append(" Search active: ").append(bl).toString());
        this.resultListHandler.setSearchResult(navLocation, n, navLocation2, navLocation3, bl2);
        this.showLastDests = false;
        this.modelNotifier.updateSearchResultList(this.resultListHandler.getSearchResults());
        this.modelNotifier.updateMapSearchResultList(this.resultListHandler.getSearchResults());
        if (!bl) {
            this.dualListViewHandler.drawFlags();
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


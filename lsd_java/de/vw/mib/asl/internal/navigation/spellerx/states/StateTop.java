/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.states;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.spellerx.XSpellerHandlerMap;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.IEvents;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdHistoryAddLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdNavLocationToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetNVCRange;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTargetDecorator;
import de.vw.mib.asl.internal.navigation.spellerx.handler.DestInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HomeInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.states.NavReflectionState;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateMapCode;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePhoneNumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateZipCode;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputLocationCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.SearchResult;

public class StateTop
extends NavReflectionState
implements CacheClient {
    private static boolean IS_HIGH_JP = ServiceManager.configManagerDiag.isFeatureFlagSet(75) & ServiceManager.configManagerDiag.isFeatureFlagSet(70);
    private XSpellerTarget target;
    private boolean stripEventReceived = false;
    private DSISearch dsiSearch;
    private LISpellerData discardData;
    private boolean setInputActive;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;

    public StateTop(XSpellerTarget xSpellerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(xSpellerTarget, hsm, string, hsmState);
        this.target = xSpellerTarget;
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
    }

    public void evtHSM_EXIT(AbstractReflectionContext abstractReflectionContext) {
        SpellerContext.ACTIVE_HISTORY_MODE = 10001;
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_COPY_LOCATION(SpellerContext spellerContext, int n, int n2) {
        SpellerContext.setActiveExtInterfaceField(0);
        SpellerHandler spellerHandler = XSpellerHandlerMap.getHandler(n, n2);
        if (spellerHandler != null) {
            spellerContext.setHandler(spellerHandler);
        }
        this.trace(new StringBuffer("StateTop: COPY_LOCATION from: ").append(n).append(" --> ").append(n2).toString());
        NavLocation navLocation = null;
        switch (n) {
            case 0: {
                navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation();
                break;
            }
            case 1: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDemoLocation();
                break;
            }
            case 2: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDestInputLocation();
                break;
            }
            case 3: {
                if (n2 == 10 || n2 == 4) {
                    navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDestInputLocation();
                    break;
                }
                navLocation = spellerContext.getLocation();
                break;
            }
            case 4: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPoiSearchLocation();
                break;
            }
            case 5: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMapInputLocation();
                break;
            }
            case 6: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMemoryLocation();
                break;
            }
            case 7: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDestInputLocation();
                break;
            }
            case 8: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getWpmLocation();
                break;
            }
            case 10: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getTourmodeLocation();
                break;
            }
            case 11: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExternalLocationInputLocation();
                break;
            }
            case 12: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getClickInMapLocation();
                break;
            }
            case 13: {
                if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null) {
                    navLocation = ASLNavigationTruffelFactory.getNavigationTruffelApi().getNavLocation();
                    break;
                }
                this.warn("StateTop -> CopyLocation: ShieldLocation is empty.");
                break;
            }
            case 14: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDetailViewLocation();
                break;
            }
            case 15: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getGuidanceInfoLocation();
                break;
            }
            case 16: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getTopOfLastDestLocation();
                break;
            }
            case 17: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPOILocation();
                break;
            }
            case 18: {
                navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getSldeVicinityLocation();
                break;
            }
        }
        if (navLocation == null) {
            navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation();
        }
        switch (n2) {
            case 0: {
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setHomeDest(navLocation, true);
                HomeInputHandler homeInputHandler = new HomeInputHandler();
                homeInputHandler.onLocationSaved(spellerContext);
                break;
            }
            case 1: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDemoLocation(navLocation);
                break;
            }
            case 2: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(navLocation);
                spellerContext.setLocation(navLocation);
                SpellerContext.setOriginalLocation(navLocation, this.target);
                DestInputHandler destInputHandler = new DestInputHandler();
                destInputHandler.onLocationSaved(spellerContext);
                if (!this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) break;
                if (Boolean.valueOf(System.getProperty("enableNARHistory", "false")).booleanValue()) {
                    this.trace(new StringBuffer("Adding location to NAR history: ").append(navLocation).toString());
                    new CmdHistoryAddLocation(this, navLocation).execute();
                    break;
                }
                this.trace("NAR writing location into history disabled");
                break;
            }
            case 3: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(navLocation);
                spellerContext.setLocation(navLocation);
                this.target.freezeAllLists();
                break;
            }
            case 4: {
                if (this.target.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiSearchLocation(navLocation);
                    spellerContext.setLocation(navLocation);
                    break;
                }
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiSearchLocation(navLocation);
                break;
            }
            case 5: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMapInputLocation(navLocation);
                break;
            }
            case 6: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(navLocation);
                break;
            }
            case 8: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmLocation(navLocation);
                break;
            }
            case 10: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTourmodeLocation(navLocation);
                break;
            }
            case 11: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setExternalLocationInputLocation(navLocation);
                break;
            }
            case 12: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setClickInMapLocation(navLocation);
                break;
            }
            case 13: {
                if (ASLNavigationTruffelFactory.getNavigationTruffelApi() == null) break;
                ASLNavigationTruffelFactory.getNavigationTruffelApi().setNavLocation(navLocation);
                break;
            }
            case 14: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDetailViewLocation(navLocation);
                new MatchTextSubjectUtil().updateMapHKNav(this.target, navLocation);
                ASLNavigationUtilFactory.getNavigationUtilApi().updateNavDetailLocationGetter(navLocation);
                break;
            }
            case 15: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setGuidanceInfoLocation(navLocation);
                new MatchTextSubjectUtil().updateMap(this.target, navLocation);
                break;
            }
            case 16: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTopOfLastDestLocation(navLocation);
                new MatchTextSubjectUtil().updateMap(this.target, navLocation);
                break;
            }
            case 17: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPOILocation(navLocation);
                break;
            }
            case 18: {
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSldeVicinityLocation(navLocation);
                break;
            }
        }
        SpellerContext.setOriginalLocation(navLocation, this.target);
        if (spellerHandler != null) {
            spellerContext.setHandler(spellerHandler);
            spellerContext.getHandler().onActivated(spellerContext);
        } else {
            spellerHandler = spellerContext.getHandler();
            if (spellerHandler != null) {
                spellerHandler.onLocationSaved(spellerContext);
                spellerContext.setHandler(null);
            }
        }
        ModelUpdater.updateLocationInputActionResult(true);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_SET_LAST_INPUT_MODE(AbstractReflectionContext abstractReflectionContext, int n) {
        this.trace(new StringBuffer("StateTop: evtEV_LOCATION_INPUT_SET_LAST_INPUT_MODE. Mode is ").append(n).toString());
        this.setLastInputMode(n);
    }

    public void evtEV_START_SPELLER_BY_HANDLER(ISpellerContext iSpellerContext, SpellerHandler spellerHandler) {
        iSpellerContext.setHandler(spellerHandler);
        spellerHandler.onActivated(iSpellerContext);
        ModelUpdater.updateLocationResolved(false);
        new CmdSetCurrentLD(this, iSpellerContext.getLocation()).execute();
        ModelUpdater.updateLocationInputActionResult(true);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.aslPropertyManager.valueChangedInteger(2965, 0);
    }

    public void evtEV_STRIP_BY_STRIP_ID(ISpellerContext iSpellerContext, int n) {
        this.stripEventReceived = true;
        new CmdStripLocation(this, this.target.getSpellerContext().getLocation(), n).execute();
    }

    public void evtEV_SET_CONTEXT_LOCATION(ISpellerContext iSpellerContext, NavLocation navLocation) {
        this.trace(new StringBuffer("StateTop: evtEV_SET_CONTEXT_LOCATION is called with location ").append(navLocation).toString());
        iSpellerContext.setLocation(navLocation);
    }

    public void evtEV_SAVE_SPELLER_BY_HANDLER(SpellerContext spellerContext, SpellerHandler spellerHandler) {
        spellerContext.setHandler(spellerHandler);
        spellerHandler.onLocationSaved(spellerContext);
        ModelUpdater.updateLocationInputActionResult(true);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.aslPropertyManager.valueChangedInteger(2965, 0);
    }

    public void evtASL_NAVIGATION_HOMEDESTINPUT_INIT(AbstractReflectionContext abstractReflectionContext) {
        ModelUpdater.updateLocationInputActionResult(true);
        ModelUpdater.updateHomeDestInputActionResult(true);
    }

    public void evtEV_LOCATION_INPUT_START_INPUT(AbstractReflectionContext abstractReflectionContext, int n) {
        SpellerContext.setActiveExtInterfaceField(0);
        this.setInputActive = true;
        int n2 = 0;
        XSpellerTargetDecorator.currentUseCase = 0;
        this.trace(new StringBuffer("StateTop: evtEV_LOCATION_INPUT_START_INPUT is called with field: ").append(n).toString());
        n2 = this.getStripTypeForField(n);
        if (n2 > 0) {
            if (n2 != 152) {
                new CmdStripLocation(this, this.target.getSpellerContext().getExtInterfaceLocation(), n2).execute();
            } else {
                this.trace("StateTop: evtEV_LOCATION_INPUT_START_INPUT: Don't send liStripLocation for ward field");
                XSpellerTarget.changeExtLocation(this.target.getSpellerContext().getExtInterfaceLocation(), XSpellerTarget.getExtAvailableSelectionCriteria(), false);
                ModelUpdater.updateLocationInputInputFieldActionResult(true);
                ModelUpdater.updateLocationInputActionResult(true);
            }
        } else {
            this.error(new StringBuffer("StateTop: StripType not supported: ").append(n).toString());
        }
    }

    public void evtEV_LOCATION_INPUT_SET_INPUT(AbstractReflectionContext abstractReflectionContext, int n, String string) {
        this.trace(new StringBuffer("StateTop: evtEV_LOCATION_INPUT_SET_INPUT").toString());
        this.transToSpeechEvent(n);
        this.sendSetInputEvent(string);
    }

    public void evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID(AbstractReflectionContext abstractReflectionContext, int n, String string) {
        this.trace(new StringBuffer("StateTop: evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX. ObjectId is ").append(string).toString());
        this.transToSpeechEvent(n);
        this.sendSelectEntryViaObjectId(string);
    }

    public void evtEV_LOCATION_INPUT_CANCEL_INPUT(AbstractReflectionContext abstractReflectionContext, int n) {
        SpellerContext.setActiveExtInterfaceField(0);
    }

    public void evtEV_LOCATION_INPUT_SELECT_NOTHING(AbstractReflectionContext abstractReflectionContext, int n) {
        this.setInputActive = false;
        int n2 = this.getStripTypeForField(n);
        new CmdStripLocation(this, this.target.getSpellerContext().getExtInterfaceLocation(), n2).execute();
    }

    public void evtEV_LOCATION_INPUT_SET_CURRENT_LOCATION(AbstractReflectionContext abstractReflectionContext, Object object) {
        NavLocation navLocation;
        if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null) {
            ASLNavigationTruffelFactory.getNavigationTruffelApi().resetSHIELDHousenumber();
        }
        if ((navLocation = (NavLocation)object) == null || navLocation.getCountry() == null || navLocation.getCountry().length() == 0 || navLocation.getCountryAbbreviation() == null || navLocation.getCountryAbbreviation().length() == 0) {
            this.overrideLocation(navLocation, "ExtInterface CurrentLocationCall is null. Overriding!");
        } else {
            new CmdSetCurrentLD(this, navLocation).execute();
        }
    }

    public void evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX(AbstractReflectionContext abstractReflectionContext, int n, int n2) {
        this.trace(new StringBuffer("StateTop: evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX. Id is ").append(n2).toString());
        this.transToSpeechEvent(n);
        this.sendSelectEntryViaIndexEvent(n2);
    }

    private int getStripTypeForField(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                if (this.target.getSpellerContext().getLocation().getCountryAbbreviation() != null && this.target.getSpellerContext().getLocation().countryAbbreviation.equals("USA")) {
                    n2 = 16;
                    break;
                }
                n2 = 1;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 5: 
            case 136: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 8;
                break;
            }
            case 127: {
                n2 = 5;
                break;
            }
            case 138: {
                n2 = 15;
                break;
            }
            case 152: {
                n2 = 152;
                break;
            }
            case 147: {
                n2 = 25;
                break;
            }
            case 144: {
                n2 = 21;
                break;
            }
            default: {
                this.trace(new StringBuffer("StateTop: Index is not used: ").append(n).toString());
            }
        }
        return n2;
    }

    private void transToSpeechEvent(int n) {
        if (n != SpellerContext.getActiveExtInterfaceField()) {
            SpellerContext.setActiveExtInterfaceField(n);
            switch (n) {
                case 1: {
                    this.trans(((XSpellerTarget)this.myTarget).stateCountry);
                    break;
                }
                case 138: {
                    this.trans(((XSpellerTarget)this.myTarget).stateState);
                    break;
                }
                case 2: {
                    this.trans(((XSpellerTarget)this.myTarget).stateCity);
                    break;
                }
                case 6: {
                    if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                        this.trans(((XSpellerTarget)this.myTarget).statePlace);
                        break;
                    }
                    this.trans(((XSpellerTarget)this.myTarget).stateZip);
                    break;
                }
                case 3: {
                    this.trans(((XSpellerTarget)this.myTarget).stateStreetWithBasenames);
                    break;
                }
                case 127: {
                    this.trans(((XSpellerTarget)this.myTarget).stateStreetDisambiguation);
                    break;
                }
                case 4: {
                    this.trans(((XSpellerTarget)this.myTarget).stateCrossing);
                    break;
                }
                case 5: {
                    this.trans(((XSpellerTarget)this.myTarget).statePointLocationHousenumber);
                    break;
                }
                case 136: {
                    this.trans(((XSpellerTarget)this.myTarget).stateHousenumber);
                    break;
                }
                case 152: {
                    this.trans(((XSpellerTarget)this.myTarget).stateWard);
                    break;
                }
                case 147: {
                    this.trans(((XSpellerTarget)this.myTarget).statePlace);
                    break;
                }
                case 144: {
                    this.trans(((XSpellerTarget)this.myTarget).stateChome);
                    break;
                }
                default: {
                    this.error(new StringBuffer("No state trans could be applied. Requested state to trans to: ").append(n).toString());
                    break;
                }
            }
        } else {
            this.trace(new StringBuffer().append("Trans to field :").append(n).append("is not necessary, already in correct field").toString());
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INIT_LOCATION(AbstractReflectionContext abstractReflectionContext) {
        SpellerContext.setActiveExtInterfaceField(0);
        if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null) {
            ASLNavigationTruffelFactory.getNavigationTruffelApi().resetSHIELDHousenumber();
        }
        XSpellerTarget.extInputHapticTakesOver();
        this.clearDSIStates();
        if (SpellerContext.cancelFlag) {
            this.trace(new StringBuffer("INIT location and cancel flag is true -> calling restoring location").append(SpellerContext.originalLocation).toString());
            SpellerContext.cancelFlag = false;
            ModelUpdater.updateLocationResolved(false);
            NavLocation navLocation = SpellerContext.originalLocation;
            if (navLocation.getCountry() == null || navLocation.getCountryAbbreviation().equals("USA") && ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation).getState().equals("")) {
                this.overrideLocation(navLocation, "location has no country! -> use ccp & strip all but country");
                return;
            }
            new CmdSetCurrentLD(this, navLocation).execute();
        } else {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
            NavLocation navLocation = this.target.getSpellerContext().getLocation();
            if (navLocation == null) {
                this.overrideLocation(navLocation, "location was null! -> use ccp & strip all but country");
                return;
            }
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            if (iLocationWrapper.getCountry() == null || iLocationWrapper.getCountry().length() == 0) {
                this.overrideLocation(navLocation, "location has no country! -> use ccp & strip all but country");
                return;
            }
            if (navLocation != null && !iLocationWrapper.isNavigable()) {
                this.stripNonNavigableLocation(navLocation, "location is not navigable! -> use ccp and strip all but country");
                return;
            }
            ModelUpdater.updateLocationResolved(false);
            new CmdSetCurrentLD(this, navLocation).execute();
        }
    }

    private void setLastInputMode(int n) {
        switch (n) {
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1024454656, 0);
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setLastModeDestinationInput(0);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1024454656, 1);
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setLastModeDestinationInput(1);
                break;
            }
        }
    }

    private void stripNonNavigableLocation(NavLocation navLocation, String string) {
        this.trace(string);
        ModelUpdater.updateLocationResolved(false);
        new CmdStripLocation(this, navLocation, 16).execute();
    }

    private void overrideLocation(NavLocation navLocation, String string) {
        this.trace(string);
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
        if (navLocation2 == null || navLocation2.getLatitude() == 0 && navLocation2.getLongitude() == 0) {
            this.trace("ccp is null or invalid (0,0) -> using default Location");
            navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
            this.trace(navLocation.toString());
            ModelUpdater.updateLocationResolved(false);
            new CmdGetLocationDescriptionTransform(this, navLocation).execute();
        } else {
            this.trace("ccp is valid -> setting initLocation = ccpLocation");
            navLocation = navLocation2;
            this.trace(navLocation.toString());
            ModelUpdater.updateLocationResolved(false);
            new CmdStripLocation(this, navLocation, IS_HIGH_JP ? 15 : 6).execute();
        }
    }

    private void sendSetInputEvent(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setString(0, string);
        eventGeneric.setReceiverEventId(IEvents.EV_SET_INPUT);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void sendSelectEntryViaIndexEvent(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(IEvents.EV_SELECT_VIA_INDEX);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void sendSelectEntryViaObjectId(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setString(0, string);
        eventGeneric.setReceiverEventId(IEvents.EV_SELECT_VIA_ID);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_DELETE_FIELD(AbstractReflectionContext abstractReflectionContext, int n) {
        XSpellerTarget.extInputHapticTakesOver();
        int n2 = 0;
        this.trace(new StringBuffer("StateTop: DELETE FIELD is being called with index: ").append(n).toString());
        switch (n) {
            case 0: {
                n2 = 2;
                break;
            }
            case 1: {
                if (this.target.getSpellerContext().getLocation().getCountryAbbreviation() != null && this.target.getSpellerContext().getLocation().getCountryAbbreviation().equals("USA")) {
                    n2 = 16;
                    break;
                }
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            case 5: {
                n2 = 8;
                break;
            }
            case 6: 
            case 7: {
                n2 = 15;
                break;
            }
        }
        new CmdStripLocation(this, this.target.getSpellerContext().getLocation(), n2).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_SET_LOCATION_INPUT_PATH(ISpellerContext iSpellerContext, int n) {
        this.trace("Entering evtASL_NAVIGATION_LOCATIONINPUT_SET_LOCATION_INPUT_PATH, clearing DSI states");
        this.target.countryField.clearDSIState();
        this.target.provinceField.clearDSIState();
        this.target.stateField.clearDSIState();
        this.target.cityField.clearDSIState();
        this.target.postalcodeField.clearDSIState();
        this.target.streetField.clearDSIState();
        this.target.streetWithBasenamesField.clearDSIState();
        this.target.streetDisambiguationField.clearDSIState();
        this.target.housenumberField.clearDSIState();
        this.target.crossingField.clearDSIState();
        if (this.target.getSpellerContext().getActiveField() != null) {
            this.target.getSpellerContext().getActiveField().clearDSIState();
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_SET_HWR_SPELLER_MODE_ENABLED(AbstractReflectionContext abstractReflectionContext, boolean bl) {
        this.trace("Entering evtASL_NAVIGATION_LOCATION_INPUT_SET_HWR_SPELLER_MODE_ENABLED(boolean) ");
        if (bl) {
            new CmdSetNVCRange(this, 2).execute();
        } else {
            new CmdSetNVCRange(this, 1).execute();
        }
        SpellerContext.hwrEnabled = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, bl);
        this.trace(new StringBuffer("HWR is ").append(SpellerContext.hwrEnabled ? "true" : "false").toString());
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INIT_FIELD(AbstractReflectionContext abstractReflectionContext, int n, boolean bl) {
        XSpellerTarget.extInputHapticTakesOver();
        StateZipCode.restore = false;
        switch (n) {
            case 0: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_TYPE_C0_COUNTRY");
                this.trans(((XSpellerTarget)this.myTarget).stateCountry);
                break;
            }
            case 1: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C1_CITY");
                this.trans(((XSpellerTarget)this.myTarget).stateCity);
                break;
            }
            case 2: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C2_ZIP");
                if (bl) {
                    StateZipCode.restore = true;
                }
                if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                    this.trans(((XSpellerTarget)this.myTarget).statePlace);
                    break;
                }
                this.trans(((XSpellerTarget)this.myTarget).stateZip);
                break;
            }
            case 3: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_TYPE_C3_STREET");
                this.trans(((XSpellerTarget)this.myTarget).stateStreet);
                break;
            }
            case 4: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C4_HNO_ALTERNATIVE");
                if (SpellerContext.isPointLocation) {
                    this.trans(((XSpellerTarget)this.myTarget).statePointLocationHousenumber);
                    break;
                }
                this.trans(((XSpellerTarget)this.myTarget).stateHousenumber);
                break;
            }
            case 5: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C5_HNO_MATCH_OR_ALTERNATIVE");
                if (SpellerContext.isPointLocation) {
                    this.trans(((XSpellerTarget)this.myTarget).statePointLocationHousenumber);
                    break;
                }
                this.trans(((XSpellerTarget)this.myTarget).stateHousenumber);
                break;
            }
            case 6: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C6_CROSS");
                this.trans(((XSpellerTarget)this.myTarget).stateCrossing);
                break;
            }
            case 7: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C7_STREET_DISAMBIGUATION");
                this.trans(((XSpellerTarget)this.myTarget).stateStreetDisambiguation);
                break;
            }
            case 8: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C8_PROVINCE");
                this.trans(((XSpellerTarget)this.myTarget).stateProvince);
                break;
            }
            case 9: {
                if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                    this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C9_STATE but will start StateWard");
                    this.trans(((XSpellerTarget)this.myTarget).stateWard);
                    break;
                }
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C9_STATE");
                this.trans(((XSpellerTarget)this.myTarget).stateState);
                break;
            }
            case 10: {
                this.printOutInitEvent("StateTop: Got event: INITFIELD_FIELD_C10_STREET_WITH_BASENAMES");
                this.trans(((XSpellerTarget)this.myTarget).stateStreetWithBasenames);
                break;
            }
            case 11: {
                this.printOutInitEvent("StateTop: Got event: INIT_FIELD__FIELD__C11_PHONENUMBER");
                if (bl) {
                    StatePhoneNumber.restore = true;
                }
                this.trans(((XSpellerTarget)this.myTarget).statePhoneNumber);
                break;
            }
            case 12: {
                this.printOutInitEvent("StateTop: Got event: INIT_FIELD__FIELD__C12_MAPCODE");
                if (bl) {
                    StateMapCode.restore = true;
                }
                this.trans(((XSpellerTarget)this.myTarget).stateMapCode);
                break;
            }
            case 112: {
                this.printOutInitEvent("StateTop: Got event: INIT_FIELD_STREET1ST_CITY");
                this.trans(((XSpellerTarget)this.myTarget).stateStreet1stCity);
                break;
            }
            case 111: {
                this.printOutInitEvent("StateTop: Got event: INIT_FIELD_STREET1ST_STREET");
                this.trans(((XSpellerTarget)this.myTarget).stateStreet1stStreetWithBasenames);
                break;
            }
            case 113: {
                this.printOutInitEvent("StateTop: Got event: INIT_FIELD_STREET1ST_ZIP");
                this.trans(((XSpellerTarget)this.myTarget).stateStreet1stZipCode);
                break;
            }
            default: {
                this.printOutInitEvent("UNKOWN INIT EVENT");
            }
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_CANCEL_FIELD(AbstractReflectionContext abstractReflectionContext) {
        this.trace("CANCEL_FIELD received: Setting cancelFlag to true");
        SpellerContext.cancelFlag = true;
        this.target.freezeAllLists();
        ModelUpdater.updateLocationInputActionResult(true);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_START_ROUTE_CALC_FROM_DETAILVIEW(AbstractReflectionContext abstractReflectionContext, int n) {
        if (n == 1) {
            this.trace(new StringBuffer("StateTop: START_ROUTE_CALC_FROM_DETAILVIEW called with SHIELD Parameter. Saving history for SHIELD").toString());
            this.setSearchResultInSHIELDHistory(this.target.getSpellerContext());
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_MATCH_LIST_LIMIT(AbstractReflectionContext abstractReflectionContext, int n) {
        this.trace(new StringBuffer("StateTop: MatchListLimit is being set to: ").append(n).toString());
        SpellerContext.listSizeLimit = n;
    }

    private void printOutInitEvent(String string) {
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append("StateTop: Got Init event for field: ").append(string).log();
        }
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        if (cmdSetCurrentLD.liResult_ReturnCode != 0L) {
            this.warn(new StringBuffer().append("handleCommandCmdSetCurrentLD resultCode not OK: ").append(cmdSetCurrentLD.liResult_ReturnCode).append("").toString());
            return;
        }
        NavLocation navLocation = cmdSetCurrentLD.liCurrentState_liCurrentLD;
        if (navLocation == null) {
            navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
        }
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" SPELLER> handleCommandCmdSetCurrentLD location: "), navLocation).log();
        }
        ModelUpdater.setHousenumberSpellerToUse(cmdSetCurrentLD.liCurrentState_usefulRefinementCriteria, this.target);
        this.setInputActive = false;
        SpellerContext.setExtInterfaceLocation(navLocation);
        if (cmdSetCurrentLD.liCurrentState_availableSelectionCriteria != null) {
            XSpellerTarget.changeExtLocation(navLocation, cmdSetCurrentLD.liCurrentState_availableSelectionCriteria, this.setInputActive);
        } else {
            this.warn("handleCommandCmdSetCurrentLD: availableSelectionCriteria is null!");
        }
        this.updateCountryIcon(navLocation);
        MatchTextSubjectUtil matchTextSubjectUtil = new MatchTextSubjectUtil();
        matchTextSubjectUtil.updateMap(this.target, navLocation);
        ModelUpdater.updateLocationResolved(true);
        ModelUpdater.updateNextAvailableCriterions(cmdSetCurrentLD.liCurrentState_availableSelectionCriteria, navLocation, this.target);
        ModelUpdater.updateLocation(navLocation, this.target);
        this.printAvailableCriterions(cmdSetCurrentLD.liCurrentState_availableSelectionCriteria);
        this.target.getSpellerContext().setLocation(navLocation);
        if (this.target.getSpellerContext().getActiveField() != null) {
            ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        }
        this.indentifyAddressFormat(navLocation);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
        ModelUpdater.updateLocationInputActionResult(true);
        if (this.stripEventReceived) {
            if (this.target.getLogger().isTraceEnabled()) {
                this.target.getLogger().makeTrace().append(" received strip event - sending action result ").log();
            }
            this.stripEventReceived = false;
            ModelUpdater.updateLocationInputInputFieldActionResult(true);
        }
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append("Storing speller (using DSI)...");
        }
        this.discardData = cmdLiGetState.liGetStateResult_spellerState;
    }

    private void updateCountryIcon(NavLocation navLocation) {
        Integer n = new Integer(-2000);
        GenericASLList genericASLList = ListManager.getGenericASLList(2830);
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)genericASLList.getRowItem(0);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append(" ICONINDEX for NDF country icon is: ").append(iLocationWrapper.getCountryIconIndex()).log();
        }
        navigationLocationInputLocationCollector.navigation_locationinput_location_country_icon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForCountryIcon(iLocationWrapper.getCountryIconIndex(), 1, this, n);
        genericASLList.updateListItem(0, navigationLocationInputLocationCollector);
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        NavLocation navLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" SPELLER>   transformedLocation: "), navLocation).log();
        }
        new CmdStripLocation(this, navLocation, IS_HIGH_JP ? 15 : 6).execute();
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
        NavLocation navLocation = cmdStripLocation.liStripLocationResult_location;
        ModelUpdater.updateLocationResolved(false);
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" SPELLER>   stripped location: "), navLocation).log();
        }
        new CmdSetCurrentLD(this, navLocation).execute();
    }

    @Override
    public void handleCommandCmdHistoryAddLocation(CmdHistoryAddLocation cmdHistoryAddLocation) {
        if (cmdHistoryAddLocation.liResult_ReturnCode != 0L) {
            this.error(" StateTop -> handleCommandCmdHistoryAddLocation cmd.liResult ERROR");
        } else {
            this.trace(" StateTop -> handleCommandCmdHistoryAddLocation: Added location successfully");
        }
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append("RestoreState ").append(cmdRestoreState).log();
        }
        if (0L != cmdRestoreState.liResult_ReturnCode) {
            this.target.getLogger().makeError().append("restoring speller failed, returnCode=").append(cmdRestoreState.liResult_ReturnCode).log();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext(new StringBuffer("Starting speller failed: ").append(cmdRestoreState.liResult_ReturnCode).toString());
            return;
        }
        ModelUpdater.updateNextAvailableCriterions(cmdRestoreState.liCurrentState_availableSelectionCriteria, cmdRestoreState.liCurrentState_liCurrentLD, this.target);
        ModelUpdater.updateLocation(cmdRestoreState.liCurrentState_liCurrentLD, this.target);
        ModelUpdater.updateLocationResolved(true);
        this.printAvailableCriterions(cmdRestoreState.liCurrentState_availableSelectionCriteria);
        this.target.getSpellerContext().setLocation(cmdRestoreState.liCurrentState_liCurrentLD);
        if (this.target.getSpellerContext().getActiveField() != null) {
            ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        }
        ModelUpdater.updateLocationInputActionResult(true);
    }

    private void printAvailableCriterions(int[] nArray) {
        if (this.target.getLogger().isTraceEnabled() && nArray != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendCriteria(this.target.getLogger().makeTrace().append("SPELLER> available criteria: "), nArray).log();
        }
    }

    private void indentifyAddressFormat(NavLocation navLocation) {
        GenericASLList genericASLList = ListManager.getGenericASLList(2830);
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)genericASLList.getRowItem(0);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        if (iLocationWrapper.isCityCenter()) {
            navigationLocationInputLocationCollector.navigation_locationinput_location_address_format = 1;
            this.logAdressFormat("CityCenter ", navLocation);
        } else if (!iLocationWrapper.isCityCenter() && !iLocationWrapper.getCrossing().equals("")) {
            navigationLocationInputLocationCollector.navigation_locationinput_location_address_format = 2;
            this.logAdressFormat("intersection1st ", navLocation);
        } else if (iLocationWrapper.getLocationDSIType() == 0) {
            navigationLocationInputLocationCollector.navigation_locationinput_location_address_format = 0;
            this.logAdressFormat("default ", navLocation);
        } else {
            navigationLocationInputLocationCollector.navigation_locationinput_location_address_format = 0;
            this.logAdressFormat("Unkown ", navLocation);
        }
        genericASLList.updateListItem(0, navigationLocationInputLocationCollector);
    }

    private void logAdressFormat(String string, NavLocation navLocation) {
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" SPELLER> location is: ").append(string), navLocation).log();
        }
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (this.target.getLogger().isTraceEnabled()) {
            this.trace("LocationInput-StateTop: handleIconCacheUpdate");
        }
        GenericASLList genericASLList = ListManager.getGenericASLList(2830);
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)genericASLList.getRowItem(0);
        navigationLocationInputLocationCollector.navigation_locationinput_location_country_icon = resourceLocator;
        genericASLList.updateListItem(0, navigationLocationInputLocationCollector);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    private void clearDSIStates() {
        if (this.target.getLogger().isTraceEnabled()) {
            this.trace("LocationInput-StateTop: clearDSIStates called, clearing all dsistates!");
        }
        this.target.countryField.clearDSIState();
        this.target.provinceField.clearDSIState();
        this.target.stateField.clearDSIState();
        this.target.cityField.clearDSIState();
        this.target.postalcodeField.clearDSIState();
        this.target.streetField.clearDSIState();
        this.target.streetWithBasenamesField.clearDSIState();
        this.target.streetDisambiguationField.clearDSIState();
        this.target.housenumberField.clearDSIState();
        this.target.crossingField.clearDSIState();
        this.target.chomeField.clearDSIState();
        this.target.wardField.clearDSIState();
        this.target.placeField.clearDSIState();
        this.target.phoneNumberField.clearDSIState();
        this.target.mapcodeField.clearDSIState();
        if (this.target.getSpellerContext().getActiveField() != null) {
            this.target.getSpellerContext().getActiveField().clearDSIState();
        }
    }

    private void setSearchResultInSHIELDHistory(SpellerContext spellerContext) {
        Object object;
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
        if (this.dsiSearch == null) {
            object = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiSearch = (DSISearch)object.getService(spellerContext.getTarget(), class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = StateTop.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch);
        }
        if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null && ASLNavigationTruffelFactory.getNavigationTruffelApi().addNavLocationToHistory()) {
            object = ASLNavigationTruffelFactory.getNavigationTruffelApi().getSearchResult();
            if (bl) {
                NavLocation navLocation = ASLNavigationTruffelFactory.getNavigationTruffelApi().getNavLocation();
                if (navLocation == null) {
                    if (this.target.getLogger().isTraceEnabled()) {
                        this.trace("LocationInput-StateTop: HIGH_Target - Location is null, probably because it already has been added.");
                    }
                } else {
                    if (this.target.getLogger().isTraceEnabled()) {
                        this.trace(new StringBuffer().append("LocationInput-StateTop: HIGH_Target - handle history via application data. Location: ").append(navLocation).toString());
                    }
                    navLocation.housenumber = ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber();
                    new CmdNavLocationToStream(this, 0, navLocation).execute();
                }
            } else {
                if (object != null && ((SearchResult)object).tokens != null) {
                    block3: for (int i2 = 0; i2 < ((SearchResult)object).tokens.length; ++i2) {
                        switch (((SearchResult)object).tokens[i2].wordType) {
                            case 7: {
                                ((SearchResult)object).tokens[i2].token = ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber();
                                ((SearchResult)object).tokens[i2].highlights = new Highlight[0];
                                continue block3;
                            }
                        }
                    }
                }
                if (object != null && ((SearchResult)object).entryType != 16) {
                    this.dsiSearch.addToHistory((SearchResult)object);
                }
            }
        }
    }

    @Override
    public void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
        if (cmdNavLocationToStream.isResultSuccess()) {
            byte[] byArray = cmdNavLocationToStream.getStreamOfLocation();
            NavLocation navLocation = cmdNavLocationToStream.getLocationToStream();
            if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null) {
                SearchResult searchResult = ASLNavigationTruffelFactory.getNavigationTruffelApi().getSearchResult();
                if (searchResult != null && searchResult.tokens != null) {
                    ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                    if (iLocationWrapper.isTownorder9()) {
                        this.trace("STATETOP -> location.isTownorder9 == true");
                        block9: for (int i2 = 0; i2 < searchResult.tokens.length; ++i2) {
                            switch (searchResult.tokens[i2].wordType) {
                                case 2: {
                                    searchResult.tokens[i2].token = iLocationWrapper.getUnformattedTownName();
                                    searchResult.tokens[i2].highlights = new Highlight[0];
                                    continue block9;
                                }
                                case 1: {
                                    searchResult.tokens[i2].token = iLocationWrapper.getCityRefinement();
                                    searchResult.tokens[i2].highlights = new Highlight[0];
                                    continue block9;
                                }
                                case 7: {
                                    searchResult.tokens[i2].token = ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber();
                                    searchResult.tokens[i2].highlights = new Highlight[0];
                                    continue block9;
                                }
                            }
                        }
                    } else {
                        this.trace("STATETOP -> location.isTownorder9 == false");
                        block10: for (int i3 = 0; i3 < searchResult.tokens.length; ++i3) {
                            switch (searchResult.tokens[i3].wordType) {
                                case 1: {
                                    searchResult.tokens[i3].token = iLocationWrapper.getUnformattedTownName();
                                    searchResult.tokens[i3].highlights = new Highlight[0];
                                    continue block10;
                                }
                                case 7: {
                                    searchResult.tokens[i3].token = ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber();
                                    searchResult.tokens[i3].highlights = new Highlight[0];
                                    continue block10;
                                }
                            }
                        }
                    }
                    searchResult.applicationData = byArray;
                    this.trace(new StringBuffer().append(" STATETOP -> History searchResult to set in history: ").append(searchResult).toString());
                    this.dsiSearch.addToHistory(searchResult);
                }
            } else {
                this.error("LocationInput-StateTop: truffelAPI cannot be accessed!");
            }
        } else {
            this.error("LocationInput-StateTop: CmdNavLocationToStream is unsuccessful");
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


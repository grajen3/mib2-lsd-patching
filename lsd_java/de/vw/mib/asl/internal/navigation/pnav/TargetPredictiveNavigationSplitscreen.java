/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.pnav;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.guidance.ASLPnavLikelyDestination;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavLikelyDestinationListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class TargetPredictiveNavigationSplitscreen
extends AbstractResettableAslTarget
implements CacheClient,
TargetForFullFactoryReset,
TargetForResetNavigation,
DSIServiceStateListener,
ReloadPersistedDataListener {
    protected DSINavigation dsiNavigationService;
    private DSIListener dsiNavigationListener;
    protected DSIPredictiveNavigation dsiPredictiveNavigationService;
    protected DSIListener dsiPredictiveNavigationListener;
    DSIServiceLocator locator = ServiceManager.dsiServiceLocator;
    private boolean isServiceStateListenerAdded = false;
    public static final int EV_NAVI_GUIDANCE_SET_PNAV_STATUS_EXTERNAL;
    public static int EV_NAVI_GUIDANCE_SET_PNAV_STATUS_EXTERNAL__P0_INT;
    private static final int[] ASL_SERVICES;
    private static final int[] OBSERVER_DSINAV;
    private static final int[] OBSERVER_DSIPNAV;
    private static final int[] OBSERVERS;
    static final int MAX_LIST_SIZE;
    public static final int EV_INDEX_START_PNAV_GUIDANCE;
    private NavigationPnavLikelyDestinationListCollector[] likelyDestCollector = new NavigationPnavLikelyDestinationListCollector[3];
    int opMode;
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private boolean isFirstUpdateOnPnavOperationModeAfterStartup = true;
    private int externalPnavStatus;
    private int internalPnavStatus;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener;

    public TargetPredictiveNavigationSplitscreen(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    private void traceList(Object[] objectArray, String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass().getName());
            logMessage.append(string);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                logMessage.append(objectArray[i2]);
            }
            logMessage.log();
        }
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        if (string.intern() == (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName().intern()) {
            this.initDsiPredictiveNavigation();
        } else if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.initDsiNavigation();
        }
        if (this.dsiNavigationService != null && this.dsiPredictiveNavigationService != null) {
            this.isFirstStartupDone = true;
        }
    }

    public void initDsiNavigation() {
        this.locator = ServiceManager.dsiServiceLocator;
        this.dsiNavigationService = (DSINavigation)this.locator.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.locator.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigationService.setNotification(OBSERVER_DSINAV, this.dsiNavigationListener);
    }

    public void initDsiPredictiveNavigation() {
        this.locator = ServiceManager.dsiServiceLocator;
        this.dsiPredictiveNavigationService = (DSIPredictiveNavigation)this.locator.getService(null, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation);
        this.dsiPredictiveNavigationListener = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener);
        this.locator.addResponseListener(null, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener, this.dsiPredictiveNavigationListener);
        this.dsiPredictiveNavigationService.setNotification(OBSERVER_DSIPNAV, this.dsiPredictiveNavigationListener);
        this.dsiPredictiveNavigationService.setMaxPredictions(3);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPredictiveNavigationSplitscreen tries to unregister from ").append(string).log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                if (this.isTraceEnabled()) {
                    this.trace().append("DSIProxy was null!");
                }
                return;
            }
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[113]) {
                this.unregisterDsiPredictiveNavigation(string, dSIProxy);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
                this.unregisterDsiNavigation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void unregisterDsiPredictiveNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiPredictiveNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener, this.dsiPredictiveNavigationListener);
            this.dsiPredictiveNavigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPredictiveNavigationSplitscreen unregistered from ").append(string).log();
        }
    }

    public void initDSI() {
        if (!this.isServiceStateListenerAdded) {
            this.isServiceStateListenerAdded = true;
            ServiceManager.dsiServiceLocator.addServiceStateListener(this);
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.trace("NAVI_TARGET_PREPARE_ON");
                this.registerServices(ASL_SERVICES, false);
                break;
            }
            case 106: {
                this.traceState("POWER_ON");
                this.initDSI();
                this.addObservers(OBSERVERS);
                if (this.fullFactoryResetParticipant == null) {
                    this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                }
                if (this.navigationResetParticipant != null) break;
                this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                break;
            }
            case 107: {
                this.traceState("POWER_OFF");
                if (this.fullFactoryResetParticipant != null) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                    this.fullFactoryResetParticipant = null;
                }
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 1073742393: {
                this.traceState("SET_CURRENT_CONTENT_G");
                if (eventGeneric.getInt(0) != 7) break;
                this.updateModel();
                break;
            }
            case 1074841905: {
                if (this.dsiPredictiveNavigationService != null) {
                    this.internalPnavStatus = eventGeneric.getInt(0);
                    this.setCorrectPnavStatus(this.internalPnavStatus);
                    break;
                }
                this.traceState("SET_PNAV_STATUS, dsiPredictiveNavigationService not available");
                break;
            }
            case 100100: {
                this.externalPnavStatus = eventGeneric.getInt(EV_NAVI_GUIDANCE_SET_PNAV_STATUS_EXTERNAL__P0_INT);
                this.setCorrectPnavStatus(this.externalPnavStatus);
                this.traceState(new StringBuffer().append("pnavInSplitscreenVisible: ").append(this.externalPnavStatus).toString());
                break;
            }
            case 1074841904: {
                boolean bl = eventGeneric.getBoolean(0);
                this.changePnavEnabled(bl);
                break;
            }
            case 1074841906: {
                break;
            }
            case 1074841907: {
                int n = eventGeneric.getInt(0);
                NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector = this.likelyDestCollector[n];
                this.updateSelectedDestination(navigationPnavLikelyDestinationListCollector);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 1917522944, 159842560);
                eventGeneric2.setObject(0, navigationPnavLikelyDestinationListCollector.getSegmentId());
                try {
                    this.send(eventGeneric2);
                }
                catch (GenericEventException genericEventException) {
                    this.getTextLogger().error(2).attachThrowable(genericEventException).log();
                }
                eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 1682641920, 159842560);
                eventGeneric2.setObject(0, navigationPnavLikelyDestinationListCollector);
                try {
                    this.send(eventGeneric2);
                }
                catch (GenericEventException genericEventException) {
                    this.getTextLogger().error(2).attachThrowable(genericEventException).log();
                }
                break;
            }
            case 1074841911: {
                this.handleFullFacotryReset();
                break;
            }
        }
    }

    public void changePnavEnabled(boolean bl) {
        if (this.dsiPredictiveNavigationService != null) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1995444224, bl);
            PersistedGuidanceSetup.getInstance().setPnavEnabled(bl);
            this.updateIsPNavEnabled(bl);
            if (bl) {
                if (this.opMode == 0) {
                    this.setOperationMode(1);
                    this.internalPnavStatus = 1;
                }
            } else {
                this.setOperationMode(0);
                this.internalPnavStatus = 0;
            }
        } else {
            this.traceState("SET_PNAV_ENABLED, dsiPredictiveNavigationService not available");
        }
    }

    private void setOperationMode(int n) {
        this.dsiPredictiveNavigationService.setOperationMode(n);
    }

    private void updateModel() {
        this.traceState("updateModel()");
        ListManager.getGenericASLList(2028998656).updateList(this.likelyDestCollector);
        if (this.likelyDestCollector != null) {
            this.traceList(this.likelyDestCollector, " updateModel(): likely destinations  list");
        }
        int n = this.getCombinedCalculationState();
        ServiceManager.aslPropertyManager.valueChangedInteger(2096107520, n);
        if (this.likelyDestCollector != null) {
            this.traceList(this.likelyDestCollector, " updateModel(): updating calulation state");
        }
        this.updateCombinedCalculationState(n);
        this.updateLikelyDestinations(this.likelyDestCollector);
    }

    private void setCorrectPnavStatus(int n) {
        int n2 = 0;
        n2 = this.internalPnavStatus == 2 || this.externalPnavStatus == 1 ? 2 : (n == 0 ? 0 : 1);
        this.setOperationMode(n2);
    }

    private int getCombinedCalculationState() {
        if (this.likelyDestCollector != null && this.likelyDestCollector.length > 0) {
            int n;
            for (n = 0; n < this.likelyDestCollector.length; ++n) {
                if (this.likelyDestCollector[n].getCalculationState() != 1) continue;
                return 1;
            }
            for (n = 0; n < this.likelyDestCollector.length; ++n) {
                if (this.likelyDestCollector[n].getCalculationState() != 3) continue;
                return 3;
            }
            for (n = 0; n < this.likelyDestCollector.length; ++n) {
                if (this.likelyDestCollector[n].getCalculationState() != 2) continue;
                return 2;
            }
        }
        return 0;
    }

    public void dsiPredictiveNavigationUpdateLikelyDestinations(LikelyDestination[] likelyDestinationArray, int n) {
        if (n == 1) {
            if (likelyDestinationArray != null) {
                this.likelyDestCollector = new NavigationPnavLikelyDestinationListCollector[likelyDestinationArray.length];
                for (int i2 = 0; i2 < likelyDestinationArray.length; ++i2) {
                    ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTargetIcon(likelyDestinationArray[i2].getRouteColorIconId(), 0, this, new Integer(i2));
                    this.likelyDestCollector[i2] = new NavigationPnavLikelyDestinationListCollector(likelyDestinationArray[i2], resourceLocator);
                }
                this.updateModel();
                if (likelyDestinationArray.length == 0) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(82841600);
                }
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(82841600);
            }
        }
    }

    public void dsiPredictiveNavigationUpdateOperationMode(int n, int n2) {
        this.traceState("TargetPredictiveNavigationSplitscreen: dsiPredictiveNavigationUpdateOperationMode()");
        if (n2 == 1) {
            if (this.isFirstUpdateOnPnavOperationModeAfterStartup) {
                int n3;
                this.traceState("TargetPredictiveNavigationSplitscreen: first DSINavigationPredictiveNavigation.updateOperationMode received.");
                this.isFirstUpdateOnPnavOperationModeAfterStartup = false;
                boolean bl = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isPnavEnabled();
                if (bl) {
                    n3 = 1;
                    this.traceState("TargetPredictiveNavigationSplitscreen: pnav mode from persistence is true = OPERATIONMODE_PASSIVE");
                } else {
                    n3 = 0;
                    this.traceState("TargetPredictiveNavigationSplitscreen: pnav mode from persistence is false = OPERATIONMODE_INACTIVE");
                }
                if (n3 != n) {
                    this.traceState("TargetPredictiveNavigationSplitscreen: current PNAV mode different from persisted one -> sending new PNAV mode to southside");
                    this.setOperationMode(n3);
                } else {
                    this.changePnavMode(n);
                }
            } else {
                this.changePnavMode(n);
            }
        }
    }

    private void changePnavMode(int n) {
        this.traceState(new StringBuffer().append("TargetPredictiveNavigationSplitscreen: setting PNAV mode in HMI to ").append(n).toString());
        int n2 = 0;
        boolean bl = false;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 2;
                bl = true;
                break;
            }
            case 1: {
                n2 = 1;
                bl = true;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        this.opMode = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(1978667008, n2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1995444224, bl);
        PersistedGuidanceSetup.getInstance().setPnavEnabled(bl);
        this.updatePNavStatus(n2);
        this.updateIsPNavEnabled(bl);
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (this.isTraceEnabled()) {
            this.trace("TargetPredictiveNavigationSplitscreen: handleIconCacheUpdate");
        }
        int n = (Integer)object;
        NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector = (NavigationPnavLikelyDestinationListCollector)ListManager.getGenericASLList(2028998656).getRowItemCacheOnly(n);
        navigationPnavLikelyDestinationListCollector.setRouteColorIconIdResourceLocator(resourceLocator);
        ListManager.getGenericASLList(2028998656).updateListItem(n, navigationPnavLikelyDestinationListCollector);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    private void clearPredictionsCache() {
        if (this.dsiPredictiveNavigationService != null) {
            this.setOperationMode(1);
            this.dsiPredictiveNavigationService.clearCache();
            this.likelyDestCollector = null;
            this.updateModel();
        } else {
            this.traceState("RESET, dsiPredictiveNavigationService not available");
        }
    }

    @Override
    public void handleFullFacotryReset() {
        this.clearPredictionsCache();
        this.fullFactoryResetParticipant.notifyResetDone();
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.clearPredictionsCache();
        this.navigationResetParticipant.notifyResetDone();
    }

    private void updateLikelyDestinations(NavigationPnavLikelyDestinationListCollector[] navigationPnavLikelyDestinationListCollectorArray) {
        ASLPnavLikelyDestination[] aSLPnavLikelyDestinationArray = new ASLPnavLikelyDestination[]{};
        if (navigationPnavLikelyDestinationListCollectorArray != null) {
            aSLPnavLikelyDestinationArray = new ASLPnavLikelyDestination[navigationPnavLikelyDestinationListCollectorArray.length];
            for (int i2 = 0; i2 < aSLPnavLikelyDestinationArray.length; ++i2) {
                aSLPnavLikelyDestinationArray[i2] = this.createASLLikelyDestination(navigationPnavLikelyDestinationListCollectorArray[i2]);
            }
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1096561920);
        eventGeneric.setObject(0, aSLPnavLikelyDestinationArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void updateSelectedDestination(NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector) {
        if (navigationPnavLikelyDestinationListCollector != null) {
            ASLPnavLikelyDestination aSLPnavLikelyDestination = this.createASLLikelyDestination(navigationPnavLikelyDestinationListCollector);
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1113339136);
            eventGeneric.setObject(0, aSLPnavLikelyDestination);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        }
    }

    private ASLPnavLikelyDestination createASLLikelyDestination(NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector) {
        ASLPnavLikelyDestination aSLPnavLikelyDestination = new ASLPnavLikelyDestination();
        aSLPnavLikelyDestination.setCalculationProgress(navigationPnavLikelyDestinationListCollector.getCalculationProgress());
        aSLPnavLikelyDestination.setCalculationState(navigationPnavLikelyDestinationListCollector.getCalculationState());
        aSLPnavLikelyDestination.setColorIcon(navigationPnavLikelyDestinationListCollector.getRouteColorIcon());
        aSLPnavLikelyDestination.setDtd(navigationPnavLikelyDestinationListCollector.getDistance());
        NavLocation navLocation = navigationPnavLikelyDestinationListCollector.getDestination();
        if (navLocation != null) {
            aSLPnavLikelyDestination.setCity(navLocation.getTown());
            aSLPnavLikelyDestination.setCityRefinement(navLocation.getTownRefinement());
            aSLPnavLikelyDestination.setCrossStreet(navLocation.getJunction());
            aSLPnavLikelyDestination.setHousenumber(navLocation.getHousenumber());
            aSLPnavLikelyDestination.setLatitude(navLocation.getLatitude());
            FixFormatterFieldData fixFormatterFieldData = new FixFormatterFieldDataImpl();
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            aSLPnavLikelyDestination.setLikelyDestAddressData(fixFormatterFieldData);
            aSLPnavLikelyDestination.setLikelyHood(navigationPnavLikelyDestinationListCollector.getLikelihood());
            aSLPnavLikelyDestination.setLongitude(navLocation.getLongitude());
            aSLPnavLikelyDestination.setStreet(navLocation.getStreet());
            aSLPnavLikelyDestination.setStreetRefinement(navLocation.getStreetRefinement());
        }
        aSLPnavLikelyDestination.setRouteColor(navigationPnavLikelyDestinationListCollector.getRouteColor());
        aSLPnavLikelyDestination.setRtt(navigationPnavLikelyDestinationListCollector.getRemainingTravelTime());
        aSLPnavLikelyDestination.setTimeDelay(navigationPnavLikelyDestinationListCollector.getTimeDelay());
        return aSLPnavLikelyDestination;
    }

    private void updateCombinedCalculationState(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1163670784);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void updateIsPNavEnabled(boolean bl) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1146893568);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void updatePNavStatus(int n) {
        ASLNavGuidanceDP.getInstance().setPnavStatus(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1130116352);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void reloadPersistedData() {
        this.changePnavEnabled(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isPnavEnabled());
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = TargetPredictiveNavigationSplitscreen.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.traceState("resetting values after DSI restart");
            }
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiPredictiveNavigation();
                this.initLocalVariablesPNav();
            }
        } else if (this.isTraceEnabled()) {
            this.traceState("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    public void initLocalVariablesPNav() {
        this.likelyDestCollector = null;
        this.opMode = 0;
        this.isFirstUpdateOnPnavOperationModeAfterStartup = true;
        this.updateModel();
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
        EV_NAVI_GUIDANCE_SET_PNAV_STATUS_EXTERNAL__P0_INT = 0;
        ASL_SERVICES = new int[]{1163670784, 1146893568, 1096561920, 1113339136, 1130116352};
        OBSERVER_DSINAV = new int[]{42};
        OBSERVER_DSIPNAV = new int[]{2, 1, 3};
        OBSERVERS = new int[]{956432448, 835260480, 818483264, 868814912, 852037696, 935923776};
    }
}


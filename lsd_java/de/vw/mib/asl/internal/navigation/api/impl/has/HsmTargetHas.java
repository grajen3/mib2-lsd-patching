/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.api.impl.has.HasServices;
import de.vw.mib.asl.internal.navigation.api.impl.has.Services;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateActive;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateCalculate;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateConfirmationPending;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateGuidance;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateNoGuidance;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateStopStartGuidance;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateStopStartGuidanceImportGpx;
import de.vw.mib.asl.internal.navigation.api.impl.has.StateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.GuidanceRemainingContainer;
import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;
import generated.de.vw.mib.has.contexts.navigation.NavigationProperties;
import generated.de.vw.mib.has.contexts.navigation.NavigationResults;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.util.RouteHelper;

public class HsmTargetHas
extends AbstractResettableAslHsmTarget {
    public final StateWork stateWork;
    public final StateActive stateActive;
    public final StateGuidance stateGuidance;
    public final StateCalculate stateCalculate;
    public final StateNoGuidance stateNoGuidance;
    public final StateStopStartGuidance stateStopStartGuidance;
    public final StateStopStartGuidanceImportGpx stateStopStartGuidanceImportGpx;
    public final StateConfirmationPending stateConfirmationPending;
    public static final int CALL_ID_NOT_SET;
    Services services;
    HasServices hasServices;
    ASLNavigationGuidanceAPI aslNavigationGuidanceAPI;
    NavigationProperties hasProperties;
    HASFactory factory;
    NavigationResults hasResults;
    int startGuidanceCallId;
    AddressContainer startGuidanceAddressContainer;
    int resolveAddressCallId;
    int importGPXCallid;
    int resolveLastDestId;
    GuidanceRemainingContainer guidanceRemaining;
    StartGuidanceResultContainer startGuidanceResult;
    AddressContainer currentVehiclePos;
    boolean alternativeRouteCalcEnabled;
    Route route;
    NavLocation importGpxResultLocation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    @Override
    public void trace(String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void traceState(AbstractHsmState abstractHsmState, String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    protected void initDSI() {
        if (this.services == null) {
            this.services = new Services(this);
        }
    }

    public HsmTargetHas(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateActive = new StateActive(this, this.hsm, "stateActive", this.stateWork);
        this.stateGuidance = new StateGuidance(this, this.hsm, "stateGuidance", this.stateActive);
        this.stateCalculate = new StateCalculate(this, this.hsm, "stateCalculate", this.stateActive);
        this.stateNoGuidance = new StateNoGuidance(this, this.hsm, "stateNoGuidance", this.stateWork);
        this.stateStopStartGuidance = new StateStopStartGuidance(this, this.hsm, "stateStopStartGuidance", this.stateWork);
        this.stateStopStartGuidanceImportGpx = new StateStopStartGuidanceImportGpx(this, this.hsm, "stateStopStartGuidanceImportGpx", this.stateWork);
        this.stateConfirmationPending = new StateConfirmationPending(this, this.hsm, "stateConfirmationPending", this.stateWork);
        this.aslNavigationGuidanceAPI = ASLNavigationGuidanceFactory.getNavigationGuidanceApi();
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    void initHAS() {
        this.hasServices = new HasServices();
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Navigation");
        hASContext.setServicesImpl(this.hasServices);
        this.initLocalVariables();
    }

    private void initLocalVariables() {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Navigation");
        this.hasResults = (NavigationResults)hASContext.getResultsImpl();
        this.hasProperties = (NavigationProperties)hASContext.getPropertiesImpl();
        this.factory = HAS.getInstance().getFactory();
        this.guidanceRemaining = (GuidanceRemainingContainer)this.factory.createContainer(25);
        this.startGuidanceResult = (StartGuidanceResultContainer)this.factory.createContainer(67);
        this.currentVehiclePos = (AddressContainer)HAS.getInstance().getFactory().createContainer(1);
        this.alternativeRouteCalcEnabled = false;
    }

    void disableAlternativeRouteCalculation() {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().setHmiAlternativeRouteCalculation(false);
    }

    void enableAlternativeRouteCalculation() {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().setHmiAlternativeRouteCalculation(true);
    }

    void setRouteToNavLocation(NavLocation navLocation) {
        this.route = new Route();
        RouteDestination routeDestination = new RouteDestination();
        routeDestination.setRouteLocation(navLocation);
        RouteHelper.addDestinationAtPosition(this.route, routeDestination, 0);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetHas.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            this.trace("resetting values after DSI restart");
            this.resetHsmToState(this.stateNoGuidance);
            this.initLocalVariables();
            this.services.initDsiNavigation();
        } else {
            this.trace("no reset necessary because restarted DSI(s) is/are not used in target");
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.startup.StartupGroupManager;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TargetResetManager
implements DSIServiceStateListener {
    private final ArrayList allDsis = new ArrayList();
    private final ArrayList registeredDsis = new ArrayList();
    private final HashMap resettedDsis = new HashMap();
    private final ArrayList dsisRequiringModelReset = new ArrayList();
    private final StartupGroupManager startupGroupManager;
    private Target[] targets = new Target[0];
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractor;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngine;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlocking;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSICombinedRouteList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchange;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;

    public TargetResetManager(StartupGroupManager startupGroupManager) {
        this.startupGroupManager = startupGroupManager;
        this.fillDsisRequiringModelReset();
        this.registerDsiStateListener();
    }

    private void fillDsisRequiringModelReset() {
        this.dsisRequiringModelReset.add((class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = TargetResetManager.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName());
        this.dsisRequiringModelReset.add((class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName());
        this.dsisRequiringModelReset.add((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetResetManager.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName());
    }

    private void registerDsiStateListener() {
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = TargetResetManager.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 0, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 1, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 2, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 3, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngine = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngine, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = TargetResetManager.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = TargetResetManager.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSICombinedRouteList == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteList = TargetResetManager.class$("org.dsi.ifc.navigation.DSICombinedRouteList")) : class$org$dsi$ifc$navigation$DSICombinedRouteList, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetResetManager.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 3, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 3, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = TargetResetManager.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = TargetResetManager.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = TargetResetManager.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = TargetResetManager.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TargetResetManager.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = TargetResetManager.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = TargetResetManager.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = TargetResetManager.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = TargetResetManager.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = TargetResetManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    @Override
    public void registered(String string, int n) {
        String string2 = new StringBuffer().append(string).append("_").append(n).toString();
        this.printTrace("Registered ", string2);
        if (!this.allDsis.contains(string2)) {
            this.allDsis.add(string2);
        }
        if (!this.registeredDsis.contains(string2)) {
            this.registeredDsis.add(string2);
        }
        if (this.allDsisRegistered() && this.resettedDsis.size() > 0) {
            this.printTrace("All DSIs up again. ", "Reset required");
            this.updateTargets();
            this.resetTargets();
            if (this.modelResetRequired()) {
                this.printTrace("", "Modelreset required");
                this.resetModel();
            }
            this.resettedDsis.clear();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = new StringBuffer().append(string).append("_").append(n).toString();
        this.printTrace("Unregistered ", string2);
        if (this.registeredDsis.contains(string2)) {
            this.registeredDsis.remove(string2);
        }
        if (!this.resettedDsis.containsKey(string)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Integer(n));
            this.resettedDsis.put(string, arrayList);
        } else {
            ArrayList arrayList = (ArrayList)this.resettedDsis.get(string);
            if (arrayList != null && !arrayList.contains(new Integer(n))) {
                arrayList.add(new Integer(n));
                this.resettedDsis.put(string, arrayList);
            }
        }
    }

    private boolean modelResetRequired() {
        Iterator iterator = this.dsisRequiringModelReset.iterator();
        String string = "";
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            if (!this.resettedDsis.containsKey(string)) continue;
            return true;
        }
        return false;
    }

    private boolean allDsisRegistered() {
        return this.registeredDsis.containsAll(this.allDsis) && this.allDsis.containsAll(this.registeredDsis);
    }

    private void updateTargets() {
        this.targets = this.startupGroupManager.getAllTargets();
    }

    private void resetTargets() {
        for (int i2 = 0; i2 < this.targets.length; ++i2) {
            if (this.targets[i2] instanceof AbstractResettableAslTarget) {
                ((AbstractResettableAslTarget)this.targets[i2]).reset(this.resettedDsis);
                continue;
            }
            if (this.targets[i2] instanceof AbstractResettableAslHsmTarget) {
                ((AbstractResettableAslHsmTarget)this.targets[i2]).reset(this.resettedDsis);
                continue;
            }
            if (this.targets[i2] instanceof AbstractResettableTarget) {
                ((AbstractResettableTarget)this.targets[i2]).reset(this.resettedDsis);
                continue;
            }
            if (!NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) continue;
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: TargetResetManager: ").append("Target ").append(super.getClass().toString()).append(" does not implement reset method");
            logMessage.log();
        }
    }

    private void resetModel() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(756, true);
    }

    private void printTrace(String string, String string2) {
        LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
        logMessage.append("NAVI-STARTUP: TargetResetManager: ").append(string).append(string2);
        logMessage.log();
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


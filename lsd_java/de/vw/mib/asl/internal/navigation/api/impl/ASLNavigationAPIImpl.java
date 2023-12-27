/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl;

import de.vw.mib.asl.api.navbap.ASLNavBAPAPI;
import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.NavigationMapListener;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListener;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.navigation.api.impl.TargetASLNavigationServices;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationPosPositionImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.asl.internal.navigation.util.IdentityHashSet;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechCapabiltiesCollector;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class ASLNavigationAPIImpl
implements ASLNavigationAPI,
ASLNavigationContainer,
INavServiceStateListener {
    private static IdentityHashSet navServiceStateListeners;
    private static NavigationExtServiceImpl extServiceTarget;
    private final TargetASLNavigationServices targetAslNavServices = new TargetASLNavigationServices(ServiceManager.eventMain, "hsmtask");
    private final ASLNavBAPAPI bapAPI = ASLNavBAPFactory.getNavBAPApi();
    private HsmTargetHas hasTarget;

    public static void notifyNavServiceStateListeners() {
        Iterator iterator = navServiceStateListeners.iterator();
        while (iterator.hasNext()) {
            try {
                INavServiceStateListener iNavServiceStateListener = (INavServiceStateListener)iterator.next();
                iNavServiceStateListener.navServiceStateChanged();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public ASLNavigationAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
        this.registerNavServiceStateListener(this);
    }

    @Override
    public int degMinSecToDsi(double[] dArray) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(dArray);
    }

    @Override
    public int degMinSecToDsi(double[] dArray, boolean bl) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(dArray, bl);
    }

    @Override
    public double[] dsiToDegMinSec(int n) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(n);
    }

    @Override
    public double dsiToDecimal(int n) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(n);
    }

    @Override
    public int decimalToDsi(double d2) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(d2);
    }

    @Override
    public ASLNavigationServices getASLNavigationServices(ASLNavigationServicesListener aSLNavigationServicesListener) {
        return this.targetAslNavServices.createServiceInstance(aSLNavigationServicesListener);
    }

    @Override
    public boolean isGatwayInstance() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().isGatewayInstance();
    }

    @Override
    public void setNavSpeechCapabilities(boolean bl, boolean bl2, boolean bl3) {
        NavigationSpeechCapabiltiesCollector navigationSpeechCapabiltiesCollector = new NavigationSpeechCapabiltiesCollector();
        navigationSpeechCapabiltiesCollector.navigation_speech_full_word = bl;
        navigationSpeechCapabiltiesCollector.navigation_speech_one_shot = bl2;
        navigationSpeechCapabiltiesCollector.navigation_speech_spelling = bl3;
        ListManager.getGenericASLList(2503).updateList(new NavigationSpeechCapabiltiesCollector[]{navigationSpeechCapabiltiesCollector});
    }

    @Override
    public void updateBapCompassInfo(int n, int n2) {
        ServiceManager.logger.warn(16384, "ASLNavigationAPI.updateBapCompassInfo is deprectaed. please use ASLNavBAP.updateBapCompassInfo");
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("CompassInfo angle=").append(n).append(" direction=").append(n2).log();
        }
        this.bapAPI.updateBapCompassInfo(n, n2);
    }

    @Override
    public void updateBapDistanceToDestination(int n, int n2) {
        ServiceManager.logger.warn(16384, "ASLNavigationAPI.updateBapDistanceToDestination is deprectaed. please use ASLNavBAP.updateBapDistanceToDestination");
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("DistanceToDestination distance=").append(n).append(" unit=").append(n2).log();
        }
        this.bapAPI.updateBapDistanceToDestination(n, n2);
    }

    @Override
    public void updateBapDistanceToNextManeuver(int n, int n2, boolean bl, int n3) {
        ServiceManager.logger.warn(16384, "ASLNavigationAPI.updateBapDistanceToNextManeuver is deprectaed. please use ASLNavBAP.updateBapDistanceToNextManeuver");
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("UpdateDistanceToNextManeuver distance=").append(n).append(" unit=").append(n2).append(" bargraphEnabled=").append(bl).append(" bargraphValue=").append(n3).log();
        }
        this.bapAPI.updateBapDistanceToNextManeuver(n, n2, bl, n3);
    }

    @Override
    public void updateBapTimeToDestination(int n, int n2, long l) {
        ServiceManager.logger.warn(16384, "ASLNavigationAPI.updateBapTimeToDestination is deprectaed. please use ASLNavBAP.updateBapTimeToDestination");
        this.bapAPI.updateBapTimeToDestination(n, n2, l);
    }

    @Override
    public void updateBapTurnToInfo(String string, String string2) {
        ServiceManager.logger.warn(16384, "ASLNavigationAPI.updateBapTurnToInfo is deprectaed. please use ASLNavBAP.updateBapTurnToInfo");
        this.bapAPI.updateBapTurnToInfo(string, string2);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        this.hasTarget = new HsmTargetHas(genericEvents, 1430983680, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, this.hasTarget);
        extServiceTarget = new NavigationExtServiceImpl(genericEvents, -901049344, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, extServiceTarget);
    }

    public NavLocation constructNavLocation(double d2, double d3) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().constructNavLocation(d2, d3);
    }

    @Override
    public int getNavigationServiceState() {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationServiceState();
        }
        return 0;
    }

    @Override
    public NavigationGuidanceService getNavigationGuidanceService(NavigationGuidanceListener navigationGuidanceListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationGuidanceService(navigationGuidanceListener);
        }
        throw new NavigationServiceException("call to getNavigationGuidanceService before service available");
    }

    @Override
    public NavigationMemoryService getNavigationMemoryService(NavigationMemoryListener navigationMemoryListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationMemoryService(navigationMemoryListener);
        }
        throw new NavigationServiceException("call to getNavigationMemoryService before service available");
    }

    @Override
    public NavigationLocationinputService getNavigationLocationinputService(NavigationLocationinputListener navigationLocationinputListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationLocationinputService(navigationLocationinputListener);
        }
        throw new NavigationServiceException("call to getNavigationLocationinputService before service available");
    }

    @Override
    public INavigationLocation createNavigationLocation(double d2, double d3) {
        return new INavigationLocationImpl(ASLNavigationUtilFactory.getNavigationUtilApi().constructNavLocation(d2, d3));
    }

    @Override
    public NavigationMapService getNavigationMapService(NavigationMapListener navigationMapListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationMapService(navigationMapListener);
        }
        throw new NavigationServiceException("call to getNavigationMapService before service available");
    }

    @Override
    public NavigationTrafficService getNavigationTrafficService(NavigationTrafficListener navigationTrafficListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationTrafficService(navigationTrafficListener);
        }
        throw new NavigationServiceException("call to getNavigationTrafficService before service available");
    }

    @Override
    public void registerNavServiceStateListener(INavServiceStateListener iNavServiceStateListener) {
        navServiceStateListeners.add(iNavServiceStateListener);
        try {
            iNavServiceStateListener.navServiceStateChanged();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void unregisterNavServiceStateListener(INavServiceStateListener iNavServiceStateListener) {
        navServiceStateListeners.remove(iNavServiceStateListener);
    }

    @Override
    public void navServiceStateChanged() {
    }

    @Override
    public ICMapService getICMapService(ICMapListener iCMapListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getICMapService(iCMapListener);
        }
        throw new NavigationServiceException("call to getICMapService before service available");
    }

    @Override
    public String dynPoi2Service(int n) {
        throw new NavigationServiceException("Call dynPoi2Service is deprecated! Please use NavigationOnlinePoiService.dynPoi2Service(int)");
    }

    @Override
    public NavigationOnlinePoiService getNavigationOnlinePoiService(NavigationOnlinePoiListener navigationOnlinePoiListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationOnlinePoiService(navigationOnlinePoiListener);
        }
        throw new NavigationServiceException("call to getNavigationPoiService before service available");
    }

    @Override
    public NavigationOnboardPoiService getNavigationOnboardPoiService(NavigationOnboardPoiListener navigationOnboardPoiListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationOnboardPoiService(navigationOnboardPoiListener);
        }
        throw new NavigationServiceException("call to getNavigationPoiService before service available");
    }

    @Override
    public NavigationSplitscreenService getNavigationSplitscreenService(NavigationSplitscreenListener navigationSplitscreenListener) {
        if (extServiceTarget != null) {
            return extServiceTarget.getNavigationSplitscreenService(navigationSplitscreenListener);
        }
        throw new NavigationServiceException("call to getNavigationSplitscreenService before service available");
    }

    @Override
    public INavigationPosPosition getPositionInfo() {
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        return new INavigationPosPositionImpl(posPosition);
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 1900745728, 1474376448);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1447760896, 155076864, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1900745728, 1474376448);
        ASLNavigationMapFactory.getNavigationMapApi().preRegisterServices();
        navServiceStateListeners = new IdentityHashSet();
    }
}


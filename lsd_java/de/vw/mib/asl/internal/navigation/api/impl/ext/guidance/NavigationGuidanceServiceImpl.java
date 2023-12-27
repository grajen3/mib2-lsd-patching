/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationRoute;
import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationRouteImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class NavigationGuidanceServiceImpl
implements NavigationGuidanceService {
    private static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    private static IGuidanceInfo[] latsGuidanceInfo = new IGuidanceInfo[2];
    public static int lastSatelliteSystem;
    private int routeIdToStart = -1;
    final NavigationGuidanceListener listener;
    final NavigationExtServiceImpl navigationExtServiceImpl;

    public static void notifysPNavSelectedDestination(IPnavLikelyDestination iPnavLikelyDestination) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl != null && navigationGuidanceServiceImpl.listener == null) continue;
        }
    }

    public static void notifysPNavLikelyDestinations(IPnavLikelyDestination[] iPnavLikelyDestinationArray) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updatePNavLikelyDestinations(iPnavLikelyDestinationArray);
        }
    }

    public static void notifysPNavIsEnabled(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updatePNavIsEnabled(bl);
        }
    }

    public static void notifysPNavCombinedCalculationState(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updatePNavCombinedCalculationState(n);
        }
    }

    public static void notifysPNavStatus(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updatePNavStatus(n);
        }
    }

    public static void notifyCalculationStates(int[] nArray, int[] nArray2, int[] nArray3) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.calculateRouteUpdate(nArray, nArray2, nArray3);
        }
    }

    public static void notifyGuidanceState(int n, int n2) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateGuidanceState(n, n2);
            if (n2 != 1 || navigationGuidanceServiceImpl.routeIdToStart == -1) continue;
            navigationGuidanceServiceImpl.listener.startGuidanceCalculatedRouteResult(navigationGuidanceServiceImpl.routeIdToStart, 0);
            navigationGuidanceServiceImpl.routeIdToStart = -1;
        }
    }

    public static void notifyGuidanceErrorState(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateGuidanceErrorState(n);
        }
    }

    public static void notifyGuidanceInfo(IGuidanceInfo[] iGuidanceInfoArray) {
        IGuidanceInfo[] iGuidanceInfoArray2 = new IGuidanceInfo[2];
        if (iGuidanceInfoArray != null) {
            for (int i2 = 0; i2 < iGuidanceInfoArray2.length && i2 < iGuidanceInfoArray.length; ++i2) {
                iGuidanceInfoArray2[i2] = iGuidanceInfoArray[i2];
            }
            latsGuidanceInfo = iGuidanceInfoArray2;
        }
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateGuidanceInfo(iGuidanceInfoArray);
        }
    }

    public static void notifyWPMCurrentMode(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMCurrentMode(n);
        }
    }

    public static void notifyWPMDistanceToNextWaypoint(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMDistanceToNextWaypoint(n);
        }
    }

    public static void notifyWPMInfoDirection(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMInfoDirection(n);
        }
    }

    public static void notifyWPMIsRecordModeDestinationSet(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMIsRecordModeDestinationSet(bl);
        }
    }

    public static void notifyWPMNumberOfFreePointsInMemory(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMNumberOfFreePointsInMemory(n);
        }
    }

    public static void notifyWPMNumberOfMaxPointsInMemory(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMNumberOfMaxPointsInMemory(n);
        }
    }

    public static void notifyWPMNumberOfPointsForCurrentRecord(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateWPMNumberOfPointsForCurrentRecord(n);
        }
    }

    public static void notifyTriggerEventAudioMessageResult(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateTriggerEventAudioMessageResult(n);
        }
    }

    public static void notifyVZAVZEIcons(ASLGuidanceVZAVZEIcons[] aSLGuidanceVZAVZEIconsArray) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateVZAVZEIcons(aSLGuidanceVZAVZEIconsArray);
        }
    }

    public static void notifyLaneGuidance(ASLGuidanceLaneGuidance[] aSLGuidanceLaneGuidanceArray) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateLaneGuidance(aSLGuidanceLaneGuidanceArray);
        }
    }

    public static void notifySpeedCameraWarningIcon(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateSpeedCameraWarningIcon(bl);
        }
    }

    public static void notifySatelliteSystem(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateSatelliteSystem(n);
        }
    }

    public NavigationGuidanceServiceImpl(NavigationGuidanceListener navigationGuidanceListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationGuidanceListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        this.listener.updateSatelliteSystem(lastSatelliteSystem);
        serviceInstances.add(this);
    }

    @Override
    public void calculateRoute(INavigationLocation[] iNavigationLocationArray) {
        if (iNavigationLocationArray == null) {
            throw new NavigationServiceException("null parameter to calculateRoute");
        }
        if (iNavigationLocationArray.length <= 0) {
            throw new NavigationServiceException("no destinations to calculateRoute");
        }
        INavigationRoute iNavigationRoute = this.getNewRoute();
        for (int i2 = 0; i2 < iNavigationLocationArray.length; ++i2) {
            if (!(iNavigationLocationArray[i2] instanceof INavigationLocationHelper)) continue;
            iNavigationRoute.addDestinationAtPosition(iNavigationLocationArray[i2], i2);
        }
        this.calculateRoute(iNavigationRoute, ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isDemomodeActive());
    }

    @Override
    public void startGuidanceCalculatedRoute(int n) {
        this.routeIdToStart = n;
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().startGuidanceCalculatedRoute(n);
    }

    @Override
    public int getGuidanceState() {
        return this.navigationExtServiceImpl.getGuidanceState();
    }

    @Override
    public boolean isRgActive() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive();
    }

    @Override
    public void stopGuidance() {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().stopGuidance();
        this.navigationExtServiceImpl.activeGuidanceService = null;
    }

    @Override
    public int[] getCalculationStates() {
        return this.navigationExtServiceImpl.getCalculationStates();
    }

    @Override
    public int[] getCalculationRouteIds() {
        return this.navigationExtServiceImpl.getCalculationRouteIds();
    }

    @Override
    public int getGuidanceMode() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceMode();
    }

    @Override
    public void calculateRoute(INavigationRoute iNavigationRoute, boolean bl) {
        if (iNavigationRoute == null) {
            throw new NavigationServiceException("null parameter to calculateRoute");
        }
        if (iNavigationRoute.getNumberOfDestinations() <= 0) {
            throw new NavigationServiceException("no destinations to calculateRoute");
        }
        if (iNavigationRoute.getNumberOfDestinations() > ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getMaxNumberOfDestinations()) {
            throw new NavigationServiceException("route with too many entries!!!");
        }
        if (ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isDemomodeActive() != bl) {
            this.setDemomodeActive(bl);
        }
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().calculateRouteWithConfirmation(((INavigationRouteImpl)iNavigationRoute).getRealRoute(), 6);
    }

    @Override
    public void reCalculateRoute(INavigationRoute iNavigationRoute, boolean bl) {
        if (iNavigationRoute == null) {
            throw new NavigationServiceException("null parameter to calculateRoute");
        }
        if (iNavigationRoute.getNumberOfDestinations() <= 0) {
            throw new NavigationServiceException("no destinations to calculateRoute");
        }
        if (iNavigationRoute.getNumberOfDestinations() > ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getMaxNumberOfDestinations()) {
            throw new NavigationServiceException("route with too many entries!!!");
        }
        if (ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isDemomodeActive() != bl) {
            this.setDemomodeActive(bl);
        }
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().recalculateRoute(((INavigationRouteImpl)iNavigationRoute).getRealRoute(), bl);
    }

    @Override
    public INavigationRoute getCurrentRoute() {
        return new INavigationRouteImpl(ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getCurrentRoute());
    }

    @Override
    public void leaveWaypointMode() {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().leaveWaypointMode();
    }

    @Override
    public INavigationRoute getNewRoute() {
        return new INavigationRouteImpl(null);
    }

    @Override
    public void setAlternativeRouteCalculation(boolean bl) {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().setHmiAlternativeRouteCalculation(bl);
    }

    @Override
    public boolean isAlternativeRouteCalculation() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isAlternativeRouteCalculation();
    }

    @Override
    public boolean isDemomodeActive() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isDemomodeActive();
    }

    @Override
    public void setDemoDest(INavigationLocation iNavigationLocation) {
        if (iNavigationLocation instanceof INavigationLocationHelper && iNavigationLocation.isValid()) {
            ASLNavigationGuidanceFactory.getNavigationGuidanceApi().setDemoDest(((INavigationLocationHelper)((Object)iNavigationLocation)).getRealLocation());
        }
    }

    @Override
    public INavigationLocation getDemoDest() {
        return new INavigationLocationImpl(ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDemoDest());
    }

    private long calculateEtaForFinalDest(Route route, RgInfoForNextDestination rgInfoForNextDestination, NavRouteListData[] navRouteListDataArray) {
        long l = rgInfoForNextDestination.getTimeToNextDest() * 0;
        if (navRouteListDataArray != null && navRouteListDataArray.length > 1 && route != null) {
            int n = (int)(route.getIndexOfCurrentDestination() + 1L);
            if (route.getRoutelist() != null && n < navRouteListDataArray.length) {
                l += (long)navRouteListDataArray[n].getRemainingTravelTime();
            }
        }
        return l;
    }

    @Override
    public IGuidanceInfo[] getGuidanceInfo() {
        return latsGuidanceInfo;
    }

    @Override
    public boolean isStatusNextStopover() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup().isStatusLineInfo();
    }

    @Override
    public boolean isEtaSelected() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup().getDpGuidanceTimeFormat() == 0;
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    @Override
    public void setDemomodeActive(boolean bl) {
        IPersistedGuidanceSetup iPersistedGuidanceSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup();
        iPersistedGuidanceSetup.setDemoMode(bl);
        iPersistedGuidanceSetup.updatePropertyIsDemoMode();
        iPersistedGuidanceSetup.updatePropertyIsDemoModeG();
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().triggerEventAudioMessage(n);
    }

    @Override
    public void startGuidancePNAVRoute(int n) {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().startGuidancePNAVRoute(n);
    }

    @Override
    public void setPNAVStatus(int n) {
        switch (n) {
            case 1: {
                n = 1;
                break;
            }
            case 0: {
                n = 0;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                n = 0;
            }
        }
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().setPNAVStatus(n);
    }

    public static void notifySetupTrafficSignMode(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = (NavigationGuidanceServiceImpl)iterator.next();
            if (navigationGuidanceServiceImpl == null || navigationGuidanceServiceImpl.listener == null) continue;
            navigationGuidanceServiceImpl.listener.updateSetupTrafficSignMode(n);
        }
    }

    @Override
    public int getSetupTrafficSignMode() {
        int n = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getSetupTrafficSignMode();
        switch (n) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    @Override
    public int getPnavStatus() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getPnavStatus();
    }

    @Override
    public int getExecutionMode() {
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getExecutionMode();
    }
}


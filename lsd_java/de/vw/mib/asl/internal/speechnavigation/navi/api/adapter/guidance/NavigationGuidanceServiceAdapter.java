/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationRoute;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceInformationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter$1;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter$2;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter$3;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapterBase$StartGuidanceCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapterBase$StopGuidanceCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StartGuidanceToListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;

public final class NavigationGuidanceServiceAdapter
extends NavigationGuidanceServiceAdapterBase
implements NavigationGuidanceListener,
GuidanceService,
GuidanceInformationService {
    private static NavigationGuidanceServiceAdapter instance = null;
    protected final NavigationGuidanceService guidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this);
    protected final NavigationGuidanceServiceAdapterBase$StartGuidanceCallerLock startGuidanceCaller = new NavigationGuidanceServiceAdapterBase$StartGuidanceCallerLock(this, this.guidanceService);
    protected final NavigationGuidanceServiceAdapterBase$StopGuidanceCallerLock stopGuidanceCaller = new NavigationGuidanceServiceAdapterBase$StopGuidanceCallerLock(this);

    private NavigationGuidanceServiceAdapter() {
    }

    private static NavigationGuidanceServiceAdapter getInstance() {
        if (instance == null) {
            instance = new NavigationGuidanceServiceAdapter();
        }
        return instance;
    }

    public static GuidanceService getGuidanceService() {
        return NavigationGuidanceServiceAdapter.getInstance();
    }

    public static GuidanceInformationService getGuidanceInformationService() {
        return NavigationGuidanceServiceAdapter.getInstance();
    }

    @Override
    public void release() {
        this.startGuidanceCaller.restoreNaviGuidanceDemoSetting();
    }

    @Override
    public void startGuidanceTo(StartGuidanceToListener startGuidanceToListener, INavigationLocation iNavigationLocation) {
        INavigationRoute iNavigationRoute = this.guidanceService.getNewRoute();
        iNavigationRoute.addDestinationAtPosition(iNavigationLocation, 0);
        if (this.isGuidanceActive()) {
            this.stopGuidance(new NavigationGuidanceServiceAdapter$1(this, startGuidanceToListener, iNavigationLocation, iNavigationRoute));
        } else {
            try {
                this.startGuidanceCaller.acquire(startGuidanceToListener, iNavigationLocation);
                this.guidanceService.calculateRoute(iNavigationRoute, false);
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.error(new StringBuffer().append("error calling calculateRoute: ").append(navigationServiceException.getMessage()).toString());
                this.startGuidanceCaller.release(1);
            }
        }
    }

    @Override
    public boolean canAddStopover() {
        INavigationRoute iNavigationRoute = this.guidanceService.getCurrentRoute();
        return iNavigationRoute.getMaximumNumberOfDestinations() > iNavigationRoute.getNumberOfDestinations();
    }

    @Override
    public void addNextStopOver(StartGuidanceToListener startGuidanceToListener, INavigationLocation iNavigationLocation) {
        INavigationRoute iNavigationRoute = this.guidanceService.getCurrentRoute();
        int n = iNavigationRoute.getIndexOfCurrentDestination();
        this.stopGuidance(new NavigationGuidanceServiceAdapter$2(this, startGuidanceToListener, iNavigationLocation, iNavigationRoute, n));
    }

    @Override
    public void removeNextStopOver(StartGuidanceToListener startGuidanceToListener) {
        INavigationRoute iNavigationRoute = this.guidanceService.getCurrentRoute();
        int n = iNavigationRoute.getIndexOfCurrentDestination();
        this.stopGuidance(new NavigationGuidanceServiceAdapter$3(this, startGuidanceToListener, iNavigationRoute, n));
    }

    @Override
    public void stopGuidance(StopGuidanceListener stopGuidanceListener) {
        try {
            this.stopGuidanceCaller.acquire(stopGuidanceListener);
            this.guidanceService.stopGuidance();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append("an error occured calling stopGuidance: ").append(navigationServiceException.getMessage()).toString());
            this.stopGuidanceCaller.release(1, this.guidanceService.getGuidanceMode(), this.guidanceService.getGuidanceState());
        }
    }

    @Override
    public void stopRouteCalculation(StopGuidanceListener stopGuidanceListener) {
        this.stopGuidance(stopGuidanceListener);
    }

    @Override
    public void stopSilentGuidance(StopGuidanceListener stopGuidanceListener) {
        this.stopGuidance(stopGuidanceListener);
    }

    @Override
    public void stopWayPointMode(StopGuidanceListener stopGuidanceListener) {
        this.stopGuidance(stopGuidanceListener);
        this.guidanceService.leaveWaypointMode();
    }

    @Override
    public void startGuidanceCalculatedRouteResult(int n, int n2) {
        if (this.startGuidanceCaller.isAcquired()) {
            this.startGuidanceCaller.release(this.guidanceStateResultMap.get(n2));
        } else {
            AppLogger.info(new StringBuffer().append("received startGuidanceCalculatedRouteResult( routeId = ").append(n).append(", resultCode = ").append(n2).append(" ), result while a speech caller is not yet acquired").toString());
        }
    }

    @Override
    public int getRouteCalculationStatus() {
        int[] nArray = this.guidanceService.getCalculationStates();
        return this.getRouteCalculationStatus(nArray);
    }

    private int getRouteCalculationStatus(int[] nArray) {
        int n = -1;
        if (nArray == null || nArray.length == 0) {
            n = 0;
        } else {
            boolean bl = true;
            boolean bl2 = true;
            boolean bl3 = true;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                bl &= nArray[i2] == 2;
                bl2 &= nArray[i2] == 0;
                bl3 &= nArray[i2] == 1;
            }
            n = bl ? 3 : (bl3 ? 1 : (bl2 ? 0 : 2));
        }
        return n;
    }

    @Override
    public int getGuidanceStatus() {
        int n = 0;
        if (this.guidanceService.getGuidanceMode() == 0) {
            n = this.guidanceService.getGuidanceState() == 0 ? 0 : 1;
        }
        return n;
    }

    @Override
    public int getSilentGuidanceStatus() {
        int n = 0;
        if (this.guidanceService.getGuidanceMode() == 2) {
            n = this.guidanceService.getGuidanceState() == 0 ? 0 : 1;
        }
        return n;
    }

    @Override
    public int getWayPointModeStatus() {
        int n = 0;
        if (this.guidanceService.getGuidanceMode() == 1) {
            n = 1;
        }
        return n;
    }

    @Override
    public boolean isGuidanceActive() {
        boolean bl = this.getGuidanceStatus() == 1 ^ this.getSilentGuidanceStatus() == 1;
        return bl;
    }

    @Override
    public boolean isStopoverDefined() {
        INavigationRoute iNavigationRoute = this.guidanceService.getCurrentRoute();
        int n = iNavigationRoute.getNumberOfDestinations();
        int n2 = iNavigationRoute.getIndexOfCurrentDestination();
        return n2 < n - 1;
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
        int n3 = this.guidanceTypeMap.containsKey(n) ? this.guidanceTypeMap.get(n) : -1;
        int n4 = this.guidanceStateMap.get(n2);
        AppLogger.info(this, this.translateGuidanceStatus(n3, n4));
        Framework.updateUIValue(1963471872, n4 == 1);
        if (!this.stopGuidanceCaller.isAcquired()) {
            return;
        }
        if (n2 == 0) {
            this.stopGuidanceCaller.release(0, n3, n4);
        }
    }

    @Override
    public void calculateRouteUpdate(int[] nArray, int[] nArray2, int[] nArray3) {
        if (nArray == null || nArray.length == 0) {
            AppLogger.warn("invalid calculateRouteUpdate update: routeIds[] empty or null");
            return;
        }
        int n = this.getRouteCalculationStatus(nArray2);
        if (!this.startGuidanceCaller.isAcquired()) {
            return;
        }
        if (!this.guidanceService.isAlternativeRouteCalculation()) {
            if (n == 3) {
                int n2 = nArray[0];
                try {
                    this.guidanceService.startGuidanceCalculatedRoute(n2);
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.error(new StringBuffer().append("cannot start guidance for given route id: ").append(n2).toString());
                    this.startGuidanceCaller.release(1);
                }
            }
        } else {
            this.startGuidanceCaller.release(0);
        }
    }

    @Override
    public int getSetupOption() {
        if (this.guidanceService.isStatusNextStopover()) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getEtaDays() {
        return this.getGuidanceInfo().getEtaDays();
    }

    @Override
    public int getEtaHours() {
        return this.getGuidanceInfo().getEtaHours();
    }

    @Override
    public int getEtaMinutes() {
        return this.getGuidanceInfo().getEtaMinutes();
    }

    @Override
    public long getRttMiliseconds() {
        return this.getGuidanceInfo().getRttMilliseconds();
    }

    @Override
    public long getDistance() {
        return this.getGuidanceInfo().getDistance();
    }

    @Override
    public IGuidanceInfo getGuidanceInfo() {
        IGuidanceInfo[] iGuidanceInfoArray = this.guidanceService.getGuidanceInfo();
        if (this.isStopoverDefined() && this.getSetupOption() == 0) {
            return iGuidanceInfoArray[0];
        }
        return iGuidanceInfoArray[1];
    }
}


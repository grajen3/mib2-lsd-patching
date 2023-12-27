/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.service.NavigationService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandlerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalController;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase$3;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ModalController;

public abstract class ApplicationModalControllerBase
extends ApplicationErrorHandlerBase
implements RecognizedEventConsumer,
ApplicationModalController,
ModalController {
    public final GuidanceService guidanceService;
    protected boolean navCheckDone = false;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$common$ApplicationModalControllerBase;

    public ApplicationModalControllerBase() {
        this.guidanceService = NavigationGuidanceServiceAdapter.getGuidanceService();
    }

    public ApplicationModalControllerBase(NavigationService navigationService, GuidanceService guidanceService) {
        super(navigationService);
        this.guidanceService = guidanceService;
    }

    @Override
    public void onActionCancelled() {
    }

    protected void checkPrerequisites() {
        this.navCheckDone = false;
        this.checkNaviServiceAvailable();
        this.checkWayPointModeActive();
        this.checkSilentGuidanceModeActive();
        this.checkRouteCalculationModeActive();
    }

    protected void checkWayPointModeActive() {
        if (this.guidanceService.getWayPointModeStatus() == 1) {
            this.navCheckDone = true;
            this.onWaypointModeActive();
            throw new NavigationServiceException(" waypoint mode active");
        }
    }

    protected void checkSilentGuidanceModeActive() {
        if (this.guidanceService.getSilentGuidanceStatus() != 0) {
            this.navCheckDone = true;
            this.onSilentGuidanceActive();
            throw new NavigationServiceException(" silent guidance active");
        }
    }

    protected void checkRouteCalculationModeActive() {
        if (this.guidanceService.getRouteCalculationStatus() != 0) {
            this.navCheckDone = true;
            this.onRouteCalculationActive();
            throw new NavigationServiceException(" route calculation active or no route selected");
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141864: {
                this.onAbortStopRouteCalculationCommand();
                break;
            }
            case 1077141863: {
                this.onConfirmStopRouteCalculationCommand();
                break;
            }
            case 1077141860: {
                this.onAbortStopWayPointModeCommand();
                break;
            }
            case 1077141859: {
                this.onConfirmStopWaypointModeCommand();
                break;
            }
            case 1077141862: {
                this.onAbortStopSilentGuidanceCommand();
                break;
            }
            case 1077141861: {
                this.onConfirmStopSilentGuidanceCommand();
                break;
            }
            default: {
                AppLogger.warn(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$common$ApplicationModalControllerBase == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$common$ApplicationModalControllerBase = ApplicationModalControllerBase.class$("de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$common$ApplicationModalControllerBase).getName()).append(", unhandle recognition event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onWaypointModeActive() {
        Framework.fireUIEvent(-2029505536);
    }

    @Override
    public void onConfirmStopWaypointModeCommand() {
        Framework.fireUIEvent(-2012728320);
        this.guidanceService.stopWayPointMode(new ApplicationModalControllerBase$1(this));
    }

    @Override
    public void onAbortStopWayPointModeCommand() {
        Framework.fireUIEvent(-1995951104);
        this.onActionCancelled();
    }

    @Override
    public void onSilentGuidanceActive() {
        Framework.fireUIEvent(-1979173888);
    }

    @Override
    public void onConfirmStopSilentGuidanceCommand() {
        Framework.fireUIEvent(-1962396672);
        this.guidanceService.stopSilentGuidance(new ApplicationModalControllerBase$2(this));
    }

    @Override
    public void onAbortStopSilentGuidanceCommand() {
        Framework.fireUIEvent(-1945619456);
        this.onActionCancelled();
    }

    @Override
    public void onRouteCalculationActive() {
        Framework.fireUIEvent(-1928842240);
    }

    @Override
    public void onConfirmStopRouteCalculationCommand() {
        Framework.fireUIEvent(-1912065024);
        this.guidanceService.stopRouteCalculation(new ApplicationModalControllerBase$3(this));
    }

    @Override
    public void onAbortStopRouteCalculationCommand() {
        Framework.fireUIEvent(-1895287808);
        this.onActionCancelled();
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


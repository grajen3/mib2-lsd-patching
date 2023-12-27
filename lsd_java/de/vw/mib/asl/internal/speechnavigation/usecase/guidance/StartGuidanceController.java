/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceController$1;
import de.vw.mib.genericevents.EventGeneric;

public class StartGuidanceController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_START_GUIDANCE;
    private final LastDestinationService destinationsService = NavigationMemoryServiceAdapter.getLastDestinationService();
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController;

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(1510487040);
    }

    @Override
    public void onActionResumed() {
        this.onStartGuidanceCommand();
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141833: {
                try {
                    this.checkNaviServiceAvailable();
                    this.checkWayPointModeActive();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.error(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController = StartGuidanceController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController).getName()).append(" ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onStartGuidanceCommand();
                break;
            }
            case 1077141834: 
            case 1077141835: {
                this.onConfirmStopGuidanceCommand();
                break;
            }
            case 1077141836: 
            case 1077141837: {
                this.onCancelStopGuidanceCommand();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141833: {
                this.onStartGuidanceCommand();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController = StartGuidanceController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StartGuidanceController).getName()).append(" unhandle event ").append(n).toString());
            }
        }
    }

    private void onStartGuidanceCommand() {
        if (this.guidanceService.getGuidanceStatus() == 1 || this.guidanceService.getSilentGuidanceStatus() == 1) {
            this.notifyGuidanceActive();
            return;
        }
        int n = this.guidanceService.getRouteCalculationStatus();
        if (n == 1) {
            this.notifyRouteCalculationInProgress();
            return;
        }
        if (n == 3) {
            this.notifyRouteCalculationFinishedNotSelected();
            return;
        }
        if (n == 2) {
            this.notifyRouteCalculationInProgress();
        } else if (n == 0) {
            this.destinationsService.getLastUsedDestination(new StartGuidanceController$1(this));
        }
    }

    private void onCancelStopGuidanceCommand() {
        this.notifyCanceStopGuidance();
    }

    private void notifyCanceStopGuidance() {
        Framework.fireUIEvent(1661481984);
    }

    private void notifyGuidanceActive() {
        Framework.fireUIEvent(1527264256);
    }

    private void notifyRouteCalculationInProgress() {
        Framework.fireUIEvent(1544041472);
    }

    private void notifyRouteCalculationFinishedNotSelected() {
        Framework.fireUIEvent(-1593297920);
    }

    private void onConfirmStopGuidanceCommand() {
        Framework.fireEvent(1994470208);
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


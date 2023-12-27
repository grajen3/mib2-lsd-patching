/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.actions.ActionInvoker;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StopGuidanceController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.RemoveNextStopOverAction;
import de.vw.mib.genericevents.EventGeneric;

public class StopGuidanceController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_STOP_GUIDANCE;
    private final ActionInvoker actionInvoker = new ActionInvoker(SpeechServices.getDialogStateService());
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController;

    @Override
    public void onActionResumed() {
        this.onStopGuidanceCommand();
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1576520704);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141878: {
                try {
                    this.checkNaviServiceAvailable();
                    this.checkWayPointModeActive();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.error(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController = StopGuidanceController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StopGuidanceController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController).getName()).append(": ").append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onStopGuidanceCommand();
                break;
            }
            case 1077141839: {
                this.onCancelStartGuidanceCommand();
                break;
            }
            case 1077141838: 
            case 1077141840: {
                this.onConfirmStartGuidanceCommand();
                break;
            }
            case 1077141879: 
            case 1077141880: {
                this.onYesNoStopGuidanceStopover();
                break;
            }
            case 1077141834: {
                this.onConfirmStopGuidanceCommand();
                break;
            }
            case 1077141881: {
                this.onCancelStopGuidanceStopoverCommand();
                break;
            }
            case 1077141882: {
                this.onStopGuidanceStopover();
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
            case 1077141878: {
                this.onStopGuidanceCommand();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController = StopGuidanceController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StopGuidanceController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$guidance$StopGuidanceController).getName()).append(".onEvent( event = ").append(eventGeneric.toString()).append("), is not handled.").toString());
            }
        }
    }

    private void onStopGuidanceCommand() {
        if (this.guidanceService.getGuidanceStatus() != 1 && this.guidanceService.getSilentGuidanceStatus() != 1) {
            int n = this.guidanceService.getRouteCalculationStatus();
            if (n == 1 || n == 3 || n == 2) {
                this.stopGuidance();
            } else {
                this.notifyGuidanceNotActive();
            }
        } else if (!this.guidanceService.isStopoverDefined()) {
            this.stopGuidance();
        } else {
            this.notifyStopoverActive();
        }
    }

    private void stopGuidance() {
        this.guidanceService.stopGuidance(new StopGuidanceController$1(this));
    }

    private void onYesNoStopGuidanceStopover() {
        Framework.fireUIEvent(-1492634624);
    }

    private void onStopGuidanceStopover() {
        Framework.fireUIEvent(-1459080192);
        this.actionInvoker.invokeWhenSdsSessionEnds(new RemoveNextStopOverAction(this.guidanceService));
    }

    private void onCancelStopGuidanceStopoverCommand() {
        Framework.fireUIEvent(-1475857408);
    }

    private void onConfirmStopGuidanceCommand() {
        this.stopGuidance();
    }

    private void onCancelStartGuidanceCommand() {
        Framework.fireUIEvent(-1509411840);
    }

    void notifyGuidanceStopped() {
        Framework.fireUIEvent(-1542966272);
    }

    private void notifyGuidanceNotActive() {
        Framework.fireUIEvent(-1559743488);
    }

    private void notifyStopoverActive() {
        Framework.fireUIEvent(-1526189056);
    }

    private void onConfirmStartGuidanceCommand() {
        Framework.fireEvent(1239495488);
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


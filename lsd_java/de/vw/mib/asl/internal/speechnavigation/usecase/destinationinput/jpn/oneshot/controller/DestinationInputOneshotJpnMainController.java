/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController$3;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputOneshotJpnMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputOneshotJpnMainController] ";
    public static final int CMD_ENTER_ADDRESS;
    public static final int CMD_ENTER_ADDRESS_VIA_BACK;
    public static final int CMD_ENTER_ADDRESS_AGAIN_NOT_INITIALIZED;
    public static final int SUI_ONESHOT_SELECT_ITEM;
    private final DestinationDetailListener destinationInputAgainListener;

    public DestinationInputOneshotJpnMainController(DestinationDetailListener destinationDetailListener) {
        this.destinationInputAgainListener = destinationDetailListener;
    }

    public static void selectSUIAddress(OneShotJpnModel oneShotJpnModel) {
        Framework.fireEvent(1929779456, oneShotJpnModel);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141930: {
                this.destinationInputAgainListener.onResetCounter();
                try {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Start oneshot.").toString());
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
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
            case 1640051: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received SUI address input request.").toString());
                this.destinationInputAgainListener.onResetCounter();
                OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)eventGeneric.getObject(0);
                this.initializeSUIDestinationInput(oneShotJpnModel);
                break;
            }
            case 1077141996: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Start oneshot via back.").toString());
                this.destinationInputAgainListener.onReEnterAddress(true);
                break;
            }
            case 1640033: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Start oneshot via enter again including initialization.").toString());
                this.initializeDestinationInputViaEnterAgain();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(84489216);
    }

    @Override
    public void onActionResumed() {
        this.destinationInputService.initializeDestinationInput(new DestinationInputOneshotJpnMainController$1(this));
    }

    @Override
    public void onActionCancelled() {
    }

    @Override
    protected void checkPrerequisites() {
        this.checkNaviServiceAvailable();
        this.checkWayPointModeActive();
        this.checkSilentGuidanceModeActive();
        this.checkRouteCalculationModeActive();
    }

    private void initializeSUIDestinationInput(OneShotModel oneShotModel) {
        this.destinationInputService.initializeDestinationInput(new DestinationInputOneshotJpnMainController$2(this, oneShotModel));
    }

    private void initializeDestinationInputViaEnterAgain() {
        this.destinationInputService.initializeDestinationInput(new DestinationInputOneshotJpnMainController$3(this));
    }
}


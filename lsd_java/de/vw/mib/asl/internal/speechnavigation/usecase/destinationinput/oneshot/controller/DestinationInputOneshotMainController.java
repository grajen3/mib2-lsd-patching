/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneshotMainController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneshotMainController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputOneshotMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_ENTER_ADDRESS;
    public static final int CMD_ENTER_ADDRESS_VIA_BACK;
    public static final int SUI_ONESHOT_SELECT_ITEM;
    public static final int CMD_ENTER_ADDRESS_AGAIN_NOT_INITIALIZED;
    protected boolean enterAgain = false;

    public static void selectSUIAddress(OneShotModel oneShotModel) {
        Framework.fireEvent(1929779456, oneShotModel);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141930: {
                this.enterAgain = false;
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
                break;
            }
            case 1077141996: {
                DestinationInputOneShotController.enterOneShot();
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
                OneShotModel oneShotModel = (OneShotModel)eventGeneric.getObject(0);
                this.initializeSUIDestinationInput(oneShotModel);
                break;
            }
            case 1077141930: {
                this.enterAgain = false;
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
                break;
            }
            case 1640033: {
                this.enterAgain = true;
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
                break;
            }
            case 1077141996: {
                DestinationInputOneShotController.enterOneShot();
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
        this.destinationInputService.initializeDestinationInput(new DestinationInputOneshotMainController$1(this));
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
        this.destinationInputService.initializeDestinationInput(new DestinationInputOneshotMainController$2(this, oneShotModel));
    }
}


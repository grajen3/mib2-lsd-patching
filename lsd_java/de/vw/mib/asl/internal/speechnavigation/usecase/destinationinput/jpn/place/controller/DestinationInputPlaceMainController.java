/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceMainController$1;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputPlaceMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputPlaceMainController] ";
    public static final int CMD_ENTER_PLACE;
    public static final int CMD_ENTER_PLACE_VIA_BACK;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141967: {
                try {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_ENTER_PLACE.").toString());
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
            case 1077141994: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_ENTER_PLACE_VIA_BACK.").toString());
                DestinationInputPlaceController.enterPlace();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionResumed() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to initialize dest input for place").toString());
        this.destinationInputService.initializeDestinationInput(new DestinationInputPlaceMainController$1(this));
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(1024013312);
    }

    @Override
    public void onActionCancelled() {
    }
}


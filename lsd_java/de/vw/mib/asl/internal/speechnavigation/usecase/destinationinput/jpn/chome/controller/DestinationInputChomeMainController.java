/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeMainController$1;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputChomeMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputChomeMainController] ";
    public static final int CMD_ENTER_CHOME;
    public static final int CMD_ENTER_CHOME_VIA_BACK;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141968: {
                try {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_ENTER_CHOME.").toString());
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
            case 1077141995: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_ENTER_CHOME_VIA_BACK.").toString());
                DestinationInputChomeController.enterChome();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionResumed() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to initialize dest input for chome").toString());
        this.destinationInputService.initializeDestinationInput(new DestinationInputChomeMainController$1(this));
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(1057567744);
    }

    @Override
    public void onActionCancelled() {
    }
}


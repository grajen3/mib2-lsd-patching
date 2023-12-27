/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureMainController$1;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputPrefectureMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputPrefectureMainController] ";
    public static final int CMD_ENTER_PREFECTURE;
    public static final int CMD_ENTER_PREFECTURE_VIA_BACK;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141965: {
                try {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_ENTER_PREFECTURE.").toString());
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
            case 1077141992: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_ENTER_PREFECTURE_VIA_BACK.").toString());
                DestinationInputPrefectureController.enterPrefecture();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(this.logPrefix).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionResumed() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to initialize dest input for prefecture").toString());
        this.destinationInputService.initializeDestinationInput(new DestinationInputPrefectureMainController$1(this));
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(940127232);
    }

    @Override
    public void onActionCancelled() {
    }
}


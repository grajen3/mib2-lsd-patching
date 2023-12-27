/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityMainController$1;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputCityMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_ENTER_CITY;
    public static final int CMD_ENTER_CITY_VIA_BACK;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141884: {
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
            case 1077141987: {
                DestinationInputCityController.enterCity();
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
            case 1077141884: {
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
            case 1077141987: {
                DestinationInputCityController.enterCity();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1291308032);
    }

    @Override
    public void onActionResumed() {
        this.destinationInputService.initializeDestinationInput(new DestinationInputCityMainController$1(this));
    }

    @Override
    public void onActionCancelled() {
    }
}


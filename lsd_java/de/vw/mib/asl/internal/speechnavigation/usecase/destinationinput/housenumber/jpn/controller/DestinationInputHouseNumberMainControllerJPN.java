/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberMainControllerJPN$1;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputHouseNumberMainControllerJPN
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_ENTER_HOUSENUMBER;
    public static final int CMD_ENTER_HOUSENUMBER_VIA_BACK;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141887: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                if (this.destinationInputService.isHouseNumberBySds()) {
                    DestinationInputHouseNumberControllerJPN.enterHouseNumber();
                    break;
                }
                this.onActionResumed();
                break;
            }
            case 1077141990: {
                DestinationInputHouseNumberControllerJPN.enterHouseNumber();
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
            case 1077141887: {
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
            case 1077141990: {
                DestinationInputHouseNumberControllerJPN.enterHouseNumber();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1190644736);
    }

    @Override
    public void onActionResumed() {
        this.destinationInputService.initializeDestinationInput(new DestinationInputHouseNumberMainControllerJPN$1(this));
    }
}


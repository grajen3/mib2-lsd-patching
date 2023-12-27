/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingMainController$1;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputCrossingMainController
extends DestinationInputModalControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_ENTER_CROSSING;
    public static final int CMD_ENTER_CROSSING_VIA_BACK;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141888: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController = DestinationInputCrossingMainController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingMainController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController).getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
                break;
            }
            case 1077141991: {
                DestinationInputCrossingController.enterCrossing();
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
            case 1077141888: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController = DestinationInputCrossingMainController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingMainController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$crossing$controller$DestinationInputCrossingMainController).getName()).append(navigationServiceException.getMessage()).toString());
                    return;
                }
                this.onActionResumed();
                break;
            }
            case 1077141991: {
                DestinationInputCrossingController.enterCrossing();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append("unhandled model event: ").append(n).toString());
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1157090304);
    }

    @Override
    public void onActionResumed() {
        this.destinationInputService.initializeDestinationInput(new DestinationInputCrossingMainController$1(this));
    }

    @Override
    public void onActionCancelled() {
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


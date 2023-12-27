/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationMainController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;

public class LastDestinationMainController
extends ApplicationModalControllerBase
implements RecognizedEventConsumer {
    public static final int CMD_LAST_DESTINATIONS;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$lastdestination$controller$LastDestinationMainController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141897: {
                try {
                    this.checkPrerequisites();
                }
                catch (NavigationServiceException navigationServiceException) {
                    AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$lastdestination$controller$LastDestinationMainController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$lastdestination$controller$LastDestinationMainController = LastDestinationMainController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationMainController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$lastdestination$controller$LastDestinationMainController).getName()).append(navigationServiceException.getMessage()).toString());
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
    public void onActionResumed() {
        Framework.fireEvent(1172386624);
    }

    @Override
    public void onActionCancelled() {
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(1829254144);
    }

    public static void startGuidanceBy(LastDestination lastDestination) {
        LastDestinationService lastDestinationService;
        try {
            lastDestinationService = NavigationMemoryServiceAdapter.getLastDestinationService();
        }
        catch (NavigationServiceException navigationServiceException) {
            Framework.fireUIEvent(2097689600);
            return;
        }
        INavigationListElement iNavigationListElement = lastDestinationService.getLastDestination(lastDestination.objectId);
        lastDestinationService.getLastDestination(new LastDestinationMainController$1(), iNavigationListElement);
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


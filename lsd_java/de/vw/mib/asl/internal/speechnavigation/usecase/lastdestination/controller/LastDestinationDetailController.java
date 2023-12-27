/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationDetailController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class LastDestinationDetailController
extends DestinationDetailController
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int SHOW_LOCATION_ADDRESS_DETAILS;

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141852: {
                this.onShowDestinationAddressDetails((LastDestination)eventGeneric.getObject(0));
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141838: 
            case 1077141840: {
                this.onConfirmStartGuidanceCommand();
                break;
            }
            case 1077141839: {
                this.onAbortStartGuidanceCommand();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(2064135168);
    }

    public static void showDestinationAddressDetails(LastDestination lastDestination) {
        Framework.fireEvent(1558262592, lastDestination);
    }

    private void onShowDestinationAddressDetails(LastDestination lastDestination) {
        try {
            LastDestinationService lastDestinationService = NavigationMemoryServiceAdapter.getLastDestinationService();
            INavigationListElement iNavigationListElement = lastDestinationService.getLastDestination(lastDestination.objectId);
            lastDestinationService.getLastDestination(new LastDestinationDetailController$1(this), iNavigationListElement);
        }
        catch (NavigationServiceException navigationServiceException) {
            Framework.fireUIEvent(2097689600);
            return;
        }
    }

    void notifyShowDestinationAddressDetails(INavigationLocation iNavigationLocation) {
        this.showDestinationAddressDetails(iNavigationLocation, 1862808576);
    }

    private void onConfirmStartGuidanceCommand() {
        this.notifyStartGuidance();
    }

    private void onAbortStartGuidanceCommand() {
        this.notifyAbortStartGuidance();
    }

    private void notifyAbortStartGuidance() {
        Framework.fireUIEvent(1695036416);
    }

    private void notifyStartGuidance() {
        LastDestination lastDestination = (LastDestination)ListManager.getGenericASLList(1426600960).getDSIObjects()[0];
        LastDestinationMainController.startGuidanceBy(lastDestination);
    }
}


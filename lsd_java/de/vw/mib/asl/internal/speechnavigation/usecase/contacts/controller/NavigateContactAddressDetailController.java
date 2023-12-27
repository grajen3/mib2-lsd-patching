/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.AddressService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactAddressDetailController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.ContactAddress;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceCheckStopoverController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.genericevents.EventGeneric;

public class NavigateContactAddressDetailController
extends DestinationDetailController
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int SHOW_LOCATION_ADDRESS_DETAILS;

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640041: {
                this.onShowDestinationAddressDetails((ContactAddress)eventGeneric.getObject(0));
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

    public static void showDestinationAddressDetails(ContactAddress contactAddress) {
        Framework.fireEvent(1762007296, contactAddress);
    }

    private void onShowDestinationAddressDetails(ContactAddress contactAddress) {
        try {
            AddressService addressService = NavigationDestinationInputServiceAdapter.getAddressService();
            addressService.resolveAddress(new NavigateContactAddressDetailController$1(this), contactAddress.address);
        }
        catch (NavigationServiceException navigationServiceException) {
            Framework.fireUIEvent(2097689600);
            return;
        }
    }

    void notifyShowDestinationAddressDetails(INavigationLocation iNavigationLocation) {
        this.showDestinationAddressDetails(iNavigationLocation, -536333312);
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
        StartGuidanceCheckStopoverController.startGuidance(this.destinationDetail);
    }
}


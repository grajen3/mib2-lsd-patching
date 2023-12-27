/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.OnboardPOIService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceCheckStopoverController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIAddressDetailController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOIDataService;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class OnboardPOIAddressDetailController
extends DestinationDetailController
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int SHOW_LOCATION_ADDRESS_DETAILS;
    final OnboardPOIDataService service;

    public OnboardPOIAddressDetailController(OnboardPOIDataService onboardPOIDataService) {
        this.service = onboardPOIDataService;
    }

    public int getListIdTopLevel() {
        return 1879585792;
    }

    public int getListIdSelectedItem() {
        return 1997026304;
    }

    public OnboardPOI getNext() {
        OnboardPOI onboardPOI = (OnboardPOI)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        int n = onboardPOI.getInternalIndex() + 1;
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getItemCount()) {
            onboardPOI = (OnboardPOI)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new OnboardPOI[]{onboardPOI});
            return onboardPOI;
        }
        return null;
    }

    public OnboardPOI getPrevious() {
        OnboardPOI onboardPOI = (OnboardPOI)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        int n = onboardPOI.getInternalIndex() - 1;
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getItemCount()) {
            onboardPOI = (OnboardPOI)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new OnboardPOI[]{onboardPOI});
            return onboardPOI;
        }
        return null;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640046: 
            case 1077142003: {
                OnboardPOI onboardPOI = (OnboardPOI)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
                this.onShowDestinationAddressDetails(onboardPOI, 1997026304);
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
            case 1077141924: {
                OnboardPOI onboardPOI = this.getNext();
                if (onboardPOI != null) {
                    this.onShowDestinationAddressDetails(onboardPOI, -133680128);
                    break;
                }
                Framework.fireUIEvent(-116902912);
                break;
            }
            case 1077141925: {
                OnboardPOI onboardPOI = this.getPrevious();
                if (onboardPOI != null) {
                    this.onShowDestinationAddressDetails(onboardPOI, -167234560);
                    break;
                }
                Framework.fireUIEvent(-150457344);
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

    public static void showDestinationAddressDetails(OnboardPOI onboardPOI) {
        Framework.fireEvent(1845893376, onboardPOI);
    }

    private void onShowDestinationAddressDetails(OnboardPOI onboardPOI, int n) {
        try {
            OnboardPOIService onboardPOIService = NavigationOnboardPOIServiceAdapter.getService();
            onboardPOIService.resolveEntry(new OnboardPOIAddressDetailController$1(this, n), onboardPOI.getModel());
        }
        catch (NavigationServiceException navigationServiceException) {
            this.onActionFailed();
        }
    }

    void notifyShowDestinationAddressDetails(INavigationLocation iNavigationLocation, int n) {
        this.showDestinationAddressDetails(iNavigationLocation, n);
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


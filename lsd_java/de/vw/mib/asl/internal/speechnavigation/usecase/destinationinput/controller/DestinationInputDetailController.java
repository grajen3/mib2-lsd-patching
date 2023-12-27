/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceCheckStopoverController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;
import de.vw.mib.genericevents.EventGeneric;

public class DestinationInputDetailController
extends DestinationDetailController
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int START_GUIDANCE_WITH_DETAIL_VIEW;
    public static final int START_GUIDANCE_WITHOUT_DETAIL_VIEW;

    public DestinationInputDetailController(DestinationDetailListener destinationDetailListener) {
        super(destinationDetailListener);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640037: {
                this.onStartGuidanceWithDetailView((INavigationLocation)eventGeneric.getObject(0));
                break;
            }
            case 1640038: {
                this.onStartGuidanceWithoutDetailView((INavigationLocation)eventGeneric.getObject(0));
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

    public static void startGuidanceWithDetailView(INavigationLocation iNavigationLocation) {
        Framework.fireEvent(1694898432, iNavigationLocation);
    }

    public static void startGuidanceWithoutDetailView(INavigationLocation iNavigationLocation) {
        Framework.fireEvent(1711675648, iNavigationLocation);
    }

    private void onStartGuidanceWithDetailView(INavigationLocation iNavigationLocation) {
        this.notifyStartGuidanceWithDetailView(iNavigationLocation);
    }

    private void onStartGuidanceWithoutDetailView(INavigationLocation iNavigationLocation) {
        this.notifyStartGuidanceWithoutDetailView(iNavigationLocation);
    }

    void notifyStartGuidanceWithDetailView(INavigationLocation iNavigationLocation) {
        this.showDestinationAddressDetails(iNavigationLocation, 1577595904);
    }

    void notifyStartGuidanceWithoutDetailView(INavigationLocation iNavigationLocation) {
        this.destinationInputListener.onResetCounter();
        StartGuidanceCheckStopoverController.startGuidance(iNavigationLocation);
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
        this.destinationInputListener.onResetCounter();
        StartGuidanceCheckStopoverController.startGuidance(this.destinationDetail);
    }
}


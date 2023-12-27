/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController$2;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputStreetController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_STREET;
    public static final int FIRST_CMD_ENTER_STREET;
    public static final int CMD_DLG_STREET;
    public static final int CMD_DLG_START_GUIDANCE;
    private static final int CMD_DLG_ENTER_CITY;
    private static final int CMD_DLG_STATE_AGAIN_NBEST_STREET;
    public static final int CMD_DLG_ENTER_ADDRESS;
    public static final int CMD_DLG_REENTER_CITY;

    public DestinationInputStreetController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141906: {
                super.onRequestItems();
                break;
            }
            case 1077141884: {
                DestinationInputCityController.enterCity();
                break;
            }
            case 1077141907: {
                this.onEnterStreetAgain();
                break;
            }
            case 1077141912: {
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
                break;
            }
            case 1077141961: {
                DestinationInputCityController.enterCity();
                break;
            }
            case 1077141962: {
                DestinationInputOneShotController.enterOneShot();
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
            case 1640012: {
                this.checkEntryMode(-1240976384);
                break;
            }
            case 1640013: {
                this.checkEntryMode(-754437120);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterStreet() {
        Framework.fireEvent(1275468032);
    }

    public static void enterStreetFirst() {
        Framework.fireEvent(1292245248);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(-989318144);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onStreetSelected();
    }

    private void onStreetSelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setStreet(new DestinationInputStreetController$1(this), viewModelItem);
    }

    void notifyStreetSelected() {
        this.selectNextPossibleEntryMode();
    }

    private void onEnterStreetAgain() {
        this.onEnterStreet(-771214336);
    }

    private void onEnterStreet(int n) {
        this.destinationInputService.selectStreetInput(new DestinationInputStreetController$2(this, n));
    }

    void notifyEnterStreetSucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    private void checkEntryMode(int n) {
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            DestinationInputOneShotController.enterOneShot();
        } else if (!this.destinationInputService.isStreetAvailable() || !this.destinationInputService.isCitySelected()) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord()) {
                DestinationInputCityController.enterCityFirst();
            } else {
                Framework.fireUIEvent(-301452288);
            }
        } else {
            this.onEnterStreet(n);
        }
    }

    public void selectNextPossibleEntryMode() {
        if (StartEntryMode.getMode() == 8) {
            DestinationInputCrossingController.enterCrossing();
        } else {
            DestinationInputHouseNumberController.enterHouseNumber();
        }
    }
}


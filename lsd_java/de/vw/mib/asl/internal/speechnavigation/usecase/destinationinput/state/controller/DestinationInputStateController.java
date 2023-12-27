/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController$2;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputStateController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_STATE;
    public static final int FIRST_CMD_ENTER_STATE;
    public static final int CMD_DLG_STATE;
    private static final int CMD_DLG_ENTER_COUNTRY;
    private static final int CMD_DLG_STATE_AGAIN_NBEST_CITY;

    public DestinationInputStateController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141959: {
                super.onRequestItems();
                break;
            }
            case 1077141883: {
                DestinationInputCountryController.enterCountry();
                break;
            }
            case 1077141954: {
                this.onEnterStateAgain();
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
            case 1640005: {
                this.checkEntryMode();
                this.onEnteringState(705246208);
                break;
            }
            case 1640006: {
                this.checkEntryMode();
                this.onEnteringState(822686720);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    private void checkEntryMode() {
        if (!this.destinationInputService.isCountryStateAvailable()) {
            DestinationInputCountryStateController.enterCountryStateFirst();
        }
    }

    public static void enterState() {
        Framework.fireEvent(1158027520);
    }

    public static void enterStateFirst() {
        Framework.fireEvent(1174804736);
    }

    private void onEnterStateAgain() {
        this.onEnteringState(805909504);
    }

    private void onEnteringState(int n) {
        this.destinationInputService.selectStateInput(new DestinationInputStateController$1(this, n));
    }

    void notifyEnteringStateSucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(789132288);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onStateSelected();
    }

    private void onStateSelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setState(new DestinationInputStateController$2(this), viewModelItem);
    }

    void notifyStateSelected() {
        this.selectNextPossibleEntryMode();
    }

    private void selectNextPossibleEntryMode() {
        if (this.destinationInputService.isCityAvailable()) {
            DestinationInputCityController.enterCity();
        } else if (this.destinationInputService.isZipAvailable()) {
            DestinationInputPostalCodeController.enterPostalCode();
        } else {
            Framework.fireUIEvent(-1291308032);
        }
    }
}


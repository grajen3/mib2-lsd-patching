/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputCityController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_CITY;
    public static final int FIRST_CMD_ENTER_CITY;
    public static final int CMD_DLG_CITY;
    private static final int CMD_DLG_STATE_AGAIN_NBEST_CITY;
    public static final int CMD_DLG_REENTER_COUNTRY;
    public static final int CMD_DLG_REENTER_STATE;
    private static final int CONST_ENTRY_MODE_NORMAL;
    private static final int CONST_ENTRY_MODE_FIRST;
    private static boolean cityEnteredGlobally;

    public DestinationInputCityController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141902: {
                super.onRequestItems();
                break;
            }
            case 1077141903: {
                this.onEnterCityAgain();
                break;
            }
            case 1077141960: {
                DestinationInputCountryController.enterCountry();
                break;
            }
            case 1077142008: {
                DestinationInputStateController.enterState();
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
            case 1640009: {
                this.checkEntryMode(0, -1308085248);
                break;
            }
            case 1640010: {
                this.checkEntryMode(1, -855100416);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    private void checkEntryMode(int n, int n2) {
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot() && this.variantService.isOneshotAvailable() && this.destinationInputService.isCountrySelected()) {
                if (n == 1) {
                    DestinationInputOneShotController.enterOneShotFirst();
                } else {
                    DestinationInputOneShotController.enterOneShot();
                }
            } else {
                this.onActionFailed();
            }
        } else if (!this.destinationInputService.isCityAvailable() || !this.destinationInputService.isCountrySelected()) {
            if (this.variantService.isNARVariant() && this.destinationInputService.isCountryStateSelected()) {
                DestinationInputStateController.enterStateFirst();
            } else {
                DestinationInputCountryController.enterCountryFirst();
            }
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot() && this.variantService.isOneshotAvailable()) {
            if (n == 1) {
                DestinationInputOneShotController.enterOneShotFirstByCity();
            } else if (cityEnteredGlobally) {
                DestinationInputOneShotController.enterOneShotByCity();
            } else {
                DestinationInputOneShotController.enterOneShot();
            }
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord()) {
            this.onEnteringCity(n2);
        } else {
            Framework.fireUIEvent(-301452288);
        }
    }

    public static void enterCity() {
        cityEnteredGlobally = false;
        Framework.fireEvent(1225136384);
    }

    public static void enterCityGlobally() {
        cityEnteredGlobally = true;
        Framework.fireEvent(1225136384);
    }

    public static void enterCityFirst() {
        Framework.fireEvent(1241913600);
    }

    private void onEnterCityAgain() {
        this.onEnteringCity(-871877632);
    }

    private void onEnteringCity(int n) {
        this.destinationInputService.selectCityInput(new DestinationInputCityController$1(this, n));
    }

    void notifyEnteringCitySucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(-1022872576);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onCitySelected();
    }

    private void onCitySelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setCity(new DestinationInputCityController$2(this), viewModelItem);
    }

    void notifyCitySelected() {
        this.selectNextPossibleEntryMode();
    }

    private void selectNextPossibleEntryMode() {
        if (this.destinationInputService.isStreetAvailable()) {
            DestinationInputStreetController.enterStreet();
        } else if (this.destinationInputService.getCurrentInput().isValid()) {
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        } else {
            Framework.fireUIEvent(-1224199168);
        }
    }

    static {
        cityEnteredGlobally = false;
    }
}


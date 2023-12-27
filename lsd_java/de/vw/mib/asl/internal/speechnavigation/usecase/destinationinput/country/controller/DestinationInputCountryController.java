/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputCountryController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_COUNTRY;
    public static final int FIRST_CMD_ENTER_COUNTRY;
    public static final int CMD_DLG_COUNTRY_X;
    private static final int CMD_DLG_STATE_AGAIN_NBEST_COUNTRY;

    public DestinationInputCountryController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141900: {
                super.onRequestItems();
                break;
            }
            case 1077141901: {
                this.onEnterCountryAgain(-922209280);
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
            case 1640003: {
                this.onEnterCountry(-1341639680);
                break;
            }
            case 1640004: {
                this.onEnterCountry(-905432064);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterCountry() {
        Framework.fireEvent(1124473088);
    }

    public static void enterCountryFirst() {
        Framework.fireEvent(1141250304);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(-1039649792);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onCountrySelected();
    }

    private void onCountrySelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setCountry(new DestinationInputCountryController$1(this), viewModelItem);
    }

    void notifyCountrySelected() {
        this.selectNextPossibleEntryMode();
    }

    private void onEnterCountryAgain(int n) {
        this.onEnterCountry(n);
    }

    private void onEnterCountry(int n) {
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            this.onActionFailed();
        } else if (this.variantService.isNARVariant()) {
            DestinationInputCountryStateController.enterCountryState();
        } else {
            this.destinationInputService.selectCountryInput(new DestinationInputCountryController$2(this, n));
        }
    }

    void notifyEnterCountrySucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    public void selectNextPossibleEntryMode() {
        if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() || this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot()) {
            if (this.destinationInputService.isCityAvailable()) {
                DestinationInputCityController.enterCity();
            } else if (this.destinationInputService.isZipAvailable()) {
                DestinationInputPostalCodeController.enterPostalCode();
            } else {
                Framework.fireUIEvent(-1291308032);
            }
        } else {
            Framework.fireUIEvent(-301452288);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputPostalCodeController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_POSTAL_CODE;
    public static final int CMD_DLG_POSTAL_CODE;
    public static final int CMD_DLG_REENTER_COUNTRY;
    public static final int CMD_DLG_REENTER_STATE;
    private static final int CMD_DLG_STATE_AGAIN_NBEST_POSTAL_CODE;

    public DestinationInputPostalCodeController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141904: {
                super.onRequestItems();
                break;
            }
            case 1077142009: {
                DestinationInputCountryController.enterCountry();
                break;
            }
            case 1077142010: {
                DestinationInputStateController.enterState();
                break;
            }
            case 1077141905: {
                this.onEnterPostalCodeAgain();
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
            case 1640011: {
                this.checkEntryMode();
                this.onEnterPostalCode();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterPostalCode() {
        Framework.fireEvent(1258690816);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(-1006095360);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onPostalCodeSelected();
    }

    private void onPostalCodeSelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setPostalCode(new DestinationInputPostalCodeController$1(this), viewModelItem);
    }

    void notifyPostalCodeSelected() {
        this.selectNextPossibleEntryMode();
    }

    private void onEnterPostalCodeAgain() {
        this.onEnterPostalCode();
    }

    private void onEnterPostalCode() {
        this.destinationInputService.selectPostalCodeInput(new DestinationInputPostalCodeController$2(this));
    }

    void notifyEnterPostalCodeSucceeded(INavigationLocation iNavigationLocation) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(-1274530816);
    }

    private void checkEntryMode() {
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            DestinationInputOneShotController.enterOneShot();
        } else if (!this.destinationInputService.isZipAvailable() || !this.destinationInputService.isCountrySelected()) {
            DestinationInputCountryController.enterCountryFirst();
        }
    }

    public void selectNextPossibleEntryMode() {
        if (this.destinationInputService.isStreetAvailable()) {
            DestinationInputStreetController.enterStreet();
        } else if (this.destinationInputService.getCurrentInput().isValid()) {
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        } else {
            Framework.fireUIEvent(-1224199168);
        }
    }
}


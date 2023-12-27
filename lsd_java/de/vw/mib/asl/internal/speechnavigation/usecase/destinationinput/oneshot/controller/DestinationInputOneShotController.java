/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController$3;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController$4;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController$5;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController$6;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputOneShotController
extends DestinationInputOneShotControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int RESUME_CMD_ENTER_ADDRESS;
    public static final int FIRST_CMD_ENTER_ADDRESS;
    public static final int AGAIN_CMD_ENTER_ADDRESS;
    public static final int RESUME_CMD_ENTER_ADDRESS_BY_CITY;
    public static final int FIRST_CMD_ENTER_ADDRESS_BY_CITY;
    public static final int AGAIN_CMD_ENTER_ADDRESS_BY_CITY;
    public static final int CMD_DLG_STATE_AGAIN_NBEST_ADDRESS;
    public static final int CMD_DLG_FULL_ADDRESS_EU;
    public static final int CMD_DLG_REENTER_COUNTRY;
    public static final int CMD_DLG_REENTER_STATE;
    public static final int CMD_DLG_REENTER_ZIP;
    public static final int PREPARE_CITY_INPUT;
    private boolean isSUIInput = false;

    public DestinationInputOneShotController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public int getListIdTopLevel() {
        return 2064135168;
    }

    @Override
    public int getListIdDetailLevel() {
        return 2080912384;
    }

    @Override
    public int getListIdSelectedItem() {
        return 2097689600;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141928: {
                super.onRequestItems();
                this.isSUIInput = false;
                break;
            }
            case 1077141929: {
                DestinationInputOneShotController.enterOneShotAgain();
                this.isSUIInput = false;
                break;
            }
            case 1077142011: {
                DestinationInputCountryController.enterCountry();
                this.isSUIInput = false;
                break;
            }
            case 1077142012: {
                DestinationInputStateController.enterState();
                this.isSUIInput = false;
                break;
            }
            case 1077142013: {
                DestinationInputPostalCodeController.enterPostalCode();
                this.isSUIInput = false;
                break;
            }
            default: {
                super.onRecognizedEvent(n);
                this.isSUIInput = false;
            }
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640030: {
                this.checkEntryMode();
                this.onEnteringOneShot(101266432);
                this.isSUIInput = false;
                break;
            }
            case 1640031: {
                this.checkEntryMode();
                this.onEnteringOneShot(554251264);
                this.isSUIInput = false;
                break;
            }
            case 1640032: {
                this.checkEntryMode();
                this.onEnteringOneShot(520696832);
                this.isSUIInput = false;
                break;
            }
            case 1640034: {
                this.checkEntryMode();
                this.onEnteringOneShot(537474048);
                this.isSUIInput = false;
                break;
            }
            case 1640035: {
                this.checkEntryMode();
                this.onEnteringOneShot(554251264);
                this.isSUIInput = false;
                break;
            }
            case 1640036: {
                this.checkEntryMode();
                this.onEnteringOneShot(571028480);
                this.isSUIInput = false;
                break;
            }
            case 1077141957: {
                OneShotModel oneShotModel = (OneShotModel)eventGeneric.getObject(0);
                ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new OneShotModel[]{oneShotModel});
                this.checkEntryMode();
                this.prepareInputCity();
                this.isSUIInput = true;
                break;
            }
            case 1077141958: {
                this.selectCity();
                break;
            }
            case 1077141932: {
                this.prepareInputStreet();
                break;
            }
            case 1077141933: {
                this.selectStreet();
                break;
            }
            case 1077141934: {
                this.prepareInputHouseNumber();
                break;
            }
            case 1077141935: {
                this.selectHouseNumber();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    void checkEntryMode() {
        if (!this.destinationInputService.isCityAvailable() || !this.destinationInputService.isCountrySelected()) {
            if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
                this.onActionFailed();
            } else {
                DestinationInputCountryController.enterCountryFirst();
            }
        } else if (!this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot() || !this.variantService.isOneshotAvailable()) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && !this.variantService.isCHNVariant() && !this.variantService.isTWNVariant()) {
                DestinationInputCityController.enterCity();
            } else {
                Framework.fireUIEvent(-301452288);
                throw new NavigationServiceException(" sds not supported for current country ");
            }
        }
    }

    public static void enterOneShot() {
        Framework.fireEvent(1577457920);
    }

    public static void enterOneShotFirst() {
        Framework.fireEvent(1594235136);
    }

    public static void enterOneShotAgain() {
        Framework.fireEvent(1611012352);
    }

    public static void enterOneShotByCity() {
        Framework.fireEvent(1644566784);
    }

    public static void enterOneShotFirstByCity() {
        Framework.fireEvent(1661344000);
    }

    public static void enterOneShotAgainByCity() {
        Framework.fireEvent(1678121216);
    }

    void onEnteringOneShot(int n) {
        this.destinationInputService.selectCityInput(new DestinationInputOneShotController$1(this, n));
    }

    void notifyEnteringOneShotSucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            Framework.updateUIValue(-1962396672, StartEntryMode.getMode());
        }
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        OneShotModel oneShotModel = (OneShotModel)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
        Framework.updateUIValue(-1895287808, oneShotModel.getNbestHeadlineText(this.variantService.isNARVariant()));
        Framework.fireUIEvent(-16239616);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.selectCity();
    }

    private void prepareInputCity() {
        this.destinationInputService.selectCityInput(new DestinationInputOneShotController$2(this));
    }

    void notifyInputCityPrepared() {
        Framework.fireUIEvent(889795584);
    }

    private void selectCity() {
        OneShotModel oneShotModel = (OneShotModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setCity(new DestinationInputOneShotController$3(this, oneShotModel), oneShotModel.city);
    }

    void notifyCitySelected(OneShotModel oneShotModel) {
        super.updateLocation(this.destinationInputService.getCurrentInput());
        if (this.destinationInputService.isStreetAvailable() && oneShotModel.isStreetValid()) {
            Framework.fireUIEvent(134820864);
        } else if (this.destinationInputService.isStreetAvailable() && !this.variantService.isCHNVariant() && !this.variantService.isTWNVariant()) {
            DestinationInputStreetController.enterStreet();
        } else if (this.destinationInputService.getCurrentInput().isValid()) {
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        } else {
            this.onActionFailed();
        }
    }

    private void prepareInputStreet() {
        this.destinationInputService.selectStreetInput(new DestinationInputOneShotController$4(this));
    }

    void notifyInputStreetPrepared() {
        Framework.fireUIEvent(151598080);
    }

    private void selectStreet() {
        OneShotModel oneShotModel = (OneShotModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setStreet(new DestinationInputOneShotController$5(this, oneShotModel), oneShotModel.street);
    }

    void notifyStreetSelected(OneShotModel oneShotModel) {
        super.updateLocation(this.destinationInputService.getCurrentInput());
        if (this.destinationInputService.isHouseNumberAvailable() && oneShotModel.isHouseNumberValid()) {
            Framework.fireUIEvent(168375296);
        } else if (!this.variantService.isCHNVariant() && !this.variantService.isTWNVariant()) {
            if (StartEntryMode.getMode() == 8) {
                DestinationInputCrossingController.enterCrossing();
            } else {
                DestinationInputHouseNumberController.enterHouseNumber();
            }
        } else {
            DestinationInputCrossingController.enterCrossingViaOneshot();
        }
    }

    void prepareInputHouseNumber() {
        this.destinationInputService.selectHouseNumberInput(new DestinationInputOneShotController$6(this));
    }

    void notifyInputHouseNumberPrepared() {
        Framework.fireUIEvent(185152512);
    }

    private void selectHouseNumber() {
        OneShotModel oneShotModel = (OneShotModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        if (this.isSUIInput) {
            DestinationInputHouseNumberController.enterHouseNumberSUIOneShot(oneShotModel.houseNumber);
        } else {
            DestinationInputHouseNumberController.enterHouseNumberOneShot(oneShotModel.houseNumber);
        }
    }
}


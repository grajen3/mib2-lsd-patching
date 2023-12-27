/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController$3;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController$4;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.model.CountryStateModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputCountryStateController
extends DestinationInputCountryStateControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int RESUME_CMD_ENTER_COUNTRY_STATE;
    public static final int FIRST_CMD_ENTER_COUNTRY_STATE;
    public static final int CMD_DLG_STATE_AGAIN_NBEST_COUNTRY_STATE;
    public static final int CMD_DLG_COUNTRY_STATE;

    public DestinationInputCountryStateController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public int getListIdTopLevel() {
        return -2012728320;
    }

    @Override
    public int getListIdDetailLevel() {
        return -1995951104;
    }

    @Override
    public int getListIdSelectedItem() {
        return -1979173888;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141951: {
                super.onRequestItems();
                break;
            }
            case 1077141952: {
                this.enterCountryStateAgain();
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
            case 1640007: {
                this.onEnteringCountryState(688468992);
                break;
            }
            case 1640008: {
                this.onEnteringCountryState(755577856);
                break;
            }
            case 1077141955: {
                this.prepareInputState();
                break;
            }
            case 1077141956: {
                this.selectState();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterCountryState() {
        Framework.fireEvent(1191581952);
    }

    public static void enterCountryStateFirst() {
        Framework.fireEvent(1208359168);
    }

    private void enterCountryStateAgain() {
        this.onEnteringCountryState(738800640);
    }

    private void onEnteringCountryState(int n) {
        this.destinationInputService.selectCountryInput(new DestinationInputCountryStateController$1(this, n));
    }

    void notifyEnteringCountryStateSucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(722023424);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onCountrySelected();
    }

    private void onCountrySelected() {
        CountryStateModel countryStateModel = (CountryStateModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setCountry(new DestinationInputCountryStateController$2(this, countryStateModel), countryStateModel.country);
    }

    void notifyCountryStateSelected(CountryStateModel countryStateModel) {
        if (this.destinationInputService.isCountryStateAvailable() && countryStateModel.isStateValid()) {
            Framework.fireUIEvent(856241152);
        } else if (this.destinationInputService.isCountryStateAvailable() && this.variantService.isNARVariant()) {
            DestinationInputStateController.enterState();
        } else if (!this.destinationInputService.isCountryStateAvailable()) {
            DestinationInputCityController.enterCity();
        } else {
            this.onActionFailed();
        }
    }

    private void prepareInputState() {
        this.destinationInputService.selectStateInput(new DestinationInputCountryStateController$3(this));
    }

    void notifyInputStatePrepared() {
        Framework.fireUIEvent(873018368);
    }

    private void selectState() {
        CountryStateModel countryStateModel = (CountryStateModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setState(new DestinationInputCountryStateController$4(this), countryStateModel.state);
    }

    void notifyStateSelected() {
        if (this.destinationInputService.isCityAvailable()) {
            DestinationInputCityController.enterCity();
        } else if (this.destinationInputService.isZipAvailable()) {
            DestinationInputPostalCodeController.enterPostalCode();
        } else {
            Framework.fireUIEvent(-1291308032);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.DestinationInputJpnFormatter;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputLocationCollector;

public class DestinationInputHouseNumberController
extends ApplicationListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int RESUME_CMD_ENTER_HOUSENUMBER;
    public static final int RESUME_CMD_ENTER_HOUSENUMBER_ONESHOT;
    public static final int CMD_DLG_HN_STANDARD;
    public static final int CMD_DLG_START_GUIDANCE;
    public static final int CMD_DLG_ENTER_AGAIN;
    public static final int CMD_DLG_NEAREST_HNO;
    public static final int CMD_DLG_ENTER_CROSSING;
    public static final int CMD_DLG_NEAREST_HELP;
    protected final DestinationInputService destinationInputService;
    protected final HouseNumberDataService service;
    protected final ApplicationVariant variantService;
    private final ResultItemHandler itemHandler;
    protected static boolean enteredViaOneshot;
    private static boolean isSUIInput;

    public DestinationInputHouseNumberController(HouseNumberDataService houseNumberDataService, ResultItemRowNumberHandler resultItemRowNumberHandler, ResultItemHandler resultItemHandler) {
        super(houseNumberDataService, resultItemRowNumberHandler);
        this.itemHandler = resultItemHandler;
        this.service = houseNumberDataService;
        this.destinationInputService = NavigationDestinationInputServiceAdapter.getService();
        this.variantService = new ApplicationVariantImpl();
    }

    public static void enterHouseNumber() {
        enteredViaOneshot = false;
        Framework.fireEvent(1309022464);
    }

    public static void enterHouseNumberOneShot(HouseNumber houseNumber) {
        enteredViaOneshot = true;
        isSUIInput = false;
        Framework.fireEvent(1862670592, houseNumber);
    }

    public static void enterHouseNumberSUIOneShot(HouseNumber houseNumber) {
        enteredViaOneshot = true;
        isSUIInput = true;
        Framework.fireEvent(1862670592, houseNumber);
    }

    @Override
    public int getListIdTopLevel() {
        return 2013803520;
    }

    @Override
    public int getListIdSelectedItem() {
        return 2030580736;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141908: {
                HouseNumber houseNumber = new HouseNumber(0, this.itemHandler.getResultItem().getIdentifier());
                this.service.setHouseNumberLike(houseNumber);
                Framework.updateUIValue(-1945619456, houseNumber.recognizedString);
                super.onRequestItems();
                break;
            }
            case 1077141913: {
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
                break;
            }
            case 1077141926: {
                this.selectNearestHouseNumber();
                break;
            }
            case 1077141927: {
                this.onEnterHouseNumberAgain();
                break;
            }
            case 1077141963: {
                if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
                    DestinationInputCrossingController.enterCrossingViaOneshot();
                    break;
                }
                DestinationInputCrossingController.enterCrossing();
                break;
            }
            case 1077141964: {
                Framework.fireUIEvent(906572800);
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
            case 1640014: {
                this.checkEntryMode();
                break;
            }
            case 1640047: {
                HouseNumber houseNumber = (HouseNumber)eventGeneric.getObject(0);
                this.service.setHouseNumberLike(houseNumber);
                Framework.updateUIValue(-1945619456, houseNumber.recognizedString);
                super.onRequestItems();
                break;
            }
            case 1077141913: {
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void notifyItemsRequested() {
        if (this.destinationInputService.arePointLocationHouseNumbersAvailable()) {
            if (this.service.isHousenumberNone() && this.service.getAvailableItemsCount() == 0) {
                AppLogger.trace(this, ".notifyItemsRequested(), handle [pointlocation_hn_input, hn_none] ");
                Framework.fireUIEvent(1695101952);
            } else if (this.service.isHousenumberUnique() && this.service.getAvailableItemsCount() == 1) {
                AppLogger.trace(this, ".notifyItemsRequested(), handle [pointlocation_hn_input, hn_unique_match] ");
                HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
                ListManager.getASLList(this.getListIdSelectedItem()).updateList(new HouseNumber[]{houseNumber});
                this.onHouseNumberSelected();
            } else if (this.service.isHousenumberAlternatives() && this.service.getAvailableItemsCount() == 1) {
                AppLogger.trace(this, ".notifyItemsRequested(), handle [pointlocation_hn_input, hn_nearest_alternative] ");
                Framework.fireUIEvent(-66571264);
            } else if (this.service.isHousenumberMatchesFound() && this.service.getAvailableItemsCount() > 1) {
                AppLogger.trace(this, ".notifyItemsRequested(), handle [pointlocation_hn_input, hn_multiple] ");
                Framework.fireUIEvent(1711879168);
            }
        } else if (this.service.isHousenumberUnique()) {
            AppLogger.trace(this, ".notifyItemsRequested(), handle [standard_hn_input, hn_unique] ");
            HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
            ListManager.getASLList(this.getListIdSelectedItem()).updateList(new HouseNumber[]{houseNumber});
            this.onHouseNumberSelected();
        } else if (this.service.isHousenumberAlternatives()) {
            AppLogger.trace(this, ".notifyItemsRequested(), handle [standard_hn_input, hn_nearest_alternative] ");
            Framework.fireUIEvent(-66571264);
        } else if (this.service.isHousenumberNone()) {
            AppLogger.error(this, ".notifyItemsRequested(), handle [standard_hn_input, hn_none] ");
            this.onActionFailed();
        } else {
            AppLogger.error(this, ".notifyItemsRequested(), handle [standard_hn_input, hn_multiple] incompatible");
            this.onActionFailed();
        }
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onHouseNumberSelected();
    }

    private void onEnterHouseNumberAgain() {
        this.onEnteringHouseNumber(67712000);
    }

    protected void onEnteringHouseNumber(int n) {
        this.destinationInputService.selectHouseNumberInput(new DestinationInputHouseNumberController$1(this, n));
    }

    protected void onHouseNumberSelected() {
        HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setHouseNumber(new DestinationInputHouseNumberController$2(this), houseNumber);
    }

    private void selectNearestHouseNumber() {
        HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
        ListManager.getASLList(this.getListIdSelectedItem()).updateList(new HouseNumber[]{houseNumber});
        this.onHouseNumberSelected();
    }

    void notifyHouseNumberSelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        if (!isSUIInput && ListManager.getGenericASLList(2064135168).getDSIObjects().length > 1 && enteredViaOneshot) {
            DestinationInputDetailController.startGuidanceWithoutDetailView(this.destinationInputService.getCurrentInput());
        } else if (isSUIInput && ListManager.getGenericASLList(-2146946048).getDSIObjects().length > 1 && enteredViaOneshot) {
            DestinationInputDetailController.startGuidanceWithoutDetailView(this.destinationInputService.getCurrentInput());
        } else {
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        }
    }

    void notifyEnterHouseNumberSucceeded(INavigationLocation iNavigationLocation, int n) {
        this.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    private void updateLocation(INavigationLocation iNavigationLocation) {
        SpeechNavigationControllerDestinationInputLocationCollector speechNavigationControllerDestinationInputLocationCollector = new SpeechNavigationControllerDestinationInputLocationCollector();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country = iNavigationLocation.getCountry();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_city = iNavigationLocation.getTown();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_postal_code = iNavigationLocation.getZipCode();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_street = iNavigationLocation.getStreet();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_housenumber = iNavigationLocation.getHousenumber();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_crossing = iNavigationLocation.getJunction();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country_code = iNavigationLocation.getCountryAbbreviation();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_guideable = iNavigationLocation.isValid();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_province = iNavigationLocation.getState();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_state = iNavigationLocation.getState();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_prefecture = iNavigationLocation.getPrefecture();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_municipality = DestinationInputJpnFormatter.getCompleteMunicipality(iNavigationLocation);
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_place = iNavigationLocation.getPlace();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_chome = iNavigationLocation.getChome();
        ListManager.getGenericASLList(1560818688).updateList(new SpeechNavigationControllerDestinationInputLocationCollector[]{speechNavigationControllerDestinationInputLocationCollector});
    }

    protected void checkEntryMode() {
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            DestinationInputOneShotController.enterOneShot();
            return;
        }
        if (!this.destinationInputService.isStreetSelected()) {
            DestinationInputStreetController.enterStreetFirst();
        } else if (!this.destinationInputService.isHouseNumberAvailable()) {
            this.selectNextPossibleEntryMode();
        } else {
            this.onEnteringHouseNumber(-1207421952);
        }
    }

    private void selectNextPossibleEntryMode() {
        if (this.destinationInputService.isCrossingAvailable()) {
            Framework.fireUIEvent(-100125696);
            DestinationInputCrossingController.enterCrossingNoHousenumber();
        } else {
            Framework.fireUIEvent(-83348480);
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        }
    }

    static {
        enteredViaOneshot = false;
        isSUIInput = false;
    }
}


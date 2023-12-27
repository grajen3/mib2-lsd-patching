/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$10;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$11;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$3;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$4;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$5;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$6;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$7;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$8;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController$9;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputOneShotJpnController
extends DestinationInputOneShotControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputOneShotJpnController] ";
    public static final int RESUME_CMD_ENTER_ADDRESS;
    public static final int AGAIN_CMD_ENTER_ADDRESS;
    public static final int CMD_DLG_STATE_AGAIN_ADDRESS_JPN;
    public static final int CMD_DLG_FULL_ADDRESS_JPN;
    public static final int PREPARE_PREFECTURE_INPUT;
    private final DestinationDetailListener destinationInputAgainListener;
    private boolean isSUIInput = false;

    public DestinationInputOneShotJpnController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler, DestinationDetailListener destinationDetailListener) {
        super(additionalDataService, resultListHandler);
        this.destinationInputAgainListener = destinationDetailListener;
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
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_FULL_ADDRESS_JPN.").toString());
                super.onRequestItems();
                this.isSUIInput = false;
                break;
            }
            case 1077141929: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_STATE_AGAIN_ADDRESS_JPN.").toString());
                this.destinationInputAgainListener.onReEnterAddress(true);
                this.isSUIInput = false;
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
            case 1640030: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received RESUME_CMD_ENTER_ADDRESS.").toString());
                this.checkEntryMode();
                this.onEnteringOneShot(1544107008);
                this.isSUIInput = false;
                break;
            }
            case 1640032: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received AGAIN_CMD_ENTER_ADDRESS.").toString());
                this.checkEntryMode();
                this.onEnteringOneShot(1560884224);
                this.isSUIInput = false;
                break;
            }
            case 1077142006: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received PREPARE_PREFECTURE_INPUT.").toString());
                OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)eventGeneric.getObject(0);
                ListManager.getGenericASLList(this.getListIdSelectedItem()).updateList(new OneShotJpnModel[]{oneShotJpnModel});
                this.checkEntryMode();
                this.prepareInputPrefecture();
                this.isSUIInput = true;
                break;
            }
            case 1077142007: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received SELECT_PREFECTURE.").toString());
                this.selectPrefecture();
                break;
            }
            case 1077141979: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received PREPARE_MUNICIPALITY_INPUT.").toString());
                this.prepareInputMunicipality();
                break;
            }
            case 1077141980: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received SELECT_MUNICIPALITY.").toString());
                this.selectMunicipality();
                break;
            }
            case 1077141981: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received PREPARE_PLACE_INPUT.").toString());
                this.prepareInputPlace();
                break;
            }
            case 1077141982: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received SELECT_PLACE.").toString());
                this.selectPlace();
                break;
            }
            case 1077141983: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received PREPARE_CHOME_INPUT.").toString());
                this.prepareInputChome();
                break;
            }
            case 1077141984: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received SELECT_CHOME.").toString());
                this.selectChome();
                break;
            }
            case 1077141934: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received PREPARE_HOUSE_NUMBER_INPUT.").toString());
                this.prepareInputHouseNumber();
                break;
            }
            case 1077141935: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received SELECT_HOUSE_NUMBER.").toString());
                this.selectHouseNumber();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    private void checkEntryMode() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Checking entry mode for oneshot.").toString());
        boolean bl = false;
        if (!this.destinationInputService.isPrefectureAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No prefectures available, so no SDS address input possible.").toString());
            bl = true;
        }
        if (!this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot() || !this.variantService.isOneshotAvailable()) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord()) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Oneshot not available, but fullword is, so start prefecture multistep input.").toString());
                DestinationInputPrefectureController.enterPrefecture();
            } else {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Oneshot and fullword not available, so no SDS address input possible.").toString());
                bl = true;
            }
        }
        if (bl) {
            Framework.fireUIEvent(-301452288);
            throw new NavigationServiceException(" SDS not supported for current country ");
        }
    }

    public static void enterOneShot() {
        Framework.fireEvent(1577457920);
    }

    public static void enterOneShotAgain() {
        Framework.fireEvent(1611012352);
    }

    private void onEnteringOneShot(int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Start a JPN oneshot input by opening the speller for prefectures.").toString());
        this.destinationInputService.selectPrefectureInput(new DestinationInputOneShotJpnController$1(this, n));
    }

    protected void notifyEnteringOneShotSucceeded(INavigationLocation iNavigationLocation, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Starting oneshot succeeded, update location and open dialog.").toString());
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
        Framework.updateUIValue(-1895287808, oneShotJpnModel.getNbestHeadlineText());
        Framework.fireUIEvent(1577661440);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.selectPrefecture();
    }

    private void prepareInputPrefecture() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Open speller for prefecture input.").toString());
        this.destinationInputService.selectPrefectureInput(new DestinationInputOneShotJpnController$2(this));
    }

    protected void notifyInputPrefecturePrepared() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Prefecture input prepared successfully.").toString());
        Framework.fireUIEvent(1745433600);
    }

    private void selectPrefecture() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Try to set the prefecture from address given in the oneshot.").toString());
        OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setPrefecture(new DestinationInputOneShotJpnController$3(this, oneShotJpnModel), oneShotJpnModel.prefecture);
    }

    protected void notifyPrefectureSelected(OneShotJpnModel oneShotJpnModel) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Prefecture from oneshot address has been set.").toString());
        if (oneShotJpnModel.isMunicipalityValid() && this.destinationInputService.isMunicipalityAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Municipality is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1426666496);
        } else if (oneShotJpnModel.isPlaceValid() && this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No municipality given, place is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1460220928);
        } else if (oneShotJpnModel.isChomeValid() && this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No municipality and place given, chome is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1493775360);
        } else if (oneShotJpnModel.isHouseNumberValid() && this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No municipality and place and chome given, housenumber is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1527329792);
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isMunicipalityAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture given, so start municipality multistep input.").toString());
            DestinationInputMunicipalityController.enterMunicipality();
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture given, municipality not available, place available, so start place multistep input.").toString());
            DestinationInputPlaceController.enterPlace();
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture given, municipality and place not available, chome available, so start chome multistep input.").toString());
            DestinationInputChomeController.enterChome();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture given, municipality and place and chome not available, so start housenumber multistep input.").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }

    private void prepareInputMunicipality() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Open speller for municipality input.").toString());
        this.destinationInputService.selectMunicipalityInput(new DestinationInputOneShotJpnController$4(this));
    }

    protected void notifyInputMunicipalityPrepared() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Municipality input prepared successfully.").toString());
        Framework.fireUIEvent(1443443712);
    }

    private void selectMunicipality() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Try to set the municipality from address given in the oneshot.").toString());
        OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setMunicipality(new DestinationInputOneShotJpnController$5(this, oneShotJpnModel), oneShotJpnModel.municipality);
    }

    protected void notifyMunicipalitySelected(OneShotJpnModel oneShotJpnModel) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Municipality from oneshot address has been set.").toString());
        if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isWardAvailable() && !this.destinationInputService.isPlaceAvailable() && !this.destinationInputService.isChomeAvailable() && !this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and municipality given, ward available, so start ward multistep input.").toString());
            DestinationInputWardController.enterWard();
        } else if (oneShotJpnModel.isPlaceValid() && this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Place is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1460220928);
        } else if (oneShotJpnModel.isChomeValid() && this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No place given, chome is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1493775360);
        } else if (oneShotJpnModel.isHouseNumberValid() && this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No place and chome given, housenumber is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1527329792);
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and municipality given, so start place multistep input.").toString());
            DestinationInputPlaceController.enterPlace();
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and municipality given, place not available, chome available, so start chome multistep input.").toString());
            DestinationInputChomeController.enterChome();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and municipality given, place and chome not available, so start housenumber multistep input.").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }

    private void prepareInputPlace() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Open speller for place input.").toString());
        this.destinationInputService.selectPlaceInput(new DestinationInputOneShotJpnController$6(this));
    }

    protected void notifyInputPlacePrepared() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Place input prepared successfully.").toString());
        Framework.fireUIEvent(1476998144);
    }

    private void selectPlace() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Try to set the place from address given in the oneshot.").toString());
        OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setPlace(new DestinationInputOneShotJpnController$7(this, oneShotJpnModel), oneShotJpnModel.place);
    }

    protected void notifyPlaceSelected(OneShotJpnModel oneShotJpnModel) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Place from oneshot address has been set.").toString());
        if (oneShotJpnModel.isChomeValid() && this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Chome is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1493775360);
        } else if (oneShotJpnModel.isHouseNumberValid() && this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No chome given, housenumber is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1527329792);
        } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and (municipality and/or place) given, so start chome multistep input.").toString());
            DestinationInputChomeController.enterChome();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and (municipality and/or place) given, chome not available, so start housenumber multistep input.").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }

    private void prepareInputChome() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Open speller for chome input.").toString());
        this.destinationInputService.selectChomeInput(new DestinationInputOneShotJpnController$8(this));
    }

    protected void notifyInputChomePrepared() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Chome input prepared successfully.").toString());
        Framework.fireUIEvent(1510552576);
    }

    private void selectChome() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Try to set the chome from address given in the oneshot.").toString());
        OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setChome(new DestinationInputOneShotJpnController$9(this, oneShotJpnModel), oneShotJpnModel.chome);
    }

    protected void notifyChomeSelected(OneShotModel oneShotModel) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Chome from oneshot address has been set.").toString());
        if (oneShotModel.isHouseNumberValid() && this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Hosuenumber is part of address and possible as next input, so validate this address part next.").toString());
            Framework.fireUIEvent(1527329792);
        } else if (oneShotModel.isHouseNumberValid() && !this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Housenumber entered in oneshot but no housenumbers available.").toString());
            Framework.fireUIEvent(1611215872);
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Only prefecture and (municipality and/or place and/or chome) given, so start housenumber multistep input.").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }

    private void prepareInputHouseNumber() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Open speller for housenumber input.").toString());
        this.destinationInputService.selectHouseNumberInput(new DestinationInputOneShotJpnController$10(this));
    }

    protected void notifyInputHouseNumberPrepared() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Housenumber input prepared successfully.").toString());
        Framework.fireUIEvent(185152512);
    }

    private void selectHouseNumber() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Continue with housenumber validation.").toString());
        OneShotJpnModel oneShotJpnModel = (OneShotJpnModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        if (!oneShotJpnModel.houseNumber.isObjectIdValid()) {
            DestinationInputHouseNumberControllerJPN.enterHouseNumberOneShot(oneShotJpnModel.houseNumber);
            return;
        }
        this.destinationInputService.setHouseNumber(new DestinationInputOneShotJpnController$11(this), oneShotJpnModel.houseNumber);
    }

    void notifyHouseNumberSelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        int n = this.isSUIInput ? ListManager.getGenericASLList(-2146946048).getDSIObjects().length : ListManager.getGenericASLList(2064135168).getDSIObjects().length;
        if (n > 1) {
            DestinationInputDetailController.startGuidanceWithoutDetailView(this.destinationInputService.getCurrentInput());
        } else {
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        }
    }
}


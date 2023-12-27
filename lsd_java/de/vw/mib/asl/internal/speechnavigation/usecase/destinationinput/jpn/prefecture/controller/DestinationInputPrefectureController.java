/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController$2;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputPrefectureController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputPrefectureController] ";
    public static final int RESUME_CMD_ENTER_PREFECTURE;
    public static final int FIRST_CMD_ENTER_PREFECTURE;
    public static final int FALLBACK_CMD_ENTER_PREFECTURE;
    public static final int CMD_DLG_PREFECTURE;
    public static final int CMD_DLG_STATE_AGAIN_PREFECTURE;

    public DestinationInputPrefectureController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141969: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_PREFECTURE.").toString());
                super.onRequestItems();
                break;
            }
            case 1077141970: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_STATE_AGAIN_PREFECTURE.").toString());
                this.checkEntryMode(true, 1091122176);
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
            case 1640018: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received RESUME_CMD_ENTER_PREFECTURE.").toString());
                this.checkEntryMode(false, 923350016);
                break;
            }
            case 1640019: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received FIRST_CMD_ENTER_PREFECTURE.").toString());
                this.checkEntryMode(false, 1107899392);
                break;
            }
            case 1640020: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received FALLBACK_CMD_ENTER_PREFECTURE.").toString());
                this.checkEntryMode(true, 1627993088);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterPrefecture() {
        Framework.fireEvent(1376131328);
    }

    public static void enterPrefectureFirst() {
        Framework.fireEvent(1392908544);
    }

    public static void enterPrefectureFallback() {
        Framework.fireEvent(1409685760);
    }

    private void checkEntryMode(boolean bl, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting entry mode").toString());
        boolean bl2 = false;
        if (bl && this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord() && this.destinationInputService.isPrefectureAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("fallback to multistep input because of too many failed attempts or enter again inside multistep").toString());
            this.onEnterPrefecture(n);
            bl2 = true;
        }
        if (!bl2) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot()) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("oneshot is possible, so start oneshot input").toString());
                DestinationInputOneShotJpnController.enterOneShot();
            } else if (this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord()) {
                if (this.destinationInputService.isPrefectureAvailable()) {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("start multistep prefecture input").toString());
                    this.onEnterPrefecture(n);
                } else {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("multistep prefecture input not possbible").toString());
                    this.onActionNotSupported();
                }
            } else {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("neither oneshot nor multistep supported").toString());
                Framework.fireUIEvent(-301452288);
            }
        }
    }

    private void onEnterPrefecture(int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to open speller for entering a prefecture").toString());
        this.destinationInputService.selectPrefectureInput(new DestinationInputPrefectureController$1(this, n));
    }

    public void onActionNotSupported() {
        Framework.fireUIEvent(1141453824);
    }

    void notifyEnterPrefectureSucceeded(INavigationLocation iNavigationLocation, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("entering a prefecture is possible now, stripped location will be forwarded to model").toString());
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(1074344960);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyItemSelected() {
        this.onPrefectureSelected();
    }

    private void onPrefectureSelected() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("a prefecture has been selected").toString());
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setPrefecture(new DestinationInputPrefectureController$2(this), viewModelItem);
    }

    void notifyPrefectureSelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(1124676608);
        super.notifyItemSelected();
        this.selectNextPossibleEntryMode();
    }

    public void selectNextPossibleEntryMode() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting next input step").toString());
        if (this.destinationInputService.isMunicipalityAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipalities available, so start municipality input").toString());
            DestinationInputMunicipalityController.enterMunicipality();
        } else if (this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipalities not available, but places available, so start place input").toString());
            DestinationInputPlaceController.enterPlace();
        } else if (this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipalities and places not available, but chomes available, so start chome input").toString());
            DestinationInputChomeController.enterChome();
        } else if (this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipalities, places and chomes not available, so start housenumber input to check housenumber availability").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }
}


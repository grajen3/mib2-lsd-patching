/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputMunicipalityController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputMunicipalityController] ";
    public static final int RESUME_CMD_ENTER_MUNICIPALITY;
    public static final int FIRST_CMD_ENTER_MUNICIPALITY;
    public static final int CMD_DLG_MUNICIPALITY;
    public static final int CMD_DLG_STATE_AGAIN_MUNICIPALITY;
    public static final int CMD_DLG_START_GUIDANCE_MUNICIPALITY;
    private static final int CONST_ENTRY_MODE_NORMAL;
    private static final int CONST_ENTRY_MODE_FIRST;

    public DestinationInputMunicipalityController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141971: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_MUNICIPALITY.").toString());
                super.onRequestItems();
                break;
            }
            case 1077141972: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_STATE_AGAIN_MUNICIPALITY.").toString());
                this.onEnterMunicipality(1175008256);
                break;
            }
            case 1077141998: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_START_GUIDANCE_MUNICIPALITY.").toString());
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
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
            case 1640021: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received RESUME_CMD_ENTER_MUNICIPALITY.").toString());
                this.checkEntryMode(0, 956904448);
                break;
            }
            case 1640022: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received FIRST_CMD_ENTER_MUNICIPALITY.").toString());
                this.checkEntryMode(1, 1191785472);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterMunicipality() {
        Framework.fireEvent(1426462976);
    }

    public static void enterMunicipalityFirst() {
        Framework.fireEvent(1443240192);
    }

    private void checkEntryMode(int n, int n2) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting entry mode").toString());
        if (!this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord()) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot()) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("fullword not possible but oneshot is, so start oneshot").toString());
                DestinationInputPrefectureController.enterPrefecture();
            } else {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("neither oneshot nor multistep supported").toString());
                Framework.fireUIEvent(-301452288);
            }
        } else if (!this.destinationInputService.isPrefectureSelected()) {
            if (this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot()) {
                DestinationInputPrefectureController.enterPrefecture();
            } else {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("no prefecture selected and no oneshot possible, so enter prefecture first as multistep").toString());
                DestinationInputPrefectureController.enterPrefectureFirst();
            }
        } else if (this.destinationInputService.isMunicipalityAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("prefecture set and municipalities available, so start municipality input").toString());
            this.onEnterMunicipality(n2);
        } else if (n == 1) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipality not available, entry with enter first, so enter prefecture first").toString());
            DestinationInputPrefectureController.enterPrefectureFirst();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipality not available, entry via command or as next input, so play error message and enter place").toString());
            this.onActionNotSupported();
            DestinationInputPlaceController.enterPlaceNext();
        }
    }

    private void onEnterMunicipality(int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to open speller for entering a municipality").toString());
        this.destinationInputService.selectMunicipalityInput(new DestinationInputMunicipalityController$1(this, n));
    }

    public void onActionNotSupported() {
        Framework.fireUIEvent(1644770304);
    }

    void notifyEnterMunicipalitySucceeded(INavigationLocation iNavigationLocation, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("entering a municipality is possible now, stripped location will be forwarded to model").toString());
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(1158231040);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyItemSelected() {
        this.onMunicipalitySelected();
    }

    private void onMunicipalitySelected() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("a municipality has been selected").toString());
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setMunicipality(this.createDestinationInputListener(), viewModelItem);
    }

    private DestinationInputListener createDestinationInputListener() {
        return new DestinationInputMunicipalityController$2(this);
    }

    void notifyMunicipalitySelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(1208562688);
        super.notifyItemSelected();
        this.selectNextPossibleEntryMode();
    }

    private void selectNextPossibleEntryMode() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting next input step").toString());
        if (this.destinationInputService.isWardAvailable() && !this.destinationInputService.isPlaceAvailable() && !this.destinationInputService.isChomeAvailable() && !this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("ward required and available, so start ward input").toString());
            DestinationInputWardController.enterWard();
        } else if (this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("places available, so start place input").toString());
            DestinationInputPlaceController.enterPlace();
        } else if (this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("places not available, but chomes available, so start chome input").toString());
            DestinationInputChomeController.enterChome();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("places and chomes not available, so start housenumber input to check housenumber availability").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }
}


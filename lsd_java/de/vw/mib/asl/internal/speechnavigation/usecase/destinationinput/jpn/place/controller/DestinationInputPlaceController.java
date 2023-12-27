/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputPlaceController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputPlaceController] ";
    public static final int RESUME_CMD_ENTER_PLACE;
    public static final int NEXT_CMD_ENTER_PLACE;
    public static final int FIRST_CMD_ENTER_PLACE;
    public static final int CMD_DLG_PLACE;
    public static final int CMD_DLG_STATE_AGAIN_PLACE;
    public static final int CMD_DLG_START_GUIDANCE_PLACE;
    private static final int CONST_ENTRY_MODE_NORMAL;
    private static final int CONST_ENTRY_MODE_FIRST;
    private static final int CONST_ENTRY_MODE_NEXT;

    public DestinationInputPlaceController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141975: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_PLACE.").toString());
                super.onRequestItems();
                break;
            }
            case 1077141976: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_STATE_AGAIN_PLACE.").toString());
                this.onEnterPlace(1309225984);
                break;
            }
            case 1077142000: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_START_GUIDANCE_PLACE.").toString());
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
            case 1640024: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received RESUME_CMD_ENTER_MUNICIPALITY.").toString());
                this.checkEntryMode(0, 1007236096);
                break;
            }
            case 1640025: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received NEXT_CMD_ENTER_PLACE.").toString());
                this.checkEntryMode(2, 1007236096);
                break;
            }
            case 1640026: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received FIRST_CMD_ENTER_PLACE.").toString());
                this.checkEntryMode(1, 1326003200);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterPlace() {
        Framework.fireEvent(1476794624);
    }

    public static void enterPlaceNext() {
        Framework.fireEvent(1493571840);
    }

    public static void enterPlaceFirst() {
        Framework.fireEvent(1510349056);
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
        } else if (!this.destinationInputService.isMunicipalitySelected() && n == 0) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("no municipality selected, so enter municipality first").toString());
            DestinationInputMunicipalityController.enterMunicipalityFirst();
        } else if (this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("municipality set and places available, so start place input").toString());
            this.onEnterPlace(n2);
        } else if (n == 1) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("place not available, entry with enter first, so enter municipality first").toString());
            DestinationInputMunicipalityController.enterMunicipalityFirst();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("place not available, entry via command or as next input, so play error message (if entered via command) and enter chome").toString());
            if (n != 2) {
                this.onActionNotSupported();
            }
            DestinationInputChomeController.enterChomeNext();
        }
    }

    private void onEnterPlace(int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to open speller for entering a place").toString());
        this.destinationInputService.selectPlaceInput(new DestinationInputPlaceController$1(this, n));
    }

    public void onActionNotSupported() {
        Framework.fireUIEvent(1661547520);
    }

    void notifyEnterPlaceSucceeded(INavigationLocation iNavigationLocation, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("entering a place is possible now, stripped location will be forwarded to model").toString());
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(1292448768);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyItemSelected() {
        this.onPlaceSelected();
    }

    private void onPlaceSelected() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("a place has been selected").toString());
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setPlace(new DestinationInputPlaceController$2(this), viewModelItem);
    }

    void notifyPlaceSelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(1342780416);
        super.notifyItemSelected();
        this.selectNextPossibleEntryMode();
    }

    public void selectNextPossibleEntryMode() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting next input step").toString());
        if (this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("chomes available, so start chome input").toString());
            DestinationInputChomeController.enterChome();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("no chomes available, so start housenumber input to check housenumber availability").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }
}


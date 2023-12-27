/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller;

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
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputChomeController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputChomeController] ";
    public static final int RESUME_CMD_ENTER_CHOME;
    public static final int NEXT_CMD_ENTER_CHOME;
    public static final int FIRST_CMD_ENTER_CHOME;
    public static final int CMD_DLG_CHOME;
    public static final int CMD_DLG_STATE_AGAIN_CHOME;
    public static final int CMD_DLG_START_GUIDANCE_CHOME;
    private static final int CONST_ENTRY_MODE_NORMAL;
    private static final int CONST_ENTRY_MODE_FIRST;
    private static final int CONST_ENTRY_MODE_NEXT;

    public DestinationInputChomeController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141977: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_CHOME.").toString());
                super.onRequestItems();
                break;
            }
            case 1077141978: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_STATE_AGAIN_CHOME.").toString());
                this.onEnterChome(1376334848);
                break;
            }
            case 1077142001: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_START_GUIDANCE_CHOME.").toString());
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
            case 1640027: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received RESUME_CMD_ENTER_CHOME.").toString());
                this.checkEntryMode(0, 1040790528);
                break;
            }
            case 1640028: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received NEXT_CMD_ENTER_CHOME.").toString());
                this.checkEntryMode(2, 1040790528);
                break;
            }
            case 1640029: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received FIRST_CMD_ENTER_CHOME.").toString());
                this.checkEntryMode(1, 1393112064);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterChome() {
        Framework.fireEvent(1527126272);
    }

    public static void enterChomeNext() {
        Framework.fireEvent(1543903488);
    }

    public static void enterChomeFirst() {
        Framework.fireEvent(1560680704);
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
        } else if (!(this.destinationInputService.isPlaceSelected() || n != 0 && n != 1)) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("no place selected, so enter place first").toString());
            DestinationInputPlaceController.enterPlaceFirst();
        } else if (this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("place set and chomes available, so start chome input").toString());
            this.onEnterChome(n2);
        } else if (n == 1) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("chome not available, entry with enter first, so enter place first").toString());
            DestinationInputPlaceController.enterPlaceFirst();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("chome not available, entry via command or as next input, so play error message (if entered via command) and enter housenumber").toString());
            if (n != 2) {
                this.onActionNotSupported();
            }
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }

    private void onEnterChome(int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to open speller for entering a chome").toString());
        this.destinationInputService.selectChomeInput(new DestinationInputChomeController$1(this, n));
    }

    public void onActionNotSupported() {
        Framework.fireUIEvent(1678324736);
    }

    void notifyEnterPlaceSucceeded(INavigationLocation iNavigationLocation, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("entering a chome is possible now, stripped location will be forwarded to model").toString());
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(1359557632);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyItemSelected() {
        this.onChomeSelected();
    }

    private void onChomeSelected() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("a chome has been selected").toString());
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setChome(new DestinationInputChomeController$2(this), viewModelItem);
    }

    void notifyChomeSelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(1409889280);
        super.notifyItemSelected();
        this.selectNextPossibleEntryMode();
    }

    public void selectNextPossibleEntryMode() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting next input step").toString());
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("start housenumber input to check if housenumber is available").toString());
        DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
    }
}


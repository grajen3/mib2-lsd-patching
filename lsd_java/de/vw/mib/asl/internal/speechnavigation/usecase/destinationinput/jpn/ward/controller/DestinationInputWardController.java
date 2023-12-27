/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller;

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
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController$2;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputWardController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputWardController] ";
    public static final int RESUME_CMD_ENTER_WARD;
    public static final int CMD_DLG_WARD;
    public static final int CMD_DLG_STATE_AGAIN_WARD;
    public static final int CMD_DLG_START_GUIDANCE_WARD;

    public DestinationInputWardController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141973: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_WARD.").toString());
                super.onRequestItems();
                break;
            }
            case 1077141974: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_STATE_AGAIN_WARD.").toString());
                this.onEnterWard(1242117120);
                break;
            }
            case 1077141999: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received CMD_DLG_START_GUIDANCE_WARD.").toString());
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
            case 1640023: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received RESUME_CMD_ENTER_WARD.").toString());
                this.onEnterWard(990458880);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterWard() {
        Framework.fireEvent(1460017408);
    }

    private void onEnterWard(int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("try to open speller for entering a ward").toString());
        this.destinationInputService.selectWardInput(new DestinationInputWardController$1(this, n));
    }

    void notifyEnterWardSucceeded(INavigationLocation iNavigationLocation, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("entering a ward is possible now, stripped location will be forwarded to model").toString());
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(1225339904);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyItemSelected() {
        this.onWardSelected();
    }

    private void onWardSelected() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("a ward has been selected").toString());
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setWard(new DestinationInputWardController$2(this), viewModelItem);
    }

    void notifyWardSelected(INavigationLocation iNavigationLocation) {
        this.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(1275671552);
        super.notifyItemSelected();
        this.selectNextPossibleEntryMode();
    }

    public void selectNextPossibleEntryMode() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("selecting next input step").toString());
        if (this.destinationInputService.isPlaceAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("places available, so start place input").toString());
            DestinationInputPlaceController.enterPlace();
        } else if (this.destinationInputService.isChomeAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("places not available, but chomes available, so start chome input").toString());
            DestinationInputChomeController.enterChome();
        } else if (this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("no places and chomes available, so start housenumber input to check housenumber availability").toString());
            DestinationInputHouseNumberControllerJPN.enterHouseNumberNext();
        }
    }
}


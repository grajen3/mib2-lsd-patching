/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputCrossingController
extends DestinationInputControllerBase
implements RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_CROSSING;
    public static final int ENTER_CROSSING_NO_HOUSENUMBER;
    public static final int CMD_DLG_CROSSING;
    public static final int CMD_DLG_START_GUIDANCE;
    private static final int CMD_DLG_ENTER_STREET;
    private static final int CMD_DLG_STATE_AGAIN_NBEST_CROSSING;
    private static boolean isEnteredViaOneshot;

    public DestinationInputCrossingController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141909: {
                super.onRequestItems();
                break;
            }
            case 1077141886: {
                DestinationInputStreetController.enterStreet();
                break;
            }
            case 1077141910: {
                this.onEnterCrossingAgain();
                break;
            }
            case 1077141914: {
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
            case 1640016: {
                this.checkEntryMode(-1173867520);
                break;
            }
            case 1640017: {
                this.checkEntryMode(-670551040);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    public static void enterCrossing() {
        isEnteredViaOneshot = false;
        Framework.fireEvent(1342576896);
    }

    public static void enterCrossingViaOneshot() {
        isEnteredViaOneshot = true;
        Framework.fireEvent(1342576896);
    }

    public static void enterCrossingNoHousenumber() {
        Framework.fireEvent(1359354112);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(-955763712);
    }

    @Override
    public void notifyItemSelected() {
        super.notifyItemSelected();
        this.onCrossingSelected();
    }

    private void onCrossingSelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        this.destinationInputService.setCrossing(new DestinationInputCrossingController$1(this), viewModelItem);
    }

    void notifyCrossingSelected() {
        super.notifyItemSelected();
        this.selectNextPossibleEntryMode();
    }

    private void onEnterCrossingAgain() {
        this.onEnterCrossing(-720882688);
    }

    private void onEnterCrossing(int n) {
        this.destinationInputService.selectCrossingInput(new DestinationInputCrossingController$2(this, n));
    }

    void notifyEnterCrossingSucceeded(INavigationLocation iNavigationLocation, int n) {
        super.updateLocation(iNavigationLocation);
        Framework.fireUIEvent(n);
    }

    private void checkEntryMode(int n) {
        if (this.variantService.isCHNVariant() || this.variantService.isTWNVariant()) {
            if (!isEnteredViaOneshot) {
                DestinationInputOneShotController.enterOneShot();
            } else if (!this.destinationInputService.isCrossingAvailable()) {
                if (!this.destinationInputService.isHouseNumberAvailable()) {
                    Framework.fireUIEvent(-83348480);
                } else {
                    Framework.fireUIEvent(-33016832);
                }
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
            } else {
                this.onEnterCrossing(n);
            }
        } else if (!this.destinationInputService.isCrossingAvailable() || !this.destinationInputService.isStreetSelected()) {
            DestinationInputStreetController.enterStreetFirst();
        } else if (!this.destinationInputService.isCrossingAvailable()) {
            if (!this.destinationInputService.isHouseNumberAvailable()) {
                Framework.fireUIEvent(-83348480);
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
            } else {
                Framework.fireUIEvent(-33016832);
                DestinationInputHouseNumberController.enterHouseNumber();
            }
        } else {
            this.onEnterCrossing(n);
        }
    }

    public void selectNextPossibleEntryMode() {
        if (this.destinationInputService.getCurrentInput().isValid()) {
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        } else {
            Framework.fireUIEvent(-1157090304);
        }
    }

    static {
        isEnteredViaOneshot = false;
    }
}


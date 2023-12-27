/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import generated.de.vw.mib.asl.internal.ListManager;

public class DestinationInputHouseNumberControllerJPN
extends DestinationInputHouseNumberController {
    public String logPrefix = "[SN][DestInputJPN][DestinationInputHouseNumberControllerJPN] ";
    private static boolean enteredAsNext = false;

    public DestinationInputHouseNumberControllerJPN(HouseNumberDataService houseNumberDataService, ResultItemRowNumberHandler resultItemRowNumberHandler, ResultItemHandler resultItemHandler) {
        super(houseNumberDataService, resultItemRowNumberHandler, resultItemHandler);
    }

    public static void enterHouseNumber() {
        enteredViaOneshot = false;
        enteredAsNext = false;
        Framework.fireEvent(1309022464);
    }

    public static void enterHouseNumberNext() {
        enteredViaOneshot = false;
        enteredAsNext = true;
        Framework.fireEvent(1309022464);
    }

    public static void enterHouseNumberOneShot(HouseNumber houseNumber) {
        enteredViaOneshot = true;
        enteredAsNext = false;
        Framework.fireEvent(1862670592, houseNumber);
    }

    @Override
    public void notifyItemsRequested() {
        if (this.destinationInputService.arePointLocationHouseNumbersAvailable()) {
            if (this.service.isHousenumberNone() && this.service.getAvailableItemsCount() == 0) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [pointlocation_hn_input, hn_none] ").toString());
                Framework.fireUIEvent(1695101952);
            } else if (this.service.isHousenumberUnique() && this.service.getAvailableItemsCount() == 1) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [pointlocation_hn_input, hn_unique_match] ").toString());
                HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
                houseNumber.objectId = "";
                this.selectHousenumber(houseNumber);
            } else if (this.service.isHousenumberAlternatives() && this.service.getAvailableItemsCount() == 1) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [pointlocation_hn_input, hn_nearest_alternative] ").toString());
                Framework.fireUIEvent(1695101952);
            } else if (this.service.isHousenumberMatchesFound() && this.service.getAvailableItemsCount() > 1) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [pointlocation_hn_input, hn_multiple] ").toString());
                HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
                if (houseNumber != null) {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append(" use the first housenumber out of several possible housenumbers").toString());
                    houseNumber.objectId = "";
                    this.selectHousenumber(houseNumber);
                } else {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append(" an error occured during point location housenumber selection").toString());
                    Framework.fireUIEvent(1695101952);
                }
            }
        } else if (this.service.isHousenumberUnique()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [standard_hn_input, hn_unique] ").toString());
            HouseNumber houseNumber = (HouseNumber)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[0];
            ListManager.getASLList(this.getListIdSelectedItem()).updateList(new HouseNumber[]{houseNumber});
            this.onHouseNumberSelected();
        } else if (this.service.isHousenumberAlternatives()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [standard_hn_input, hn_nearest_alternative] ").toString());
            Framework.fireUIEvent(1695101952);
        } else if (this.service.isHousenumberNone()) {
            AppLogger.error(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [standard_hn_input, hn_none] ").toString());
            Framework.fireUIEvent(1695101952);
        } else {
            AppLogger.error(new StringBuffer().append(this.logPrefix).append(".notifyItemsRequested(), handle [standard_hn_input, hn_multiple] incompatible").toString());
            this.onActionFailed();
        }
    }

    @Override
    protected void checkEntryMode() {
        if (!(enteredAsNext || this.destinationInputService.isChomeSelected() || this.destinationInputService.isHouseNumberBySds())) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Housenumber should be entered in multistep but no chome entered, so enter chome first.").toString());
            DestinationInputChomeController.enterChomeFirst();
        } else if (!this.destinationInputService.isHouseNumberAvailable()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No housenumbers available.").toString());
            Framework.fireUIEvent(1594438656);
            DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
        } else {
            this.onEnteringHouseNumber(-1207421952);
        }
    }

    private void selectHousenumber(HouseNumber houseNumber) {
        ListManager.getASLList(this.getListIdSelectedItem()).updateList(new HouseNumber[]{houseNumber});
        this.onHouseNumberSelected();
    }
}


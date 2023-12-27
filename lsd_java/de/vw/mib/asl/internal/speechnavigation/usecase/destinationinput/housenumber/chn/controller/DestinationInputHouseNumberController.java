/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.chn.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;

public class DestinationInputHouseNumberController
extends de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController {
    public DestinationInputHouseNumberController(HouseNumberDataService houseNumberDataService, ResultItemRowNumberHandler resultItemRowNumberHandler, ResultItemHandler resultItemHandler) {
        super(houseNumberDataService, resultItemRowNumberHandler, resultItemHandler);
    }

    @Override
    protected void checkEntryMode() {
        DestinationInputOneShotController.enterOneShot();
    }
}


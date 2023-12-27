/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationNBestListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class LastDestinationNBestListController
extends ApplicationNBestListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int CMD_LAST_DESTINATION_X;

    public LastDestinationNBestListController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public int getListIdTopLevel() {
        return 1393046528;
    }

    @Override
    public int getListIdDetailLevel() {
        return 1409823744;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1426600960;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            default: 
        }
        super.onEvent(eventGeneric);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141830: {
                super.onRequestItems();
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(1846031360);
    }

    @Override
    public void notifyItemsRequested() {
        this.showDestinationAddressDetails();
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects().length) {
            LastDestination lastDestination = (LastDestination)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            Framework.updateUIValue(1594373120, lastDestination.title);
        }
        super.notifyGroupExpanded(n);
    }

    @Override
    public void notifyItemSelected() {
        LastDestination lastDestination = (LastDestination)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, lastDestination.title);
        super.notifyItemSelected();
        LastDestinationMainController.startGuidanceBy(lastDestination);
    }

    private void showDestinationAddressDetails() {
        LastDestination lastDestination = (LastDestination)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, lastDestination.title);
        LastDestinationDetailController.showDestinationAddressDetails(lastDestination);
    }
}


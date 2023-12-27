/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class LastDestinationListController
extends ApplicationListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int RESUME_CMD_LAST_DESTINATIONS;
    public static final int CMD_DLG_GO_BACK;
    public static final int CMD_DLG_SELECT_LASTDESTINATION;
    public static final int CMD_DLG_STATE_AGAIN_NBEST_LASTDEST;
    private int notificationListUpdateEvent = 1812476928;

    public LastDestinationListController(DataService dataService, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(dataService, resultItemRowNumberHandler);
    }

    @Override
    public int getListIdTopLevel() {
        return 1393046528;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1426600960;
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141831: 
            case 1077141851: {
                this.requestListAgain();
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
            case 1077141851: {
                this.requestListAgain();
                break;
            }
            case 1077141829: {
                this.requestList();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void notifyItemsRequested() {
        if (ListManager.getGenericASLList(this.getListIdTopLevel()).getItemCount() == 0) {
            Framework.fireUIEvent(1795699712);
        } else {
            Framework.fireUIEvent(this.notificationListUpdateEvent);
        }
    }

    @Override
    public void notifyItemSelected() {
        LastDestination lastDestination = (LastDestination)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, lastDestination.title);
        super.notifyItemSelected();
        LastDestinationMainController.startGuidanceBy(lastDestination);
    }

    private void requestListAgain() {
        this.notificationListUpdateEvent = 1879585792;
        super.onRequestItems();
    }

    private void requestList() {
        this.notificationListUpdateEvent = 1812476928;
        super.onRequestItems();
    }
}


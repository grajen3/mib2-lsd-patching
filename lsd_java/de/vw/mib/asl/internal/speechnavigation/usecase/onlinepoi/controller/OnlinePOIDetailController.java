/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceCheckStopoverController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model.OnlinePOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIDetailUpdateListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIHandler;
import de.vw.mib.genericevents.EventGeneric;

public class OnlinePOIDetailController
extends DestinationDetailController
implements RecognizedEventConsumer,
ModelEventConsumer,
OnlinePOIDetailUpdateListener {
    private String logPrefix = "[SN][OnlinePOI][OnlinePOIDetailController] ";
    public static final int ONLINE_POI_SEARCH_SHOW_DETAIL;
    public static final int ONLINE_POI_SEARCH_SHOW_DETAIL_SINGLE;
    public static final int BACK_TO_DETAIL;
    private final OnlinePOIHandler service;
    private int nextSuccessNotification;
    private int backNotification;

    public OnlinePOIDetailController(OnlinePOIHandler onlinePOIHandler) {
        this.service = onlinePOIHandler;
        onlinePOIHandler.registerListener(this);
    }

    public int getListIdTopLevel() {
        return 2114466816;
    }

    public int getListIdSelectedItem() {
        return 2131244032;
    }

    private void setSelectedItemInModel(OnlinePOI onlinePOI) {
        Object[] objectArray = new OnlinePOI[]{onlinePOI};
        Framework.getListManager().getGenericASLList(this.getListIdSelectedItem()).updateList(objectArray);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640056: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Showing online POI detail from a result with several items.").toString());
                OnlinePOI onlinePOI = (OnlinePOI)Framework.getListManager().getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
                this.service.selectItem(onlinePOI);
                this.backNotification = this.nextSuccessNotification = 403256320;
                this.service.resolveSelectedItem();
                break;
            }
            case 1640057: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Showing online POI detail from a result with only one item.").toString());
                this.service.selectFirstItem();
                this.backNotification = this.nextSuccessNotification = 386479104;
                this.service.resolveSelectedItem();
                break;
            }
            case 1077141943: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Entering online POI search result detail via back command.").toString());
                Framework.fireUIEvent(this.backNotification);
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141838: 
            case 1077141840: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Start guidance to online POI.").toString());
                this.onConfirmStartGuidanceCommand();
                break;
            }
            case 1077141839: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Don't start guidance to online POI.").toString());
                this.onAbortStartGuidanceCommand();
                break;
            }
            case 1077141940: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Showing next online POI from result list.").toString());
                OnlinePOI onlinePOI = this.service.selectNext();
                if (onlinePOI != null) {
                    this.nextSuccessNotification = 453587968;
                    this.service.resolveSelectedItem();
                    break;
                }
                Framework.fireUIEvent(470365184);
                break;
            }
            case 1077141939: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Showing previous online POI from result list.").toString());
                OnlinePOI onlinePOI = this.service.selectPrev();
                if (onlinePOI != null) {
                    this.nextSuccessNotification = 420033536;
                    this.service.resolveSelectedItem();
                    break;
                }
                Framework.fireUIEvent(436810752);
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(2064135168);
    }

    private void onAbortStartGuidanceCommand() {
        Framework.fireUIEvent(1963471872);
    }

    private void onConfirmStartGuidanceCommand() {
        StartGuidanceCheckStopoverController.startGuidance(this.destinationDetail);
    }

    @Override
    public void onDetailsComplete(INavigationLocation iNavigationLocation) {
        this.setSelectedItemInModel(this.service.getSelectedItem());
        this.showDestinationAddressDetails(iNavigationLocation, this.nextSuccessNotification);
    }
}


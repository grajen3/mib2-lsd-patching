/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model.OnlinePOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIListUpdateListener;
import de.vw.mib.genericevents.EventGeneric;

public class OnlinePOIListController
extends ResultListControllerBase
implements ApplicationErrorHandler,
RecognizedEventConsumer,
ModelEventConsumer,
OnlinePOIListUpdateListener {
    private String logPrefix = "[SN][OnlinePOI][OnlinePOIListController] ";
    public static final int RESUME_CMD_ENTER_POI_ONLINE_X;
    public static final int START_SEARCHING_PLAYED;
    public static final int NEXT_PAGE_FAILED;
    public static final int BACK_TO_LIST;
    private final OnlinePOIHandler service;

    public OnlinePOIListController(OnlinePOIHandler onlinePOIHandler, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(onlinePOIHandler, resultItemRowNumberHandler, Framework.getListManager());
        this.service = onlinePOIHandler;
        this.service.registerListener(this);
    }

    @Override
    public int getListIdTopLevel() {
        return 2114466816;
    }

    @Override
    public int getListIdSelectedItem() {
        return 2131244032;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640055: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Starting online POI search direct recognition.").toString());
                this.onStartSearching();
                break;
            }
            case 1077141941: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Start searching prompt has been played, continue search.").toString());
                super.onRequestItems();
                break;
            }
            case 1077141944: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Next page failed.").toString());
                this.onNextPageFailed();
                break;
            }
            case 1077141942: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI search list has been entered via back command.").toString());
                this.onEnterTheList();
                break;
            }
            case 1077141824: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Selecting online POI search result.").toString());
                int n2 = eventGeneric.getInt(0);
                super.onSelectItem(n2);
                break;
            }
            default: {
                AppLogger.warn(new StringBuffer().append(this.logPrefix).append("received but discarded generic event with id ").append(n).append(".").toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141848: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Selecting online POI search result by row number.").toString());
                super.onRecognizeRowNumber();
                break;
            }
            case 1077141842: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Selecting online POI search result next page.").toString());
                Framework.fireUIEvent(1896363008);
                break;
            }
            case 1077141849: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Selecting online POI search result previous page.").toString());
                Framework.fireUIEvent(1913140224);
                break;
            }
            case 1077141844: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Selecting online POI search result first page.").toString());
                Framework.fireUIEvent(1929917440);
                break;
            }
            case 1077141845: {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Selecting online POI search result last page.").toString());
                Framework.fireUIEvent(1946694656);
                break;
            }
            default: {
                AppLogger.warn(new StringBuffer().append(this.logPrefix).append("received but discarded recognized event with id ").append(n).append(".").toString());
            }
        }
    }

    private void onStartSearching() {
        GenericASLList genericASLList = Framework.getListManager().getGenericASLList(this.getListIdTopLevel());
        genericASLList.clear();
        Framework.fireUIEvent(503919616);
    }

    private void onEnterTheList() {
        Framework.fireUIEvent(352924672);
    }

    private void onNextPageFailed() {
        if (this.service.hasMorePOIs()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Next page failed but there are further results, so retrieve further entries.").toString());
            Framework.fireUIEvent(369701888);
            this.service.retrieveMoreEntries();
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Next page failed and there are no further results, so inform model.").toString());
            Framework.fireUIEvent(671691776);
        }
    }

    @Override
    public void notifyItemsRequested() {
        if (this.service.isUniqueResult()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Search result is unique result, open details directly.").toString());
            Framework.fireEvent(2030442752);
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Search result is not unique, enter the list.").toString());
            this.onEnterTheList();
        }
    }

    @Override
    public void notifyItemSelected() {
        Framework.fireEvent(2013665536);
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        Framework.updateUIValue(1577595904, n);
        Framework.updateUIValue(1376269312, n - 1);
    }

    @Override
    public void onNewDataReceived(OnlinePOI[] onlinePOIArray) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Receiving further results, filling them into the list.").toString());
        GenericASLList genericASLList = Framework.getListManager().getGenericASLList(this.getListIdTopLevel());
        genericASLList.updateList(onlinePOIArray);
        this.onNextPageFilled();
    }

    private void onNextPageFilled() {
        Framework.fireUIEvent(1896363008);
    }

    @Override
    public void onError(int n) {
        if (this.service.isUseCaseActive()) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Forwarding error to model.").toString());
            if (n == 2) {
                this.onNoResult();
            } else if (n == 3) {
                this.onNoKeyword();
            } else if (n == 4) {
                this.onNoLanguageSupport();
            } else if (n == 5) {
                this.onNoFurtherResults();
            } else if (n == 1) {
                this.onNoResponse();
            } else {
                this.onActionFailed();
            }
        }
    }

    private void onNoResult() {
        Framework.fireUIEvent(285815808);
    }

    private void onNoKeyword() {
        Framework.fireUIEvent(302593024);
    }

    private void onNoLanguageSupport() {
        Framework.fireUIEvent(336147456);
    }

    private void onNoFurtherResults() {
        Framework.fireUIEvent(269038592);
    }

    private void onNoResponse() {
        Framework.fireUIEvent(319370240);
    }

    @Override
    public void onActionNotAvailable() {
    }

    @Override
    public void onActionFailed() {
        Framework.fireUIEvent(2097689600);
    }
}


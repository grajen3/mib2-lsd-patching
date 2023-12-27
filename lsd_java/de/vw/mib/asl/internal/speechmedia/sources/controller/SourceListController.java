/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.global.SelectSourceAction;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.controller.SourceListObserver;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SourceListController$1;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.genericevents.EventGeneric;

public class SourceListController
extends ResultListControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[SpeechMediaStartTarget] ");
    public static final int CMD_SELECT_SOURCE;
    public static final int CDM_SELECT_ITEM_RELATIVE;
    public static final int SOURCE_LIST_ENTERED;
    public static final int SOURCE_LIST_LEFT;
    public static final int SELECT_ITEM_BY_OBJECT_ID;
    public static final int SELECT_ITEM_BY_OBJECT_ID__P0_OBJECTID__LONG;
    protected SelectSourceAction selectSourcePrecondition;
    protected final MediaServiceController msController;
    private SourceListObserver sourceListObserver = new SourceListController$1(this);

    public SourceListController(MediaServiceController mediaServiceController, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        super(mediaServiceController.getSourceListService(), resultItemRowNumberHandler, mediaServiceController.getSpeechMediaServiceManager().getAslListManager());
        this.msController = mediaServiceController;
        this.selectSourcePrecondition = new SelectSourceAction(mediaServiceController);
    }

    @Override
    public int getListIdTopLevel() {
        return -1300155904;
    }

    @Override
    public int getListIdSelectedItem() {
        return -1300155904;
    }

    @Override
    public void notifyItemsRequested() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1165938176);
    }

    @Override
    public void notifyItemSelected() {
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("notifyRowNumberRecognized() rowNumber: ").append(n).toString());
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1216269824, n);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1031720448);
    }

    private void selectItemBySourceId(long l) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("selectItemByObectId(), sourceId: ").append(l).log();
        }
        this.msController.activateSource((int)l);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077041830: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_SELECT_SOURCE recognized.");
                }
                if (!this.selectSourcePrecondition.executeAction(4)) break;
                this.registerObserver();
                super.onRequestItems();
                break;
            }
            case 1077041837: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CDM_SELECT_ITEM_RELATIVE recognized.");
                }
                super.onRecognizeRowNumber();
                break;
            }
        }
    }

    private void registerObserver() {
        this.msController.setSourceListObserver(this.sourceListObserver);
    }

    private void unregisterObserver() {
        this.msController.setSourceListObserver(null);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077041839: {
                long l = eventGeneric.getLong(0);
                this.selectItemBySourceId(l);
                break;
            }
            case 1077041853: {
                this.registerObserver();
                break;
            }
            case 1077041852: {
                this.unregisterObserver();
                break;
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.global.SelectMusicPrecondition;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.sources.util.SourceUtil;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController$1;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController$2;
import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.genericevents.EventGeneric;

public abstract class AbstractMusicListController
extends ResultListNBestControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[TitleListController] ");
    public static final int CMD_SELECT_ITEM_RELATIVE;
    public static final int CMD_SELECT_BY_NAME;
    public static final int CMD_YES;
    public static final int CMD_NO;
    public static final int CMD_STATE_AGAIN;
    public static final int CMD_NBEST_RECOGNITION;
    public static final int ACTIVATION_FINISHED;
    public static final int SELECT_ITEM_BY_INDEX;
    public static final int SELECT_SUBITEM_BY_INDEX;
    public static final int SYSTEM_SELECTED_PARROT;
    public static final int SYSTEM_SUCCESS;
    public static final int SYSTEM_SHOW_NBEST;
    public static final int SYSTEM_SELECT_TRACK;
    public static final int SYSTEM_SELECT_TITLE;
    public static final int SYSTEM_ERROR_NO_DB_HANDLING;
    public static final int SYSTEM_ERROR_DB_TOO_LARGE;
    public static final int SYSTEM_ERROR_GRAMMAR;
    public static final int SYSTEM_ERROR_CANNOT_PLAY;
    public static final int SYSTEM_GROUP_CLOSED;
    public static final int SYSTEM_GROUP_OPENED;
    public static final int SYSTEM_NO;
    public static final int SYSTEM_STATE_AGAIN;
    public static final int DATAPOOL_RECOGNIZED_GROUP_NAME;
    public static final int DATAPOOL_GROUP_INDEX;
    public static final int DATAPOOL_USECASE;
    protected final MediaServiceController msController;
    private Callback onSelectUseCaseCallback = new AbstractMusicListController$2(this);

    public AbstractMusicListController(AdditionalDataService additionalDataService, MediaServiceController mediaServiceController, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler, mediaServiceController.getSpeechMediaServiceManager().getAslListManager());
        this.msController = mediaServiceController;
    }

    public abstract int getUseCase() {
    }

    public abstract int getMainCommand() {
    }

    public abstract SelectMusicPrecondition getPrecondition() {
    }

    @Override
    public int getListIdDetailLevel() {
        return -914279936;
    }

    @Override
    public int getListIdTopLevel() {
        return -998166016;
    }

    @Override
    public int getListIdSelectedItem() {
        return -897502720;
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-880725504);
    }

    @Override
    public void notifyGroupExpanded(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(-964611584, n);
        TitleModel titleModel = this.getTitle(n);
        if (titleModel != null) {
            AbstractASLHsmTarget.writeStringToDatapool(-931057152, titleModel.titleName);
        } else {
            AbstractASLHsmTarget.writeStringToDatapool(-931057152, "");
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-729730560);
    }

    @Override
    public void notifyGroupCollapsed(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(-964611584, -1);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-712953344);
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    @Override
    public void notifyItemSelected() {
        TitleModel titleModel = this.getSelectedTitle();
        if (titleModel == null) {
            this.logger.error("Selected title is null");
            this.msController.doFatalError();
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("item selected: ").append(titleModel.toString()).log();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-863948288);
        MediaEntry mediaEntry = titleModel.mediaEntry;
        if (mediaEntry == null || mediaEntry.getFileState() != 0) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-746507776);
            return;
        }
        this.msController.play(mediaEntry, new AbstractMusicListController$1(this));
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("notifyRowNumberRecognized() rowNumber: ").append(n).toString());
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1216269824, n);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1031720448);
    }

    private TitleModel getSelectedTitle() {
        return this.getGenericTitle(0, -897502720);
    }

    private TitleModel getTitle(int n) {
        return this.getGenericTitle(n, -998166016);
    }

    private TitleModel getGenericTitle(int n, int n2) {
        Object[] objectArray = this.msController.getSpeechMediaServiceManager().getAslListManager().getGenericASLList(n2).getDSIObjects();
        if (objectArray == null || n < 0 || n >= objectArray.length) {
            return null;
        }
        Object object = objectArray[n];
        if (object instanceof TitleModel) {
            return (TitleModel)object;
        }
        return null;
    }

    protected void executeMainUseCase() {
        if (this.executePreconditions()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Media source all preconditions successfull. Notify media.");
            }
            this.msController.browseCurrentSource(this.getUseCase(), this.onSelectUseCaseCallback);
        }
    }

    protected boolean executePreconditions() {
        AbstractASLHsmTarget.writeIntegerToDatapool(-880725504, this.getUseCase());
        Source source = this.msController.getCurrentMediaSource();
        if (!source.isPlayable()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Current Source is not playable. Play error prompt.");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-796839424);
            return false;
        }
        if (this.getUseCase() == 0 && SourceUtil.isOptical(source.getSourceId())) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Title selection for CD, does not need preconditions.");
            }
            return true;
        }
        if (source.getContentBrowsingAvailable() == 1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Media source does not support browsing.");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-796839424);
            return false;
        }
        int n = this.msController.getUseCaseSlotState(this.getUseCase());
        if (source.getContentBrowsingAvailable() == 2 || n == 3 || n == 2) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Media source is still synching db or grammar is compiling.");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-763284992);
            return false;
        }
        if (n == 5) {
            if (this.msController.exceedsMaxTitles()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Media source containst too many DB entries.");
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-780062208);
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Media source grammar compilation failed.");
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-763284992);
            }
            return false;
        }
        return true;
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == this.getMainCommand()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("CMD_SELECT_MUSIC recognized. Execute precondition.");
            }
            if (this.getPrecondition().executeAction(this.getUseCase())) {
                this.executeMainUseCase();
            }
            return;
        }
        switch (n) {
            case 1077041848: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_SELECT_BY_NAME recognized.");
                }
                super.onRequestItems();
                break;
            }
            case 1077041837: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_SELECT_ITEM_RELATIVE recognized.");
                }
                super.onRecognizeRowNumber();
                break;
            }
            case 1077041864: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_NBEST_RECOGNITION recognized.");
                }
                super.onSelectItem();
                break;
            }
            case 1077041858: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_YES recognized.");
                }
                super.onSelectItem(0);
                break;
            }
            case 1077041859: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_NO recognized.");
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-629067264);
                break;
            }
            case 1077041854: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("CMD_STATE_AGAIN recognized.");
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-696176128);
                break;
            }
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        int n2 = 0;
        switch (n) {
            case 1077041835: {
                this.executeMainUseCase();
                break;
            }
            case 1077041850: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("SELECT_ITEM_BY_INDEX event.");
                }
                n2 = eventGeneric.getInt(0);
                this.onSelectItem(n2);
                break;
            }
            case 1077041851: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("SELECT_SUBITEM_BY_INDEX event.");
                }
                n2 = eventGeneric.getInt(0);
                this.onSelectSubItem(n2);
                break;
            }
        }
    }
}


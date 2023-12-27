/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.GenericAction;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.SelectTrackAction$1;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;

public class SelectTrackAction
extends GenericAction {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[SelectTrackAction] ");
    public static final int DOWN_EVENT;
    public static final int SELECTED;
    public static final int SUCCESS;
    public static final int ERROR_EVENT;
    public static final int DATAPOOL;
    protected final MediaServiceController msContr;
    protected final ResultItemHandler resultHandler;

    public SelectTrackAction(MediaServiceController mediaServiceController, ResultHandler resultHandler) {
        super(-830393856, -1185271232);
        this.msContr = mediaServiceController;
        this.resultHandler = resultHandler.getResultItemHandler();
    }

    @Override
    protected void onAction() {
        int n = this.getTrackNumber();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Recognized SELECT_TRACK command. TrackNr: ").append(n).log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1031720448, n);
        if (n > this.msContr.getCurrentItemCount()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("ERROR playing track. CD contains ").append(this.msContr.getCurrentItemCount()).append(" tracks.").log();
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-847171072);
            return;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-830393856);
        this.msContr.playTrack(n - 1, new SelectTrackAction$1(this));
    }

    private int getTrackNumber() {
        ResultItem resultItem = this.resultHandler.getResultItem();
        return resultItem.getIdentifier().getObjectIndex() + 1;
    }
}


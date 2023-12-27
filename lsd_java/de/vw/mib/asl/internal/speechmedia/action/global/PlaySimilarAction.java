/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.global.GenericGlobalAction;
import de.vw.mib.asl.internal.speechmedia.action.global.PlaySimilarAction$1;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;

public class PlaySimilarAction
extends GenericGlobalAction {
    public static final int SYSTEM_REQUIRES_ACTIVE_MEDIA;
    public static final int SYSTEM_NOT_SUPPORTED;
    public static final int SYSTEM_SYNCHING;
    public static final int SYSTEM_STARTED;
    public static final int SYSTEM_SUCCESS;
    public static final int DP_COUNT;

    public PlaySimilarAction(MediaServiceController mediaServiceController) {
        super(mediaServiceController);
    }

    @Override
    public int getDownEvent() {
        return -950390208;
    }

    @Override
    protected int getSuccessEvent() {
        return -561958400;
    }

    @Override
    protected int getDatapoolValue() {
        return 9;
    }

    @Override
    protected boolean doSourceCheck() {
        return false;
    }

    @Override
    protected boolean doSuccess() {
        return false;
    }

    @Override
    public boolean executeAction(int n) {
        if (!super.executeAction(n)) {
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("PLAY_SIMILAR command recognized.");
        }
        if (!this.msController.isActive() || !this.msController.getCurrentMediaSource().isPlaying()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-545181184);
            return false;
        }
        if (this.msController.getCurrentMediaSource().getPlaySimilarAvailable() == 1) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-528403968);
            return false;
        }
        if (this.msController.getCurrentMediaSource().getPlaySimilarAvailable() == 2 || !this.msController.isPlaySimilarAvailable()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-461295104);
            return false;
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-578735616);
        this.msController.playSimilar(new PlaySimilarAction$1(this));
        return true;
    }
}


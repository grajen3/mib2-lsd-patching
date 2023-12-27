/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.sources.util.SourceUtil;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController;

class AbstractMusicListController$2
implements Callback {
    private final /* synthetic */ AbstractMusicListController this$0;

    AbstractMusicListController$2(AbstractMusicListController abstractMusicListController) {
        this.this$0 = abstractMusicListController;
    }

    @Override
    public void response(ResultCode resultCode) {
        if (resultCode == ResultCode.NOK) {
            this.this$0.logger.warn("Media is not ready for selection. ResultCode.NOK");
            this.this$0.msController.doFatalError();
            return;
        }
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Media ready for selection");
        }
        Source source = this.this$0.msController.getCurrentMediaSource();
        if (this.this$0.getUseCase() == 0 && SourceUtil.isOptical(source.getSourceId())) {
            AbstractASLHsmTarget.writeIntegerToDatapool(-880725504, 4);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-813616640);
            return;
        }
        if (this.this$0.executePreconditions()) {
            if (this.this$0.logger.isTraceEnabled()) {
                this.this$0.logger.trace("Music selection, all preconditions successfull. Show view.");
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-998166016);
        }
    }
}


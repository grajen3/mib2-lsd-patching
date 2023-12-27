/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController;

class AbstractMusicListController$1
implements Callback {
    private final /* synthetic */ AbstractMusicListController this$0;

    AbstractMusicListController$1(AbstractMusicListController abstractMusicListController) {
        this.this$0 = abstractMusicListController;
    }

    @Override
    public void response(ResultCode resultCode) {
        if (resultCode == ResultCode.NOK) {
            this.this$0.logger.warn("Media could not play items. ResultCode.NOK");
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-746507776);
        } else {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-595512832);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechmedia.action.global.SelectMusicPrecondition;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController;
import de.vw.mib.asl.internal.speechmedia.titles.service.TitleDataService;

public class TitleListController
extends AbstractMusicListController {
    public static final int CMD_SELECT_TITLE;
    public static final int CMD_TITLE_BY_NAME;
    private SelectMusicPrecondition selectTitlePrecondition;

    public TitleListController(MediaServiceController mediaServiceController, ResultListHandler resultListHandler) {
        super((AdditionalDataService)new TitleDataService(mediaServiceController), mediaServiceController, resultListHandler);
        this.selectTitlePrecondition = new SelectMusicPrecondition(this.msController, 7);
    }

    @Override
    public int getUseCase() {
        return 0;
    }

    @Override
    public int getMainCommand() {
        return -1403375040;
    }

    @Override
    public SelectMusicPrecondition getPrecondition() {
        return this.selectTitlePrecondition;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechmedia.action.global.SelectMusicPrecondition;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController;
import de.vw.mib.asl.internal.speechmedia.titles.service.GenreDataService;

public class GenreListController
extends AbstractMusicListController {
    public static final int CMD_SELECT_GENRE;
    private SelectMusicPrecondition selectGenrePrecondition;

    public GenreListController(MediaServiceController mediaServiceController, ResultListHandler resultListHandler) {
        super((AdditionalDataService)new GenreDataService(mediaServiceController), mediaServiceController, resultListHandler);
        this.selectGenrePrecondition = new SelectMusicPrecondition(this.msController, 8);
    }

    @Override
    public int getUseCase() {
        return 3;
    }

    @Override
    public int getMainCommand() {
        return -967167424;
    }

    @Override
    public SelectMusicPrecondition getPrecondition() {
        return this.selectGenrePrecondition;
    }
}


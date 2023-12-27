/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechmedia.action.global.SelectMusicPrecondition;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController;
import de.vw.mib.asl.internal.speechmedia.titles.service.AlbumDataService;

public class AlbumListController
extends AbstractMusicListController {
    public static final int CMD_SELECT_ALBUM;
    private SelectMusicPrecondition selectAlbumPrecondition;

    public AlbumListController(MediaServiceController mediaServiceController, ResultListHandler resultListHandler) {
        super((AdditionalDataService)new AlbumDataService(mediaServiceController), mediaServiceController, resultListHandler);
        this.selectAlbumPrecondition = new SelectMusicPrecondition(this.msController, 5);
    }

    @Override
    public int getUseCase() {
        return 1;
    }

    @Override
    public int getMainCommand() {
        return -1000721856;
    }

    @Override
    public SelectMusicPrecondition getPrecondition() {
        return this.selectAlbumPrecondition;
    }
}


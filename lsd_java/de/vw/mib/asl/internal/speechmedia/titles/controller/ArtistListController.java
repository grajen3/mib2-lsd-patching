/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechmedia.action.global.SelectMusicPrecondition;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AbstractMusicListController;
import de.vw.mib.asl.internal.speechmedia.titles.service.ArtistDataService;

public class ArtistListController
extends AbstractMusicListController {
    public static final int CMD_SELECT_ARTIST;
    private SelectMusicPrecondition selectArtistPrecondition;

    public ArtistListController(MediaServiceController mediaServiceController, ResultListHandler resultListHandler) {
        super((AdditionalDataService)new ArtistDataService(mediaServiceController), mediaServiceController, resultListHandler);
        this.selectArtistPrecondition = new SelectMusicPrecondition(this.msController, 6);
    }

    @Override
    public int getUseCase() {
        return 2;
    }

    @Override
    public int getMainCommand() {
        return -983944640;
    }

    @Override
    public SelectMusicPrecondition getPrecondition() {
        return this.selectArtistPrecondition;
    }
}

